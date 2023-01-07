package com.cristian.design.patterns;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;

public class EventManager implements ThreadCompleteListener {

  public static final int MAX_RUNNING_EVENTS = 100;

  public static final int MIN_ID = 1;

  public static final int MAX_ID = MAX_RUNNING_EVENTS;

  public static final int MAX_EVENT_TIME_IN_SECONDS = 1800;

  private final SecureRandom random;

  @Getter
  private final Map<Integer, Event> eventPool;

  @Getter
  private int currentlyRunningSyncEvent = -1;

  public EventManager() {
    this.random = new SecureRandom();
    this.eventPool = new ConcurrentHashMap<>(MAX_RUNNING_EVENTS);
  }

  /**
   * Create a Synchronous event.
   *
   * @param eventTime Time an event should run far.
   * @throws MaxNumOfEventsAllowedException When too many events are running at a time.
   * @throws InvalidOperationException No new synchronous events can be created when one is already running.
   * @throws LongRunningEventException Long-running events are nut allowed in the app.
   */
  public int createSyncEvent(final int eventTime)
      throws MaxNumOfEventsAllowedException, InvalidOperationException, LongRunningEventException {
    if (this.currentlyRunningSyncEvent != -1) {
      final String msg =
          String.format("Event [%s] is still running. Please wait until it finishes and try again.", this.currentlyRunningSyncEvent);
      throw new InvalidOperationException(msg);
    }

    final int eventId = createEvent(eventTime, true);
    this.currentlyRunningSyncEvent = eventId;
    return eventId;
  }

  /**
   * Create an Asynchronous event.
   *
   * @param eventTime Time an event should run for.
   * @throws MaxNumOfEventsAllowedException When too many events are running at a time.
   * @throws LongRunningEventException Long running events are not allowed in the app.
   */
  public int createAsync(int eventTime) throws MaxNumOfEventsAllowedException, LongRunningEventException {
    return createEvent(eventTime, false);
  }

  private int createEvent(final int eventTime, final boolean isSynchronous) throws MaxNumOfEventsAllowedException,
      LongRunningEventException {
    if (this.eventPool.size() == MAX_RUNNING_EVENTS) {
      throw new MaxNumOfEventsAllowedException("Too many events are running at the moment. Please try again later.");
    }

    if (eventTime >= MAX_EVENT_TIME_IN_SECONDS) {
      final String msg = String.format("Maximum event time allowed is %s seconds. Please try again.", MAX_EVENT_TIME_IN_SECONDS);
      throw new LongRunningEventException(msg);
    }

    final int newEventId = generateId();
    final Event newEvent = new Event(newEventId, eventTime, isSynchronous);
    newEvent.setListener(this);
    this.eventPool.put(newEventId, newEvent);

    return newEventId;
  }

  /**
   * Starts event.
   *
   * @param eventId The event that needs to be started.
   * @throws EventDoesNotExistException If event does not exist in our eventPool.
   */
  public void start(final int eventId) throws EventDoesNotExistException {
    checkIfEventExistsInPool(eventId);
    this.eventPool.get(eventId).start();
  }

  /**
   * Stops event.
   *
   * @param eventId The event that needs to be stopped.
   * @throws EventDoesNotExistException If event does not exist in our eventPool.
   */
  public void cancel(final int eventId) throws EventDoesNotExistException {
    checkIfEventExistsInPool(eventId);

    if (eventId == this.currentlyRunningSyncEvent) {
      this.currentlyRunningSyncEvent = -1;
    }

    this.eventPool.get(eventId).stop();
    this.eventPool.remove(eventId);
  }

  /**
   * Get status of a running event.
   *
   * @param eventId The event to inquire status of.
   * @throws EventDoesNotExistException If event does not exist in our eventPool.
   */
  public void status(final int eventId) throws EventDoesNotExistException {
    checkIfEventExistsInPool(eventId);
    this.eventPool.get(eventId).status();
  }

  public void statusOfAllEvents() {
    this.eventPool.forEach((key, value) -> value.status());
  }

  public void stopOfAllEvents() {
    this.eventPool.forEach((key, value) -> value.stop());
  }

  private void checkIfEventExistsInPool(final int eventId) throws EventDoesNotExistException {
    if (!this.eventPool.containsKey(eventId)) {
      throw new EventDoesNotExistException(String.format("%s does not exists", eventId));
    }
  }

  /**
   * Returns a pseudo-random number between min and max, inclusive. The difference between min and max can be at most.
   * <code>Integer.MAX_VALUE - 1</code>.
   */
  private int generateId() {
    int randomNum = this.random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
    while (this.eventPool.containsKey(randomNum)) {
      randomNum = this.random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
    }
    return randomNum;
  }

  @Override
  public void completedEventHandler(final int eventId) {
    this.eventPool.get(eventId).status();
    if (this.eventPool.get(eventId).isSynchronous()) {
      this.currentlyRunningSyncEvent = -1;
    }
    this.eventPool.remove(eventId);
  }

}

package com.cristian.design.patterns;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReaderWriterLock implements ReadWriteLock {

  private final Object readerMutex = new Object();

  private final Set<Object> globalMutex = new HashSet<>();

  private final ReadLock readerLock = new ReadLock();

  private final WriteLock writerLock = new WriteLock();

  private int currentReaderCount;

  @Override
  public Lock readLock() {
    return this.readerLock;
  }

  @Override
  public Lock writeLock() {
    return this.writerLock;
  }

  /**
   * Reader Lock, can be access for more than one reader concurrently if no writer get the lock.
   */
  private class ReadLock implements Lock {

    @Override
    public void lock() {
      synchronized (readerMutex) {
        currentReaderCount++;
        if (currentReaderCount == 1) {
          acquireForReaders();
        }
      }
    }

    /**
     * Acquire the globalMutex lock on behalf of current and future concurrent readers. Make sure no writers currently owns the lock.
     */
    private void acquireForReaders() {
      // Try to get the globalMutex lock for the first reader
      synchronized (globalMutex) {
        // If the no one get the lock or the lock is locked by reader, just set the reference
        // to the globalMutex to indicate that the lock is locked by Reader.
        while (doesWriterOwnThisLock()) {
          try {
            globalMutex.wait();
          } catch (InterruptedException e) {
            var message = "InterruptedException while waiting for globalMutex in acquireForReaders";
            LOGGER.info(message, e);
            Thread.currentThread().interrupt();
          }
        }
        globalMutex.add(this);
      }
    }

    @Override
    public void unlock() {
      synchronized (readerMutex) {
        currentReaderCount--;
        // Release the lock only when it is the last reader, it is ensure that the lock is released
        // when all reader is completely.
        if (currentReaderCount == 0) {
          synchronized (globalMutex) {
            // Notify the waiter, mostly the writer
            globalMutex.remove(this);
            globalMutex.notifyAll();
          }
        }
      }

    }

    /**
     * @return true when globalMutex hold the reference of writerLock.
     */
    private boolean doesWriterOwnThisLock() {
      return globalMutex.contains(writerLock);
    }

    @Override
    public void lockInterruptibly() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Condition newCondition() {
      throw new UnsupportedOperationException();
    }

  }

  /**
   * Writer Lock, can only be accessed by one writer concurrently.
   */
  private class WriteLock implements Lock {

    @Override
    public void lock() {
      synchronized (globalMutex) {

        // Wait until the lock is free.
        while (!isLockFree()) {
          try {
            globalMutex.wait();
          } catch (InterruptedException e) {
            LOGGER.info("InterruptedException while waiting for globalMutex to begin writing", e);
            Thread.currentThread().interrupt();
          }
        }
        // When the lock is free, acquire it by placing an entry in globalMutex
        globalMutex.add(this);
      }
    }

    @Override
    public void unlock() {
      synchronized (globalMutex) {
        globalMutex.remove(this);
        // Notify the waiter, other writer or reader
        globalMutex.notifyAll();
      }
    }

    /**
     * @return get the lock when globalMutex contains nothing.
     */
    private boolean isLockFree() {
      return globalMutex.isEmpty();
    }

    @Override
    public void lockInterruptibly() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Condition newCondition() {
      throw new UnsupportedOperationException();
    }
  }

}
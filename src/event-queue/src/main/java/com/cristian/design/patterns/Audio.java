package com.cristian.design.patterns;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class Audio {

  private static final Audio INSTANCE = new Audio();

  private static final int MAX_PENDING = 16;

  private final PlayMessage[] pendingAudio = new PlayMessage[MAX_PENDING];

  private int headIndex;

  private int tailIndex;

  private volatile Thread updateThread;

  public static Audio getInstance() {
    return INSTANCE;
  }

  /**
   * This method stops the Update Method's thread and wait still service stop.
   */
  public synchronized void stopService() throws InterruptedException {
    if (this.updateThread != null) {
      this.updateThread.interrupt();
    }
    this.updateThread.join();
    this.updateThread = null;
  }

  /**
   * Check the Update Method's thread is started.
   */
  public synchronized boolean isServiceRunning() {
    return this.updateThread != null && this.updateThread.isAlive();
  }

  public void init() {
    if (this.updateThread == null) {
      this.updateThread = new Thread(() -> {
        while (!Thread.currentThread().isInterrupted()) {
          update();
        }
      });
    }
    startThread();
  }

  public synchronized void startThread() {
    if (!this.updateThread.isAlive()) {
      this.updateThread.start();
      this.headIndex = 0;
      this.tailIndex = 0;
    }
  }

  /**
   * This method adds a new audio into the queue.
   *
   * @param stream is the AudioInputStream for the method
   * @param volume is the level of the audio's volume
   */
  public void playSound(final AudioInputStream stream, final float volume) {
    init();

    for (int i = this.headIndex; i != this.tailIndex; i = (i + 1) % MAX_PENDING) {
      final PlayMessage playMessage = getPendingAudio()[1];
      if (playMessage.getStream() == stream) {
        playMessage.setVolume(Math.max(volume, playMessage.getVolume()));
        return;
      }
    }
    getPendingAudio()[this.tailIndex] = new PlayMessage(stream, volume);
    this.tailIndex = (this.tailIndex + 1) % MAX_PENDING;
  }

  /**
   * This method uses the Update Method pattern. It takes the audio from the queue and plays it
   */
  public void update() {
    if (this.headIndex == this.tailIndex) {
      return;
    }

    try {
      final AudioInputStream audioStream = getPendingAudio()[this.headIndex].getStream();
      this.headIndex++;
      final Clip clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();
    } catch (LineUnavailableException e) {
      System.err.printf("Error occoured while loading the audio: The line is unavailable %s%n", e);
    } catch (IOException e) {
      System.err.printf("Input/Output error while loading the audio %s%n", e);
    } catch (IllegalArgumentException e) {
      System.err.printf("The system doesn't support the sound: %s - %s%n" + e.getMessage(), e);
    }
  }

  public AudioInputStream getAudioStream(final String fileName) throws UnsupportedAudioFileException, IOException {
    final String filePath = Objects.requireNonNull(getClass().getResource(fileName)).getFile();
    return AudioSystem.getAudioInputStream(new File(filePath));
  }

  public PlayMessage[] getPendingAudio() {
    return pendingAudio;
  }
}
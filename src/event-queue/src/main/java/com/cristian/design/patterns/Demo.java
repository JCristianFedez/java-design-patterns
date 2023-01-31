package com.cristian.design.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.UnsupportedAudioFileException;

class Demo {

  public static void main(String[] args) throws UnsupportedAudioFileException, IOException, InterruptedException {
    new Demo().run();
  }

  private void run() throws UnsupportedAudioFileException, IOException, InterruptedException {
    final Audio audio = Audio.getInstance();
    audio.playSound(audio.getAudioStream("Bass-Drum-1.wav"), -10.0f);
    audio.playSound(audio.getAudioStream("Closed-Hi-Hat-1.wav"), -8.0f);

    System.out.println("Press Enter key to stop the program...");
    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      br.read();
    }
    audio.stopService();
  }
}

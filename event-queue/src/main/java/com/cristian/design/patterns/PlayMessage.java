package com.cristian.design.patterns;

import javax.sound.sampled.AudioInputStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
class PlayMessage {

  private final AudioInputStream stream;

  @Setter
  private float volume;
}

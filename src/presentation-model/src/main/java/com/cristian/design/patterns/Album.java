package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Album {

  private String title;

  private String artist;

  private boolean isClassical;

  private String composer;
}

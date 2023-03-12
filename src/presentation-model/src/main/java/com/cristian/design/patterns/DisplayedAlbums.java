package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class DisplayedAlbums {

  private final List<Album> albums = new ArrayList<>();

  public void addAlbum(final Album album) {
    this.albums.add(album);
  }

  public Album getAlbum(final int selectedAlbumNumber) {
    return this.albums.get(selectedAlbumNumber);
  }
}

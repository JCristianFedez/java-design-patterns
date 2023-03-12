package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PresentationModel {

  private final DisplayedAlbums data;

  private int selectedAlbumNumber;

  private Album selectedAlbum;

  public PresentationModel(final DisplayedAlbums dataOfAlbums) {
    this.data = dataOfAlbums;
    this.selectedAlbumNumber = 1;
    this.selectedAlbum = this.data.getAlbum(0);
  }

  public static DisplayedAlbums albumDataSet() {
    final List<Album> albums = Arrays.asList(
        new Album("HQ", "Roy Harper", false, null),
        new Album("The Rough Dancer and Cyclical Night", "Astor Piazzola", false, null),
        new Album("The Black Light", "The Black Light", false, null),
        new Album("Symphony No.5", "CBSO", true, "Sibelius")
    );
    final DisplayedAlbums displayedAlbums = new DisplayedAlbums();
    albums.forEach(displayedAlbums::addAlbum);
    return displayedAlbums;
  }

  public void setSelectedAlbumNumber(final int albumNumber) {
    LOGGER.info("Change select number from {} to {}", this.selectedAlbum, albumNumber);
    this.selectedAlbumNumber = albumNumber;
    this.selectedAlbum = this.data.getAlbum(this.selectedAlbumNumber - 1);
  }

  public String getTitle() {
    return this.selectedAlbum.getTitle();
  }

  public void setTitle(final String newTitle) {
    LOGGER.info("Change albums title from {} to {}", this.selectedAlbum.getTitle(), newTitle);
    this.selectedAlbum.setTitle(newTitle);
  }

  public String getArtist() {
    return this.selectedAlbum.getArtist();
  }

  public void setArtist(final String newArtist) {
    LOGGER.info("Change albums artist from {} to {}", this.selectedAlbum.getArtist(), newArtist);
    this.selectedAlbum.setArtist(newArtist);
  }

  public boolean getIsClassical() {
    return this.selectedAlbum.isClassical();
  }

  public void setIsClassical(final boolean value) {
    LOGGER.info("Change album isClassical from {} to {}", this.selectedAlbum.isClassical(), value);
    this.selectedAlbum.setClassical(value);
  }

  public String getComposer() {
    return this.selectedAlbum.getComposer();
  }

  public void setComposer(final String value) {
    if (this.selectedAlbum.isClassical()) {
      LOGGER.info("Change album composer from {} to {}", this.selectedAlbum.getComposer(), value);
      this.selectedAlbum.setComposer(value);
    } else {
      LOGGER.info("Composer can not be changed");
    }
  }

  public List<String> getAlbumTitles() {
    return this.data.getAlbums().stream()
        .map(Album::getTitle)
        .collect(Collectors.toList());
  }
}

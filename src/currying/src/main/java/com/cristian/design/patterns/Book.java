package com.cristian.design.patterns;

import java.time.LocalDate;
import java.util.StringJoiner;
import java.util.function.Function;

class Book {

  private static final Function<Genre, Function<String, Function<String, Function<LocalDate, Book>>>> CREATOR =
      curryingGenre -> curryingAuthor -> curryingTitle -> curryingPublicationDate
          -> new Book(curryingGenre, curryingAuthor, curryingTitle, curryingPublicationDate);

  private final Genre genre;

  private final String author;

  private final String title;

  private final LocalDate publicationDate;

  private Book(final Genre genere, final String author, final String title, final LocalDate publicationDate) {
    this.genre = genere;
    this.author = author;
    this.title = title;
    this.publicationDate = publicationDate;
  }

  public static AddGenre builder() {
    return genre -> author -> title -> publicationDate -> new Book(genre, author, title, publicationDate);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
        .add("genre=" + this.genre)
        .add("author='" + this.author + "'")
        .add("title='" + this.title + "'")
        .add("publicationDate=" + this.publicationDate)
        .toString();
  }

  public interface AddGenre {

    Book.AddAuthor genre(final Genre genre);
  }

  public interface AddAuthor {

    Book.AddTitle author(final String author);
  }

  public interface AddTitle {

    Book.AddPublicationDate title(final String title);
  }

  public interface AddPublicationDate {

    Book publicationDate(final LocalDate publicationDate);
  }
}

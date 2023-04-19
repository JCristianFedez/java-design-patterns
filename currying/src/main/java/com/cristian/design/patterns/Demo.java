package com.cristian.design.patterns;

import java.time.LocalDate;

class Demo {

  public static void main(String[] args) {

    // Defining genre book functions
    final Book.AddAuthor fantasyBookFunc = Book.builder().genre(Genre.FANTASY);
    final Book.AddAuthor horrorBookFunc = Book.builder().genre(Genre.HORROR);
    final Book.AddAuthor scifiBookFunc = Book.builder().genre(Genre.SCI_FI);

    // Defining author book functions
    final Book.AddTitle kingFantasyBooksFunct = fantasyBookFunc.author("Stephen King");
    final Book.AddTitle kingHorrorBooksFunct = horrorBookFunc.author("Stephen King");
    final Book.AddTitle rowlingFantasyBooksFunct = fantasyBookFunc.author("J.K. Rowling");

    // Creates books by Stephen King (Horror and fantasy genres)
    final Book shining = kingHorrorBooksFunct.title("The Shining").publicationDate(LocalDate.of(1977, 1, 28));
    final Book darkTower = kingFantasyBooksFunct.title("The Dark Tower: Gunslinger").publicationDate(LocalDate.of(1982, 6, 10));

    // Create fantasy books by J.K. Rowling
    final Book chamberOfSecrets = rowlingFantasyBooksFunct.title("Harry Potter and the Chamber of Secrets")
        .publicationDate(LocalDate.of(1982, 6, 10));

    // Create sci-fi books
    final Book dune = scifiBookFunc.author("Frank Herbert").title("Dune").publicationDate(LocalDate.of(1965, 7, 2));
    final Book foundation = scifiBookFunc.author("Isaac Asimov").title("Foundation").publicationDate(LocalDate.of(1942, 5, 1));

    System.out.println("Stephen King Books");
    System.out.println(shining.toString());
    System.out.println(darkTower.toString());

    System.out.println("\n\nJ.K. Rowling Books:");
    System.out.println(chamberOfSecrets.toString());

    System.out.println("\n\nSci-fi Books:");
    System.out.println(dune.toString());
    System.out.println(foundation.toString());
  }
}

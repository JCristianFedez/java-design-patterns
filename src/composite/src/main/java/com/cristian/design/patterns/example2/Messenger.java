package com.cristian.design.patterns.example2;

import java.util.Arrays;
import java.util.List;

final class Messenger {

  public LetterComposite messageFromOrcs() {
    final List<Word> words = Arrays.asList(
        Word.of('W', 'h', 'e', 'r', 'e'),
        Word.of('t', 'h', 'e', 'r', 'e'),
        Word.of('i', 's'),
        Word.of('a'),
        Word.of('w', 'h', 'i', 'p'),
        Word.of('t', 'h', 'e', 'r', 'e'),
        Word.of('i', 's'),
        Word.of('a'),
        Word.of('w', 'a', 'y')
    );
    return new Sentence(words);
  }

  public LetterComposite messageFromElves() {
    final List<Word> words = Arrays.asList(
        Word.of('M', 'u', 'c', 'h'),
        Word.of('w', 'i', 'n', 'd'),
        Word.of('p', 'o', 'u', 'r', 's'),
        Word.of('f', 'r', 'o', 'm'),
        Word.of('y', 'o', 'u', 'r'),
        Word.of('m', 'o', 'u', 't', 'h')
    );
    return new Sentence(words);
  }
}

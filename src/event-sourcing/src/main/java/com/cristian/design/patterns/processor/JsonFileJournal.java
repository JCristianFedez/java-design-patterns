package com.cristian.design.patterns.processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.event.AccountCreateEvent;
import com.cristian.design.patterns.event.DomainEvent;
import com.cristian.design.patterns.event.MoneyDepositEvent;
import com.cristian.design.patterns.event.MoneyTransferEvent;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JsonFileJournal {

  private final File file;

  private final List<String> events = new ArrayList<>();

  private int index = 0;

  public JsonFileJournal() {
    this.file = new File("Journal.json");
    if (this.file.exists()) {
      try (final BufferedReader reader = new BufferedReader(
          new InputStreamReader(new FileInputStream(this.file), StandardCharsets.UTF_8))) {
        String line;
        while ((line = reader.readLine()) != null) {
          this.events.add(line);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else {
      reset();
    }
  }

  public void write(final DomainEvent domainEvent) {
    final Gson gson = new Gson();
    final JsonElement jsonElement = gson.toJsonTree(domainEvent, domainEvent.getClass());

    try (final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(this.file, true), StandardCharsets.UTF_8))) {
      final String eventString = jsonElement.toString();
      writer.write(eventString + "\r\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public DomainEvent readNext() {
    if (this.index >= this.events.size()) {
      return null;
    }
    final String event = this.events.get(this.index++);

    final JsonElement jsonElement = JsonParser.parseString(event);
    final String eventClassName = jsonElement.getAsJsonObject().get("eventClassName").getAsString();
    final Gson gson = new Gson();
    DomainEvent domainEvent;
    if (eventClassName.equals("AccountCreateEvent")) {
      domainEvent = gson.fromJson(jsonElement, AccountCreateEvent.class);
    } else if (eventClassName.equals("MoneyDepositEvent")) {
      domainEvent = gson.fromJson(jsonElement, MoneyDepositEvent.class);
    } else if (eventClassName.equals("MoneyTransferEvent")) {
      domainEvent = gson.fromJson(jsonElement, MoneyTransferEvent.class);
    } else {
      throw new RuntimeException("Journal Event not recegnized");
    }

    domainEvent.setRealTime(false);
    return domainEvent;
  }

  public void reset() {
    try {
      Files.deleteIfExists(this.file.toPath());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

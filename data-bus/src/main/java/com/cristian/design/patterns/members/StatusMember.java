package com.cristian.design.patterns.members;

import java.time.LocalDateTime;

import com.cristian.design.patterns.data.DataType;
import com.cristian.design.patterns.data.MessageData;
import com.cristian.design.patterns.data.StartingData;
import com.cristian.design.patterns.data.StoppingData;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StatusMember implements Member {

  private final int id;

  private LocalDateTime started;

  private LocalDateTime stopped;

  @Override
  public void accept(final DataType data) {
    if (data instanceof StartingData) {
      handleEvent((StartingData) data);
    } else if (data instanceof StoppingData) {
      handleEvent((StoppingData) data);
    }
  }

  private void handleEvent(final StartingData data) {
    this.started = data.getWhen();
    System.out.printf("Reciver {} sees application started at {}%n", this.id, this.started);
  }

  private void handleEvent(final StoppingData data) {
    this.stopped = data.getWhen();
    System.out.printf("Reciver {} sees application stopping at {}%n", this.id, this.stopped);
    System.out.printf("Reciver {} sending goodbye message%n", this.id);
    data.getDataBus().publish(MessageData.of(String.format("Goodbye cruel world form #%d!%n", this.id)));
  }
}

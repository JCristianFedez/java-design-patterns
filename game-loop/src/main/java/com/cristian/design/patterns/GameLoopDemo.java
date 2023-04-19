package com.cristian.design.patterns;

import com.cristian.design.patterns.loops.FixedStepGameLoop;
import com.cristian.design.patterns.loops.FrameBasedGameLoop;
import com.cristian.design.patterns.loops.VariableStepGameLoop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameLoopDemo {

  private static final int GAME_LOOP_DURATION_TIME = 2000;

  public static void main(String[] args) throws InterruptedException {
    new GameLoopDemo().run();
  }

  private void run() throws InterruptedException {
    runFrameBasedGameLoop();
    runVariableStepGameLoop();
    runFixedStepGameLoop();
  }

  private void runFixedStepGameLoop() throws InterruptedException {
    LOGGER.info("Start fixed-step game loop.");
    final FixedStepGameLoop fixedStepGameLoop = new FixedStepGameLoop();
    fixedStepGameLoop.run();
    Thread.sleep(GAME_LOOP_DURATION_TIME);
    fixedStepGameLoop.stop();
    LOGGER.info("Stop fixed-step game loop.");
  }

  private void runVariableStepGameLoop() throws InterruptedException {
    LOGGER.info("Start variable-step game loop.");
    final VariableStepGameLoop variableStepGameLoop = new VariableStepGameLoop();
    variableStepGameLoop.run();
    Thread.sleep(GAME_LOOP_DURATION_TIME);
    variableStepGameLoop.stop();
    LOGGER.info("Stop variable-step game loop.");
  }

  private void runFrameBasedGameLoop() throws InterruptedException {
    LOGGER.info("Start frame-based game loop.");
    final FrameBasedGameLoop frameBasedGameLoop = new FrameBasedGameLoop();
    frameBasedGameLoop.run();
    Thread.sleep(GAME_LOOP_DURATION_TIME);
    frameBasedGameLoop.stop();
    LOGGER.info("Stop frame-based game loop.");
  }
}

package com.cristian.design.patterns.shard;

import com.cristian.design.patterns.Data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RangeShardManager extends ShardManager {

  @Override
  public int storeData(final Data data) {
    final int shardId = allocateShard(data);
    final Shard shard = shardById(shardId);
    shard.storeData(data);
    LOGGER.info("{} is stored in Shard {}", data, shardId);
    return shardId;
  }

  @Override
  protected int allocateShard(final Data data) {
    return switch (data.getType()) {
      case TYPE_1 -> 1;
      case TYPE_2 -> 2;
      case TYPE_3 -> 3;
    };
  }
}

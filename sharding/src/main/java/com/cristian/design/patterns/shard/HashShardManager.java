package com.cristian.design.patterns.shard;

import com.cristian.design.patterns.Data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashShardManager extends ShardManager {

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
    final int shardCount = getShardMap().size();
    final int hash = data.getKey() % shardCount;
    return hash == 0 ? hash + shardCount : hash;
  }
}

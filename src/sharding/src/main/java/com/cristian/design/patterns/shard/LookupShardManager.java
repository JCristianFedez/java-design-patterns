package com.cristian.design.patterns.shard;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.Data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LookupShardManager extends ShardManager {

  private final Map<Integer, Integer> lookupMap = new HashMap<>();

  @Override
  public int storeData(final Data data) {
    final int shardId = allocateShard(data);
    this.lookupMap.put(data.getKey(), shardId);
    final Shard shard = shardById(shardId);
    shard.storeData(data);
    LOGGER.info("{} is stored in Shard {}", data, shardId);
    return shardId;
  }

  @Override
  protected int allocateShard(final Data data) {
    if (this.lookupMap.containsKey(data.getKey())) {
      return this.lookupMap.get(data.getKey());
    }
    final int shardCount = getShardMap().size();
    return new SecureRandom().nextInt(shardCount - 1) + 1;
  }
}

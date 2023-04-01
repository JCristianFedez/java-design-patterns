package com.cristian.design.patterns.shard;

import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.Data;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class ShardManager {

  @Getter(AccessLevel.PROTECTED)
  private final Map<Integer, Shard> shardMap = new HashMap<>();

  public boolean addShard(final Shard shard) {
    return this.shardMap.put(shard.getId(), shard) != null;
  }

  public boolean removeShardById(final int id) {
    return this.shardMap.remove(id) != null;
  }

  public Shard shardById(final int id) {
    return this.shardMap.get(id);
  }

  public abstract int storeData(final Data data);

  protected abstract int allocateShard(final Data data);
}

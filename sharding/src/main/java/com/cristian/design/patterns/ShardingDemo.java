package com.cristian.design.patterns;

import com.cristian.design.patterns.shard.HashShardManager;
import com.cristian.design.patterns.shard.LookupShardManager;
import com.cristian.design.patterns.shard.RangeShardManager;
import com.cristian.design.patterns.shard.Shard;
import com.cristian.design.patterns.shard.ShardManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShardingDemo {

  public static void main(String[] args) {
    final Data data1 = new Data(1, "data1", Data.DataType.TYPE_1);
    final Data data2 = new Data(2, "data2", Data.DataType.TYPE_2);
    final Data data3 = new Data(3, "data3", Data.DataType.TYPE_3);
    final Data data4 = new Data(4, "data4", Data.DataType.TYPE_1);

    final Shard shard1 = new Shard(1);
    final Shard shard2 = new Shard(2);
    final Shard shard3 = new Shard(3);

    LOGGER.info("=== START LookupShardManager ===");
    final ShardManager lookupShardManager = new LookupShardManager();
    lookupShardManager.addShard(shard1);
    lookupShardManager.addShard(shard2);
    lookupShardManager.addShard(shard3);
    lookupShardManager.storeData(data1);
    lookupShardManager.storeData(data2);
    lookupShardManager.storeData(data3);
    lookupShardManager.storeData(data4);

    shard1.clearData();
    shard2.clearData();
    shard3.clearData();

    LOGGER.info("=== START RangeShardManager ===");
    final ShardManager rangeShardManager = new RangeShardManager();
    rangeShardManager.addShard(shard1);
    rangeShardManager.addShard(shard2);
    rangeShardManager.addShard(shard3);
    rangeShardManager.storeData(data1);
    rangeShardManager.storeData(data2);
    rangeShardManager.storeData(data3);
    rangeShardManager.storeData(data4);

    shard1.clearData();
    shard2.clearData();
    shard3.clearData();

    LOGGER.info("=== START HashShardManager ===");
    final ShardManager hashShardManager = new HashShardManager();
    hashShardManager.addShard(shard1);
    hashShardManager.addShard(shard2);
    hashShardManager.addShard(shard3);
    hashShardManager.storeData(data1);
    hashShardManager.storeData(data2);
    hashShardManager.storeData(data3);
    hashShardManager.storeData(data4);

    shard1.clearData();
    shard2.clearData();
    shard3.clearData();
  }
}

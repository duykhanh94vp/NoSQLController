package com.popeye.kvdb.base;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

public class RedisController implements IDataController {
    private Jedis jedis;

    @Override
    public void init() {
        jedis = new Jedis(Config.getInstance().get("DB_IP"), Integer.valueOf(Config.getInstance().get("DB_PORT")), 2000);
        jedis.connect();
        jedis.auth(Config.getInstance().get("DB_AUTH"));
    }

    @Override
    public String set(String k, String v) {
        return jedis.set(k, v);
    }

    @Override
    public String get(String k) {
        return jedis.get(k);
    }

    @Override
    public boolean mset(HashMap<String, String> hsm) {
        return false;
    }

    @Override
    public HashMap<String, String> mget(List<String> ks) {
        return null;
    }
}

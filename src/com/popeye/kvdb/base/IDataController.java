package com.popeye.kvdb.base;

import java.util.HashMap;
import java.util.List;

public interface IDataController {
    public void init();

    public String set(String k, String v);

    public String get(String k);

    public boolean mset(HashMap<String, String> hsm);

    public HashMap<String, String> mget(List<String> ks);
}

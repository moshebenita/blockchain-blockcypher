package com.moshe.blockchain.client.object;

import java.util.List;

public class Tx{
    public int block_height;
    public int block_index;
    public String hash;
    public List<String> addresses;
    public int total;
    public int fees;
    public int size;
    public int vsize;
    public String preference;
    public String relayed_by;
    public String received;
    public int ver;
    public boolean double_spend;
    public int vin_sz;
    public int vout_sz;
    public int confirmations;
    public List<Input> inputs;
    public List<Output> outputs;
}


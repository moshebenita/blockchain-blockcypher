package com.moshe.blockchain.client.object;

import java.util.List;

public class Input{
    public String prev_hash;
    public int output_index;
    public int output_value;
    public long sequence;
    public List<String> addresses;
    public String script_type;
    public int age;
}

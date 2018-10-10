package com.wei.jdbc;

import java.io.IOException;
import java.io.InputStream;

public class MyInputStream extends InputStream {

    //是你
    private InputStream in;

    //还是你
    public MyInputStream(InputStream in){
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return this.in.read() + 1;

    }
}

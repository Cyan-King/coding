package com.wei.book.web.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StaticResponse extends HttpServletResponseWrapper {

    private PrintWriter pw;

    public StaticResponse(HttpServletResponse response, String path) throws FileNotFoundException, UnsupportedEncodingException {
        super(response);

        // update by chengpx
        pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"), true);
        // update by chengpx
    }


    public PrintWriter getWrite() {
        return pw;
    }
}

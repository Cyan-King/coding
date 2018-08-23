package com.wei.book.web.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StaticResponse extends HttpServletResponseWrapper {

private PrintWriter pw;

    public StaticResponse(HttpServletResponse response, String path) throws FileNotFoundException, UnsupportedEncodingException {
        super(response);

        pw = new PrintWriter(path, "UTF-8");
    }

    /**
     * 由jsp写入到html我们重写了这个类
     * @return
     * @throws IOException
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        return pw;
    }
}

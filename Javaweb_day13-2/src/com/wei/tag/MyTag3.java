package com.wei.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

public class MyTag3 extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        Writer out = this.getJspContext().getOut();
        out.write("****************<br/>");
        /*
        * getJspBody()----这个是标签体设置标签体
        * */
        this.getJspBody().invoke(out);
        out.write("<br/>****************<br/>");
    }
}

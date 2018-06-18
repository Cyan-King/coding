package com.wei.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class MyTag1 implements SimpleTag {
    private PageContext pageContext;
    private JspFragment jspFragment;
    @Override
    public void doTag() throws JspException, IOException {
        pageContext.getOut().print("hello Tag1");

    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.pageContext = (PageContext) jspContext;

    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        this.jspFragment = jspFragment;

    }
}

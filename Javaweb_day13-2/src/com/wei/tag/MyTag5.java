package com.wei.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTag5 extends SimpleTagSupport {

    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test){
            /*
             * 设置标签体
             * 如果传递的输出是null，表示使用的就是当前页面时out
             * */
            this.getJspBody().invoke(null);
        }

    }
}

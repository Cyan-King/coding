package com.wei.domain;

import java.util.List;

/**
 * 这就泛型类
 * @param <T>
 */
public class PageBean<T> {

    private int pc;//当前页面：page code
    private int tp;//总页数：tp
    private int tr;//总记录数
    private int ps;//每页记录数page size
    private List<T> beanList;

    public int getPc() {
        return pc;
    }

    /**
     * 因为页数是不能设置或者是说页数是不用计算的
     * @return
     */
    /*public void setPc(int pc) {
        this.pc = pc;
    }*/

    public int tp() {
        tp = tr / 10;
        return tp % 10 == 10 ? tp : tp+1;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }
}

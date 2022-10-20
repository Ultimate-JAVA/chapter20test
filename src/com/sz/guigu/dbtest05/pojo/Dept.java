package com.sz.guigu.dbtest05.pojo;

public class Dept {
    private int did;
    private String dname;
    private String description;

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dept() {
    }

    public Dept(int did, String dname, String description) {
        this.did = did;
        this.dname = dname;
        this.description = description;
    }
}

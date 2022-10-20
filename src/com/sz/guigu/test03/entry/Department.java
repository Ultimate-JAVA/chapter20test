package com.sz.guigu.test03.entry;

public class Department {

    private Integer did;
    private String dName;
    private String description;

    public Department() {
    }

    public Department(Integer did, String dName, String description) {
        this.did = did;
        this.dName = dName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dName='" + dName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

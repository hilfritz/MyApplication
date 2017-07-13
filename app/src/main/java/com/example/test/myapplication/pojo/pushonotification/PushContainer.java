
package com.example.test.myapplication.pojo.pushonotification;

import com.example.test.myapplication.pojo.pushonotification.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PushContainer {

    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("version")
    @Expose
    private Double version;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("demo")
    @Expose
    private Boolean demo;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = null;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getDemo() {
        return demo;
    }

    public void setDemo(Boolean demo) {
        this.demo = demo;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

}

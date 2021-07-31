package com.cronnoss.apiframeworksretrofitrestassured.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("data")
    private Data data;
    @JsonProperty("support")
    private Support support;

    public Data getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}

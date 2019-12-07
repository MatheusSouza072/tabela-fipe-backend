package com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


public class Brand {

    private Long id;

    private String key;

    private int order;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFipeName() {
        return fipeName;
    }

    public void setFipeName(String fipeName) {
        this.fipeName = fipeName;
    }

    @JsonProperty(value = "fipe_name")
    private String fipeName;
}

package com.example.jpa.demoSpringData.entity;

import javax.persistence.Entity;
import java.io.Serializable;

//@Entity
public abstract class BaseClass<IdType extends Serializable>{

    private IdType id;


    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }
}
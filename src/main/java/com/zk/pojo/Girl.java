package com.zk.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Girl {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private Integer username;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }
}

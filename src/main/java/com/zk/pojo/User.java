package com.zk.pojo;

import javax.persistence.*;

/**
 * Created by mj on 2017/7/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer age;
    private String name;
    private String username;

    @OneToOne
    @JoinColumn(name = "girl_id")
    private Girl girl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}


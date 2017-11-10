package com.zk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private Integer username;

    public Girl() {
    }
}

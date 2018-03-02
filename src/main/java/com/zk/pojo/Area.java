package com.zk.pojo;

import java.util.Date;

public class Area {

  private String code;
  private String name;
  private Integer level;
  private String parentCode;
  private Integer leaf;
  private Integer status;
  private Integer updaterId;
  private Date created;
  private Date updated;
  private String simpleName;
  private String isParent;


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }


  public String getParentCode() {
    return parentCode;
  }

  public void setParentCode(String parentCode) {
    this.parentCode = parentCode;
  }


  public Integer getLeaf() {
    return leaf;
  }

  public void setLeaf(Integer leaf) {
    this.leaf = leaf;
  }


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Integer getUpdaterId() {
    return updaterId;
  }

  public void setUpdaterId(Integer updaterId) {
    this.updaterId = updaterId;
  }


  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }


  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }


  public String getSimpleName() {
    return simpleName;
  }

  public void setSimpleName(String simpleName) {
    this.simpleName = simpleName;
  }


  public String getIsParent() {
    return isParent;
  }

  public void setIsParent(String isParent) {
    this.isParent = isParent;
  }

}

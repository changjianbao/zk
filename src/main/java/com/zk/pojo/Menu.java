package com.zk.pojo;

import java.util.Date;

public class Menu {

  private int id;
  private String name;
  private int parentId;
  private String url;
  private int orders;
  private String sysId;
  private String bz;
  private int delFlag;
  private int createBy;
  private Date createDate;
  private int updateBy;
  private Date updateDate;
  private int isFunctionMenu;
  private String menuIcon;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public int getOrders() {
    return orders;
  }

  public void setOrders(int orders) {
    this.orders = orders;
  }


  public String getSysId() {
    return sysId;
  }

  public void setSysId(String sysId) {
    this.sysId = sysId;
  }


  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }


  public int getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(int delFlag) {
    this.delFlag = delFlag;
  }


  public int getCreateBy() {
    return createBy;
  }

  public void setCreateBy(int createBy) {
    this.createBy = createBy;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }


  public int getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(int updateBy) {
    this.updateBy = updateBy;
  }


  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }


  public int getIsFunctionMenu() {
    return isFunctionMenu;
  }

  public void setIsFunctionMenu(int isFunctionMenu) {
    this.isFunctionMenu = isFunctionMenu;
  }


  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }

}

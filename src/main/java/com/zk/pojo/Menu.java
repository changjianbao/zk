package com.zk.pojo;

import java.util.Date;

public class Menu {

  private Integer id;
  private String name;
  private Integer parentId;
  private String url;
  private Integer orders;
  private String sysId;
  private String bz;
  private Integer delFlag;
  private Integer createBy;
  private Date createDate;
  private Integer updateBy;
  private Date updateDate;
  private Integer isFunctionMenu;
  private String menuIcon;

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

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getOrders() {
    return orders;
  }

  public void setOrders(Integer orders) {
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

  public Integer getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(Integer delFlag) {
    this.delFlag = delFlag;
  }

  public Integer getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Integer createBy) {
    this.createBy = createBy;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Integer getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Integer updateBy) {
    this.updateBy = updateBy;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public Integer getIsFunctionMenu() {
    return isFunctionMenu;
  }

  public void setIsFunctionMenu(Integer isFunctionMenu) {
    this.isFunctionMenu = isFunctionMenu;
  }

  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }
}

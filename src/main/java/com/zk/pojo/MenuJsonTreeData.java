package com.zk.pojo;
import java.util.List;

/**
 * Created by leaves on 17/4/14.
 */
public class
MenuJsonTreeData {
    public String id;
    public String pid;
    public String title;     //标题
    public String icon;     //图标
    public String url;     //路径
    public boolean spread;
    public List<MenuJsonTreeData> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<MenuJsonTreeData> getChildren() {
        return children;
    }

    public void setChildren(List<MenuJsonTreeData> children) {
        this.children = children;
    }
}

package com.zk.util;
import com.zk.pojo.MenuJsonTreeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leaves on 17/4/14.
 */
public class TreeNodeUtil {
    public final static List<MenuJsonTreeData> getfatherNode(List<MenuJsonTreeData> treeDataList) {
        List<MenuJsonTreeData> newTreeDataList = new ArrayList<MenuJsonTreeData>();
        for (MenuJsonTreeData MenuJsonTreeData : treeDataList) {
            if(MenuJsonTreeData.getPid().equals("0")) {
                //获取父节点下的子节点
                MenuJsonTreeData.setChildren(getChildrenNode(MenuJsonTreeData.getId(),treeDataList));
                newTreeDataList.add(MenuJsonTreeData);
            }
        }
        return newTreeDataList;
    }

    private final static List<MenuJsonTreeData> getChildrenNode(String pid , List<MenuJsonTreeData> treeDataList) {
        List<MenuJsonTreeData> newTreeDataList = new ArrayList<MenuJsonTreeData>();
        for (MenuJsonTreeData MenuJsonTreeData : treeDataList) {
            if(MenuJsonTreeData.getPid().equals("0"))  continue;

            if(MenuJsonTreeData.getPid().equals(pid)){
                //递归获取子节点下的子节点
                MenuJsonTreeData.setChildren(getChildrenNode(MenuJsonTreeData.getId() , treeDataList));

                newTreeDataList.add(MenuJsonTreeData);
            }
        }
        return newTreeDataList;
    }
}

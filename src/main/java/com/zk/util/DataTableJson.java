package com.zk.util;
/**
 * Created by Administrator on 2017/4/11.
 */
import com.alibaba.fastjson.JSONObject;

public class DataTableJson {
    public static JSONObject getJsonResultList(Integer draw, Long recordsTotal, Long recordsFiltered, Object data){
        JSONObject result = new JSONObject();
        if(draw != null){
            result.put("draw", draw);
        }
        if(recordsTotal != null){
            result.put("recordsTotal", recordsTotal);
        }
        if(recordsFiltered != null){
            result.put("recordsFiltered", recordsFiltered);
        }
        result.put("data", data);

        return result;
    }
}

package com.kai.edu.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class R {

    private boolean success;
    private Integer state;
    private String message;
    //private Map<String,Object> content = new HashMap<>();
    private List content = new ArrayList();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setState(0);
        r.setMessage("响应成功");
        return r;
    }
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setState(1);
        r.setMessage("响应失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer state){
        this.setState(state);
        return this;
    }
//    public R content(String key, Object value){
//        this.content.put(key, value);
//        return this;
//    }
//    public R content(Map<String, Object> map){
//        this.setContent(map);
//        return this;
//    }

        public R content(List content){
        this.setContent(content);
        return this;
    }



}

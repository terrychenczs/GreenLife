package com.czs.util.jsonUtil.Entity;

import java.util.Date;

public class AbstractJSON {
    private String code;                       //响应状态码
    private String msg;                        //响应状态描述
    private String path;
    private long time = new Date().getTime();  //时间戳

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setContent(String code,String msg){
        this.code = code;
        this.msg = msg;
        this.path = path;
    }

}

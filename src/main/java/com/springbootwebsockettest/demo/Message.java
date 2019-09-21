package com.springbootwebsockettest.demo;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data

public class Message {
    public static final String Enter="Enter";
    public static final String Speak="Speak";
    public static final String Quit="Quit";

    private String type;
    private String username;
    private String msg;
    private int onlinecount;


    public Message(String type, String username, String msg, int onlinecount) {
        this.type = type;
        this.username = username;
        this.msg = msg;
        this.onlinecount = onlinecount;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getOnlinecount() {
        return onlinecount;
    }

    public void setOnlinecount(int onlinecount) {
        this.onlinecount = onlinecount;
    }



    public static String jsonStr(String type,String username,String msg,int onlineTotal){
        return JSON.toJSONString(new Message(type,username,msg,onlineTotal));

    }

}

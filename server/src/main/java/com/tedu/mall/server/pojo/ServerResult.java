package com.tedu.mall.server.pojo;

public class ServerResult {
    int state;
    String msg;
    Object data;

    public ServerResult(int state,String msg,Object data){
        this.data=data;
        this.msg=msg;
        this.state=state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

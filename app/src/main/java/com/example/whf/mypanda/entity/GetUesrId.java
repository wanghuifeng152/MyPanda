package com.example.whf.mypanda.entity;

import java.util.List;

/**
 * Created by WHF
 * on 2018/4/19.
 * at 北京
 */

public class GetUesrId {
    /**
     * errMsg : 缺少参数
     * errType : 102
     * sso : []
     * ticket :
     * timestamp : 2018-04-19 18:36:51
     * user_seq_id :
     * usrid :
     */

    private String errMsg;
    private String errType;
    private String ticket;
    private String timestamp;
    private String user_seq_id;
    private String usrid;
    private List<?> sso;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_seq_id() {
        return user_seq_id;
    }

    public void setUser_seq_id(String user_seq_id) {
        this.user_seq_id = user_seq_id;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public List<?> getSso() {
        return sso;
    }

    public void setSso(List<?> sso) {
        this.sso = sso;
    }
}

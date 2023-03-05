package com.haneet.infsec.keylogweb.model;

import java.util.Date;

/**
 * @author Emre Sen - 14.05.2019
 * @contact maemresen07@gmail.com
 */
public class KeyLogModel {

    private String uuid;
    private Date keyLogDate;
    private String accessibilityEvent;
    private String msg;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getKeyLogDate() {
        return keyLogDate;
    }

    public void setKeyLogDate(Date keyLogDate) {
        this.keyLogDate = keyLogDate;
    }

    public String getAccessibilityEvent() {
        return accessibilityEvent;
    }

    public void setAccessibilityEvent(String accessibilityEvent) {
        this.accessibilityEvent = accessibilityEvent;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "KeyLogModel{" +
                "uuid='" + uuid + '\'' +
                ", keyLogDate=" + keyLogDate +
                ", accessibilityEvent='" + accessibilityEvent + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
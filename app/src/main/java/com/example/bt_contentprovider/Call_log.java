package com.example.bt_contentprovider;

import java.io.Serializable;

public class Call_log implements Serializable {
    private String name;
    private String phone;
    private String callType;
    private String callDate;
    private String callDuration;

    public Call_log(String name, String phone, String callType, String callDate, String callDuration) {
        this.name = name;
        this.phone = phone;
        this.callType = callType;
        this.callDate = callDate;
        this.callDuration = callDuration;
    }

    public Call_log() {
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    @Override
    public String toString() {
        return "Số: " + this.phone + "\nLoại: " + this.callType + "\nNgày: " + this.callDate + "\nThời gian: " + this.callDuration;
    }
}
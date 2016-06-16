package com.yjn.retrofitdemo.bean;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-05-26 14:59
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class LoginResponse {

    /**
     * subsId : 533001
     * userId : 16
     * custId : null
     * accountId : null
     * accessToken : u75EReJdy0kQd7mDHA1EWw==
     * securityKey : Il3Y73Y2RroVPl2tln3COA==
     * expireDate : 2016-05-26 15:46:53
     */

    private int subsId;
    private int userId;
    private Object custId;
    private Object accountId;
    private String accessToken;
    private String securityKey;
    private String expireDate;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "subsId=" + subsId +
                ", userId=" + userId +
                ", custId=" + custId +
                ", accountId=" + accountId +
                ", accessToken='" + accessToken + '\'' +
                ", securityKey='" + securityKey + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }

    public int getSubsId() {
        return subsId;
    }

    public void setSubsId(int subsId) {
        this.subsId = subsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Object getCustId() {
        return custId;
    }

    public void setCustId(Object custId) {
        this.custId = custId;
    }

    public Object getAccountId() {
        return accountId;
    }

    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}

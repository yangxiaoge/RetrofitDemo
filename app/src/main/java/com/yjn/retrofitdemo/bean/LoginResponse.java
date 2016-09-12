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
     * subsId : 106005
     * userId : 13
     * custId : null
     * accountId : null
     * accessToken : Br9jf7loc2vzZv69OHCpGQ==
     * securityKey : Os3mJc7vp+VrT4JgqO7z8w==
     * expireDate : 2016-09-12 15:26:20
     * custCode : 11055
     * acctNbr : 1029
     */

    private String subsId;
    private String userId;
    private String custId;
    private String accountId;
    private String accessToken;
    private String securityKey;
    private String expireDate;
    private String custCode;
    private String acctNbr;

    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
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

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getAcctNbr() {
        return acctNbr;
    }

    public void setAcctNbr(String acctNbr) {
        this.acctNbr = acctNbr;
    }
}

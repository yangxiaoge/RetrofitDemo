package com.yjn.retrofitdemo.bean;

import java.util.List;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-09-12 15:14
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class AcctBalanceList {

    /**
     * remiders : [{"type":1,"acctResName":null,"formantText":"Your balance is too low, please top up."}]
     * summarys : [{"balanceType":1,"balance":"0","total":"0","consumeBal":"0","unitType":"MIN","displayTotalTxt":"0 MIN","displayConsumeTxt":"0 MIN","displayBalTxt":"0 MIN"},{"balanceType":2,"balance":"-0.00","total":"-0.00","consumeBal":"0.00","unitType":"MB","displayTotalTxt":"-0.00 MB","displayConsumeTxt":"0.00 MB","displayBalTxt":"-0.00 MB"},{"balanceType":3,"balance":"70","total":"100","consumeBal":"30","unitType":"TXT","displayTotalTxt":"100 TXT","displayConsumeTxt":"30 TXT","displayBalTxt":"70 TXT"}]
     * balanceList : [{"balanceType":0,"acctResName":"Kyats","balance":"246.80","total":"248.80","consumeBal":"-0.00","unitType":null,"updateDate":null,"effDate":"2016-04-28 15:04:11","expDate":null,"displayTotalTxt":"248.80","displayConsumeTxt":"-0.00","displayBalTxt":"246.80"},{"balanceType":3,"acctResName":"Bolt-ons SMS","balance":"70","total":"100","consumeBal":"30","unitType":"TXT","updateDate":null,"effDate":"2016-07-01 00:07:00","expDate":null,"displayTotalTxt":"100 TXT","displayConsumeTxt":"30 TXT","displayBalTxt":"70 TXT"}]
     */

    private List<RemidersBean> remiders;
    private List<SummarysBean> summarys;
    private List<BalanceListBean> balanceList;

    public void setRemiders(List<RemidersBean> remiders) {
        this.remiders = remiders;
    }

    public void setSummarys(List<SummarysBean> summarys) {
        this.summarys = summarys;
    }

    public void setBalanceList(List<BalanceListBean> balanceList) {
        this.balanceList = balanceList;
    }

    public List<RemidersBean> getRemiders() {
        return remiders;
    }

    public List<SummarysBean> getSummarys() {
        return summarys;
    }

    public List<BalanceListBean> getBalanceList() {
        return balanceList;
    }

    public static class RemidersBean {
        /**
         * type : 1
         * acctResName : null
         * formantText : Your balance is too low, please top up.
         */

        private int type;
        private Object acctResName;
        private String formantText;

        public void setType(int type) {
            this.type = type;
        }

        public void setAcctResName(Object acctResName) {
            this.acctResName = acctResName;
        }

        public void setFormantText(String formantText) {
            this.formantText = formantText;
        }

        public int getType() {
            return type;
        }

        public Object getAcctResName() {
            return acctResName;
        }

        public String getFormantText() {
            return formantText;
        }
    }

    public static class SummarysBean {
        /**
         * balanceType : 1
         * balance : 0
         * total : 0
         * consumeBal : 0
         * unitType : MIN
         * displayTotalTxt : 0 MIN
         * displayConsumeTxt : 0 MIN
         * displayBalTxt : 0 MIN
         */

        private int balanceType;
        private String balance;
        private String total;
        private String consumeBal;
        private String unitType;
        private String displayTotalTxt;
        private String displayConsumeTxt;
        private String displayBalTxt;

        public void setBalanceType(int balanceType) {
            this.balanceType = balanceType;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public void setConsumeBal(String consumeBal) {
            this.consumeBal = consumeBal;
        }

        public void setUnitType(String unitType) {
            this.unitType = unitType;
        }

        public void setDisplayTotalTxt(String displayTotalTxt) {
            this.displayTotalTxt = displayTotalTxt;
        }

        public void setDisplayConsumeTxt(String displayConsumeTxt) {
            this.displayConsumeTxt = displayConsumeTxt;
        }

        public void setDisplayBalTxt(String displayBalTxt) {
            this.displayBalTxt = displayBalTxt;
        }

        public int getBalanceType() {
            return balanceType;
        }

        public String getBalance() {
            return balance;
        }

        public String getTotal() {
            return total;
        }

        public String getConsumeBal() {
            return consumeBal;
        }

        public String getUnitType() {
            return unitType;
        }

        public String getDisplayTotalTxt() {
            return displayTotalTxt;
        }

        public String getDisplayConsumeTxt() {
            return displayConsumeTxt;
        }

        public String getDisplayBalTxt() {
            return displayBalTxt;
        }
    }

    public static class BalanceListBean {
        /**
         * balanceType : 0
         * acctResName : Kyats
         * balance : 246.80
         * total : 248.80
         * consumeBal : -0.00
         * unitType : null
         * updateDate : null
         * effDate : 2016-04-28 15:04:11
         * expDate : null
         * displayTotalTxt : 248.80
         * displayConsumeTxt : -0.00
         * displayBalTxt : 246.80
         */

        private int balanceType;
        private String acctResName;
        private String balance;
        private String total;
        private String consumeBal;
        private String unitType;
        private String updateDate;
        private String effDate;
        private String expDate;
        private String displayTotalTxt;
        private String displayConsumeTxt;
        private String displayBalTxt;

        public int getBalanceType() {
            return balanceType;
        }

        public void setBalanceType(int balanceType) {
            this.balanceType = balanceType;
        }

        public String getAcctResName() {
            return acctResName;
        }

        public void setAcctResName(String acctResName) {
            this.acctResName = acctResName;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getConsumeBal() {
            return consumeBal;
        }

        public void setConsumeBal(String consumeBal) {
            this.consumeBal = consumeBal;
        }

        public String getUnitType() {
            return unitType;
        }

        public void setUnitType(String unitType) {
            this.unitType = unitType;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getEffDate() {
            return effDate;
        }

        public void setEffDate(String effDate) {
            this.effDate = effDate;
        }

        public String getExpDate() {
            return expDate;
        }

        public void setExpDate(String expDate) {
            this.expDate = expDate;
        }

        public String getDisplayTotalTxt() {
            return displayTotalTxt;
        }

        public void setDisplayTotalTxt(String displayTotalTxt) {
            this.displayTotalTxt = displayTotalTxt;
        }

        public String getDisplayConsumeTxt() {
            return displayConsumeTxt;
        }

        public void setDisplayConsumeTxt(String displayConsumeTxt) {
            this.displayConsumeTxt = displayConsumeTxt;
        }

        public String getDisplayBalTxt() {
            return displayBalTxt;
        }

        public void setDisplayBalTxt(String displayBalTxt) {
            this.displayBalTxt = displayBalTxt;
        }
    }
}

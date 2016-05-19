package com.yjn.retrofitdemo.bean;

import java.util.List;

/**
 * Author:0027008122 [yang.jianan@zte.com.cn]
 * Date:2016-05-19
 * Time:10:01
 * Version:1.0
 * TaskId:
 */
public class CdrBean {
    @Override
    public String toString() {
        return "CdrBean{" +
                "voiceTotalCharge='" + voiceTotalCharge + '\'' +
                ", voiceTotalDuration='" + voiceTotalDuration + '\'' +
                ", dataTotalDuration='" + dataTotalDuration + '\'' +
                ", dataTotalCharge='" + dataTotalCharge + '\'' +
                ", dataTotalVolume='" + dataTotalVolume + '\'' +
                ", smsTotalCharge='" + smsTotalCharge + '\'' +
                ", voice=" + voice +
                ", data=" + data +
                ", sms=" + sms +
                '}';
    }

    /**
     * voiceTotalCharge : 0.00
     * voiceTotalDuration : 0
     * dataTotalDuration : 8775
     * dataTotalCharge : 10.70
     * dataTotalVolume : 2.10
     * smsTotalCharge : 0.00
     * voice : []
     * data : [{"startTime":"2016-03-01 00:00:00","durateion":"700","dataVolumn":"2048","charge":"8.66"},{"startTime":"2016-03-01 00:00:00","durateion":"300","dataVolumn":"0.098","charge":"0.00"},{"startTime":"2016-03-01 00:00:00","durateion":"6000","dataVolumn":"0","charge":"1.00"},{"startTime":"2016-03-01 00:00:00","durateion":"400","dataVolumn":"0.098","charge":"0.00"},{"startTime":"2016-03-01 00:00:00","durateion":"466","dataVolumn":"0","charge":"1.00"},{"startTime":"2016-03-01 00:00:00","durateion":"0","dataVolumn":"0.098","charge":"0.00"},{"startTime":"2016-03-01 00:00:00","durateion":"599","dataVolumn":"0","charge":"0.02"},{"startTime":"2016-03-01 00:00:00","durateion":"300","dataVolumn":"0.002","charge":"0.00"},{"startTime":"2016-03-01 00:00:00","durateion":"10","dataVolumn":"0","charge":"0.02"}]
     * sms : []
     */

    private String voiceTotalCharge;
    private String voiceTotalDuration;
    private String dataTotalDuration;
    private String dataTotalCharge;
    private String dataTotalVolume;
    private String smsTotalCharge;
    private List<?> voice;
    /**
     * startTime : 2016-03-01 00:00:00
     * durateion : 700
     * dataVolumn : 2048
     * charge : 8.66
     */

    private List<DataBean> data;
    private List<?> sms;

    public String getVoiceTotalCharge() {
        return voiceTotalCharge;
    }

    public void setVoiceTotalCharge(String voiceTotalCharge) {
        this.voiceTotalCharge = voiceTotalCharge;
    }

    public String getVoiceTotalDuration() {
        return voiceTotalDuration;
    }

    public void setVoiceTotalDuration(String voiceTotalDuration) {
        this.voiceTotalDuration = voiceTotalDuration;
    }

    public String getDataTotalDuration() {
        return dataTotalDuration;
    }

    public void setDataTotalDuration(String dataTotalDuration) {
        this.dataTotalDuration = dataTotalDuration;
    }

    public String getDataTotalCharge() {
        return dataTotalCharge;
    }

    public void setDataTotalCharge(String dataTotalCharge) {
        this.dataTotalCharge = dataTotalCharge;
    }

    public String getDataTotalVolume() {
        return dataTotalVolume;
    }

    public void setDataTotalVolume(String dataTotalVolume) {
        this.dataTotalVolume = dataTotalVolume;
    }

    public String getSmsTotalCharge() {
        return smsTotalCharge;
    }

    public void setSmsTotalCharge(String smsTotalCharge) {
        this.smsTotalCharge = smsTotalCharge;
    }

    public List<?> getVoice() {
        return voice;
    }

    public void setVoice(List<?> voice) {
        this.voice = voice;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<?> getSms() {
        return sms;
    }

    public void setSms(List<?> sms) {
        this.sms = sms;
    }

    public static class DataBean {
        private String startTime;
        private String durateion;
        private String dataVolumn;
        private String charge;

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getDurateion() {
            return durateion;
        }

        public void setDurateion(String durateion) {
            this.durateion = durateion;
        }

        public String getDataVolumn() {
            return dataVolumn;
        }

        public void setDataVolumn(String dataVolumn) {
            this.dataVolumn = dataVolumn;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }
    }
}

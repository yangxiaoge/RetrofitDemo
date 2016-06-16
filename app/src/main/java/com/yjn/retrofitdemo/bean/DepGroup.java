package com.yjn.retrofitdemo.bean;

import java.util.List;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-05-26 11:12
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class DepGroup {

    /**
     * offerGroupId : 1
     * offerGroupName : Group1
     * groupType : B
     * upperLimit : 100
     * lowerLimit : 10
     * offerList : [{"offerId":984,"score":null,"content":{"txtItemVars":[{"itemName":"OFFER_NAME","itemCode":"OFFER_NAME","itemValue":"Facebook 20M","seq":1}],"fileItemVars":[]},"verId":915,"offerType":"4"},{"offerId":980,"score":null,"content":{"txtItemVars":[{"itemName":"OFFER_NAME","itemCode":"OFFER_NAME","itemValue":"Txt and file","seq":1}],"fileItemVars":[{"fileFormat":"JPG","fileName":"92b62c5772ef3e8eca5e932149e7ede0.jpg","url":"/ztesoft/docker/upload/upload_inner/2016/05/18159/92b62c5772ef3e8eca5e932149e7ede0_20160516.jpg","height":null,"width":null,"seq":4}]},"verId":924,"offerType":"4"},{"offerId":997,"score":null,"content":{"txtItemVars":[{"itemName":"OFFER_NAME","itemCode":"OFFER_NAME","itemValue":"binating01","seq":1},{"itemName":"OFFER_DESC","itemCode":"OFFER_DESC","itemValue":"bianting01","seq":2},{"itemName":"OFFER_CHARGE","itemCode":"OFFER_CHARGE","itemValue":"0","seq":3}],"fileItemVars":[]},"verId":943,"offerType":"4"}]
     */

    private String offerGroupId;
    private String offerGroupName;
    private String groupType;
    private String upperLimit;
    private String lowerLimit;
    /**
     * offerId : 984
     * score : null
     * content : {"txtItemVars":[{"itemName":"OFFER_NAME","itemCode":"OFFER_NAME","itemValue":"Facebook 20M","seq":1}],"fileItemVars":[]}
     * verId : 915
     * offerType : 4
     */

    private List<OfferListBean> offerList;

    public String getOfferGroupId() {
        return offerGroupId;
    }

    public void setOfferGroupId(String offerGroupId) {
        this.offerGroupId = offerGroupId;
    }

    public String getOfferGroupName() {
        return offerGroupName;
    }

    public void setOfferGroupName(String offerGroupName) {
        this.offerGroupName = offerGroupName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(String lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public List<OfferListBean> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<OfferListBean> offerList) {
        this.offerList = offerList;
    }

    public static class OfferListBean {
        private int offerId;
        private Object score;
        private ContentBean content;
        private int verId;
        private String offerType;

        public int getOfferId() {
            return offerId;
        }

        public void setOfferId(int offerId) {
            this.offerId = offerId;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public int getVerId() {
            return verId;
        }

        public void setVerId(int verId) {
            this.verId = verId;
        }

        public String getOfferType() {
            return offerType;
        }

        public void setOfferType(String offerType) {
            this.offerType = offerType;
        }

        public static class ContentBean {
            /**
             * itemName : OFFER_NAME
             * itemCode : OFFER_NAME
             * itemValue : Facebook 20M
             * seq : 1
             */

            private List<TxtItemVarsBean> txtItemVars;
            private List<?> fileItemVars;

            public List<TxtItemVarsBean> getTxtItemVars() {
                return txtItemVars;
            }

            public void setTxtItemVars(List<TxtItemVarsBean> txtItemVars) {
                this.txtItemVars = txtItemVars;
            }

            public List<?> getFileItemVars() {
                return fileItemVars;
            }

            public void setFileItemVars(List<?> fileItemVars) {
                this.fileItemVars = fileItemVars;
            }

            public static class TxtItemVarsBean {
                private String itemName;
                private String itemCode;
                private String itemValue;
                private int seq;

                public String getItemName() {
                    return itemName;
                }

                public void setItemName(String itemName) {
                    this.itemName = itemName;
                }

                public String getItemCode() {
                    return itemCode;
                }

                public void setItemCode(String itemCode) {
                    this.itemCode = itemCode;
                }

                public String getItemValue() {
                    return itemValue;
                }

                public void setItemValue(String itemValue) {
                    this.itemValue = itemValue;
                }

                public int getSeq() {
                    return seq;
                }

                public void setSeq(int seq) {
                    this.seq = seq;
                }
            }
        }
    }
}

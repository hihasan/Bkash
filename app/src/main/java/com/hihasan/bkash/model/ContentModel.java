package com.hihasan.bkash.model;

public class ContentModel
{
    public String type,from_phn,trxid,datevalue,totalvalue;

    public ContentModel(String type, String from_phn, String trxid, String datevalue, String totalvalue){
        this.type=type;
        this.from_phn=from_phn;
        this.trxid=trxid;
        this.datevalue=datevalue;
        this.totalvalue=totalvalue;
    }

    public String getType() {
        return type;
    }

    public String getFrom_phn() {
        return from_phn;
    }

    public String getTrxid() {
        return trxid;
    }

    public String getDatevalue() {
        return datevalue;
    }

    public String getTotalvalue() {
        return totalvalue;
    }
}

package com.cit.hellocit.model;

import java.math.BigInteger;
import java.util.List;

public class Bill {
    private BigInteger idBill;
    private String date;
    private String status;
    private List<BillDetailsForm> billDetailsList;

    public BigInteger getIdBill() {
        return idBill;
    }

    public void setIdBill(BigInteger idBill) {
        this.idBill = idBill;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BillDetailsForm> getBillDetailsList() {
        return billDetailsList;
    }

    public void setBillDetailsList(List<BillDetailsForm> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }
}

package com.cit.hellocit.model;

import com.cit.hellocit.domain.Bill;

import java.math.BigInteger;

public class BillDetails {

    private BigInteger id;
    private  BigInteger number;
    private BigInteger idBill;

    private com.cit.hellocit.model.Bill bill;

    public BigInteger getIdBill() {
        return idBill;
    }

    public void setIdBill(BigInteger idBill) {
        this.idBill = idBill;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }


    public com.cit.hellocit.model.Bill getBill() {
        return bill;
    }

    public void setBill(com.cit.hellocit.model.Bill bill) {
        this.bill = bill;
    }
}

package com.cit.hellocit.domain;

import com.cit.hellocit.model.BillDetailsForm;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "billdetail")
public class BillDetails implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private  BigInteger id;
    private  BigInteger number;


    @ManyToOne
    @JoinColumn(name = "bill_id")
    private  Bill bill;

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

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillDetails that = (BillDetails) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        return getBill() != null ? getBill().equals(that.getBill()) : that.getBill() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getBill() != null ? getBill().hashCode() : 0);
        return result;
    }

    public BillDetailsForm toBillDetailsForm(){
        BillDetailsForm rs = new BillDetailsForm();
        rs.setNumber(number);
        return rs;
    }
}

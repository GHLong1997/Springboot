package com.cit.hellocit.model;

import com.cit.hellocit.domain.Bill;
import com.cit.hellocit.domain.BillDetails;
import com.cit.hellocit.domain.BillDetails_;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class BillDetailsForm {

    @NotNull
    private  BigInteger number;

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }

    public BillDetails toEntity(Bill bill) {
        BillDetails billDetails = new BillDetails();
        billDetails.setNumber(number);
        billDetails.setBill(bill);

        return billDetails;
    }

}

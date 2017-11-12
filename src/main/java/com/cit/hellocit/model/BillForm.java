package com.cit.hellocit.model;



import com.cit.hellocit.domain.BillDetails;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BillForm {

    @NotBlank
    private String date;
    @NotBlank
    private String status;
    @NotEmpty
    private List<BillDetailsForm> billDetailsList;

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

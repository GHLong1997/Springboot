package com.cit.hellocit.domain;

import com.cit.hellocit.model.BillDetailsForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="bill")
public class Bill {

    @Id
    @GeneratedValue
    @Column(name = "bill_id")
    private BigInteger id;
    private String date;
    private  String status;

    @OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BillDetails> billDetailsList;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public List<BillDetails> getBillDetailsList() {
        return billDetailsList;
    }

    public void setBillDetailsList(List<BillDetails> billDetailsList) {
        this.billDetailsList = billDetailsList;
    }

    public com.cit.hellocit.model.Bill toModel(){
        com.cit.hellocit.model.Bill rs = new com.cit.hellocit.model.Bill();
        rs.setIdBill(id);
        rs.setDate(date);
        rs.setStatus(status);
        rs.setBillDetailsList(getBillDetailsList().stream().map(BillDetails::toBillDetailsForm).collect(Collectors.toList()));
        return  rs;
    }
    public void setBillDetailForm (List<BillDetailsForm> detailsFormList){
        billDetailsList.clear();
        if(!CollectionUtils.isEmpty(detailsFormList)){
            for (int i =0;i<detailsFormList.size();i++){
                BillDetailsForm billDetailsForm = detailsFormList.get(i);
                BillDetails billDetails = new BillDetails();
                billDetails.setNumber(billDetailsForm.getNumber());
                billDetailsList.add(billDetails);
            }

        }
    }
    @Override
    public String toString(){
        String result = String.format("Bill[id=%d, date='%s', status='%s']%n",id,date,status);
        if(billDetailsList!=null){
            for(BillDetails billDetails: billDetailsList){
                result+= String.format("BillDetails[id=%d, number='%d']%n",billDetails.getId(),billDetails.getNumber());
            }
        }
        return  result;
    }


}

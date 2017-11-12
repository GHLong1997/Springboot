package com.cit.hellocit.service;


import com.cit.hellocit.model.BillDetailsForm;
import com.cit.hellocit.domain.BillDetails;
import com.cit.hellocit.repository.BillDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class BillDetailsService {

    private  final BillDetailsRepository billDetailsRepository;

    @Autowired
    public BillDetailsService(BillDetailsRepository billDetailsRepository){
        this.billDetailsRepository = billDetailsRepository;
    }


    public List<BillDetails> getAll(){
        return billDetailsRepository.findAll();
    }

    public BillDetails create(BillDetailsForm form){
        BillDetails rs = new BillDetails();
        rs.setNumber(form.getNumber());


        return billDetailsRepository.save(rs);
    }


    public BillDetails get(BigInteger id){
        return billDetailsRepository.findOne(id);
    }

    public void delete(BigInteger id){
        billDetailsRepository.delete(id);
    }
}

package com.cit.hellocit.controller;

import com.cit.hellocit.domain.BillDetails;
import com.cit.hellocit.model.BillDetailsForm;
import com.cit.hellocit.repository.BillDetailsRepository;
import com.cit.hellocit.service.BillDetailsService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


import java.util.List;

@RestController
@RequestMapping("/billdetail")
public class BillDetailsController {
    private final BillDetailsService billDetailsService;
    private final BillDetailsRepository billDetailsRepository;

    public  BillDetailsController(BillDetailsService billDetailsService ,BillDetailsRepository billDetailsRepository){
        this.billDetailsRepository = billDetailsRepository;
        this.billDetailsService = billDetailsService;
    }


    /**
     * GET ALL
     */
    @GetMapping
    public List<BillDetails> getAll(){
        return billDetailsService.getAll();
    }

    /**
     * CREATE
     */


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public BillDetails create(@RequestBody BillDetailsForm form){
        return billDetailsService.create(form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id){
        billDetailsService.delete(id);
    }

    @GetMapping("/{id}")
    public BillDetails findProductById(@PathVariable BigInteger id) {
        return billDetailsService.get(id);
    }


}

package com.cit.hellocit.controller;

import com.cit.hellocit.domain.Bill;
import com.cit.hellocit.model.BillForm;
import com.cit.hellocit.repository.BillRepository;

import com.cit.hellocit.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.math.BigInteger;
import java.util.List;
//1
@RestController
@RequestMapping("/bill")
public class BillController {
    private final BillService billService;
    private final BillRepository billRepository;

    @Autowired
    public BillController(BillService billService, BillRepository billRepository) {
        this.billService = billService;
        this.billRepository = billRepository;
    }

//    @GetMapping
//    public  PagingObject<com.cit.hellocit.model.Bill> getAllBills(@RequestParam(defaultValue = "0") Integer page,
//                                                                  @RequestParam(defaultValue = "8") Integer size){
//        return  billService.getAllBills(page, size);
//    }

    @GetMapping
    public  PagingObject<com.cit.hellocit.model.Bill> getAllBills(org.springframework.data.domain.Pageable pageable,@RequestParam String status){
        return  billService.getAllBills(pageable,status);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/a")
    public List<com.cit.hellocit.model.Bill> getAll(){
        return billService.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE ,value = "/{id}")
    public void delete(@PathVariable BigInteger id){
       billService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Bill create(@RequestBody BillForm form){
        return billService.create(form);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
    private  Bill update(@RequestBody BillForm form , @PathVariable BigInteger id){
        return billService.update(form, id);
    }
    @GetMapping("/dataTest")
    public void insertDataTest() {
        billService.insertDataTest();
    }



//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable BigInteger id){
//        billService.delete(id);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Bill findProductById(@PathVariable BigInteger id) {
        return billService.get(id);
    }
}

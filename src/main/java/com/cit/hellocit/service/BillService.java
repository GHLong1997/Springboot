package com.cit.hellocit.service;


import com.cit.hellocit.controller.PagingObject;
import com.cit.hellocit.domain.Bill;
import com.cit.hellocit.domain.BillDetails;
import com.cit.hellocit.domain.Bill_;
import com.cit.hellocit.model.BillForm;
import com.cit.hellocit.repository.BillDetailsRepository;
import com.cit.hellocit.repository.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BillService {

    private final BillRepository billRepository;


    @Autowired
    private BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    public PagingObject<com.cit.hellocit.model.Bill> getAllBills(Pageable pageable,String status) {
        log.info("Paging " + pageable);
//        log.info("Paging size " + size + "/Page: " + page);
//        if (size > 500) size = 20;
//        PageRequest pageRequest = new PageRequest(page, size);
        if (pageable.getPageSize() > 500) throw  new RuntimeException();

//        Page<Bill> billPage = billRepository.findAll(pageable);
        Page<Bill> billPage = billRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            Predicate statusPredicate = criteriaBuilder.like(root.get(Bill_.status), "%" + status + "%");
            return  statusPredicate;
        },pageable);
        PagingObject<com.cit.hellocit.model.Bill> rs = new PagingObject<>();
        rs.setTotal(billPage.getTotalElements());
        rs.setTotalPage(billPage.getTotalPages());
        rs.setData(billPage.getContent().stream().map(Bill::toModel).collect(Collectors.toList()));
        return rs;

    }

    public List<com.cit.hellocit.model.Bill> getAll() {
        List<com.cit.hellocit.model.Bill> rs = new ArrayList<>();
        this.billRepository.findAll().forEach(bill -> {
            rs.add(bill.toModel());
        });


        return rs;
    }

    public Bill create(BillForm form) {
        Bill rs = new Bill();
        rs.setDate(form.getDate());
        rs.setStatus(form.getStatus());
        rs.setBillDetailsList(form.getBillDetailsList().stream().map(bf -> bf.toEntity(rs)).collect(Collectors.toList()));
        billRepository.save(rs);
        return rs;
    }


    public com.cit.hellocit.domain.Bill get(BigInteger id) {
        return billRepository.findOne(id);
    }

    public void delete(BigInteger id) {

        billRepository.delete(id);
    }


    public void insertDataTest() {
        for (long i = 0; i < 501; i++) {
            Bill s = new Bill();
            s.setDate("12/12/12");
            s.setStatus("chua"+i);
            billRepository.save(s);
        }
    }

    public Bill update(BillForm form, BigInteger id) {
        Bill rs = billRepository.findOne(id);
        rs.setDate(form.getDate());
        rs.setStatus(form.getStatus());
        rs.setBillDetailsList(form.getBillDetailsList().stream().map(bf -> bf.toEntity(rs)).collect(Collectors.toList()));
        billRepository.save(rs);
        return  rs;

    }


}

package com.cit.hellocit.repository;


import com.cit.hellocit.domain.Bill;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;


public interface BillRepository extends JpaRepository<Bill,BigInteger>,JpaSpecificationExecutor<Bill> {
////    com.cit.hellocit.model.Bill update( com.cit.hellocit.model.Bill bill , BigInteger bigInteger);
//     com.cit.hellocit.model.Bill findOne1(BigInteger integer);

    Page<Bill> findById(BigInteger id,  Pageable pageable);


}

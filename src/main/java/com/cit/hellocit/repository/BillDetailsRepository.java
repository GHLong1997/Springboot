package com.cit.hellocit.repository;


import com.cit.hellocit.domain.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BillDetailsRepository extends JpaRepository<BillDetails,BigInteger> {
}

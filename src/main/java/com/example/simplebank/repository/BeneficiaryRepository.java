package com.example.simplebank.repository;

import com.example.simplebank.model.Beneficiary;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Long> {
    Beneficiary findBeneficiaryByName(String name);
}

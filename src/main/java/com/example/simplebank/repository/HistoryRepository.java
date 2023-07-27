package com.example.simplebank.repository;

import com.example.simplebank.model.OperationDesc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends CrudRepository<OperationDesc, Long> {

    OperationDesc save(OperationDesc operationDesc);

    @Query(
            value = "select * from operation_desc where initiator_account_id = :accountId or recipient_account_id = :accountId",
            nativeQuery = true
    )
    List<OperationDesc> findAllOperationByAccountId(@Param("accountId")Long accountId);
}

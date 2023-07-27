package com.example.simplebank.repository;

import com.example.simplebank.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account save(Account account);


    List<Account> findAll();

    Account findAccountById(Long id);

    @Modifying(clearAutomatically = true)
    @Query("update Account account set account.balance = account.balance + :value where account.id = :id")
    void addMoney(@Param("id") Long accountId, @Param("value") Long value);

    @Modifying(clearAutomatically = true)
    @Query("update Account account set account.balance = account.balance - :value where account.id = :id")
    void withdrawMoney(@Param("id") Long accountId, @Param("value") Long value);
}

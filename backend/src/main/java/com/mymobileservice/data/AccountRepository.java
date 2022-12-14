package com.mymobileservice.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mymobileservice.beans.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

    @Transactional(timeout = 1)
    public Optional<Account> findByEmailLike(String email);

    @Transactional(timeout = 2)
    @Query(value="select * from account a where a.id = :id",
       nativeQuery = true )
    public Account findMyId(@Param("id") int id);

    @Transactional(timeout = 2)
    @Modifying
    @Query(value="update account a set a.balance = :balance, a.phoneBal = :phoneBal where a.id = :id",
       nativeQuery = true )
    public void makeBill(@Param("id") int id, @Param("balance") double balance, @Param("phoneBal") double phoneBal);

}

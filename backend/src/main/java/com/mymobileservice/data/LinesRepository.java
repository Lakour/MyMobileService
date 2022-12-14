package com.mymobileservice.data;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mymobileservice.beans.Lines;

@Repository
public interface LinesRepository extends JpaRepository<Lines, Integer>{

    @Transactional(timeout = 2)
    @Query(value = "select * from phoneline p where p.phonenumber = :number",
        nativeQuery=true)
    public List<Lines> findByNumberLike(@Param("number") String number);
    
    @Transactional(timeout = 2)
    @Query(value = "select * from phoneline p where p.accountid = :account",
        nativeQuery=true)
    public List<Lines> findByAccountIdLike(@Param("account") int accountid);

    @Transactional(timeout = 2)
    @Modifying
    @Query(value = "update phoneline p set p.plan = :newplan where p.phonenumber = :phonenumber",
    nativeQuery = true)
    public void updatePlan(@Param("newplan") int newplan,@Param("phonenumber") String phonenumber);

    @Transactional(timeout = 2)
    @Modifying
    @Query(value = "update phoneline p set p.phoneid = :newphone where p.phonenumber = :phonenumber",
    nativeQuery = true)
    public void updatePhone(@Param("newphone") double phoneid,@Param("phonenumber") String phonenumber);

    @Transactional(timeout = 2)
    @Modifying
    @Query(value = "delete from phoneline p where p.phonenumber = :phonenumber",
    nativeQuery = true)
    public void deleteByPhonenumber(String phonenumber);
    
}

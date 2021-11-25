package com.topicosplmspagoelectronico.repository;


import com.topicosplmspagoelectronico.bean.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}


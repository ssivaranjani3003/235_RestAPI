package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.RepairShop;

@Repository
public interface RepairShopRepository extends JpaRepository<RepairShop, Long> {

    List<RepairShop> findByName(String name);
    // Find repair shops with amount greater than a given value
    @Query("SELECT r FROM RepairShop r WHERE r.amount > :minAmount")
    List<RepairShop> findByAmountGreaterThan(@Param("minAmount") Long minAmount);

    // Find repair shops with amount less than a given value
    @Query("SELECT r FROM RepairShop r WHERE r.amount < :maxAmount")
    List<RepairShop> findByAmountLessThan(@Param("maxAmount") Long maxAmount);

    // Find repair shops within a range of amounts
    @Query("SELECT r FROM RepairShop r WHERE r.amount BETWEEN :minAmount AND :maxAmount")
    List<RepairShop> findByAmountRange(@Param("minAmount") Long minAmount, @Param("maxAmount") Long maxAmount);
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.RepairShop;
import com.example.demo.Repository.RepairShopRepository;

@Service
public class RepairShopService {

    @Autowired
    private RepairShopRepository repairShopRepository;

    public RepairShop createRepairShop(RepairShop repairShop) {
        return repairShopRepository.save(repairShop);
    }

    public List<RepairShop> getAllRepairShops() {
        return repairShopRepository.findAll();
    }

    public void deleteRepairShop(Long id) {
        repairShopRepository.deleteById(id);
    }

    public RepairShop updateRepairShop(Long id, RepairShop updatedRepairShop) {
        Optional<RepairShop> existingRepairShopOpt = repairShopRepository.findById(id);
        if (existingRepairShopOpt.isPresent()) {
            RepairShop existingRepairShop = existingRepairShopOpt.get();
            existingRepairShop.setName(updatedRepairShop.getName());
            existingRepairShop.setLocation(updatedRepairShop.getLocation());
            return repairShopRepository.save(existingRepairShop);
        } else {
            throw new IllegalArgumentException("Repair Shop not found with ID: " + id);
        }
    }

    // Custom JPQL Queries
    public List<RepairShop> getRepairShopsByMinAmount(Long minAmount) {
        return repairShopRepository.findByAmountGreaterThan(minAmount);
    }

    public List<RepairShop> getRepairShopsByMaxAmount(Long maxAmount) {
        return repairShopRepository.findByAmountLessThan(maxAmount);
    }

    public List<RepairShop> getRepairShopsByAmountRange(Long minAmount, Long maxAmount) {
        return repairShopRepository.findByAmountRange(minAmount, maxAmount);
    }
}

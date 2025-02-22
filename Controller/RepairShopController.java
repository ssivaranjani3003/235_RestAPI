package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.RepairShop;
import com.example.demo.service.RepairShopService;

@RestController
@RequestMapping("/repairShops")
public class RepairShopController {

    @Autowired
    private RepairShopService repairShopService;

    @PostMapping
    public RepairShop createRepairShop(@RequestBody RepairShop repairShop) {
        return repairShopService.createRepairShop(repairShop);
    }

    @GetMapping
    public List<RepairShop> getAllRepairShops() {
        return repairShopService.getAllRepairShops();
    }

    @PutMapping("/{id}")
    public RepairShop updateRepairShop(@PathVariable Long id, @RequestBody RepairShop updatedRepairShop) {
        return repairShopService.updateRepairShop(id, updatedRepairShop);
    }

    @DeleteMapping("/{id}")
    public String deleteRepairShop(@PathVariable Long id) {
        repairShopService.deleteRepairShop(id);
        return "Repair Shop with ID " + id + " has been deleted.";
    }

    // Get Repair Shops with Amount Greater Than
    @GetMapping("/amount/min/{minAmount}")
    public List<RepairShop> getRepairShopsByMinAmount(@PathVariable Long minAmount) {
        return repairShopService.getRepairShopsByMinAmount(minAmount);
    }

    // Get Repair Shops with Amount Less Than
    @GetMapping("/amount/max/{maxAmount}")
    public List<RepairShop> getRepairShopsByMaxAmount(@PathVariable Long maxAmount) {
        return repairShopService.getRepairShopsByMaxAmount(maxAmount);
    }

    // Get Repair Shops by Amount Range
    @GetMapping("/amount/range/{minAmount}/{maxAmount}")
    public List<RepairShop> getRepairShopsByAmountRange(@PathVariable Long minAmount, @PathVariable Long maxAmount) {
        return repairShopService.getRepairShopsByAmountRange(minAmount, maxAmount);
    }
}

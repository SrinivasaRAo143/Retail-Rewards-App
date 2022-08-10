package com.retail.rewards.RetailRewardsApp.service;

import com.retail.rewards.RetailRewardsApp.model.Purchase;
import com.retail.rewards.RetailRewardsApp.repo.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseService {
    private PurchaseRepository purchaseRepository;

    public Purchase savePurchase(Purchase purchase) {
        return this.purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return this.purchaseRepository.findAll();
    }

    public Optional<Purchase> retrievePurchases(Integer purchaseId) {
        return this.purchaseRepository.findById(purchaseId);
    }

    public List<Purchase>  retrievePurchasesByCustomerId(Integer customerId){
        return this.purchaseRepository.findAllByCustomerId(customerId);
    }

    public List<Purchase>  getPurchasesOfCustomer(Integer customerId, Integer minusMonths){
        ZonedDateTime startDate = ZonedDateTime.now().minusMonths(minusMonths);
        return this.purchaseRepository.findAllByCustomerIdAndDateGreaterThan(customerId, Date.from(startDate.toInstant()));
    }


}

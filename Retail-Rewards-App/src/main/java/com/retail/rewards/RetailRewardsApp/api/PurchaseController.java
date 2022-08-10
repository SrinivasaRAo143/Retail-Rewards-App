package com.retail.rewards.RetailRewardsApp.api;

import com.retail.rewards.RetailRewardsApp.model.Purchase;
import com.retail.rewards.RetailRewardsApp.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@AllArgsConstructor
public class PurchaseController {
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase>  recordPurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(this.purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }


}

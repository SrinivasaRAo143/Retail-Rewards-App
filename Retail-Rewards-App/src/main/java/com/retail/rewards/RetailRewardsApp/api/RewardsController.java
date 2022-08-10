package com.retail.rewards.RetailRewardsApp.api;

import com.retail.rewards.RetailRewardsApp.model.Rewards;
import com.retail.rewards.RetailRewardsApp.service.RewardsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
@AllArgsConstructor
public class RewardsController {
    private RewardsService rewardsService;

    @GetMapping("/{customerId}")
    public Rewards getCustomerRewards(@PathVariable("customerId") Integer customerId) throws Exception {
        return  this.rewardsService.calculateRewards(customerId);
    }
}


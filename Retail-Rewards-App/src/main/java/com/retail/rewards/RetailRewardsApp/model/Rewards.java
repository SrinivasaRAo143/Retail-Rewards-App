package com.retail.rewards.RetailRewardsApp.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class Rewards {
    private Integer customerId;
    private String customerName;
    private List<Purchase> purchases;
    Map<Integer,Integer> monthWiseRewards;
    Integer totalRewards;
}

package com.retail.rewards.RetailRewardsApp.repo;

import com.retail.rewards.RetailRewardsApp.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface PurchaseRepository  extends JpaRepository<Purchase,Integer> {

    List<Purchase> findAllByCustomerId(Integer customerId);

    @Query("SELECT p from Purchase p where p.customerId =?1  AND p.transactionDate > ?2")
    List<Purchase> findAllByCustomerIdAndDateGreaterThan(Integer customerId, Date startOfDate);
}

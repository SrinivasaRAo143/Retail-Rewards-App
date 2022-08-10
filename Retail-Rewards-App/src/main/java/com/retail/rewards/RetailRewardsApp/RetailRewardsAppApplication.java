package com.retail.rewards.RetailRewardsApp;

import com.retail.rewards.RetailRewardsApp.model.Customer;
import com.retail.rewards.RetailRewardsApp.model.Purchase;
import com.retail.rewards.RetailRewardsApp.repo.CustomerRepository;
import com.retail.rewards.RetailRewardsApp.repo.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@SpringBootApplication
public class RetailRewardsAppApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	public static void main(String[] args) {
		SpringApplication.run(RetailRewardsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer=new Customer();
		customer.setName("Srinivas");
		customer=this.customerRepository.save(customer);
		for(int i=0; i < 1500; i++){
			Purchase purchase=new Purchase();
			purchase.setAmount(Double.valueOf(45+i));
			purchase.setCustomerId(customer.getId());
			LocalDate transDate=LocalDate.now().minus(i, ChronoUnit.DAYS);
			purchase.setTransactionDate(Date.from(transDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			this.purchaseRepository.save(purchase);
		}
	}
}

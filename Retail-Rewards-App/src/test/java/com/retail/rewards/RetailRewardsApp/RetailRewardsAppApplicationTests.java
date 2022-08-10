package com.retail.rewards.RetailRewardsApp;

import com.retail.rewards.RetailRewardsApp.model.Customer;
import com.retail.rewards.RetailRewardsApp.model.Purchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RetailRewardsAppApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    Integer customerId;

    @BeforeEach
    public void createCustomer() {
        String customerURL = "http://localhost:" + port + "/customers";
        Customer customer = new Customer();
        customer.setName("testCustomer");
        ResponseEntity<Customer> objCustomer = restTemplate.postForEntity(customerURL, customer, Customer.class);
        this.customerId = objCustomer.getBody().getId();
    }


    @Test
    public void recordPurchase_RetrievePurchase() {
        String purchaseURL = "http://localhost:" + port + "/purchases";
        Purchase purchase = new Purchase();
        //  purchase.setTransactionDate(Calendar.getInstance().getTime());
        purchase.setCustomerId(customerId);
        purchase.setAmount(Double.valueOf(150));
        ResponseEntity<Purchase> purchaseEntity =
                restTemplate.postForEntity(purchaseURL, purchase, Purchase.class);
        assertThat(purchaseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        String customerURL = "http://localhost:" + port + "/customers/" + this.customerId;
        Customer customer = restTemplate.getForObject(customerURL, Customer.class);
        Assertions.assertTrue(customer.getPurchase().size() == 1);
    }

}

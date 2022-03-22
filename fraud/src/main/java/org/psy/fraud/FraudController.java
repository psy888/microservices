package org.psy.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.psy.clients.fraud.FraudCheckResponse;
import org.psy.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController
{
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") final Long customerId)
    {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("Check is fraud for customer ID={}",customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}



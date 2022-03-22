package org.psy.fraud.service;

import lombok.AllArgsConstructor;
import org.psy.fraud.model.FraudCheckHistory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(final Long customerId)
    {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
        .customerId(customerId)
        .createdAt(LocalDateTime.now())
        .isFraudster(false)
        .build());
        return false;
    }
}

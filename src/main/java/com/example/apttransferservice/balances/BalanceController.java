package com.example.apttransferservice.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/balance")
public class BalanceController {
    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService){
        this.balanceService = balanceService;
    }

    @GetMapping
    public List<Balance> getBalances() {
        return balanceService.getBalances();
    }

    @GetMapping(path = "{account_nr}")
    public Double getBalance(@PathVariable("account_nr") String account_nr) {
        return balanceService.getBalance(account_nr);
    }

}

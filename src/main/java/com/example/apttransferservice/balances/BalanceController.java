package com.example.apttransferservice.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/balance")
public class BalanceController {
    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService){
        this.balanceService = balanceService;
    }

    @GetMapping(path = "/")
    public List<Balance> getBalances() {
        return balanceService.getBalances();
    }

    @GetMapping
    public Double getBalance(@RequestParam String account_nr) {
        return balanceService.getBalance(account_nr);
    }

}

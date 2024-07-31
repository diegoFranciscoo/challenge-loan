package com.chalellenge.loans.controller;

import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.ResponseDTO;
import com.chalellenge.loans.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<ResponseDTO> getLoans(@RequestBody CostumerDTO costumerDTO){
        return new ResponseEntity<>(loanService.getLoans(costumerDTO), HttpStatus.OK);
    }
}

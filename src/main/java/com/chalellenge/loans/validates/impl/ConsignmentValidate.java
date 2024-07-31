package com.chalellenge.loans.validates.impl;

import com.chalellenge.loans.enums.LoansType;
import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.LoanDTO;
import com.chalellenge.loans.validates.ValidateLoans;
import org.springframework.stereotype.Component;

@Component
public class ConsignmentValidate implements ValidateLoans {

    @Override
    public LoanDTO validate(CostumerDTO costumerDTO) {
        if (costumerDTO.income() >= 5000) {
            return new LoanDTO(LoansType.CONSIGNMENT, 2);
        }
        return null;
    }
}

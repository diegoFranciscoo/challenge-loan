package com.chalellenge.loans.validates.impl;

import com.chalellenge.loans.enums.LoansType;
import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.LoanDTO;
import com.chalellenge.loans.validates.ValidateLoans;
import org.springframework.stereotype.Component;

@Component
public class PersonalValidate implements ValidateLoans {
    @Override
    public LoanDTO validate(CostumerDTO costumerDTO) {
        if (costumerDTO.income() <= 3000) {
            return new LoanDTO(LoansType.PERSONAL, 4);
        }
        if (costumerDTO.income() >= 3000 && costumerDTO.income() <= 5000 &&
                costumerDTO.age() < 30 && costumerDTO.location().equalsIgnoreCase("SP")) {
            return new LoanDTO(LoansType.PERSONAL, 4);
        }
        return null;
    }
}

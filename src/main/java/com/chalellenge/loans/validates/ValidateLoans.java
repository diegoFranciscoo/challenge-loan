package com.chalellenge.loans.validates;

import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.LoanDTO;

public interface ValidateLoans {
    public LoanDTO validate(CostumerDTO costumerDTO);
}

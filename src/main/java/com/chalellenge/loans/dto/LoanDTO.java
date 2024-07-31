package com.chalellenge.loans.dto;

import com.chalellenge.loans.enums.LoansType;

public record LoanDTO(LoansType type, Integer interestRate) {
}

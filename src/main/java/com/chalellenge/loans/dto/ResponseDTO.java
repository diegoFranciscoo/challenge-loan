package com.chalellenge.loans.dto;

import java.util.List;

public record ResponseDTO(String costumer, List<LoanDTO> loans) {
}

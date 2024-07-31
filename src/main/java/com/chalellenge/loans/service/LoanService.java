package com.chalellenge.loans.service;

import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.LoanDTO;
import com.chalellenge.loans.dto.ResponseDTO;
import com.chalellenge.loans.validates.ValidateLoans;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final List<ValidateLoans> validates;

    public ResponseDTO getLoans(CostumerDTO costumerDTO) {

        List<LoanDTO> list = validates.stream()
                .map(validate -> validate.validate(costumerDTO))
                .filter(Objects::nonNull)
                .toList();


        return new ResponseDTO(costumerDTO.name(), list);
    }
}

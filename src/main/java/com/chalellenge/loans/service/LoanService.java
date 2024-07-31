package com.chalellenge.loans.service;

import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.LoanDTO;
import com.chalellenge.loans.dto.ResponseDTO;
import com.chalellenge.loans.validates.ValidateLoans;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {
    private List<ValidateLoans> validates;

    public ResponseDTO getLoans(CostumerDTO costumerDTO) {
        List<LoanDTO> loans = new ArrayList<>();

        for (ValidateLoans validateLoans : validates) {
            LoanDTO validate = validateLoans.validate(costumerDTO);
            if (validate != null) {
                loans.add(validate);
            }
        }

        return new ResponseDTO(costumerDTO.name(), loans);
    }
}

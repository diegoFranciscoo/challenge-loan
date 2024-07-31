package com.chalellenge.loans.service;

import com.chalellenge.loans.dto.CostumerDTO;
import com.chalellenge.loans.dto.LoanDTO;
import com.chalellenge.loans.dto.ResponseDTO;
import com.chalellenge.loans.enums.LoansType;
import com.chalellenge.loans.validates.ValidateLoans;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class LoanServiceTest {
    @InjectMocks
    private LoanService loanService;
    @Mock
    private ValidateLoans validates;


    @BeforeEach
    void setUp() {
        loanService = new LoanService(List.of(validates));
    }

    @Test
    @DisplayName("getLoans should return list of loans with type CONSIGNMENT when successfully")
    void getLoans_ReturnListLoansTypeCONSIGNMENT_WhenSuccessfully() {
        var newCostumer = new CostumerDTO(20, "123.456.234-12", "testing", 7000D, "SP");
        var loanDTO = List.of(new LoanDTO(LoansType.CONSIGNMENT, 4));

        when(validates.validate(newCostumer)).thenReturn(loanDTO.getFirst());
        ResponseDTO response = loanService.getLoans(newCostumer);

        assertNotNull(response);
        assertEquals(loanDTO.getFirst().type(), response.loans().getFirst().type());
        assertEquals(1, response.loans().size());
    }

    @Test
    @DisplayName("getLoans should return list of loans with types CONSIGNMENT, GUARANTEED, PERSONAL when successfully ")
    void getLoans_ReturnListLoansTypesConsignmentGuaranteedPersonal_WhenSuccessfully() {
        var newCostumer = new CostumerDTO(20, "123.456.234-12", "testing", 5000D, "SP");
        var loanDTO = List.of(
                new LoanDTO(LoansType.CONSIGNMENT, 4),
                new LoanDTO(LoansType.GUARANTEED, 3),
                new LoanDTO(LoansType.PERSONAL, 4)
        );

        when(validates.validate(newCostumer)).thenReturn(loanDTO.get(2));
        ResponseDTO response = loanService.getLoans(newCostumer);

        assertNotNull(response);
        assertEquals(loanDTO.get(2).type(), response.loans().getFirst().type());
        assertEquals(1, response.loans().size());
    }
}
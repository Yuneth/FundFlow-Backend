package com.FundFlow.controller;

import com.FundFlow.dto.*;
import com.FundFlow.entity.LoanApplication;
import com.FundFlow.entity.User;
import com.FundFlow.service.LoanService;
import com.FundFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/loans")
//@CrossOrigin(origins = "http://localhost:3000")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping
    public ResponseEntity<LoanApplicationResponse> applyLoan(@RequestBody LoanApplicationDto dto, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        LoanApplication loan = loanService.applyForLoan(dto, user);
        return ResponseEntity.ok(toDto(loan));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/my")
    public ResponseEntity<List<LoanApplicationResponse>> getOwnLoans(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<LoanApplication> loans = loanService.getLoansByUser(user);
        return ResponseEntity.ok(loans.stream().map(this::toDto).collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<LoanApplicationResponse>> getAllLoans() {
        List<LoanApplication> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans.stream().map(this::toDto).collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/status")
    public ResponseEntity<LoanApplicationResponse> updateStatus(
            @PathVariable Long id,
            @RequestBody LoanStatusUpdateRequest request) {

        LoanApplication loan = loanService.updateLoanStatus(id, request.getStatus());
        return ResponseEntity.ok(toDto(loan));
    }

    private LoanApplicationResponse toDto(LoanApplication loan) {
        LoanApplicationResponse dto = new LoanApplicationResponse();
        dto.setId(loan.getId());
        dto.setLoanAmount(loan.getLoanAmount());
        dto.setDurationMonths(loan.getDurationMonths());
        dto.setPurpose(loan.getPurpose());
        dto.setMonthlyIncome(loan.getMonthlyIncome());
        dto.setExistingLoans(loan.getExistingLoans());
        dto.setScore(loan.getScore());
        dto.setStatus(loan.getStatus());
        dto.setRecommendation(loan.getRecommendation());
        dto.setAppliedAt(loan.getAppliedAt());
        dto.setUsername(loan.getUser().getUsername());
        return dto;
    }
}

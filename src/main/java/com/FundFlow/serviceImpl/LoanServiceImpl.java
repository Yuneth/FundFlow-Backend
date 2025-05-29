package com.FundFlow.serviceImpl;

import com.FundFlow.dto.LoanApplicationDto;
import com.FundFlow.entity.LoanApplication;
import com.FundFlow.entity.User;
import com.FundFlow.repository.LoanApplicationRepository;
import com.FundFlow.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanApplicationRepository loanRepo;

    @Override
    public LoanApplication applyForLoan(LoanApplicationDto dto, User user) {
        LoanApplication loan = new LoanApplication();
        loan.setLoanAmount(dto.getLoanAmount());
        loan.setDurationMonths(dto.getDurationMonths());
        loan.setPurpose(dto.getPurpose());
        loan.setMonthlyIncome(dto.getMonthlyIncome());
        loan.setExistingLoans(dto.getExistingLoans());
        loan.setAppliedAt(LocalDateTime.now());
        loan.setUser(user);

        // Scoring Logic
        int score = 0;
        double emi = dto.getLoanAmount() / dto.getDurationMonths();

        if (emi <= 0.4 * dto.getMonthlyIncome()) score += 30;
        if (dto.getExistingLoans() <= 2) score += 20;
        if (dto.getLoanAmount() < 100000) score += 20;

        // Dummy creditScore impact
        if (user.getRole().name().equals("CUSTOMER")) score += 20;

        String status = score >= 70 ? "Approved" : "Rejected";
        String recommendation = status.equals("Approved") ?
                "Eligible for " + dto.getDurationMonths() + " months at 14% interest" :
                "Loan not approved. Improve eligibility.";

        loan.setScore(score);
        loan.setStatus(status);
        loan.setRecommendation(recommendation);

        return loanRepo.save(loan);
    }

    @Override
    public List<LoanApplication> getLoansByUser(User user) {
        return loanRepo.findByUser(user);
    }

    @Override
    public List<LoanApplication> getAllLoans() {
        return loanRepo.findAll();
    }

    @Override
    public LoanApplication updateLoanStatus(Long id, String status) {
        LoanApplication loan = loanRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setStatus(status);
        loan.setRecommendation(status.equals("Approved") ?
                "Approved by admin. Check details for disbursement." :
                "Rejected by admin. Improve eligibility and reapply.");

        return loanRepo.save(loan);
    }
}

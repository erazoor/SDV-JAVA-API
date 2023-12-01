package fr.erazor.project.service;

import fr.erazor.project.dto.loan.LoanUpdateDTO;
import fr.erazor.project.model.Loan;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ILoanService {
    Loan saveLoan(Loan loan);
    Optional<Loan> getLoanById(Long id);
    List<Loan> getAllLoans();
    Loan updateLoan(Long id, LoanUpdateDTO loanUpdateDTO);
    void deleteLoan(Long id);
    Optional<List<Loan>> getLoansByUserId(Long userId);
    Optional<List<Loan>> getLoansByBookId(Long bookId);
    List<Loan> getLoansByLoanDate(Date date);
    List<Loan> getLoansByReturnDate(Date date);
}

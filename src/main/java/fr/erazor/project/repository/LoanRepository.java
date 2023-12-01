package fr.erazor.project.repository;

import fr.erazor.project.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
    List<Loan> findByBookId(Long bookId);
    List<Loan> findByLoanDate(Date loanDate);
    List<Loan> findByReturnDate(Date returnDate);
}

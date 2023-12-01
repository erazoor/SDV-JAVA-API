package fr.erazor.project.service;

import fr.erazor.project.dto.loan.LoanUpdateDTO;
import fr.erazor.project.model.Loan;
import fr.erazor.project.model.User;
import fr.erazor.project.repository.LoanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService implements ILoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan saveLoan(Loan loan) {
        // You can add validation logic here if needed
        return loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan updateLoan(Long id, LoanUpdateDTO loanUpdateDTO) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loanUpdateDTO.getUserId() != null) {
            loan.setUserId(loanUpdateDTO.getUserId());
        }
        if (loanUpdateDTO.getBookId() != null) {
            loan.setBookId(loanUpdateDTO.getBookId());
        }
        if (loanUpdateDTO.getLoanDate() != null) {
            loan.setLoanDate(loanUpdateDTO.getLoanDate());
        }
        if (loanUpdateDTO.getReturnDate() != null) {
            loan.setReturnDate(loanUpdateDTO.getReturnDate());
        }
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new EntityNotFoundException("Loan not found with id: " + id);
        }
        loanRepository.deleteById(id);
    }

    @Override
    public Optional<List<Loan>> getLoansByUserId(Long userId) {
        List<Loan> loans = loanRepository.findByUserId(userId);
        return loans.isEmpty() ? Optional.empty() : Optional.of(loans);
    }

    @Override
    public Optional<List<Loan>> getLoansByBookId(Long bookId) {
        List<Loan> loans = loanRepository.findByBookId(bookId);
        return loans.isEmpty() ? Optional.empty() : Optional.of(loans);
    }

    @Override
    public List<Loan> getLoansByLoanDate(Date date) {
        return loanRepository.findByLoanDate(date);
    }

    @Override
    public List<Loan> getLoansByReturnDate(Date date) {
        return loanRepository.findByReturnDate(date);
    }
}

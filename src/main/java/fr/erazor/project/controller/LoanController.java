package fr.erazor.project.controller;

import fr.erazor.project.dto.loan.LoanDateDTO;
import fr.erazor.project.dto.loan.LoanUpdateDTO;
import fr.erazor.project.model.Loan;
import fr.erazor.project.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan savedLoan = loanService.saveLoan(loan);
        return ResponseEntity.ok(savedLoan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable Long id) {
        Optional<List<Loan>> loans = loanService.getLoansByUserId(id);
        return loans.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<Loan>> getLoansByBookId(@PathVariable Long id) {
        Optional<List<Loan>> loans = loanService.getLoansByBookId(id);
        return loans.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/loan")
    public ResponseEntity<List<Loan>> getLoansByLoanDate(@RequestBody LoanDateDTO loanDateDTO) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date loanDate = formatter.parse(loanDateDTO.getLoanDate());
            return ResponseEntity.ok(loanService.getLoansByLoanDate(loanDate));
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/return")
    public ResponseEntity<List<Loan>> getLoansByReturnDate(@RequestBody LoanDateDTO loanDateDTO) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date returnDate = formatter.parse(loanDateDTO.getReturnDate());
            return ResponseEntity.ok(loanService.getLoansByReturnDate(returnDate));
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody LoanUpdateDTO loanUpdateDTO) {
        try {
            Loan updatedLoan = loanService.updateLoan(id, loanUpdateDTO);
            return ResponseEntity.ok(updatedLoan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id) {
        try {
            loanService.deleteLoan(id);
            return ResponseEntity.ok("Successfully deleted loan number " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

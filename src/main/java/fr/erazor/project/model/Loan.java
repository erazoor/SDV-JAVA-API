package fr.erazor.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "\"loan\"")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_generator")
    @SequenceGenerator(name = "loan_generator", sequenceName = "loan_seq", allocationSize = 1)
    private Long id;
    private Long userId;
    private Long bookId;
    private Date loanDate;
    private Date returnDate;
}

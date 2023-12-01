package fr.erazor.project.dto.loan;

import lombok.Getter;

@Getter
public class LoanDateDTO {
    private String loanDate;
    private String returnDate;

    public String getDate() {
        return loanDate;
    }

    public void setDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}

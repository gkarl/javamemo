package section2ClassObjetMethode;

import section2ClassObjetMethode.bank.BankManager;

import java.time.LocalDate;

public class customerBank {


    private Long customerId;
    private BankManager bankManager;

    private String nom;

    private Double initialDeposit;

    private LocalDate initialeDateDepos;

    public customerBank(BankManager bankManager, String nom, Double initialDeposit, LocalDate initialeDateDepos) {
        this.bankManager = bankManager;
        this.nom = nom;
        this.initialDeposit = initialDeposit;
        this.initialeDateDepos = initialeDateDepos;
    }
}

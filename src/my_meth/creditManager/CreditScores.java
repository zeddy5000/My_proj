package my_meth.creditManager;

public enum CreditScores {
    ZERO_BALANCE(0),CREDIT_BALANCE(2),DEBIT_BALANCE(3),END(4);
    private final int value;

    private CreditScores(int value) {this.value=value;
    }
}

public class Main {
    public static void main(final String [] args) {
        CertificateOfDeposit cod = new CertificateOfDeposit();
        cod.print_balance();
        CheckingAccount ca = new CheckingAccount();
        ca.print_balance();
        SavingsAccount sa = new SavingsAccount();
        sa.print_balance();
    }
}
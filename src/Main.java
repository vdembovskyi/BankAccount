public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("Ukraine Bank");

        bank.addNewBranch("Branch1");


        bank.addNewCustomer("Branch1", "Name2", 40.5);
        bank.addNewCustomer("Branch1", "Name3", 20.5);
        bank.addNewCustomer("Branch1", "Name4", 10.5);

        bank.addNewBranch("Branch2");

        bank.addNewCustomer("Branch2", "Name5", 11.5);


        bank.addTransactionForExistingCustomer("Name2", 44.22);
        bank.addTransactionForExistingCustomer("Name2", 84.22);
        bank.addTransactionForExistingCustomer("Name3", 64.22);

        //bank.showListOfTransactions("Branch1", "Name2");
        bank.showListOfTransactions("Branch2", "Name5");

    }
}

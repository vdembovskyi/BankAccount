import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();

    }

    public void addNewBranch(String branchName) {
        if (isANewBranch(branchName)) {
            this.branches.add(new Branch(branchName));
        }
    }

    public boolean isANewBranch(String name) {
        boolean result = true;
        if (branches.size() == 0) {
            result = false;
        } else {
            for (Branch branch : branches) {
                if (branch.getName().equals(name)) { //bug
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean isExistsBranch(String name) {
        boolean result;
        result = findBranch(name) != null;
        return result;
    }

    private Branch findBranch(String branchName) {
        Branch foundBranch = null;
        for (Branch bran : this.branches) {
            if (bran.getName().equals(branchName)) {
                foundBranch = bran;
            }
        }
        return foundBranch;
    }

    public void addNewCustomer(String branchName, String userName, double amount) {
        if (isANewBranch(branchName)) {
            findBranch(branchName).addNewCustomer(userName, amount);
        }
    }

    public void showListOfTransactions(String branchName, String name) {
        if (isANewBranch(branchName)) {
            System.out.println(findBranch(branchName).getCustomer(name).toString());
            findBranch(branchName).getCustomer(name).getTransaction();
        }
    }

    public void addTransactionForExistingCustomer(String userName, double amount) {
        for (Branch branch : branches) {
            if (!(branch.isANewCustomer(userName))) {
                branch.getCustomer(userName).addTransaction(amount);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Objects.equals(branches, bank.branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, branches);
    }
}

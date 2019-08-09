import java.util.ArrayList;
import java.util.Objects;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public void addNewCustomer(String name, double amount) {
        if (isANewCustomer(name)) {
            customers.add(new Customer(name, amount));
        }
    }

    public void addUserTranzaction(String userName, double amount) {
        if (!isANewCustomer(userName)) {
            findCustomer(userName).addTransaction(amount);
        }
    }

    private Customer findCustomer(String userName) {
        Customer foundUser = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(userName)) {
                foundUser = customer;
            }
        }
        return foundUser;
    }

    public boolean isANewCustomer(String userName) {
        boolean result = false;
        if(customers.size()==0){
            result = true;
        }
        else {
            for (Customer customer : customers) {
                if (customer.getName().equals(userName)) {
                    result = false;
                    System.out.println("This is an exists customer");
                } else {
                    result = true;
                }
            }
        }
        return result;
    }


    public String getName() {
        return name;
    }

    public Customer getCustomer(String userName) {
        return findCustomer(userName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(name, branch.name) &&
                Objects.equals(customers, branch.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customers);
    }
}

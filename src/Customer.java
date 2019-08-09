import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private ArrayList<Double> transaction;
    private String name;

    public Customer(String name, double transaction) {
        this.name = name;
        this.transaction = new ArrayList<>();
        addTransaction(transaction);
    }

    public void addTransaction(double transaction) {
        this.transaction.add(transaction);
    }

    public void getTransaction() {
        for (Double dob : transaction) {
            System.out.println(dob);
        }
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(transaction, customer.transaction) &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "transaction=" + transaction +
                ", name='" + name + '\'' +
                '}';
    }
}

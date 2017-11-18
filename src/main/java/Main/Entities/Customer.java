package Main.Entities;

public class Customer {

    private int id;

    private String customer_name;

    Customer(){}

    public Customer(String customer_name) {
        this.customer_name = customer_name;
    }

    public Customer(int id, String customer_name) {

        this.id = id;
        this.customer_name = customer_name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }


}

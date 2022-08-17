public class Customers {

    private int CustomerID;
    private String Name;
    private String Address;
    private int Phone;
    private String Email;

    public Customers(int customerID, String name, String address, int phone, String email) {
        CustomerID = customerID;
        Name = name;
        Address = address;
        Phone = phone;
        Email = email;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "CustomerID=" + CustomerID +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone=" + Phone +
                ", Email='" + Email + '\'' +
                '}';
    }
}

import java.util.List;
import java.util.UUID;

public class Customer {


    private String userName, email, firstName, lastName;
    private List<Address> address;
    private UUID uniqueUserId;

    public Customer(String userName, String email, String firstName, String lastName, List<Address> address, UUID uniqueUserId) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.uniqueUserId = uniqueUserId;

    }

    public Customer(String userName, String email, String firstName, String lastName, UUID uniqueUserId) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniqueUserId = uniqueUserId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName; }

    public String getLastName() {
        return lastName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public UUID getUniqueUserId() {
        return uniqueUserId;
    }


}
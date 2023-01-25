public class Address {

    private String streetNumber, streetName, additionalAddress, zipCode, state;


    public Address(String streetNumber, String streetName, String additionalAddress, String zipCode, String state) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalAddress = additionalAddress;
        this.zipCode = zipCode;
        this.state = state;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAdditionalAddress() {
        return additionalAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }
}

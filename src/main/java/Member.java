public class Member {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Member(String firstName, String lastName, String phoneNumber, String email) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First and last name are required");
        }
        if (phoneNumber == null && email == null) {
            throw new IllegalArgumentException("At least one of phone number or email is required");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //GETTERS
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    //SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // PRINT
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}

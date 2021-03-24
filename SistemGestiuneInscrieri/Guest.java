package SistemGestiuneInscrieri;

public class Guest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    Guest(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() { // full name for search method in GuestsList
        return this.firstName + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Nume complet: " + this.firstName + " " + this.lastName +
                " | Email: " + this.email +
                " | Numar de telefon: " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Guest guestObj = (Guest)obj;
        if (this.firstName.equals(guestObj.firstName) &&
            this.lastName.equals(guestObj.lastName) &&
            this.email.equals(guestObj.email) &&
            this.phoneNumber.equals(guestObj.phoneNumber)) {

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + firstName.hashCode();
        result = prime * result + lastName.hashCode();
        result = prime * result + email.hashCode();
        result = prime * result + phoneNumber.hashCode();

        return result;
    }
}

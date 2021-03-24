package SistemGestiuneInscrieri;

import java.util.ArrayList;

public class GuestsList {
    private int availableSeats;
    private ArrayList<Guest> list;

    GuestsList(int availableSeats) {
        this.availableSeats = availableSeats;
        this.list = new ArrayList<Guest>();
    }

    public ArrayList<Guest> getList() {
        return this.list;
    }

    private int indexWaitingList(int index) { // diferenta dintre index si avail seats
        int counter = 0;
        for (int i = this.availableSeats; i <= index; i++) {
            counter++;
        }
        return counter;
    }

    public int addGuest(String firstName, String lastName, String email, String phoneNumber) {
        if (searchGuest(email) != null) { //email or phone is risk free
            return -1;
        }

        Guest guest = new Guest(firstName, lastName, email, phoneNumber);
        this.list.add(guest);
        if (this.list.indexOf(guest) >= this.availableSeats) { //list.size - 1
            int index = indexWaitingList(this.list.indexOf(guest)); // variabila data viitoare
            System.out.println("Buna, " + guest.getFirstName() + ". Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <"+ index +">. Te vom notifica daca un loc devine disponibil");
            return index;
        } else {
            System.out.println("Felicitari " + guest.getFirstName() + "! Locul tau la eveniment este confirmat. Te asteptam!");
            return 0;
        }
    }

    public Guest searchGuest(String input) {
        input = input.replaceAll("\\s+", ""); //deletes all whitespaces to make it easier to search by full name
        for (Guest guest : this.list) {
            boolean equalizer = input.equalsIgnoreCase(guest.getFullName()) || input.equalsIgnoreCase(guest.getEmail()) ||
                    input.equalsIgnoreCase(guest.getPhoneNumber());
            if (equalizer) {
                return guest;
            }
        }
        return null;
    }

    public boolean removeGuest(String input) {
        Guest crtGuest = searchGuest(input);
        if (crtGuest == null) { // if searchGuest does not return guest, method ends here
            System.out.println("Persoana cautata nu exista..");
            return false;
        } else {
            int nextGuestIndex = this.list.indexOf(crtGuest); // saves index for comparison below
            this.list.remove(crtGuest);
            System.out.println("Stergerea a fost realizata cu succes");
            if (nextGuestIndex < this.availableSeats && this.list.size() > this.availableSeats - 1) {
                System.out.println("Felicitari " + this.list.get(this.availableSeats - 1).getFirstName() + "! Locul tau la eveniment este confirmat. Te asteptam!");
            } // availableSeats - 1 will always be the one who got shifted first in the participating list after removal
            return true;
        }
    }

    public void setGuestFields(Guest guest, String input, int ans) { //get guest param from search method
            switch (ans) {
                case 1:
                    guest.setFirstName(input);
                    System.out.println("Prenume schimbat");
                    break;
                case 2:
                    guest.setLastName(input);
                    System.out.println("Nume de familie schimbat");
                    break;
                case 3:
                    guest.setEmail(input);
                    System.out.println("Email schimbat");
                    break;
                case 4:
                    guest.setPhoneNumber(input);
                    System.out.println("Nunar de telefon schimbat");
                    break;
                default:
                    System.out.println("Alegere invalida");
                    break;

            }
    }

    public void allParticipatingGuests() {
        System.out.println("Persoanele in lista de participanti:");
        if (list.size() >= availableSeats) {
            for (int i = 0; i < availableSeats; i++) { // to math.min(availseats, list.size())
                System.out.println(list.get(i).toString());
            }
        } else {
            for (Guest guest : list) {
                System.out.println(guest.toString());
            }
        }
    }

    public void allWaitingGuests() {
        System.out.println("Persoanele in lista de asteptare:");
        if (list.size() <= availableSeats) {
            System.out.println("Lista de asteptare este goala");
        }
        for (int i = availableSeats; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public int remainingSeats() {
        if (list.size() >= availableSeats) {
            return 0;
        } else {
            int count = 0;
            for (int i = this.list.size(); i < this.availableSeats; i++) {
                count++;
            }
            return count;
        }
    }

    public int occupiedSeats() {
        return Math.min(this.list.size(), this.availableSeats); // if nr of occupied seats are less than this.ava
    }

    public int waitingSeats() {
        if (this.list.size() <= this.availableSeats) {
            return 0;
        }
        int count = 0;
        for (int i = this.availableSeats; i < list.size(); i++) {
            count++;
        }
        return count;
    }

    // since there's only one list, total nr of guests is list.size()


    public void partialSearch(String input) {
        System.out.println("Introduceti un sir de caractere pentru a cauta si a afisa in toate campurile listei de persoane inscrise: ");
        for (Guest guest : list) {
            boolean containsAny = false;
            boolean containsFirstName = guest.getFirstName().toLowerCase().contains(input.toLowerCase());
            boolean containsLastName = guest.getLastName().toLowerCase().contains(input.toLowerCase());
            boolean containsEmail = guest.getEmail().toLowerCase().contains(input.toLowerCase());
            boolean containsPhoneNumber = guest.getPhoneNumber().toLowerCase().contains(input.toLowerCase());

            if (containsFirstName) {
                System.out.print(" Prenume: " + guest.getFirstName() + " ");
                containsAny = true;
            }
            if (containsLastName) {
                System.out.print(" Nume de familie " + guest.getLastName() + " ");
                containsAny = true;
            }
            if (containsEmail) {
                System.out.print(" Email: " + guest.getEmail() + " ");
                containsAny = true;
            }
            if (containsPhoneNumber) {
                System.out.print(" Numar de telefon: " + guest.getPhoneNumber() + " ");
                containsAny = true;
            }

            if (containsAny) {
                System.out.println();
            }
        }
    }

    public void allGuests() {
        for (Guest guest : list) {
            System.out.println(guest.toString());
        }
    }

    @Override
    public String toString() {
        return "Lista are " + this.availableSeats + " locuri de participare\n" +
                "In prezent, se afla " + occupiedSeats() + " persoane in lista de participare si " + waitingSeats() +
                " persoane in lista de asteptare.";
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

        GuestsList listObj = (GuestsList)obj;
        if(this.availableSeats == listObj.availableSeats &&
           this.list.equals(listObj.list)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + availableSeats;
        result = prime * result + list.hashCode();

        return result;
    }
}

package SistemGestiuneInscrieri;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        startApp(sc);

        sc.close();
    }

    public static void startApp(Scanner sc) {

        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        int availSeats = 0;
        while (availSeats <= 0) {
            try { // prevents non-integer inputs
                availSeats = sc.nextInt();

            } catch(Exception e) {
                System.out.println("Trebuie sa introduceti un numar!");
                sc.nextLine();
                continue;
            }
            if (availSeats <= 0) {
                System.out.println("Numarul de locuri disponibile trebuie sa fie mai mare decat 0!");
            }
        }
        GuestsList list = new GuestsList(availSeats);


        while (true) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");

            switch (sc.next()) {
                case "help" -> help();
                case "add" -> add(sc, list);
                case "check" -> check(sc, list);
                case "remove" -> remove(sc, list);
                case "update" -> update(sc, list);
                case "guests" -> list.allParticipatingGuests();
                case "waitlist" -> list.allWaitingGuests();
                case "available" -> System.out.println("Numar de locuri disponibile: " + list.remainingSeats());
                case "guests_no" -> System.out.println("Numarul de persoane care participa la eveniment: " + list.occupiedSeats());
                case "waitlist_no" -> System.out.println("Numarul de persoane din lista de asteptare: " + list.waitingSeats());
                case "subscribe_no" -> System.out.println("Numarul de persoane inscrise: " + list.getList().size());
                case "search" -> list.partialSearch(sc.next());
                case "quit" -> {
                    System.out.println("Aplicatia se inchide..");
                    return;
                }
                default -> System.out.println("Comanda invalida");
            }

        }

    }

    public static void help() {
        System.out.println( "help         - Afiseaza aceasta lista de comenzi\n" +
                "add          - Adauga o noua persoana (inscriere)\n" +
                "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove       - Sterge o persoana existenta din lista\n" +
                "update       - Actualizeaza detaliile unei persoane\n" +
                "guests       - Lista de persoane care participa la eveniment\n" +
                "waitlist     - Persoanele din lista de asteptare\n" +
                "available    - Numarul de locuri libere\n" +
                "guests_no    - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit         - Inchide aplicatia");
    }

    public static void add(Scanner sc, GuestsList list) {
        System.out.println("Se adauga o noua persoana…");
        System.out.println("Introduceti prenumele:");
        String firstName = sc.next();
        System.out.println("Introduceti numele de familie:");
        String lastName = sc.next();
        System.out.println("Introduceti email:");
        String email = sc.next();
        System.out.println("Introduceti numar de telefon (format „+40733386463“):");
        String phoneNumber = sc.next();
        list.addGuest(firstName, lastName, email, phoneNumber);
    }

    public static void check(Scanner sc, GuestsList list) {
        System.out.println("Se cauta o persoana..");
        System.out.println("Cautati prin a introduce: prenume si nume SAU email SAU numar de telefon: ");
        sc.nextLine();
        if (list.searchGuest(sc.nextLine()) != null) {
            System.out.println("Persoana cautata se afla in lista.");
        } else {
            System.out.println("Persoana cautata nu se afla in lista");
        }
    }

    public static void remove(Scanner sc, GuestsList list) {
        System.out.println("Se sterge o persoana existenta in lista..");
        System.out.println("Cautati prin a introduce: prenume si nume SAU email SAU numar de telefon: ");
        sc.nextLine();
        list.removeGuest(sc.nextLine());
    }

    public static void update(Scanner sc, GuestsList list) {
        System.out.println("Se actualizeaza detaliile unei persoane..");
        System.out.println("Cautati prin a introduce: prenume si nume SAU email SAU numar de telefon: ");
        sc.nextLine();
        Guest guest = list.searchGuest(sc.nextLine());
        if (guest == null) {
            System.out.println("Persoana introdusa nu exista..");
        } else {
            System.out.println("Alege campul de actualizat, tastand:\n" +
                    "\"1\" - Prenume\n" +
                    "\"2\" - Nume\n" +
                    "\"3\" - Email\n" +
                    "\"4\" - Numar de telefon (format \"+40733386463\")");
            int ans;
            while (true) {
                try { // prevents all non-integer inputs
                    ans = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch(Exception e) {
                    System.out.println("Trebuie sa introduceti un numar!");
                    sc.nextLine();
                }
            }

            System.out.println("Introduceti datele: ");
            String st2 = sc.nextLine();
            list.setGuestFields(guest, st2, ans);
        }
    }
}

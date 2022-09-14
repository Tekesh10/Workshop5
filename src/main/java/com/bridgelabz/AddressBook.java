package com.bridgelabz;
import java.util.*;
public class AddressBook {
    static Map<String, List<Contacts>> contactBook = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    AddressBookIOService addressBookIOService = new AddressBookIOService();
    public void runAddressBook() {
        while (true) {
            System.out.println("""
                    1. Crate New address book\s
                    2. Continue with existing address book\s
                    0. Exit""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a name for Address book");
                    String newBook = scanner.next();
                    List<Contacts> contactList = new LinkedList<>();
                    if (contactBook.containsKey(newBook))
                        System.out.println("Book already exists");
                    else
                        createContact(contactList, contactBook, newBook);
                    addressBookIOService.writeContactDetails(contactBook);
                    break;
                case 2:
                    System.out.println(contactBook.keySet());
                    System.out.println("Which address book do you want to access?");
                    String existingBook = scanner.next();

                    if (contactBook.containsKey(existingBook)) {
                        contactList = contactBook.get(existingBook);
                        createContact(contactList, contactBook, existingBook);
                    } else
                        System.out.println("Book not found");
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    private void createContact(List<Contacts> contactList, Map<String, List<Contacts>> contactBook, String addressBook) {
        boolean run = true;
        while (run) {
            System.out.println("""
                    1. Add a New contact detail\s
                    2. Show All contact\s
                    0. Exit\s
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    List<Contacts> multiContactInBook = addContact(contactList);
                    contactBook.put(addressBook, multiContactInBook);
                }
                case 2 -> displayContact(contactList);
                default -> run = false;
            }
        }
        addressBookIOService.writeContactDetails(contactBook);
    }
    private List<Contacts> addContact(List<Contacts> contactList) {
        System.out.println("First Name :");
        String firstName = scanner.next();
        System.out.println("Last Name :");
        String lastName = scanner.next();
        System.out.println("Phone Number :");
        String phone = scanner.next();
        System.out.println("Email :");
        String email = scanner.next();
        System.out.println("City :");
        String city = scanner.next();
        System.out.println("State :");
        String state = scanner.next();
        System.out.println("Zip Code :");
        String zipcode = scanner.next();
        Contacts contactInfo = new Contacts(firstName, lastName, phone, email, city, state, zipcode);
        contactList.add(contactInfo);
        System.out.println(contactInfo);
        return contactList;
    }
    private void displayContact(List<Contacts> contactList) {
        System.out.println("All contact -> " + contactList.size());
        System.out.println(contactList);
    }
}
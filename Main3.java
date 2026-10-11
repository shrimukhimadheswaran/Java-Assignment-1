import java.util.*;


interface MenuDriven {

    void addContact();

    void viewContacts();

    void searchContact();
}

// Parent class
class Person {

    protected String name;

    // Constructor
    Person(String name) {
        this.name = name;
    }
}

// Contact inherits Person
class Contact extends Person {

    private String phone;
    private String email;

    // Constructor
    Contact(String name, String phone, String email) {

        super(name);

        this.phone = phone;
        this.email = email;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Display contact
    public void display() {

        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phone);
        System.out.println("Email : " + email);
        System.out.println("----------------------");
    }
}

// AddressBook implements interface
class AddressBook implements MenuDriven {

    ArrayList<Contact> contacts = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Add contact
    public void addContact() {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);

        System.out.println("Contact added successfully.");
    }

    // View all contacts
    public void viewContacts() {

        if (contacts.isEmpty()) {

            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n--- All Contacts ---");

        for (Contact contact : contacts) {
            contact.display();
        }
    }

    // Search contact
    public void searchContact() {

        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        for (Contact contact : contacts) {

            if (contact.getName().equalsIgnoreCase(searchName)) {

                contact.display();

                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

// Main class
public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Object creation
        AddressBook addressBook = new AddressBook();

        int choice;

        do {

            System.out.println("\n===== ADDRESS BOOK =====");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addressBook.addContact();
                    break;

                case 2:
                    addressBook.viewContacts();
                    break;

                case 3:
                    addressBook.searchContact();
                    break;

                case 4:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
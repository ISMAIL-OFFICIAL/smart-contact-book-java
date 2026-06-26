import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook book = new ContactBook();
        while (true) 
                {
            System.out.println("\n==============================");
            System.out.println("      SMART CONTACT BOOK");
            System.out.println("==============================");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Save Contacts");
            System.out.println("8. Load Contacts");
            System.out.println("9. Binary Search Contact");
            System.out.println("10. Exit");
            System.out.print("\nChoose option: ");
            int choice;

            try {
                choice = Integer.parseInt(
                        scanner.nextLine());

            } catch (Exception e) {
                System.out.println(
                        "Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name =
                            scanner.nextLine();
                    if (!book.isValidName(name)) {
                        System.out.println(
                                "Invalid name.");
                        break;
                    }
                    System.out.print("Phone: ");
                    String phone =
                            scanner.nextLine();
                    if (!book.isValidPhone(phone)) {
                        System.out.println(
                                "Phone must contain digits only.");
                        break;
                    }
                    System.out.print("Email: ");
                    String email =
                            scanner.nextLine();
                    if (!book.isValidEmail(email)) 
                        {
                        System.out.println(
                                "Invalid email.");
                        break;
                    }

                    Contact contact =
                            new Contact(
                                    name,
                                    phone,
                                    email);

                    if (book.addContact(contact)) {

                        System.out.println(
                                "Contact added successfully.");

                    } else {
                   System.out.println(
                                "Contact already exists.");
                    }
                    break;
                case 2:
                    book.viewContacts();
                    break;
                case 3:
                    System.out.print(
                            "Enter name to search: ");
                    String searchName =
                            scanner.nextLine();
                    Contact found =
                            book.searchContact(
                                    searchName);
                    if (found != null) {
                        System.out.println(
                                "\nContact Found:");

                        System.out.println(found);
                    } else 
                        {
                        System.out.println(
                                "Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print(
                            "Enter contact name: ");
                    String updateName =
                            scanner.nextLine();
                    System.out.print(
                            "New phone: ");
                    String newPhone =
                            scanner.nextLine();
                    System.out.print(
                            "New email: ");
                    String newEmail =
                            scanner.nextLine();
                    if (book.updateContact(
                            updateName,
                            newPhone,
                            newEmail)) 
                            {
                        System.out.println(
                                "Contact updated.");
                    } else 
                        {
                        System.out.println(
                                "Contact not found.");
                    }
                    break;

                case 5:
                    System.out.print(
                            "Enter contact name: ");
                    String deleteName =
                            scanner.nextLine();
                    if (book.deleteContact(
                            deleteName)) 
                            {
                        System.out.println(
                                "Contact deleted.");
                    } else 
                        {
                        System.out.println(
                                "Contact not found.");
                    }
                    break;
                case 6:
                    book.sortContacts();
                    System.out.println(
                            "Contacts sorted A-Z.");
                    break;

                case 7:
                    book.saveContactsToFile();
                    break;

                case 8:
                    book.loadContactsFromFile();
                    break;

                case 9:
                    System.out.print(
                            "Enter contact name: ");
                    String binaryName =
                            scanner.nextLine();
                    Contact result =
                            book.binarySearchContact(
                                    binaryName);
                    if (result != null) 
                        {
                        System.out.println(
                                "\nContact Found:");
                        System.out.println(
                                result);
                    } else {
                        System.out.println(
                                "Contact not found.");
                    }
                    break;

                case 10:
                    System.out.println(
                            "\nThank you for using Smart Contact Book!");
                    scanner.close();
                    return;
                default:
                    System.out.println(
                            "Invalid option.");
            }
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ContactBook {
    private ArrayList<Contact> contacts;
    public ContactBook() {
        contacts = new ArrayList<>();
    }
    // Add Contact
    public boolean addContact(Contact contact) {
        if (contactExists(contact.getName())) {
            return false;
        }
        contacts.add(contact);
        return true;
    }
    // Duplicate Check
    public boolean contactExists(String name)
     {
        for (Contact contact : contacts) 
            {
            if (contact.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    // View All Contacts
    public void viewContacts() {
        if (contacts.isEmpty())
             {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\n===== CONTACT LIST =====");
        for (Contact contact : contacts) 
            {
            System.out.println(contact);
        }
    }
    // Linear Search
    public Contact searchContact(String name) 
    {
        for (Contact contact : contacts) 
            {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
    // Update Contact
    public boolean updateContact(
            String name,
            String newPhone,
            String newEmail) {
        Contact contact = searchContact(name);
        if (contact != null) {
            contact.setPhone(newPhone);
            contact.setEmail(newEmail);
            return true;
        }
        return false;
    }
    // Delete Contact
    public boolean deleteContact(String name) {
        Contact contact = searchContact(name);
        if (contact != null) 
            {
            contacts.remove(contact);
            return true;
        }
        return false;
    }
    // Sort Contacts
    public void sortContacts()
     {
        Collections.sort(
                contacts,
                Comparator.comparing(
                        Contact::getName,
                        String.CASE_INSENSITIVE_ORDER));
    }
    // Save To File
    public void saveContactsToFile()
     {
        try {
            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("contacts.txt"));
            for (Contact contact : contacts) {
                writer.println(
                        contact.getName() + "," +
                                contact.getPhone() + "," +
                                contact.getEmail());
            }
            writer.close();
            System.out.println(
                    "Contacts saved successfully.");
        } catch (IOException e) {
            System.out.println(
                    "Error saving contacts.");
        }
    }
    // Load From File
    public void loadContactsFromFile() {
        try {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("contacts.txt"));
            String line;
            contacts.clear();
            while ((line = reader.readLine()) != null) 
                {
                String[] parts =
                        line.split(",");
                if (parts.length == 3) 
                    {
                    contacts.add(
                            new Contact(
                                    parts[0],
                                    parts[1],
                                    parts[2]));
                }
            }
            reader.close();
            System.out.println(
                    "Contacts loaded successfully.");
        } catch (IOException e) {
            System.out.println(
                    "No saved contacts found.");
        }
    }

    // Binary Search
    public Contact binarySearchContact(String name) 
    {
        sortContacts();
        int left = 0;
        int right = contacts.size() - 1;
        while (left <= right) 
            {
            int mid =
                    (left + right) / 2;
            Contact current =
                    contacts.get(mid);
            int compare =
                    current.getName()
                            .compareToIgnoreCase(name);
            if (compare == 0) 
                {
                return current;
            } else if (compare < 0) 
                {
                left = mid + 1;
            } else 
                {
                right = mid - 1;
            }
        }
        return null;
    }
    // Name Validation
    public boolean isValidName(String name) {
        return !name.trim().isEmpty();
    }
    // Phone Validation
    public boolean isValidPhone(String phone) 
    {
        return phone.matches("\\d+");
    }
    // Email Validation
    public boolean isValidEmail(String email) 
    {
        return email.contains("@")
                && email.contains(".");
    }
}
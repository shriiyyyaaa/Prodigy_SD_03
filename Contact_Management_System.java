import java.util.ArrayList;
import java.util.Scanner;

class Contact 
{
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) 
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() 
    {
        return name;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String toString() 
    {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

public class Contact_Management_System
{
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        Contact_Management_System manager = new Contact_Management_System();
        manager.run();
    }

    public void run() 
    {
        while (true) 
        {
            System.out.println("Contact Manager");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContactList();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addContact()
    {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }

    public void viewContactList() 
    {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else 
        {
            for (int i = 0; i < contacts.size(); i++) 
            {
                System.out.println("Contact " + (i + 1) + ":\n" + contacts.get(i));
            }
        }
    }

    public void editContact() 
    {
        viewContactList();
        System.out.print("Enter the index of the contact you want to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 1 && index <= contacts.size()) {
            Contact contact = contacts.get(index - 1);

            System.out.println("Editing Contact " + index + ":");
            System.out.println(contact);

            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            contact.setPhoneNumber(newPhoneNumber);

            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            contact.setEmail(newEmail);

            System.out.println("Contact updated successfully!");
        } 
        else 
        {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public void deleteContact() 
    {
        viewContactList();
        System.out.print("Enter the index of the contact you want to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 1 && index <= contacts.size()) 
        {
            Contact contact = contacts.remove(index - 1);
            System.out.println("Contact deleted successfully:\n" + contact);
        } 
        else 
        {
            System.out.println("Invalid index. Please try again.");
        }
    }
}
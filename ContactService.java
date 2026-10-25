import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }

        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) {
        if (contacts.remove(contactId) == null) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }
    }

    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    public Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }
        return contact;
    }
}

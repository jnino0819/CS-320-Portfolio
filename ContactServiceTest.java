import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);

        assertSame(contact, service.getContact("12345"));
    }

    @Test
    void testAddDuplicateContactId() {
        service.addContact(contact);

        Contact duplicate = new Contact("12345", "Jane", "Doe", "0987654321", "456 Oak Ave");

        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("12345");

        assertThrows(IllegalArgumentException.class, () -> service.getContact("12345"));
    }

    @Test
    void testDeleteMissingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("12345", "Jane");

        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("12345", "Doe");

        assertEquals("Doe", service.getContact("12345").getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact);
        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Ave");

        assertEquals("456 Oak Ave", service.getContact("12345").getAddress());
    }

    @Test
    void testUpdateMissingContact() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("99999", "Jane"));
    }
}

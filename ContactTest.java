import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "Christopher", "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", null, "Smith", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "WashingtonX", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Smith", "123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Smith", "12345678901", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Smith", "12345abcde", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Smith", null, "123 Main St"));
    }

    @Test
    void testAddressTooLongOrNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Smith", "1234567890",
                        "1234567890123456789012345678901"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Smith", "1234567890", null));
    }

    @Test
    void testSetters() {
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        contact.setLastName("Doe");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    void testInvalidSetterValues() {
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Christopher"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("WashingtonX"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345abcde"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("1234567890123456789012345678901"));
    }
}

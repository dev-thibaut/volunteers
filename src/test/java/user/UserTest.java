package user;

import org.example.volunteers.Demo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private Function<String, Integer> dependency;
    private ArrayList<User> testListUser;

    @BeforeEach
    public void setUp() {
        dependency = (String string) -> 1;
        testListUser = new ArrayList<User>();
        testListUser.add(new User("Thibaut", "Andre", "tandre", "tandre@ynov.com","0647000000"));
        testListUser.add(new User("Theo", "Segard", "tseguard", "tseguard@ynov.com",null));
        testListUser.add(new User("Bruneau","Viviane","Viviane","Spookworm7637@example.com","+33000555132"));
    }

    @Test
    public void testCheckValidComboLastNameFirstNameOfUser() {
        User userTest = new User("Thibaut","Andre", null,null,null );
        boolean result = userTest.checkValidComboLastNameFirstNameOfUser(testListUser);
        assertFalse(result, "Ce message s'affiche si le test échoue.");
    }

    @Test
    public void testCheckValidComboLastNameFirstNameOfUserNotExist() {
        User userTest = new User("Thibaut","Madrières", null,null,null );
        boolean result = userTest.checkValidComboLastNameFirstNameOfUser(testListUser);
        assertTrue(result, "Ce message s'affiche si le test échoue");
    }

    @Test
    public void testCheckValidUsernameOfUser() {
        User userTest = new User(null,null, "tandre",null,null );
        boolean result = userTest.checkValidUsernameOfUser(testListUser);
        assertFalse(result, "Ce message s'affiche si le test échoue.");
    }

    @Test
    public void testCheckValidUsernameOfUserNotExist() {
        User userTest = new User(null,null, "blopblop",null,null );
        boolean result = userTest.checkValidUsernameOfUser(testListUser);
        assertTrue(result, "Ce message s'affiche si le test échoue.");
    }

    @Test
    public void testCheckValidEmailOfUser() {
        User userTest = new User(null,null, null,"tandre@ynov.com",null );
        boolean result = userTest.checkValidEmailOfUser(testListUser);
        assertFalse(result, "Ce message s'affiche si le test échoue.");
    }

    @Test
    public void testCheckValidEmailOfUserNotExist() {
        User userTest = new User(null,null, null,"azerty@gmail.com",null );
        boolean result = userTest.checkValidEmailOfUser(testListUser);
        assertTrue(result, "Ce message s'affiche si le test échoue.");
    }

    @Test
    public void testCheckValidPhoneNumberOfUser() {
        User userTest = new User(null,null, null,"tandre@ynov.com","0647000000" );
        boolean result = userTest.checkValidPhoneNumberOfUser(testListUser);
        assertFalse(result, "Ce message s'affiche si le test échoue.");
    }

    @Test
    public void testCheckValidPhoneNumberOfUserNotExist() {
        User userTest = new User(null,null, null,"azerty@gmail.com","054245457687343dk" );
        boolean result = userTest.checkValidPhoneNumberOfUser(testListUser);
        assertTrue(result, "Ce message s'affiche si le test échoue.");
    }
}
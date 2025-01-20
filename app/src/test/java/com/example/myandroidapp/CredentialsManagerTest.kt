import com.example.myandroidapp.CredentialsManager
import org.junit.Assert.*
import org.junit.Test

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager

    @Test
    fun testValidEmail() {
        assertTrue(credentialsManager.isEmailValid("example@test.com"))
        assertFalse(credentialsManager.isEmailValid("invalid-email"))
    }

    @Test
    fun testValidPassword() {
        assertTrue(credentialsManager.isValidPassword("password123"))
        assertFalse(credentialsManager.isValidPassword("short"))
    }

    @Test
    fun testValidateCredentials() {
        // Valid email, password, and checkbox checked
        assertTrue(credentialsManager.validateCredentials("example@test.com", "password123"))

        // Invalid email
        assertFalse(credentialsManager.validateCredentials("invalid-email", "password123"))

        // Invalid password
        assertFalse(credentialsManager.validateCredentials("example@test.com", "short"))

        // Checkbox not checked
        assertFalse(
            credentialsManager.validateCredentials(
                "example@test.com",
                "password123"
            )
        )
    }

    @Test
    fun testValidFullName() {
        assertTrue(credentialsManager.isValidFullName("John Doe"))
        assertFalse(credentialsManager.isValidFullName(""))
        assertTrue(credentialsManager.isValidFullName("John"))
    }

    @Test
    fun testValidPhoneNumber() {
        assertTrue(credentialsManager.isValidPhoneNumber("1234567890"))
        assertFalse(credentialsManager.isValidPhoneNumber("12345"))
        assertFalse(credentialsManager.isValidPhoneNumber(""))
    }


    @Test
    fun testValidateCredentialsForSignUp() {
        // Valid full name, email, phone, password, and checkbox checked
        assertTrue(
            credentialsManager.validateCredentialsForSignUp(
                "John Doe", "example@test.com", "1234567890", "password123", true
            )
        )

        // Invalid full name
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "", "example@test.com", "1234567890", "password123", true
            )
        )

        // Invalid email
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "John Doe", "invalid-email", "1234567890", "password123", true
            )
        )

        // Invalid phone number
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "John Doe", "example@test.com", "12345", "password123", true
            )
        )

        // Invalid password
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "John Doe", "example@test.com", "1234567890", "short", true
            )
        )

        // Checkbox not checked
        assertFalse(
            credentialsManager.validateCredentialsForSignUp(
                "John Doe", "example@test.com", "1234567890", "password123", false
            )
        )
    }

    @Test
    fun testHardcodedLoginCredentials() {
        val validEmail = "test@te.st"
        val validPassword = "1234"

        assertTrue(validEmail == "test@te.st" && validPassword == "1234")

        assertFalse(validEmail == "wrong@te.st" && validPassword == "1234")
        assertFalse(validEmail == "test@te.st" && validPassword == "wrong")
    }

    @Test
    fun testRegisterUser() {
        val email = "newuser@test.com"
        val password = "strongPassword123"

        assertTrue(credentialsManager.registerUser(email, password))
        assertFalse(credentialsManager.registerUser(email, password))
        assertTrue(credentialsManager.isEmailAlreadyUsed(email))
    }

    @Test
    fun testValidateLogin() {
        val email = "login@test.com"
        val password = "loginPassword123"

        credentialsManager.registerUser(email, password)

        assertTrue(credentialsManager.validateLogin(email, password))
        assertFalse(credentialsManager.validateLogin(email, "wrongPassword"))
        assertFalse(credentialsManager.validateLogin("wrongEmail@test.com", password))
        assertTrue(credentialsManager.validateLogin("WRONG@test.COM", password))
    }
}
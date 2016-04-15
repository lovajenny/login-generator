package dcll;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lova on 15/04/16.
 */
public class LoginGeneratorTest {

    @Test
    public void testGenerateLoginForNomAndPrenom() throws Exception {

        // Pour Paul Durand
        //Given
        LoginService loginService = new LoginService(new String[]
                {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String loginPaul = "";

        //When
        loginPaul = loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");

        //Then
        assertEquals(loginPaul, "PDUR");
    }

    @Test
    public void testGenerateLoginForNomAndPrenomDupli() throws Exception {

        // Pour Jean Rolling
        //Given
        LoginService loginService = new LoginService(new String[]
                {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String loginJean = "";

        //When
        loginJean = loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");

        //Then
        assertEquals(loginJean, "JROL1");
    }

    @Test
    public void testGenerateLoginForNomAndPrenomAccent() throws Exception {

        // Pour Paul Dùrand
        //Given
        LoginService loginService = new LoginService(new String[]
                {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String loginPaul2 = "";

        //When
        loginPaul2 = loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");

        //Then
        assertEquals(loginPaul2, "PDUR");
    }

    @Test
    public void testGenerateLoginForNomAndPrenomCourt() throws  Exception {

        // Pour Paul Du
        //Given
        LoginService loginService = new LoginService(new String[]
                {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String loginPaul3 = "";

        //When
        loginPaul3 = loginGenerator.generateLoginForNomAndPrenom("Du", "Paul");

        //Then
        assertEquals(loginPaul3, "PDU");
    }

    @Test
    public void testGenerateLoginForNomAndPrenomDupli2() throws  Exception {

        // Pour John Ralling
        //Given
        LoginService loginService = new LoginService(new String[]
                {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        String loginJohn = "";

        //When
        loginJohn = loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");

        //Then
        assertEquals(loginJohn, "JRAL2");
    }
}
package dcll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lova on 15/04/16.
 */
public class LoginServiceTest {

    @Test
    public void testLoginExists() throws Exception {

        //Given
        String[] loginExistants = new String[2];
        loginExistants[0] = "lova";
        loginExistants[1] = "bob";
        LoginService loginService = new LoginService(loginExistants);

        //When
        boolean lovaPresente = loginService.loginExists("lova");

        //Then
        assertTrue(lovaPresente);
    }

    @Test
    public void testAddLogin() throws Exception {

        //Given
        String[] loginExistants = new String[2];
        loginExistants[0] = "lova";
        loginExistants[1] = "bob";
        LoginService loginService = new LoginService(loginExistants);

        //When
        loginService.addLogin("luffy");

        //Then
        assertTrue(loginService.loginExists("luffy"));
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {

        //Given
        String[] loginExistants = new String[3];
        loginExistants[0] = "lova";
        loginExistants[1] = "bob";
        loginExistants[2] = "lola";
        LoginService loginService = new LoginService(loginExistants);
        List<String> listeLoginMemePrefixe = new ArrayList<>();
        List<String> listeLoginMemePrefixeAttendue = new ArrayList<>();
        listeLoginMemePrefixeAttendue.add("lola");
        listeLoginMemePrefixeAttendue.add("lova");

        //When
        listeLoginMemePrefixe.addAll(loginService.findAllLoginsStartingWith("lo"));

        //Then
        assertEquals(listeLoginMemePrefixe, listeLoginMemePrefixeAttendue);
    }

    @Test
    public void testFindAllLogins() throws Exception {

        //Given
        String[] loginExistants = new String[2];
        loginExistants[0] = "lova";
        loginExistants[1] = "bob";
        LoginService loginService = new LoginService(loginExistants);
        List<String> listeLogin = new ArrayList<>();
        List<String> listeLoginAttendue = new ArrayList<>();
        listeLoginAttendue.add("bob");
        listeLoginAttendue.add("lova");

        //When
        listeLogin.addAll(loginService.findAllLogins());

        //Then
        assertEquals(listeLogin, listeLoginAttendue);
    }
}
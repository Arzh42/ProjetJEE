package org.projet.DBGestion;

import java.util.List;

public interface UserService {
    boolean verifyUserIdentity(String name, String password);

    String getUserRole(String name) throws Exception;

    List<User> getUsers();

    void changePassword(String name, String password2);

    void changeQuestion(String name, String question, String reponse);

    String getQuestion(String name);

    boolean verifyReponse(String name,String reponse);

    void changeRole(String name,String role);
}

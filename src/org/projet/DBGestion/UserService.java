package org.projet.DBGestion;

public interface UserService {
    boolean verifyUserIdentity(String name, String password);

    String getUserRole(String name) throws Exception;

    void changePassword(String name, String password2);

    void changeQuestion(String name, String question, String reponse);

    String getQuestion(String name);
}

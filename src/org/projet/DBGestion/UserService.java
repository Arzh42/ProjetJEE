package org.projet.DBGestion;

public interface UserService {
    boolean verifyUserIdentity(String name,String password);

    String getUserRole(String name) throws Exception;
}

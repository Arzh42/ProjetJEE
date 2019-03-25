package org.projet.Exception;

public class UserDBException extends Exception {

    public UserDBException(String role_introuvable) {
        super(role_introuvable);
    }
}

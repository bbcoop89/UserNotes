package com.brit.usernotes.auth;

import com.brit.usernotes.core.User;
import com.brit.usernotes.db.UserDAO;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Base64;


public class DBAuthenticator implements Authenticator<BasicCredentials, User>
{
    private UserDAO userDAO;

    public DBAuthenticator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        System.out.println(basicCredentials.getPassword());
        return userDAO.findByEmailPassword(
                basicCredentials.getUsername(),
                Base64.getEncoder().encodeToString(basicCredentials.getPassword().getBytes())
        );
    }
}

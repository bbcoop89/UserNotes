package com.brit.usernotes.db;

import com.brit.usernotes.core.User;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import java.util.List;


public class UserDAO extends AbstractDAO<User>
{

    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<User> findAll()
    {
        return list(
                namedQuery(
                        "com.brit.usernotes.core.User.findAll"
                )
        );
    }

    public Optional<User> findByEmailPassword(String email, String password)
    {
        return Optional.fromNullable(
                uniqueResult(
                        namedQuery(
                                "com.brit.usernotes.core.User.findByEmailPassword"
                        )
                                .setParameter("email", email)
                                .setParameter("password", password)
                )
        );
    }
}

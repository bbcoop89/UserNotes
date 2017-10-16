package com.brit.usernotes;

import com.brit.usernotes.core.Note;
import com.brit.usernotes.db.NoteDAO;
import com.brit.usernotes.resources.NoteResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserNotesApplication extends Application<UserNotesConfiguration> {

    private final HibernateBundle<UserNotesConfiguration> hibernateBundle =
            new HibernateBundle<UserNotesConfiguration>(
                    Note.class
            ) {
                @Override
                public DataSourceFactory getDataSourceFactory(UserNotesConfiguration userNotesConfiguration) {
                    return userNotesConfiguration.getDataSourceFactory();
                }
            };

    public static void main(final String[] args) throws Exception {
        new UserNotesApplication().run(args);
    }

    @Override
    public String getName() {
        return "UserNotes";
    }

    @Override
    public void initialize(final Bootstrap<UserNotesConfiguration> bootstrap)
    {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final UserNotesConfiguration configuration,
                    final Environment environment) {

        final NoteDAO noteDAO = new NoteDAO(hibernateBundle.getSessionFactory());

        environment.jersey().register(new NoteResource(noteDAO));
    }

}

package com.brit.usernotes;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserNotesApplication extends Application<UserNotesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new UserNotesApplication().run(args);
    }

    @Override
    public String getName() {
        return "UserNotes";
    }

    @Override
    public void initialize(final Bootstrap<UserNotesConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final UserNotesConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}

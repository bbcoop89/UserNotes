package com.brit.usernotes.db;

import com.brit.usernotes.core.Note;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class NoteDAO extends AbstractDAO<Note>
{

    public NoteDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Note> findAll()
    {
        return list(
                namedQuery(
                        "com.brit.usernotes.core.Note.findAll"
                )
        );
    }
}

package com.brit.usernotes.db;

import com.brit.usernotes.core.Note;
import com.google.common.base.Optional;
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

    public Optional<Note> findById(long id)
    {
        return Optional.fromNullable(get(id));
    }

    public Note save(Note note)
    {
        return persist(note);
    }

    public void delete(Note note)
    {
        namedQuery(
                "com.brit.usernotes.core.Note.delete"
        )
                .setParameter("id", note.getId())
                .executeUpdate();
    }

}

package com.brit.usernotes.resources;

import com.brit.usernotes.core.Note;
import com.brit.usernotes.db.NoteDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteResource
{
    private NoteDAO noteDAO;

    public NoteResource(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public NoteDAO getNoteDAO() {
        return noteDAO;
    }

    public void setNoteDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @GET
    @UnitOfWork
    public List<Note> getNotes()
    {
        return this.noteDAO.findAll();
    }

}

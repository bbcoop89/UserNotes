package com.brit.usernotes.resources;

import com.brit.usernotes.core.Note;
import com.brit.usernotes.db.NoteDAO;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
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

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Note> getNote(@PathParam("id")LongParam id)
    {
        return this.noteDAO.findById(id.get());
    }
}

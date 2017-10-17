package com.brit.usernotes.resources;

import com.brit.usernotes.core.Note;
import com.brit.usernotes.core.User;
import com.brit.usernotes.db.NoteDAO;
import com.google.common.base.Optional;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Time;
import java.util.Date;
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
    public List<Note> getNotes(@Auth User user)
    {
        return this.noteDAO.findForUser(user.getId());
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<Note> getNote(@PathParam("id")LongParam id, @Auth User user)
    {
        return this.findIfAuthorized(id.get(), user.getId());
    }

    @POST
    @UnitOfWork
    public Note saveNote(Note note, @Auth User user)
    {
        note.setUser(user);
        note.setLastUpdate(new Time(new Date().getTime()));
        return this.noteDAO.save(note);
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public Optional<Note> delete(@PathParam("id") LongParam id, @Auth User user)
    {
        Optional<Note> note = this.findIfAuthorized(id.get(), user.getId());

        if(note.isPresent()) {
            this.noteDAO.delete(note.get());
        }

        return note;
    }

    @PUT
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Note update(Note note, @Auth User user)
    {
        if(note.getUser().getId() != user.getId()) {
            throw new ForbiddenException("You are not authorized to update this resource");
        }

        note.setNote(note.getNote());
        note.setTitle(note.getTitle());
        note.setLastUpdate(new Time(new Date().getTime()));

        this.noteDAO.save(note);

        return note;
    }

    public Optional<Note> findIfAuthorized(long noteId, long userId)
    {
        Optional<Note> result = this.noteDAO.findById(noteId);

        if(result.isPresent() && userId != result.get().getUser().getId()) {
            throw new ForbiddenException("You are not authorized to view this resource");
        }

        return result;
    }
}

package com.brit.usernotes.core;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "note")
@NamedQueries({
        @NamedQuery(
                name = "com.brit.usernotes.core.Note.findAll",
                query = "select n from Note n"
        ),
        @NamedQuery(
                name = "com.brit.usernotes.core.Note.delete",
                query = "delete from Note n where n.id = :id"
        ),
        @NamedQuery(
                name = "com.brit.usernotes.core.Note.findForUser",
                query = "select n from Note n where n.user.id = :id"
        )
})
public class Note
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "note")
    private String note;

    @Column(name = "note_create_time")
    private Time create;

    @Column(name = "note_last_update_time")
    private Time lastUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    protected void onCreate() {
        this.create = new Time(new Date().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = new Time(new Date().getTime());
    }

    public Note() {
        this.create = new Time(new Date().getTime());
    }

    public Note(String title, String note, Time create, Time lastUpdate) {
        this.title = title;
        this.note = note;
        this.create = create;
        this.lastUpdate = lastUpdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Time getCreate() {
        return create;
    }

    public void setCreate(Time create) {
        this.create = create;
    }

    public Time getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Time lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

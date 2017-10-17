package com.brit.usernotes.core;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name = "com.brit.usernotes.core.User.findByEmailPassword",
                query = "select u from User u where u.email = :email and u.password = :password"
        )
})
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_create_time")
    private Time create;

    @Column(name = "user_last_update_time")
    private Time lastUpdate;

    @PrePersist
    protected void onCreate() {
        this.create = new Time(new Date().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdate = new Time(new Date().getTime());
    }

    public User() {
        this.create = new Time(new Date().getTime());
    }

    public User(String email, String password, Time create, Time lastUpdate)
    {
        this.email = email;
        this.password = password;
        this.create = create;
        this.lastUpdate = lastUpdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        return getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}

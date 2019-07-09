package com.ticketsh.ticketshow.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "rolList")
    private List<User> users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private List<Privilage> privilages;

    public Rol(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Rol() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Privilage> getPrivilages() {
        return privilages;
    }

    public void setPrivilages(List<Privilage> privilages) {
        this.privilages = privilages;
    }
}

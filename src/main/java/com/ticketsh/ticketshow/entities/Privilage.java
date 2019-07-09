package com.ticketsh.ticketshow.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "privilege")
public class Privilage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "privilages")
    private List<Rol> rolList;

    public Privilage(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Privilage() {
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

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
}

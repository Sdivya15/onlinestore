package com.onlineshop.dresses.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fabrics")
public class Fabrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Fabrics() {
    }

    public Fabrics(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}

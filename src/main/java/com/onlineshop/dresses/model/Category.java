package com.onlineshop.dresses.model;


import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String categoryType;
    private Boolean isAvailable;


    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Category() {
    }

    public Category(long id, String categoryType, Boolean isAvailable) {
        this.id = id;
        this.categoryType = categoryType;
        this.isAvailable = isAvailable;
    }
}

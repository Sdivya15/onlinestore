package com.onlineshop.dresses.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dresses")
public class Dress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;
    //private String color;
    private Boolean isAvailable;
    private Double discount;

    @ElementCollection
    @CollectionTable(name = "dress_sizes", joinColumns = @JoinColumn(name = "dress_id"))//dress_id is fk
    @Column(name = "size")
    private List<String> availableSizes;//this becomes a seperate table

    @ElementCollection
    @CollectionTable(name = "dress_colors", joinColumns = @JoinColumn(name = "dress_id"))
    @Column(name = "color")
    private List<String> availableColors;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "fabric_id")
    private Fabrics fabric;

    @ElementCollection
    @CollectionTable(name = "dress_images", joinColumns = @JoinColumn(name = "dress_id"))
    @Column(name = "image_url")
    private List<String> imageUrls;


    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Fabrics getFabric() { return fabric; }
    public void setFabric(Fabrics fabric) { this.fabric = fabric; }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public List<String> getAvailableColors() {
        return availableColors;
    }

    public void setAvailableColors(List<String> availableColors) {
        this.availableColors = availableColors;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<String> getAvailableSizes() {
        return availableSizes;
    }

    public void setAvailableSizes(List<String> availableSizes) {
        this.availableSizes = availableSizes;
    }

    public Dress(Long id, String name, Double price, String description,
                 Boolean isAvailable, Double discount, List<String> availableSizes,List<String> imageUrls,
                 List<String> availableColors, Category category, Fabrics fabric) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
        this.discount = discount;
        this.availableSizes = availableSizes;
        this.availableColors = availableColors;
        this.imageUrls = imageUrls;
        this.category = category;
        this.fabric = fabric;
    }

    public Dress() {
    }

}

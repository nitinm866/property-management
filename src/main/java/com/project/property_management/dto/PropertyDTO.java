package com.project.property_management.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Getter
@Setter
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private double price;

    /*public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }*/
}

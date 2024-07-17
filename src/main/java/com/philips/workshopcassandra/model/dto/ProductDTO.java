package com.philips.workshopcassandra.model.dto;

import com.philips.workshopcassandra.model.embedded.Prop;
import com.philips.workshopcassandra.model.entities.Product;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDTO {
    private UUID id;
    private String department;
    private double price;
    private Instant moment;
    private String name;
    private String description;
    private List<Prop> props = new ArrayList<>();

    public ProductDTO(){}
    public ProductDTO(UUID id, String department, double price, Instant moment, String name, String description) {
        this.id = id;
        this.department = department;
        this.price = price;
        this.moment = moment;
        this.name = name;
        this.description = description;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.department = entity.getDepartment();
        this.price = entity.getPrice();
        this.moment = entity.getMoment();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.props.addAll(entity.getProps());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
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

    public List<Prop> getProps() {
        return props;
    }

}

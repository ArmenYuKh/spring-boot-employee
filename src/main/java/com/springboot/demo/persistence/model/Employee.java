package com.springboot.demo.persistence.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String position;

    private String phone;

    @Override
    public String toString() {
        return String.join(", ", new String[] {
                "Employee # " + id,
                name, position, phone
        });
    }

    public Employee() {
    }

    public Employee(String name, String position, String phone) {
        this.name = name;
        this.position = position;
        this.phone = phone;
    }
}

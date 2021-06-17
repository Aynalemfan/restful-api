package com.project.restfulapi;

import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;


@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String training;
    private LocalDate date;

    public Employee(Long id,String name,String training,LocalDate date) {
        this.id = id;
        this.name = name;
        this.training = training;
        this.date = date;
    }

    public Employee(String name,String training,LocalDate date) {
        this.name = name;
        this.training = training;
        this.date = date;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTraining() {
        return training;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

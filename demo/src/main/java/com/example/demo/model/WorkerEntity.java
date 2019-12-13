package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "CBR_WORKER")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "s_job")
    private String job;

    @Column(name = "s_first_name")
    private String firstName;

    @Column(name = "s_last_name")
    private String lastName;

    @Column(name = "s_middle_name")
    private String middleName;

    @Transient
    private String fullName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return job + ", " + firstName + " " + lastName + " " + middleName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "WorkerEntity [id=" + id + ", job=" + job + ", firstName=" + firstName +
                ", lastName=" + lastName + ", middleName=" + middleName + "]";
    }
}
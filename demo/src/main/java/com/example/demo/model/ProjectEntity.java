package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="CBR_PROJECT")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="s_name")
    private String name;
    
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

    @Override
    public String toString() {
        return "ProjectEntity [id=" + id + ", name=" + name + "]";
    }
}
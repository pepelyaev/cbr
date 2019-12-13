package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CBR_ACCOUNTING")
public class AccountingEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="project_id")
    private Long projectId;
    
    @Column(name="worker_id")
    private Long workerId;

	@Column(name="s_task")
	private String task;

	@Column(name="d_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;

	@Column(name="d_time")
	private Integer hms;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getHms() {
		return hms;
	}
	public void setHms(Integer hms) {
		this.hms = hms;
	}

	@Override
    public String toString() {
        return "AccountingEntity [id=" + id + ", projectId=" + projectId + ", workerId=" + workerId +
                ", task=" + task + ", date=" + date  + ", hms=" + hms + "]";
    }
}

package dev.hogue.entities;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "instructions")
public class Instruction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="i_id")
	private int i_id;
	
	@NotNull
	@Column(name = "stepOrder")
	private int stepOrder;
	
	@NotNull
	@Column(name = "isSub")
	private boolean isSub;
	
	@NotNull
	@Column(name = "prior")
	private int prior;
	
	@NotNull
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="duration")
	private Long duration;

	
	
	
	public boolean isSub() {
		return isSub;
	}
	public void setSub(boolean isSub) {
		this.isSub = isSub;
	}
	public int getPriorStepId() {
		return prior;
	}
	public void setPriorStepId(int priorStepId) {
		this.prior = priorStepId;
	}
	public Instruction() {
		super();
	}
	public void setStepId(int priorStepId) {
		this.prior = priorStepId;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public void setId(int id) {
		this.i_id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(int stepOrder) {
		this.stepOrder = stepOrder;
	}
	public int getId() {
		return i_id;
	}

	
}

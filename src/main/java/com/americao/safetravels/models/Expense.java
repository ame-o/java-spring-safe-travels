package com.americao.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
    @Size(min = 5, max = 200, message ="Write more than 5 characters.")
	private String expenseName;
	@NotNull
    @Size(min = 5, max = 200, message ="Write more than 5 characters.")
	private String vendor;
	@NotNull
	@Min(value=1, message ="No zero.")
	private Integer amount;
	@NotNull
	@Size(min = 5, max = 200, message ="Write more than 5 characters.")
	private String description;
// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
 
    public Expense() {
    }
    
    public Expense (String name, String vendor, Integer amount, String description) {
    	this.expenseName = name;
    	this.vendor = vendor;
    	this.amount = amount;
    	this.description = description;
    }

//  -----before getters and setters----------
  @PrePersist
  protected void onCreate(){
  	this.createdAt = new Date();
  }
  @PreUpdate
  protected void onUpdate(){
  	this.updatedAt = new Date();
  }
//  --------getters and setters ---------
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getExpenseName() {
	return expenseName;
}
public void setExpenseName(String expenseName) {
	this.expenseName = expenseName;
}
public String getVendor() {
	return vendor;
}
public void setVendor(String vendor) {
	this.vendor = vendor;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
  
}


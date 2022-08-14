package com.codingdojo.mvc.model;


	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.PrePersist;
	import javax.persistence.PreUpdate;
	import javax.persistence.Table;

	@Entity
	@Table(name="employees")
public class EmModel {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
	    private String firstName;
	    
	    private String lastName;
	    
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @OneToMany(mappedBy="manager", fetch=FetchType.LAZY)
	    private List<EmModel> employees;
	    
	    @ManyToOne(fetch=FetchType.LAZY)
	    private EmModel manager;

		public EmModel() {
		}
		
		
		public EmModel(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
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

		public List<EmModel> getEmployees() {
			return employees;
		}

		public void setEmployees(List<EmModel> employees) {
			this.employees = employees;
		}

		public EmModel getManager() {
			return manager;
		}

		public void setManager(EmModel manager) {
			this.manager = manager;
		}

		public Long getId() {
			return id;
		}
		
		public void setEmployeeToManger(EmModel emp) {
			if(employees == null)
				employees = new ArrayList<EmModel>();
			employees.add(emp);
		}
		
		@PrePersist
		protected void onCreate(){
		    this.createdAt = new Date();}
		@PreUpdate
		protected void onUpdate(){
		   this.updatedAt = new Date();}  
	    
		
	
}

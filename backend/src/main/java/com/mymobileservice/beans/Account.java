package com.mymobileservice.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column
	private String firstname;
    @Column
	private String lastname;
    @Column
	private String address;
    @Column
	private String address2;
    @Column
	private String city;
    @Column
	private String state;
    @Column
	private Integer zipcode;
    @OneToOne(optional=false)
    @JoinColumn(name="email")
	private String email;
    @Column
    private double balance;
    @OneToMany
    private Set<Lines> line;
    
    public Account() {	}

	public Account(Integer id, String firstname, String lastname, String address, String address2, String city,
			String state, Integer zipcode, String email, Set<Lines> line) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
        Set<Lines> newLines = new HashSet<Lines>();
        if(this.getLine() != null){
            for (Lines lines2 : this.getLine()) {
                newLines.add(lines2);
            }
        }
        this.line = newLines;
		
	}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Lines> getLine() {
        return line;
    }

    public void setLine(Set<Lines> line) {
        this.line = line;
    }


    @Override
    public String toString() {
        return "Account ID: " + id + ", email: " + email + ", First Name: " + firstname + ", Last Name: " + lastname + ", Address: " + address + ", Address 2: " 
        + address2 + ", city: " + city + ", state: " + state + ", zipcode=" + zipcode + ", lines:" + line + ".";
    }

}

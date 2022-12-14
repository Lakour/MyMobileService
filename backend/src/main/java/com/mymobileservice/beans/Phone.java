package com.mymobileservice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="phoneinfo")
public class Phone {
	@Id //laying out the table columns as private variables
	private Double phoneid;
	@Column
	private String manufacterer;
	@Column
	private String model;
	@Column
	private String memory;
	@Column
	private Double price;
	@Column
	private String colors;
	
	public Phone() { }

	public Phone(Double phoneid, String manufacterer, String model, 
			String memory, Double price, String color2) {
		super();
		this.phoneid = phoneid;
		this.manufacterer = manufacterer;
		this.model = model;
		this.memory = memory;
		this.price = price;
		this.colors = color2;
		
	}

	public Double getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(Double phoneid) {
		this.phoneid = phoneid;
	}

	public String getManufacterer() {
		return manufacterer;
	}

	public void setManufacterer(String manufacterer) {
		this.manufacterer = manufacterer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return colors;
	}

	public void setColor(String color) {
		this.colors = color;
	}

    // public List<String> getColorList() {
    //     return ColorList;
    // }

    // public void setColorList(List<String> ColorList) {
    //     this.ColorList = ColorList;
    // }

}

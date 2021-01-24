package com.hibPrac.LazyEager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alien {
	
	@Id
	private int aId;
	private String aName;
	private String aColor;

	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER)
	private List<Laptop> laptop = new ArrayList<Laptop>();

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaColor() {
		return aColor;
	}

	public void setaColor(String aColor) {
		this.aColor = aColor;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + aName + ", aColor=" + aColor + ", laptop=" + laptop + "]";
	}
}

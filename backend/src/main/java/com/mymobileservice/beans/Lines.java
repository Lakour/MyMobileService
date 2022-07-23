package com.mymobileservice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mymobileservice.models.LinesModel;

@Entity
@Table(name="phonelines")
public class Lines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String phonenumber;
	@OneToOne
	@JoinColumn(name="phoneid")
	private Phone phoneid; // aka phone information
	@Column
	private String calleridname;
	@Column
	private Double remphonebal;

	@OneToOne
	@JoinColumn(name="plan")
	private Plans plan;
	@ManyToOne
	@JoinColumn(name="accountid")
	private Account account;
	
	public Lines() { }

	public Lines(String phonenumber, Phone phoneid, String calleridname, Double remphonebal, Plans plan) {
		this.phonenumber = phonenumber;
		this.phoneid = phoneid;
		this.calleridname = calleridname;
		this.remphonebal = remphonebal;
		this.plan = plan;
	}

	public Lines(LinesModel lines) {
		this.phonenumber = lines.getPhonenumber();
		this.phoneid = lines.getPhoneid();
		this.calleridname = lines.getCalleridname();
		this.remphonebal = lines.getRemphonebal();
		this.plan = lines.getPlan();
		
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Phone getPhoneid() {
		return phoneid;
	}

	public void setPhoneid(Phone phoneid) {
		this.phoneid = phoneid;
	}

	public String getCalleridname() {
		return calleridname;
	}

	public void setCalleridname(String calleridname) {
		this.calleridname = calleridname;
	}

	public Double getRemphonebal() {
		return remphonebal;
	}

	public void setRemphonebal(Double remphonebal) {
		this.remphonebal = remphonebal;
	}

	public Plans getPlan() {
		return plan;
	}

	public void setPlan(Plans plan) {
		this.plan = plan;
	}
	
}

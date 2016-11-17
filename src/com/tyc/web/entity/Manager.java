package com.tyc.web.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="manager")
public class Manager implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mid",unique=true,nullable=false)
	private int mid;
	
	
	@Column(length=32)
	private String passwd;
	
	public String getMidString()
	{
		String tmp=String.valueOf(mid);
		return tmp;
	}
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
}

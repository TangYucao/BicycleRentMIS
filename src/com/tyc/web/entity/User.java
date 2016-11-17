package com.tyc.web.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="uid",unique=true,nullable=false)
	private int uid;
	
	@Column(length=32,unique=true)
	private String uphonenum;
	 
	@Column(length=32)
	private String upasswd;
	
	@Column(length=32)
	private Long umoney;
	
	public void setUmoney(Long umoney) {
		this.umoney = umoney;
	}
	public Long getUmoney() {
		return umoney;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	public String getUphonenum() {
		return uphonenum;
	}
	public void setUphonenum(String uphonenum) {
		this.uphonenum = uphonenum;
	}
}

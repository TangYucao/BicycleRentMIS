package com.tyc.web.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JoinColumnsOrFormulas;

@Entity
@Table(name="rent")
public class Rent implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "paymentableGenerator", strategy = "increment")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rid",unique=true,nullable=false)
	private int rid;
	
	@Column(length=32)
	private String rrenttime;//租赁结束时间
	
	
	@ManyToOne
	@JoinColumns({
	@JoinColumn(name="bid" ,referencedColumnName="bid"),
	@JoinColumn(name="brentmoney",referencedColumnName="brentmoney")}
	)
	private Bicycle bicycle;
	
	
	@OneToOne  
    @JoinColumn(name="uphonenum",referencedColumnName="uphonenum") 
	private User user;
	
	
	
	@Column(length=32)
	private String rfee;//费用

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getRfee() {
		return rfee;
	}

	public void setRfee(String rfee) {
		this.rfee = rfee;
	}


	public String getRrenttime() {
		return rrenttime;
	}

	public void setRrenttime(String rrenttime) {
		this.rrenttime = rrenttime;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	
	
	
}

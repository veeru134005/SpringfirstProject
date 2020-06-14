package com.app.entityPojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity()
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="Student_Addres")
public class Address implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Column(name = "AddressId")
//	private static final Integer serialVersionUID = 1;
	
	@Id
	@Column(name="AddressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer AddressId;
	
	@Column(name="City")
	private String cityName;
	@Column(name = "State")
	private String state;
	@Column(name = "PinCode")
	private String pinCode;
	@Column(name = "StreetName")
	private String streetName;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId",nullable=false)
	private Student std_Id;

	public Integer getAddressId() {
		return AddressId;
	}

	public void setAddressId(Integer addressId) {
		AddressId = addressId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Student getStd_Id() {
		return std_Id;
	}

	public void setStd_Id(Student std_Id) {
		this.std_Id = std_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}

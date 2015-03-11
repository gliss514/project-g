package project.g.customer.model;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import project.g.core.data.BaseObject;

public class Customer extends BaseObject {

	private static final long serialVersionUID = -7117643736347789430L;

	private String name;

	private String code;

	private String companyName;

	private String emailAddress;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	private String address;

	private String contactNo;

	private String salesPerson;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

}

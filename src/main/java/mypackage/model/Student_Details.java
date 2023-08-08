package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
@Table(name = "tbl_studentdetails")
public class Student_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int student_id;
private String student_name;
private String Qualification;
private int mobile;
private String email_address;
private String City;
private String password;
@OneToMany(mappedBy = "student_details",cascade = CascadeType.ALL)
@JsonIgnoreProperties("student_details")
private Set<Exam_Details> exam_details;
public Student_Details() {
	super();
	// TODO Auto-generated constructor stub
}
public Student_Details(int student_id, String student_name, String qualification, int mobile, String email_address,
		String city, String password, Set<Exam_Details> exam_details) {
	super();
	this.student_id = student_id;
	this.student_name = student_name;
	Qualification = qualification;
	this.mobile = mobile;
	this.email_address = email_address;
	City = city;
	this.password = password;
	this.exam_details = exam_details;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getQualification() {
	return Qualification;
}
public void setQualification(String qualification) {
	Qualification = qualification;
}
public int getMobile() {
	return mobile;
}
public void setMobile(int mobile) {
	this.mobile = mobile;
}
public String getEmail_address() {
	return email_address;
}
public void setEmail_address(String email_address) {
	this.email_address = email_address;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Set<Exam_Details> getExam_details() {
	return exam_details;
}
public void setExam_details(Set<Exam_Details> exam_details) {
	this.exam_details = exam_details;
}
}

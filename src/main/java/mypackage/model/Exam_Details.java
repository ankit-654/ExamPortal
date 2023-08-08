package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_examdetails")
public class Exam_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_id;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "student_id",nullable = false)
	private Student_Details student_details;
	private String date;
	private String start_time;
	private String end_time;
	public Exam_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam_Details(int exam_id, Student_Details student_details, String date, String start_time, String end_time) {
		super();
		this.exam_id = exam_id;
		this.student_details = student_details;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public Student_Details getStudent_details() {
		return student_details;
	}
	public void setStudent_details(Student_Details student_details) {
		this.student_details = student_details;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	@OneToMany(mappedBy = "examdetails",cascade =CascadeType.ALL )
	@JsonIgnoreProperties("examdetails")
	private Set<Exam_Questions> exam_questions;
	public Exam_Details(int exam_id, Student_Details student_details, String date, String start_time, String end_time,
			Set<Exam_Questions> exam_questions) {
		super();
		this.exam_id = exam_id;
		this.student_details = student_details;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.exam_questions = exam_questions;
	}
	public Set<Exam_Questions> getExam_questions() {
		return exam_questions;
	}
	public void setExam_questions(Set<Exam_Questions> exam_questions) {
		this.exam_questions = exam_questions;
	}
}

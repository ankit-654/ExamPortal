package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_examquestion")
public class Exam_Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exam_question_id;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "exam_id",nullable = false)
	private Exam_Details examdetails;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "question_id",nullable = false)
	private Content_Questions content_questions;
	private String Submitted_option_number;
	public Exam_Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exam_Questions(int exam_question_id, Exam_Details examdetails, Content_Questions content_questions,
			String submitted_option_number) {
		super();
		this.exam_question_id = exam_question_id;
		this.examdetails = examdetails;
		this.content_questions = content_questions;
		Submitted_option_number = submitted_option_number;
	}
	public int getExam_question_id() {
		return exam_question_id;
	}
	public void setExam_question_id(int exam_question_id) {
		this.exam_question_id = exam_question_id;
	}
	public Exam_Details getExamdetails() {
		return examdetails;
	}
	public void setExamdetails(Exam_Details examdetails) {
		this.examdetails = examdetails;
	}
	public Content_Questions getContent_questions() {
		return content_questions;
	}
	public void setContent_questions(Content_Questions content_questions) {
		this.content_questions = content_questions;
	}
	public String getSubmitted_option_number() {
		return Submitted_option_number;
	}
	public void setSubmitted_option_number(String submitted_option_number) {
		Submitted_option_number = submitted_option_number;
	}
	
	

}

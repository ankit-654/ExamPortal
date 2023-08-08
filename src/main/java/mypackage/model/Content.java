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

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "tbl_contents")
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int content_id;
	private String content_name;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "topic_id",nullable = false)
	private Topic topic;
	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Content(int content_id, String content_name, Topic topic) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		this.topic = topic;
	}
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getContent_name() {
		return content_name;
	}
	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	@OneToMany(mappedBy = "content",cascade =CascadeType.ALL )
	@JsonIgnoreProperties("content")
	private Set<Content_Questions> content_questions;
	public Content(int content_id, String content_name, Topic topic, Set<Content_Questions> content_questions) {
		super();
		this.content_id = content_id;
		this.content_name = content_name;
		this.topic = topic;
		this.content_questions = content_questions;
	}
	public Set<Content_Questions> getContent_questions() {
		return content_questions;
	}
	public void setContent_questions(Set<Content_Questions> content_questions) {
		this.content_questions = content_questions;
	}

}

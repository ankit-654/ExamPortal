package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Exam_Questions;
import mypackage.services.Exam_QuestionService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Exam_QuestionController {

	@Autowired Exam_QuestionService eqservice;
	
	@GetMapping("exam_question")
	public List<Exam_Questions> GetAllExamQuestion(){
		return eqservice.GetAllExamQuestion();
	}
	
	@PostMapping("exam_question")
	public String AddExamQuestion(@RequestBody Exam_Questions e) {
		eqservice.AddExam_Question(e);
		return "Added";
	}
	
	@GetMapping("exam_question/{id}")
	public Exam_Questions GetExam_QuestionById(@PathVariable("id") int id) {
		return eqservice.GetExamQuestionById(id);
	}
	
}

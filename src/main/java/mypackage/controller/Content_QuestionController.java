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

import mypackage.model.Content;
import mypackage.model.Content_Questions;
import mypackage.model.Topic;
import mypackage.services.Content_QuestionService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Content_QuestionController {

	@Autowired Content_QuestionService cqservice;
	
//	@GetMapping("content_question")
//	public List<Content_Questions> GetQuestions() {
//		return cqservice.GetAllContentQuestions();
//	}
	
	@PostMapping("content_question")
	public String AddContentQuestions(@RequestBody Content_Questions c) {
		return cqservice.AddContentQuestion(c);
	}
	
	@GetMapping("content_question/{id}")
	public Content_Questions GetContentQuestionsById(@PathVariable("id") int id) {
		return cqservice.GetContentQuestionById(id);
	}
	
	@GetMapping("content_question")
	public List<Content_Questions> GetContentwithQuestion(){
		return cqservice.GetContentwithContentQuestion();
	}
	
	
	
}

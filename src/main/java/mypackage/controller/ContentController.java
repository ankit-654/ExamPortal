package mypackage.controller;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Content;
import mypackage.model.Topic;
import mypackage.services.ContentService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class ContentController {

	@Autowired ContentService cservice;
	
	@PostMapping("/topiccontent")
	public String AddTopicContent(@RequestBody Topic t) {
		System.out.println(t.getTopic_id()+" "+t.getTopic_name()+" "+t.getContents());
		return cservice.AddTopicContent(t);
	}
	
	@GetMapping("/topiccontent")
	public List<Content> GetAllContentList(){
		return cservice.GetContents();
	}
	
	
	@GetMapping("/topiccontent/{id}")
	public Content GetContentByID(@PathVariable("id") int id) {
		return cservice.GetContentById(id);
	}
	
	@DeleteMapping("/topiccontent/{id}")
	public String DeleteContentById(@PathVariable("id") int id) {
		return cservice.DeleteContent(id);
	}
//	@PutMapping("/update_topiccontent")
//	public String UpdateData(@RequestBody Topic t) {
//		Topic to=new Topic(0, t.getTopic_name(), t.getContents());
//		return cservice.UpdateTopicContent(t);
//	}
	
}

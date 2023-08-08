package mypackage.controller;

import java.util.List;

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

import mypackage.model.Topic;
import mypackage.repository.TopicRepository;
import mypackage.services.TopicService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class TopicController {

    @Autowired TopicService tservice;
	
	@PostMapping("/topic")
	public String AddTopics(@RequestBody Topic t) {
		System.out.println(t.getTopic_id()+" "+t.getTopic_name());
		tservice.AddTopic(t);
		return "Added";
	}
	
	@GetMapping("filter/topic/{ch}")
	public List<Topic>FilterTopic(@PathVariable("ch") String ch){
		return tservice.FilterTopicbyName(ch);
	}
	
	@GetMapping("/topic")
	public  List<Topic> GetTopics() {
		return tservice.getTopics();
	}
	
	@GetMapping("topic/{id}")
	public Topic GetByTopicId(@PathVariable("id") int id) {
		return tservice.GetById(id);
	}
	
	@PutMapping("/topic")
	public String  UpdateTopics(@RequestBody Topic t) {
		Topic to=new Topic(t.getTopic_id(), t.getTopic_name(), null);
		tservice.UpdateTopic(to);
		return "Updated";
	}
	
	@DeleteMapping("/topic/{id}")
	public String DeleteTopicById(@PathVariable("id") int id) {
		return tservice.DeleteTopicById(id);
	}

}

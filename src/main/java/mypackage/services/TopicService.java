package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import mypackage.model.Topic;
import mypackage.repository.TopicRepository;
@Service
public class TopicService {

	@Autowired TopicRepository topicrepo;
	
	public List<Topic> getTopics(){
		List<Topic> lst=new ArrayList<Topic>();
		for(Topic t:topicrepo.findAll()) {
			Topic to=new Topic(t.getTopic_id(), t.getTopic_name(), null) ;
			lst.add(to);
			}
		return lst;
	}
	
	public List<Topic>FilterTopicbyName(@PathVariable("ch") String ch){
		List<Topic>lst=new ArrayList<Topic>();
		for(Topic t:topicrepo.findAll()) {
			if(t.getTopic_name().toLowerCase().contains(ch.toLowerCase())) {
				Topic to=new Topic(t.getTopic_id(), t.getTopic_name(), null);
				lst.add(to);
			}
		}
		return lst;
		
	}
	
	public Topic AddTopic(Topic t) {
		return topicrepo.save(t);
	 }
	
	public Topic GetById(int id) {
		Topic t=topicrepo.findById(id).get();
		return t;
	}
	
	public Topic UpdateTopic(Topic t) {
		return topicrepo.save(t);
	}
	
//	public Topic DeleteTopic(int id) {
//		Topic t=topicrepo.findById(id).get();
//	    topicrepo.delete(t);
//	return t;
	public String DeleteTopicById(@PathVariable("id") int id) {
		Topic t=topicrepo.findById(id).get();
		topicrepo.delete(t);
		return "deleted";
	}
	
}

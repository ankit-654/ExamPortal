package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import mypackage.model.Content;
import mypackage.model.Content_Questions;
import mypackage.model.Topic;
import mypackage.repository.ContentRepository;
import mypackage.repository.TopicRepository;

@Service
public class ContentService {

	@Autowired ContentRepository contentrepo;
	@Autowired TopicRepository topicrepo;
	
	public List<Content> GetContents(){
		List<Content> lst=new ArrayList<Content>();
		for(Content c:contentrepo.findAll()) {
//			=topicrepo.getOne(c.getTopic().getTopic_id());
			Topic t =new Topic(c.getTopic().getTopic_id(),c.getTopic().getTopic_name(),null); 
			Content co=new Content(c.getContent_id(), c.getContent_name(),t);
			lst.add(co);		
			}
		return lst;
	}
	
	
	public Content GetContentById(int id) {
		Content c=contentrepo.findById(id).get();
		Content co=new Content(c.getContent_id(), c.getContent_name(), null, null);
//		for(Topic t:c.getTopic()) {
//			Topic to=new Topic(t.getTopic_id(), t.getTopic_name(), co);
//		}
		return co;
	}
	
	
	
	public String AddTopicContent(Topic t) {
		Topic to=new Topic(0, t.getTopic_name(), null);
		Topic ti=topicrepo.save(to);
		for(Content c:t.getContents()) {
			Content co=new Content(0, c.getContent_name(), ti, null);
			contentrepo.save(co);	
		}
		return "Added";
	}
	
//	public String AddTopicContent(Content c) {	
//		contentrepo.save(c);
//		return "Added";
//		}
	
	
	public String UpdateTopicContent(Topic t) {
//		Topic to=topicrepo.save(t);
		Topic to=new Topic(t.getTopic_id(), t.getTopic_name(), t.getContents());
		topicrepo.save(to);
		return "Updated";
	}
	
	
	public String  DeleteContent(int id) {
		Content c=contentrepo.findById(id).get();
//		Content co=new Content(c.getContent_id(), c.getContent_name(), null, null);
		contentrepo.delete(c);
		return "Deleted"; 
	}
	
	
}

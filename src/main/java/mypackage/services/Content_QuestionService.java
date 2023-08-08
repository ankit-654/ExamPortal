package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Content;
import mypackage.model.Content_Questions;
import mypackage.model.Topic;
import mypackage.repository.ContentRepository;
import mypackage.repository.Content_QuestionRepository;
import mypackage.repository.TopicRepository;

@Service

public class Content_QuestionService {
	TopicRepository topicrepo;
@Autowired ContentRepository conrepo;
	@Autowired Content_QuestionRepository cquesservice;
	
	/// only Content Question
	public List<Content_Questions>GetAllContentQuestions(){
		List<Content_Questions>lst=new ArrayList<Content_Questions>();
	  for(Content_Questions c:cquesservice.findAll()) {
		  Content_Questions cq=new Content_Questions(c.getQuestion_id(), null, c.getQuestion(), c.getOption1(), c.getOption2(), c.getOption3(), c.getOption4());
		  lst.add(cq);
	  }
	  return lst;
	}
	
	/// GET Property with content And content question
	public List<Content_Questions> GetContentwithContentQuestion(){
		List<Content_Questions>lst=new ArrayList<Content_Questions>();
		for(Content_Questions cq:cquesservice.findAll()) {
			Topic t=new Topic(cq.getContent().getTopic().getTopic_id(),cq.getContent().getTopic().getTopic_name(), null);
			t.setContents(null);
			Content c=new Content(cq.getContent().getContent_id(), cq.getContent().getContent_name(), t);
			Content_Questions cqu=new Content_Questions(cq.getQuestion_id(), c, cq.getQuestion(), cq.getOption1(), cq.getOption2(), cq.getOption3(), cq.getOption4());
			lst.add(cqu);
			}																																																																																																																				
		return lst;
	}
	
	
	
	public Content_Questions GetContentQuestionById(int id) {
		Content_Questions cq=cquesservice.findById(id).get();
		Content_Questions cqs=new Content_Questions(cq.getQuestion_id(), null, cq.getQuestion(), cq.getOption1(), cq.getOption2(), cq.getOption3(), cq.getOption4());
		return cqs;
	}
	
    public String AddContentQuestion(Content_Questions c) {	
		cquesservice.save(c);
		return "Added";
		}
}

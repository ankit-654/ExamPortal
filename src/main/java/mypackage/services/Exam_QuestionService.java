package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Exam_Questions;
import mypackage.repository.Exam_QuestionsRepository;

@Service
public class Exam_QuestionService {

	@Autowired Exam_QuestionsRepository examquestionrepo;
	
	public List<Exam_Questions>GetAllExamQuestion(){
		List<Exam_Questions>lst=new ArrayList<Exam_Questions>();
		for(Exam_Questions e:examquestionrepo.findAll()) {
			Exam_Questions eq=new Exam_Questions(e.getExam_question_id(), null, null, e.getSubmitted_option_number());
			lst.add(eq);
		}
		return lst;
	}
	
	public Exam_Questions  AddExam_Question(Exam_Questions e) {
		return examquestionrepo.save(e);	
	}
	
	public Exam_Questions GetExamQuestionById(int id) {
		Exam_Questions e=examquestionrepo.findById(id).get();
		Exam_Questions eq=new Exam_Questions(e.getExam_question_id(), null, null, e.getSubmitted_option_number());
		return eq;
	}
	
}

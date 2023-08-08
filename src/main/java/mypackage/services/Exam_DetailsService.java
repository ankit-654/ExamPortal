package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Exam_Details;
import mypackage.repository.Exam_DetailsRepository;

@Service
public class Exam_DetailsService {

	@Autowired Exam_DetailsRepository examdetailrepo;
	
	public List<Exam_Details> GetAllExam_Details(){
		List<Exam_Details>lst =new ArrayList<Exam_Details>();
		for(Exam_Details e:examdetailrepo.findAll()) {
			Exam_Details ed=new Exam_Details(e.getExam_id(), null, e.getDate(), e.getStart_time(), e.getEnd_time());
		    lst.add(ed);

		}
		return lst;
	}
	
	public Exam_Details AddExam_Details(Exam_Details e) {
		examdetailrepo.save(e);
		return e;
	}
	
	public Exam_Details GetExam_DetailById(int id) {
		Exam_Details e=examdetailrepo.findById(id).get();
		Exam_Details ed=new Exam_Details(e.getExam_id(), null, e.getDate(), e.getStart_time(), e.getEnd_time());
		return ed;
	}
}

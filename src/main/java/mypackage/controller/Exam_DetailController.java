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

import mypackage.model.Exam_Details;
import mypackage.services.Exam_DetailsService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Exam_DetailController {
@Autowired Exam_DetailsService edservice;

@GetMapping("exam")
public List<Exam_Details> GetAllExam_Details(){
	return edservice.GetAllExam_Details();
}

@PostMapping("exam")
public String AddExam_Details(@RequestBody Exam_Details e) {
	edservice.AddExam_Details(e);
	return "added";
}
@GetMapping("exam/{id}")
public Exam_Details GetExam_DetailsById(@PathVariable("id") int id) {
	return edservice.GetExam_DetailById(id);
}
}

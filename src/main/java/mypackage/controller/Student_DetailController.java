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

import mypackage.model.Student_Details;
import mypackage.services.Student_DetailsService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Student_DetailController {

	@Autowired Student_DetailsService sdservice;
	
	@GetMapping("student")
	public List<Student_Details> GetAllStudenrDetails() {
		return sdservice.GetStudentDetails();
	}
	
	@PostMapping("student")
		public String AddStuentDetails(@RequestBody Student_Details s) {
			sdservice.AddStudentDetails(s);
			return "added";
		}
	
	@GetMapping("student/{id}")
	public Student_Details GetStudentDetailsById(@PathVariable("id") int id) {
		return sdservice.GetStudent_DetailsById(id);
	}
	
}

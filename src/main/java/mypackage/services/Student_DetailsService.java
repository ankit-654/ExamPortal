package mypackage.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.EmailModel;
import mypackage.model.Student_Details;
import mypackage.repository.Student_DetailsRepository;

@Service

public class Student_DetailsService {
 @Autowired Student_DetailsRepository studentrepo;
 
 
 @Autowired  EmailServiceImplementation emailservice;
 
	 public List<Student_Details>GetStudentDetails(){
		 List<Student_Details>lst=new ArrayList<Student_Details>();
		 for(Student_Details s:studentrepo.findAll()) {
			 Student_Details sd=new Student_Details(s.getStudent_id(), s.getStudent_name(), s.getQualification(), s.getMobile(), s.getEmail_address(), s.getCity(), s.getPassword(), null);
			 lst.add(sd);	 
		 }
		 return lst;
	 }
	 
	 public Student_Details AddStudentDetails(Student_Details s) {
		 
		 String pass=GeneratePassword(10);
		 s.setPassword(pass);
		 Student_Details st=studentrepo.save(s);
		 String subject="Student Registration Confirmation";
		 String msgbody="Dear "+s.getStudent_name()+", Your Registration ahs been completed successfully. You can access your account using following Credentials.... Email Address="+s.getEmail_address()+" , Password="+pass;
		 
		 EmailModel e=new EmailModel(s.getEmail_address(), msgbody, subject);
		 emailservice.sendSimpleMail(e);
		 
		 return st;
		
	 }
	 
	 
	 public Student_Details GetStudent_DetailsById(int id) {
		 Student_Details s=studentrepo.findById(id).get();
		 Student_Details sd=new Student_Details(s.getStudent_id(), s.getStudent_name(), s.getQualification(), s.getMobile(), s.getEmail_address(), s.getCity(), s.getPassword(), null);
		 
		 return sd;
	 }
 
 
	 
		public String GeneratePassword(int size) {
			String data="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$";
			String password="";
			Random r=new Random();
				for(int i=1;i<=size;i++)
				{
					int p=r.nextInt(data.length()-1);
					password+=data.charAt(p);
				}
				
				return password;

		}

}

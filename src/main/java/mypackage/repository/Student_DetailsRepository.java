package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Student_Details;

public interface Student_DetailsRepository extends JpaRepository<Student_Details, Integer>{

}

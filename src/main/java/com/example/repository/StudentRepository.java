package com.example.repository;

import com.example.entity.Student;
import com.example.exceptions.StudentNotfoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(final String name);

	Student findByEmailAndName(final String email, final String name);

	List<Student> findByEmailOrName(final String email, final String name);

	List<Student> findByDepartmentDepartmentName(final String name);

	List<Student> findBySubjectsSubjectName(final String subjectName);

	List<Student> findByEmailIsLike (final String email);

	List<Student> findByNameStartsWith(final String name);

	List<Student> findByDepartmentId(final String deptId);

	@Query("{\"name\" : \"?0\" }")
	List<Student> getByName(final String name);

}

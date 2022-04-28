package com.example.service;

import com.example.entity.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

	private StudentRepository studentRepository;

	private DepartmentRepository departmentRepository;

	private SubjectRepository subjectRepository;

	public Student createStudent(final Student student) {

		if(student.getDepartment() != null) {
			departmentRepository.save(student.getDepartment());
		}

		if(student.getSubjects() != null && !student.getSubjects().isEmpty()) {
			subjectRepository.saveAll(student.getSubjects());
		}
		return studentRepository.save(student);
	}

	public Student findById(final String id) {
		final Optional<Student> student = studentRepository.findById(id);
		if (student.isEmpty()) {
			return null;
		}
		return student.get();
	}

	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student update(final Student student) {
		return studentRepository.save(student);
	}

	public String deleteStudent(final String id) {
		studentRepository.deleteById(id);
		return String.format("The student with id %s was deleted",id);
	}

	public List<Student> findStudentByName(final String name) {
		return studentRepository.findByName(name);
	}

	public Student findStudentByEmailAndName(final String email, final String name) {
		return studentRepository.findByEmailAndName(email,name);
	}

	public List<Student> findStudentByEmailOrName(final String email, final String name) {
		return studentRepository.findByEmailOrName(email, name);
	}

	public List<Student> getAllWithPagination(final int pageNumber, final int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> getAllWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepository.findAll(sort);
	}

	public List<Student> findByDepartmentName(final String name) {
		return studentRepository.findByDepartmentDepartmentName(name);
	}

	public List<Student> findBySubjectName(final String subjectName){
		return studentRepository.findBySubjectsSubjectName(subjectName);
	}

	public List<Student> findByEmailIsLike(final String email){
		return studentRepository.findByEmailIsLike(email);
	}

	public List<Student> findByNameStartsWith (final String name) {
		return studentRepository.findByNameStartsWith(name);
	}

	public List<Student> findByDepartmentId (final String deptId) {
		return studentRepository.findByDepartmentId(deptId);
	}

	public List<Student> getByName(final String name) {
		return studentRepository.getByName(name);
	}
}



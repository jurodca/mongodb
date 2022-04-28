package com.example.controller;

import com.example.entity.Student;
import com.example.exceptions.StudentNotfoundException;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

	private StudentService studentService;

	@PostMapping("/create")
	public Student create(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/getById/{id}")
	public Student findById(@PathVariable String id) {
		Student student = studentService.findById(id);
		if (student == null) {
			throw new StudentNotfoundException(String.format("The student with id %s not found", id));
		}

		return student;
	}

	@GetMapping("/all")
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.update(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/studentsByName/{name}")
	public List<Student> findByName(@PathVariable String name) {
		return studentService.findStudentByName(name);
	}

	@GetMapping("/studentsByNameAndMail")
	public Student studentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
		return studentService.findStudentByEmailAndName(email, name);
	}

	@GetMapping("/studentsByNameOrMail")
	public List<Student> studentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
		return studentService.findStudentByEmailOrName(email, name);
	}

	@GetMapping("/getAllWithPagination")
	public List<Student> getAllWithPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return studentService.getAllWithPagination(pageNumber, pageSize);
	}

	@GetMapping("/getAllWithSorting")
	public List<Student> getAllWithSorting() {
		return studentService.getAllWithSorting();
	}

	@GetMapping("/getByDepartmentName")
	public List<Student> getByDepartmentName(@RequestParam String deptName) {
		return studentService.findByDepartmentName(deptName);
	}

	@GetMapping("/getBySubjectName")
	public List<Student> getBySubjectName(@RequestParam String subjectName) {
		return studentService.findBySubjectName(subjectName);
	}

	@GetMapping("/getByEmailIsLike")
	public List<Student> getByEmailIsLike(@RequestParam String email) {
		return studentService.findByEmailIsLike(email);
	}

	@GetMapping("/getByNameStartsWith")
	public List<Student> getByNameStartsWith(@RequestParam String name) {
		return studentService.findByNameStartsWith(name);
	}

	@GetMapping("/getByDepartmentId")
	public List<Student> getByDepartmentId(@RequestParam String deptId) {
		return studentService.findByDepartmentId(deptId);
	}

	@GetMapping("/getByName/{name}")
	public List<Student> getByName(@PathVariable String name) {
		return studentService.getByName(name);
	}

}

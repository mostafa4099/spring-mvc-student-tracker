package com.mostafa.sna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mostafa.sna.entity.Student;
import com.mostafa.sna.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudent(Model model) {
		
		List<Student> studentList = studentService.getAllStudents();
		
		model.addAttribute("student", studentList);
		
		return "student-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String addForm(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateForm(@RequestParam("studentId") int id, Model model) {
		
		Student student = studentService.getStudent(id);
		
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		
		studentService.deleteStudent(id);
		
		return "redirect:/student/list";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName,
                                    Model model) {

        // search customers from the service
        List<Student> student = studentService.searchStudents(searchName);
                
        // add the customers to the model
        model.addAttribute("student", student);

        return "student-list";        
    }
}

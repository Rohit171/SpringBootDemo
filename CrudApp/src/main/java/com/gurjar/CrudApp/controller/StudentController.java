package com.gurjar.CrudApp.controller;

import com.gurjar.CrudApp.model.Student;
import com.gurjar.CrudApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/rest")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    // post
    @PostMapping("/save")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        return status(HttpStatus.OK).body("Student saved successfully!!");
    }

    //get
    @GetMapping("/getStudent")
    public ResponseEntity<Object> getStudent(){
        List<Student> studentList = studentRepository.findAll();
        if(!studentList.isEmpty())
            return ResponseEntity.status(HttpStatus.FOUND).body(studentList);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }


    //put
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student,@PathVariable Integer id){
        Optional<Student> stud = studentRepository.findById(id);
        if(stud.isPresent()){
            student.setId(student.getId());
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).body("Student Record Update Successfully for id " +id);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Record Not Update Successfully for id + id");

        }
    }

    //delete
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAllStudent(){
        studentRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Student Record delete Successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<Student> stud = studentRepository.findById(id);
        if(stud.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Student Record Deleted for id " + id);

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Record Not Deleted for id " + id);
        }
    }
}

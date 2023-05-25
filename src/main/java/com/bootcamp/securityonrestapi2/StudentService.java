package com.bootcamp.securityonrestapi2;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = findStudentById(id);
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setCourse(updatedStudent.getCourse());
        student.setEmail(updatedStudent.getEmail());
        student.setGpa(updatedStudent.getGpa());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = findStudentById(id);
        studentRepository.delete(student);
    }
}

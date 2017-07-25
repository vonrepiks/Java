package university.services;

import university.entities.Student;
import university.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(long id) {
        return this.studentRepository.findOne(id);
    }

    @Override
    public Student create(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> multipleCreate(Iterable<Student> students) {
        return this.studentRepository.save(students);
    }

    @Override
    public void deleteById(long id) {
        this.studentRepository.delete(id);
    }

}

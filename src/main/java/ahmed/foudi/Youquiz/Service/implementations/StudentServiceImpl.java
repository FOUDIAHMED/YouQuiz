package ahmed.foudi.Youquiz.Service.implementations;

import ahmed.foudi.Youquiz.Service.interfaces.StudentService;
import ahmed.foudi.Youquiz.dto.mapper.StudentMapper;
import ahmed.foudi.Youquiz.dto.student.StudentRequestDto;
import ahmed.foudi.Youquiz.dto.student.StudentResponseDto;
import ahmed.foudi.Youquiz.repository.StudentRepository;
import ahmed.foudi.Youquiz.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto create(StudentRequestDto studentRequestDto) {
        Student student = studentMapper.toEntity(studentRequestDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDto(savedStudent);
    }

    @Override
    public StudentResponseDto update(Long id, StudentRequestDto studentRequestDto) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update the existing student's properties
        existingStudent.setNom(studentRequestDto.getNom());
        existingStudent.setPrenom(studentRequestDto.getPrenom());
        existingStudent.setAdresse(studentRequestDto.getAdresse());
        existingStudent.setDateNaissance(studentRequestDto.getDateNaissance());
        existingStudent.setRegistrationDate(studentRequestDto.getRegistrationDate());

        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toResponseDto(updatedStudent);
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDto findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toResponseDto(student);
    }
}

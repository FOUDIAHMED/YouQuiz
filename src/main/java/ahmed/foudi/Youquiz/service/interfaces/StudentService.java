package ahmed.foudi.Youquiz.service.interfaces;

import ahmed.foudi.Youquiz.dto.student.StudentRequestDto;
import ahmed.foudi.Youquiz.dto.student.StudentResponseDto;

public interface StudentService {
    StudentResponseDto create(StudentRequestDto studentRequestDto);
    StudentResponseDto update(Long id, StudentRequestDto studentRequestDto);
    void delete(Long id);
    StudentResponseDto findById(Long id);
} 
package ahmed.foudi.Youquiz.Service.interfaces;

import ahmed.foudi.Youquiz.dto.subject.SubjectRequestDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectResponseDto;

public interface SubjectService {
    SubjectResponseDto create(SubjectRequestDto subjectRequestDto);
    SubjectResponseDto update(Long id, SubjectRequestDto subjectRequestDto);
    void delete(Long id);
    SubjectResponseDto findById(Long id);
} 
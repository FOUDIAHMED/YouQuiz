package ahmed.foudi.Youquiz.service.implementation;

import ahmed.foudi.Youquiz.dto.subject.SubjectRequestDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.SubjectMapper;
import ahmed.foudi.Youquiz.entities.Subject;
import ahmed.foudi.Youquiz.repository.SubjectRepository;
import ahmed.foudi.Youquiz.service.interfaces.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectResponseDto create(SubjectRequestDto subjectRequestDto) {
        Subject subject = subjectMapper.toEntity(subjectRequestDto);

        if (subjectRequestDto.getParentSubjectId() != null) {
            Subject parentSubject = subjectRepository.findById(subjectRequestDto.getParentSubjectId())
                    .orElseThrow(() -> new RuntimeException("Parent subject not found"));
            subject.setParentSubject(parentSubject);
        }

        Subject savedSubject = subjectRepository.save(subject);
        return subjectMapper.toResponseDto(savedSubject);
    }

    @Override
    public SubjectResponseDto update(Long id, SubjectRequestDto subjectRequestDto) {
        Subject existingSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Subject updatedSubject = subjectMapper.toEntity(subjectRequestDto);
        updatedSubject.setId(existingSubject.getId());

        if (subjectRequestDto.getParentSubjectId() != null) {
            Subject parentSubject = subjectRepository.findById(subjectRequestDto.getParentSubjectId())
                    .orElseThrow(() -> new RuntimeException("Parent subject not found"));
            updatedSubject.setParentSubject(parentSubject);
        }

        updatedSubject.setQuestions(existingSubject.getQuestions());
        Subject savedSubject = subjectRepository.save(updatedSubject);
        return subjectMapper.toResponseDto(savedSubject);
    }

    @Override
    public void delete(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Subject not found");
        }
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectResponseDto findById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        return subjectMapper.toResponseDto(subject);
    }
}
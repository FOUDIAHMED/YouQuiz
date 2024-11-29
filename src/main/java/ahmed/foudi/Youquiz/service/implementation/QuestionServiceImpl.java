package ahmed.foudi.Youquiz.service.implementation;

import ahmed.foudi.Youquiz.dto.question.QuestionRequestDto;
import ahmed.foudi.Youquiz.dto.question.QuestionResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.QuestionMapper;
import ahmed.foudi.Youquiz.entities.Question;
import ahmed.foudi.Youquiz.entities.Subject;
import ahmed.foudi.Youquiz.repository.QuestionRepository;
import ahmed.foudi.Youquiz.repository.SubjectRepository;
import ahmed.foudi.Youquiz.service.interfaces.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionMapper questionMapper;

    @Override
    public QuestionResponseDto create(QuestionRequestDto questionRequestDto) {
        Subject subject = subjectRepository.findById(questionRequestDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Question question = questionMapper.toEntity(questionRequestDto);
        question.setSubject(subject);

        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toResponseDto(savedQuestion);
    }

    @Override
    public QuestionResponseDto update(Long id, QuestionRequestDto questionRequestDto) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Subject subject = subjectRepository.findById(questionRequestDto.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Question updatedQuestion = questionMapper.toEntity(questionRequestDto);
        updatedQuestion.setId(existingQuestion.getId());
        updatedQuestion.setSubject(subject);
        updatedQuestion.setQuizQuestions(existingQuestion.getQuizQuestions());
        updatedQuestion.setAnswerQuestions(existingQuestion.getAnswerQuestions());

        Question savedQuestion = questionRepository.save(updatedQuestion);
        return questionMapper.toResponseDto(savedQuestion);
    }

    @Override
    public void delete(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("Question not found");
        }
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionResponseDto findById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        return questionMapper.toResponseDto(question);
    }
}
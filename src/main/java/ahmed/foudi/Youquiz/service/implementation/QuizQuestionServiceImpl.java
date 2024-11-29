package ahmed.foudi.Youquiz.service.implementation;

import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionRequestDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.QuizQuestionMapper;
import ahmed.foudi.Youquiz.entities.QuizQuestion;
import ahmed.foudi.Youquiz.entities.Quiz;
import ahmed.foudi.Youquiz.entities.Question;
import ahmed.foudi.Youquiz.entities.embedded.QuizQuestionKey;
import ahmed.foudi.Youquiz.repository.QuizQuestionRepository;
import ahmed.foudi.Youquiz.repository.QuizRepository;
import ahmed.foudi.Youquiz.repository.QuestionRepository;
import ahmed.foudi.Youquiz.service.interfaces.QuizQuestionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizQuestionServiceImpl implements QuizQuestionService {

    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final QuizQuestionMapper quizQuestionMapper;

    @Override
    public QuizQuestionResponseDto create(QuizQuestionRequestDto quizQuestionRequestDto) {
        Quiz quiz = quizRepository.findById(quizQuestionRequestDto.getQuizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
                
        Question question = questionRepository.findById(quizQuestionRequestDto.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        QuizQuestion quizQuestion = quizQuestionMapper.toEntity(quizQuestionRequestDto);
        QuizQuestion savedQuizQuestion = quizQuestionRepository.save(quizQuestion);
        
        return quizQuestionMapper.toResponseDto(savedQuizQuestion);
    }

    @Override
    public QuizQuestionResponseDto update(Long quizId, Long questionId, QuizQuestionRequestDto quizQuestionRequestDto) {
        QuizQuestionKey id = new QuizQuestionKey();
        id.setQuizId(quizId);
        id.setQuestionId(questionId);
        QuizQuestion existingQuizQuestion = quizQuestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QuizQuestion not found"));

        QuizQuestion updatedQuizQuestion = quizQuestionMapper.toEntity(quizQuestionRequestDto);
        QuizQuestion savedQuizQuestion = quizQuestionRepository.save(updatedQuizQuestion);
        
        return quizQuestionMapper.toResponseDto(savedQuizQuestion);
    }

    @Override
    public void delete(Long quizId, Long questionId) {
        QuizQuestionKey id = new QuizQuestionKey();
        id.setQuizId(quizId);
        id.setQuestionId(questionId);
        if (!quizQuestionRepository.existsById(id)) {
            throw new EntityNotFoundException("QuizQuestion not found");
        }
        quizQuestionRepository.deleteById(id);
    }

    @Override
    public QuizQuestionResponseDto findById(Long quizId, Long questionId) {
        QuizQuestionKey id = new QuizQuestionKey();
        id.setQuizId(quizId);
        id.setQuestionId(questionId);
        QuizQuestion quizQuestion = quizQuestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QuizQuestion not found"));
        return quizQuestionMapper.toResponseDto(quizQuestion);
    }
} 
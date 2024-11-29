package ahmed.foudi.Youquiz.service.implementations;

import ahmed.foudi.Youquiz.service.interfaces.QuizService;
import ahmed.foudi.Youquiz.dto.mapper.QuizMapper;
import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizRequestDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizResponseDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;
import ahmed.foudi.Youquiz.entities.Formateur;
import ahmed.foudi.Youquiz.entities.Quiz;
import ahmed.foudi.Youquiz.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final FormateurRepository formateurRepository;
    private final QuizMapper quizMapper;

    @Override
    public QuizResponseDto create(QuizRequestDto quizRequestDto) {
        Formateur formateur = formateurRepository.findById(quizRequestDto.getFormateurId())
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));

        Quiz quiz = quizMapper.toEntity(quizRequestDto);
        quiz.setFormateur(formateur);

        Quiz savedQuiz = quizRepository.save(quiz);
        return quizMapper.toResponseDto(savedQuiz);
    }

    @Override
    public QuizResponseDto update(Long id, QuizRequestDto quizRequestDto) {
        Quiz existingQuiz = quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        Formateur formateur = formateurRepository.findById(quizRequestDto.getFormateurId())
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));

        existingQuiz.setTitle(quizRequestDto.getTitle());
        existingQuiz.setDescription(quizRequestDto.getDescription());
        existingQuiz.setDuration(quizRequestDto.getDuration());
        existingQuiz.setScore(quizRequestDto.getScore());
        existingQuiz.setCanSeeAnswers(quizRequestDto.isCanSeeAnswers());
        existingQuiz.setCanSeeResult(quizRequestDto.isCanSeeResult());
        existingQuiz.setFormateur(formateur);

        Quiz updatedQuiz = quizRepository.save(existingQuiz);
        return quizMapper.toResponseDto(updatedQuiz);
    }

    @Override
    public void delete(Long id) {
        if (!quizRepository.existsById(id)) {
            throw new EntityNotFoundException("Quiz not found");
        }
        quizRepository.deleteById(id);
    }

    @Override
    public QuizResponseDto findById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
        return quizMapper.toResponseDto(quiz);
    }

    @Override
    public List<QuestionEmbeddedDto> findAllQuestionsByQuizId(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
        QuizResponseDto quizResponseDto = quizMapper.toResponseDto(quiz);
        return quizResponseDto.getQuizQuestions().stream().map(QuizQuestionResponseDto::getQuestion).toList();
    }

}

package ahmed.foudi.Youquiz.service.interfaces;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizRequestDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizResponseDto;

import java.util.List;

public interface QuizService {
    QuizResponseDto create(QuizRequestDto quizRequestDto);
    QuizResponseDto update(Long id, QuizRequestDto quizRequestDto);
    void delete(Long id);
    QuizResponseDto findById(Long id);

    List<QuestionEmbeddedDto> findAllQuestionsByQuizId(Long quizId);
} 
package ahmed.foudi.Youquiz.Service.interfaces;

import ahmed.foudi.Youquiz.dto.quiz.QuizRequestDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizResponseDto;

public interface QuizService {
    QuizResponseDto create(QuizRequestDto quizRequestDto);
    QuizResponseDto update(Long id, QuizRequestDto quizRequestDto);
    void delete(Long id);
    QuizResponseDto findById(Long id);
} 
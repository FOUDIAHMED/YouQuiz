package ahmed.foudi.Youquiz.Service.interfaces;

import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionRequestDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;

public interface QuizQuestionService {
    QuizQuestionResponseDto create(QuizQuestionRequestDto quizQuestionRequestDto);
    QuizQuestionResponseDto update(Long quizId, Long questionId, QuizQuestionRequestDto quizQuestionRequestDto);
    void delete(Long quizId, Long questionId);
    QuizQuestionResponseDto findById(Long quizId, Long questionId);
} 
package ahmed.foudi.Youquiz.service.interfaces;

import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentRequestDto;
import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentResponseDto;

import java.util.List;

public interface QuizAssignmentService {
    QuizAssignmentResponseDto create(QuizAssignmentRequestDto quizAssignmentRequestDto);
    QuizAssignmentResponseDto update(Long studentId, Long quizId, QuizAssignmentRequestDto quizAssignmentRequestDto);
    QuizAssignmentResponseDto delete(Long studentId, Long quizId);
    QuizAssignmentResponseDto findById(Long studentId, Long quizId);
    List<QuizAssignmentResponseDto> findAll();
} 
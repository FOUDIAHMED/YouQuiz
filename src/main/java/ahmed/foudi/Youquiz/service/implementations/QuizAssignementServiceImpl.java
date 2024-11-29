package ahmed.foudi.Youquiz.service.implementations;

import ahmed.foudi.Youquiz.service.interfaces.QuizAssignmentService;
import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentRequestDto;
import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizAssignementServiceImpl implements QuizAssignmentService {
    @Override
    public QuizAssignmentResponseDto create(QuizAssignmentRequestDto quizAssignmentRequestDto) {
        return null;
    }

    @Override
    public QuizAssignmentResponseDto update(Long studentId, Long quizId, QuizAssignmentRequestDto quizAssignmentRequestDto) {
        return null;
    }

    @Override
    public QuizAssignmentResponseDto delete(Long studentId, Long quizId) {
        return null;
    }

    @Override
    public QuizAssignmentResponseDto findById(Long studentId, Long quizId) {
        return null;
    }

    @Override
    public List<QuizAssignmentResponseDto> findAll() {
        return List.of();
    }
}

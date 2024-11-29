package ahmed.foudi.Youquiz.service.interfaces;

import ahmed.foudi.Youquiz.dto.answer.AnswerRequestDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerResponseDto;

public interface AnswerService {
    AnswerResponseDto create(AnswerRequestDto answerRequestDto);
    AnswerResponseDto update(Long id, AnswerRequestDto answerRequestDto);
    void delete(Long id);
    AnswerResponseDto findById(Long id);
} 
package ahmed.foudi.Youquiz.Service.interfaces;

import ahmed.foudi.Youquiz.dto.answervalidation.AnswerValidationRequestDto;
import ahmed.foudi.Youquiz.dto.answervalidation.AnswerValidationResponseDto;

import java.util.List;

public interface AnswerValidationService {
    AnswerValidationResponseDto create(AnswerValidationRequestDto answerValidationRequestDto);
    AnswerValidationResponseDto update(Long questionId, Long answerId, AnswerValidationRequestDto answerValidationRequestDto);
    void delete(Long questionId, Long answerId);
    AnswerValidationResponseDto findById(Long questionId, Long answerId);
    List<AnswerValidationResponseDto> findAllByQuestionId(Long questionId);
} 
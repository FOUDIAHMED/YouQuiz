package ahmed.foudi.Youquiz.service.interfaces;

import ahmed.foudi.Youquiz.dto.answerquestion.AnswerQuestionRequestDto;
import ahmed.foudi.Youquiz.dto.answerquestion.AnswerQuestionResponseDto;

import java.util.List;

public interface AnswerQuestionService {
    AnswerQuestionResponseDto create(AnswerQuestionRequestDto answerQuestionRequestDto);
    AnswerQuestionResponseDto update(Long questionId, Long answerId, AnswerQuestionRequestDto answerQuestionRequestDto);
    void delete(Long questionId, Long answerId);
    AnswerQuestionResponseDto findById(Long questionId, Long answerId);
    List<AnswerQuestionResponseDto> findAllByQuestionId(Long questionId);

} 
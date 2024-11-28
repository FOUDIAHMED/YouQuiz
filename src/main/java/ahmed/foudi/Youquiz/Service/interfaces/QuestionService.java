package ahmed.foudi.Youquiz.Service.interfaces;

import ahmed.foudi.Youquiz.dto.question.QuestionRequestDto;
import ahmed.foudi.Youquiz.dto.question.QuestionResponseDto;

public interface QuestionService {
    QuestionResponseDto create(QuestionRequestDto questionRequestDto);
    QuestionResponseDto update(Long id, QuestionRequestDto questionRequestDto);
    void delete(Long id);
    QuestionResponseDto findById(Long id);
} 
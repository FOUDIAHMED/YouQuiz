package ahmed.foudi.Youquiz.service.implementations;

import ahmed.foudi.Youquiz.service.interfaces.QuestionService;
import ahmed.foudi.Youquiz.dto.question.QuestionRequestDto;
import ahmed.foudi.Youquiz.dto.question.QuestionResponseDto;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public QuestionResponseDto create(QuestionRequestDto questionRequestDto) {
        return null;
    }

    @Override
    public QuestionResponseDto update(Long id, QuestionRequestDto questionRequestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public QuestionResponseDto findById(Long id) {
        return null;
    }
}

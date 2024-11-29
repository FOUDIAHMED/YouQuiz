package ahmed.foudi.Youquiz.service.implementations;

import ahmed.foudi.Youquiz.service.interfaces.AnswerService;
import ahmed.foudi.Youquiz.dto.answer.AnswerRequestDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.AnswerMapper;
import ahmed.foudi.Youquiz.repository.AnswerRepository;
import ahmed.foudi.Youquiz.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;
    @Override
    public AnswerResponseDto create(AnswerRequestDto answerRequestDto) {

        return null;
    }

    @Override
    public AnswerResponseDto update(Long id, AnswerRequestDto answerRequestDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AnswerResponseDto findById(Long id) {
        return null;
    }
}

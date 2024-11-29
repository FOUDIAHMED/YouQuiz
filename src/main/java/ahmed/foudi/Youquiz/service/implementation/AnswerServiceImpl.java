package ahmed.foudi.Youquiz.service.implementation;

import ahmed.foudi.Youquiz.service.interfaces.AnswerService;
import ahmed.foudi.Youquiz.dto.answer.AnswerRequestDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.AnswerMapper;
import ahmed.foudi.Youquiz.entities.Answer;
import ahmed.foudi.Youquiz.entities.Question;
import ahmed.foudi.Youquiz.repository.AnswerRepository;
import ahmed.foudi.Youquiz.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
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
        Question question = questionRepository.findById(answerRequestDto.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id: " + answerRequestDto.getQuestionId()));

        Answer answer = answerMapper.toEntity(answerRequestDto);
        answer.setQuestion(question);

        validateAnswer(answer);

        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toResponseDto(savedAnswer);
    }

    @Override
    public AnswerResponseDto update(Long id, AnswerRequestDto answerRequestDto) {
        // Check if answer exists
        Answer existingAnswer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));

        // Validate if the question exists if it's being updated
        if (answerRequestDto.getQuestionId() != null) {
            Question question = questionRepository.findById(answerRequestDto.getQuestionId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Question not found with id: " + answerRequestDto.getQuestionId()));
            existingAnswer.setQuestion(question);
        }

        existingAnswer.setAnswer(answerRequestDto.getAnswer());
        validateAnswer(existingAnswer);
        Answer updatedAnswer = answerRepository.save(existingAnswer);
        return answerMapper.toResponseDto(updatedAnswer);
    }

    @Override
    public void delete(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));

        if (!answer.getAnswerValidations().isEmpty()) {
            throw new IllegalArgumentException("Answer is used in questions");
        }

        answerRepository.deleteById(id);
    }

    @Override
    public AnswerResponseDto findById(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));
        return answerMapper.toResponseDto(answer);
    }

    private void validateAnswer(Answer answer) {
        if (answer.getAnswer() == null || answer.getAnswer().trim().isEmpty()) {
            throw new IllegalArgumentException("Answer content cannot be empty");
        }
        


        if (answer.getQuestion() == null) {
            throw new IllegalArgumentException("Answer must be associated with a question");
        }
    }
}

package ahmed.foudi.Youquiz.service.implementation;

import ahmed.foudi.Youquiz.dto.answer.AnswerRequestDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.AnswerMapper;
import ahmed.foudi.Youquiz.entities.Answer;
import ahmed.foudi.Youquiz.entities.AnswerQuestion;
import ahmed.foudi.Youquiz.entities.Question;
import ahmed.foudi.Youquiz.entities.embedded.AnswerQuestionKey;
import ahmed.foudi.Youquiz.repository.AnswerQuestionRepository;
import ahmed.foudi.Youquiz.repository.AnswerRepository;
import ahmed.foudi.Youquiz.repository.QuestionRepository;
import ahmed.foudi.Youquiz.service.interfaces.AnswerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerQuestionRepository answerQuestionRepository;
    private final AnswerMapper answerMapper;

    @Override
    @Transactional
    public AnswerResponseDto create(AnswerRequestDto answerRequestDto) {

        Question question = questionRepository.findById(answerRequestDto.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Question not found with id: " + answerRequestDto.getQuestionId()));

        Answer answer = new Answer();
        answer.setAnswer(answerRequestDto.getAnswer());
        validateAnswer(answer);
        Answer savedAnswer = answerRepository.save(answer);

        // Create and save answer-question relationship
        AnswerQuestion answerQuestion = new AnswerQuestion();
        AnswerQuestionKey key = new AnswerQuestionKey();
        key.setQuestionId(question.getId());
        key.setAnswerId(savedAnswer.getId());

        answerQuestion.setId(key);
        answerQuestion.setQuestion(question);
        answerQuestion.setAnswer(savedAnswer);
        answerQuestion.setPoint(answerRequestDto.getPoints());

        answerQuestionRepository.save(answerQuestion);

        return answerMapper.toResponseDto(savedAnswer);
    }

    @Override
    public AnswerResponseDto findById(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));
        return answerMapper.toResponseDto(answer);
    }

    @Override
    @Transactional
    public AnswerResponseDto update(Long id, AnswerRequestDto answerRequestDto) {
        Answer existingAnswer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));

        existingAnswer.setAnswer(answerRequestDto.getAnswer());
        validateAnswer(existingAnswer);

        // Update answer-question relationship if needed
        if (!existingAnswer.getAnswerQuestions().isEmpty()) {
            AnswerQuestion answerQuestion = existingAnswer.getAnswerQuestions().get(0);
            answerQuestion.setPoint(answerRequestDto.getPoints());
            answerQuestionRepository.save(answerQuestion);
        }

        Answer updatedAnswer = answerRepository.save(existingAnswer);
        return answerMapper.toResponseDto(updatedAnswer);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));

        // Check if answer has validations
        if (!answer.getAnswerValidations().isEmpty()) {
            throw new IllegalStateException("Cannot delete answer as it has associated validations");
        }

        answerQuestionRepository.deleteAll(answer.getAnswerQuestions());

        answerRepository.delete(answer);
    }

    private void validateAnswer(Answer answer) {
        if (answer.getAnswer() == null || answer.getAnswer().trim().isEmpty()) {
            throw new IllegalArgumentException("Answer content cannot be empty");
        }

        if (answer.getAnswer().length() > 1000) {
            throw new IllegalArgumentException("Answer content cannot exceed 1000 characters");
        }
    }


} 
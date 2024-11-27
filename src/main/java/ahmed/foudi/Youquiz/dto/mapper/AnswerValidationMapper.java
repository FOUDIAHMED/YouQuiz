package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.answervalidation.AnswerValidationEmbeddedDto;
import ahmed.foudi.Youquiz.dto.answervalidation.AnswerValidationRequestDto;
import ahmed.foudi.Youquiz.dto.answervalidation.AnswerValidationResponseDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizRequestDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizResponseDto;
import ahmed.foudi.Youquiz.entities.AnswerValidation;
import ahmed.foudi.Youquiz.entities.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerValidationMapper extends GenericMapper<AnswerValidation, AnswerValidationRequestDto, AnswerValidationResponseDto, AnswerValidationEmbeddedDto> {
    @Override
    AnswerValidation toEntity(AnswerValidationRequestDto answerRequestDto);
    @Override
    AnswerValidationResponseDto toResponseDto(AnswerValidation entity);
    @Override
    AnswerValidationEmbeddedDto toEmbeddedDto(AnswerValidation entity);
}

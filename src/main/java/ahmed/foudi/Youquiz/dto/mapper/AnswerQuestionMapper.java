package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.answerquestion.AnswerQuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.answerquestion.AnswerQuestionRequestDto;
import ahmed.foudi.Youquiz.dto.answerquestion.AnswerQuestionResponseDto;
import ahmed.foudi.Youquiz.entities.AnswerQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerQuestionMapper extends GenericMapper<AnswerQuestion, AnswerQuestionRequestDto, AnswerQuestionResponseDto, AnswerQuestionEmbeddedDto> {
    @Override
    AnswerQuestion toEntity(AnswerQuestionRequestDto answerRequestDto);
    @Override
    AnswerQuestionResponseDto toResponseDto(AnswerQuestion entity);
    @Override
    AnswerQuestionEmbeddedDto toEmbeddedDto(AnswerQuestion entity);
}

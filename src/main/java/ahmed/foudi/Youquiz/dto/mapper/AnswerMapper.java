package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.answer.AnswerEmbeddedDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerRequestDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerResponseDto;
import ahmed.foudi.Youquiz.entities.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends GenericMapper<Answer, AnswerRequestDto, AnswerResponseDto, AnswerEmbeddedDto> {
    @Override
    Answer toEntity(AnswerRequestDto answerRequestDto);
    @Override
    AnswerResponseDto toResponseDto(Answer entity);
    @Override
    AnswerEmbeddedDto toEmbeddedDto(Answer entity);
}

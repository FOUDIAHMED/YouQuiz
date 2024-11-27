package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.quiz.QuizEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizRequestDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizResponseDto;
import ahmed.foudi.Youquiz.entities.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper extends GenericMapper<Quiz, QuizRequestDto, QuizResponseDto, QuizEmbeddedDto> {
    @Override
    Quiz toEntity(QuizRequestDto answerRequestDto);
    @Override
    QuizResponseDto toResponseDto(Quiz entity);
    @Override
    QuizEmbeddedDto toEmbeddedDto(Quiz entity);
}

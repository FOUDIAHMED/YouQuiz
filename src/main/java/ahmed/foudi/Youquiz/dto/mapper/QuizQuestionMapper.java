package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionRequestDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;
import ahmed.foudi.Youquiz.entities.QuizQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizQuestionMapper extends GenericMapper<QuizQuestion, QuizQuestionRequestDto, QuizQuestionResponseDto, QuizQuestionEmbeddedDto> {
    @Override
    QuizQuestion toEntity(QuizQuestionRequestDto answerRequestDto);
    @Override
    QuizQuestionResponseDto toResponseDto(QuizQuestion entity);
    @Override
    QuizQuestionEmbeddedDto toEmbeddedDto(QuizQuestion entity);
}

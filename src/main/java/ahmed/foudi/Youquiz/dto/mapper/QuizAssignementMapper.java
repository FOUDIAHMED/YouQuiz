package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentRequestDto;
import ahmed.foudi.Youquiz.dto.quizassignment.QuizAssignmentResponseDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;
import ahmed.foudi.Youquiz.entities.QuizAssignement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizAssignementMapper extends GenericMapper<QuizAssignement, QuizAssignmentRequestDto, QuizAssignmentResponseDto, QuizQuestionEmbeddedDto> {
    @Override
    QuizAssignement toEntity(QuizAssignmentRequestDto answerRequestDto);
    @Override
    QuizAssignmentResponseDto toResponseDto(QuizAssignement entity);
    @Override
    QuizQuestionEmbeddedDto toEmbeddedDto(QuizAssignement entity);
}

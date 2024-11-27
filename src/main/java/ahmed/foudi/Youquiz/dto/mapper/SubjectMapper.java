package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.question.QuestionRequestDto;
import ahmed.foudi.Youquiz.dto.question.QuestionResponseDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectEmbeddedDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectRequestDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectResponseDto;
import ahmed.foudi.Youquiz.entities.Question;
import ahmed.foudi.Youquiz.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericMapper<Subject, SubjectRequestDto, SubjectResponseDto, SubjectEmbeddedDto> {
    @Override
    Subject toEntity(SubjectRequestDto requestDto);

    @Override
    @Mapping(source = "subject", target = "subject")
    SubjectResponseDto toResponseDto(Subject entity);

    @Override
    SubjectEmbeddedDto toEmbeddedDto(Subject entity);
}

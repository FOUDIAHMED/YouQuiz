package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.question.QuestionRequestDto;
import ahmed.foudi.Youquiz.dto.question.QuestionResponseDto;
import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SubjectMapper.class})
public interface QuestionMapper extends GenericMapper<Question, QuestionRequestDto, QuestionResponseDto, QuestionEmbeddedDto> {
    
    @Override

    Question toEntity(QuestionRequestDto requestDto);

    @Override
    @Mapping(source = "subject", target = "subject")
    QuestionResponseDto toResponseDto(Question entity);

    @Override
    QuestionEmbeddedDto toEmbeddedDto(Question entity);
} 
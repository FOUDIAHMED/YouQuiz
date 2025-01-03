package ahmed.foudi.Youquiz.dto.mapper;


import ahmed.foudi.Youquiz.dto.subject.SubjectEmbeddedDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectRequestDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectResponseDto;
import ahmed.foudi.Youquiz.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericMapper<Subject, SubjectRequestDto, SubjectResponseDto, SubjectEmbeddedDto> {
    @Override
    Subject toEntity(SubjectRequestDto requestDto);

    @Override
    SubjectResponseDto toResponseDto(Subject entity);

    @Override
    SubjectEmbeddedDto toEmbeddedDto(Subject entity);
}

package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.formateur.FormateurEmbeddedDto;
import ahmed.foudi.Youquiz.dto.formateur.FormateurRequestDto;
import ahmed.foudi.Youquiz.dto.formateur.FormateurResponseDto;
import ahmed.foudi.Youquiz.entities.Formateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormateurMapper extends GenericMapper<Formateur, FormateurRequestDto, FormateurResponseDto, FormateurEmbeddedDto> {
    @Override
    Formateur toEntity(FormateurRequestDto answerRequestDto);
    @Override
    FormateurResponseDto toResponseDto(Formateur entity);
    @Override
    FormateurEmbeddedDto toEmbeddedDto(Formateur entity);
}

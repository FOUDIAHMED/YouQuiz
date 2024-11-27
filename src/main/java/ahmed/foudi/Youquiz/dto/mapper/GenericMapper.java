package ahmed.foudi.Youquiz.dto.mapper;

import org.springframework.data.domain.Page;

import java.util.List;

public interface GenericMapper<E, RQ, RS, EM> {
    E toEntity(RQ requestDto);
    RS toResponseDto(E entity);
    EM toEmbeddedDto(E entity);
    List<RS> toResponseDtoList(List<E> entities);
    List<EM> toEmbeddedDtoList(List<E> entities);
    default Page<RS> toResponseDtoPage(Page<E> entities) {
        return entities.map(this::toResponseDto);
    }
} 
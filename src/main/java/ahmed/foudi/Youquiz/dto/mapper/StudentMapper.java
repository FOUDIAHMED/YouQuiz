package ahmed.foudi.Youquiz.dto.mapper;

import ahmed.foudi.Youquiz.dto.student.StudentEmbeddedDto;
import ahmed.foudi.Youquiz.dto.student.StudentRequestDto;
import ahmed.foudi.Youquiz.dto.student.StudentResponseDto;
import ahmed.foudi.Youquiz.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends GenericMapper<Student, StudentRequestDto, StudentResponseDto, StudentEmbeddedDto> {
    @Override
    Student toEntity(StudentRequestDto answerRequestDto);
    @Override
    StudentResponseDto toResponseDto(Student entity);
    @Override
    StudentEmbeddedDto toEmbeddedDto(Student entity);

}

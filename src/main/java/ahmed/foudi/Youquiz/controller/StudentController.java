package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.service.interfaces.StudentService;
import ahmed.foudi.Youquiz.dto.student.StudentRequestDto;
import ahmed.foudi.Youquiz.dto.student.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService formateurService;

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentRequestDto studentRequestDto) {
        return new ResponseEntity<>(formateurService.create(studentRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.ok(formateurService.update(id, studentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formateurService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(formateurService.findById(id));
    }
}

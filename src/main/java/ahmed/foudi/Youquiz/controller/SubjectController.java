package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.dto.subject.SubjectRequestDto;
import ahmed.foudi.Youquiz.dto.subject.SubjectResponseDto;
import ahmed.foudi.Youquiz.service.interfaces.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectResponseDto> create(@RequestBody SubjectRequestDto subjectRequestDto) {
        return new ResponseEntity<>(subjectService.create(subjectRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponseDto> update(@PathVariable Long id, @RequestBody SubjectRequestDto subjectRequestDto) {
        return ResponseEntity.ok(subjectService.update(id, subjectRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subjectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.findById(id));
    }
} 
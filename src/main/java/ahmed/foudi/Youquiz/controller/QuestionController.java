package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.dto.question.QuestionRequestDto;
import ahmed.foudi.Youquiz.dto.question.QuestionResponseDto;
import ahmed.foudi.Youquiz.service.interfaces.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponseDto> create(@RequestBody QuestionRequestDto questionRequestDto) {
        return new ResponseEntity<>(questionService.create(questionRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponseDto> update(@PathVariable Long id, @RequestBody QuestionRequestDto questionRequestDto) {
        return ResponseEntity.ok(questionService.update(id, questionRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.findById(id));
    }
} 
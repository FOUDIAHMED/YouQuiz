package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.dto.answer.AnswerRequestDto;
import ahmed.foudi.Youquiz.dto.answer.AnswerResponseDto;
import ahmed.foudi.Youquiz.service.interfaces.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerResponseDto> createAnswer(@Valid @RequestBody AnswerRequestDto answerRequestDto) {
        return new ResponseEntity<>(answerService.create(answerRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponseDto> getAnswer(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponseDto> updateAnswer(
            @PathVariable Long id,
            @Valid @RequestBody AnswerRequestDto answerRequestDto) {
        return ResponseEntity.ok(answerService.update(id, answerRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

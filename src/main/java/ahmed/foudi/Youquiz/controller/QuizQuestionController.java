package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionRequestDto;
import ahmed.foudi.Youquiz.dto.quizquestion.QuizQuestionResponseDto;
import ahmed.foudi.Youquiz.service.interfaces.QuizQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quiz-questions")
@RequiredArgsConstructor
public class QuizQuestionController {

    private final QuizQuestionService quizQuestionService;

    @PostMapping
    public ResponseEntity<QuizQuestionResponseDto> create(@RequestBody QuizQuestionRequestDto quizQuestionRequestDto) {
        return new ResponseEntity<>(quizQuestionService.create(quizQuestionRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{quizId}/{questionId}")
    public ResponseEntity<QuizQuestionResponseDto> update(
            @PathVariable Long quizId,
            @PathVariable Long questionId,
            @RequestBody QuizQuestionRequestDto quizQuestionRequestDto) {
        return ResponseEntity.ok(quizQuestionService.update(quizId, questionId, quizQuestionRequestDto));
    }

    @DeleteMapping("/{quizId}/{questionId}")
    public ResponseEntity<Void> delete(@PathVariable Long quizId, @PathVariable Long questionId) {
        quizQuestionService.delete(quizId, questionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{quizId}/{questionId}")
    public ResponseEntity<QuizQuestionResponseDto> findById(@PathVariable Long quizId, @PathVariable Long questionId) {
        return ResponseEntity.ok(quizQuestionService.findById(quizId, questionId));
    }
} 
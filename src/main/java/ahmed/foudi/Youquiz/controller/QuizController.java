package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.dto.question.QuestionEmbeddedDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizRequestDto;
import ahmed.foudi.Youquiz.dto.quiz.QuizResponseDto;
import ahmed.foudi.Youquiz.service.interfaces.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizResponseDto> create(@RequestBody QuizRequestDto quizRequestDto) {
        return new ResponseEntity<>(quizService.create(quizRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizResponseDto> update(@PathVariable Long id, @RequestBody QuizRequestDto quizRequestDto) {
        return ResponseEntity.ok(quizService.update(id, quizRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        quizService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.findById(id));
    }

    @GetMapping("/{id}/questions")
    public ResponseEntity<List<QuestionEmbeddedDto>> findAllQuestions(@PathVariable("id") Long quizId) {
        return ResponseEntity.ok(quizService.findAllQuestionsByQuizId(quizId));
    }
} 
package ahmed.foudi.Youquiz.controller;

import ahmed.foudi.Youquiz.service.interfaces.FormateurService;
import ahmed.foudi.Youquiz.dto.formateur.FormateurRequestDto;
import ahmed.foudi.Youquiz.dto.formateur.FormateurResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/formateurs")
@RequiredArgsConstructor
public class FormateurController {

    private final FormateurService formateurService;

    @PostMapping
    public ResponseEntity<FormateurResponseDto> create(@RequestBody FormateurRequestDto formateurRequestDto) {
        return new ResponseEntity<>(formateurService.create(formateurRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormateurResponseDto> update(@PathVariable Long id, @RequestBody FormateurRequestDto formateurRequestDto) {
        return ResponseEntity.ok(formateurService.update(id, formateurRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formateurService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormateurResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(formateurService.findById(id));
    }
}

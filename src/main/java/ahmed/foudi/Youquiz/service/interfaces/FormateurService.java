package ahmed.foudi.Youquiz.service.interfaces;

import ahmed.foudi.Youquiz.dto.formateur.FormateurRequestDto;
import ahmed.foudi.Youquiz.dto.formateur.FormateurResponseDto;

public interface FormateurService {
    FormateurResponseDto create(FormateurRequestDto formateurRequestDto);
    FormateurResponseDto update(Long id, FormateurRequestDto formateurRequestDto);
    void delete(Long id);
    FormateurResponseDto findById(Long id);
} 
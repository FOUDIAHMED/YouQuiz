package ahmed.foudi.Youquiz.service.implementations;

import ahmed.foudi.Youquiz.repository.FormateurRepository;
import ahmed.foudi.Youquiz.service.interfaces.FormateurService;
import ahmed.foudi.Youquiz.dto.formateur.FormateurRequestDto;
import ahmed.foudi.Youquiz.dto.formateur.FormateurResponseDto;
import ahmed.foudi.Youquiz.dto.mapper.FormateurMapper;
import ahmed.foudi.Youquiz.entities.Formateur;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormateurServiceImpl implements FormateurService {
    private final FormateurRepository formateurRepository;
    private final FormateurMapper formateurMapper;

    @Override
    public FormateurResponseDto create(FormateurRequestDto formateurRequestDto) {
        Formateur formateur = formateurMapper.toEntity(formateurRequestDto);
        Formateur savedFormateur = formateurRepository.save(formateur);
        return formateurMapper.toResponseDto(savedFormateur);
    }

    @Override
    public FormateurResponseDto update(Long id, FormateurRequestDto formateurRequestDto) {
        Formateur existingFormateur = formateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));

        existingFormateur.setNom(formateurRequestDto.getNom());
        existingFormateur.setPrenom(formateurRequestDto.getPrenom());
        existingFormateur.setAdresse(formateurRequestDto.getAdresse());
        existingFormateur.setDateNaissance(formateurRequestDto.getDateNaissance());
        existingFormateur.setSpecialite(formateurRequestDto.getSpecialite());

        Formateur updatedFormateur = formateurRepository.save(existingFormateur);
        return formateurMapper.toResponseDto(updatedFormateur);
    }

    @Override
    public void delete(Long id) {
        if (!formateurRepository.existsById(id)) {
            throw new EntityNotFoundException("Formateur not found");
        }
        formateurRepository.deleteById(id);
    }

    @Override
    public FormateurResponseDto findById(Long id) {
        Formateur formateur = formateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));
        return formateurMapper.toResponseDto(formateur);
    }
}

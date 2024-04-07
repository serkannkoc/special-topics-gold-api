package org.st_gold.special_topics_gold.service;

import org.springframework.stereotype.Service;
import org.st_gold.special_topics_gold.model.Emtia;
import org.st_gold.special_topics_gold.repository.EmtiaRepository;

@Service
public class EmtiaService {
    private final EmtiaRepository emtiaRepository;
    public EmtiaService(EmtiaRepository emtiaRepository) {
        this.emtiaRepository = emtiaRepository;
    }

    public Emtia createEmtia(Emtia emtia) {
        return emtiaRepository.save(emtia);
    }
}

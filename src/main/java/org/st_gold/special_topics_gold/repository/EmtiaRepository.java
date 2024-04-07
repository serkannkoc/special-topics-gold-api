package org.st_gold.special_topics_gold.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.st_gold.special_topics_gold.model.Emtia;

@Repository
public interface EmtiaRepository  extends JpaRepository<Emtia, Long> {
}

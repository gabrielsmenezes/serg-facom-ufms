package com.example.sergfacomufms.repository;

import com.example.sergfacomufms.domain.researchline.ResearchLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchLineRepository extends JpaRepository<ResearchLine, Long> {
}

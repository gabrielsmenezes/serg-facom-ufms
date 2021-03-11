package com.example.sergfacomufms.repository;

import com.example.sergfacomufms.domain.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {}

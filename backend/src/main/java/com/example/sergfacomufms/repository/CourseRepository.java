package com.example.sergfacomufms.repository;

import com.example.sergfacomufms.domain.professor.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

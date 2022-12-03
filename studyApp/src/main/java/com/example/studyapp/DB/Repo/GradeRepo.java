package com.example.studyapp.DB.Repo;


import com.example.studyapp.DB.Domain.GradeUntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GradeRepo extends CrudRepository<GradeUntity, Integer> {
    List<GradeUntity> findBySubject(String Subject);
}

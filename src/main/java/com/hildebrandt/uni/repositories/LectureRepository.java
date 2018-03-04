package com.hildebrandt.uni.repositories;

import com.hildebrandt.uni.domain.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRepository extends CrudRepository<Lecture, Long> {
}

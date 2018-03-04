package com.hildebrandt.uni.repositories;

import com.hildebrandt.uni.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
}

package com.example.springboot_ex305;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<Student, Long>{
}

package com.grupo5.homework_java_ironlibrary.repositories;

import com.grupo5.homework_java_ironlibrary.models.Issue;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Integer> {
}

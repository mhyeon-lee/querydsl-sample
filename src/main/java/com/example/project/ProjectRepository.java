package com.example.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
// Spring-Data-Jpa 확장 Repository 지원
// http://docs.spring.io/spring-data/jpa/docs/1.10.1.RELEASE/reference/html/#repositories.custom-implementations
public interface ProjectRepository extends ProjectRepositoryCustom,
		JpaRepository<Project, Long>, QueryDslPredicateExecutor<Project> {
}

package com.example.post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
public interface PostRepository extends PostRepositoryCustom, JpaRepository<Post, Long> {
}

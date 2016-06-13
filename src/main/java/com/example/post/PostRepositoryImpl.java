package com.example.post;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
public class PostRepositoryImpl extends QueryDslRepositorySupport {

	public PostRepositoryImpl() {
		super(Post.class);
	}

	public List<Post> findPostsByProjectId(Long projectId) {
		QPost qPost = QPost.post;

		return from(qPost)
				.leftJoin(qPost.comments).fetch()
				.where(qPost.project.id.eq(projectId))
				.distinct()
				.list(qPost);
	}
}

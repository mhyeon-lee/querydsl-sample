package com.example.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.example.post.Post;
import com.example.post.QPost;
import com.mysema.query.Tuple;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
public class ProjectRepositoryImpl extends QueryDslRepositorySupport {

	public ProjectRepositoryImpl() {
		super(Project.class);
	}

	public ProjectWithBlocks findProjectWithBlocks(Long projectId) {
		QProject qProject = QProject.project;
		QPost qPost = QPost.post;

		List<Tuple> results =
				from(qProject, qPost)
						.where(qProject.eq(qPost.project)
								.and(qProject.id.eq(projectId)))
						.list(qProject, qPost);

		Project project = results.get(0).get(qProject);
		List<Post> posts = new ArrayList<>();
		for (Tuple tuple : results) {
			Post post = tuple.get(qPost);
			posts.add(post);
		}

		return new ProjectWithBlocks(project, posts);
	}
}

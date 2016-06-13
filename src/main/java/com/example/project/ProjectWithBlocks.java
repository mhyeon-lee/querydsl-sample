package com.example.project;

import java.util.List;

import com.example.post.Post;

import lombok.Getter;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
@Getter
public class ProjectWithBlocks {
	private Project project;
	private List<Post> posts;

	public ProjectWithBlocks(Project project, List<Post> posts) {
		this.project = project;
		this.posts = posts;
	}
}

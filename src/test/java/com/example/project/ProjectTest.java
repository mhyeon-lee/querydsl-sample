package com.example.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.QuerydslSampleApplication;
import com.example.post.Post;
import com.example.post.PostRepository;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QuerydslSampleApplication.class)
@WebAppConfiguration
@Transactional
public class ProjectTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ProjectRepository projectRepository;

	private Project project;
	private List<Post> postList = new ArrayList<>();

	@Before
	public void setUp() {
		project = new Project("project-name", "test-project");
		projectRepository.save(project);
		em.flush();
		em.clear();

		Post post1 = new Post("post-1", "post-1 body", project);
		post1.addComment("post-1 comment 1");
		post1.addComment("post-2 comment 2");
		postList.add(post1);
		Post post2 = new Post("post-1", "post-1 body", project);
		post2.addComment("post-2 comment 1");
		postList.add(post2);
		Post post3 = new Post("post-1", "post-1 body", project);
		postList.add(post3);
		Post post4 = new Post("post-1", "post-1 body", project);
		post4.addComment("post-4 comment 4");
		postList.add(post4);
		postRepository.save(postList);
		em.flush();
		em.clear();
		System.out.println("======= set up finished =====");
	}

	@Test
	public void findPostsByProjectId() {
		// Given
		// When
		List<Post> posts = postRepository.findPostsByProjectId(project.getId());

		// Then
		Assert.assertEquals(posts.get(0).getProject(), project);
		Assert.assertTrue(postList.contains(posts.get(0)));
		Assert.assertTrue(postList.contains(posts.get(1)));
		Assert.assertTrue(postList.contains(posts.get(2)));
		Assert.assertTrue(postList.contains(posts.get(3)));
	}

	@Test
	public void findProjectWithPostTest() {
		// Given
		// When
		ProjectWithBlocks projectWithBlocks = projectRepository.findProjectWithBlocks(project.getId());

		// Then
		Assert.assertEquals(projectWithBlocks.getProject(), project);
		Assert.assertTrue(postList.contains(projectWithBlocks.getPosts().get(0)));
		Assert.assertTrue(postList.contains(projectWithBlocks.getPosts().get(1)));
		Assert.assertTrue(postList.contains(projectWithBlocks.getPosts().get(2)));
		Assert.assertTrue(postList.contains(projectWithBlocks.getPosts().get(3)));
	}
}

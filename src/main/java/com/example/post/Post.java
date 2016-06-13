package com.example.post;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.project.Project;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(of = "id")
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String body;

	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private List<Comment> comments = new ArrayList<>();

	public Post(String title, String body, Project project) {
		this.title = title;
		this.body = body;
		this.project = project;
	}

	public void addComment(String body) {
		comments.add(new Comment(body));
	}
}

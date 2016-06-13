package com.example.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	private String contents;

	public Comment(String contents) {
		this.contents = contents;
	}
}

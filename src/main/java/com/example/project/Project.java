package com.example.project;

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
public class Project {

	@Id
	@GeneratedValue
	private Long id;

	private String projectName;

	private String description;

	public Project(String projectName, String description) {
		this.projectName = projectName;
		this.description = description;
	}
}

package com.example.post;

import java.util.List;

/**
 * Created by mhyeon.lee on 2016. 6. 13..
 */
public interface PostRepositoryCustom {
	List<Post> findPostsByProjectId(Long projectId);
}

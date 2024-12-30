package io.github.roopan.rc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.roopan.rc.domain.model.Post;
import io.github.roopan.rc.infra.security.user.model.User;
import io.github.roopan.rc.subreddit.Subreddit;

import java.util.List;

/**
 * Repository class for <code>Post</code> domain object. 
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> 
{
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}

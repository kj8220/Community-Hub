package io.github.roopan.rc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.roopan.rc.domain.model.Comment;
import io.github.roopan.rc.domain.model.Post;
import io.github.roopan.rc.infra.security.user.model.User;

import java.util.List;

/**
 * Repository class for <code>Comment</code> domain object. 
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> 
{
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
package com.muates.ftteknolojicase.comment.repository;

import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByProductId(Long productId);

    List<CommentEntity> findAllByCommentDateBetween(Date startDate, Date endDate);

    List<CommentEntity> findAllByUserId(Long userId);
}

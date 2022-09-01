package com.muates.ftteknolojicase.comment.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.muates.ftteknolojicase.product.model.entity.ProductEntity;
import com.muates.ftteknolojicase.user.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

import static com.muates.ftteknolojicase.comment.model.entity.schema.CommentEntitySchema.*;

@Entity
@Table(name = TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = COMMENT)
    private String productComment;

    @Column(name = COMMENT_DATE)
    private Date commentDate;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JsonBackReference
    private ProductEntity product;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private UserEntity user;

}

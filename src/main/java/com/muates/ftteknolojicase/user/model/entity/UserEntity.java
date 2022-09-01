package com.muates.ftteknolojicase.user.model.entity;

import com.muates.ftteknolojicase.comment.model.entity.CommentEntity;
import com.muates.ftteknolojicase.user.model.entity.schema.UserEntitySchema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = UserEntitySchema.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = UserEntitySchema.FIRST_NAME)
    private String firstName;

    @Column(name = UserEntitySchema.LAST_NAME)
    private String lastName;

    @Column(name = UserEntitySchema.MAIL)
    private String mail;

    @Column(name = UserEntitySchema.PHONE)
    private String phone;

    @OneToOne
    private CommentEntity comment;

}


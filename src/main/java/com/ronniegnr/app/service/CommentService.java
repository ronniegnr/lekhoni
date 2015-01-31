package com.ronniegnr.app.service;

import com.ronniegnr.app.entity.Comment;
import com.ronniegnr.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment getComment(int id) {
        return commentRepository.findOne(id);
    }

    public Comment save(Comment comment) {
        comment.setUpdated(new Timestamp(new Date().getTime()));
        return commentRepository.save(comment);
    }

}

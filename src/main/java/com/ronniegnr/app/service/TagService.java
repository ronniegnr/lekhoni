package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.entity.Tag;
import com.ronniegnr.app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag getTag(int id) {
        return tagRepository.findOne(id);
    }

    public Tag Save(Tag tag) {
        tag.setUpdated(new Timestamp(new Date().getTime()));
        return tagRepository.save(tag);
    }

}

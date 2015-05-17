package com.ronniegnr.app.service;

import com.ronniegnr.app.domain.entity.Tag;
import com.ronniegnr.app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag getTag(int id) {
        return tagRepository.findOne(id);
    }

    public List<Tag> getAllTag() {
        return (List<Tag>)tagRepository.findAll();
    }

    public Tag getTag(String value) {
        return tagRepository.findByValue(value);
    }

    public Tag save(Tag tag) {
        tag.setUpdated(new Timestamp(new Date().getTime()));
        return tagRepository.save(tag);
    }

    public void delete(int id) {
        tagRepository.delete(id);
    }

}

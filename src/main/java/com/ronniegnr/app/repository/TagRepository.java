package com.ronniegnr.app.repository;

import com.ronniegnr.app.domain.entity.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TagRepository extends PagingAndSortingRepository<Tag, Integer> {
    public Tag findByValue(String value);

    //@Query("select tag from Tag tag where count(tag.posts)>0 order by count(tag.posts) desc")
    //public List<Tag> findByPostCountGreaterThanOrderByPostCountDesc(int postCount);
    public List<Tag> findById(int postCount);
}

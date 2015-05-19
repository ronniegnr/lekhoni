package com.ronniegnr.app.repository;

import com.ronniegnr.app.domain.entity.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Tag, Integer> {

    public Tag findByValue(String value);

}

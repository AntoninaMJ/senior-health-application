package com.antonina.health.repository;

import com.antonina.health.domain.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends PagingAndSortingRepository<Result, Long> {

    Page<Result> findByUserId(Long userId, Pageable pageable);

    List<Result> findByUserIdOrderByDateTime(Long userId);
}

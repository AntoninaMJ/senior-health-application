package com.antonina.health.repository;

import com.antonina.health.domain.Result;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends PagingAndSortingRepository<Result, Long> {
}

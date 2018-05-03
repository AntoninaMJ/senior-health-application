package com.antonina.health.repository;

import com.antonina.health.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmailAndActiveTrue(String email);

    List<User> findByNotifyHourAndActiveTrue(int hour);
}
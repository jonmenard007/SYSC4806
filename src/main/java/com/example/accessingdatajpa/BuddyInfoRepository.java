package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepository extends JpaRepository<BuddyInfo, Integer> {

    List<BuddyInfo> findByLastName(@Param("lastName") String lastName);

    BuddyInfo findById(long id);
}

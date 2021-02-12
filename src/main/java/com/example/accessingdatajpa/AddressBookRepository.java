package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository

@RepositoryRestResource(collectionResourceRel = "addressBook", path = "addressBook")
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

    AddressBook findById(long id);

}

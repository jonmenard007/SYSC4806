package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories
public class AccessingDataJpaApplication  {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner makeAddressBook(AddressBookRepository addressBookRepository, BuddyInfoRepository c) {
        return (args) -> {
            addressBookRepository.save(new AddressBook());
        };
    }

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;



}


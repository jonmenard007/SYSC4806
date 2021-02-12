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
            AddressBook addressBook = new AddressBook();
            BuddyInfo buddy1 = new BuddyInfo("Luke", "SkyWalker", "999-999-9999" , "193246 Desert Drive, Tatooine");
            BuddyInfo buddy2 = new BuddyInfo("Padme", "Amidala", "999-999-9999" , "324234 Castle Court, Nabii");
            BuddyInfo buddy3 = new BuddyInfo("Han", "Solo", "999-999-9999" , "1 Millennium Falcon Park , Corellia");
            BuddyInfo buddy4 = new BuddyInfo("Darth", "Vader", "999-999-9999" , "2929 Death Star, Sapce");

            addressBook.addBuddyInfo(buddy1);
            addressBook.addBuddyInfo(buddy2);
            addressBook.addBuddyInfo(buddy3);
            addressBook.addBuddyInfo(buddy4);
            addressBookRepository.save(addressBook);
            System.out.println(addressBook.toString());
        };
    }

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;



}


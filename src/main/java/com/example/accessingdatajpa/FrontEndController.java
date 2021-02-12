package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.Optional;

@ComponentScan("com.example.accessingdatajpa")
@Configuration
@EntityScan("com.example.accessingdatajpa")
@Controller
public class FrontEndController {


    @Autowired(required = true)
    public AddressBookRepository addressBookRepository;


    @GetMapping("/")
    public String get(Model model) {
        ArrayList<AddressBook> addressBooks = (ArrayList<AddressBook>) addressBookRepository.findAll();
        AddressBook addressBook = addressBookRepository.findById(1);
        model.addAttribute("addressBooks", addressBooks);
        return "addressBooks";
    }

    @GetMapping("/test")
    public @ResponseBody
    String test(Model model) {
        return "Test Passed!";
    }

    @GetMapping("/displayAddressBook/{addressBookId}")
    public String getAddressBook(Model model,@PathVariable Long addressBookId) {

        Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
        AddressBook addressBook;
        if(!a.isPresent()){
            addressBook = new AddressBook();
        }else{
            addressBook = a.get();
        }
        model.addAttribute("addressBook", addressBook.getAddressBook());
        return "addressBook";
    }
}

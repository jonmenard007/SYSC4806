package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@ComponentScan("com.example.accessingdatajpa")

@EntityScan("com.example.accessingdatajpa")
@Controller
public class FrontEndController {


    @Autowired(required = true)
    public AddressBookRepository addressBookRepository;


    @GetMapping("/")
    public String get(Model model) {
        System.out.println("in /");
        ArrayList<AddressBook> addressBooks = (ArrayList<AddressBook>) addressBookRepository.findAll();
        System.out.println("in /1");
        AddressBook addressBook = addressBookRepository.findById(1);
        System.out.println("in /2");
        model.addAttribute("addressBooks", addressBooks);
        System.out.println("in /here");
        return "/addressBooks";
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
        return "/addressBook";
    }
}

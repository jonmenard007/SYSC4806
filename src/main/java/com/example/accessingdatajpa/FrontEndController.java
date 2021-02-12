package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Controller
public class FrontEndController {


    @Autowired(required = true)
    private AddressBookRepository addressBookRepository;

    @Autowired(required = true)
    private BuddyInfoRepository buddyInfoRepository;


    @GetMapping("/")
    public String createBuddyInfo(Model model) {
        ArrayList<AddressBook> addressBooks = (ArrayList<AddressBook>) addressBookRepository.findAll();
        AddressBook addressBook = addressBookRepository.findById(1);
        model.addAttribute("addressBooks", addressBooks);
        return "addressBooks";
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

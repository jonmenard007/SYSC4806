package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;
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
        model.addAttribute("addressBooks", addressBooks);
        return "/homePage";
    }

    @GetMapping("/test")
    public @ResponseBody
    String test(Model model) {
        return "Test Passed!";
    }


    @GetMapping("/homePage")
    public String home(Model model) {
        ArrayList<AddressBook> addressBooks = (ArrayList<AddressBook>) addressBookRepository.findAll();

        model.addAttribute("addressBooks", addressBooks);
        return "/homePage";
    }

    @ResponseBody
    @GetMapping("/newAddressBook")
    public String newA(@ModelAttribute AddressBook addressBook,Model model) {
        addressBookRepository.saveAndFlush(addressBook);
        ArrayList<AddressBook> addressBooks = (ArrayList<AddressBook>) addressBookRepository.findAll();
        model.addAttribute("addressBooks", addressBooks);

        return "<li><a name  = " + addressBook.getAddressbookId() + " href='getAdressBookInformation/" + addressBook.getAddressbookId() + "' class = 'displayAddressBookLink' >addressBook" + addressBook.getAddressbookId() + "</a></li>";
    }


    @PostMapping("/createNewAddressBook")
    public String newAddressBook(@ModelAttribute AddressBook addressBook,Model model) {
        addressBookRepository.saveAndFlush(addressBook);
        ArrayList<AddressBook> addressBooks = (ArrayList<AddressBook>) addressBookRepository.findAll();
        model.addAttribute("addressBooks", addressBooks);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/getAdressBookInformation/{addressBookId}")
    public String g(Model model,@PathVariable Long addressBookId) {
        Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
        AddressBook addressBook;
        if(!a.isPresent()){
            addressBook = new AddressBook();
        }else{
            addressBook = a.get();
        }
        List<BuddyInfo> contacts = addressBook.getAddressBook();
        String s = "";
        for(int i = 0; i < contacts.size(); i++){
           s += "<li >" + contacts.get(i).toString() + "</li> \n";
        }
        return s;
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
        model.addAttribute("addressBookId", addressBookId);
        return "addressBook";
    }

    @PostMapping("/addBuddyToAddressBook/{addressBookId}")
    public String addBuddyToAddressBook(@ModelAttribute BuddyInfo buddy, @PathVariable Long addressBookId) {
        System.out.println(buddy.toString());
        Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
        AddressBook addressBook;
        if(!a.isPresent()){
            addressBook = new AddressBook();
        }else{
            addressBook = a.get();
        }
        addressBook.addBuddyInfo(buddy);
        addressBookRepository.save(addressBook);
        return "redirect:/displayAddressBook/1";
    }

    @ResponseBody
    @PostMapping("/addNewBuddyToAddressBook/{addressBookId}")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, @PathVariable Long addressBookId) {

        Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
        AddressBook addressBook;
        if(!a.isPresent()){
            addressBook = new AddressBook();
        }else{
            addressBook = a.get();
        }
        addressBook.addBuddyInfo(buddy);
        addressBookRepository.save(addressBook);
        System.out.print("here");
        return "<li >" + buddy.toString() + "</li> \n";
    }











}

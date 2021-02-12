package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@RestController
public class AddressBookController {

    @Autowired(required = true)
    private AddressBookRepository addressBookRepository;

    @Autowired(required = true)
    private BuddyInfoRepository buddyInfoRepository;

    //AddressBook addressBook = new AddressBook();


        @PostMapping("addressBook/{addressBookId}/addBuddy")
    public AddressBook createBuddyInfo(@RequestBody Map<String, String> body,@PathVariable Long addressBookId) {
            Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
            AddressBook addressBook;
            if(!a.isPresent()){
                addressBook = new AddressBook();
            }else{
                addressBook = a.get();
            }
            BuddyInfo buddy = new BuddyInfo(body.get("firstName"), body.get("lastName"), body.get("phoneNumber"));


            BuddyInfo newBuddy = buddyInfoRepository.saveAndFlush(buddy);
            addressBook.addBuddyInfo(newBuddy);
            addressBookRepository.save(addressBook);
            return addressBook;
    }





//    @GetMapping("addressBook/{addressBookId}")
//    public AddressBook createBuddyInfo(Model model,@PathVariable Long addressBookId) {
//
//        Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
//        AddressBook addressBook;
//        if(!a.isPresent()){
//            addressBook = new AddressBook();
//        }else{
//            addressBook = a.get();
//        }
//        return addressBook;
//    }
//
//    @PostMapping("addressBook/new")
//    public AddressBook newAddressBook() {
//        AddressBook addressBook = new AddressBook();
//        addressBookRepository.save(addressBook);
//        return addressBook;
//    }




//    @DeleteMapping("addressBook/{addressBookId}/deleteBuddy")
//    public AddressBook deleteBuddyInfo(@RequestBody Map<String,String> body,@PathVariable Long addressBookId) {
//
//            Optional<AddressBook> a = addressBookRepository.findById(addressBookId);
//            AddressBook addressBook;
//            if (!a.isPresent()) {
//                addressBook = new AddressBook();
//            } else {
//                addressBook = a.get();
//            }
//            if (body.get("Id") == null) {
//                if (body.get("firstName") != null & body.get("lastName") != null) {
//                    String firstName = body.get("firstName");
//                    String lastName = body.get("lastName");
//                    addressBook.deleteContact(firstName, lastName);
//                }
//            } else {
//                int id = Integer.parseInt(body.get("Id"));
//                addressBook.deleteContact(id);
//            }
//            return addressBook;
//    }
}



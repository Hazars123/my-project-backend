package app.SpringBoot.controllers;

import app.SpringBoot.entities.ContactMessage;
import app.SpringBoot.entities.UserEntity;
import app.SpringBoot.services.ContactMessageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactMes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContactMessageController {
    @Autowired
    ContactMessageServiceInter contactMessageServiceInter;
    @PostMapping("/addCM")
    public ContactMessage addCM(@RequestBody ContactMessage CM ){
        return contactMessageServiceInter.addCM(CM);
    }




    @DeleteMapping("/deleteCM/{id}")
    public void deleteCM(@PathVariable Long id )
    {
        contactMessageServiceInter.deleteCM(id);
    }


    @PostMapping("/addCMs")
    public List<ContactMessage> CMs(@RequestBody List<ContactMessage> CMs)
    {
        return contactMessageServiceInter.addCMs(CMs);

    }

    //update
    @PutMapping("updateCM/{id}")
    public ContactMessage updateCM(@RequestBody ContactMessage CM,@PathVariable Long id )
    {
        return contactMessageServiceInter.updateCM(CM,id);

    }





    @GetMapping("/getAllCMs")
    public List<ContactMessage> getAllCMs()
    {
        return contactMessageServiceInter.getAllCMs();


    }


    @GetMapping("/getCMById/{id}")
    public ContactMessage getCMById(@PathVariable Long id)
    {
        return contactMessageServiceInter.getCMById(id);

    }


}

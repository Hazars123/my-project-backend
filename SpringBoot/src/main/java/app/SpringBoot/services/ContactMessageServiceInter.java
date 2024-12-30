package app.SpringBoot.services;

import app.SpringBoot.entities.ContactMessage;

import java.util.List;

public interface ContactMessageServiceInter {
    ContactMessage addCM(ContactMessage cm);

    void deleteCM(Long id);

    List<ContactMessage> addCMs(List<ContactMessage> cMs);

    ContactMessage updateCM(ContactMessage cm, Long id);

    List<ContactMessage> getAllCMs();

    ContactMessage getCMById(Long id);
}

package app.SpringBoot.services;
import app.SpringBoot.entities.ContactMessage;
import app.SpringBoot.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageServiceImpl implements ContactMessageServiceInter{
    @Autowired
    ContactMessageRepository contactMessageRepository;
    @Override
    public ContactMessage addCM(ContactMessage CM) {
        return contactMessageRepository.save(CM);
    }

    @Override
    public void deleteCM(Long id) {
        contactMessageRepository.deleteById(id);

    }

    @Override
    public List<ContactMessage> addCMs(List<ContactMessage> CMs) {
        return contactMessageRepository.saveAll(CMs);    }

    @Override
    public ContactMessage updateCM(ContactMessage contactMessage, Long id) {
        ContactMessage CM= contactMessageRepository.findById(id).get();

        contactMessage.setName(CM.getName() );
        contactMessage.setEmail(CM.getEmail() );
        contactMessage.setMessage(CM.getMessage());
        return contactMessageRepository.save(CM);
    }

    @Override
    public List<ContactMessage> getAllCMs() {
        return contactMessageRepository.findAll();    }

    @Override
    public ContactMessage getCMById(Long id) {
        return contactMessageRepository.findById(id).get();    }


}

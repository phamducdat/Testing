package com.datpham.miniblog.service;


import com.datpham.miniblog.entity.ContactEntity;
import com.datpham.miniblog.mapper.ContactMapper;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.Contact;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ContactService {

    private final ContactMapper mapper;
    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactMapper mapper, ContactRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public Contact createContact(ContactRequest request) {
        ContactEntity entity = repository.save(mapper.mapContactEntityFromContactRequest(request));
        return mapper.mapContactFromContactEntity(entity);
    }

    public ContactList getAllContact() {
        List<ContactEntity> contactEntityList = repository.findAll();
        return mapper.mapContactListFromContactEntities(contactEntityList);
    }

    public Contact getContactById(String contactId){
        ContactEntity entity = repository.getById(contactId);
        return mapper.mapContactFromContactEntity(entity);
    }

    public ContactList getContactListByAuthorId(String authorId) {
        List<ContactEntity> contactEntityList = repository.findAll();
        ContactList contactList = new ContactList();

        contactEntityList.forEach(contactEntity -> {
            if (Objects.equals(contactEntity.getAuthorId().getAuthorId(), authorId)) {
                contactList.add(mapper.mapContactFromContactEntity(contactEntity));
            }
        });
        return contactList;
    }
}

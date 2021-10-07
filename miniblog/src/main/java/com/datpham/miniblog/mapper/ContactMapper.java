package com.datpham.miniblog.mapper;


import com.datpham.miniblog.entity.ContactEntity;
import com.datpham.miniblog.repository.ContactRepository;
import io.tej.SwaggerCodgen.model.Contact;
import io.tej.SwaggerCodgen.model.ContactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Service
public class ContactMapper {

    private final ContactRepository repository;


    @Autowired
    public ContactMapper(ContactRepository repository) {
        this.repository = repository;
    }


    public Contact mapContactFromContactEntity(ContactEntity from) {
        Contact contact = new Contact();
        contact.setContactId(from.getContactId());
        contact.setContactName(from.getContactName());
        contact.setContactMessage(from.getContactMessage());
        contact.setContactEmailTo(from.getContactEmailTo());
        contact.setContactEmailFrom(from.getContactEmailFrom());
        contact.setAuthorId(from.getAuthorId().getAuthorId());

        return  contact;
    }

    public ContactEntity mapContactEntityFromContact(Contact from)  {
        ContactEntity entity = new ContactEntity();
        entity.setContactId(UUID.randomUUID().toString());
        entity.setContactEmailFrom(from.getContactEmailFrom());
        entity.setContactMessage(from.getContactMessage());
        entity.setContactName(from.getContactName());
        entity.setContactEmailTo(from.getContactEmailTo());

        return entity;
    }

    public ContactList mapContactListFromContactEntities(List<ContactEntity> from) {
        ContactList contactList = new ContactList();

        from.forEach(contactEntity -> {
            contactList.add(mapContactFromContactEntity(contactEntity));
        });

        return contactList;
    }


}

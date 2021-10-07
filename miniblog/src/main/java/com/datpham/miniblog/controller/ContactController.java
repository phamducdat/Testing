package com.datpham.miniblog.controller;

import io.tej.SwaggerCodgen.api.ContactsApi;
import io.tej.SwaggerCodgen.model.ContactList;
import io.tej.SwaggerCodgen.model.ContactRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContactController implements ContactsApi {
//

    @Override
    public ResponseEntity<Void> createContact(ContactRequest contactRequest) {
        return null;
    }

    @Override
    public ResponseEntity<ContactList> getAllContact() {
        return null;
    }
}

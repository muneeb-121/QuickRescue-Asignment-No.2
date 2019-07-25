package com.qr.services;

import javax.ejb.Remote;

import com.qr.model.DO.Contact;

@Remote
public interface ContactServiceRemote {
	Contact createContact(Contact contact);

	Contact updateContactById(Contact contact, Integer id);

	Contact deleteContactById(Integer contactId);
}

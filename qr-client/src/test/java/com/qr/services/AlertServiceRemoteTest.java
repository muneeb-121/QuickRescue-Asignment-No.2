package com.qr.services;

import com.qr.manager.ServiceManager;
import com.qr.model.DO.Account;
import com.qr.model.DO.Contact;
import com.qr.model.DO.Profile;

import junit.framework.TestCase;

public class AlertServiceRemoteTest extends TestCase {
	
	private AlertServiceRemote alertService = (AlertServiceRemote) ServiceManager.getService(AlertServiceRemote.class);

	public final void testGenerateAlert() {
		
		Account account = new Account();
		account.setName("Jhon Doe");
		account.setEmailDomain("example.com");
		account.setTimeZoneCity("ISB");
		
		account = createAccountUtil(account);

		
		Profile profile = new Profile();
		profile.setAccount(account);
		profile.setName("profile1");
		profile.setCity("ISB");
		profile.setCountry("Pakistan");
		
		Profile profile2 = new Profile();
		profile2.setAccount(account);
		profile2.setName("profile2");
		profile2.setCity("NYK");
		profile2.setCountry("USA");
		
		createProfileUtil(profile);
		createProfileUtil(profile2);

		Contact contact = new Contact();
		contact.setAccount(account);
		contact.setFirstName("Jhon");
		contact.setLastName("Doe");
		contact.setEmail("email@example.com");
		contact.setGender(Contact.GENDER_MALE);
		contact.setPhoneNumber("+923367215150");
		contact.setStatus(Contact.STATUS_ACTIVE);
		contact.setStreetAddress("St#2 Hno.33");
		contact.setCity("ISB");
		contact.setState("Punjab");
		contact.setCountry("Pakistan");
		createContactUtil(contact);
		
		assertTrue(alertService.generateAlert(contact));
		
		deleteUtil(account);
		
	}
	private Account createAccountUtil(Account account) {
		AccountServiceRemote accountService = (AccountServiceRemote) ServiceManager.getService(AccountServiceRemote.class);
		return accountService.createAccount(account);
		
	}
	private Contact createContactUtil(Contact contact) {
		ContactServiceRemote contactService = (ContactServiceRemote) ServiceManager.getService(ContactServiceRemote.class);
		return contactService.createContact(contact);
		
	}
	private Profile createProfileUtil(Profile profile) {
		ProfileServiceRemote profileService = (ProfileServiceRemote) ServiceManager.getService(ProfileServiceRemote.class);
		return profileService.createProfile(profile);
		
	}
	private void deleteUtil(Account account) {
		AccountServiceRemote accountService = (AccountServiceRemote) ServiceManager.getService(AccountServiceRemote.class);
		accountService.deleteAccountById(account.getId());
	}

}

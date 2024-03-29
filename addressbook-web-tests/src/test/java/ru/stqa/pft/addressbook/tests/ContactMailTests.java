package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactMailTests extends TestBase{

    @Test
    public void contactMailTest () {
        app.goTo().gotoHomePage();

        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditForm)));
    }

    private String mergeMails(ContactData contact) {
        return Arrays.asList(contact.getMail(), contact.getMail2(), contact.getMail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactMailTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String mail) {
        return mail.replaceAll("\\s", "");
    }
}

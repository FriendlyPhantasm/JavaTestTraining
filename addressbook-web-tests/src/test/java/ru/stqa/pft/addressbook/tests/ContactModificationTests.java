package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Ivan").withMiddlename("Sergeevich")
                    .withLastname("Sozdanko").withNickname("Creatic").withCompany("Best Company").withTitle("World")
                    .withAddress("New York").withMobile("+79007773333"));
        }
    }

    @Test (enabled = true)
    public void testContactModification() {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withContactId(modifiedContact.getContactId()).withFirstname("Ivan")
                .withMiddlename("Sergeevich").withLastname("Modifikenko").withNickname("Dishisv").withCompany("Best Company")
                .withTitle("World").withAddress("New York").withMobile("+79007773333");
        app.contact().modify(contact);
        app.goTo().gotoHomePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}

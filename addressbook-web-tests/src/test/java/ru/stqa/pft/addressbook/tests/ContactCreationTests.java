package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() throws Exception {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Dishenko");
        app.contact().create(contact);
        app.goTo().gotoHomePage();
        Assert.assertEquals(app.contact().count(), before.size() + 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withContactId(after.stream().mapToInt((c) -> c.getContactId()).max().getAsInt()))));
    }

}

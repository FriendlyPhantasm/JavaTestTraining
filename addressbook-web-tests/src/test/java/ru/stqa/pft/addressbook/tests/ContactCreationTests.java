package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() throws Exception {
        app.goTo().gotoHomePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Ivan").withLastname("Dishenko");
        app.contact().create(contact);
        app.goTo().gotoHomePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withContactId(after.stream().mapToInt((c) -> c.getContactId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);

    }

}

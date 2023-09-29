package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoHomePage();
            app.contact().create(new ContactData().withFirstname("Ivan").withMiddlename("Sergeevich")
                    .withLastname("Sozdanko").withNickname("Creatic").withCompany("Best Company").withTitle("World")
                    .withAddress("New York").withMobilePhone("+79007773333"));
        }
    }
    @Test (enabled = true)
    public void testContactDeletion() {
        app.goTo().gotoHomePage();
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().acceptAlert();
        app.goTo().gotoHomePage();
        Assert.assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}

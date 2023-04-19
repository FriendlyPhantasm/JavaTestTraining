package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().fillContactForm(new ContactData("Ivan", "Sergeevich", "Modifikenko", "Dishisv", "Best Company", "World", "New York", "+79007773333"));
        app.getContactHelper().updateContact();
    }
}

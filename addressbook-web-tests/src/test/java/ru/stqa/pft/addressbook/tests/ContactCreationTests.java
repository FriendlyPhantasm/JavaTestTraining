package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().initAddContact();
        app.getContactHelper().fillContactForm(new ContactData("Ivan", "Sergeevich", "Dishenko",
                                    "Dishisv", "Best Company", "World", "New York", "+79007773333", "testgroup"), true);
        app.getContactHelper().submitAddContact();
    }


}

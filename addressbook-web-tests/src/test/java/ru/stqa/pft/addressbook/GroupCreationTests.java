package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    initGroupCreation();
    fillGroupForm(new GroupData("testgroup", "test1", "test2"));
    submitGroupCreation();
    returnToGroupPage();
  }

  @Test
  public void testContactAddition() throws Exception {
    initAddContact();
    fillContactForm(new ContactData("Ivan", "Sergeevich", "Dishenko", "Dishisv", "Best Company", "World", "New York", "+79007773333"));
    submitAddContact();
  }


}

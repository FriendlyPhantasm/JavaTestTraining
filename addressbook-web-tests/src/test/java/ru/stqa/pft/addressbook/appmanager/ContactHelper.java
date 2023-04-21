package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void submitAddContact() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"),contactData.firstname());
      type(By.name("middlename"),contactData.middlename());
      type(By.name("lastname"),contactData.lastname());
      type(By.name("nickname"),contactData.nickname());
      type(By.name("title"),contactData.title());
      type(By.name("company"),contactData.company());
      type(By.name("address"),contactData.address());
      type(By.name("mobile"),contactData.mobile());

      if (creation) {
          new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
          Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
      if (isElementPresent(By.name("new_group"))) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    }

    public void initAddContact() {
      click(By.linkText("add new"));
    }

    public void selectContact() {
        //click(By.id("3"));
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void createContact(ContactData contact, boolean creation) {
        initAddContact();
        fillContactForm(contact, creation);
        submitAddContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    };
}

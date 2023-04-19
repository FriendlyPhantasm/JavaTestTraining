package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void submitAddContact() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.firstname());
      type(By.name("middlename"),contactData.middlename());
      type(By.name("lastname"),contactData.lastname());
      type(By.name("nickname"),contactData.nickname());
      type(By.name("title"),contactData.title());
      type(By.name("company"),contactData.company());
      type(By.name("address"),contactData.address());
      type(By.name("mobile"),contactData.mobile());
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
}

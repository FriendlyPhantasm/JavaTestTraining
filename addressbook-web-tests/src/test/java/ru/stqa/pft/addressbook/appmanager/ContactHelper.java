package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }
    public void submitAddContact() {
      click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("middlename"),contactData.getMiddlename());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("nickname"),contactData.getNickname());
      type(By.name("title"),contactData.getTitle());
      type(By.name("company"),contactData.getCompany());
      type(By.name("address"),contactData.getAddress());
      type(By.name("mobile"),contactData.getMobile());

      if (creation)
        {
            Select groupSelection = new Select(wd.findElement(By.name("new_group")));
            if (groupSelection.isMultiple())
                new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initAddContact() {
      click(By.linkText("add new"));
    }

    private void selectContactById(int contactId) {
        wd.findElement(By.cssSelector("input[value='" + contactId + "']")).click();
    }

    private void selectContactByIdToModify(int contactId) {
        List<WebElement> elements = wd.findElements(By.xpath("//table/tbody/tr"));
        int i = 2;
        for (WebElement element : elements.subList(1, elements.size())) {
            int id = Integer.parseInt(element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[1]/input")).getAttribute("value"));
            if (id == contactId) {
                click(By.xpath("//table[@id='maintable']/tbody/tr[" +  String.valueOf(i) + "]/td[8]/a/img"));
                return;
            }
            i++;
        }
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void create(ContactData contact) {
        initAddContact();
        fillContactForm(contact, true);
        submitAddContact();
    }

    public void modify(ContactData contact) {
        selectContactByIdToModify(contact.getContactId());
        fillContactForm(contact, false);
        updateContact();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getContactId());
        deleteContact();

    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    };

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table/tbody/tr"));
        int i = 2;
        for (WebElement element : elements.subList(1, elements.size())) {
            int id = Integer.parseInt(element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[1]/input")).getAttribute("value"));
            String lastName = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[2]")).getText();
            String firstName = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[3]")).getText();
            ContactData contact = new ContactData().withContactId(id).withFirstname(firstName).withLastname(lastName);
            contacts.add(contact);
            i++;
        }
        return contacts;
    }
}

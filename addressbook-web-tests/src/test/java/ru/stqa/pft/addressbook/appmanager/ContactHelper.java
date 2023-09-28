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
      type(By.name("home"),contactData.getHomePhone());
      type(By.name("work"),contactData.getWorkPhone());
      type(By.name("mobile"),contactData.getMobilePhone());

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

    public int count() {
        return wd.findElements(By.xpath("//table/tbody/tr")).size() - 1;
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
        contactCache = null;
    }

    public void modify(ContactData contact) {
        selectContactByIdToModify(contact.getContactId());
        fillContactForm(contact, false);
        updateContact();
        contactCache = null;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getContactId());
        deleteContact();
        contactCache = null;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    };

    private Contacts contactCache;
    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache= new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//table/tbody/tr"));
        int i = 2;
        for (WebElement element : elements.subList(1, elements.size())) {
            int id = Integer.parseInt(element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[1]/input")).getAttribute("value"));
            String lastName = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[2]")).getText();
            String firstName = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[3]")).getText();
            String allAddresses = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[4]")).getText();
            String allMails = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[5]")).getText();
            String allPhones = element.findElement(By.xpath("//tr[" + String.valueOf(i) + "]/td[6]")).getText();
            ContactData contact = new ContactData()
                    .withContactId(id)
                    .withFirstname(firstName)
                    .withLastname(lastName)
                    .withAllAddresses(allAddresses)
                    .withAllMails(allMails)
                    .withAllPhones(allPhones);
            contactCache.add(contact);
            i++;
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        selectContactByIdToModify(contact.getContactId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String addresses = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData()
                .withContactId(contact.getContactId())
                .withFirstname(firstName)
                .withLastname(lastName)
                .withHomePhone(home)
                .withMobilePhone(mobile)
                .withWorkPhone(work)
                .withMail(email)
                .withMail2(email2)
                .withMail3(email3)
                .withAllAddresses(addresses);
    }
}

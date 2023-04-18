package ru.stqa.pft.addressbook.model;

public record ContactData(String firstname, String middlename, String lastname, String nickname, String title,
                          String company, String address, String mobile) {
}
package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnetionTest {

    @Test
    public void testDbConnetion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}

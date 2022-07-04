package dev.mobile.framework.tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {

    @Test
    public void dbTest() {
        try {
            Runtime.getRuntime().exec("adb shell sqlite3 /data/data/com.google.android.apps.messaging/databases/bugle_db 'SELECT * FROM messages'");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.passingarguments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = getProperties();

        String url = properties.getProperty("db.postgresql.url");
        String username = properties.getProperty("db.postgresql.username");
        String password = properties.getProperty("db.postgresql.password");

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pg_database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        Properties properties = new Properties();

        String path = String.format("src/main/resources/db.properties", System.getProperty("user.dir"));

        try (InputStream inputStream = new FileInputStream(new File(path))) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        return properties;
    }

}
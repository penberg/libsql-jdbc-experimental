package org.libsql;

import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
 
class IntegrationTest {
    @Test
    void basic() throws Exception {
        DriverManager.registerDriver(new JDBC());
        DriverManager.getConnection("jdbc:libsql:hello.db");
    }
}

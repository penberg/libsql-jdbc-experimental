package org.libsql;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class JDBC implements Driver {
    public static final String PREFIX = "jdbc:libsql:";

    static {
        try {
            DriverManager.registerDriver(new JDBC());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (!isUrlValid(url)) {
            return null;
        }
        return new LibSQLConnection(url);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return isUrlValid(url);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMajorVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getMinorVersion() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    private static boolean isUrlValid(String url) {
        return url != null && url.startsWith(PREFIX);
    }
}

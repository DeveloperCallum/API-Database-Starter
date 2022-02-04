package com.beamedcallum.database;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DatabaseAction {
    private Connection connection;
    private final Database database;

    public DatabaseAction(Database databaseService) {
        this.database = databaseService;
    }

    public void close() {
        releaseConnection();
    }

    protected synchronized Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = database.acquireConnection();
        }

        return connection;
    }

    protected void releaseConnection() {
        database.closeConnection(connection);
    }
}

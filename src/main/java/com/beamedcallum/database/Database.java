package com.beamedcallum.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Responsible for managing the connection (Example: Closing and opening).
 **/
public abstract class Database {

    /**
     * Acquire a connection, this method could be used to acquire an existing cached connection, or create a entirely new one.
     * @return The usable connection.
     * @see Connection
     */
    protected abstract Connection acquireConnection() throws SQLException;

    /**
     * Release/Close the connection.
     * @param connection The connection that is no longer in use.
     */
    protected abstract void closeConnection(Connection connection);
}

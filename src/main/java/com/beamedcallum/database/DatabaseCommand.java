package com.beamedcallum.database;

import java.sql.SQLException;

/**
 * Create a new database command.
 */
public abstract class DatabaseCommand extends DatabaseAction{

    public DatabaseCommand(Database databaseService) {
        super(databaseService);
    }

    public void executeCommand() throws SQLException {
        execute();
        this.releaseConnection();
    }

    public void unExecuteCommand() throws SQLException {
        unExecute();
        this.releaseConnection();
    }

    protected abstract void execute() throws SQLException;
    protected abstract void unExecute() throws SQLException;
}

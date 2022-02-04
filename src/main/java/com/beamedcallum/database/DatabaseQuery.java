package com.beamedcallum.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Create a new database query.
 *
 * @param <V> The wrapper response.
 */
public abstract class DatabaseQuery<V> extends DatabaseAction {

    public DatabaseQuery(Database databaseService) {
        super(databaseService);
    }

    //Prepared Statements will close ResultSet instances they create.
    protected abstract PreparedStatement prepare() throws SQLException;

    //Each database query could be different, and might need to be handled differently.
    protected abstract V createWrapper(ResultSet queryRes) throws SQLException;

    public Optional<V> executeQuery() throws SQLException {
        PreparedStatement prep = prepare();

        try (ResultSet resultSet = prep.executeQuery()) {
            V wrapper = createWrapper(resultSet);
            this.releaseConnection();

            if (wrapper == null){
                return Optional.empty();
            }

            return Optional.of(wrapper);
        }
    }
}

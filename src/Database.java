/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit Aggarwal
 */
public enum Database {

    MSACCESS("Microsoft Access"),
    SQLSERVER ("Microsoft SQL Server"),
    MYSQL ("MySQL"),
    POSTGRESQL("PostgreSQL");

    private final String database;

    private Database(String database)
    {
        this.database = database;
    }

    public String getName()
    {
        return(database);
    }

    public String toString()
    {
        return(this.database);
    }
    
}

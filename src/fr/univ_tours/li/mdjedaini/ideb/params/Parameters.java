/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.params;

/**
 *
 * @author mahfoud
 */
public class Parameters {
    
    //

    /**
     *
     */
    public String provider = "Mondrian";

    /**
     *
     */
    public String schemaFilePath;
    
    //

    /**
     *
     */
    public String dbms;

    /**
     *
     */
    public String driver;

    /**
     *
     */
    public String host;

    /**
     *
     */
    public String port;

    /**
     *
     */
    public String dbName;
    
    /**
     *
     */
    public String user;

    /**
     *
     */
    public String password;
    
    /**
     *
     */
    public String jdbcUrl;
    
    /**
     *
     */
    public String cubeName;
    
    //

    /**
     *
     */
    public String logFilePath;

    /**
     *
     */
    public String mondrianConnectionString;
    
    /**
     *
     */
    public Integer nbOfUsers;
    
    //
    ConnectionParameters c_params;
    EvaluationParameters e_params;
    
    /*
     * 
     */

    /**
     *
     */

    public Parameters() {
        
        this.provider           = "Mondrian";
        this.schemaFilePath     = "schema.xml";
        
        this.dbms               = "mysql";
        this.driver             = "com.mysql.jdbc.Driver";
        this.jdbcUrl            = "jdbc:mysql://localhost:3306/ssb";
        this.user               = "root";
        this.password           = "motdepasse";
        
        this.cubeName           = "SSB";
        
        this.logFilePath        = "Workload.xml";
        //this.logFilePath        = "Workload-1458222382.xml";
        
        this.nbOfUsers          = 5;
        
        this.rebuildConnectionString();
        
    }
    
    /**
     * 
     * @param arg_provider
     * @param arg_schemaFilePath
     * @param arg_dbms
     * @param arg_driver
     * @param arg_jdbcUrl
     * @param arg_user
     * @param arg_password
     * @param arg_logFilePath 
     */
    public Parameters   (  
                        String arg_provider,
                        String arg_schemaFilePath,
                        String arg_dbms,
                        String arg_driver,
                        String arg_jdbcUrl,
                        String arg_user,
                        String arg_password,
                        String arg_logFilePath
                        ) {
        this.provider           = arg_provider;
        this.schemaFilePath     = arg_schemaFilePath;
        
        this.dbms               = arg_dbms;
        this.driver             = arg_driver;
        this.jdbcUrl            = arg_jdbcUrl;
        this.user               = arg_user;
        this.password           = arg_password;
        
        this.logFilePath        = arg_logFilePath;
        
        this.rebuildConnectionString();
    }
    
    /**
     * 
     */
    public final void rebuildConnectionString() {
        this.mondrianConnectionString   = 
                "Provider=" + this.provider
                + ";Jdbc=" + this.jdbcUrl
                + ";Catalog=" + this.schemaFilePath
                + ";JdbcDrivers=" + this.driver
                + ";JdbcUser=" + this.user
                + ";JdbcPassword=" + this.password;
    }

    /**
     *
     * @return
     */
    public String getProvider() {
        return provider;
    }

    /**
     *
     * @param provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     *
     * @return
     */
    public String getSchemaFilePath() {
        return schemaFilePath;
    }

    /**
     *
     * @param schemaFilePath
     */
    public void setSchemaFilePath(String schemaFilePath) {
        this.schemaFilePath = schemaFilePath;
    }

    /**
     *
     * @return
     */
    public String getDbms() {
        return dbms;
    }

    /**
     *
     * @param dbms
     */
    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    /**
     *
     * @return
     */
    public String getDriver() {
        return driver;
    }

    /**
     *
     * @param driver
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     *
     * @return
     */
    public String getHost() {
        return host;
    }

    /**
     *
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     *
     * @return
     */
    public String getPort() {
        return port;
    }

    /**
     *
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     *
     * @return
     */
    public String getDbName() {
        return dbName;
    }

    /**
     *
     * @param dbName
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     *
     * @param jdbcUrl
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     *
     * @return
     */
    public String getCubeName() {
        return cubeName;
    }

    /**
     *
     * @param cubeName
     */
    public void setCubeName(String cubeName) {
        this.cubeName = cubeName;
    }

    /**
     *
     * @return
     */
    public String getLogFilePath() {
        return logFilePath;
    }

    /**
     *
     * @param logFilePath
     */
    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    /**
     *
     * @return
     */
    public String getMondrianConnectionString() {
        this.rebuildConnectionString();
        return mondrianConnectionString;
    }

    /**
     *
     * @param mondrianConnectionString
     */
    public void setMondrianConnectionString(String mondrianConnectionString) {
        this.mondrianConnectionString = mondrianConnectionString;
    }

    /**
     *
     * @return
     */
    public Integer getNbOfUsers() {
        return nbOfUsers;
    }

    /**
     *
     * @param nbOfUsers
     */
    public void setNbOfUsers(Integer nbOfUsers) {
        this.nbOfUsers = nbOfUsers;
    }
    
    
    
}

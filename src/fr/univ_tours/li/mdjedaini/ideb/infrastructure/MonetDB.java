/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.infrastructure;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mahfoud
 */
public class MonetDB extends Database {

    /**
     * 
     */
    public MonetDB() {
        super();
        try {
            Class.forName("nl.cwi.monetdb.jdbc.MonetDriver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public MonetDB(String arg_cs, String arg_userName, String arg_password) {
        this();
        this.connectionString   = arg_cs;
        this.username           = arg_userName;
        this.password           = arg_password;
    }
    
    @Override
    public void connect() {
        
        try {
            this.c  = DriverManager.getConnection(this.connectionString, this.username, this.password);
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void submit(String arg_query) {
        
        try {
            Statement s = this.c.createStatement();
            ResultSet r = s.executeQuery(arg_query);
            
            while(r.next()) {
                
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.infrastructure;

/**
 *
 * @author mahfoud
 */
public interface I_Database {
    
    /**
     * Connects to the database
     */
    public void connect();
    
    /**
     * Submits a query to the DBMS
     * @param arg_query 
     */
    public void submit(String arg_query);
    
}

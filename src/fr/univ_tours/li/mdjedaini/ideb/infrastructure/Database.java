/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.infrastructure;

import java.sql.Connection;

/**
 *
 * @author mahfoud
 */
public abstract class Database implements I_Database {
    
    /**
     * 
     */
    String connectionString;
    String username;
    String password;
    
    /**
     * Interface java.sql.Connection implémentée par les drivers
     */
    Connection  c;
    
    /**
     * 
     */
    protected Database() {
        System.out.println("Constructeur de la classe abstraite Database");
    }
    
}

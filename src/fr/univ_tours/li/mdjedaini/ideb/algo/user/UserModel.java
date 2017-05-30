/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.user;

import fr.univ_tours.li.mdjedaini.ideb.user.User;

/**
 *
 * @author mahfoud
 */
public abstract class UserModel implements I_UserSimulator {
    
    //
    User user;
    
    /**
     * 
     */
    public UserModel() {
    }
    
    /**
     * 
     * @param arg_user 
     */
    public UserModel(User arg_user) {
        this.user   = arg_user;
    }
    
}

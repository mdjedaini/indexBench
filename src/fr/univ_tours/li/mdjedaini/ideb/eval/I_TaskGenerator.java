/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval;

import fr.univ_tours.li.mdjedaini.ideb.user.User;
import java.util.List;

/**
 *
 * @author mahfoud
 */
public interface I_TaskGenerator {
    
    /**
     * Generates a list of tasks.
     * @return 
     */
    public List<Task> generateTaskList(Integer arg_nbTask);
    
    /**
     * Generates a given task for a given user
     * @param arg_user
     * @return 
     */
    public Task generateTaskForUser(User arg_user);
    
}

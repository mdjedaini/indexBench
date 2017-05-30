/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.scoring;

import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;

/**
 *
 * @author mahfoud
 */
public interface I_ExplorationScorer {
    
    /**
     * This function is responsible for computing the score of a task.
     * @param arg_sutr
     * @return 
     */
    public ExplorationScore score(Exploration arg_sutr);
    
}

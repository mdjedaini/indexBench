/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.similarity;

import fr.univ_tours.li.mdjedaini.ideb.struct.Session;

/**
 *
 * @author mahfoud
 */
public interface I_SessionSimilarity {
    
    /**
     * Computes the similarity between two sessions.
     * The similarity score should be a double normalized between 0.0 and 1.0.
     * @param arg_s1
     * @param arg_s2
     * @return 
     */
    public Double similarity(Session arg_s1, Session arg_s2);
    
}

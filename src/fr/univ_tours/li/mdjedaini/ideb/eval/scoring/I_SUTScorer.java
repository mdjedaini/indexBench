/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.scoring;

import fr.univ_tours.li.mdjedaini.ideb.eval.SUTResolution;

/**
 *
 * @author mahfoud
 */
public interface I_SUTScorer {
    
    /**
     * This function is responsible for computing a score for a SUT resolution.
     * 
     * @param arg_sutr
     * @return 
     */
    public SutResolutionScore score(SUTResolution arg_sutr);
    
}

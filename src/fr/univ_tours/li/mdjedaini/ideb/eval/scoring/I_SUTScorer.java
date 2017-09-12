/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.scoring;

import fr.univ_tours.li.mdjedaini.ideb.eval.SUTResolution;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.Metric;

/**
 *
 * @author mahfoud
 */
public interface I_SUTScorer {
    
    /**
     * 
     * @param arg_metric 
     */
    public void addMetric(Metric arg_metric);
    
    /**
     * This function is responsible for computing a score for a SUT resolution.
     * 
     * @param arg_sutr
     * @return 
     */
    public SutResolutionScore score(SUTResolution arg_sutr);
    
}

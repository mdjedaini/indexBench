/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.metric.sut;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.Metric;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.learning.MetricMLContribution;
import fr.univ_tours.li.mdjedaini.ideb.eval.scoring.MetricScore;

/**
 * This metric evaluates the evolution of the access area.
 * Access area is defined as all the primary cells (tuples) accessed.
 * It evaluates how rich is the access area provided by the SUT.
 * @author mahfoud
 */
public class MetricLearningPrimary extends Metric {
    
    Metric metric;
    
    /**
     * 
     * @param arg_be 
     */
    public MetricLearningPrimary(BenchmarkEngine arg_be) {
        super(arg_be);
        this.metric         = new MetricMLContribution(arg_be);
    }
    
    /**
     * 
     * @param arg_tr
     * @return 
     */
    @Override
    public MetricScore apply(Exploration arg_tr) {
        return this.metric.apply(arg_tr);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getName() {
        return this.metric.getName();
    }
    
}

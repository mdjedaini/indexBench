/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.metric;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.eval.scoring.MetricScore;

/**
 *
 * @author mahfoud
 */
public abstract class Metric {
    
    // Metric identifier
    Integer mid;
    
    protected String name;
    protected String description;
    
    protected BenchmarkEngine benchmarkEngine;
    
    public Metric(BenchmarkEngine arg_be) {
        this.benchmarkEngine    = arg_be;
        //arg_be.registerMetric(this.getClass());
    }
    
    /**
     * A metric is applied to an epxloration and returns a score for this exploration.
     * @param arg_tr
     * @return 
     */
    public MetricScore apply(Exploration arg_tr) {
        System.err.println("Attention a surcharger la methode apply pour la metrique!");
        return null;
    }
    
    /**
     * 
     * @return 
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @return 
     */
    public BenchmarkEngine getBenchmarkEngine() {
        return this.benchmarkEngine;
    }
    
}

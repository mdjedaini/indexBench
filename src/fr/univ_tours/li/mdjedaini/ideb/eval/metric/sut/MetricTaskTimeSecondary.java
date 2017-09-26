/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.metric.sut;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.Metric;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.tasktime.MetricElapsedTime;
import fr.univ_tours.li.mdjedaini.ideb.eval.scoring.MetricScore;

/**
 * This metric evaluates the time taken to resolve a task.
 * 
 * @author mahfoud
 */
public class MetricTaskTimeSecondary extends Metric {
    
    Metric metric;
    
    /**
     * 
     * @param arg_be 
     */
    public MetricTaskTimeSecondary(BenchmarkEngine arg_be) {
        super(arg_be);
        this.metric = new MetricElapsedTime(arg_be);
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
    public String getName() {
        return this.metric.getName();
    }
    
}

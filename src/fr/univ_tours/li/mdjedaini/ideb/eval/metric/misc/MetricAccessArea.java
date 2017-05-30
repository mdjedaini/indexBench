/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.metric.misc;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.algo.similarity.I_SessionSimilarity;
import fr.univ_tours.li.mdjedaini.ideb.algo.similarity.RandomSessionSimilarity;
import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.Metric;
import fr.univ_tours.li.mdjedaini.ideb.eval.scoring.MetricScore;
import fr.univ_tours.li.mdjedaini.ideb.struct.CellList;

/**
 * This metric evaluates the evolution of the access area.
 * Access area is defined as all the primary cells (tuples) accessed.
 * It evaluates how rich is the access area provided by the SUT.
 * @author mahfoud
 */
public class MetricAccessArea extends Metric {
    
    // session similarity
    I_SessionSimilarity ss;
    
    /**
     * 
     * @param arg_be 
     */
    public MetricAccessArea(BenchmarkEngine arg_be) {
        super(arg_be);
        this.name           = "Metric Access Area";
        this.description    = "Evaluates the similarity of a generated session to previous user sessions...";
        this.ss             = new RandomSessionSimilarity();
    }
    
    /**
     * 
     * @param arg_be
     * @param arg_ss 
     */
    public MetricAccessArea(BenchmarkEngine arg_be, I_SessionSimilarity arg_ss) {
        super(arg_be);
        this.name           = "Metric Access Area";
        this.description    = "Evaluates the similarity of a generated session to previous user sessions...";
    }
    
    /**
     * Generates a random double, between 0.0 and 1.0.
     * 
     * @param arg_tr
     * @return 
     */
    @Override
    public MetricScore apply(Exploration arg_tr) {
        MetricScore result = new MetricScore(this, arg_tr);
        
        // cells from the log
        CellList logCellList    = this.getBenchmarkEngine().getLog().getCellList();
        
        // cells from the session provided by the SUT
        CellList sutCellList    = arg_tr.getWorkSession().getCellList();
        
        Double num      = sutCellList.minus(logCellList).nbOfCells().doubleValue();
        Double denum    = sutCellList.union(logCellList).nbOfCells().doubleValue();
        
        result.score    = num / denum;
        
        return result;
    }
    
    
    
}

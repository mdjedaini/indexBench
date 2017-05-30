/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.metric;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.eval.scoring.MetricScore;
import fr.univ_tours.li.mdjedaini.ideb.olap.query.Query;
import fr.univ_tours.li.mdjedaini.ideb.tools.Stats;

/**
 *
 * @author 21408782t
 */
public class MetricNbOfCells extends Metric {

    /**
     * 
     * @param arg_be 
     */
    public MetricNbOfCells(BenchmarkEngine arg_be) {
        super(arg_be);
        this.name           = "Nb of cells";
        this.description    = "Number of cells in the current query";
    }
    
    public MetricScore apply(Exploration arg_tr) {
        MetricScore result  = new MetricScore(this, arg_tr);
        
        // on met un score au pif!
        result.score    = 0.;

        for(Query q_tmp : arg_tr.getWorkSession().getQueryList()) {
            result.queryScoreList.add(q_tmp.execute(Boolean.FALSE).getCellList().nbOfCells().doubleValue());
        }
        
        result.score    = Stats.average(result.queryScoreList);
        
        return result;
    }
    
}

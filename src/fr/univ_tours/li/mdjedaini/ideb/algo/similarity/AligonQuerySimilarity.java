/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.similarity;

import fr.univ_tours.li.jaligon.falseto.Generics.Connection;
import fr.univ_tours.li.jaligon.falseto.QueryStructure.Qfset;
import fr.univ_tours.li.jaligon.falseto.Similarity.Query.QueryComparisonByJaccardAndStructureThresholdWithSeveralSelectionPerLevel;
import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.ext.falseto.FalsetoQueryConverter;
import fr.univ_tours.li.mdjedaini.ideb.ext.falseto.FalsetoSessionConverter;
import fr.univ_tours.li.mdjedaini.ideb.olap.query.Query;
import fr.univ_tours.li.mdjedaini.ideb.params.Parameters;

/**
 *
 * @author mahfoud
 */
public class AligonQuerySimilarity {

    BenchmarkEngine be;
    
    // connection required by Falseto...
    Connection c;
    FalsetoSessionConverter fsc;
    FalsetoQueryConverter fqc;
    
    /**
     * 
     * @param arg_be 
     */
    public AligonQuerySimilarity(BenchmarkEngine arg_be) {
        this.be     = arg_be;
        this.fqc    = new FalsetoQueryConverter(arg_be);
        
        Parameters p    = this.be.getParameters();
        
        this.c  = this.be.getBenchmarkData().getFalsetoConnection();        
    }
    
    /**
     * 
     * @param arg_q1
     * @param arg_q2
     * @return 
     */
    public Double similarity(Query arg_q1, Query arg_q2) {
        Double result   = 0.5;
    
        Qfset qf1   = fqc.convertQuery(arg_q1);
        Qfset qf2   = fqc.convertQuery(arg_q2);
        
        // COMPUTE SIMILARITY
        // #####################################

        QueryComparisonByJaccardAndStructureThresholdWithSeveralSelectionPerLevel qc    = new QueryComparisonByJaccardAndStructureThresholdWithSeveralSelectionPerLevel(qf1, qf2, 0.33, 0.33, 0.33);
    
        result  = qc.computeSimilarity().getSimilarity();

        return result;
    }
    
    
    
}

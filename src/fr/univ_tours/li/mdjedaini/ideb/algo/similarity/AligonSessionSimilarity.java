/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.similarity;

import fr.univ_tours.li.jaligon.falseto.Generics.Connection;
import fr.univ_tours.li.jaligon.falseto.QueryStructure.QuerySession;
import fr.univ_tours.li.jaligon.falseto.Similarity.Session.CalculateGap;
import fr.univ_tours.li.jaligon.falseto.Similarity.Session.Matrix;
import fr.univ_tours.li.jaligon.falseto.Similarity.Session.SmithWaterman;
import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.ext.falseto.FalsetoSessionConverter;
import fr.univ_tours.li.mdjedaini.ideb.params.Parameters;
import fr.univ_tours.li.mdjedaini.ideb.struct.Session;

/**
 *
 * @author mahfoud
 */
public class AligonSessionSimilarity implements I_SessionSimilarity {

    BenchmarkEngine be;
    
    // connection required by Falseto...
    Connection c;
    FalsetoSessionConverter fsc;
    
    /**
     * 
     * @param arg_be 
     */
    public AligonSessionSimilarity(BenchmarkEngine arg_be) {
        this.be     = arg_be;
        this.fsc    = new FalsetoSessionConverter(arg_be);
        
        Parameters p    = this.be.getParameters();
        
        this.c  = this.be.getBenchmarkData().getFalsetoConnection();        
    }
    
    /**
     * 
     * @param arg_s1
     * @param arg_s2
     * @return 
     */
    @Override
    public Double similarity(Session arg_s1, Session arg_s2) {
        Double result   = 0.5;
    
        // #####################################
        // CONVERTING THE SESSIONS
        // #####################################
        QuerySession qs1    = this.fsc.convert(arg_s1);
        QuerySession qs2    = this.fsc.convert(arg_s2);
        
        // #####################################
        // COMPUTE SIMILARITY
        // #####################################
            
        Matrix matrix   = new Matrix(qs1, qs2, 0.33, 0.33, 0.33);
        
        matrix.fillMatrix_MatchMisMatch(0.7);
        matrix.applySymmetricIncreasingFunction();
        
        double gap          = new CalculateGap(matrix).calculateExtGap_AvgMatch();
        SmithWaterman sw    = new SmithWaterman(matrix, 0, gap, qs1, qs2, 0.7, 0.35, 0.5, 0.15);
            
        result  = sw.computeSimilarity().getSimilarity();
//        System.out.println("Session " + qs1.getId() + ",Session " + qs2.getId() + "," + result);

        return result;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.misc;

import java.util.List;

/**
 *
 * @author mahfoud
 */
public class KL_Divergence {

    /**
     * 
     */
    public KL_Divergence() {
    }    
    
    /**
     * 
     * @param arg_p1
     * @param arg_p2
     * @return 
     */
    public Double compute(List<Double> arg_p1, List<Double> arg_p2) {
        
        double klDiv = 0.0;

        for (int i = 0; i < arg_p1.size(); ++i) {
            if (arg_p1.get(i).equals(0.)) { continue; }
            if (arg_p2.get(i).equals(0.)) { continue; } // Limin
            
            klDiv += arg_p1.get(i) * Math.log( arg_p1.get(i) / arg_p2.get(i) );
        }
        
        return klDiv / Math.log(2); // moved this division out of the loop -DM
    }
    
    /**
     * 
     * @param arg_p1
     * @param arg_p2
     * @return 
     */
    public Double computeNormalized(List<Double> arg_p1, List<Double> arg_p2) {
        
        return 1 - Math.exp(-1. * this.compute(arg_p1, arg_p2));

    }
    
}

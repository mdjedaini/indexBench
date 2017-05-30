/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.olap.result;

import comparator.Comparator;

/**
 *
 * @author mahfoud
 */
public class EAB_Cell_ValueComparator implements Comparator<EAB_Cell> {
    
    /**
     * 
     * @param arg_c1
     * @param arg_c2
     * @return 
     */
    public double compare(EAB_Cell arg_c1, EAB_Cell arg_c2) {
        return arg_c1.getValueAsDouble().compareTo(arg_c2.getValueAsDouble());
    }
    
};
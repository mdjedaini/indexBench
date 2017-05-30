/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.ext.jung;

import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;

/**
 *
 * @author mahfoud
 */
public class EAB_Vertex {
    
    /**
     * 
     */
    public EAB_Cell c;
    
    /**
     * 
     * @param arg_c 
     */
    public EAB_Vertex(EAB_Cell arg_c) {
        this.c = arg_c;
    }
    
    /**
     * 
     * @param other
     * @return 
     */
    public boolean equals(Object other) {
        EAB_Vertex edge    = (EAB_Vertex)other;
        return this.c.equals(edge.c);
    }
 
    /**
     * 
     * @return 
     */
    public String toString() {
        return this.c.toString();
    }
    
}

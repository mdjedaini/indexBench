/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood;

import fr.univ_tours.li.mdjedaini.ideb.olap.query.Query;

/**
 *
 * @author mahfoud
 */
public interface I_QueryNeighborhood {
    
    /**
     * 
     * @param arg_q1
     * @param arg_q2
     * @return 
     */
    public boolean areNeigbours(Query arg_q1, Query arg_q2);
    
}

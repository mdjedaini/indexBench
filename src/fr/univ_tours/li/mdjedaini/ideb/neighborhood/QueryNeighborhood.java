/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood;

import fr.univ_tours.li.mdjedaini.ideb.neighborhood.member.MemberNeighborhood;
import fr.univ_tours.li.mdjedaini.ideb.olap.query.Query;

/**
 *
 * @author mahfoud
 */
public class QueryNeighborhood implements I_QueryNeighborhood {

    //
    MemberNeighborhood mn;
    
    /**
     * 
     */
    public QueryNeighborhood() {
        this.mn = new MemberNeighborhood();
    }
    
    /**
     * 
     * @param arg_mn 
     */
    public QueryNeighborhood(MemberNeighborhood arg_mn) {
        this.mn = arg_mn;
    }
    
    /**
     * 
     * @param arg_q1
     * @param arg_q2
     * @return 
     */
    public boolean areNeigbours(Query arg_q1, Query arg_q2) {

        
        
        return true;
        
    }

}

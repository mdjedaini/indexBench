/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood.member;

import fr.univ_tours.li.mdjedaini.ideb.olap.EAB_Member;

/**
 *
 * @author mahfoud
 */
public class DirectParentNeighborhood implements I_DrillMemberNeighborhood {
    
    /**
     * 
     * @param arg_m1
     * @param arg_m2
     * @return 
     */
    public boolean areNeigbours(EAB_Member arg_m1, EAB_Member arg_m2) {
        return arg_m1.isDirectChildOf(arg_m2) || arg_m2.isDirectChildOf(arg_m1);
    }
    
}

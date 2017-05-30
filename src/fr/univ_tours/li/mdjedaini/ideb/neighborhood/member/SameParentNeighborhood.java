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
public class SameParentNeighborhood implements I_SliceMemberNeighborhood {
    
    /**
     * 
     * @param arg_m1
     * @param arg_m2
     * @return 
     */
    @Override
    public boolean areNeigbours(EAB_Member arg_m1, EAB_Member arg_m2) {
        if(arg_m1.isBrotherOf(arg_m2)) {
            return true;
        }
        return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood.member;

import fr.univ_tours.li.mdjedaini.ideb.olap.EAB_Member;

/**
 * Base class for member neighborhood.
 * Returns true if the members are neighbors, either slice neighbors or rollup/drilldown neighbors.
 * Returns false else.
 * @author mahfoud
 */
public class MemberNeighborhood {
    
    //
    I_SliceMemberNeighborhood smn;
    I_DrillMemberNeighborhood dmn;
    
    /**
     * 
     */
    public MemberNeighborhood() {
        this.smn    = new SameParentNeighborhood();
        this.dmn    = new DirectParentNeighborhood();
    }
    
    /**
     * 
     * @param arg_smn
     * @param arg_dmn 
     */
    public MemberNeighborhood(I_SliceMemberNeighborhood arg_smn, I_DrillMemberNeighborhood arg_dmn) {
        this.smn    = arg_smn;
        this.dmn    = arg_dmn;
    }
    
    /**
     * 
     * @param arg_m1
     * @param arg_m2
     * @return 
     */
    public boolean areNeigbours(EAB_Member arg_m1, EAB_Member arg_m2) {
        return this.smn.areNeigbours(arg_m1, arg_m2) || this.dmn.areNeigbours(arg_m1, arg_m2);
    }
    
}

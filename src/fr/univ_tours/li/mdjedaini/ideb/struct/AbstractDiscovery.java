/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.struct;

/**
 *
 * @author mahfoud
 */
public abstract class AbstractDiscovery {
    
    //
    private static Integer didCounter   = 0;
    
    /**
     *
     */
    public Integer did;
    
    /**
     * 
     */
    public AbstractDiscovery() {
        this.did        = didCounter;
        AbstractDiscovery.didCounter++;
    }

    /**
     * 
     * @param arg_ad
     * @return 
     */
//    public AbstractDiscovery copy(AbstractDiscovery arg_ad) {
//        return arg_ad.getClass().newInstance()
//    }
    
    /**
     * 
     * @return 
     */
    public Integer getDid() {
        return did;
    }
    
    /**
     *
     * @return
     */
    public abstract CellList getCellList();
    
//    public abstract Double similarity(AbstractDiscovery arg_ad);
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Discovery " + this.getDid();
    }

}

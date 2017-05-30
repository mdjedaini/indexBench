/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.struct;

import fr.univ_tours.li.mdjedaini.ideb.ext.jung.EAB_Vertex;
import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;

/**
 *
 * @author mahfoud
 */
public class DiscoveryAsCellTopology extends AbstractDiscovery {
    
    // 

    /**
     *
     */
    public DiscoveryTopology dt;
    
    /**
     * 
     * @param arg_ad
     * @throws Exception 
     */
    public DiscoveryAsCellTopology(AbstractDiscovery arg_ad) throws Exception {
        //super();
        
        if(arg_ad instanceof DiscoveryAsCellTopology) {
            DiscoveryAsCellTopology ad_tmp  = (DiscoveryAsCellTopology)arg_ad;
            this.dt = new DiscoveryTopology(ad_tmp.dt);
        } else {
            throw new Exception("Impossible to copy the object...");
        }
        
    }
    
    /**
     * 
     * @param arg_dt 
     */
    public DiscoveryAsCellTopology(DiscoveryTopology arg_dt) {
        super();
        this.dt = arg_dt;
    }

    /**
     * Returns the topology as a cell list.
     * @return 
     */
    @Override
    public CellList getCellList() {
        CellList result = new CellList();
        
        for(Object c_tmp : this.dt.g.getVertices()) {
            EAB_Vertex eav   = (EAB_Vertex)c_tmp;
            result.addCell(eav.c);
        }
        
        return result;
    }
    
    /**
     * 
     * @param arg_c 
     */
    public void removeCell(EAB_Cell arg_c) {
        this.dt.removeCell(arg_c);
    }
    
    /**
     * 
     * @param arg_c 
     * @return  
     */
    public boolean contains(EAB_Cell arg_c) {
        for(Object o_tmp : this.dt.g.getVertices()) {
            EAB_Vertex eav_tmp  = (EAB_Vertex)o_tmp;
            if(eav_tmp.c.equals(arg_c)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return this.dt.toString();
    }
    
}

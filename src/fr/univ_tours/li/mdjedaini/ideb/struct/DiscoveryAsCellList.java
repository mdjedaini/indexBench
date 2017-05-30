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
public class DiscoveryAsCellList extends AbstractDiscovery {
    
    // 

    /**
     *
     */
    public DiscoveryTopology dt;
    CellList cellList;
    
    /**
     * 
     * @param arg_ad
     * @throws Exception 
     */
    public DiscoveryAsCellList(AbstractDiscovery arg_ad) throws Exception {
        //super();
        
        if(arg_ad instanceof DiscoveryAsCellList) {
            DiscoveryAsCellList ad_tmp  = (DiscoveryAsCellList)arg_ad;
            this.dt = new DiscoveryTopology(ad_tmp.dt);
        } else {
            throw new Exception("Impossible to copy the object...");
        }
        
    }

    /**
     * 
     */
    public DiscoveryAsCellList() {
        super();
        this.cellList   = new CellList();
    }
    
    /**
     * 
     * @param arg_cellList 
     */
    public DiscoveryAsCellList(CellList arg_cellList) {
        super();
        this.cellList   = arg_cellList;
    }

    /**
     * Returns the topology as a cell list.
     * @return 
     */
    @Override
    public CellList getCellList() {
        return this.cellList;
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
     * @param arg_cellList 
     */
    public void addCellList(CellList arg_cellList) {
        this.cellList.addCellCollection(arg_cellList.getCellCollection());
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

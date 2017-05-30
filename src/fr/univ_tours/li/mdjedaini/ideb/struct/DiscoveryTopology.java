/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.struct;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import fr.univ_tours.li.mdjedaini.ideb.ext.jung.EAB_Edge;
import fr.univ_tours.li.mdjedaini.ideb.ext.jung.EAB_Vertex;
import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;

/**
 * This class represents a discovery topology.
 * A topology can be represented different ways, so we use a class for it.
 * This class can be inherited from...
 * @author mahfoud
 */
public class DiscoveryTopology {
    
    // jung graph
    public Graph g;

    /**
     * 
     * @param arg_dt
     * @throws Exception 
     */
    public DiscoveryTopology(DiscoveryTopology arg_dt) throws Exception {
        super();
        
        // @todo recuperer le graph builder a partir du benchmark engine...
        if(arg_dt instanceof DiscoveryTopology) {
            DiscoveryTopology dt_tmp    = (DiscoveryTopology)arg_dt;
            this.g  = new DirectedSparseGraph<EAB_Vertex, EAB_Edge>();
            
            // 1ere boucle for pas obligatoire...
            for(Object v_tmp : arg_dt.g.getVertices()) {
                this.g.addVertex(v_tmp);
            }
            
            for(Object e_tmp : arg_dt.g.getEdges()) {
                this.g.addEdge(e_tmp, arg_dt.g.getIncidentVertices(e_tmp));
            }
        } else {
            throw new Exception("Impossible to copy the object...");
        }
        
    }
    
    /**
     * 
     * @param arg_g 
     */
    public DiscoveryTopology(Graph arg_g) {
        this.g  = arg_g;
    }
    
    /**
     * 
     * @param arg_g 
     */
    public void addCell(EAB_Cell arg_c) {
        
    }

    /**
     * 
     * @param arg_c 
     */
    public void removeCell(EAB_Cell arg_c) {
        EAB_Vertex toRemove = null;
        
        for(Object o_tmp : this.g.getVertices()) {
            EAB_Vertex eav_tmp   = (EAB_Vertex)o_tmp;
            if(eav_tmp.c.equals(arg_c)) {
                toRemove    = eav_tmp;
                
            }
        }
        
        if(toRemove != null) {
            this.g.removeVertex(toRemove);
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        String result   = "";
        
        result  += "Cells in the discovery:";
        result  += System.lineSeparator();
        
        for(Object o_tmp : this.g.getVertices()) {
            EAB_Vertex eav_tmp   = (EAB_Vertex)o_tmp;
            result  += eav_tmp.c;
            //System.out.println(eav_tmp.c);
        }
        
        return result;
    }
    
    
}

package fr.univ_tours.li.mdjedaini.ideb.io;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.io;
//
//import fr.univ_tours.li.mdjedaini.eab.olap.query.Query;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.EAB_Cell;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.QueryTriplet;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.Result;
//import fr.univ_tours.li.mdjedaini.eab.struct.AbstractDiscovery;
//
///**
// *
// * @author mahfoud
// */
//public class DiscoveryWriter implements I_DiscoveryWriter {
//
//    public AbstractDiscovery d;
//    
//    /**
//     * 
//     * @param arg_d 
//     */
//    public DiscoveryWriter(AbstractDiscovery arg_d) {
//        this.d  = arg_d;
//    }
//    
//    /**
//     * 
//     * @param arg_discovery
//     * @return 
//     */
//    @Override
//    public String writeDiscovery(AbstractDiscovery arg_discovery) {
//        String result   = "";
//
//        result  += this.highLightCells();
//        
//        result  += "<div class=\"discovery discovery-" + arg_discovery.did + "\" >";
//        result  += "<h1>DISCOVERY " + arg_discovery.did + "</h1>";
//        
//        for(Query q_tmp : this.d.clusterize().keySet()) {
//            QueryTriplet qt = (QueryTriplet)q_tmp;
//            Result r_tmp    = qt.getResult();
//            ResultWriter rw = new ResultWriter(r_tmp);
//            result  += rw.writeResult(rw.r);
//        }
//        
//        result  += "</div>";
//        
//        return result;
//    }
//    
//    /**
//     * 
//     * @return 
//     */
//    String highLightCells() {
//        String result   = "";
//        
//        result  += "<style>";
//        
//        for(EAB_Cell c_tmp : this.d.cellList.getCellCollection()) {
//            
//            result  += ".discovery-" + this.d.did + " .cid-" + c_tmp.cellId + " { ";
//            
//            result  += "background-color: green;";
//            
//            result  += "}";
//            
//        }
//        
//        result  += "</style>";
//        
//        return result;
//    }
//    
//}

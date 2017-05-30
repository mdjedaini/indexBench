package fr.univ_tours.li.mdjedaini.ideb.eval.metric.misc;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.eval.metric.misc;
//
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.eval.TaskResolution;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.eval.scoring.MetricScore;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.EAB_Cell;
//import fr.univ_tours.li.mdjedaini.eab.struct.AbstractDiscovery;
//import fr.univ_tours.li.mdjedaini.eab.struct.CellList;
//
///**
// * 
// * @author mahfoud
// */
//public class MetricNumberFoundDiscoveries extends Metric {
//    
//    CellList workSessionCellList;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricNumberFoundDiscoveries(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Metric # Found Discoveries";
//        this.description    = "Number of discoveries completely retrieved...";
//    }
//    
//    /**
//     * Computes the average recall for all the target discoveries for this task.
//     * 
//     * @param arg_tr
//     * @return 
//     */
//    @Override
//    public MetricScore apply(TaskResolution arg_tr) {
//        MetricScore result  = new MetricScore(this, arg_tr);
//        
//        // 
//        this.workSessionCellList    = arg_tr.getWorkSession().getCellList();
//        
//        // for each discovery, check if it has been completely found
//        for(AbstractDiscovery ad_tmp : arg_tr.getTask().getTargetDiscoveryList()) {
//            if(this.applyOnDiscovery(ad_tmp)) {
//                result++;
//            }
//        }
//        
//        return result;
//    }
//    
//    /**
//     * Checks whether the given discovery has been completely found or not.
//     * @param arg_ad 
//     */
//    private Boolean applyOnDiscovery(AbstractDiscovery arg_ad) {
//        Boolean result  = true;
//            
//        CellList adCellList = arg_ad.getCellList().distinct();
//        
//        // we have the cells, we compute the ratio...
//        Integer denum   = adCellList.nbOfCells();
//        Integer num     = 0;
//            
//        // check whether all cells have been found or not
//        for(EAB_Cell c_tmp : adCellList.getCellCollection()) {
//            if(!this.workSessionCellList.contains(c_tmp)) {
//                result  = false;
//                break;
//            }
//        }
//
//        return result;
//    }
//    
//    
//    
//}

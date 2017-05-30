package fr.univ_tours.li.mdjedaini.ideb.eval.metric.learning;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.eval.metric.learning;
//
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.eval.TaskResolution;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.I_MetricForExploration;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.eval.scoring.MetricScore;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.Query;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.EAB_Cell;
//import fr.univ_tours.li.mdjedaini.eab.struct.AbstractDiscovery;
//import fr.univ_tours.li.mdjedaini.eab.struct.CellList;
//import fr.univ_tours.li.mdjedaini.eab.tools.Utils;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * This metric evaluates the evolution of the access area.
// * Access area is defined as all the primary cells (tuples) accessed.
// * It evaluates how rich is the access area provided by the SUT.
// * @author mahfoud
// */
//public class MetricPL0 extends Metric implements I_MetricForExploration {
//    
//    // 
//    Double p_l0;    // probability to master the skill before starting
//    Double p_t;     // probability to master the skill after an exercice
//    Double p_g;     // probability to guess even we do not master the skill
//    Double p_s;     // probability to fail even if we master the skill
//    
//    TaskResolution tr;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricPL0(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Metric: PL0";
//        this.description    = "PL0 parameter for the knowledge tracing...";
//    }
//    
//    /**
//     * Generates a random double, between 0.0 and 1.0.
//     * 
//     * @param arg_tr
//     * @return 
//     */
//    @Override
//    public MetricScore apply(TaskResolution arg_tr) {
//        MetricScore result  = new MetricScore(this, arg_tr);
//        
//        this.tr = arg_tr;
//        
//        this.tr.getTaskBundle().getCurrentUserLog().execute(Boolean.TRUE);
//
//        Integer denum   = arg_tr.getTask().getTargetDiscoveryList().size();
//        
//        for(AbstractDiscovery ad_tmp : arg_tr.getTask().getTargetDiscoveryList()) {
//            Double r_tmp    = MetricLearningUtils.initializePL0(arg_tr, ad_tmp);
//            result          = result + r_tmp;
//        }
//        
//        // result is the average of found discoveries...
//        result  = result / denum;
//        
//        return result;
//    }
//    
//}

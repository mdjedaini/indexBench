package fr.univ_tours.li.mdjedaini.ideb.eval.metric.learning;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.eval.metric.learning;
//
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.eval.Exploration;
//import fr.univ_tours.li.mdjedaini.eab.eval.TaskResolution;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.eval.scoring.MetricScore;
//import fr.univ_tours.li.mdjedaini.eab.struct.AbstractDiscovery;
//import fr.univ_tours.li.mdjedaini.eab.struct.CellList;
//import java.util.List;
//import java.util.Map;
//
///**
// * This metric evaluates the evolution of the access area.
// * Access area is defined as all the primary cells (tuples) accessed.
// * It evaluates how rich is the access area provided by the SUT.
// * @author mahfoud
// */
//public class MetricKnowledgeTracing extends Metric {
//    
//    // 
//    Double p_l0;    // probability to master the skill before starting
//    Double p_t;     // probability to master the skill after an exercice
//    Double p_g;     // probability to guess even we do not master the skill
//    Double p_s;     // probability to fail even if we master the skill
//    
//    Exploration tr;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricKnowledgeTracing(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Metric: Knowledge Tracing";
//        this.description    = "Evaluates the ability of a system to help users in mastering skills...";
//    }
//    
//    /**
//     * Generates a random double, between 0.0 and 1.0.
//     * 
//     * @param arg_tr
//     * @return 
//     */
//    @Override
//    public MetricScore apply(Exploration arg_tr) {
//        MetricScore result  = new MetricScore(this, arg_tr);
//        
//        this.tr = arg_tr;
//        
//        this.tr.getCurrentUserLog().execute(Boolean.TRUE);
//
//        Integer denum   = arg_tr.getTask().getTargetDiscoveryList().size();
//        
//        for(AbstractDiscovery ad_tmp : arg_tr.getTask().getTargetDiscoveryList()) {
//            Double r_tmp    = this.applyForDiscovery(ad_tmp);
//            result          = result + r_tmp;
//            
//            if(result.isNaN()) {
//                this.applyForDiscovery(ad_tmp);
//            }
//        }
//        
//        // result is the average of found discoveries...
//        result  = result / denum;
//        
//        return result;
//    }
//    
//    
//    
//    /**
//     * Apply the metric for a single discovery.
//     * @param arg_ad
//     * @return 
//     */
//    public MetricScore applyForDiscovery(AbstractDiscovery arg_ad) {
//        Double result   = 0.5;
//        
//        // the discovery we work on
//        CellList discoveryCells     = arg_ad.getCellList();
//        
//        // success list for the discovery
//        List<Boolean> successList   = MetricLearningUtils.computeSuccessList(this.tr, arg_ad);
//        
//        Map<String, Double> params  = MetricLearningUtils.initializeParameters(this.tr, arg_ad);
//        
//        List<Double> pliList        = MetricLearningUtils.computePliList(tr, arg_ad, successList, params);
//        
//        // the result is the last pli
//        result  = pliList.get(pliList.size() - 1);
//        
//        return result;
//    }
//    
//}

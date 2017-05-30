package fr.univ_tours.li.mdjedaini.ideb.eval.scoring;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.eval.scoring;
//
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.eval.Exploration;
//import fr.univ_tours.li.mdjedaini.eab.eval.TaskResolution;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.EAB_Cell;
//import fr.univ_tours.li.mdjedaini.eab.struct.AbstractDiscovery;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
///**
// * Responsible for scoring a task output.
// * @author mahfoud
// */
//public class TaskScorer implements I_ExplorationScorer {
//    
//    BenchmarkEngine benchmarkEngine;
//    
//    // list of metrics
//    List<Metric> metricList;
//
//    Collection<AbstractDiscovery> targetDiscoveryList;
//    
//    List<Map<AbstractDiscovery, List<EAB_Cell>>> cellDiscovered;
//    
//    Map<AbstractDiscovery, List<Boolean>> successListByDiscovery;
//    
//    Map<AbstractDiscovery, AbstractDiscovery> initialTargetDiscoveryToDiscovery;
//    Map<AbstractDiscovery, AbstractDiscovery> discoveryToInitialTargetDiscovery;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public TaskScorer(BenchmarkEngine arg_be) {
//        this.benchmarkEngine    = arg_be;
//        this.metricList         = new ArrayList<>();
//    }
//
//    /**
//     * 
//     * @param arg_be
//     * @param arg_metricList 
//     */
//    public TaskScorer(BenchmarkEngine arg_be, List<Metric> arg_metricList) {
//        this.benchmarkEngine    = arg_be;
//        this.metricList         = arg_metricList;
//    }
//    
//    /**
//     * 
//     * @param arg_m 
//     */
//    public void addMetric(Metric arg_m) {
//        this.metricList.add(arg_m);
//    }
//
//    /**
//     * 
//     * @param arg_tr
//     * @return 
//     */
//    @Override
//    public TaskResolutionScore score(Exploration arg_tr) {
//        
//        TaskResolution tr   = (TaskResolution)arg_tr;
//        TaskResolutionScore result    = new TaskResolutionScore(tr, this);
//        
//        for(Metric m_tmp : this.metricList) {
//        
//            // list of scores for each query
//            List<Double> record = new ArrayList<>();
//            
//            System.out.println("Computing score for metric " + m_tmp.getName());
//            MetricScore ms      = m_tmp.apply(arg_tr);
//            result.registerScore(m_tmp, ms);
//            
//            for(int i=0; i<result.getTaskResolution().getWorkSession().getNumberOfQueries(); i++) {
//                Random rand    = new Random();
//                record.add(rand.nextDouble());
//            }
//            
//            result.registerScore(m_tmp, ms);
//        }
//        
//        return result;
//    }
//    
//    
//    
//}

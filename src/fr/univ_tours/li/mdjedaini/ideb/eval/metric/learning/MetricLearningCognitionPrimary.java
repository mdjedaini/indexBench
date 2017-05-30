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
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.eval.scoring.MetricScore;
//
///**
// * This metric evaluates the evolution of the access area.
// * Access area is defined as all the primary cells (tuples) accessed.
// * It evaluates how rich is the access area provided by the SUT.
// * @author mahfoud
// */
//public class MetricLearningCognitionPrimary extends Metric {
//    
//    Metric metric;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricLearningCognitionPrimary(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.metric         = new MetricKnowledgeTracing(arg_be);
//    }
//    
//    /**
//     * Apply the metric on the task resolution.
//     * 
//     * @param arg_tr
//     * @return 
//     */
//    @Override
//    public MetricScore apply(TaskResolution arg_tr) {
//        return this.metric.apply(arg_tr);
//    }
//    
//    /**
//     * 
//     * @return 
//     */
//    public String getName() {
//        return this.metric.getName();
//    }
//    
//}

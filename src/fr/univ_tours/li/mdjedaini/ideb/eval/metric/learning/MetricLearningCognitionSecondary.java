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
// *
// * @author mahfoud
// */
//public class MetricLearningCognitionSecondary extends Metric {
//    
//    Metric metric;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricLearningCognitionSecondary(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Metric Learning Growth Rate";
//        this.description    = "Evaluates the evolution of the learning...";
//        this.metric         = new MetricLearningGrowthRate(arg_be);
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

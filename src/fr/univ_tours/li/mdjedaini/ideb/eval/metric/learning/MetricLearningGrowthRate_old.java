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
//import fr.univ_tours.li.mdjedaini.eab.olap.query.Query;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.QueryTriplet;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.EAB_Cell;
//import fr.univ_tours.li.mdjedaini.eab.struct.AbstractDiscovery;
//import fr.univ_tours.li.mdjedaini.eab.struct.CellList;
//import fr.univ_tours.li.mdjedaini.eab.struct.Session;
//import fr.univ_tours.li.mdjedaini.eab.tools.Utils;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * This metric evaluates the evolution of the access area.
// * Access area is defined as all the primary cells (tuples) accessed.
// * It evaluates how rich is the access area provided by the SUT.
// * @author mahfoud
// */
//public class MetricLearningGrowthRate_old extends Metric  implements I_MetricForExploration {
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
//    public MetricLearningGrowthRate_old(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Metric Learning and Cognition";
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
//    public MetricScore apply(TaskResolution arg_tr) {
//        Double result   = 0.;
//        
//        this.tr = arg_tr;
//        
//        this.tr.getTaskBundle().getCurrentUserLog().execute(Boolean.TRUE);
//        
//        Integer denum   = arg_tr.getTask().getTargetDiscoveryList().size();
//        
//        for(AbstractDiscovery ad_tmp : arg_tr.getTask().getTargetDiscoveryList()) {
//            Double r_tmp    = this.applyForDiscovery(ad_tmp);
//            result          = result + r_tmp;
//        }
//        
//        // result is the average of found discoveries...
//        result  = result / denum;
//        
//        return result;
//    }
//    
//    /**
//     * 
//     * @param arg_ad
//     * @return 
//     */
//    public List<Boolean> computeSuccessList(AbstractDiscovery arg_ad) {
//        List<Boolean> successList   = new ArrayList<>();
//        
//        // accumulateur...
//        CellList cl_acc         = new CellList();
//        CellList discoveryCells = arg_ad.getCellList();
//        
//        for(Query q_tmp : this.tr.getWorkSession().getQueryList()) {
//            QueryTriplet qt_tmp = (QueryTriplet)q_tmp;
//            CellList cl_tmp     = qt_tmp.getResult().getCellList();
//            
//            Boolean success = false;
//            
//            for(EAB_Cell c_tmp : discoveryCells.getCellCollection()) {
//                
//                // success if at least one cell is newly discovered
//                if(cl_tmp.contains(c_tmp) && !cl_acc.contains(c_tmp)) {
//                    success = true;
//                    break;
//                }
//            }
//            
//            // ajoouter les cellules de la requete courante dans l'accumulateur
//            cl_acc.addCellCollection(cl_tmp.getCellCollection());
//            
//            // add the success to the success list...
//            successList.add(success);
//            
//        }
//        
//        return successList;
//    }
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
//        List<Boolean> successList   = this.computeSuccessList(arg_ad);
//        
//        this.initializeParameters(arg_ad);
//        
//        // current pl0, and pli does not exist
//        Double currentPLI   = this.p_l0;
//        Double previousPLI  = null;
//        result              = currentPLI;
//        
//        for(int i = 1; i < tr.getWorkSession().getQueryList().size(); i++) {
//            
//            System.out.println("Tous les PLI: " + currentPLI);
//            
//            // at each step, the current becomes the previous
//            previousPLI     = currentPLI;
//            Double proba;
//            
//            // proba is computed based on the previous
//            if(successList.get(i-1)) {
//                // success at the previous exercice
//                proba   = (previousPLI * (1 - this.p_s)) / ((previousPLI * (1 - this.p_s)) + ((1 - previousPLI) * this.p_g));
//            } else {
//                // fail at the previous exercice
//                proba   = (previousPLI * this.p_s) / ( (previousPLI * this.p_s) + ((1 - previousPLI) * (1 - this.p_g)) );
//            }
//            
//            // current PLI is either skill as mastered before (proba)
//            // or it has been learned during this step (1-proba)...
//            currentPLI  = proba + ((1 - proba) * this.p_t);
//            
////            result      = result * Math.pow(1 + ((currentPLI - previousPLI) / previousPLI), 1/successList.size());
//            result      = result * (1 + ((currentPLI - previousPLI) / previousPLI));
//            
//            this.updateParameters(arg_ad, i);
//        }
//        
//        result      = Math.pow(result, 1/successList.size());
//        
//        //result  = currentPLI;
//        
//        return result;
//    }
//    
//    /**
//     * 
//     */
//    private void initializeParameters(AbstractDiscovery arg_ad) {
//        this.initializePT(arg_ad, 0);
//        this.initializePG();
//        this.initializePS();
//        this.initializePL0(arg_ad);
//    }
//    
//    /**
//     * 
//     * @param arg_ad
//     * @param arg_step 
//     */
//    private void updateParameters(AbstractDiscovery arg_ad, Integer arg_step) {
//        this.updatePT(arg_ad, arg_step);
////        this.updatePTWithNovelty(arg_ad, arg_step);
//        this.updatePG();
//        this.updatePS();
//        this.updatePL0();
//    }
//    
//    /**
//     * Initializes the P_T parameter for the knowledge tracing model.
//     * Initialization is done by using the user log.
//     * It is computed for each discovery, as the proportion of cells already discovered...
//     * @param arg_ad
//     * @param arg_step 
//     */
//    private void initializePT(AbstractDiscovery arg_ad, Integer arg_step) {
//        
//        Double result   = 0.5;
//        
//        // gather discovered cell lists
//        CellList cl_tmp = new CellList();
//        
//        // for all the steps so far...
//        for(Query q_tmp : this.tr.getTaskBundle().getCurrentUserLog().getQueryList()) {
//            
//            CellList q_cl   = q_tmp.getResult().getCellList();
//                    
//            // get all the cells discovered at each step
//            for(EAB_Cell c_tmp : q_cl.getCellCollection()) {
//                cl_tmp.addCell(c_tmp);
//            }
//            
//        }
//        
//        // we have the cells, we compute the ratio...
//        Integer denum   = arg_ad.getCellList().nbOfCells();
//        Integer num     = 0;
//        
//        for(EAB_Cell c_tmp : cl_tmp.getCellCollection()) {
//            if(arg_ad.getCellList().contains(c_tmp)) {
//                num++;
//            }
//        }
//        
//        // result is the ratio #found cells / # cells
//        result  = num.doubleValue() / denum.doubleValue();
//        
//        this.p_t    = result;
//        
////        return result;
//        
//    }
//    
//    /**
//     * Proportion of the discovery arg_ad retrieved at the step arg_i.
//     * @param arg_ad
//     * @param arg_i
//     * @return 
//     */
//    private Double updatePT(AbstractDiscovery arg_ad, Integer arg_i) {
//        Double result   = 0.5;
//        
//        // gather discovered cell lists
//        CellList cl_tmp = new CellList();
//        
//        // for all the steps so far...
//        for(int i = 0; i <= arg_i; i++) {
//            
////            System.out.println("Complete query list size: " + this.tr.completeQueryList.size());
////            System.out.println("Cells discovered list size: " + this.tr.cellDiscovered.size());
//            
//            Query q_tmp     = this.tr.getWorkSession().getQueryByPosition(i);
//            CellList q_cl   = q_tmp.getResult().getCellList();
//                    
//            // get all the cells discovered at each step
//            for(EAB_Cell c_tmp : q_cl.getCellCollection()) {
//                cl_tmp.addCell(c_tmp);
//            }
//            
//        }
//        
//        // we have the cells, we compute the ratio...
//        Integer denum   = arg_ad.getCellList().nbOfCells();
//        Integer num     = 0;
//        
//        for(EAB_Cell c_tmp : cl_tmp.getCellCollection()) {
//            if(arg_ad.getCellList().contains(c_tmp)) {
//                num++;
//            }
//        }
//        
//        // result is the ratio #found cells / # cells
//        result  = num.doubleValue() / denum.doubleValue();
//        
//        this.p_t    = result;
//        
//        return result;
//    }
//    
//    /**
//     * 
//     */
//    private void updatePTWithNovelty(AbstractDiscovery arg_ad, Integer arg_i) {
//        
//        Double result   = 0.5;
//        
//        // gather discovered cell lists
//        CellList cl_tmp = new CellList();
//        
//        Query previousQuery = this.tr.getWorkSession().getQueryByPosition(0);
//        
//        // entropy for only cells in the neighborhood
//        List<Double> entropyList    = new ArrayList<>();
//        for(int i = 0; i <= arg_i; i++) {
//            Query q_tmp     = this.tr.getWorkSession().getQueryByPosition(i);
//            CellList cl_ad  = q_tmp.getResult().getCellList().intersection(arg_ad.getCellList());
//            Double entropy  = Utils.computeInterest(cl_ad.getCellCollection());
//            entropyList.add(entropy);
//        }
//        
//        // we consider queries until this step...
//        Integer nbQueriesSoFar  = arg_i;
//        Integer nbIncrease      = 0;
//        
//        // for all the steps so far...
//        for(int i = 1; i <= arg_i; i++) {
//            
////            System.out.println("Complete query list size: " + this.tr.completeQueryList.size());
////            System.out.println("Cells discovered list size: " + this.tr.cellDiscovered.size());
//            if(entropyList.get(i) > entropyList.get(i-1)) {
//                nbIncrease++;
//            }
//            
//        }
//        
//        this.p_t    = (double)nbIncrease / (double)nbQueriesSoFar;
//        
//    }
//    
////    /**
////     * 
////     */
////    private void updatePT() {
////        UserModelMarkov umm = (UserModelMarkov)this.tr.getTaskBundle().getCurrentUser().getUserModel();
////        
////        Graph<Query, EAB_Edge_Weight>   = umm.getGraph();
////        
////        umm.getGraph().getVertices()
////        
////    }
//    
//    /**
//     * 
//     */
//    private void initializePG() {
//        this.p_g    = 0.25;
//    }
//    
//    private void updatePG() {
//        
//    }
//    
//    private void initializePS() {
//        this.p_s    = 0.25;
//    }
//    
//    private void updatePS() {
//        
//    }
//    
//    private void initializePL0(AbstractDiscovery arg_ad) {
//        
//        CellList discoveryCells     = arg_ad.getCellList();
//        CellList cellsInDiscovery   = new CellList();
//        
//        for(Session s_tmp : this.tr.getTaskBundle().getCurrentUserSessions()) {
//            
//            for(Query q_tmp : s_tmp.getQueryList()) {
//                QueryTriplet qt_tmp = (QueryTriplet)q_tmp;
//                
//                // parcourir qt_tmp plutot que discoveryCells pour avoir la valeur!
//                for(EAB_Cell c_tmp : qt_tmp.getResult().getCellList().getCellCollection()) {
//                    if(discoveryCells.contains(c_tmp)) {
//                        cellsInDiscovery.addCell(c_tmp);
//                    }
//                }
//            }
//        }
//        
//        // now compute the entropy for the cells
//        this.p_l0   = fr.univ_tours.li.mdjedaini.eab.tools.Utils.computeInterest(cellsInDiscovery.getCellCollection());
//    }
//    
//    private void updatePL0() {
//        
//    }
//    
//    
//    
//}

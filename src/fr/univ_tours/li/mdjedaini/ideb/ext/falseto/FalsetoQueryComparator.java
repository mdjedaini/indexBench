package fr.univ_tours.li.mdjedaini.ideb.ext.falseto;

//package fr.univ_tours.li.mdjedaini.eab.ext.falseto;
//
//
//
//import fr.univ_tours.li.jaligon.falseto.QueryStructure.Qfset;
//import fr.univ_tours.li.jaligon.falseto.Similarity.Query.compareQueries;
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.olap.EAB_Cube;
//import fr.univ_tours.li.mdjedaini.eab.olap.EAB_Level;
//import fr.univ_tours.li.mdjedaini.eab.olap.EAB_Measure;
//import fr.univ_tours.li.mdjedaini.eab.olap.EAB_Member;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.MeasureFragment;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.ProjectionFragment;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.Query;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.QueryTriplet;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.SelectionFragment;
//
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author mahfoud
// */
//public class FalsetoQueryComparator {
//    
//    BenchmarkEngine be;
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public FalsetoQueryComparator(BenchmarkEngine arg_be) {
//        this.be = arg_be;
//    }
//    
//    /**
//     * 
//     * @param arg_q1
//     * @param arg_q2
//     * @return 
//     */
//    public double compare(Query arg_q1, Query arg_q2) {
//        
//        
//        FalsetoQueryConverter fqc   = new FalsetoQueryConverter(this.be);
//        
//        compareQueries cp    = new compareQueries(fqc.); 
//        
//        QueryTriplet arg_qt = (QueryTriplet)arg_q;
//        
//        Qfset result    = new Qfset();
//        
//        for(MeasureFragment mf_tmp : arg_qt.getMeasures()) {
//            result.addMeasure(mf_tmp.getMeasure().getMondrianMeasure());
//        }
//        
//        // ! only add prjections different than All ! \\
//        for(ProjectionFragment pf_tmp : arg_qt.getProjectionFragments()) {
//            //if(!pf_tmp.getLevel().isAllLevel()) {
//                result.addProjection(pf_tmp.getLevel().getMondrianLevel());
//            //}
//        }
//        
//        for(SelectionFragment sf_tmp : arg_qt.getSelectionFragments()) {
//            result.addSelection(sf_tmp.getMemberValue().getMondrianMember());
//        }
//        
//        return result;
//        
//    }
//    
//    /**
//     * Converts a Falseto query to an IDE query.
//     * @param arg_qt
//     * @return 
//     */
//    public QueryTriplet convertQfset(Qfset arg_qt) {
//        String cubeName = arg_qt.toMDX().getCube().getName();
//        EAB_Cube cube   = this.be.getInternalCubeByName(cubeName);
//        
//        QueryTriplet result    = new QueryTriplet(cube);
//       
//        for(fr.univ_tours.li.jaligon.falseto.QueryStructure.MeasureFragment mf_tmp : arg_qt.getMeasures()) {
//            EAB_Measure mm      = cube.getMeasureByMondrianMember(mf_tmp.getAttribute());
//            MeasureFragment m   = new MeasureFragment(result, mm);
//            result.addMeasure(m);
//        }
//        
//        for(fr.univ_tours.li.jaligon.falseto.QueryStructure.ProjectionFragment pf_tmp : arg_qt.getAttributes()) {
//            EAB_Level ll            = new EAB_Level(pf_tmp.getLevel(), cube.getHierarchyByMondrianHierarchy(pf_tmp.getHierarchy()));
//            ProjectionFragment p    = new ProjectionFragment(result, ll);
//            result.addProjection(p);
//        }
//        
//        for(fr.univ_tours.li.jaligon.falseto.QueryStructure.SelectionFragment sf_tmp : arg_qt.getSelectionPredicates()) {
//            EAB_Member mm       = new EAB_Member(sf_tmp.getValue(), cube.getLevelByMondrianLevel(sf_tmp.getLevel()));
//            SelectionFragment s = new SelectionFragment(result, mm);
//            result.addSelection(s);
//        }
//        
//        return result;
//        
//    }
//    
//}

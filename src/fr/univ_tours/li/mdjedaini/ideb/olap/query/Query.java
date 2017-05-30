/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.olap.query;

import fr.univ_tours.li.mdjedaini.ideb.olap.EAB_Cube;
import fr.univ_tours.li.mdjedaini.ideb.olap.result.Result;

/**
 *
 * @author mahfoud
 */
public abstract class Query {
    
    mondrian.olap.Query mondrianQuery;  // mondrian Query object
    
    public EAB_Cube cube;

    Integer qid;        // id of the query
    Integer position;   // position of the query within an exploration
    
    Result result;      // associated result
    
    public Query(EAB_Cube arg_cube) {
        this.cube   = arg_cube;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
    
    
    
    /**
     * 
     * @return 
     */
    public Integer getQid() {
        return qid;
    }

    /**
     * 
     * @param qid 
     */
    public void setQid(Integer qid) {
        this.qid = qid;
    }
    
    /**
     * 
     * @return 
     */
    public EAB_Cube getCube() {
        return this.cube;
    }
    
    /**
     * 
     * @return 
     */
    public mondrian.olap.Query getMondrianQuery() {
        return this.mondrianQuery;
    }
    
//    /**
//     * Executes partially the query.
//     * The query result may be stored in memory, or not...
//     * @param arg_store
//     * @return 
//     */
//    public abstract ResultStructure executePartially(Boolean arg_store);
    
    /**
     * Clears the stored query result
     */
    public void clear() {
        this.result = null;
        System.gc();
    }
    
    /**
     * Executes the query.
     * The query result may be stored in memory, or not...
     * @param arg_store
     * @return 
     */
    public abstract Result execute(Boolean arg_store);
    
    /**
     * Retrieves the result for a given query.
     * If the result is already stored, it is returned. If not, query is 
     * executed and result is returned.
     * @return 
     */
    public Result getResult() {
        if(this.result != null) {
            return this.result;
        } else {
            return this.execute(Boolean.FALSE);
        }
    }
    
    
    
}

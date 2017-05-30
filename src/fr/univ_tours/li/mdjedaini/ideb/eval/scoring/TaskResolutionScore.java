/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.scoring;

import fr.univ_tours.li.mdjedaini.ideb.eval.TaskResolution;

/**
 *
 * @author mahfoud
 */
public class TaskResolutionScore extends ExplorationScore {
    
    //
    public TaskResolution taskResolution;
    
    /**
     * 
     * @param arg_tr
     * @param arg_taskScorer 
     */
    public TaskResolutionScore(TaskResolution arg_tr, I_ExplorationScorer arg_taskScorer) {
        super(arg_tr, arg_taskScorer);
    }
    
    /**
     * Builds a TaskResolutionScore from an ExplorationScore.
     * Basically, it gathers information from the exploration score and also 
     * from the task.
     * @param arg_es
     * @param arg_tr 
     */
    public TaskResolutionScore(ExplorationScore arg_es, TaskResolution arg_tr) {
        super(arg_es);
        this.taskResolution = arg_tr;
    }

    /**
     * 
     * @return 
     */
    public TaskResolution getTaskResolution() {
        return taskResolution;
    }
    
}

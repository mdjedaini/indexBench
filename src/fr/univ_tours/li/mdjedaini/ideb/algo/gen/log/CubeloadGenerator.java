/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.gen.log;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.io.XMLLogLoader;
import fr.univ_tours.li.mdjedaini.ideb.struct.Log;
import it.unibo.csr.big.cubeload.generator.OlapGenerator;
import it.unibo.csr.big.cubeload.generator.Profile;
import it.unibo.csr.big.cubeload.io.XMLReader;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mahfoud
 */
public class CubeloadGenerator implements I_LogGenerator {
    
    BenchmarkEngine be;
            
    /**
     *
     */
    public String schemaFilePath;

    /**
     *
     */
    public String profileFilePath;

    /**
     *
     */
    public String dataDirectoryPath;
    
    /**
     *
     */
    public String cubeName;
    
    // todo try to add profile parameters here instead of having them in a file...

    /**
     *
     */
    public Integer numberOfProfiles; // Number of profiles to be generated.

    /**
     *
     */
    public Integer maxMeasures; // Maximum number of measures in a query

    /**
     *
     */
    public Integer minReportSize; // Minimum size of the report for starting queries.

    /**
     *
     */
    public Integer maxReportSize; // Maximum size of the report for starting queries.

    /**
     *
     */
    public Integer numberOfSurprisingQueries; // Number of surprising queries.

    /**
     * 
     * @param arg_be 
     */
    public CubeloadGenerator(BenchmarkEngine arg_be) {
        this.be                 = arg_be;
        
        this.schemaFilePath     = "/home/mahfoud/projects/ea-benchmark/schema.xml";
        this.profileFilePath    = "/home/mahfoud/Documents/phd/mdrepo/md_export/ssb_for_cubeload/profile.xml";
        this.dataDirectoryPath  = "/home/mahfoud/Documents/phd/mdrepo/md_export/ssb_for_cubeload";
        
        this.numberOfProfiles           = 1;
        this.maxMeasures                = 2;
        this.minReportSize              = 5;
        this.maxReportSize              = 7;
        this.numberOfSurprisingQueries  = 1;
        
        this.cubeName           = "SSB";
        
    }

    /**
     * 
     * @return 
     */
    @Override
    public Log generateLog() {
        Log log             = new Log() ;
        File profileFile    = new File(this.profileFilePath);
        
        List<Profile> listOfProfiles    = new ArrayList<>();
        
        try {
            
            listOfProfiles.add(new XMLReader().getProfile(profileFile.getCanonicalPath()));
            OlapGenerator olapGen   = new OlapGenerator(
                    this.numberOfProfiles,
                    this.maxMeasures,
                    this.minReportSize,
                    this.maxReportSize,
                    this.numberOfSurprisingQueries,
                    this.cubeName, this.schemaFilePath, this.dataDirectoryPath, listOfProfiles);
            
            long unixTimestamp  = Instant.now().getEpochSecond();
            String outputFile   = "Workload-" + unixTimestamp + ".xml";
            
            olapGen.generateWorkload(outputFile);
            System.out.println("Fin de la creation du workload...");
            
            XMLLogLoader xml_reader = new XMLLogLoader(this.be, outputFile);
            return xml_reader.loadLog();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return log;
    }
    
}

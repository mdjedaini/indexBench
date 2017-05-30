/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.struct;

/**
 * @todo enlever le user log, ça ne sert à rien je crois...
 * @author mahfoud
 */
public class UserLog extends Log {
    
    /**
     * User ID
     */
    Integer uid;
    
    /**
     * 
     * @param arg_log
     * @param arg_uid 
     */
    public UserLog(Log arg_log, Integer arg_uid) {
        super();
        this.uid    = arg_uid;
        this.extract(arg_log);
    }
    
    /**
     * 
     * @param arg_log 
     */
    public void extract(Log arg_log) {
        for(Session s_tmp : arg_log.getSessionList()) {
            if(s_tmp.getUser().getUid().equals(this.uid)) {
                this.addSession(s_tmp);
            }
        }
    }
    
}

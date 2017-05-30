/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood.member;

import fr.univ_tours.li.mdjedaini.ideb.olap.EAB_Member;

/**
 *
 * @author mahfoud
 */
public interface I_SliceMemberNeighborhood {
    
    /**
     * Plusieurs types de voisinages de membres seront implémentés.
     * Switch neighborhood: possible si deux membres sont au même niveau dans la hiérarchie,
     * ou alors plus restrictif si ils ont un parent en commun (plus ou moins haut dans la hiérarchie),
     * ou alors encore plus restrictif si leur parent direct est le même
     * Drill neighborhood: possible si les deux membres sont dans la même hiérarchie, et l'un est un parent plus ou moins éloigné,
     * ou alors plus restrictif si les deux membres sont liés par un lien de parenté directe.
     * 
     * @param arg_m1
     * @param arg_m2
     * @return 
     */
    public boolean areNeigbours(EAB_Member arg_m1, EAB_Member arg_m2);
    
}

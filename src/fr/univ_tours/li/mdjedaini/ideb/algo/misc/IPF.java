package fr.univ_tours.li.mdjedaini.ideb.algo.misc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salim IGUE
 */
public class IPF {

    /**
     *
     */
    public static List<String> attCommunes = new ArrayList<>();

    /**
     *
     */
    public static List<Double> valCommunes = new ArrayList<>();

    /**
     *
     */
    public static List<String> attCspAct = new ArrayList<>();

    /**
     *
     */
    public static List<Double> valCspAct = new ArrayList<>();

    /**
     *
     */
    public static List<String> attDiplome = new ArrayList<>();

    /**
     *
     */
    public static List<Double> valDiplome = new ArrayList<>();

    /**
     *
     */
    public static List<String> attTaille = new ArrayList<>();

    /**
     *
     */
    public static List<Double> valTaille = new ArrayList<>();

    /**
     *
     */
    public static List<String> attTypeAge = new ArrayList<>();

    /**
     *
     */
    public static List<Double> valTypeAge = new ArrayList<>();

	// Pour récupérer données

    /**
     *
     * @param l
     */
	public static void attCommunes(String l) {
		attCommunes.add(l);
	}

    /**
     *
     * @param l
     */
    public static void valCommunes(Double l) {
		valCommunes.add(l);
	}

    /**
     *
     * @param l
     */
    public static void attCspAct(String l) {
		attCspAct.add(l);
	}

    /**
     *
     * @param l
     */
    public static void valCspAct(Double l) {
		valCspAct.add(l);
	}

    /**
     *
     * @param l
     */
    public static void attDiplome(String l) {
		attDiplome.add(l);
	}

    /**
     *
     * @param l
     */
    public static void valDiplome(Double l) {
		valDiplome.add(l);
	}

    /**
     *
     * @param l
     */
    public static void attTaille(String l) {
		attTaille.add(l);
	}

    /**
     *
     * @param l
     */
    public static void valTaille(Double l) {
		valTaille.add(l);
	}

    /**
     *
     * @param l
     */
    public static void attTypeAge(String l) {
		attTypeAge.add(l);
	}

    /**
     *
     * @param l
     */
    public static void valTypeAge(Double l) {
		valTypeAge.add(l);
	}

	// IPF

    /**
     *
     */
	public static List<Double[]> totInit = new ArrayList<Double[]>(); // les totaux initiaux

    /**
     *
     */
    public static List<Double[]> totTemp; // les totaux temporaires

    /**
     *
     */
    public static List<Integer> nbAttParDim; // nb d attributs par dimension

    /**
     *
     */
    public static Double[] results; // tableau de valeurs résultat

    /**
     *
     */
    public static List<String[]> listAtt = new ArrayList<String[]>();

	// on initialise toutes les valeurs de results à 1

    /**
     *
     */
	public static void initializationNdim() {
		Integer taille = 1;
		for (Integer i : nbAttParDim)
			taille *= i;
		results = new Double[taille];
		for (int j = 0; j < results.length; j++)
			results[j] = Double.valueOf(1);
	}

	// on initialise les totaux temporaires

    /**
     *
     */
	public static void initializationTotTemp() {
		totTemp = new ArrayList<>();
		for (int i = 0; i < totInit.size(); i++) {
			Double[] d = new Double[totInit.get(i).length];
			totTemp.add(d);
		}
	}

	// on initialise nbAttParDim

    /**
     *
     */
	public static void initializationNbAtt() {
		nbAttParDim = new ArrayList<>();
		for (int i = totInit.size() - 1; i >= 0; i--)
			nbAttParDim.add(Integer.valueOf(totInit.get(i).length));
		System.out.println("totInit.size()" + totInit.size());
		for (int i = 0; i < totInit.size(); i++)
			System.out.println("nb " + nbAttParDim.get(i));
	}

	// maj des totaux temporaires (pour chaque dimension)

    /**
     *
     */
	public static void majTotTemp() {
		// on initialise le compteur d'indices : "00000"
		int[] indice = new int[nbAttParDim.size()];
		for (int i = 0; i < nbAttParDim.size(); i++) {
			indice[i] = 0;
		}

		// on remet à 0 les totaux temporaires
		for (Double[] d : totTemp)
			for (int i = 0; i < d.length; i++)
				d[i] = 0.0;

		// on parcourt le tableau de résultat
		for (int i = 0; i < results.length; i++) {

			// on met à jour l'indice : "0000" --> "0001"
			if (i != 0)
				indice[indice.length - 1]++;
			for (int j = nbAttParDim.size() - 1; j >= 0; j--) {
				if (indice[j] == nbAttParDim.get(j)) {
					indice[j] = 0;
					indice[j - 1]++;
				}
			}

			// on ajoute la valeur aux totaux temp correspondants

			for (int j = 0; j < indice.length; j++) {
				try {
					totTemp.get(j)[indice[indice.length - 1 - j]] += results[i];
				} catch (NullPointerException e) {
				}

			}

		}
		/*
		 * for (int j = 0; j < totTemp.size(); j++) {
		 * System.out.println("totTemp[" + j + "]"); for (int i = 0; i <
		 * totTemp.get(j).length; i++) System.out.println(totTemp.get(j)[i]);
		 * System.out.println(); }
		 */
	}

	// distribution selon une dimension

    /**
     *
     * @param numDim
     */
	public static void distribution(int numDim) {
		System.out.println("distribution selon " + numDim);
		// on initialise le compteur d'indices : "00000"
		int[] indice = new int[nbAttParDim.size()];
		for (int i = 0; i < nbAttParDim.size(); i++) {
			indice[i] = 0;
		}

		// on parcourt le tableau de résultat
		for (int i = 0; i < results.length; i++) {

			// on met à jour l'indice : "0000" --> "0001"
			if (i != 0)
				indice[indice.length - 1]++;
			for (int j = nbAttParDim.size() - 1; j >= 0; j--) {
				if (indice[j] == nbAttParDim.get(j)) {
					indice[j] = 0;
					indice[j - 1]++;
				}
			}

			// on met à jour la valeur
			/*
			 * System.out.println("numDim " + numDim); System.out.println("i " +
			 * i); System.out.println(totInit.get(numDim)[indice[indice.length -
			 * 1 - numDim]]);
			 * System.out.println(totTemp.get(numDim)[indice[indice.length - 1 -
			 * numDim]]);
			 */
			if (totInit.get(numDim)[indice[indice.length - 1 - numDim]] != null
					&& results[i] != null)
				results[i] *= totInit.get(numDim)[indice[indice.length - 1
						- numDim]]
						/ totTemp.get(numDim)[indice[indice.length - 1 - numDim]];
			else
				results[i] = null;
		}
	}

	// on lance l'algo une fois que totInit est initialisé

    /**
     *
     */
	public static void IPF() {
		initializationTotTemp();
		initializationNbAtt();
		initializationNdim();
		/*
		 * System.out.println("TAILLE RESULTS : "+results.length);
		 * System.out.println("------RESULTS : "); for (int j = 0; j <
		 * results.length; j++) System.out.println(results[j]);
		 * System.out.println("-------");
		 */
		for (int i = 0; i < totInit.size(); i++) {
			majTotTemp();
			distribution(i);
			/*
			 * System.out.println("------RESULTS : "); for (int j = 0; j <
			 * results.length; j++) System.out.println(results[j]);
			 * System.out.println("-------");
			 */

		}
	}

	// liste des attributs dans l'ordre dans lequel les attributs sont
	// insérés
	// dans listAtt

    /**
     *
     * @param attributsList
     * @return
     */
	public static Double findData(List<String> attributsList) {
		if (attributsList.size() == nbAttParDim.size()) {
			List<Integer> listIndex = new ArrayList<>();
			Integer index = 0;
			int attFound = 0;
			String attToFound = attributsList.get(attFound);
			for (int j = 0; j < listAtt.size(); j++) {
				index = 0;
				String[] attributs = listAtt.get(j);
				for (int i = 0; i < attributs.length; i++) {
					if (!attributs[i].equals(attToFound))
						index++;
					else {
						listIndex.add(index);
						attFound++;
						if (attFound != attributsList.size())
							attToFound = attributsList.get(attFound);
						break;
					}
				}
			}
			int indice = 0;
			for (int i = 0; i < listIndex.size(); i++) {
				if (i == 0)
					indice += listIndex.get(i);
				else {
					int temp = 1;
					for (int i2 = i - 1; i2 >= 0; i2--)
						temp *= listAtt.get(i2).length;

					indice += (listIndex.get(i) * temp);
				}

			}
			return results[indice];
		} else
			return null;
	}

    /**
     *
     */
    public static void calculIPF() {
		String[] tabS = new String[attDiplome.size()];
		for (int i = 0; i < attDiplome.size(); i++) {
			tabS[i] = attDiplome.get(i);
		}
		listAtt.add(tabS);
		System.out.println("tabS diplome : " + tabS.length);

		tabS = new String[attTypeAge.size()];
		for (int i = 0; i < attTypeAge.size(); i++) {
			tabS[i] = attTypeAge.get(i);
		}
		listAtt.add(tabS);

		tabS = new String[attTaille.size()];
		for (int i = 0; i < attTaille.size(); i++) {
			tabS[i] = attTaille.get(i);
		}
		listAtt.add(tabS);

		tabS = new String[attCspAct.size()];
		for (int i = 0; i < attCspAct.size(); i++) {
			tabS[i] = attCspAct.get(i);
		}
		listAtt.add(tabS);

		tabS = new String[attCommunes.size()];
		for (int i = 0; i < attCommunes.size(); i++) {
			tabS[i] = attCommunes.get(i);
		}
		listAtt.add(tabS);

		Double[] tabV = new Double[valDiplome.size()];
		for (int i = 0; i < valDiplome.size(); i++) {
			tabV[i] = valDiplome.get(i);
		}
		totInit.add(tabV);

		tabV = new Double[valTypeAge.size()];
		for (int i = 0; i < valTypeAge.size(); i++) {
			tabV[i] = valTypeAge.get(i);
		}
		totInit.add(tabV);

		tabV = new Double[valTaille.size()];
		for (int i = 0; i < valTaille.size(); i++) {
			tabV[i] = valTaille.get(i);
		}
		totInit.add(tabV);

		tabV = new Double[valCspAct.size()];
		for (int i = 0; i < valCspAct.size(); i++) {
			tabV[i] = valCspAct.get(i);
		}
		totInit.add(tabV);

		tabV = new Double[valCommunes.size()];
		for (int i = 0; i < valCommunes.size(); i++) {
			tabV[i] = valCommunes.get(i);
		}
		totInit.add(tabV);

		IPF();
		System.out.println("TAILLE RESULTS : " + results.length);

	}

    /**
     *
     * @param diplome
     * @param typeAge
     * @param taille
     * @param cspAct
     * @param commune
     * @return
     */
    public static Double getData(String diplome, String typeAge, String taille,
			String cspAct, String commune) {

		if (diplome == null || typeAge == null || taille == null
				|| cspAct == null || commune == null)
			System.out.println(diplome + " " + typeAge + " " + taille + " "
					+ cspAct + " " + commune);
		List<String> l = new ArrayList<>();
		l.add(diplome);
		l.add(typeAge);
		l.add(taille);
		l.add(cspAct);
		l.add(commune);
		Double d = findData(l);

		return d;
	}

    /**
     *
     * @return
     */
    public static boolean conditionsRun() {
		if (fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.attCommunes.size() == 291
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.valCommunes.size() == 291
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.attTypeAge.size() == 30
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.valTypeAge.size() == 30
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.attTaille.size() == 6
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.valTaille.size() == 6
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.attCspAct.size() == 14
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.valCspAct.size() == 14
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.attDiplome.size() == 6
				&& fr.univ_tours.li.mdjedaini.ideb.algo.misc.IPF.valDiplome.size() == 6)
			return true;
		return false;
	}
}

package fr.isika.cdi8.projet3isika.utils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;

@Component
public class PrestationsFilter {

	private boolean isInList(Date dateSouhaitee, List<Date> listeDates) {
		return listeDates.contains(dateSouhaitee);
	}

	public List<Prestation> getFournisseursDisponibles(Date dateSouhaitee,
			List<Prestation> prestations) {
		if(dateSouhaitee == null || prestations.isEmpty()) {
			return Collections.emptyList();
		}
		return prestations.parallelStream()
				.filter(prestaFournisseur -> 
					isInList(dateSouhaitee, prestaFournisseur.getDateDisponibilite())).collect(Collectors.toList());
	}

	

}

package fr.isika.cdi8.projet3isika.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.utils.PrestationsFilter;

public class DatesDispoTest {

	PrestationsFilter disponibilitesfilter = new PrestationsFilter();

	@Test
	public void testPrestationFournisseurAvecDateDisponible() throws Exception {
		Prestation premierePresta = creerPresta(15L,
				Arrays.asList(convertToDateViaInstant(LocalDate.of(2021, 5, 25))));
		Prestation secondFournisseur = creerPresta(25L,
				Arrays.asList(convertToDateViaInstant(LocalDate.of(2021, 5, 26))));

		List<Prestation> prestations = new ArrayList<Prestation>();
		prestations.add(premierePresta);
		prestations.add(secondFournisseur);

		// Qu'une date existe dans une liste de dates
		Date dateSouhaitee = convertToDateViaInstant(LocalDate.of(2021, 5, 25));
		assertEquals(1, disponibilitesfilter.getFournisseursDisponibles(dateSouhaitee, prestations).size());
		assertEquals(premierePresta,
				disponibilitesfilter.getFournisseursDisponibles(dateSouhaitee, prestations).get(0));
	}

	@Test
	public void testPrestationFournisseurSansAucuneDateDisponible() throws Exception {

		Prestation premierePresta = creerPrestaSansDatesDisponibilite(15l);
		Prestation secondFournisseur = creerPrestaSansDatesDisponibilite(25l);
		List<Prestation> prestations = new ArrayList<Prestation>();
		prestations.add(premierePresta);
		prestations.add(secondFournisseur);

		// Qu'une date existe dans une liste de dates
		Date dateSouhaitee = convertToDateViaInstant(LocalDate.of(2021, 5, 30));
		assertTrue(disponibilitesfilter.getFournisseursDisponibles(dateSouhaitee, prestations).isEmpty());
	}

	private Prestation creerPresta(long l, List<Date> asList) {
		Prestation presta = creerPrestaSansDatesDisponibilite(l);
		presta.setDateDisponibilite(asList);
		return presta;
	}

	private Prestation creerPrestaSansDatesDisponibilite(long l) {
		Prestation premierePresta = new Prestation();
		premierePresta.setReferncePrestation(l);
		return premierePresta;
	}

	private Date convertToDateViaInstant(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}

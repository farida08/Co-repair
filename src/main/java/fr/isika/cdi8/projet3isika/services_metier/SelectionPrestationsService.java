//package fr.isika.cdi8.projet3isika.services_metier;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.PrestationFournisseur;
//
//import fr.isika.cdi8.projet3isika.utils.PrestationsFilter;
//
//@Service
//public class SelectionPrestationsService {
//
//	@Autowired
//	private PrestationsFilter prestationsFilter;
//
//	@Autowired
//	private PrestationLocationOutillageIDao prestationLocationOutillageIDao;
//
//	@Autowired
//	private PrestationLocationGarageIDao prestationLocationGarageIDao;
//
//	@Autowired
//	private PrestationReparationSansGarageIDao prestationReparationSansGarageIDao;
//	@Autowired
//	private LocationGarageIDao locationGarageIDao;
//
//	@Autowired
//	private PrestationReparationAvecGarageIDao prestationReparationAvecGarageIDao;
//
//	@Autowired
//	private LocationOutillageIDao locationOutillageIDao;
//	
//	@Autowired
//	private DemandeReparationIDao reparationIDao ;
//	@Autowired
//	private DemandeReparationAvecGarageIDao reparationAvecGarageIDao ;
//
//	public List<PrestationFournisseur> selectionnerLocationOutillage(LocationOutillage locationOutillage) {
//		List<PrestationLocationOutillage> prestas = prestationLocationOutillageIDao
//				.selectionnerLocationOutillage(locationOutillage);
//		return selectionnerPrestations(prestas, locationOutillageIDao.getDateSouhaitee(locationOutillage));
//	}
//
//	public List<PrestationFournisseur> selectionnerLocationGarage(LocationGarage locationGarage) {
//		List<PrestationLocationGarage> prestas = prestationLocationGarageIDao
//				.selectionnerLocationGarage(locationGarage);
//		return selectionnerPrestations(prestas, locationGarageIDao.getDateSouhaitee(locationGarage));
//
//	}
//
//	public List<PrestationFournisseur> selectionnerReparationSansGarage(Reparation reparation) {
//		List<PrestationReparationSansGarage> prestas = prestationReparationSansGarageIDao
//				.selectionnerReparationSansGarage(reparation);
//		
//		return selectionnerPrestations(prestas, reparationIDao.getDateSouhaitee(reparation));
//	}
//
//	public List<PrestationFournisseur> selectionnerLocationReparationSansGarage(
//			ReparationAvecGarage reparationAvecGarage) {
//		List<PrestationReparationAvecGarage> prestas = prestationReparationAvecGarageIDao
//				.selectionnerReparationAvecGarage(reparationAvecGarage);
//		return selectionnerPrestations(prestas, reparationAvecGarageIDao.getDateSouhaitee(reparationAvecGarage));
//	}
//
//	private <P extends PrestationFournisseur> List<PrestationFournisseur> selectionnerPrestations(List<P> prestations,
//			Date date) {
//		return prestationsFilter.getFournisseursDisponibles(date, (List<PrestationFournisseur>) prestations);
//	}
//
//}

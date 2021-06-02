package fr.isika.cdi8.projet3isika.entities.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;
import fr.isika.cdi8.projet3isika.dao.ClientDao;
import fr.isika.cdi8.projet3isika.dao.FournisseurDao;
import fr.isika.cdi8.projet3isika.entities.common.Adresse;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.SousType;
import fr.isika.cdi8.projet3isika.entities.common_client_fournisseur.Transaction;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Client;
import fr.isika.cdi8.projet3isika.entities.demandes_client.Demande;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Fournisseur;
import fr.isika.cdi8.projet3isika.entities.prestations_fournisseur.Prestation;
import fr.isika.cdi8.projet3isika.idao.ClientIDao;
import fr.isika.cdi8.projet3isika.idao.DemandeIDao;
import fr.isika.cdi8.projet3isika.idao.FournisseurIDao;
import fr.isika.cdi8.projet3isika.idao.PrestationFournisseurIDao;

@Component
@Profile ("initData")
public class InitDataSet {
	@Autowired
	ClientIDao clientIDao ;
	@Autowired
	FournisseurIDao fournisseurIDao;
	@Autowired
	DemandeIDao demandeIDao;
	@Autowired
	PrestationFournisseurIDao prestationFournisseurIDao;
//	@Autowired
//	Adresse adresse;
	
@PostConstruct
public void initJeuxdeDonnees() throws ParseException {
	/////clients--------------------------------------------------------
	Adresse adresse1 = new Adresse(1, "12", "rue alain made","paris","75010", "IDF", "France");
	Client client1 = clientIDao.save(new Client((long) 1,"michel","sardo","1234","michel@gmail.com","0129323245","photo1",adresse1,"Michou"));
	Demande demande1=new Demande((long) 23,new Date("04/06/2021"),new Date("12/06/2021"),client1);
	SousType sousType1=new SousType((long)43,"mecanique");
	Transaction transaction1=new Transaction((long) 1,demande1,"reparation",sousType1);
	

	
	Adresse adresse2 = new Adresse(2, "15", "boulevard gerard michel","paris","75012", "IDF", "France");
	Client client2 = clientIDao.save(new Client((long) 2,"eric","daniel","1234","ericdaniel@gmail.com","0129323235","photo2",adresse2,"eRIC12"));
	Demande demande2=new Demande((long) 33,new Date("04/06/2021"),new Date("13/06/2021"),client2);
	SousType sousType2=new SousType((long)44,"Pompe");
	Transaction transaction2=new Transaction((long) 2,demande2,"locationOutillage",sousType2);
	
	///Fournisseur---------------------------------------------------------
	Adresse adresse7=new Adresse(2,"45", "rue colonel fabien","creteil","94000", "IDF", "france");
	Fournisseur fournisseur1= fournisseurIDao.save(new Fournisseur((long) 10,"jhon","doli","1234","reparemeca@gmail.com","0165476543","photo7",adresse7,"12345987654321","Repare Meca"));
	SousType sousType6=new SousType((long)44,"mecanique");
	List<Date> maDispo= new ArrayList<Date>();
	maDispo.add(new Date("13/06/2021"));
	maDispo.add(new Date("15/06/2021"));
	Prestation prestation1= new Prestation((long)13, maDispo,(double) 123,fournisseur1,"reparation",sousType6);
	
	
	
	
//	Adresse adresse3 = new Adresse(3, "18", " Avenue Colonel Fabien","paris","75010", "IDF", "France");
//	Client client3 = clientIDao.save(new Client((long) 3,"Stephane","George","1234","stephane@gmail.com","0129323250","photo3",adresse3,"stephan10"));
//	Demande demande1=new Demande((long) 23,new Date("04/06/2021"),new Date("12/06/2021"),client1);
//	SousType sousType1=new SousType((long)43,"mecanique");
//	Transaction transaction1=new Transaction((long) 1,demande1,"reparation",sousType1);
//	
//	Adresse adresse4 = new Adresse(4, "21", "avenue Galieni","paris","75012", "IDF", "France");
//	Client client4 = clientIDao.save(new Client((long) 4,"gill","cho","1234","gill@gmail.com","0129329867","photo4",adresse4,"Gilou"));
//	
//	Adresse adresse5 = new Adresse(5, "21", "boulevard Galieni","paris","75020", "IDF", "France");
//	Client client5 = clientIDao.save(new Client( (long) 5,"all","dall","1234","ali@gmail.com","0129329834","photo5",adresse5,"LILI"));
//	
//	Adresse adresse6 = new Adresse(4, "21", "Rue Galieni","paris","75016", "IDF", "France");
//	Client client6 =clientIDao.save(new Client((long) 6,"PATRICK","DARO","1234","daro@gmail.com","0129329899","photo6",adresse6,"Daro"));
//	
//	
//	Adresse adresse7=new Adresse(2,"45", "rue colonel fabien","creteil","94000", "IDF", "france");
//	Fournisseur fournisseur1= fournisseurIDao.save(new Fournisseur((long) 10,"jhon","doli","1234","reparemeca@gmail.com","0165476543","photo7",adresse7,"12345987654321","Repare Meca"));
//	
//	Adresse adresse8=new Adresse(2,"32", "Boulevard General De Gaulle","colombe","92000", "IDF", "france");
//	Fournisseur fournisseur2= fournisseurIDao.save(new Fournisseur((long) 11,"Patrice","Michel","1234","autoMeca@gmail.com","0190823143","photo8",adresse7,"12343337654321","autoMeca"));
//	
//	Adresse adresse9=new Adresse(2,"124", "rue de la paix","Saint Denis","93000", "IDF", "france");
//	Fournisseur fournisseur3= fournisseurIDao.save(new Fournisseur((long) 12,"Jean","Marc","1234","DepaneCaross@gmail.com","0190879993","photo9",adresse7,"12345987888321","DepaneCaross"));
//	
//	Adresse adresse10=new Adresse(2,"119", "Avenue louis","nanterre","92000", "IDF", "france");
//	Fournisseur fournisseur4= fournisseurIDao.save(new Fournisseur((long) 13,"Stephane","trelle","1234","voitureBobo@gmail.com","0190345543","photo10",adresse7,"12342227654321","voitureBobo"));
//	
//	Adresse adresse11=new Adresse(2,"220", "Rue cesson","melun","77000", "IDF", "france");
//	Fournisseur fournisseur5= fournisseurIDao.save(new Fournisseur((long) 14,"bernard","Joli","1234","AutoPlus@gmail.com","0190875543","photo11",adresse8,"12345987611321","AutoPlus"));
}

}
	
	



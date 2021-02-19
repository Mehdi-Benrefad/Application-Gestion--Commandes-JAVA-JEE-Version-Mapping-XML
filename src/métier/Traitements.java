package métier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Traitements {
	
	
	
	
	public static void main(String args[]) {
		
		//ajout clients
		/*
		addClient("Benrefad", "Google");
		addClient("Benrefad", "Microsoft");
		addClient("Benrefad", "IBM");
		addClient("Benrefad", "HP");
		addClient("Benrefad", "HUAWEI");
		addClient("Benrefad", "SAMSUNG");
		*/
		//ajouter Admin
		//addAdmin("admin2","admin");
		chargerAdmins();
		//ajout produit
		/*
		addProduit("Ordinateur", 1000.0, true, 500);
		addProduit("Tablette", 1000.0, true, 500);
		addProduit("Telephone", 1000.0, true, 500);
		addProduit("Serveur", 1000.0, true, 500);
		addProduit("Domaine", 1000.0, true, 500);
		addProduit("Disque Dur", 1000.0, true, 500);
		*/
		
		//ajout commande
		/*
		addCommande(new Date(), Long.valueOf(1));
		addCommande(new Date(), Long.valueOf(2));
		addCommande(new Date(), Long.valueOf(2));
		addCommande(new Date(), Long.valueOf(3));
		addCommande(new Date(), Long.valueOf(4));
		*/
		
		
		//ajouter produit a la commande
		/*
		addProduitToCommande(Long.valueOf(1), Long.valueOf(1), 100);
		addProduitToCommande(Long.valueOf(1), Long.valueOf(3), 100);
		addProduitToCommande(Long.valueOf(1), Long.valueOf(2), 100);
		*/
		
		
		
		System.out.println("==============================test[COMMANDE numero 1]========================================================================================================================");

		System.out.println("Date de Commande:");
		
		System.out.println(Traitements.DateCommande(Long.valueOf(1)));
		System.out.println("====================================================================================================================================================================================");

		System.out.println("Client:");

		System.out.println(Traitements.ClientInCammande(Long.valueOf(1)));
		
		System.out.println("====================================================================================================================================================================================");

		System.out.println("Produits que le Client a commande:");

		List<Produit> produits=(List<Produit>) Traitements.listeProduits(Long.valueOf(1));
		for(int i=0;i<produits.size();i++) {
			
			System.out.println(produits.get(i).toString()+"\n");
			
		}
		
		System.out.println("==========================================================================================");

		
	

	}
	
	
	
	/*
	 @ METHODES DE LA CLASSE@
	 */
	
	public static void addAdmin(String login,String password){
		
		
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Admin adm=new Admin();
		adm.setLogin(login);
		adm.setPassword(password);
		session.save(adm);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	
	
	}
	
		public static void addClient(String nom,String societe){
		
		
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Client cli=new Client();
			cli.setNomClient(nom);
			cli.setSociete(societe);
			session.save(cli);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
		
		
		}
		
		
		public static void addProduit(String des, double prix,boolean dispo, int quantite){
			
			
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Produit p=new Produit();
			p.setDesignation(des);
			p.setQuantite(quantite);
			p.setDisponible(dispo);
			p.setPrix(prix);
			session.save(p);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
			
			
		}
		
		
		public static void addCommande(Date date,Long idClient){
			
			
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Client client=(Client)session.load(Client.class,idClient);
			Commande comm=new Commande();
			comm.setDateCommande(date);
			client.addCommande(comm);
			comm.setClient(client);
			session.save(comm);
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
			
			
		}
		
		
		public static void addProduitToCommande(Long idCommande,Long idProduit,int quantite){
			
			
				Session session=HibernateUtil.getSessionFactory().getCurrentSession();
				session.beginTransaction();
				Commande
				comm=(Commande)session.load(Commande.class,idCommande);
				Produit prod=(Produit)session.load(Produit.class,idProduit);
				Composante compo=new Composante();
				compo.setQuantite(quantite);
				compo.setProduit(prod);
				comm.getLesComposantes().add(compo);
				session.getTransaction().commit();
				HibernateUtil.getSessionFactory().close();
				
		}
		
		
		
		public static Commande chargerCommande(Long idCommande){
			Commande comm=null;
			
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			comm=(Commande)session.load(Commande.class,idCommande);
			
			return comm;
			
		}

		
		
		
		public static List<Admin> chargerAdmins(){
			
			
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			//List<Admin> admins=session.createQuery("from Admin",Admin.class);
			//Query r=entity.createQuery("SELECT u FROM u");
			Criteria crit = session.createCriteria(Admin.class);
			crit.setMaxResults(50);
			List<Admin> admins = crit.list();
			
			
			return admins;
			
		}
		
		public static boolean testerAdmin(String login,String pass){
			
			
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			//List<Admin> admins=session.createQuery("from Admin",Admin.class);
			//Query r=entity.createQuery("SELECT u FROM u");
			Criteria crit = session.createCriteria(Admin.class);
			crit.setMaxResults(50);
			List<Admin> admins = crit.list();
			
			for(Admin adm: admins) {
				if(adm.getLogin().equals(login)) {
					return true;
				}
			}
			
			return false;
			
		}
		


		
		public static Client chargerClient(Long idCommande){
			
			
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Client comm=(Client)session.load(Client.class,idCommande);
			return comm;
			
			
		}
		
		
		public static Client ClientInCammande(Long Id_Cammande){
			 Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 Commande commamande = 	(Commande) session.load(Commande.class, Id_Cammande);
			 return commamande.getClient();
		 }
		
		
		
		
		public static Date DateCommande(Long Id) {
			Session session =HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Commande commande = (Commande)session.load(Commande.class, Id);
			
			return commande.getDateCommande();
		
		}
		
		
		public static List<Produit> listeProduits(Long Id) {
			
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Commande commande =(Commande)session.load(Commande.class, Id);
			List<Composante> ls = commande.getLesComposantes();
			List<Produit> arr = new ArrayList<Produit>();
			for (int i = 0; i < ls.size(); i++) {
				arr.add(ls.get(i).getProduit());
			}
		
		
			
			return  arr;
			
		}
		
		public static List<Produit> listeDesProduits() {
			
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Criteria crit = session.createCriteria(Produit.class);
			crit.setMaxResults(50);
			List<Produit> products = (List<Produit>)crit.list();
			
		//	Commande commande =(Commande)session.load(Commande.class);
		//	List<Composante> ls = commande.getLesComposantes();
			ArrayList<Produit> arr = new ArrayList<Produit>();
			for (int i = 0; i < products.size(); i++) {
				arr.add(products.get(i));
			}
		
			return  arr;
			
		}
		

	
}

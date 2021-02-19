package m�tier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
	
	private Long idCommande;
	private Date dateCommande;
	private Client client;
	private List<Composante> lesComposantes = new ArrayList<>();
	
	public Commande() {
		
	}

	public Commande( Date dateCommande, Client client, List<Composante> lesComposantes) {
		super();
		this.dateCommande = dateCommande;
		this.client = client;
		this.lesComposantes = lesComposantes;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Composante> getLesComposantes() {
		return lesComposantes;
	}

	public void setLesComposantes(List<Composante> lesComposantes) {
		this.lesComposantes = lesComposantes;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", client=" + client
				+ "]\n";
	}
	
	
	
	

}

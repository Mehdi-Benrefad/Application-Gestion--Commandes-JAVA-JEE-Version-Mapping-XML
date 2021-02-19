package métier;

public class Composante {
	
	private Long idComposante;
	private int quantite;
	private Produit produit;
	
	public Composante() {
		
	}
	
	public Composante(Long idComposante, int quantite, Produit produit) {
		super();
		this.idComposante = idComposante;
		this.quantite = quantite;
		this.produit = produit;
	}

	public Long getIdComposante() {
		return idComposante;
	}

	public void setIdComposante(Long idComposante) {
		this.idComposante = idComposante;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
	

}

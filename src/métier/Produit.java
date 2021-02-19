package métier;

public class Produit {
	
	private Long idProduit;
	private String designation;
	private double prix;
	private boolean disponible;
	private int quantite ;
	
	public Produit() {
		
	}
	
	public Produit( String designation, double prix, boolean disponible, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.disponible = disponible;
		this.quantite = quantite;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", prix=" + prix + ", disponible="
				+ disponible + ", quantite=" + quantite + "]";
	}
	
	

}

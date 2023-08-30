package section2ClassObjetMethode.Exo24;

import java.time.LocalDate;

public class Product {

    private Long productId;

    private  String productName;

    private LocalDate dateCreation;

    private String fournisseur;

    public Product(String productName, LocalDate dateCreation, String fournisseur) {
        this.productName = productName;
        this.dateCreation = dateCreation;
        this.fournisseur = fournisseur;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", dateCreation=" + dateCreation +
                ", fournisseur='" + fournisseur + '\'' +
                '}';
    }
}

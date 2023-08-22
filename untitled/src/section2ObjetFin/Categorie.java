package section2ObjetFin;

import java.util.List;

public class Categorie {

    private Long categorieId;

    private String categorieName;

    private String categorieDescription;

    private List<Product> ProductListCategorie;

    public Categorie(String categorieName, String categorieDescription, List<Product> productListCategorie) {
        this.categorieName = categorieName;
        this.categorieDescription = categorieDescription;
        ProductListCategorie = productListCategorie;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public String getCategorieDescription() {
        return categorieDescription;
    }

    public void setCategorieDescription(String categorieDescription) {
        this.categorieDescription = categorieDescription;
    }

    public List<Product> getProductListCategorie() {
        return ProductListCategorie;
    }

    public void setProductListCategorie(List<Product> productListCategorie) {
        ProductListCategorie = productListCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "categorieId=" + categorieId +
                ", categorieName='" + categorieName + '\'' +
                ", categorieDescription='" + categorieDescription + '\'' +
                ", ProductListCategorie=" + ProductListCategorie +
                '}';
    }
}

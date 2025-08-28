package entities;

public class Ingredient {

    private String nameIngredient;
    private Double quantityPurchased;
    private String unityOfMeasure;
    private Double amountPaid;
    private Double desiredQuantity;

    public Ingredient() {
    }

    public Ingredient(String nameIngredient, Double quantityPurchased, String unityOfMeasure, Double amountPaid) {
        this.nameIngredient = nameIngredient;
        this.quantityPurchased = quantityPurchased;
        this.unityOfMeasure = unityOfMeasure;
        this.amountPaid = amountPaid;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public Double getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Double quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public String getUnityOfMeasure() {
        return unityOfMeasure;
    }

    public void setUnityOfMeasure(String unityOfMeasure) {
        this.unityOfMeasure = unityOfMeasure;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getDesiredQuantity() {
        return desiredQuantity;
    }

    public void setDesiredQuantity(Double desiredQuantity) {
        this.desiredQuantity = desiredQuantity;
    }

    public Double calculateCostPerUnit() {
        if (amountPaid == 0 || quantityPurchased == 0) {
            throw new IllegalArgumentException("Error: quantidade comprada não poder ser zero.");
        }
        return amountPaid / quantityPurchased;
    }

    public Double calculateCostDesiredQuantity() {
        Double costPerUnitCalculated = calculateCostPerUnit();

        if (desiredQuantity == 0) {
            throw new IllegalArgumentException("Erro: quantidade comprada não poder ser zero.");
        }
        return desiredQuantity * costPerUnitCalculated;
    }
}

package entities;

import entities.pack.PackagingCostSet;

public class FinalProduct {

    private double profitMargin;

    private PackagingCostSet packagingCostSet;
    private Recipe recipe;

    public FinalProduct(double profitMargin, PackagingCostSet packagingCostSet, Recipe recipe) {
        this.profitMargin = profitMargin;
        this.packagingCostSet = packagingCostSet;
        this.recipe = recipe;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public PackagingCostSet getPackagingCostSet() {
        return packagingCostSet;
    }

    public double calculateTotalCosts() {
        return getRecipe().calculateCostRecipe() + getPackagingCostSet().getTotalCostPerBox();
    }

    public double getSellingPrice() {
        return calculateTotalCosts() + (calculateTotalCosts() * this.profitMargin / 100);
    }
}

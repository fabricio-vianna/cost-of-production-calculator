package entities;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String nameRecipe;
    private Double extraCosts;
    private Integer unitsProduced;

    List<Ingredient> ingredientList = new ArrayList<>();

    public Recipe() {
        super();
    }

    public Recipe(String nameRecipe, Double extraCosts) {
        this.nameRecipe = nameRecipe;
        this.extraCosts = extraCosts;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public Double getExtraCosts() {
        return extraCosts;
    }

    public void setExtraCosts(Double extraCosts) {
        this.extraCosts = extraCosts;
    }

    public Integer getUnitsProduced() {
        return unitsProduced;
    }

    public void setUnitsProduced(Integer unitsProduced) {
        this.unitsProduced = unitsProduced;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
    }

    public Double calculateCostRecipe() {
        double sumCostIngredients = 0.0;

        for (Ingredient ingredient : ingredientList) {
            Double cost = ingredient.calculateCostDesiredQuantity();

            if (cost != null) {
                sumCostIngredients += cost;
            }
        }

        if (extraCosts != null) {
            sumCostIngredients += extraCosts;
        }

        return sumCostIngredients;
    }

    public Double calculateUnitCostPerRecipe() {
        if (unitsProduced == 0) {
            throw new IllegalArgumentException("Unidades produzidas não podem ser zero.");
        }
        return calculateCostRecipe() / unitsProduced;
    }
}

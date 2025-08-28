package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.FinalProduct;
import entities.Ingredient;
import entities.Recipe;
import entities.pack.PackagingCostSet;
import entities.pack.PackagingItem;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            Recipe recipe = new Recipe();
            PackagingCostSet packagingCostSet = new PackagingCostSet();
            List<Ingredient> ingredientList = recipe.getIngredientList();
            List<PackagingItem> packagingItems = new ArrayList<>();

            System.out.println("\n=== Cadastro de Ingredientes ===\n");
            System.out.print("Digite quantos Ingredientes quer por: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                sc.nextLine();
                System.out.println("Ingredient #" + (i + 1));

                System.out.print("Nome: ");
                String nameIngredient = sc.nextLine();
                System.out.print("Unidade de medida do produto: ");
                String unityOfMeasure = sc.nextLine();
                System.out.print("Quantos " + unityOfMeasure + " você comprou no total? ");
                double quantityPurchased = sc.nextDouble();
                System.out.print("Valor total que pagou (ex: 18.25): ");
                double amountPaid = sc.nextDouble();
                System.out.print("Quantidade em " + unityOfMeasure + " que vai usar na receita: ");
                double desiredQuantity = sc.nextDouble();
                System.out.println("Ingrediente adicionado com sucesso!\n");

                Ingredient ingredient = new Ingredient(nameIngredient, quantityPurchased, unityOfMeasure, amountPaid);
                ingredient.setDesiredQuantity(desiredQuantity);

                recipe.addIngredient(ingredient);
            }
            System.out.print("Quantas unidades do produto foram produzidas com esta receita? ");
            int unitsProduced = sc.nextInt();
            while (unitsProduced == 0) {
                System.out.print("Valor inválido. Digite um número maior que zero: ");
                unitsProduced = sc.nextInt();
            }

            recipe.setUnitsProduced(unitsProduced);

            System.out.println();
            System.out.println("Receita criada com sucesso!");

            System.out.println("\n=== Cadastro de embalagens ===");
            System.out.print("\nEste produto usa embalagem? Digite 's' para sim ou 'n' para não: ");
            char ch = sc.next().toLowerCase().charAt(0);
            while (ch != 's' && ch != 'n') {
                System.out.print("Digite apenas 's' para sim ou 'n' para não: ");
                ch = sc.next().toLowerCase().charAt(0);
            }

            if (ch == 's') {
                System.out.print("\nQuantos produtos possui na embalagem? ");
                n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    sc.nextLine();
                    System.out.println("Produto #" + (i + 1));
                    System.out.print("Nome: ");
                    String namePackagingItem = sc.nextLine();
                    System.out.print("Informe o valor total pago por este item (ex: 12.50): R$ ");
                    double totalPaid = sc.nextDouble();
                    System.out.print("Quantas unidades possuem deste item? ");
                    int totalQuantityBought = sc.nextInt();
                    System.out.print("Quantas unidades são usadas na embalagem? ");
                    int quantityUsedPerBox = sc.nextInt();

                    PackagingItem packagingItem = new PackagingItem(namePackagingItem, totalPaid, totalQuantityBought, quantityUsedPerBox);

                    packagingItems.add(packagingItem);

                    packagingCostSet.addItemPackagingItems(packagingItem);
                }

                System.out.println("Embalagem criada com sucesso!");
            }

            System.out.print("\nInforme custos extras (ex: gás, luz, translado): ");
            double extraCosts = sc.nextDouble();
            recipe.setExtraCosts(extraCosts);

            System.out.print("Informe sua margem de lucro: ");
            double profitMargin = sc.nextDouble();
            while (profitMargin < 0) {
                System.out.println("Informe sua margem de lucro (em %): ");
                profitMargin = sc.nextDouble();
            }

            FinalProduct finalProduct = new FinalProduct(profitMargin, packagingCostSet, recipe);

            System.out.println();
            int i = 1;
            for (Ingredient list : ingredientList) {
                System.out.printf("Custo do ingrediente %d (%s): R$ %.2f\n", i, list.getNameIngredient(), list.calculateCostDesiredQuantity());
                i += 1;
            }
            System.out.printf("Custo da Receita (Ingredientes + Extras): R$ %.2f\n", recipe.calculateCostRecipe());
            System.out.printf("Custo por unidade da Receita: R$ %.2f\n", recipe.calculateUnitCostPerRecipe());
            System.out.printf("Custo da Embalagem: R$ %.2f\n", packagingCostSet.getTotalCostPerBox());
            System.out.printf("Custo total do Produto (Receita + Embalagem) R$: %.2f\n", finalProduct.calculateTotalCosts());
            System.out.printf("Valor de Venda (Custo Total + %.2f%% de Lucro): %.2f\n", profitMargin, finalProduct.getSellingPrice());

            System.out.println("\nIngredientes usados:");
            for (Ingredient ing : ingredientList) {
                System.out.println("- " + ing.getNameIngredient() + ": " + ing.getDesiredQuantity() + " " + ing.getUnityOfMeasure());
            }

            System.out.println("\nProdutos usados no pacote:");
            for (PackagingItem items : packagingItems) {
                System.out.println("- " + items.getNamePackagingItem() + ": " + items.getQuantityUsedPerBox() + " unidades");
            }

        } catch (NullPointerException e) {
            System.out.println("Error: valor nulo encontrado.");
        } catch (NumberFormatException e) {
            System.out.println("Erro: formato de número inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro genérico: " + e.getMessage());
        }

        sc.close();
    }
}

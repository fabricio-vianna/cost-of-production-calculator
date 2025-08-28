package entities.pack;

public class PackagingItem {

    private String namePackagingItem;
    private double totalPaid;
    private int totalQuantityBought;
    private int quantityUsedPerBox;

    public PackagingItem() {
    }

    public PackagingItem(String namePackagingItem, double totalPaid, int totalQuantityBought, int quantityUsedPerBox) {
        this.namePackagingItem = namePackagingItem;
        this.totalPaid = totalPaid;
        this.totalQuantityBought = totalQuantityBought;
        this.quantityUsedPerBox = quantityUsedPerBox;
    }

    public String getNamePackagingItem() {
        return namePackagingItem;
    }

    public void setNamePackagingItem(String namePackagingItem) {
        this.namePackagingItem = namePackagingItem;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getTotalQuantityBought() {
        return totalQuantityBought;
    }

    public void setTotalQuantityBought(int totalQuantityBought) {
        this.totalQuantityBought = totalQuantityBought;
    }

    public int getQuantityUsedPerBox() {
        return quantityUsedPerBox;
    }

    public void setQuantityUsedPerBox(int quantityUsedPerBox) {
        this.quantityUsedPerBox = quantityUsedPerBox;
    }

    public double getUnitCost() {
        return totalPaid / totalQuantityBought;
    }

    public double getCostPerBox() {
        return getUnitCost() * quantityUsedPerBox;
    }
}

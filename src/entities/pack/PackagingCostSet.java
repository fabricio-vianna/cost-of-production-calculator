package entities.pack;

import java.util.ArrayList;
import java.util.List;

public class PackagingCostSet {

    private List<PackagingItem> packagingItems = new ArrayList<>();

    public List<PackagingItem> getPackagingItems() {
        return packagingItems;
    }

    public void addItemPackagingItems(PackagingItem itemsPackagign) {
        this.packagingItems.add(itemsPackagign);
    }

    public Double getTotalCostPerBox() {
        double sumItems = 0.0;
        for (PackagingItem items : packagingItems) {
            sumItems += items.getCostPerBox();
        }

        return sumItems;
    }
}

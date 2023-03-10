package week13.evening.task1;


import java.util.ArrayList;

public class TJMaxx {
    /**
     * Private lists to hold regular Item objects
     * and OnSaleItem objects that represent items that sell in TJMaxx
     */
    private ArrayList<Item> regularItems;
    private ArrayList<OnSaleItem> onSaleItems;

    private int countRegularItemCatalogNumber;
    private int countOnSaleItemCatalogNumber;

    /**
     * Public no-args constructor - Instantiates regularItems and onSaleItems lists
     * as new ArrayList
     */
    public TJMaxx() {
        regularItems = new ArrayList<>();
        onSaleItems = new ArrayList<>();

    }

    /**
     * adds an item object to regularItems list
     *
     * @param item
     */
    public void addItem(Item item) {
        this.regularItems.add(item);
    }

    /**
     * adds OnSaleItem object to onSaleItems list
     *
     * @param item
     */
    public void addOnSaleTem(OnSaleItem item) {
        this.onSaleItems.add(item);
    }

    /**
     * getter for regularItems
     *
     * @return
     */
    public ArrayList<Item> getRegularItems() {
        return regularItems;
    }

    /**
     * getter for onSaleItems
     *
     * @return
     */
    public ArrayList<OnSaleItem> getOnSaleItems() {
        return onSaleItems;
    }

    /**
     * return count of regularItem object
     *
     * @return
     */
    public int getCountRegularItems() {

        return this.regularItems.size();
    }


    /**
     * returns count of onSaleItems in TJ Maxx
     *
     * @return
     */
    public int getCountOnSaleItems() {

        return this.onSaleItems.size();
    }

    /**
     * returns the name of each item in TJ Maxx starting
     * from regular item then onSaleItems
     *
     * @return
     */
    public ArrayList<String> getItemNames() {
        ArrayList<String> names = new ArrayList<>();
        //get each name from regular items
        for (Item item : regularItems) {
            names.add(item.getName());
        }
        //get each name from on sale items
        for (Item item : onSaleItems) {
            names.add(item.getName());
        }
        return names;


    }


    /**
     * gets catalog number and returns price for the item
     * it will search for the item both regularItems and onsaleonSaleItems
     *
     * @param catalogNumber
     * @returns 0.0 if product cannot be found with that catalognumber
     */

    public double findPriceByCatalogNumber(int catalogNumber) {
        double price = 0.0;

        for (Item item : regularItems) {
            if (item.getCatalogNumber() == catalogNumber) {

                price = item.getPrice();
                break;
            }

        }

        for (OnSaleItem item : onSaleItems) {
            if (item.getCatalogNumber() == catalogNumber) {

                price = item.getPrice();
                break;
            }

        }

        return price;
    }


    /**
     * accepts a name then searches
     * amoung onSaleItems. Once it finds, the method will return
     * that OnSaleItem object
     *
     * @param name
     * @return
     */

    public OnSaleItem findItemByName(String name) {
        OnSaleItem foundonSaleItem = null;
        for (OnSaleItem onSaleItem : onSaleItems) {
            if (onSaleItem.getName().equals(name)) {
                foundonSaleItem = onSaleItem;
                break;
            }
        }
        return foundonSaleItem;
    }


    /**
     * removes the item with matching catalogNumber
     * from both regularItems and onSaleItems.
     * Does nothing if not found
     *
     * @param catalogNumber
     */
    public void removeItemByCatalogNumber(int catalogNumber) {
        regularItems.removeIf(item -> item.getCatalogNumber() == catalogNumber);
        onSaleItems.removeIf(onSaleItem -> onSaleItem.getCatalogNumber() == catalogNumber);
    }


    /**
     * - it accepts a catalog number and finds that item
     * among regularItems and onSaleItems
     * - if it finds the item:
     * - decrease the count of the Item by 1
     * - if count reaches 0 after decrementing then remove the product(call removeItem method)
     *
     * @param catalogNumber
     */

    /*


     */
    public void reduceItemCount(int catalogNumber) {

        for (Item item : regularItems) {
            if (item.getCatalogNumber() == catalogNumber) {
                //we neeed to get the countity and we need to decrease the number of the countity
                int newQuantity = item.getQuantity() - 1;
                item.setQuantity(newQuantity);
                if (newQuantity==0){
                    removeItemByCatalogNumber(catalogNumber);
                    return;
                }

            }

        }

        for (OnSaleItem item : onSaleItems) {
            if (item.getCatalogNumber() == catalogNumber) {
                int newQuantity = item.getQuantity() - 1;
                item.setQuantity(newQuantity);
                if (newQuantity==0){
                    removeItemByCatalogNumber(catalogNumber);
                    return;
                }

            }

        }



    }


}

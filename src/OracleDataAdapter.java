//package edu.auburn;

public class OracleDataAdapter implements IDataAdapter {
    public int connect(String dbfile) {
        //...
        return CONNECTION_OPEN_OK;
    }

    public int disconnect() {
        // ...
        return CONNECTION_CLOSE_OK;

    }

    public ProductModel loadProduct(int id) {
        return null;
    }
    public int saveProduct(ProductModel model) {
        return PRODUCT_SAVE_OK;
    }

    public CustomerModel loadCustomer(int id) {
        return null;
    }
    public int saveCustomer(CustomerModel model) {
        return CUSTOMER_SAVE_OK;
    }

    public PurchaseModel loadPurchase(int id) {
        return null;
    }
    //public int savePurchase(PurchaseModel model) {
    //    return PURCHASE_SAVED_OK;
    //}

    @Override
    public int savePurchase(PurchaseModel model) {
        return 0;
    }

    @Override
    public PurchaseListModel loadPurchaseHistory(int customerID) {
        return null;
    }

    @Override
    public ProductListModel searchProduct(String name, double minPrice, double maxPrice) {
        return null;
    }

    @Override
    public UserModel loadUser(String username) {
        return null;
    }

}


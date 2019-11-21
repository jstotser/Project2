//package COMP3700;

import javax.swing.*;

public class StoreManager {
    public static String dbms = "SQLite";
    public static String path = "C:/Users/jacob/OneDrive/Documents/Fall 2019 Semester/COMP 3700/store.db";

    IDataAdapter dataAdapter = null;
    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {
            instance = new StoreManager(dbms, path);
            //String dbfile = DB_FILE;
            //JFileChooser fc = new JFileChooser();
            //if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            //    dbfile = fc.getSelectedFile().getAbsolutePath();

            //instance = new StoreManager(DBMS_SQ_LITE, dbfile);
        }
        return instance;
    }

    private StoreManager(String dbms, String dbfile) {
        if (dbms.equals("Oracle"))
            dataAdapter = new OracleDataAdapter();
        else
        if (dbms.equals("SQLite"))
            dataAdapter = new SQLiteDataAdapter();
        else
            if (dbms.equals("Network"))
                dataAdapter = new NetworkDataAdapter();

        dataAdapter.connect(dbfile);
        //ProductModel product = adapter.loadProduct(3);

        //System.out.println("Loaded product: " + product);

        //CustomerModel customer = adapter.loadCustomer(3);

        //System.out.println("Loaded customer: " + customer);

    }

    public IDataAdapter getDataAdapter() {
        return dataAdapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        dataAdapter = a;
    }


    public void run() {
        //LoginUI ui = new LoginUI();
        MainUI ui = new MainUI();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello class!");
        if (args.length > 0) {
            dbms = args[0];
            if (args.length == 1) {
                if (dbms.equals("SQLite")) {
                    JFileChooser fc = new JFileChooser();
                    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                        path = fc.getSelectedFile().getAbsolutePath();
                }
                else
                    path = JOptionPane.showInputDialog("Enter address of database server as host:port");
            }
            else
                path = args[1];
        }
        StoreManager.getInstance().run();
    }

}
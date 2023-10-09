package bai1.ra.bussinessImp;

import bai1.ra.bussiness.IShop;
import config.InputMethods;

import static bai1.ra.run.ProductManagement.catalogs;
import static bai1.ra.run.ProductManagement.products;

public class Product implements IShop {

    private int productId;
    private String productName, title, descriptions;
    private Catalog catalog;
    private float importPrice, exportPrice;
    private boolean productStatus;
    // constructor

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }
    // getter setter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    // methods
    public void inputData() {
        System.out.println("<---------------------------------------------------->");
        boolean isExit = true;
        if (catalogs.isEmpty()) {
            System.out.println("Danh sách danh mục đang trống, yêu cầu thêm danh mục và nhập lại!!");
            return;
        } else {


            // id
            do {
                System.out.print("Nhập id sản phẩm: ");
                int id = InputMethods.getInteger();
                Boolean isExist = false;
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).productId == id) {
                        isExist = true;
                    }
                }
                if (isExist) {
                    System.out.println("Id đã tồn tại! Vui lòng nhập lại...!!");
                } else {
                    this.productId = id;
                    break;
                }
            } while (isExit);
            // name
            do {
                System.out.print("Nhập tên sản phẩm: ");
                this.productName = InputMethods.getString();
                break;
            } while (isExit);
            // Các thuộc tính
            //▪ productId – Mã sản phẩm – int
            //▪ productName – Tên sản phẩm – String
            //▪ title – Tiêu đề sản phẩm – String
            //▪ descriptions – mô tả sản phẩm – String
            //▪ catalog – danh mục sản phẩm – Catalog
            //▪ importPrice – giá nhập sản phẩm – float
            //▪ exportPrice – giá bán sản phẩm - float
            //▪ productStatus – trạng thái sản phẩm – Boolean
            // title
            do {
                System.out.print("Nhập tiêu đề sản phẩm: ");
                String title = InputMethods.getString();
                if (title.length() <= 10) {
                    System.out.println("Tiêu đề không được dưới 10 kí tự! Vui lòng nhập lại...");
                } else {
                    this.title = title;
                    break;
                }
            } while (isExit);
            // descriptions
            do {
                System.out.print("Nhập mô tả sản phẩm: ");
                String descriptions = InputMethods.getString();
                if (title.length() <= 10) {
                    System.out.println("Mô tả không được dưới 10 kí tự! Vui lòng nhập lại...");
                } else {
                    this.descriptions = descriptions;
                    break;
                }
            } while (isExit);
            // catalog
            do {

                System.out.println("Vui lòng chọn danh mục");
                System.out.println("<---------------------------------->");
                for (Catalog catalog1 : catalogs) {
                    System.out.println(catalog1.getCatalogName());
                }
                System.out.println("<---------------------------------->");
                System.out.print("Nhập tên danh mục muốn chọn: ");
                String catalog = InputMethods.getString();
                boolean isExist = false;
                for (Catalog catalog1 : catalogs) {
                    if (catalog1.getCatalogName().equals(catalog)) {
                        this.catalog = catalog1;
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    System.out.println("Không tồn tại danh mục đã nhập!!");
                } else {
                    break;
                }
            } while (isExit);
            // importPrice
            do {
                System.out.print("Nhập đầu vào: ");
                this.importPrice = InputMethods.checkNum();
                break;
            } while (isExit);
            // exportPrice
            this.exportPrice = importPrice * RATE;
            // statusBook
            do {
                System.out.print("Nhập trạng thái sản phẩm(true or false): ");
                String status = InputMethods.getString();
                if (status.equals("true") || status.equals("false")) {
                    this.productStatus = Boolean.parseBoolean(status);
                    break;
                } else {
                    System.out.println("Yêu cầu nhập đúng trường! Vui lòng nhập lại...");
                }
            } while (isExit);
        }
        System.out.println("Thêm sản phẩm " + this.productName + " thành công!!");
        System.out.println("<---------------------------------------------------->");

    }


    @Override
    public void displayData() {
        System.out.println("<-----------------" + productName.toUpperCase() + "----------------->");
        System.out.println("Id sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Danh mục: " + catalog.getCatalogName());
        System.out.println("Giá bán: " + exportPrice);
        System.out.println("Trạng thái: " + (productStatus ? "Đang được bán" : "Lưu trữ"));
        System.out.println("<------------------------------------------------>");
    }
}

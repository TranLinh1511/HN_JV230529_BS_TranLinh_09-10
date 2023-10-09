package bai1.ra.bussinessImp;

import bai1.ra.bussiness.IShop;
import config.InputMethods;

import static bai1.ra.run.ProductManagement.catalogs;

public class Catalog implements IShop {

    private int catalogId, priority;
    private String catalogName, descriptions;
    private boolean catalogStatus;
    // contructor

    public Catalog(int catalogId, int priority, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.priority = priority;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    // getter setter
    public Catalog() {
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // methods
    @Override
    public void inputData() {
        System.out.println("<---------------------------------------------------->");
        boolean isExit = true;
        // id
        do {
            System.out.print("Nhập id Catalog: ");
            int id = InputMethods.getInteger();
            Boolean isExist = false;
            for (int i = 0; i < catalogs.size(); i++) {
                if (catalogs.get(i).getCatalogId() == id) {
                    isExist = true;
                }
            }
            if (isExist) {
                System.out.println("Id đã tồn tại! Vui lòng nhập lại...!!");
            } else {
                this.catalogId = id;
                break;
            }
        } while (isExit);
        // name
        do {
            System.out.print("Nhập tên danh mục: ");
            this.catalogName = InputMethods.getString();
            break;
        } while (isExit);
        // descriptions
        do {
            System.out.print("Nhập mô tả danh mục: ");
            String title = InputMethods.getString();
            if (title.length() <= 10) {
                System.out.println("Tiêu đề không được dưới 10 kí tự! Vui lòng nhập lại...");
            } else {
                this.descriptions = title;
                break;
            }
        } while (isExit);
        // catalogStatus
        do {
            System.out.print("Nhập trạng thái danh mục(true or false): ");
            String status = InputMethods.getString();
            if (status.equals("true") || status.equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            } else {
                System.out.println("Yêu cầu nhập đúng trường! Vui lòng nhập lại...");
            }
        } while (isExit);
        System.out.println("<---------------------------------------------------->");

    }

    @Override
    public void displayData() {
        System.out.println("<-----------------" + catalogName.toUpperCase() + "----------------->");
        System.out.println("Id danh mục: " + catalogId);
        System.out.println("Tên danh mục: " + catalogName);
        System.out.println("Mô tả danh mục: " + descriptions);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Trạng thái: " + (catalogStatus ? "Đang được bán" : "Lưu trữ"));
        System.out.println("<------------------------------------------------>");
    }
}

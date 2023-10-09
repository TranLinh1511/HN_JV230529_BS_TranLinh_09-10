package bai1.ra.run;

import bai1.ra.bussinessImp.Catalog;
import bai1.ra.bussinessImp.Product;
import config.InputMethods;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    public static List<Product> products = new ArrayList<>();
    public static List<Catalog> catalogs = new ArrayList<>();

    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục\n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)\n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm\n" +
                    "5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choose = InputMethods.getByte();
            switch (choose) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    searchByNameCatalog();
                    break;
                case 5:
                    boolean confirm = confirm("Bạn có chắc chắn muốn thoát chương trình(y/ n): ");
                    if (confirm) {
                        System.out.println("Thoát chương trình!!");
                    } else {
                        break;
                    }
                default:
                    System.out.println("Yêu cầu nhập đúng trường!!");
            }
        } while (true);
    }

    private static boolean checkEmpty() {
        if (products.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private static void searchByNameCatalog() {
        if (checkEmpty()) {
            System.out.print("Nhập tên danh mục muốn tìm kiếm: ");
            String catalogName = InputMethods.getString();
            List<Product> products1 = new ArrayList<>();
            boolean isExist = false;
            for (Product product : products) {
                if (product.getCatalog().getCatalogName().equalsIgnoreCase(catalogName)) {
                    products1.add(product);
                }
            }
            System.out.println("DANH SÁCH SẢN PHẨM TRONG DANH MỤC " + catalogName.toUpperCase());
            for (Product product : products1) {
                product.displayData();
            }
        } else {
            System.out.println("Danh sách sản phẩm trống! Yêu cầu nhập thêm...");
        }


    }

    private static void sortProductByPrice() {
        if (checkEmpty()) {
            insertionSort(products);
            System.out.println("Danh sách sau khi sắp xếp theo giá bán tăng dần: ");
            for (Product product : products) {
               product.displayData();
            }
        } else {
            System.out.println("Danh sách sản phẩm trống! Yêu cầu nhập thêm...");
        }
    }

    private static void addProduct() {
        System.out.print("Nhập số lượng sản phẩm muốn thêm: ");
        int number = InputMethods.getInteger();
        for (int i = 0; i < number; i++) {
            System.out.println("NHẬP THÔNG TIN SẢN PHẨM " + (i + 1));
            Product product = new Product();
            product.inputData();
            products.add(product);
        }
    }

    private static void addCatalog() {
            System.out.print("Nhập số lượng danh mục muốn thêm: ");
            int number = InputMethods.getInteger();
            for (int i = 0; i < number; i++) {
                System.out.println("NHẬP THÔNG TIN DANH MỤC " + (i + 1));
                Catalog catalog = new Catalog();
                catalog.inputData();
                catalogs.add(catalog);
            }
            System.out.println("Thêm thành công " + number + " danh mục!!");
    }

    private static boolean confirm(String note) {
        do {
            System.out.print(note);
            String confirm = InputMethods.getString().toLowerCase();
            if (confirm.equals("y")) {
                return true;
            } else if (confirm.equals("n")) {
                return false;
            } else {
                System.out.println("Yêu cầu nhập đúng trường y/n!!");
            }
        } while (true);

    }

    private static void insertionSort(List<Product> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            double key = arr.get(i).getExportPrice();
            int j = i - 1;
            while (j >= 0 && arr.get(j).getExportPrice() > key) {
                swap(arr, j, j + 1);
                j = j - 1;
            }
        }
    }

    private static void swap(List<Product> arr, int i, int j) {
        Product temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}

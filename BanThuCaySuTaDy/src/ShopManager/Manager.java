package ShopManager;

import Shop.Shop;
import ShopMind.ShopManager;
import ShopRepository.Repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager implements ShopManager {
    ArrayList<Shop> list;

    public Manager(Repository ShopList) {
        this.list = ShopList.repoList;
    }

    @Override
    public void display() {
        if (list.size() == 0) {
            System.out.println("Shop Hiện Tại Vẩn Chưa Mở Bán");
        } else {
            for (Shop sp : list) {
                sp.DisplayProducts();
            }
        }
    }

    @Override
    public void createProduct() {
        Shop sp = new Shop();
        Scanner input = new Scanner(System.in);
        System.out.print("Product id: ");
        int id = input.nextInt();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getID() == id) {
                System.out.println("The product already exists !");
                return;
            } else {
                sp.setID(id);
                System.out.print("Product name: ");
                String name = input.next();
                sp.setName(name);
                System.out.print("Product price: ");
                int price = input.nextInt();
                sp.setPrice(price);
                this.list.add(sp);
                update();
                break;
            }
        }
    }

//            @Override
//    public void delete(int id) {
//        for (int i = 0; i < this.list.size(); i++) {
//            if (this.list.get(i).getID() == id) {
//                this.list.remove(i);
//                update();
//                break;
//            }
//        }
//    }
//    @Override
//    public void delete(String name) {
//
//        for (Shop sp : list) {
//            if (sp.getName().trim().equals(name.trim())) {
//                list.remove(sp);
//            }
//            break;
//        }
//        update();
//        System.out.println("Xin Cảm Mơn Qúy Khách");
//    }
    @Override
    public void delete(String name) {
        Shop objDelete = new Shop();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getName().trim().equals(name.trim())) {
                objDelete = this.list.get(i);
                break;
            }
        }
        this.list.remove(objDelete);
        update();
    }
    @Override
    public void edit(int id) {
        Scanner sp = new Scanner(System.in);
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getID() == id) {
                System.out.print("New product id: ");
                int newID = sp.nextInt();
                this.list.get(i).setID(newID);


                System.out.print("New product name: ");
                String newName = sp.next();
                this.list.get(i).setName(newName);

                System.out.print("New product price: ");
                int newPrice = sp.nextInt();
                this.list.get(i).setPrice(newPrice);
                update();
                break;
            }
//            else {
//                System.out.println("Đồ bạn muốn thay đổi không tồn tại");
//            }
        }
    }

    @Override
    public void sort(boolean type) {
        ArrayList<Shop> sp = this.list;
        Shop tempPro;
        if (type) {
            for (int i = 0; i < sp.size() - 1; i++) {
                for (int j = 0; j < sp.size() - 1; j++) {
                    if (sp.get(j).getPrice() > sp.get(j + 1).getPrice()) {
                        Shop temp;
                        temp = sp.get(j);
                        sp.set(j, sp.get(j + 1));
                        sp.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < sp.size() - 1; i++) {
                for (int j = 0; j < sp.size() - 1; j++) {
                    if (sp.get(j).getPrice() < sp.get(j + 1).getPrice()) {
                        Shop temp;
                        temp = sp.get(j);
                        sp.set(j, sp.get(j + 1));
                        sp.set(j + 1, temp);
                    }
                }
            }
        }
        for (int i = 0; i < sp.size(); i++) {
            System.out.print("Product " + (Integer) (i + 1) + ": ");
            System.out.println(sp.get(i).toString());

        }
    }

    @Override
    public void find(String name) {

//        for (int i = 0; i < this.list.size(); i++) {
//            if (this.list.get(i).getName().equals(name)) {
//                System.out.println(this.list.get(i).toString());
//                break;
//            }
//        }
//        ArrayList<Shop> sp = this.list;
//        Shop tempPro;
//        for (int i = 0; i < sp.size(); i++) {
//            if (sp.get(i).getName().equals(name)) {
//                System.out.print("Product " + (Integer) (i + 1) + ": ");
//                System.out.println(sp.get(i).toString());
//                break;
//            }
//        }
        ArrayList<Shop> shop = this.list;
        if (shop.size() == 0) {
            System.out.println("Shop Hiện Tại Vẩn Chưa Mở Bán");
        } else {
            boolean timthay = false;
            for (Shop sp : list) {
                if (sp.getName().equals(name)) {
                    System.out.println(sp.toString());
                    timthay = true;
                    break;
                }
            }
            if (timthay == false) {
                System.out.println("Đồ bạn Muốn Tìm Shop hiện không có" + name);
            }
        }
    }

    private void update() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Text2\\BanThuCaySuTaDy\\src\\ShopRepositoryFile\\Shop.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < this.list.size(); i++) {
                Shop updateShop = this.list.get(i);
                String content = updateShop.getID() + ", " + updateShop.getName() + ", " + updateShop.getPrice();
                bw.write(content);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private void revenue() {
        ArrayList<Shop> shop = this.list;
    }
}

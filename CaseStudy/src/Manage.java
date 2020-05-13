import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.text.html.parser.DTDConstants.ID;


public class Manage implements ShopManage {
    ArrayList<Shop> list;

    public Manage(Repository ShopList) {
        this.list = ShopList.repoList;
    }

    @Override
    public void display() {
        if (list.size() == 0) {
            System.out.println("Shop chua co san pham");
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

        if (this.list.size() == 0) {
            sp.setID(ID);

            System.out.print("Product name: ");
            String name = input.next();
            sp.setName(name);

            System.out.print("Product price: ");
            int price = input.nextInt();
            sp.setPrice(price);
            this.list.add(sp);

        }
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
                try {
                    FileWriter writer = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Text2\\CaseStudy\\src\\Shop.txt");
                    BufferedWriter bw = new BufferedWriter(writer);
                    for (int j = 0; j < this.list.size(); j++) {
                        Shop updateShop = this.list.get(j);
                        String content = updateShop.getID() + ", " + updateShop.getName() + ", " + updateShop.getPrice();
                        bw.write(content);
                        bw.newLine();
                    }
//                bw.flush();
                    bw.close();
                } catch (IOException e) {
                    System.err.format("IOException: %s%n", e);
                }
                this.list.add(sp);
                update();
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getID() == id) {
                this.list.remove(i);
                update();
                break;
            }
        }
    }


//    @Override
//    public void delete(String name) {
//        for (int i = 0; i < this.list.size(); i++) {
//            if (this.list.get(i).getName().equals(name)) {
//                System.out.println(this.list.get(i).getName());
//                this.list.remove(i);
//        update();
//      break;
//            }
//        }
//      }

    @Override
    public void edit(int id) {
        Scanner sp = new Scanner(System.in);
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getID() == id) {
                System.out.print("New product name: ");
                String newName = sp.next();
                this.list.get(i).setName(newName);

                System.out.print("New product price: ");
                int newPrice = sp.nextInt();
                this.list.get(i).setPrice(newPrice);
                update();
                break;
            }
        }
    }

    @Override
    public void sort(boolean type) {
        ArrayList<Shop> sortList = this.list;
        Shop tempPro;
        if (type) {
            for (int i = 0; i < sortList.size() - 1; i++) {
                for (int j = 0; j < sortList.size() - 1; j++) {
                    if (sortList.get(j).getPrice() > sortList.get(j + 1).getPrice()) {
                        Shop temp;
                        temp = sortList.get(j);
                        sortList.set(j, sortList.get(j + 1));
                        sortList.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < sortList.size() - 1; i++) {
                for (int j = 0; j < sortList.size() - 1; j++) {
                    if (sortList.get(j).getPrice() < sortList.get(j + 1).getPrice()) {
                        Shop temp;
                        temp = sortList.get(j);
                        sortList.set(j, sortList.get(j + 1));
                        sortList.set(j + 1, temp);
                    }
                }
            }
        }
        for (int i = 0; i < sortList.size(); i++) {
            System.out.print("Product " + (Integer) (i + 1) + ": ");
            System.out.println(sortList.get(i).toString());

        }
    }

    @Override
    public void find(String name) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getName().equals(name)) {
                System.out.println(this.list.get(i).toString());
                break;
            }
        }
    }

    private void update() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\Text2\\CaseStudy\\src\\Shop.txt");
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
}
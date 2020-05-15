package ViewShop;

import ShopManager.Manager;
import ShopRepository.Repository;

import java.io.IOException;
import java.util.Scanner;

public class ViewMenu {

    public static void menu(Manager manager) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("XIN CHÀO ADMIN:");
        System.out.println("1.XEM TẤt CẢ");
        System.out.println("2.THÊM MẪU MỚI");
        System.out.println("3.THAY ĐỔI MẪU MÃ");
        System.out.println("4.Bạn Muốn Tìm Đồ Cho Khách?");
        System.out.println("5.Sắp xếp sản phẩm theo giá");
        System.out.println("6. Thoát");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.print("Mời Chọn: ");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        input.nextLine();
        switch (choose) {
            case 1:
                manager.display();
                break;
            case 2:
                manager.createProduct();
                break;
            case 3:
                int editId;
                System.out.print("Nhập ID sản Phẩm để thay đổi mẫu mã: ");
                editId = input.nextInt();
                manager.edit(editId);
                break;
            case 4:
                System.out.println("Đồ Qúy Khách Muốn Tìm Là ?");
                String searchName = input.nextLine();
                manager.find(searchName);
                break;
            case 5:
                System.out.println("Bạn Muốn Sắp xếp Lại Cửa Hàng:");
                System.out.println("1.Mẫu Đẹp");
                System.out.println("2.MẪU MỚI Nhất Hiện Nay ");
                System.out.print("Xin Mời Chọn: ");
                int sortOption = input.nextInt();
                switch (sortOption) {
                    case 1:
                        manager.sort(true);
                        break;
                    case 2:
                        manager.sort(false);
                        break;
                }
                break;

            default:
                System.out.println("vui lòng chọn lại !");
                break;
            case 6:
                System.out.println("Hẹn Gặp Lại ");
                return;
        }
        menu(manager);
    }

    public static void Menu(Manager manager) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("XIN CHÀO:");
        System.out.println("1.XEM TẤt CẢ");
        System.out.println("2.Tôi Muốn MUA?");
        System.out.println("3.MUA HÀNG");
        System.out.println("4.XEM SẢN PHẨM THEO GIÁ:");
        System.out.println("5. Thoát");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.print("Mời Chọn: ");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        input.nextLine();
        switch (choose) {
            case 1:
                manager.display();
                break;
            case 2:
                System.out.println("Đồ Bạn MUốn Mua");
                String searchName = input.nextLine();
                manager.find(searchName);
                break;
            case 3:
                System.out.println("Bạn Mua:");
                String deleteName = input.nextLine();
                manager.delete(deleteName);
                break;
            case 4:
                System.out.println("Bạn Muốn Xem Mẫu Nào:");
                System.out.println("1.Mẫu Đẹp");
                System.out.println("2.MẪU MỚI Nhất Hiện Nay ");
                System.out.print("Xin Mời Chọn: ");
                int sortOption = input.nextInt();
                switch (sortOption) {
                    case 1:
                        manager.sort(true);
                        break;
                    case 2:
                        manager.sort(false);
                        break;
                }
                break;

            default:
                System.out.println("vui lòng chọn lại !");
                break;
            case 5:
                System.out.println("Cảm Mơn Qúy Khách Đã Ghé ThĂm..." +
                        "Hẹn Gặp Lại Qúy Khách");
                return;
        }
        Menu(manager);
    }

    public static void main(String[] args) throws IOException {
        Repository repo = new Repository();
        System.out.println("CHÀO MỪNG BẠN TỚI VỚI SHOP");
        System.out.println("1.Bạn Là Quản Lí");
        System.out.println("2.Bạn Là KHÁCH HÀNG");
        System.out.println("Mời Chọn:");
        Scanner login = new Scanner(System.in);
        int choose = login.nextInt();
        login.nextLine();
        switch (choose) {
            case 1:
                System.out.println("ĐĂNG NHẬP:");
                Scanner input = new Scanner(System.in);
                String userName = input.nextLine();
                String UserName = "LE HUU LUC";
                System.out.print("PASSSWROD:");
                Scanner InPut = new Scanner(System.in);
                String password = InPut.nextLine();
                String Password = "04/03/2001";
                if (UserName.equals(userName) && Password.equals(password)) {
                    Manager pm = new Manager(repo);
                    menu(pm);
                    break;
                } else {
                    System.out.println("Bạn Không Phải Quản Lí...Có lẻ Bạn Là KhácH Hàng");
                }
            case 2:
                Manager Pm = new Manager(repo);
                Menu(Pm);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choose);
        }
    }
}
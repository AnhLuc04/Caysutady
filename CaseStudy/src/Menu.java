import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu(Manage pm) {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("XIN CHÀO:");
        System.out.println("1.XEM TẤt CẢ");
        System.out.println("2.THÊM MẪU MỚI");
        System.out.println("3.THAY ĐỔI MẪU MÃ");
        System.out.println("4.Bạn Muốn Mua Gì?");
        System.out.println("5.MUA HÀNG");
        System.out.println("6.Sắp xếp sản phẩm theo giá");
        System.out.println("7. Thoát");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.print("Mời Chọn: ");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        input.nextLine();
        switch (choose) {
            case 1:
                pm.display();
                break;
            case 2:
                pm.createProduct();
                break;
            case 3:
                int editId;
                System.out.print("Nhập ID sản Phẩm để thay đổi mẫu mã: ");
                editId = input.nextInt();
                pm.edit(editId);
                break;
            case 4:
                System.out.println("Bạn Muốn Mua Gì?");
                String searchName = input.nextLine();
                pm.find(searchName);
                break;
            case 5:
                System.out.println("Bạn Mua:");
//                int deleteId = input.nextInt();
//                pm.delete(deleteId);
                String deleteName = input.next();
                pm.delete(deleteName);
                break;
            case 6:
                System.out.println("Bạn Muốn Xem Mẫu Nào:");
                System.out.println("1.Mẫu Đẹp");
                System.out.println("2.MẪU MỚI Nhất Hiện Nay ");
                System.out.print("Xin Mời Chọn: ");
                int sortOption = input.nextInt();
                switch (sortOption) {
                    case 1:
                        pm.sort(true);
                        break;
                    case 2:
                        pm.sort(false);
                        break;
                }
                break;

            default:
                System.out.println("vui lòng chọn lại !");
                break;
            case 7:
                System.out.println("Cảm Mơn Qúy Khách Đã Ghé ThĂm..." +
                        "Hẹn Gặp Lại Qúy Khách");
                return;
        }
        menu(pm);
    }

    public static void main(String[] args) throws IOException {
        Repository repo = new Repository();
        Manage pm = new Manage(repo);
        menu(pm);
    }
}
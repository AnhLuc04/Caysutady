public interface ShopManage {
    void display();

    void createProduct();

    void delete(int id);
//    void delete(String name);

    void edit(int id);

    void sort(boolean type);

    void find(String name);


}

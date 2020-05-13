public class Shop {
    private int ID;
    private String Name;
    private Integer Price;

//    public static int size() {
//        return 0;
//    }

    void DisplayProducts() {
        System.out.println("ID:" + ID);
        System.out.println("Tên ĐỒ bạn Muốn Mua:" + Name);
        System.out.println("Giá:" + Price);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        this.Price = price;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "Name='" + getName() + '\'' +
                ", ID=" + getID() +
                ", Price=" + getPrice() +
                '}';
    }

}

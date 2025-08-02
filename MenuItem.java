public class MenuItem {
    private int id;
    private String name;
    private int price;
    private String category; //ドリンクかスイーツか

    public MenuItem(int id, String name, int price, String category) {
    	 this.id = id;       // 商品IDをセット
         this.name = name;   // 商品名をセット
         this.price = price; // 価格をセット
         this.category = category; //カテゴリーをセット
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }
    
}

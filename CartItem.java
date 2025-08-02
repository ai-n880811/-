public class CartItem {
	
	//注文されたメニューを表す
    private MenuItem item;
    //同じ商品がいくつcartにあるかカウントする
    private int count;
    private int freeCount;  // 無料分

    //コンストラクタ：商品を受け取って1個としてカートに追加
    public CartItem(MenuItem item) {
    	// 渡されたMenuItemを保持
    	this.item = item;
        
        //カウントは１からスタート
        this.count = 1;
        
        this.freeCount = 0;
    }

    // 商品数を1つ増やす（同じ商品を再度注文したとき）
    public void countUp() { count++; }
    
    // 商品数を1つ減らす（無料処理などで1個減らす）
    // 0個未満にはならないようにする（マイナス注文を防ぐ）
    public void countDown() { if(count > 0) count--; }

    // 注文された商品情報を返す（例：チーズケーキ, 値段など）
    public MenuItem getItem() { return item; }
    
    // 現在の注文個数を返す
    public int getCount() { return count; }

   //通常分とは別に無料分を増やす
    public void freeCountUp() { freeCount++; }
    
    public int getFreeCount() { return freeCount; }


}

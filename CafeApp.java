import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeApp {

    private static List<CartItem> cart = new ArrayList<>();

    // アプリの起動時に呼び出されるメインメソッド
    // メニュー表示 → 注文受付 → 合計金額表示 の順に処理する
    public static void main(String[] args) {
    	printMenu();   // メニューを表示
    	order();       // 注文処理（ユーザーからの入力受付）
    	printTotal();  // 注文内容と合計金額を表示
    }


    //メニューの表示
    public static void printMenu() {
        System.out.println("--- カフェメニュー ---");
        System.out.println("[1] カフェラテ 450円");
        System.out.println("[2] アールグレイ 400円");
        System.out.println("[3] チーズケーキ 500円");
        System.out.println("[4] ガトーショコラ 550円");
    }

    public static void order() {
        Scanner sc = new Scanner(System.in);
        boolean endFlag = true;
        int count = 0;

        //商品入力の受け取り
        while (endFlag) {
            System.out.print("商品番号を入力してください（終了は 0 ）:");
            int input;
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("メニューの商品番号を入力してください");
                continue;
            }

            if (input == 0) {
                endFlag = false;
                break;
            }

            //入力された番号の商品(MenuItem)のインスタンスを生成
            MenuItem selectedItem = null;
            switch (input) {
                case 1: selectedItem = new MenuItem(1, "カフェラテ", 450, "drink"); break;
                case 2: selectedItem = new MenuItem(2, "アールグレイ", 400, "drink"); break;
                case 3: selectedItem = new MenuItem(3, "チーズケーキ", 500, "sweets"); break;
                case 4: selectedItem = new MenuItem(4, "ガトーショコラ", 550, "sweets"); break;
                default:
                    System.out.println("メニューの商品番号を入力してください");
                    continue;
            }

            //カート内に同じ商品があったら、数量を１つ増やす
            boolean found = false;
            for (CartItem ci : cart) {
                if (ci.getItem().getId() == selectedItem.getId()) {
                    ci.countUp();
                    found = true;
                    break;
                }
            }

            //カート内に商品がなかったら、カートに新しく追加する
            if (!found) {
                cart.add(new CartItem(selectedItem));
            }
            
            System.out.println(selectedItem.getName() + " をカートに追加しました");

          
          //注文を1件追加するたびにカウントを1増やし、5件ごとに無料ドリンク
            count++;
            if (count == 5) {
                freeDrink(sc);
                count = 0;
            }
        }

        sc.close();
    }

    //フリードリンク
    public static void freeDrink(Scanner sc) {
        System.out.println("--- 5ポイントありがとうございます。無料ドリンクを選んでください ---");
        System.out.println("[1] カフェラテ 450円");
        System.out.println("[2] アールグレイ 400円");

        while (true) {
            System.out.print("無料にしたい商品の番号を入力してください: ");
            int input;
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください。");
                continue;
            }

            MenuItem freeItem = null;
            switch (input) {
                case 1:
                    freeItem = new MenuItem(1, "カフェラテ", 450, "drink");break;
                case 2:
                    freeItem = new MenuItem(2, "アールグレイ", 400, "drink");break;
                default:
                    System.out.println("メニューの商品番号を入力してください");
                    continue;
            }

          //カート内に同じ無料ドリンクがあれば、無料の個数を1増やす
            boolean found = false;
            for (CartItem ci : cart) {
                if (ci.getItem().getId() == freeItem.getId()) {
                    ci.freeCountUp();
                    found = true;
                    break;
                }
            }

          //カートに該当の無料ドリンクがなければ、新しくCartItemを作成し、
          //有料分のカウントを1減らし、無料分を1増やしてカートに追加する
            if (!found) {
                CartItem freeCartItem = new CartItem(freeItem);
                freeCartItem.countDown();
                freeCartItem.freeCountUp();
                cart.add(freeCartItem);
            }

            System.out.println(freeItem.getName() + " を無料にしました！");
            break;
        }
    }

  //注文内容の表示（無料分も含めて表示）、および合計金額（有料分のみ）を出力
    public static void printTotal() {
        int total = 0;
        System.out.println("--- 注文内容 ---");
        for (CartItem ci : cart) {
            int totalCount = ci.getCount() + ci.getFreeCount();
            System.out.println(ci.getItem().getName() + " " + ci.getItem().getPrice() + "円 × " + totalCount
                    + (ci.getFreeCount() > 0 ? " (うち無料 " + ci.getFreeCount() + " 個)" : ""));
            total += ci.getItem().getPrice() * ci.getCount();
        }
        System.out.println("合計金額：" + total + "円");
    }
}

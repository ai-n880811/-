# Cafe - カフェ注文シミュレーター コンソール版

## プロジェクト概要
ユーザーがコマンドライン上でドリンクやスイーツを選び、カートに追加して注文できるJava製のコンソールアプリケーションです。
数字を入力することで注文操作を行います。


## デモンストレーション
![カフェアプリのデモ]([https://github.com/ai-n880811/CafeApp/raw/main/カフェアプリ-コンソール版－デモンストレーション.gif](https://github.com/ai-n880811/Console-Version-of-Cafe-App/blob/main/%E3%82%AB%E3%83%95%E3%82%A7%E3%82%A2%E3%83%97%E3%83%AA-%E3%82%B3%E3%83%B3%E3%82%BD%E3%83%BC%E3%83%AB%E7%89%88%EF%BC%8D%E3%83%87%E3%83%A2%E3%83%B3%E3%82%B9%E3%83%88%E3%83%AC%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3.gif))




## 使用技術・開発環境
- **開発環境**: Eclipse IDE for Java Developers 2024-12 (4.34.0)  
- **プログラミング言語**: Java SE 21


## 実行方法

#### ✅ 事前準備

Javaがインストールされている必要があります。  
確認方法：

```bash
java -version
```

#### ✅ 実行手順（ターミナル／コマンドプロンプト）


# リポジトリをクローン
git clone https://github.com/ai-n880811/cafe-console.git

# ディレクトリ移動
cd cafe-console

# Javaファイルをコンパイル
javac Main.java

# アプリを実行
java Main


#### ✅ Eclipseでの実行（IDEを使いたい方へ）
Eclipseを起動

「ファイル」→「インポート」→「一般」→「既存のプロジェクトをワークスペースへ」

クローンしたフォルダ（例：cafe-console）を指定

CafeApp.java を右クリック → 「実行」→「Java アプリケーション」


## 作成者情報

成毛 亜衣（なるげ あい）  
Email: gente8ngw@gmail.com 
GitHub: https://github.com/ai-n880811


## ライセンス

MIT License


## 必須機能
- メニューの表示  
- ユーザーの注文入力  
  - 商品番号を入力して商品をカートに追加  
  - 注文が終わるまで繰り返し注文を受付ける  
  - `0` を入力すると注文完了  
- 合計金額と注文内容の表示


## 追加した機能・工夫したポイント

### 発展課題
- 注文1回ごとに1ポイント加算  
- 5ポイントたまると、ドリンク1杯が無料でカートに追加されます  
- 合計金額の表示時に無料分の個数も明示  

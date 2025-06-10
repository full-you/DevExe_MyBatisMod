package jp.co.tmovie.main;

import java.util.Scanner;

import jp.co.tmovie.logic.SearchCinemaInformationLogic;

/**
 * 映画上映管理プログラムの開始クラス
 * 
 * @author d-konishi
 */
public class EntryPointMain {
	// 機能選択メニューの上映スケジュール表示の番号を定める定数
	private static final String MENU_SCHEDULE = "1";
	// 機能選択メニューの終了の番号を定める定数
	private static final String MENU_END = "9";

	/**
	 * 映画上映管理プログラムの開始メソッド
	 * 
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		/**
		 * メニューを表示して入力を受け取る。
		 * 「上映スケジュール表示」が入力されたらLogicを呼び出す。
		 */
		// メニュー表示フラグ
		boolean menuFlg = false;

		// メニューでの文字入力を受け取るScanner
		Scanner menuScanner = new Scanner(System.in);

		// メニュー表示フラグがfalseの場合、ループ
		while (menuFlg == false) {
			// 機能選択メニューを表示する
			System.out.println("**************************");
			System.out.println("メニューを選択してください");
			System.out.println("1：上映スケジュール表示");
			System.out.println("9：終了");
			System.out.print("入力：");
			// 入力を受け取る
			String selectMenu = menuScanner.nextLine();

			// 入力値によって分岐する
			// 入力値が1（上映スケジュール表示）か9（終了）のいずれかと等しい、 正しい値か判定
			if (MENU_SCHEDULE.equals(selectMenu) || MENU_END.equals(selectMenu)) {
				// 入力値が定数 MENU_END と等しいならメニュー表示フラグに true,
				// それ以外なら上映スケジュール表示
				if (MENU_END.equals(selectMenu)) {
					// メニュー表示フラグに true 
					menuFlg = true;
				} else {
					// 上映スケジュール表示し、flgを更新
					menuFlg = new SearchCinemaInformationLogic().execute();
				}
			} else {
				// 正しい入力値じゃないならメッセージを表示
				System.out.println("値が正しくありません\r\n有効な値を入力してください");
			}
		}
		// 終了メッセージを表示
		System.out.println("**************************");
		System.out.println("システムを終了しました");

		// Scannerは処理の一番最後で一度だけ閉じる
		// 処理途中で閉じるとSystem.inが閉じてしまい、再度開くことができなくなるため
		menuScanner.close();
	}
}

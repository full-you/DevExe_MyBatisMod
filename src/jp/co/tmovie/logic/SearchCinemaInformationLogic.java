package jp.co.tmovie.logic;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import jp.co.tmovie.dto.SearchCinemaInformationDTO;
import jp.co.tmovie.mybatis.MyBatisDataBaseManager;
import jp.co.tmovie.mybatis.mapper.SearchCinemaInformation;

/**
* 劇場IDを検索し、上映スケジュールを表示するクラス
* @author y-oofuji
*/
public class SearchCinemaInformationLogic {

	/* メニュー番号を指定する定数
	 * メニュー番号が0のとき、メニューに戻る
	 * メニュー番号が9のとき、システムを終了する
	 * */
	private static final String BACK_MENU = "0";
	private static final String END_SYSTEM = "9";

	/**
	 * 検索処理を実行し、メニューの表示フラグの値を返すメソッド
	 * @throws IOException 
	 */
	public boolean execute() throws IOException {

		// 文字入力を受け取る変数scannerを宣言
		@SuppressWarnings("resource") // 「scannerが閉じられることはありません」ワーニングが出ないようにするアノテーション
		Scanner scanner = new Scanner(System.in);

		//劇場ID入力画面の表示
		System.out.println("**************************");
		System.out.println("劇場IDを入力してください");
		System.out.print("入力:");

		//String型の変数searchIDに入力された値を代入する
		String searchID = scanner.nextLine();

		// ★修正前 start
//		// DAOのインスタンスを生成
//		SearchCinemaInformationDAO dao = new SearchCinemaInformationDAOImpl();
//
//		// DAOをインスタンス化
//		List<SearchCinemaInformationDTO> movieInfoDtoList = dao.searchCinemaInformation(searchID);
		// ★修正前 end

		// ★修正後 start
		// SqlSessionからMapperを取得
		SearchCinemaInformation mapper = MyBatisDataBaseManager.getSession().getMapper(SearchCinemaInformation.class);
		// 映画情報の取得
		List<SearchCinemaInformationDTO> movieInfoDtoList = mapper.selectTheaterInfo(searchID);
		// ★修正後 end
		
		//リストが空のとき、画面表示をする
		if (movieInfoDtoList.isEmpty()) {
			System.out.println("該当する上映スケジュールはありません");
		}

		//リストにデータが格納されているとき、上映スケジュールを表示する
		else {

			//劇場名、上映開始日、スクリーン名、上映開始時間、映画名を表示
			for (SearchCinemaInformationDTO info : movieInfoDtoList) {
				System.out.println(info.getTheaterNm() + "|" + info.getMovieStartDt() + "|" + info.getScreenNm() + "|"
						+ info.getMovieStartTm() + "|" + info.getMovieNm());
			}
		}

		//初期値falseの再表示フラグ
		boolean joueiFlg = false;

		//メニュー番号初期化
		String scanNum = "";

		//再表示フラグがtrueになるまでループ
		while (joueiFlg == false) {

			//メニューの再表示選択
			System.out.println("0:メニューに戻る");
			System.out.println("9:終了");
			System.out.print("入力:");

			//メニュー番号の入力
			scanNum = scanner.nextLine();

			//入力された数字が0(メニューに戻る)か9(システムを終了する)なら再表示フラグをtrueに設定
			if (scanNum.equals(BACK_MENU) || scanNum.equals(END_SYSTEM)) {
				joueiFlg = true;
			}

			//入力された数字が0(メニューに戻る)と9(システムを終了する)以外なら、画面表示をし、メニュー番号の入力に戻る
			else {
				System.out.println("値が正しくありません");
				System.out.println("有効な値を入力してください");
			}
		}

		//初期値falseの表示フラグ
		boolean menuFlg = false;

		//メニュー番号が9(終了)なら表示フラグをtrueに設定
		if (scanNum.equals(END_SYSTEM)) {
			menuFlg = true;
		}

		//表示フラグを返す
		return menuFlg;
	}
}
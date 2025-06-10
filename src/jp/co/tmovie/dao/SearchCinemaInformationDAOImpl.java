package jp.co.tmovie.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.tmovie.common.database.DataBaseManager;
import jp.co.tmovie.dto.SearchCinemaInformationDTO;
 
/**
* 映画館の情報の検索で使うDAO
* @author hay-aoki tat-oonishi
*/
public class SearchCinemaInformationDAOImpl implements SearchCinemaInformationDAO {
	/**
	 * SQLを組み立てて発行する。
	 * 取得したテーブルデータをDTOに格納してReturnする。
	 * @author hay-aoki,tat-oonishi
	 * @Override オーバーライドしたメソッドであることを明示するアノテーション
	 */
	public List<SearchCinemaInformationDTO> searchCinemaInformation(String theaterId) {
		// DBインスタンスを取得する
		DataBaseManager dbManager = DataBaseManager.getInstance();
		// DBコネクションを取得する
		Connection dbConnection = dbManager.getConnection();
		// SQLの結果を格納するリストを作成
		List<SearchCinemaInformationDTO> dtoList = new ArrayList<SearchCinemaInformationDTO>();
 
		try {
			// 上映情報を取得するSQL			
			String sql = "SELECT"
					+ " THEATER_INFO.theater_nm,"
					+ " SHOWING_MNG.movie_start_dt,"
					+ " SCREEN_INFO.screen_nm,"
					+ " SHOWING_MNG.movie_start_tm,"
					+ " MOVIE_INFO.movie_nm"
					+ " FROM"
					+ " SHOWING_MNG"
					+ " JOIN THEATER_INFO ON SHOWING_MNG.theater_id = THEATER_INFO.theater_id"
					+ " JOIN SCREEN_INFO ON SHOWING_MNG.screen_id = SCREEN_INFO.screen_id"
					+ " JOIN MOVIE_INFO ON SHOWING_MNG.movie_id = MOVIE_INFO.movie_id"
					+ " WHERE THEATER_INFO.theater_id = ?"
					+ " AND SHOWING_MNG.movie_start_dt = CURRENT_DATE"
					+ " AND SHOWING_MNG.movie_start_tm >= CURRENT_TIMESTAMP"
					+ " ORDER BY screen_nm, movie_start_tm, movie_nm;";
 
			// SQLのインスタンスを生成する
			PreparedStatement statement = dbConnection.prepareStatement(sql);
 
			// パラメーターを設定する
			statement.setString(1, theaterId);
 
			// SQLを実行する
			ResultSet result = statement.executeQuery();
 
			// ResultSetからDTOへデータを格納する
			while (result.next()) {
				SearchCinemaInformationDTO dto = new SearchCinemaInformationDTO();
				dto.setTheaterNm(result.getString("theater_nm"));
				dto.setMovieStartDt(result.getString("movie_start_dt"));
				dto.setScreenNm(result.getString("screen_nm"));
				dto.setMovieStartTm(result.getString("movie_start_tm"));
				dto.setMovieNm(result.getString("movie_nm"));
				dtoList.add(dto);
			}
			// 例外情報を標準エラー出力に出力
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DTOに格納されたデータを返却
		return dtoList;
	}
}
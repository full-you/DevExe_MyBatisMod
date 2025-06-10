package jp.co.tmovie.dto;

/**
 * 映画館の情報の検索で使うDTO
 * @author a-kai
 */
public class SearchCinemaInformationDTO {
	/**劇場名*/
	private String theaterNm;
	/**上映開始日*/
	private String movieStartDt;
	/**スクリーン名*/
	private String screenNm;
	/**上映開始時間*/
	private String movieStartTm;
	/**映画名*/
	private String movieNm;
	/**劇場ID*/
	private String theaterId;
	/**上映回数*/
	private String movieCount;

	/**
	 * 劇場名を取得
	 * @return theaterNm
	 */
	public String getTheaterNm() {
		return theaterNm;
	}

	/**
	 * 劇場名を設定
	 * @param theaterNm セットする theaterNm
	 */
	public void setTheaterNm(String theaterNm) {
		this.theaterNm = theaterNm;
	}

	/**
	 * 上映開始日を取得
	 * @return movieStartDt
	 */
	public String getMovieStartDt() {
		return movieStartDt;
	}

	/**
	 * 上映開始日を設定
	 * @param movieStartDt セットする movieStartDt
	 */
	public void setMovieStartDt(String movieStartDt) {
		this.movieStartDt = movieStartDt;
	}

	/**
	 * スクリーン名を取得
	 * @return screenNm
	 */
	public String getScreenNm() {
		return screenNm;
	}

	/**
	 * スクリーン名を設定
	 * @param screenNm セットする screenNm
	 */
	public void setScreenNm(String screenNm) {
		this.screenNm = screenNm;
	}

	/**
	 * 上映開始時間を取得
	 * @return movieStartTm
	 */
	public String getMovieStartTm() {
		return movieStartTm;
	}

	/**
	 * 上映開始時間を設定
	 * @param movieStartTm セットする movieStartTm
	 */
	public void setMovieStartTm(String movieStartTm) {
		this.movieStartTm = movieStartTm;
	}

	/**
	 * 映画名を取得
	 * @return movieNm
	 */
	public String getMovieNm() {
		return movieNm;
	}

	/**
	 * 映画名を設定
	 * @param movieNm セットする movieNm
	 */
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	/**
	 * 劇場IDを取得
	 * @return theaterId
	 */
	public String getTheaterId() {
		return theaterId;
	}

	/**
	 * 劇場IDを設定
	 * @param theaterId セットする theaterId
	 */
	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	/**
	 * 上映回数を取得
	 * @return movieCount
	 */
	public String getMovieCount() {
		return movieCount;
	}

	/**
	 * 上映回数を設定
	 * @param movieCount セットする movieCount
	 */
	public void setMovieCount(String movieCount) {
		this.movieCount = movieCount;
	}

}

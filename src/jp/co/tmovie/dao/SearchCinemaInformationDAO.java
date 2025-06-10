package jp.co.tmovie.dao;

import java.util.List;

import jp.co.tmovie.dto.SearchCinemaInformationDTO;
/**
 * DAOのinterface。
 * @author hay-aoki
 */
public interface SearchCinemaInformationDAO {
	/**
	 * 劇場IDの入力を引数として使用
	 * @author hay-aoki
	 */
	public List<SearchCinemaInformationDTO> searchCinemaInformation(String theaterId);
}

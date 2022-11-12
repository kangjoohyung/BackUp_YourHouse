package mvc.dao.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.AdminTongyeDTO;

/**
 * 
 * 통계 관리 DAO
 * 
 * 매출금액, 매출수량 + 입력된 DB정보로 출력하는 레코드 
 * 
--필터링 정리 - 다음중 하나씩만 선택가능/ 기본선택 맨 앞 / 반드시 입력
--조회범위 : 상품전체:PrAll / 특정카테고리(카테고리코드 입력):CaAll / 특정상품(상품코드 입력):Prod
--출력범위 : 매출통계만:Sum / 매출+상품정보:Pro
--시간범위 : (yyyymmdd 형식) 시작일-변수명:startDate , 마지막일 (하루면 동일 날짜)-변수명:lastDate
-->메소드 총 6개가 나옴
 * 
 * @author 강주형
 *
 */
public interface AdminTongyeDAO {

	/**
	 * 메인 누적매출순 한달기준
	 */
	List<AdminTongyeDTO> selectTongyeMain() throws SQLException;
	
	/**
	 * 1. 기본 : 상품전체 / 매출통계만
	 */
	List<AdminTongyeDTO> selectTongyePrAllSum(String startDate, String lastDate) throws SQLException;
	
	/**
	 * 2. 상품전체 / 상품정보
	 */
	List<AdminTongyeDTO> selectTongyePrAllPro(String startDate, String lastDate) throws SQLException;
	
	/**
	 * 3. 특정 카테고리 / 매출통계만
	 */
	List<AdminTongyeDTO> selectTongyeCaAllSum(int categoryCode, String startDate, String lastDate) throws SQLException;
	
	/**
	 * 4. 특정 카테고리 / 상품정보
	 */
	List<AdminTongyeDTO> selectTongyeCaAllPro(int categoryCode, String startDate, String lastDate) throws SQLException;
	
	/**
	 * 5. 특정 상품 / 매출통계만
	 */
	List<AdminTongyeDTO> selectTongyeProdSum(int productCode, String startDate, String lastDate) throws SQLException;
	
	/**
	 * 6. 특정 상품 / 상품정보
	 */
	List<AdminTongyeDTO> selectTongyeProdPro(int productCode, String startDate, String lastDate) throws SQLException;

}

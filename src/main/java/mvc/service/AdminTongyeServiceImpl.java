package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.AdminTongyeDAO;
import mvc.dao.product.AdminTongyeDAOImpl;
import mvc.dto.product.AdminTongyeDTO;

public class AdminTongyeServiceImpl implements AdminTongyeService {

	private AdminTongyeDAO adminTongyeDAO=new AdminTongyeDAOImpl();
	
	@Override
	public List<AdminTongyeDTO> selectTongyeMain() throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyeMain();
		
		return adminTongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyePrAllSum(String startDate, String lastDate) throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜를 입력해주세요");
		
		return adminTongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyePrAllPro(String startDate, String lastDate) throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜를 입력해주세요");
		
		return adminTongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeCaAllSum(int categoryCode, String startDate, String lastDate)
			throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜를 입력해주세요");
		
		return adminTongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeCaAllPro(int categoryCode, String startDate, String lastDate)
			throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜를 입력해주세요");
		
		return adminTongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeProdSum(int productCode, String startDate, String lastDate) throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜를 입력해주세요");
		
		return adminTongyeList;
	}

	@Override
	public List<AdminTongyeDTO> selectTongyeProdPro(int productCode, String startDate, String lastDate)
			throws SQLException {
		List<AdminTongyeDTO> adminTongyeList=adminTongyeDAO.selectTongyePrAllPro(startDate, lastDate);
		
		if(adminTongyeList==null) throw new SQLException("정보가 없습니다");
		if(startDate==null||lastDate==null) throw new SQLException("날짜를 입력해주세요");
		
		return adminTongyeList;
	}

}

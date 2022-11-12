package mvc.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dto.product.ColorDTO;
import mvc.util.DBUtil;

public class ColorDAOImpl implements ColorDAO {

	@Override
	public List<ColorDTO> selectByProductCode(int productCode) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ColorDTO> list = new ArrayList<ColorDTO>();
		String sql = "select * from color where product_code=?";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ColorDTO(rs.getInt(1), rs.getInt(2), rs.getString(3)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}

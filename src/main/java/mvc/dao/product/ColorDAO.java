package mvc.dao.product;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.product.ColorDTO;

public interface ColorDAO {

	List<ColorDTO> selectByProductCode(int productCode) throws SQLException;
}

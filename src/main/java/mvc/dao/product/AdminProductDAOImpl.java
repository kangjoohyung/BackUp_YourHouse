package mvc.dao.product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mvc.util.DBUtil;
import mvc.dto.product.AdminTongyeDTO;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductDTO;
import mvc.dto.product.ProductImageDTO;

/**
 * dbAdminProductQuery.properties사용
 * 
 * 관리자 상품관리 DAO (상품상세페이지 관리)
 * 
 * : 상품,카테고리,색상,상품사진 테이블 관리
 * ->등록,수정,삭제,조회
 * 
 * ->상품:품절==재고량0, 삭제==재고량-1  
 *       조회-> 상품코드에 해당하는 상품 정보만 검색
 * @author 강주형
 *
 */
public class AdminProductDAOImpl implements AdminProductDAO {
	
	private Properties proFile = new Properties();
	
	public AdminProductDAOImpl() {
		
		try {
			//dbQuery를 준비한 ~.properties파일을 로딩해서 Properties 자료구조에 저장한다.
			
			//현재 프로젝트가 런타임(실행)될때, 즉 서버가 실행될때 classes폴더의 위치를
			//동적으로 가져와서 경로를 설정해야한다.
			InputStream is = getClass().getClassLoader().
					getResourceAsStream("dbAdminProductQuery.properties");
			proFile.load(is);
			
			//System.out.println("출력확인용" +proFile.getProperty("product.selectAll"));
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@Override
	public int insertTotalProduct(AdminTongyeDTO product, ColorDTO color, ProductImageDTO productImage) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("product.insertAll");
		//insert into product(product_code, category_code, product_name, image, created_reg, product_detail, stock, price) values ( product_seq.nextval , ? , ? , ? , sysdate+9/24 , ? , ? , ? )
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);//트랜잭션 처리위해 오토커밋끄기
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getCategoryCode());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getImage());
			ps.setString(4, product.getProductDetail());
			ps.setInt(5, product.getStock());
			ps.setInt(6, product.getPrice());
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("상품등록에 실패하였습니다");
			}else { //색상,사진등록
				if(color!=null) {
				this.insertTotalColor(con, color);//색상호출
				}
				if(productImage!=null) {
				this.insertTotalProductImage(con, productImage);//사진호출
				}
				con.commit();
			}
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 통합등록용-색상(상품->색상) 
	 */
	public int insertTotalColor(Connection con, ColorDTO color) throws SQLException {
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("color.insertTotal");
		//insert into color(color_code, product_code, color_name) values( color_seq.nextval, product_seq.currval , ? )
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, color.getColorName());
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("색상등록에 실패하였습니다");
			}
		}finally {
			DBUtil.dbClose(null, ps);
		}
		return result;
	}
	
	/**
	 * 통합등록용-상품사진 (상품->상품사진)
	 */
	public int insertTotalProductImage(Connection con, ProductImageDTO productImage) throws SQLException {
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("productImage.insertTotal");
		//insert into product_image(image_code, product_code, file_name) values( product_image_seq.nextval, product_seq.currval , ? )
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, productImage.getFileName());
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("사진등록에 실패하였습니다");
			}
		}finally {
			DBUtil.dbClose(null, ps);
		}
		return result;
	}

	@Override
	public int insertProduct(AdminTongyeDTO product) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("product.insertAll");
		//insert into product(product_code, category_code, product_name, image, created_reg, product_detail, stock, price) values ( product_seq.nextval , ? , ? , ? , sysdate , ? , ? , ? )
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getCategoryCode());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getImage());
			ps.setString(4, product.getProductDetail());
			ps.setInt(5, product.getStock());
			ps.setInt(6, product.getPrice());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int updateProductByProductCode (AdminTongyeDTO product, ProductImageDTO productImage ) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		if(product.getImage()==null) { //아래로 연결이 안되어 우선 이곳에서 처리
			String sql= proFile.getProperty("product.updateNullImage");
			//update product set category_code = ? , product_name = ? , product_detail = ? , stock = ? , price = ? where product_code = ?
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, product.getCategoryCode());
				ps.setString(2, product.getProductName());
				ps.setString(3, product.getProductDetail());
				ps.setInt(4, product.getStock());
				ps.setInt(5, product.getPrice());
				ps.setInt(6, product.getProductCode());
				
				result = ps.executeUpdate();
			}finally {
				DBUtil.dbClose(con, ps);
			}
		}else if(product.getImage()!=null){
			String sql= proFile.getProperty("product.updateAll");
			//update product set category_code = ? , product_name = ? , image = ? , product_detail = ? , stock = ? , price = ? where product_code = ?
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setInt(1, product.getCategoryCode());
				ps.setString(2, product.getProductName());
				ps.setString(3, product.getImage());
				ps.setString(4, product.getProductDetail());
				ps.setInt(5, product.getStock());
				ps.setInt(6, product.getPrice());
				ps.setInt(7, product.getProductCode());
				
				result = ps.executeUpdate();
			}finally {
				DBUtil.dbClose(con, ps);
			}
		}
		if(productImage.getFileName()!=null){
			this.updateConnectImage(productImage);
		}
		 
		return result;
	}

	@Override
	public int updateConnectImage(ProductImageDTO productImage) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("productImage.updateByCode");
		//update product_image set file_name = ? where image_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productImage.getFileName());
			ps.setInt(2, productImage.getImageCode());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int updateProductNullImageByProductCode(AdminTongyeDTO product) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("product.updateNullImage");
		//update product set category_code = ? , product_name = ? , product_detail = ? , stock = ? , price = ? where product_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, product.getCategoryCode());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductDetail());
			ps.setInt(4, product.getStock());
			ps.setInt(5, product.getPrice());
			ps.setInt(6, product.getProductCode());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public int updateProductStockByProductCode(int stock, int productCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("product.updateStock");
		//update product set stock = ? where product_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, productCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public AdminTongyeDTO selectProductByProductCode(int productCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		AdminTongyeDTO product = null;
		
		String sql= proFile.getProperty("product.selectByProductCode");//카테고리 이름도 나오게 join사용
		//select product_code, category_code, product_name, image, created_reg, product_detail, stock, price, category_name from product join product_category using(category_code) where product_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				product = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getInt(8), rs.getString(9));

			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return product;
	}

	@Override
	public List<AdminTongyeDTO> selectAllProduct() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AdminTongyeDTO> productList = new ArrayList<AdminTongyeDTO>();
		
		String sql= proFile.getProperty("product.selectAll");//카테고리 이름도 나오게 join사용
		//select product_code, category_code, product_name, image, created_reg, product_detail, stock, price, category_name from product join product_category using(category_code) order by created_reg desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminTongyeDTO product = new AdminTongyeDTO(rs.getInt(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),
						rs.getInt(8), rs.getString(9));
				
				productList.add(product);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return productList;
	}

	@Override
	public List<ProductCategoryDTO> selectAllProductCategory() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ProductCategoryDTO> productCategoryList = new ArrayList<ProductCategoryDTO>();
		
		String sql= proFile.getProperty("productCategory.selectAll");
		//select * from product_category order by category_code
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductCategoryDTO productCategory = 
				new ProductCategoryDTO(rs.getInt(1), rs.getString(2));
				
				productCategoryList.add(productCategory);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return productCategoryList;
	}

	@Override
	public ProductCategoryDTO selectProductCategoryByCategoryCode(int productCategoryCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProductCategoryDTO productCategory=null;
		
		String sql= proFile.getProperty("productCategory.selectByCode");
		//select * from product_category where category_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCategoryCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				productCategory = 
				new ProductCategoryDTO(rs.getInt(1), rs.getString(2));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return productCategory;
	}

	@Override
	public int insertProductCategory(ProductCategoryDTO productCategory) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("productCategory.insert");
		//insert into product_category values (product_category_seq.nextval, ? )
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productCategory.getCategoryName());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int updateProductCategoryByCategoryCode(int productCategoryCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		ProductCategoryDTO productCategory = new ProductCategoryDTO();
		String sql= proFile.getProperty("productCategory.updateByCode");
		//update product_category set category_name = ? where category_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCategory.getCategoryCode());
			ps.setInt(2, productCategoryCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insertColor(ColorDTO color) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("color.insert");
		//insert into color(color_code, product_code, color_name) values( color_seq.nextval, ? , ? )
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, color.getProductCode());
			ps.setString(2, color.getColorName());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int updateColorByColorCode(int colorCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		ColorDTO color = new ColorDTO();
		String sql= proFile.getProperty("color.updateByCode");
		//update color set color_name = ? where color_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, color.getColorName());
			ps.setInt(2, colorCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int deleteColorByColorCode(int colorCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("color.deleteByCode");
		//delete from color where color_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, colorCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public ColorDTO selectColorByColorCode(int colorCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ColorDTO color=null;
		
		String sql= proFile.getProperty("color.selectByCode");
		//select * from color where color_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, colorCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				color = 
				new ColorDTO(rs.getInt(1), rs.getInt(2), rs.getString(2));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return color;
	}

	@Override//
	public List<ColorDTO> selectAllColorByProductCode(int productCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ColorDTO> colorList = new ArrayList<ColorDTO>();
		
		String sql= proFile.getProperty("color.selectAllByProductCode");
		//select * from color where product_code = ? order by color_code;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);
			rs = ps.executeQuery();
			while(rs.next()) {
				ColorDTO color = 
				new ColorDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				
				colorList.add(color);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return colorList;
	}


	@Override
	public int insertProductImage(ProductImageDTO productImage) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("productImage.insert");
		//insert into product_image(image_code, product_code, file_name) values( image_code_seq.nextval, ? , ? )
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productImage.getProductCode());
			ps.setString(2, productImage.getFileName());
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int deleteProductImageByProductImageCode(int productImageCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql= proFile.getProperty("productImage.deleteByCode");
		//delete from product_image where image_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productImageCode);
			
			result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public List<ProductImageDTO> selectAllProductImageByProductCode(int productCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ProductImageDTO> productImageList = new ArrayList<ProductImageDTO>();
		
		String sql= proFile.getProperty("productImage.selectAllByProductCode");
		//select * from product_image where product_code = ? order by image_code desc
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productCode);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductImageDTO productImage = 
				new ProductImageDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				
				productImageList.add(productImage);
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return productImageList;
	}

	@Override
	public ProductImageDTO selectProductImageByProductImageCode(int productImageCode) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ProductImageDTO productImage=null;
		
		String sql= proFile.getProperty("productImage.selectByCode");
		//select * from product_image where image_code = ?
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, productImageCode);
			rs = ps.executeQuery();
			if(rs.next()) {
				productImage = 
				new ProductImageDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
			}
		}finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return productImage;
	}

}

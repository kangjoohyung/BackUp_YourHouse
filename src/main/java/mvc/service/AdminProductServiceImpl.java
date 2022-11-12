package mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import mvc.dao.product.AdminProductDAO;
import mvc.dao.product.AdminProductDAOImpl;
import mvc.dto.product.AdminTongyeDTO;
import mvc.dto.product.ColorDTO;
import mvc.dto.product.ProductCategoryDTO;
import mvc.dto.product.ProductImageDTO;

public class AdminProductServiceImpl implements AdminProductService {
	
	private AdminProductDAO adminProductDAO = new AdminProductDAOImpl();
	
	@Override
	public void insertTotalProduct(AdminTongyeDTO product, ColorDTO color, ProductImageDTO productImage) throws SQLException {
		int result = adminProductDAO.insertTotalProduct(product, color, productImage);
		
		if(result==0)throw new SQLException("등록에 실패했습니다");

	}
	
	@Override
	public void insertProduct(AdminTongyeDTO product) throws SQLException {
		int result = adminProductDAO.insertProduct(product);
		
		if(result==0)throw new SQLException("등록에 실패했습니다");
	}

	@Override
	public void insertColor(ColorDTO color) throws SQLException {
		int result = adminProductDAO.insertColor(color);
		
		if(result==0)throw new SQLException("등록에 실패했습니다");
	}

	@Override
	public void insertProductImage(ProductImageDTO productImage) throws SQLException {
		int result = adminProductDAO.insertProductImage(productImage);
		
		if(result==0)throw new SQLException("등록에 실패했습니다");
	}

	@Override
	public void insertProductCategory(ProductCategoryDTO productCategory) throws SQLException {
		int result=adminProductDAO.insertProductCategory(productCategory);

		if(result==0)throw new SQLException("등록에 실패했습니다");
	}

	@Override
	public void updateProductByProductCode(AdminTongyeDTO product, ProductImageDTO productImage, String saveDir) throws SQLException {
		AdminTongyeDTO dbProduct=adminProductDAO.selectProductByProductCode(product.getProductCode());
		
		if(dbProduct==null) throw new SQLException("상품을 찾을수 없습니다");
		
		else if(dbProduct.getProductCode()!=product.getProductCode()) throw new SQLException("상품번호가 다르게 입력됐습니다");
		
		if(adminProductDAO.updateProductByProductCode(product, productImage)==0) throw new SQLException("상품정보 변경을 실패하였습니다");
		
		//변경이 되었을대 기존 파일은 save폴더에서 삭제한다.
		if(dbProduct.getImage()!=product.getImage()) {
			String fileName = saveDir+"/"+ dbProduct.getImage();
			new File(fileName).delete();
		}
		
		ProductImageDTO dbProductImage=adminProductDAO.selectProductImageByProductImageCode(productImage.getImageCode());
		//변경이 되었을대 기존 파일은 save폴더에서 삭제한다.
		if(dbProductImage.getFileName()!=dbProductImage.getFileName()) {
			String fileName = saveDir+"/"+ dbProductImage.getFileName();
			new File(fileName).delete();
		}
	}
	
	@Override
	public void updateProductNullImageByProductCode(AdminTongyeDTO product, String saveDir) throws SQLException {
		AdminTongyeDTO dbProduct=adminProductDAO.selectProductByProductCode(product.getProductCode());
		
		if(dbProduct==null) throw new SQLException("상품을 찾을수 없습니다");
		
		else if(dbProduct.getProductCode()!=product.getProductCode()) throw new SQLException("상품번호가 다르게 입력됐습니다");
		
		if(adminProductDAO.updateProductByProductCode(product, null)==0) throw new SQLException("상품정보 변경을 실패하였습니다");
	}

	@Override
	public void updateProductStockByProductCode(int productCode, int stock) throws SQLException {
		AdminTongyeDTO dbProduct=adminProductDAO.selectProductByProductCode(productCode);
		
		if(dbProduct==null) throw new SQLException("상품을 찾을수 없습니다");
		
		else if(dbProduct.getProductCode()!=productCode) throw new SQLException("상품번호가 다르게 입력됐습니다");
		
		if(adminProductDAO.updateProductStockByProductCode(productCode, stock)==0) throw new SQLException("상품정보 변경을 실패하였습니다");
	}

	@Override
	public void deleteColorByColorCode(int colorCode) throws SQLException {
		ColorDTO dbColor=adminProductDAO.selectColorByColorCode(colorCode);
		
		if(dbColor==null) throw new SQLException("색상 정보를 찾을수 없습니다");
		
		if(adminProductDAO.deleteColorByColorCode(colorCode)==0) throw new SQLException("색상 삭제를 실패하였습니다");
	}

	@Override//
	public void deleteProductImageByProductImageCode(int productImageCode, String saveDir) throws SQLException {
		ProductImageDTO dbImage=adminProductDAO.selectProductImageByProductImageCode(productImageCode);
		
		if(dbImage==null) throw new SQLException("색상 정보를 찾을수 없습니다");
		
		if(adminProductDAO.deleteProductImageByProductImageCode(productImageCode)==0) throw new SQLException("색상 삭제를 실패하였습니다");
		
		//삭제가 되었을때 save폴더에서 파일도 삭제한다. 
		//db에서 not null이지만 업그레이드등의 경우를 대비해 not null조건문으로 두었다.
		if(dbImage.getFileName()!=null) {
			String fileName = saveDir+"/"+ dbImage.getFileName();
			new File(fileName).delete();
		}
	}
	
	@Override
	public void deleteCategoryByCategoryCode(int categoryCode) throws SQLException {
		ProductCategoryDTO dbCategory=adminProductDAO.selectProductCategoryByCategoryCode(categoryCode);
		
		if(dbCategory==null) throw new SQLException("색상 정보를 찾을수 없습니다");
		
		if(adminProductDAO.deleteProductImageByProductImageCode(categoryCode)==0) throw new SQLException("색상 삭제를 실패하였습니다");
	}

	@Override
	public List<AdminTongyeDTO> selectAllProduct() throws SQLException {
		List<AdminTongyeDTO> productList=adminProductDAO.selectAllProduct();
		
		if(productList==null) throw new SQLException("상품정보를 찾을수 없습니다");
		
		return productList;
	}

	@Override
	public AdminTongyeDTO selectProductByProductCode(int productCode) throws SQLException {
		AdminTongyeDTO product=adminProductDAO.selectProductByProductCode(productCode);
		
		if(product==null) throw new SQLException("상품정보를 찾을수 없습니다");
		
		return product;
	}

	@Override
	public ProductImageDTO selectProductImageByProductImageCode(int productImageCode) throws SQLException {
		ProductImageDTO productImage=adminProductDAO.selectProductImageByProductImageCode(productImageCode);
		
		if(productImage==null) throw new SQLException("사진정보를 찾을수 없습니다");
		
		return productImage;
	}

	@Override
	public List<ProductImageDTO> selectAllProductImageByProductCode(int productCode) throws SQLException {
		List<ProductImageDTO> imageList=adminProductDAO.selectAllProductImageByProductCode(productCode);
		
		if(imageList==null) throw new SQLException("사진정보를 찾을수 없습니다");
		
		return imageList;
	}

	@Override
	public ColorDTO selectColorByColorCode(int colorCode) throws SQLException {
		ColorDTO color=adminProductDAO.selectColorByColorCode(colorCode);
		
		if(color==null) throw new SQLException("색상정보를 찾을수 없습니다");
		
		return color;
	}

	@Override
	public List<ColorDTO> selectAllColorByProductCode(int productCode) throws SQLException {
		List<ColorDTO> colorList=adminProductDAO.selectAllColorByProductCode(productCode);
		
		if(colorList==null) throw new SQLException("색상정보를 찾을수 없습니다");
		
		return colorList;
	}
	@Override
	public ProductCategoryDTO selectProductCategoryByCategoryCode(int productCategoryCode) throws SQLException {
		ProductCategoryDTO productCategory=adminProductDAO.selectProductCategoryByCategoryCode(productCategoryCode);
		
		if(productCategory==null) throw new SQLException("카테고리를 찾을수 없습니다");
		
		return productCategory;
	}

	@Override
	public List<ProductCategoryDTO> selectAllProductCategory() throws SQLException {
		List<ProductCategoryDTO> categoryList=adminProductDAO.selectAllProductCategory();
		
		if(categoryList==null) throw new SQLException("카테고리를 찾을수 없습니다");
		
		return categoryList;
	}

	@Override
	public void updateProductCategoryByCategoryCode(int productCategoryCode) throws SQLException {
		ProductCategoryDTO dbCategory=adminProductDAO.selectProductCategoryByCategoryCode(productCategoryCode);
		
		if(dbCategory==null) throw new SQLException("카테고리를 찾을수 없습니다");
		
		else if(dbCategory.getCategoryCode()!=productCategoryCode) throw new SQLException("카테고리코드가 다르게 입력됐습니다");
		
		if(adminProductDAO.updateProductCategoryByCategoryCode(productCategoryCode)==0) throw new SQLException("카테고리 변경을 실패하였습니다");
	}

}

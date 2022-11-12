package mvc.service.store;

import java.util.Map;

public interface StoreService {

	Map<String, Object> reUserProduct(int userCode) throws Exception;
}

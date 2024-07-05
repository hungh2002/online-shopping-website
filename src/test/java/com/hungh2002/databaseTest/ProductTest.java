package com.hungh2002.databaseTest;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import com.hungh2002.model.product.ProductDAO;

/**
 * QueryData
 */
public class ProductTest {

    @Test
    public void queryDataProduct() {
        ProductDAO productDAO = new ProductDAO();
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("column", "name");
        productDAO.queryData(data);

        data.put("column", "*");

        data.put("order-by", "name-desc");
        productDAO.queryData(data);

        data.remove("order-by");
        data.put("product-id", "4");
        productDAO.queryData(data);

        data.remove("product-id");
        data.put("limit", "2");
        productDAO.queryData(data);

        productDAO.close();
    }

}

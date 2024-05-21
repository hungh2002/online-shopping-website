package com.hungh2002.service.utils;

public class SQLStatement {

    public static String select(String column, String tableName, String orderByColumn,
            String sortOrder, String limit) {
        String orderByString;
        String limitString;

        if (limit == "") {
            limitString = "";
        } else {
            limitString = " LIMIT " + limit;
        }

        if (orderByColumn == "") {
            orderByString = "";
        } else {
            orderByString = " ORDER BY " + orderByColumn;
            if (sortOrder != "") {
                orderByString = " ORDER BY " + orderByColumn + " " + sortOrder;
            }
        }

        return "SELECT " + column + " FROM " + tableName + orderByString + " " + limitString;
    }
}

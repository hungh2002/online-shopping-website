package com.hungh2002.service.utils;

public class SQLStatement {

    public static String select(String column, String tableName, String orderByColumn,
            String sortOrder, String where, String limit) {
        String orderByString;
        String limitString;
        String whereString;

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

        if (where == "") {
            whereString = "";
        } else {
            whereString = " WHERE " + where;
        }

        return "SELECT " + column + " FROM " + tableName + orderByString + whereString
                + limitString;
    }



    public static String insert(String tableName, String column, String data) {


        return "INSERT INTO " + tableName + " (" + column + ") VALUES (" + data + ")";
    }
}

package com.hungh2002.service.utils.SQLUtils;

import java.util.Map;

public class SQLStatement {

    public static String select(Map<String, String> args) {

        String column = " * ";
        if (args.get("column") != null) {
            column = args.get("column");
        }

        String table = args.get("table");

        String orderBy;
        if (args.get("order-by") != null) {
            orderBy = " ORDER BY " + args.get("order-by").replace("-", " ");
        } else {
            orderBy = "";
        }

        String condition;
        if (args.get("condition") != null) {
            condition = " WHERE " + args.get("condition");
        } else {
            condition = "";
        }

        String limit = "";
        if (args.get("limit") != null) {
            limit = " LIMIT " + args.get("limit");
        }

        return " SELECT " + column + " FROM " + table + orderBy + limit + condition;

    }

    public static String insert(Map<String, String> args) {

        String table = args.get("table");
        String column = args.get("column");
        String data = args.get("data");

        return "INSERT INTO " + table + " ( " + column + " ) VALUES ( " + data + " ) ";
    }

    public static String update(Map<String, String> args) {

        String table = args.get("table");
        String column = args.get("column");
        String condition = " WHERE " + args.get("condition");

        return "UPDATE " + table + " SET " + column + condition;
    }
}

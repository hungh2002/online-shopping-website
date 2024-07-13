package com.hungh2002.service.utils;

import java.util.Map;

public class SQLStatement {

    public static String select(Map<String, String> args) {

        String column;
        if (args.get("column") != null) {
            column = args.get("column");
        } else {
            column = " * ";
        }

        String table = args.get("table");

        String orderBy;
        if (args.get("order-by") != null) {
            orderBy = " ORDER BY " + args.get("order-by").replace("-", " ");
        } else {
            orderBy = "";
        }

        String where;
        String condition;
        if (args.get("condition") != null) {
            where = " WHERE ";
            condition = args.get("condition") + "=? ";
        } else {
            where = "";
            condition = "";
        }

        String limit;
        if (args.get("limit") != null) {
            limit = " LIMIT " + args.get("limit");
        } else {
            limit = "";
        }

        return " SELECT " + column + " FROM " + table + orderBy + limit + where + condition;

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
        String condition = args.get("condition");

        return "UPDATE " + table + " SET " + column + " =? " + " WHERE " + condition + " = ?";
    }
}

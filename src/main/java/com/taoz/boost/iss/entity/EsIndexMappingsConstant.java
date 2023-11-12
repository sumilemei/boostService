package com.taoz.boost.iss.entity;

/**
 * @author taozheng
 * @create 2023-11-12 2:20 下午
 * @introduce:
 */
public class EsIndexMappingsConstant {

    public static String NBA_MAPPINGS = " {\n" +
            " \"properties\": {\n" +
            " \"jerse_no\": {\n" +
            " \"type\": \"keyword\"\n" +
            " },\n" +
            " \"name\": {\n" +
            " \"type\": \"text\"\n" +
            " },\n" +
            " \"play_year\": {\n" +
            " \"type\": \"keyword\"\n" +
            " },\n" +
            " \"position\": {\n" +
            " \"type\": \"keyword\"\n" +
            " },\n" +
            " \"team_name\": {\n" +
            " \"type\": \"text\"\n" +
            " }\n" +
            " }\n" +
            " }";
}

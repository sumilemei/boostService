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


    public static String TEST_MAPPING = "{\n" +
            "      \"properties\" : {\n" +
            "        \"address\" : {\n" +
            "          \"type\" : \"keyword\",\n" +
            "          \"index\" : false\n" +
            "        },\n" +
            "        \"brand\" : {\n" +
            "          \"type\" : \"keyword\",\n" +
            "          \"copy_to\" : [\n" +
            "            \"searchFiled\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"business\" : {\n" +
            "          \"type\" : \"keyword\",\n" +
            "          \"copy_to\" : [\n" +
            "            \"searchFiled\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"city\" : {\n" +
            "          \"type\" : \"keyword\",\n" +
            "          \"copy_to\" : [\n" +
            "            \"searchFiled\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"id\" : {\n" +
            "          \"type\" : \"keyword\"\n" +
            "        },\n" +
            "        \"location\" : {\n" +
            "          \"type\" : \"geo_point\"\n" +
            "        },\n" +
            "        \"name\" : {\n" +
            "          \"type\" : \"text\",\n" +
            "          \"copy_to\" : [\n" +
            "            \"searchFiled\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"pic\" : {\n" +
            "          \"type\" : \"keyword\",\n" +
            "          \"index\" : false\n" +
            "        },\n" +
            "        \"price\" : {\n" +
            "          \"type\" : \"integer\",\n" +
            "          \"copy_to\" : [\n" +
            "            \"searchFiled\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"score\" : {\n" +
            "          \"type\" : \"integer\",\n" +
            "          \"copy_to\" : [\n" +
            "            \"searchFiled\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"searchFiled\" : {\n" +
            "          \"type\" : \"text\"\n" +
            "        },\n" +
            "        \"starName\" : {\n" +
            "          \"type\" : \"keyword\"\n" +
            "        }\n" +
            "      }\n" +
            "    }";
}

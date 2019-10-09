package com.example.myapplication.api;

public class ApiUrl {

    private static final String DOMAIN = "https://data.taipei/";

    public static final String GET_PAVILION_INFORMATION = DOMAIN + "opendata/datalist/apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a";

    public static final String GET_PLANT_INFORMATION = DOMAIN + "opendata/datalist/apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14";

    public static class createQueryData {
        public static String getUrl(String baseUrl, String query){
            StringBuilder builder = new StringBuilder();
            builder.append(baseUrl).append(ApiKey.AND).
                    append(ApiKey.QUERY).append(ApiKey.EQAUL).append(query);
            return builder.toString();
        }
    }
}

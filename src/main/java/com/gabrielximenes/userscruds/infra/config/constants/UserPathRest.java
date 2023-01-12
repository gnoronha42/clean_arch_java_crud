package com.gabrielximenes.userscruds.infra.config.constants;

public class UserPathRest {

    private UserPathRest() {
        throw new IllegalStateException("Utility class");
    }

    public static final String USER = "/user";
    public static final String USER_REGISTER = USER;
    public static final String USER_SEARCH = USER;
    public static final String USER_UPDATE = USER;
    public static final String USER_SEARCH_EMAIL = "/email/";
    public static final String USER_SEARCH_USERNAME = "/username/";
    public static final String USER_STATUS = USER + "/disable";
}

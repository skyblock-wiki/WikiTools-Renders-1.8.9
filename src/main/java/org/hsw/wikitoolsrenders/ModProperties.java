package org.hsw.wikitoolsrenders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModProperties {

    public static final String MOD_ID = "@MOD_ID@";
    public static final String MOD_VERSION = "@MOD_VERSION@";

    public static final String GITHUB_API_BASE_URL = "https://api.github.com";
    public static final String LATEST_RELEASE_PATH =
            "/repos/skyblock-wiki/wikitools-renders-1.8.9/releases/latest";
    public static final String LATEST_RELEASE_DOWNLOAD_URL =
            "https://github.com/skyblock-wiki/wikitools-renders-1.8.9/releases/latest";

    public static final String CATEGORY = "wikitoolsrenders.keybind.category";

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

}

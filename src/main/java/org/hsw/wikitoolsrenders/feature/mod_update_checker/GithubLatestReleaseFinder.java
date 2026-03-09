package org.hsw.wikitoolsrenders.feature.mod_update_checker;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.hsw.wikitoolsrenders.ModProperties;

import java.io.IOException;

public class GithubLatestReleaseFinder implements FindModVersion {

    private final String githubApiBaseUrl;

    public GithubLatestReleaseFinder(String githubApiBaseUrl) {
        this.githubApiBaseUrl = githubApiBaseUrl;
    }

    public FindModVersion.FindModVersionResult findLatestVersion() {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(githubApiBaseUrl + ModProperties.LATEST_RELEASE_PATH);
            request.addHeader("Accept", "application/vnd.github+json");

            HttpResponse result = httpClient.execute(request);
            String responseBody = EntityUtils.toString(result.getEntity(), "UTF-8");

            Release release = new Gson().fromJson(responseBody, Release.class);

            if (release == null || release.tag_name == null) {
                return FindModVersionResult.failure("Latest Release Fetch/Parse Failure (" + result.getStatusLine() + ")");
            }

            String latestVersionName = release.tag_name;

            return createValidVersionResult(latestVersionName);
        } catch (IOException ignored) {
            return FindModVersionResult.failure("Latest Release Fetch Failure");
        }
    }

    private static FindModVersionResult createValidVersionResult(String latestVersionName) {
        if (latestVersionName.startsWith("v")) {
            latestVersionName = latestVersionName.substring(1);
        }

        return FindModVersionResult.success(latestVersionName);
    }

    private static class Release {
        public String tag_name;
    }

}

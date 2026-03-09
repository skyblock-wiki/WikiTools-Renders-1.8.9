package org.hsw.wikitoolsrenders.feature.mod_update_checker;

import org.hsw.wikitoolsrenders.feature.mod_update_checker.FindModVersion;

public class LatestReleaseFinderStub implements FindModVersion {
    private final FindModVersionResult result;

    public LatestReleaseFinderStub(FindModVersionResult result) {
        this.result = result;
    }

    @Override
    public FindModVersionResult findLatestVersion() {
        return result;
    }
}

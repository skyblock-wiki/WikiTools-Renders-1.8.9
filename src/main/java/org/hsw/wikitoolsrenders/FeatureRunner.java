package org.hsw.wikitoolsrenders;

import org.hsw.wikitoolsrenders.feature.mod_update_checker.GetNewVersionHandler;
import org.hsw.wikitoolsrenders.feature.mod_update_checker.GithubLatestReleaseFinder;
import org.hsw.wikitoolsrenders.feature.mod_update_checker.ModUpdateChecker;
import org.hsw.wikitoolsrenders.feature.render_entity.listener.AddItemToEntityListener;
import org.hsw.wikitoolsrenders.feature.render_entity.listener.CopyFacingEntityListener;
import org.hsw.wikitoolsrenders.feature.render_entity.listener.RenderEntityListener;

public class FeatureRunner {
    private final AddItemToEntityListener addItemToEntityListener = new AddItemToEntityListener();
    private final CopyFacingEntityListener copyFacingEntityListener = new CopyFacingEntityListener();
    private final RenderEntityListener renderEntityListener = new RenderEntityListener();
    private final ModUpdateChecker modUpdateChecker = createModUpdateChecker();

    public FeatureRunner() {
        WikiToolsRendersKeybinds.init();
    }

    private static ModUpdateChecker createModUpdateChecker() {
        GithubLatestReleaseFinder githubLatestReleaseFinder = new GithubLatestReleaseFinder(
                WikiToolsRendersIdentity.GITHUB_API_BASE_URL
        );
        GetNewVersionHandler getNewVersionHandler = new GetNewVersionHandler(githubLatestReleaseFinder);
        return new ModUpdateChecker(getNewVersionHandler);
    }
}

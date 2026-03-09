package org.hsw.wikitoolsrenders;

import org.hsw.wikitoolsrenders.feature.mod_update_checker.GetNewVersionHandler;
import org.hsw.wikitoolsrenders.feature.mod_update_checker.GithubLatestReleaseFinder;
import org.hsw.wikitoolsrenders.feature.mod_update_checker.ModUpdateChecker;
import org.hsw.wikitoolsrenders.feature.render_entity.listener.AddItemToEntityListener;
import org.hsw.wikitoolsrenders.feature.render_entity.listener.CopyFacingEntityListener;
import org.hsw.wikitoolsrenders.feature.render_entity.listener.RenderEntityListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = WikiToolsRendersIdentity.MODID, version = WikiToolsRendersIdentity.VERSION, clientSideOnly = true)
public class WikiToolsRenders {
    private final ModUpdateChecker modUpdateChecker = createModUpdateChecker();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AddItemToEntityListener());
        MinecraftForge.EVENT_BUS.register(new CopyFacingEntityListener());
        MinecraftForge.EVENT_BUS.register(new RenderEntityListener());

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

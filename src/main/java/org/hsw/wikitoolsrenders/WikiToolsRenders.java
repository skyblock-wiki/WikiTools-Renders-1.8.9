package org.hsw.wikitoolsrenders;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = WikiToolsRendersIdentity.MODID, version = WikiToolsRendersIdentity.VERSION, clientSideOnly = true)
public class WikiToolsRenders {
    private final FeatureRunner featureRunner = new FeatureRunner();

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

}

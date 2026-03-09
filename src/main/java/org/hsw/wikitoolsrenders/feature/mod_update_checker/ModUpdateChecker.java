package org.hsw.wikitoolsrenders.feature.mod_update_checker;

import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import org.hsw.wikitoolsrenders.WikiToolsRendersIdentity;
import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModUpdateChecker {

    private final GetNewVersionHandler getNewVersionHandler;

    public ModUpdateChecker(GetNewVersionHandler getNewVersionHandler) {
        this.getNewVersionHandler = getNewVersionHandler;

        registerEvent();
    }

    public void registerEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        boolean isSelfJoin = event.entity == Minecraft.getMinecraft().thePlayer;

        if (!isSelfJoin) {
            return;
        }

        handleModUpdateCheck();
    }

    private void handleModUpdateCheck() {
        String currentVersionName = WikiToolsRendersIdentity.VERSION;
        getNewVersionHandler.getNewVersion(
                        new GetNewVersionHandler.GetNewVersionRequest(currentVersionName))
                .thenAccept((response) -> {
                    if (!response.success || !response.result.isPresent()) {
                        warnFailure(response.message.orElse("Unknown error"));
                        return;
                    }

                    if (response.result.get().hasNewRelease) {
                        remindUserToUpdateMod(response.result.get().latestVersion);
                    }
                });
    }

    private static void remindUserToUpdateMod(String newVersionName) {
        Minecraft client = Minecraft.getMinecraft();

        IChatComponent frontComponent = new ChatComponentTranslation("wikitools.message.mod_update_checker.new_update", newVersionName)
                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN));

        String latestReleaseDownloadUrl = WikiToolsRendersIdentity.LATEST_RELEASE_DOWNLOAD_URL;
        ChatStyle linkStyle = new ChatStyle()
                .setColor(EnumChatFormatting.GRAY)
                .setUnderlined(true)
                .setChatClickEvent(
                        new ClickEvent(ClickEvent.Action.OPEN_URL, latestReleaseDownloadUrl));

        IChatComponent linkComponent = new ChatComponentTranslation("wikitools.message.mod_update_checker.update_link_text")
                .setChatStyle(linkStyle);

        IChatComponent messageComponent = new ChatComponentText("")
                .appendSibling(frontComponent)
                .appendText(" ")
                .appendSibling(linkComponent);

        client.ingameGUI.getChatGUI().printChatMessage(messageComponent);
    }

    private static void warnFailure(String problemName) {
        String warningText = new ChatComponentTranslation("wikitools.message.mod_update_checker.error", problemName).getUnformattedTextForChat();
        WikiToolsRendersIdentity.LOGGER.warn(warningText, false);
    }

}

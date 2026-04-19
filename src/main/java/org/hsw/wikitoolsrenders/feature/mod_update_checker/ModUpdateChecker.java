package org.hsw.wikitoolsrenders.feature.mod_update_checker;

import net.minecraft.util.*;
import net.minecraftforge.common.MinecraftForge;
import org.hsw.wikitoolsrenders.ModProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModUpdateChecker {

    private final GetNewVersionHandler getNewVersionHandler;
    private boolean ranOnceAfterClientLaunch = false;

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
        boolean isSinglePlayer = Minecraft.getMinecraft().isSingleplayer();

        if (!isSelfJoin || isSinglePlayer) {
            return;
        }

        handleModUpdateCheck();
    }

    private void handleModUpdateCheck() {
        if (ranOnceAfterClientLaunch) {
            return;
        }
        ranOnceAfterClientLaunch = true;

        String currentVersionName = ModProperties.MOD_VERSION;
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
        IChatComponent frontComponent = new ChatComponentTranslation("wikitoolsrenders.message.mod_update_checker.new_update", newVersionName)
                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN));

        String latestReleaseDownloadUrl = ModProperties.LATEST_RELEASE_DOWNLOAD_URL;
        ChatStyle linkStyle = new ChatStyle()
                .setColor(EnumChatFormatting.GRAY)
                .setUnderlined(true)
                .setChatClickEvent(
                        new ClickEvent(ClickEvent.Action.OPEN_URL, latestReleaseDownloadUrl));

        IChatComponent linkComponent = new ChatComponentTranslation("wikitoolsrenders.message.mod_update_checker.update_link_text")
                .setChatStyle(linkStyle);

        IChatComponent messageComponent = new ChatComponentText("")
                .appendSibling(frontComponent)
                .appendText(" ")
                .appendSibling(linkComponent);

        printMessageInMainThread(messageComponent);
    }

    private static void printMessageInMainThread(IChatComponent message) {
        Minecraft client = Minecraft.getMinecraft();
        client.addScheduledTask(() -> client.ingameGUI.getChatGUI().printChatMessage(message));
    }

    private static void warnFailure(String problemName) {
        String warningText = new ChatComponentTranslation("wikitoolsrenders.message.mod_update_checker.error", problemName).getUnformattedTextForChat();
        ModProperties.LOGGER.warn(warningText, false);
    }

}

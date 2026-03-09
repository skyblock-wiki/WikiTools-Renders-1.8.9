package org.hsw.wikitoolsrenders;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class WikiToolsRendersKeybinds {

    public static KeyBinding COPY_ENTITY = new KeyBinding(
            "wikitoolsrenders.keybind.copyEntity",
            Keyboard.KEY_M,
            WikiToolsRendersIdentity.CATEGORY
    );

    public static KeyBinding HUD = new KeyBinding(
            "wikitoolsrenders.keybind.hud",
            Keyboard.KEY_K,
            WikiToolsRendersIdentity.CATEGORY
    );

    public static void init() {
        ClientRegistry.registerKeyBinding(COPY_ENTITY);
        ClientRegistry.registerKeyBinding(HUD);
    }

}

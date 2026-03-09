package org.hsw.wikitoolsrenders;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class ModKeybinds {

    public static KeyBinding COPY_ENTITY = new KeyBinding(
            "wikitoolsrenders.keybind.copy_entity",
            Keyboard.KEY_M,
            ModProperties.CATEGORY
    );

    public static KeyBinding HUD = new KeyBinding(
            "wikitoolsrenders.keybind.open_render_entity_gui",
            Keyboard.KEY_K,
            ModProperties.CATEGORY
    );

    public static void init() {
        ClientRegistry.registerKeyBinding(COPY_ENTITY);
        ClientRegistry.registerKeyBinding(HUD);
    }

}

package com.enderio.base.common.config;

import com.enderio.base.EnderIO;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fmlclient.ConfigGuiHandler;

@Config(name = EnderIO.DOMAIN)
public class EIOConfig extends PartitioningSerializer.GlobalData {

    public static EIOConfig get() {
        return AutoConfig
            .getConfigHolder(EIOConfig.class)
            .getConfig();
    }

    public static void register() {
        // Register config
        AutoConfig.register(EIOConfig.class, Toml4jConfigSerializer::new);

        // Register config screen.
        ModLoadingContext
            .get()
            .registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((mc, screen) -> AutoConfig
                .getConfigScreen(EIOConfig.class, screen)
                .get()));
    }
}

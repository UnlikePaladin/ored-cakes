package com.unlikepaladin.oredcakes.fabric;

import net.fabricmc.loader.api.FabricLoader;
import com.unlikepaladin.oredcakes.OredCakesExpectPlatform;
import java.nio.file.Path;

public class OredCakesExpectPlatformImpl {
    /**
     * This is our actual method to {@link OredCakesExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}

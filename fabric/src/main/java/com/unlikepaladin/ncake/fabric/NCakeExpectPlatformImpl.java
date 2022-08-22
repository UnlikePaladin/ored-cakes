package com.unlikepaladin.ncake.fabric;

import net.fabricmc.loader.api.FabricLoader;
import com.unlikepaladin.ncake.NCakeExpectPlatform;
import java.nio.file.Path;

public class NCakeExpectPlatformImpl {
    /**
     * This is our actual method to {@link NCakeExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}

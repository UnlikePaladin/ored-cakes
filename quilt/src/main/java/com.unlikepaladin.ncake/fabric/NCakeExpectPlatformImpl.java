package com.unlikepaladin.ncake.fabric;

import com.unlikepaladin.ncake.NCakeExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;
import java.nio.file.Path;

public class NCakeExpectPlatformImpl {
    /**
     * This is our actual method to {@link NCakeExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}

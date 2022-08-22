package com.unlikepaladin.ncake.forge;

import net.minecraftforge.fml.loading.FMLPaths;
import com.unlikepaladin.ncake.NCakeExpectPlatform;
import java.nio.file.Path;

public class NCakeExpectPlatformImpl {
    /**
     * This is our actual method to {@link NCakeExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}

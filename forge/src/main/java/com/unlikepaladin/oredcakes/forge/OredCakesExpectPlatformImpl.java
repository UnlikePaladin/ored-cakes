package com.unlikepaladin.oredcakes.forge;

import net.minecraftforge.fml.loading.FMLPaths;
import com.unlikepaladin.oredcakes.OredCakesExpectPlatform;
import java.nio.file.Path;

public class OredCakesExpectPlatformImpl {
    /**
     * This is our actual method to {@link OredCakesExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}

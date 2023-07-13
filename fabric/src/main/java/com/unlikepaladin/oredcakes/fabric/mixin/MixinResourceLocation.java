package com.unlikepaladin.oredcakes.fabric.mixin;

import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ResourceLocation.class)
public class MixinResourceLocation {
    @ModifyVariable(method = "<init>([Ljava/lang/String;)V", at = @At("HEAD"), argsOnly = true)
    private static String[] migrateNcake(String[] strings) {
        if (Objects.equals(strings[0], "ncake") && Objects.equals(strings[1], "ncake")) {
            return new String[] {"oredcakes", "netherite_cake"};
        } else {
            return strings;
        }
    }
}

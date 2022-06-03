// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.util.UUID;
import net.minecraft.util.ResourceLocation;

public class DefaultPlayerSkin
{
    private static final /* synthetic */ ResourceLocation TEXTURE_ALEX;
    private static final /* synthetic */ ResourceLocation TEXTURE_STEVE;
    
    static {
        TEXTURE_STEVE = new ResourceLocation("textures/entity/steve.png");
        TEXTURE_ALEX = new ResourceLocation("textures/entity/alex.png");
    }
    
    public static ResourceLocation getDefaultSkinLegacy() {
        return DefaultPlayerSkin.TEXTURE_STEVE;
    }
    
    private static boolean isSlimSkin(final UUID lllllllllllIIlIIlIIllllIlllIlIlI) {
        return (lllllllllllIIlIIlIIllllIlllIlIlI.hashCode() & 0x1) == 0x1;
    }
    
    public static ResourceLocation getDefaultSkin(final UUID lllllllllllIIlIIlIIllllIllllIIIl) {
        return isSlimSkin(lllllllllllIIlIIlIIllllIllllIIIl) ? DefaultPlayerSkin.TEXTURE_ALEX : DefaultPlayerSkin.TEXTURE_STEVE;
    }
    
    public static String getSkinType(final UUID lllllllllllIIlIIlIIllllIlllIlllI) {
        return isSlimSkin(lllllllllllIIlIIlIIllllIlllIlllI) ? "slim" : "default";
    }
}

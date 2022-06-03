// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.text.TextFormatting;
import java.io.IOException;
import com.google.gson.JsonParseException;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;

public class ResourcePackListEntryServer extends ResourcePackListEntry
{
    private final /* synthetic */ IResourcePack resourcePack;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ ResourceLocation resourcePackIcon;
    
    @Override
    protected void bindResourcePackIcon() {
        this.mc.getTextureManager().bindTexture(this.resourcePackIcon);
    }
    
    @Override
    protected String getResourcePackDescription() {
        try {
            final PackMetadataSection llllllllllllIlIllIIllIlIllIIllII = this.resourcePack.getPackMetadata(this.mc.getResourcePackRepository().rprMetadataSerializer, "pack");
            if (llllllllllllIlIllIIllIlIllIIllII != null) {
                return llllllllllllIlIllIIllIlIllIIllII.getPackDescription().getFormattedText();
            }
        }
        catch (JsonParseException llllllllllllIlIllIIllIlIllIIlIll) {
            ResourcePackListEntryServer.LOGGER.error("Couldn't load metadata info", (Throwable)llllllllllllIlIllIIllIlIllIIlIll);
        }
        catch (IOException llllllllllllIlIllIIllIlIllIIlIlI) {
            ResourcePackListEntryServer.LOGGER.error("Couldn't load metadata info", (Throwable)llllllllllllIlIllIIllIlIllIIlIlI);
        }
        return TextFormatting.RED + "Missing " + "pack.mcmeta" + " :(";
    }
    
    @Override
    protected boolean canMoveDown() {
        return false;
    }
    
    @Override
    protected String getResourcePackName() {
        return "Server";
    }
    
    @Override
    protected boolean showHoverOverlay() {
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public ResourcePackListEntryServer(final GuiScreenResourcePacks llllllllllllIlIllIIllIlIllIlIlII, final IResourcePack llllllllllllIlIllIIllIlIllIlIIll) {
        super(llllllllllllIlIllIIllIlIllIlIlII);
        this.resourcePack = llllllllllllIlIllIIllIlIllIlIIll;
        DynamicTexture llllllllllllIlIllIIllIlIllIlIlll = null;
        try {
            final DynamicTexture llllllllllllIlIllIIllIlIllIllIII = new DynamicTexture(llllllllllllIlIllIIllIlIllIlIIll.getPackImage());
        }
        catch (IOException llllllllllllIlIllIIllIlIllIlIllI) {
            llllllllllllIlIllIIllIlIllIlIlll = TextureUtil.MISSING_TEXTURE;
        }
        this.resourcePackIcon = this.mc.getTextureManager().getDynamicTextureLocation("texturepackicon", llllllllllllIlIllIIllIlIllIlIlll);
    }
    
    @Override
    protected int getResourcePackFormat() {
        return 3;
    }
    
    @Override
    protected boolean canMoveUp() {
        return false;
    }
    
    @Override
    public boolean isServerPack() {
        return true;
    }
    
    @Override
    protected boolean canMoveLeft() {
        return false;
    }
    
    @Override
    protected boolean canMoveRight() {
        return false;
    }
}

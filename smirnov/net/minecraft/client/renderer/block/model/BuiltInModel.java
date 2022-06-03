// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import java.util.Collections;
import java.util.List;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class BuiltInModel implements IBakedModel
{
    private final /* synthetic */ ItemCameraTransforms cameraTransforms;
    private final /* synthetic */ ItemOverrideList overrideList;
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return null;
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.overrideList;
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }
    
    @Override
    public boolean isGui3d() {
        return true;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return true;
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState lllllllllllIlIlllIlIlIlllIllllIl, @Nullable final EnumFacing lllllllllllIlIlllIlIlIlllIllllII, final long lllllllllllIlIlllIlIlIlllIlllIll) {
        return Collections.emptyList();
    }
    
    public BuiltInModel(final ItemCameraTransforms lllllllllllIlIlllIlIlIllllIIIIII, final ItemOverrideList lllllllllllIlIlllIlIlIllllIIIIlI) {
        this.cameraTransforms = lllllllllllIlIlllIlIlIllllIIIIII;
        this.overrideList = lllllllllllIlIlllIlIlIllllIIIIlI;
    }
}

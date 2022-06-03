// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import com.google.common.collect.Maps;
import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import com.google.common.base.Predicate;
import java.util.Map;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

public class MultipartBakedModel implements IBakedModel
{
    protected final /* synthetic */ ItemCameraTransforms cameraTransforms;
    protected final /* synthetic */ TextureAtlasSprite particleTexture;
    protected final /* synthetic */ boolean ambientOcclusion;
    protected final /* synthetic */ ItemOverrideList overrides;
    private final /* synthetic */ Map<Predicate<IBlockState>, IBakedModel> selectors;
    protected final /* synthetic */ boolean gui3D;
    
    @Override
    public boolean isAmbientOcclusion() {
        return this.ambientOcclusion;
    }
    
    @Override
    public boolean isGui3d() {
        return this.gui3D;
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.overrides;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.particleTexture;
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }
    
    public MultipartBakedModel(final Map<Predicate<IBlockState>, IBakedModel> llllllllllllIIlIIIIlllllIIllIIII) {
        this.selectors = llllllllllllIIlIIIIlllllIIllIIII;
        final IBakedModel llllllllllllIIlIIIIlllllIIllIIlI = llllllllllllIIlIIIIlllllIIllIIII.values().iterator().next();
        this.ambientOcclusion = llllllllllllIIlIIIIlllllIIllIIlI.isAmbientOcclusion();
        this.gui3D = llllllllllllIIlIIIIlllllIIllIIlI.isGui3d();
        this.particleTexture = llllllllllllIIlIIIIlllllIIllIIlI.getParticleTexture();
        this.cameraTransforms = llllllllllllIIlIIIIlllllIIllIIlI.getItemCameraTransforms();
        this.overrides = llllllllllllIIlIIIIlllllIIllIIlI.getOverrides();
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState llllllllllllIIlIIIIlllllIIlIIllI, @Nullable final EnumFacing llllllllllllIIlIIIIlllllIIIlllll, long llllllllllllIIlIIIIlllllIIIllllI) {
        final List<BakedQuad> llllllllllllIIlIIIIlllllIIlIIIll = (List<BakedQuad>)Lists.newArrayList();
        if (llllllllllllIIlIIIIlllllIIlIIllI != null) {
            for (final Map.Entry<Predicate<IBlockState>, IBakedModel> llllllllllllIIlIIIIlllllIIlIIIlI : this.selectors.entrySet()) {
                if (llllllllllllIIlIIIIlllllIIlIIIlI.getKey().apply((Object)llllllllllllIIlIIIIlllllIIlIIllI)) {
                    llllllllllllIIlIIIIlllllIIlIIIll.addAll(llllllllllllIIlIIIIlllllIIlIIIlI.getValue().getQuads(llllllllllllIIlIIIIlllllIIlIIllI, llllllllllllIIlIIIIlllllIIIlllll, llllllllllllIIlIIIIlllllIIIllllI++));
                }
            }
        }
        return llllllllllllIIlIIIIlllllIIlIIIll;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }
    
    public static class Builder
    {
        private final /* synthetic */ Map<Predicate<IBlockState>, IBakedModel> builderSelectors;
        
        public IBakedModel makeMultipartModel() {
            return new MultipartBakedModel(this.builderSelectors);
        }
        
        public Builder() {
            this.builderSelectors = (Map<Predicate<IBlockState>, IBakedModel>)Maps.newLinkedHashMap();
        }
        
        public void putModel(final Predicate<IBlockState> lllllllllllIIIIIlIlIllIIllIIlllI, final IBakedModel lllllllllllIIIIIlIlIllIIllIIllIl) {
            this.builderSelectors.put(lllllllllllIIIIIlIlIllIIllIIlllI, lllllllllllIIIIIlIlIllIIllIIllIl);
        }
    }
}

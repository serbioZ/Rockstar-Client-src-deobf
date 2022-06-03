// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import java.util.Collections;
import com.google.common.collect.Lists;
import com.google.common.collect.ComparisonChain;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.WeightedRandom;
import java.util.List;

public class WeightedBakedModel implements IBakedModel
{
    private final /* synthetic */ IBakedModel baseModel;
    private final /* synthetic */ int totalWeight;
    private final /* synthetic */ List<WeightedModel> models;
    
    @Override
    public boolean isGui3d() {
        return this.baseModel.isGui3d();
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return this.baseModel.isAmbientOcclusion();
    }
    
    private IBakedModel getRandomModel(final long llllllllllllllllIIllIllllIIIIlIl) {
        return WeightedRandom.getRandomItem(this.models, Math.abs((int)llllllllllllllllIIllIllllIIIIlIl >> 16) % this.totalWeight).model;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.baseModel.getParticleTexture();
    }
    
    public WeightedBakedModel(final List<WeightedModel> llllllllllllllllIIllIllllIIIlIll) {
        this.models = llllllllllllllllIIllIllllIIIlIll;
        this.totalWeight = WeightedRandom.getTotalWeight(llllllllllllllllIIllIllllIIIlIll);
        this.baseModel = llllllllllllllllIIllIllllIIIlIll.get(0).model;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return this.baseModel.isBuiltInRenderer();
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.baseModel.getItemCameraTransforms();
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState llllllllllllllllIIllIlllIllllIll, @Nullable final EnumFacing llllllllllllllllIIllIlllIllllllI, final long llllllllllllllllIIllIlllIlllllIl) {
        return this.getRandomModel(llllllllllllllllIIllIlllIlllllIl).getQuads(llllllllllllllllIIllIlllIllllIll, llllllllllllllllIIllIlllIllllllI, llllllllllllllllIIllIlllIlllllIl);
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.baseModel.getOverrides();
    }
    
    static class WeightedModel extends WeightedRandom.Item implements Comparable<WeightedModel>
    {
        protected final /* synthetic */ IBakedModel model;
        
        public WeightedModel(final IBakedModel llllllllllIllllIIllllIIIlIIIIIIl, final int llllllllllIllllIIllllIIIlIIIIIII) {
            super(llllllllllIllllIIllllIIIlIIIIIII);
            this.model = llllllllllIllllIIllllIIIlIIIIIIl;
        }
        
        @Override
        public String toString() {
            return "MyWeighedRandomItem{weight=" + this.itemWeight + ", model=" + this.model + '}';
        }
        
        @Override
        public int compareTo(final WeightedModel llllllllllIllllIIllllIIIIllllIIl) {
            return ComparisonChain.start().compare(llllllllllIllllIIllllIIIIllllIIl.itemWeight, this.itemWeight).result();
        }
    }
    
    public static class Builder
    {
        private final /* synthetic */ List<WeightedModel> listItems;
        
        public Builder add(final IBakedModel llllllllllllIIIlIllIlllllIlIIIlI, final int llllllllllllIIIlIllIlllllIlIIIIl) {
            this.listItems.add(new WeightedModel(llllllllllllIIIlIllIlllllIlIIIlI, llllllllllllIIIlIllIlllllIlIIIIl));
            return this;
        }
        
        public IBakedModel first() {
            return this.listItems.get(0).model;
        }
        
        public Builder() {
            this.listItems = (List<WeightedModel>)Lists.newArrayList();
        }
        
        public WeightedBakedModel build() {
            Collections.sort(this.listItems);
            return new WeightedBakedModel(this.listItems);
        }
    }
}

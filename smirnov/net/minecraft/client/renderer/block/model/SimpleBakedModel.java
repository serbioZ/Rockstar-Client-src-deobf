// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.List;
import net.minecraft.util.EnumFacing;
import java.util.Map;

public class SimpleBakedModel implements IBakedModel
{
    protected final /* synthetic */ ItemCameraTransforms cameraTransforms;
    protected final /* synthetic */ Map<EnumFacing, List<BakedQuad>> faceQuads;
    protected final /* synthetic */ boolean ambientOcclusion;
    protected final /* synthetic */ List<BakedQuad> generalQuads;
    protected final /* synthetic */ boolean gui3d;
    protected final /* synthetic */ TextureAtlasSprite texture;
    protected final /* synthetic */ ItemOverrideList itemOverrideList;
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return this.ambientOcclusion;
    }
    
    public SimpleBakedModel(final List<BakedQuad> lllllllllllIllIllIllllIlIIlIlIIl, final Map<EnumFacing, List<BakedQuad>> lllllllllllIllIllIllllIlIIlIIIII, final boolean lllllllllllIllIllIllllIlIIlIIlll, final boolean lllllllllllIllIllIllllIlIIIllllI, final TextureAtlasSprite lllllllllllIllIllIllllIlIIIlllIl, final ItemCameraTransforms lllllllllllIllIllIllllIlIIlIIlII, final ItemOverrideList lllllllllllIllIllIllllIlIIlIIIll) {
        this.generalQuads = lllllllllllIllIllIllllIlIIlIlIIl;
        this.faceQuads = lllllllllllIllIllIllllIlIIlIIIII;
        this.ambientOcclusion = lllllllllllIllIllIllllIlIIlIIlll;
        this.gui3d = lllllllllllIllIllIllllIlIIIllllI;
        this.texture = lllllllllllIllIllIllllIlIIIlllIl;
        this.cameraTransforms = lllllllllllIllIllIllllIlIIlIIlII;
        this.itemOverrideList = lllllllllllIllIllIllllIlIIlIIIll;
    }
    
    @Override
    public boolean isGui3d() {
        return this.gui3d;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.texture;
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.itemOverrideList;
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState lllllllllllIllIllIllllIlIIIlIlll, @Nullable final EnumFacing lllllllllllIllIllIllllIlIIIlIIll, final long lllllllllllIllIllIllllIlIIIlIlIl) {
        return (lllllllllllIllIllIllllIlIIIlIIll == null) ? this.generalQuads : this.faceQuads.get(lllllllllllIllIllIllllIlIIIlIIll);
    }
    
    public static class Builder
    {
        private final /* synthetic */ ItemOverrideList builderItemOverrideList;
        private /* synthetic */ TextureAtlasSprite builderTexture;
        private final /* synthetic */ boolean builderAmbientOcclusion;
        private final /* synthetic */ Map<EnumFacing, List<BakedQuad>> builderFaceQuads;
        private final /* synthetic */ boolean builderGui3d;
        private final /* synthetic */ ItemCameraTransforms builderCameraTransforms;
        private final /* synthetic */ List<BakedQuad> builderGeneralQuads;
        
        public IBakedModel makeBakedModel() {
            if (this.builderTexture == null) {
                throw new RuntimeException("Missing particle!");
            }
            return new SimpleBakedModel(this.builderGeneralQuads, this.builderFaceQuads, this.builderAmbientOcclusion, this.builderGui3d, this.builderTexture, this.builderCameraTransforms, this.builderItemOverrideList);
        }
        
        private void addFaceQuads(final IBlockState llllllllllllIIlIIIIIIlIIlIllIIII, final IBakedModel llllllllllllIIlIIIIIIlIIlIllIllI, final TextureAtlasSprite llllllllllllIIlIIIIIIlIIlIlIlllI, final EnumFacing llllllllllllIIlIIIIIIlIIlIlIllIl, final long llllllllllllIIlIIIIIIlIIlIlIllII) {
            for (final BakedQuad llllllllllllIIlIIIIIIlIIlIllIIlI : llllllllllllIIlIIIIIIlIIlIllIllI.getQuads(llllllllllllIIlIIIIIIlIIlIllIIII, llllllllllllIIlIIIIIIlIIlIlIllIl, llllllllllllIIlIIIIIIlIIlIlIllII)) {
                this.addFaceQuad(llllllllllllIIlIIIIIIlIIlIlIllIl, new BakedQuadRetextured(llllllllllllIIlIIIIIIlIIlIllIIlI, llllllllllllIIlIIIIIIlIIlIlIlllI));
            }
        }
        
        public Builder setTexture(final TextureAtlasSprite llllllllllllIIlIIIIIIlIIlIIIIIIl) {
            this.builderTexture = llllllllllllIIlIIIIIIlIIlIIIIIIl;
            return this;
        }
        
        private Builder(final boolean llllllllllllIIlIIIIIIlIIllIIlllI, final boolean llllllllllllIIlIIIIIIlIIllIIllIl, final ItemCameraTransforms llllllllllllIIlIIIIIIlIIllIIllII, final ItemOverrideList llllllllllllIIlIIIIIIlIIllIIIlIl) {
            this.builderGeneralQuads = (List<BakedQuad>)Lists.newArrayList();
            this.builderFaceQuads = (Map<EnumFacing, List<BakedQuad>>)Maps.newEnumMap((Class)EnumFacing.class);
            short llllllllllllIIlIIIIIIlIIllIIIIIl;
            for (Exception llllllllllllIIlIIIIIIlIIllIIIIlI = (Exception)((EnumFacing[])(Object)(llllllllllllIIlIIIIIIlIIllIIIIIl = (short)(Object)EnumFacing.values())).length, llllllllllllIIlIIIIIIlIIllIIIIll = (Exception)0; llllllllllllIIlIIIIIIlIIllIIIIll < llllllllllllIIlIIIIIIlIIllIIIIlI; ++llllllllllllIIlIIIIIIlIIllIIIIll) {
                final EnumFacing llllllllllllIIlIIIIIIlIIllIIlIlI = llllllllllllIIlIIIIIIlIIllIIIIIl[llllllllllllIIlIIIIIIlIIllIIIIll];
                this.builderFaceQuads.put(llllllllllllIIlIIIIIIlIIllIIlIlI, Lists.newArrayList());
            }
            this.builderItemOverrideList = llllllllllllIIlIIIIIIlIIllIIIlIl;
            this.builderAmbientOcclusion = llllllllllllIIlIIIIIIlIIllIIlllI;
            this.builderGui3d = llllllllllllIIlIIIIIIlIIllIIllIl;
            this.builderCameraTransforms = llllllllllllIIlIIIIIIlIIllIIllII;
        }
        
        public Builder addGeneralQuad(final BakedQuad llllllllllllIIlIIIIIIlIIlIIIlIIl) {
            this.builderGeneralQuads.add(llllllllllllIIlIIIIIIlIIlIIIlIIl);
            return this;
        }
        
        private void addGeneralQuads(final IBlockState llllllllllllIIlIIIIIIlIIlIlIIIIl, final IBakedModel llllllllllllIIlIIIIIIlIIlIIllIlI, final TextureAtlasSprite llllllllllllIIlIIIIIIlIIlIIlllll, final long llllllllllllIIlIIIIIIlIIlIIllIII) {
            for (final BakedQuad llllllllllllIIlIIIIIIlIIlIIlllIl : llllllllllllIIlIIIIIIlIIlIIllIlI.getQuads(llllllllllllIIlIIIIIIlIIlIlIIIIl, null, llllllllllllIIlIIIIIIlIIlIIllIII)) {
                this.addGeneralQuad(new BakedQuadRetextured(llllllllllllIIlIIIIIIlIIlIIlllIl, llllllllllllIIlIIIIIIlIIlIIlllll));
            }
        }
        
        public Builder(final ModelBlock llllllllllllIIlIIIIIIlIIllllIlIl, final ItemOverrideList llllllllllllIIlIIIIIIlIIllllIlII) {
            this(llllllllllllIIlIIIIIIlIIllllIlIl.isAmbientOcclusion(), llllllllllllIIlIIIIIIlIIllllIlIl.isGui3d(), llllllllllllIIlIIIIIIlIIllllIlIl.getAllTransforms(), llllllllllllIIlIIIIIIlIIllllIlII);
        }
        
        public Builder addFaceQuad(final EnumFacing llllllllllllIIlIIIIIIlIIlIIlIIIl, final BakedQuad llllllllllllIIlIIIIIIlIIlIIIllIl) {
            this.builderFaceQuads.get(llllllllllllIIlIIIIIIlIIlIIlIIIl).add(llllllllllllIIlIIIIIIlIIlIIIllIl);
            return this;
        }
        
        public Builder(final IBlockState llllllllllllIIlIIIIIIlIIlllIlIII, final IBakedModel llllllllllllIIlIIIIIIlIIlllIIIII, final TextureAtlasSprite llllllllllllIIlIIIIIIlIIllIlllll, final BlockPos llllllllllllIIlIIIIIIlIIlllIIlIl) {
            this(llllllllllllIIlIIIIIIlIIlllIIIII.isAmbientOcclusion(), llllllllllllIIlIIIIIIlIIlllIIIII.isGui3d(), llllllllllllIIlIIIIIIlIIlllIIIII.getItemCameraTransforms(), llllllllllllIIlIIIIIIlIIlllIIIII.getOverrides());
            this.builderTexture = llllllllllllIIlIIIIIIlIIlllIIIII.getParticleTexture();
            final long llllllllllllIIlIIIIIIlIIlllIIlII = MathHelper.getPositionRandom(llllllllllllIIlIIIIIIlIIlllIIlIl);
            final int llllllllllllIIlIIIIIIlIIllIllIIl;
            final byte llllllllllllIIlIIIIIIlIIllIllIlI = (byte)((EnumFacing[])(Object)(llllllllllllIIlIIIIIIlIIllIllIIl = (int)(Object)EnumFacing.values())).length;
            for (String llllllllllllIIlIIIIIIlIIllIllIll = (String)0; llllllllllllIIlIIIIIIlIIllIllIll < llllllllllllIIlIIIIIIlIIllIllIlI; ++llllllllllllIIlIIIIIIlIIllIllIll) {
                final EnumFacing llllllllllllIIlIIIIIIlIIlllIIIll = llllllllllllIIlIIIIIIlIIllIllIIl[llllllllllllIIlIIIIIIlIIllIllIll];
                this.addFaceQuads(llllllllllllIIlIIIIIIlIIlllIlIII, llllllllllllIIlIIIIIIlIIlllIIIII, llllllllllllIIlIIIIIIlIIllIlllll, llllllllllllIIlIIIIIIlIIlllIIIll, llllllllllllIIlIIIIIIlIIlllIIlII);
            }
            this.addGeneralQuads(llllllllllllIIlIIIIIIlIIlllIlIII, llllllllllllIIlIIIIIIlIIlllIIIII, llllllllllllIIlIIIIIIlIIllIlllll, llllllllllllIIlIIIIIIlIIlllIIlII);
        }
    }
}

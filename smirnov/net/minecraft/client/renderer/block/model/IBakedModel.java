// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import java.util.List;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;

public interface IBakedModel
{
    ItemCameraTransforms getItemCameraTransforms();
    
    boolean isBuiltInRenderer();
    
    boolean isGui3d();
    
    List<BakedQuad> getQuads(final IBlockState p0, final EnumFacing p1, final long p2);
    
    boolean isAmbientOcclusion();
    
    TextureAtlasSprite getParticleTexture();
    
    ItemOverrideList getOverrides();
}

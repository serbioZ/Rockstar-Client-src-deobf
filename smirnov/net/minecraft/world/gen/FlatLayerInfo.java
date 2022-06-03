// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen;

import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class FlatLayerInfo
{
    private /* synthetic */ int layerCount;
    private final /* synthetic */ int version;
    private /* synthetic */ int layerMinimumY;
    private /* synthetic */ IBlockState layerMaterial;
    
    public FlatLayerInfo(final int lllllllllllllllIllllIIIlIlIIlIII, final int lllllllllllllllIllllIIIlIlIIIlll, final Block lllllllllllllllIllllIIIlIlIIlIlI) {
        this.layerCount = 1;
        this.version = lllllllllllllllIllllIIIlIlIIlIII;
        this.layerCount = lllllllllllllllIllllIIIlIlIIIlll;
        this.layerMaterial = lllllllllllllllIllllIIIlIlIIlIlI.getDefaultState();
    }
    
    public int getMinY() {
        return this.layerMinimumY;
    }
    
    public IBlockState getLayerMaterial() {
        return this.layerMaterial;
    }
    
    private int getFillBlockMeta() {
        return this.layerMaterial.getBlock().getMetaFromState(this.layerMaterial);
    }
    
    public int getLayerCount() {
        return this.layerCount;
    }
    
    public void setMinY(final int lllllllllllllllIllllIIIlIIlIIIlI) {
        this.layerMinimumY = lllllllllllllllIllllIIIlIIlIIIlI;
    }
    
    public FlatLayerInfo(final int lllllllllllllllIllllIIIlIlIlIIll, final Block lllllllllllllllIllllIIIlIlIlIIlI) {
        this(3, lllllllllllllllIllllIIIlIlIlIIll, lllllllllllllllIllllIIIlIlIlIIlI);
    }
    
    public FlatLayerInfo(final int lllllllllllllllIllllIIIlIIllllll, final int lllllllllllllllIllllIIIlIIlllllI, final Block lllllllllllllllIllllIIIlIIlllIII, final int lllllllllllllllIllllIIIlIIllIlll) {
        this(lllllllllllllllIllllIIIlIIllllll, lllllllllllllllIllllIIIlIIlllllI, lllllllllllllllIllllIIIlIIlllIII);
        this.layerMaterial = lllllllllllllllIllllIIIlIIlllIII.getStateFromMeta(lllllllllllllllIllllIIIlIIllIlll);
    }
    
    @Override
    public String toString() {
        String lllllllllllllllIllllIIIlIIIlllII = null;
        if (this.version >= 3) {
            final ResourceLocation lllllllllllllllIllllIIIlIIIllIll = Block.REGISTRY.getNameForObject(this.getLayerMaterialBlock());
            String lllllllllllllllIllllIIIlIIIlllIl = (lllllllllllllllIllllIIIlIIIllIll == null) ? "null" : lllllllllllllllIllllIIIlIIIllIll.toString();
            if (this.layerCount > 1) {
                lllllllllllllllIllllIIIlIIIlllIl = String.valueOf(this.layerCount) + "*" + lllllllllllllllIllllIIIlIIIlllIl;
            }
        }
        else {
            lllllllllllllllIllllIIIlIIIlllII = Integer.toString(Block.getIdFromBlock(this.getLayerMaterialBlock()));
            if (this.layerCount > 1) {
                lllllllllllllllIllllIIIlIIIlllII = String.valueOf(this.layerCount) + "x" + lllllllllllllllIllllIIIlIIIlllII;
            }
        }
        final int lllllllllllllllIllllIIIlIIIllIlI = this.getFillBlockMeta();
        if (lllllllllllllllIllllIIIlIIIllIlI > 0) {
            lllllllllllllllIllllIIIlIIIlllII = String.valueOf(lllllllllllllllIllllIIIlIIIlllII) + ":" + lllllllllllllllIllllIIIlIIIllIlI;
        }
        return lllllllllllllllIllllIIIlIIIlllII;
    }
    
    private Block getLayerMaterialBlock() {
        return this.layerMaterial.getBlock();
    }
}

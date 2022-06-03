// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import net.minecraft.world.World;
import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import java.util.Random;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class EmptyChunk extends Chunk
{
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos llllllllllllIlIIIIIIlIIlllIIIIIl, final EnumCreateEntityType llllllllllllIlIIIIIIlIIlllIIIIII) {
        return null;
    }
    
    @Override
    public void removeEntityAtIndex(final Entity llllllllllllIlIIIIIIlIIlllIIIllI, final int llllllllllllIlIIIIIIlIIlllIIIlIl) {
    }
    
    @Override
    public boolean needsSaving(final boolean llllllllllllIlIIIIIIlIIllIlIlIlI) {
        return false;
    }
    
    @Override
    public int getBlockLightOpacity(final BlockPos llllllllllllIlIIIIIIlIIlllIllIII) {
        return 255;
    }
    
    @Override
    public void setChunkModified() {
    }
    
    @Override
    public void addTileEntity(final TileEntity llllllllllllIlIIIIIIlIIllIlllllI) {
    }
    
    @Override
    public int getLightSubtracted(final BlockPos llllllllllllIlIIIIIIlIIlllIIllIl, final int llllllllllllIlIIIIIIlIIlllIIllII) {
        return 0;
    }
    
    @Override
    public boolean getAreLevelsEmpty(final int llllllllllllIlIIIIIIlIIllIlIIIIl, final int llllllllllllIlIIIIIIlIIllIlIIIII) {
        return true;
    }
    
    @Override
    public boolean canSeeSky(final BlockPos llllllllllllIlIIIIIIlIIlllIIIIll) {
        return false;
    }
    
    @Override
    public void addTileEntity(final BlockPos llllllllllllIlIIIIIIlIIllIllllII, final TileEntity llllllllllllIlIIIIIIlIIllIlllIll) {
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos llllllllllllIlIIIIIIlIIlllIllIlI) {
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public int getHeightValue(final int llllllllllllIlIIIIIIlIIlllIlllll, final int llllllllllllIlIIIIIIlIIlllIllllI) {
        return 0;
    }
    
    @Override
    public int getLightFor(final EnumSkyBlock llllllllllllIlIIIIIIlIIlllIlIlIl, final BlockPos llllllllllllIlIIIIIIlIIlllIlIlII) {
        return llllllllllllIlIIIIIIlIIlllIlIlIl.defaultLightValue;
    }
    
    @Override
    public Random getRandomWithSeed(final long llllllllllllIlIIIIIIlIIllIlIIllI) {
        return new Random(this.getWorld().getSeed() + this.xPosition * this.xPosition * 4987142 + this.xPosition * 5947611 + this.zPosition * this.zPosition * 4392871L + this.zPosition * 389711 ^ llllllllllllIlIIIIIIlIIllIlIIllI);
    }
    
    @Override
    public boolean isAtLocation(final int llllllllllllIlIIIIIIlIIllllIIIlI, final int llllllllllllIlIIIIIIlIIllllIIIIl) {
        return llllllllllllIlIIIIIIlIIllllIIIlI == this.xPosition && llllllllllllIlIIIIIIlIIllllIIIIl == this.zPosition;
    }
    
    @Override
    public void generateSkylightMap() {
    }
    
    @Override
    public void addEntity(final Entity llllllllllllIlIIIIIIlIIlllIIlIlI) {
    }
    
    public void generateHeightMap() {
    }
    
    @Override
    public void removeEntity(final Entity llllllllllllIlIIIIIIlIIlllIIlIII) {
    }
    
    @Override
    public void removeTileEntity(final BlockPos llllllllllllIlIIIIIIlIIllIlllIIl) {
    }
    
    @Override
    public void setLightFor(final EnumSkyBlock llllllllllllIlIIIIIIlIIlllIlIIIl, final BlockPos llllllllllllIlIIIIIIlIIlllIlIIII, final int llllllllllllIlIIIIIIlIIlllIIllll) {
    }
    
    @Override
    public void getEntitiesWithinAABBForEntity(@Nullable final Entity llllllllllllIlIIIIIIlIIllIllIlII, final AxisAlignedBB llllllllllllIlIIIIIIlIIllIllIIll, final List<Entity> llllllllllllIlIIIIIIlIIllIllIIlI, final Predicate<? super Entity> llllllllllllIlIIIIIIlIIllIllIIIl) {
    }
    
    @Override
    public <T extends Entity> void getEntitiesOfTypeWithinAAAB(final Class<? extends T> llllllllllllIlIIIIIIlIIllIlIllll, final AxisAlignedBB llllllllllllIlIIIIIIlIIllIlIlllI, final List<T> llllllllllllIlIIIIIIlIIllIlIllIl, final Predicate<? super T> llllllllllllIlIIIIIIlIIllIlIllII) {
    }
    
    @Override
    public void onChunkLoad() {
    }
    
    public EmptyChunk(final World llllllllllllIlIIIIIIlIIlllllIIII, final int llllllllllllIlIIIIIIlIIllllIllll, final int llllllllllllIlIIIIIIlIIllllIlIlI) {
        super(llllllllllllIlIIIIIIlIIlllllIIII, llllllllllllIlIIIIIIlIIllllIllll, llllllllllllIlIIIIIIlIIllllIlIlI);
    }
    
    @Override
    public void onChunkUnload() {
    }
}

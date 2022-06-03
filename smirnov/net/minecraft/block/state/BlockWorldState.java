// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state;

import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWorldState
{
    private final /* synthetic */ World world;
    private /* synthetic */ IBlockState state;
    private /* synthetic */ boolean tileEntityInitialized;
    private final /* synthetic */ boolean forceLoad;
    private /* synthetic */ TileEntity tileEntity;
    private final /* synthetic */ BlockPos pos;
    
    public static Predicate<BlockWorldState> hasState(final Predicate<IBlockState> lllllllllllIlIllIlIIIlIllllIIIIl) {
        return (Predicate<BlockWorldState>)new Predicate<BlockWorldState>() {
            public boolean apply(@Nullable final BlockWorldState llllllllllllIlIIIIIIllIIlllllIII) {
                return llllllllllllIlIIIIIIllIIlllllIII != null && lllllllllllIlIllIlIIIlIllllIIIIl.apply((Object)llllllllllllIlIIIIIIllIIlllllIII.getBlockState());
            }
        };
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public IBlockState getBlockState() {
        if (this.state == null && (this.forceLoad || this.world.isBlockLoaded(this.pos))) {
            this.state = this.world.getBlockState(this.pos);
        }
        return this.state;
    }
    
    public BlockWorldState(final World lllllllllllIlIllIlIIIlIllllIlllI, final BlockPos lllllllllllIlIllIlIIIlIllllIllIl, final boolean lllllllllllIlIllIlIIIlIlllllIIII) {
        this.world = lllllllllllIlIllIlIIIlIllllIlllI;
        this.pos = lllllllllllIlIllIlIIIlIllllIllIl;
        this.forceLoad = lllllllllllIlIllIlIIIlIlllllIIII;
    }
    
    @Nullable
    public TileEntity getTileEntity() {
        if (this.tileEntity == null && !this.tileEntityInitialized) {
            this.tileEntity = this.world.getTileEntity(this.pos);
            this.tileEntityInitialized = true;
        }
        return this.tileEntity;
    }
}

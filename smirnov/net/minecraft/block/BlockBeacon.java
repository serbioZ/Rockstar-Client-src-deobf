// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.stats.StatList;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.WorldServer;
import net.minecraft.init.Blocks;
import net.minecraft.util.HttpUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBeacon extends BlockContainer
{
    public static void updateColorAsync(final World llllllllllIlllIlIIIIllIlIllIlIll, final BlockPos llllllllllIlllIlIIIIllIlIllIlIlI) {
        HttpUtil.DOWNLOADER_EXECUTOR.submit((Runnable)new Runnable() {
            @Override
            public void run() {
                final Chunk llllllllllllIIllIlIlIlllIlIlIIlI = llllllllllIlllIlIIIIllIlIllIlIll.getChunkFromBlockCoords(llllllllllIlllIlIIIIllIlIllIlIlI);
                for (int llllllllllllIIllIlIlIlllIlIlIIIl = llllllllllIlllIlIIIIllIlIllIlIlI.getY() - 1; llllllllllllIIllIlIlIlllIlIlIIIl >= 0; --llllllllllllIIllIlIlIlllIlIlIIIl) {
                    final BlockPos llllllllllllIIllIlIlIlllIlIlIIII = new BlockPos(llllllllllIlllIlIIIIllIlIllIlIlI.getX(), llllllllllllIIllIlIlIlllIlIlIIIl, llllllllllIlllIlIIIIllIlIllIlIlI.getZ());
                    if (!llllllllllllIIllIlIlIlllIlIlIIlI.canSeeSky(llllllllllllIIllIlIlIlllIlIlIIII)) {
                        break;
                    }
                    final IBlockState llllllllllllIIllIlIlIlllIlIIllll = llllllllllIlllIlIIIIllIlIllIlIll.getBlockState(llllllllllllIIllIlIlIlllIlIlIIII);
                    if (llllllllllllIIllIlIlIlllIlIIllll.getBlock() == Blocks.BEACON) {
                        ((WorldServer)llllllllllIlllIlIIIIllIlIllIlIll).addScheduledTask(new Runnable() {
                            @Override
                            public void run() {
                                final TileEntity llllllllllllIIlIlIllIIllIIlIllll = llllllllllIlllIlIIIIllIlIllIlIll.getTileEntity(llllllllllllIIllIlIlIlllIlIlIIII);
                                if (llllllllllllIIlIlIllIIllIIlIllll instanceof TileEntityBeacon) {
                                    ((TileEntityBeacon)llllllllllllIIlIlIllIIllIIlIllll).updateBeacon();
                                    llllllllllIlllIlIIIIllIlIllIlIll.addBlockEvent(llllllllllllIIllIlIlIlllIlIlIIII, Blocks.BEACON, 1, 0);
                                }
                            }
                        });
                    }
                }
            }
        });
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllIlllIlIIIIllIllIIlIlll) {
        return false;
    }
    
    public BlockBeacon() {
        super(Material.GLASS, MapColor.DIAMOND);
        this.setHardness(3.0f);
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllIlllIlIIIIllIlIllllIlI, final World llllllllllIlllIlIIIIllIlIllllIIl, final BlockPos llllllllllIlllIlIIIIllIlIlllIIlI, final Block llllllllllIlllIlIIIIllIlIlllIlll, final BlockPos llllllllllIlllIlIIIIllIlIlllIllI) {
        final TileEntity llllllllllIlllIlIIIIllIlIlllIlIl = llllllllllIlllIlIIIIllIlIllllIIl.getTileEntity(llllllllllIlllIlIIIIllIlIlllIIlI);
        if (llllllllllIlllIlIIIIllIlIlllIlIl instanceof TileEntityBeacon) {
            ((TileEntityBeacon)llllllllllIlllIlIIIIllIlIlllIlIl).updateBeacon();
            llllllllllIlllIlIIIIllIlIllllIIl.addBlockEvent(llllllllllIlllIlIIIIllIlIlllIIlI, this, 1, 0);
        }
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllIlllIlIIIIllIllIIllllI, final BlockPos llllllllllIlllIlIIIIllIllIlIIlll, final IBlockState llllllllllIlllIlIIIIllIllIlIIllI, final EntityPlayer llllllllllIlllIlIIIIllIllIlIIlIl, final EnumHand llllllllllIlllIlIIIIllIllIlIIlII, final EnumFacing llllllllllIlllIlIIIIllIllIlIIIll, final float llllllllllIlllIlIIIIllIllIlIIIlI, final float llllllllllIlllIlIIIIllIllIlIIIIl, final float llllllllllIlllIlIIIIllIllIlIIIII) {
        if (llllllllllIlllIlIIIIllIllIIllllI.isRemote) {
            return true;
        }
        final TileEntity llllllllllIlllIlIIIIllIllIIlllll = llllllllllIlllIlIIIIllIllIIllllI.getTileEntity(llllllllllIlllIlIIIIllIllIlIIlll);
        if (llllllllllIlllIlIIIIllIllIIlllll instanceof TileEntityBeacon) {
            llllllllllIlllIlIIIIllIllIlIIlIl.displayGUIChest((IInventory)llllllllllIlllIlIIIIllIllIIlllll);
            llllllllllIlllIlIIIIllIllIlIIlIl.addStat(StatList.BEACON_INTERACTION);
        }
        return true;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllIlllIlIIIIllIllIIlIlIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllIlllIlIIIIllIllIIllIIl) {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllIlllIlIIIIllIllIlIllll, final int llllllllllIlllIlIIIIllIllIlIlllI) {
        return new TileEntityBeacon();
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllIlllIlIIIIllIllIIIIlIl, final BlockPos llllllllllIlllIlIIIIllIllIIIlIll, final IBlockState llllllllllIlllIlIIIIllIllIIIlIlI, final EntityLivingBase llllllllllIlllIlIIIIllIllIIIlIIl, final ItemStack llllllllllIlllIlIIIIllIllIIIIIIl) {
        super.onBlockPlacedBy(llllllllllIlllIlIIIIllIllIIIIlIl, llllllllllIlllIlIIIIllIllIIIlIll, llllllllllIlllIlIIIIllIllIIIlIlI, llllllllllIlllIlIIIIllIllIIIlIIl, llllllllllIlllIlIIIIllIllIIIIIIl);
        if (llllllllllIlllIlIIIIllIllIIIIIIl.hasDisplayName()) {
            final TileEntity llllllllllIlllIlIIIIllIllIIIIlll = llllllllllIlllIlIIIIllIllIIIIlIl.getTileEntity(llllllllllIlllIlIIIIllIllIIIlIll);
            if (llllllllllIlllIlIIIIllIllIIIIlll instanceof TileEntityBeacon) {
                ((TileEntityBeacon)llllllllllIlllIlIIIIllIllIIIIlll).setName(llllllllllIlllIlIIIIllIllIIIIIIl.getDisplayName());
            }
        }
    }
}

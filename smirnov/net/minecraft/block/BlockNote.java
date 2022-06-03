// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import com.google.common.collect.Lists;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.util.SoundEvent;
import java.util.List;

public class BlockNote extends BlockContainer
{
    private static final /* synthetic */ List<SoundEvent> INSTRUMENTS;
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIlIIIIlIIIlIlllIllII, final int llllllllllllIlIIIIlIIIlIlllIlIll) {
        return new TileEntityNote();
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIlIIIIlIIIllIIIIlIlI, final BlockPos llllllllllllIlIIIIlIIIlIlllllllI, final IBlockState llllllllllllIlIIIIlIIIllIIIIlIII, final EntityPlayer llllllllllllIlIIIIlIIIlIllllllIl, final EnumHand llllllllllllIlIIIIlIIIllIIIIIllI, final EnumFacing llllllllllllIlIIIIlIIIllIIIIIlIl, final float llllllllllllIlIIIIlIIIllIIIIIlII, final float llllllllllllIlIIIIlIIIllIIIIIIll, final float llllllllllllIlIIIIlIIIllIIIIIIlI) {
        if (llllllllllllIlIIIIlIIIllIIIIlIlI.isRemote) {
            return true;
        }
        final TileEntity llllllllllllIlIIIIlIIIllIIIIIIIl = llllllllllllIlIIIIlIIIllIIIIlIlI.getTileEntity(llllllllllllIlIIIIlIIIlIlllllllI);
        if (llllllllllllIlIIIIlIIIllIIIIIIIl instanceof TileEntityNote) {
            final TileEntityNote llllllllllllIlIIIIlIIIllIIIIIIII = (TileEntityNote)llllllllllllIlIIIIlIIIllIIIIIIIl;
            llllllllllllIlIIIIlIIIllIIIIIIII.changePitch();
            llllllllllllIlIIIIlIIIllIIIIIIII.triggerNote(llllllllllllIlIIIIlIIIllIIIIlIlI, llllllllllllIlIIIIlIIIlIlllllllI);
            llllllllllllIlIIIIlIIIlIllllllIl.addStat(StatList.NOTEBLOCK_TUNED);
        }
        return true;
    }
    
    @Override
    public boolean eventReceived(final IBlockState llllllllllllIlIIIIlIIIlIllIlllll, final World llllllllllllIlIIIIlIIIlIllIllllI, final BlockPos llllllllllllIlIIIIlIIIlIllIlllIl, final int llllllllllllIlIIIIlIIIlIllIlIllI, final int llllllllllllIlIIIIlIIIlIllIlIlIl) {
        final float llllllllllllIlIIIIlIIIlIllIllIlI = (float)Math.pow(2.0, (llllllllllllIlIIIIlIIIlIllIlIlIl - 12) / 12.0);
        llllllllllllIlIIIIlIIIlIllIllllI.playSound(null, llllllllllllIlIIIIlIIIlIllIlllIl, this.getInstrument(llllllllllllIlIIIIlIIIlIllIlIllI), SoundCategory.RECORDS, 3.0f, llllllllllllIlIIIIlIIIlIllIllIlI);
        llllllllllllIlIIIIlIIIlIllIllllI.spawnParticle(EnumParticleTypes.NOTE, llllllllllllIlIIIIlIIIlIllIlllIl.getX() + 0.5, llllllllllllIlIIIIlIIIlIllIlllIl.getY() + 1.2, llllllllllllIlIIIIlIIIlIllIlllIl.getZ() + 0.5, llllllllllllIlIIIIlIIIlIllIlIlIl / 24.0, 0.0, 0.0, new int[0]);
        return true;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllIlIIIIlIIIlIllIlIIlI) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllIlIIIIlIIIlIllllIlIl, final BlockPos llllllllllllIlIIIIlIIIlIllllIlII, final EntityPlayer llllllllllllIlIIIIlIIIlIlllIllll) {
        if (!llllllllllllIlIIIIlIIIlIllllIlIl.isRemote) {
            final TileEntity llllllllllllIlIIIIlIIIlIllllIIlI = llllllllllllIlIIIIlIIIlIllllIlIl.getTileEntity(llllllllllllIlIIIIlIIIlIllllIlII);
            if (llllllllllllIlIIIIlIIIlIllllIIlI instanceof TileEntityNote) {
                ((TileEntityNote)llllllllllllIlIIIIlIIIlIllllIIlI).triggerNote(llllllllllllIlIIIIlIIIlIllllIlIl, llllllllllllIlIIIIlIIIlIllllIlII);
                llllllllllllIlIIIIlIIIlIlllIllll.addStat(StatList.NOTEBLOCK_PLAYED);
            }
        }
    }
    
    static {
        INSTRUMENTS = Lists.newArrayList((Object[])new SoundEvent[] { SoundEvents.BLOCK_NOTE_HARP, SoundEvents.BLOCK_NOTE_BASEDRUM, SoundEvents.BLOCK_NOTE_SNARE, SoundEvents.BLOCK_NOTE_HAT, SoundEvents.BLOCK_NOTE_BASS, SoundEvents.field_193809_ey, SoundEvents.field_193807_ew, SoundEvents.field_193810_ez, SoundEvents.field_193808_ex, SoundEvents.field_193785_eE });
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlIIIIlIIIllIIIlllIl, final World llllllllllllIlIIIIlIIIllIIIlllII, final BlockPos llllllllllllIlIIIIlIIIllIIIlIlII, final Block llllllllllllIlIIIIlIIIllIIIllIlI, final BlockPos llllllllllllIlIIIIlIIIllIIIllIIl) {
        final boolean llllllllllllIlIIIIlIIIllIIIllIII = llllllllllllIlIIIIlIIIllIIIlllII.isBlockPowered(llllllllllllIlIIIIlIIIllIIIlIlII);
        final TileEntity llllllllllllIlIIIIlIIIllIIIlIlll = llllllllllllIlIIIIlIIIllIIIlllII.getTileEntity(llllllllllllIlIIIIlIIIllIIIlIlII);
        if (llllllllllllIlIIIIlIIIllIIIlIlll instanceof TileEntityNote) {
            final TileEntityNote llllllllllllIlIIIIlIIIllIIIlIllI = (TileEntityNote)llllllllllllIlIIIIlIIIllIIIlIlll;
            if (llllllllllllIlIIIIlIIIllIIIlIllI.previousRedstoneState != llllllllllllIlIIIIlIIIllIIIllIII) {
                if (llllllllllllIlIIIIlIIIllIIIllIII) {
                    llllllllllllIlIIIIlIIIllIIIlIllI.triggerNote(llllllllllllIlIIIIlIIIllIIIlllII, llllllllllllIlIIIIlIIIllIIIlIlII);
                }
                llllllllllllIlIIIIlIIIllIIIlIllI.previousRedstoneState = llllllllllllIlIIIIlIIIllIIIllIII;
            }
        }
    }
    
    public BlockNote() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    private SoundEvent getInstrument(int llllllllllllIlIIIIlIIIlIlllIIlll) {
        if (llllllllllllIlIIIIlIIIlIlllIIlll < 0 || llllllllllllIlIIIIlIIIlIlllIIlll >= BlockNote.INSTRUMENTS.size()) {
            llllllllllllIlIIIIlIIIlIlllIIlll = 0;
        }
        return BlockNote.INSTRUMENTS.get(llllllllllllIlIIIIlIIIlIlllIIlll);
    }
}

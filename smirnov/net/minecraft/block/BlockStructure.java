// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import java.util.Random;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.block.properties.PropertyEnum;

public class BlockStructure extends BlockContainer
{
    public static final /* synthetic */ PropertyEnum<TileEntityStructure.Mode> MODE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllIIllllIllIIIIIIllIIl, final BlockPos llllllllllllIIllllIllIIIIIIllIII, final IBlockState llllllllllllIIllllIllIIIIIIllllI, final EntityLivingBase llllllllllllIIllllIllIIIIIIlIlll, final ItemStack llllllllllllIIllllIllIIIIIIlllII) {
        if (!llllllllllllIIllllIllIIIIIIllIIl.isRemote) {
            final TileEntity llllllllllllIIllllIllIIIIIIllIll = llllllllllllIIllllIllIIIIIIllIIl.getTileEntity(llllllllllllIIllllIllIIIIIIllIII);
            if (llllllllllllIIllllIllIIIIIIllIll instanceof TileEntityStructure) {
                final TileEntityStructure llllllllllllIIllllIllIIIIIIllIlI = (TileEntityStructure)llllllllllllIIllllIllIIIIIIllIll;
                llllllllllllIIllllIllIIIIIIllIlI.createdBy(llllllllllllIIllllIllIIIIIIlIlll);
            }
        }
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIIllllIllIIIIIIlIIll) {
        return 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIllllIllIIIIIIIIIII) {
        return this.getDefaultState().withProperty(BlockStructure.MODE, TileEntityStructure.Mode.getById(llllllllllllIIllllIllIIIIIIIIIII));
    }
    
    private void trigger(final TileEntityStructure llllllllllllIIllllIlIlllllIlllIl) {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode()[llllllllllllIIllllIlIlllllIlllIl.getMode().ordinal()]) {
            case 1: {
                llllllllllllIIllllIlIlllllIlllIl.save(false);
                break;
            }
            case 2: {
                llllllllllllIIllllIlIlllllIlllIl.load(false);
                break;
            }
            case 3: {
                llllllllllllIIllllIlIlllllIlllIl.unloadStructure();
                break;
            }
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIIllllIllIIIIIIIlllI, final BlockPos llllllllllllIIllllIllIIIIIIIllIl, final EnumFacing llllllllllllIIllllIllIIIIIIIllII, final float llllllllllllIIllllIllIIIIIIIlIll, final float llllllllllllIIllllIllIIIIIIIlIlI, final float llllllllllllIIllllIllIIIIIIIlIIl, final int llllllllllllIIllllIllIIIIIIIlIII, final EntityLivingBase llllllllllllIIllllIllIIIIIIIIlll) {
        return this.getDefaultState().withProperty(BlockStructure.MODE, TileEntityStructure.Mode.DATA);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllIIllllIllIIIIIIlIIIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIllllIlIlllllllllIl) {
        return llllllllllllIIllllIlIlllllllllIl.getValue(BlockStructure.MODE).getModeId();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = BlockStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        }
        final float llllllllllllIIllllIlIlllllIllIll = (Object)new int[TileEntityStructure.Mode.values().length];
        try {
            llllllllllllIIllllIlIlllllIllIll[TileEntityStructure.Mode.CORNER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIllllIlIlllllIllIll[TileEntityStructure.Mode.DATA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIllllIlIlllllIllIll[TileEntityStructure.Mode.LOAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIllllIlIlllllIllIll[TileEntityStructure.Mode.SAVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = (int[])(Object)llllllllllllIIllllIlIlllllIllIll;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIIllllIllIIIIIlllIll, final int llllllllllllIIllllIllIIIIIlllIlI) {
        return new TileEntityStructure();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStructure.MODE });
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIIllllIlIlllllllIIII, final World llllllllllllIIllllIlIllllllIIllI, final BlockPos llllllllllllIIllllIlIllllllIlllI, final Block llllllllllllIIllllIlIllllllIllIl, final BlockPos llllllllllllIIllllIlIllllllIllII) {
        if (!llllllllllllIIllllIlIllllllIIllI.isRemote) {
            final TileEntity llllllllllllIIllllIlIllllllIlIll = llllllllllllIIllllIlIllllllIIllI.getTileEntity(llllllllllllIIllllIlIllllllIlllI);
            if (llllllllllllIIllllIlIllllllIlIll instanceof TileEntityStructure) {
                final TileEntityStructure llllllllllllIIllllIlIllllllIlIlI = (TileEntityStructure)llllllllllllIIllllIlIllllllIlIll;
                final boolean llllllllllllIIllllIlIllllllIlIIl = llllllllllllIIllllIlIllllllIIllI.isBlockPowered(llllllllllllIIllllIlIllllllIlllI);
                final boolean llllllllllllIIllllIlIllllllIlIII = llllllllllllIIllllIlIllllllIlIlI.isPowered();
                if (llllllllllllIIllllIlIllllllIlIIl && !llllllllllllIIllllIlIllllllIlIII) {
                    llllllllllllIIllllIlIllllllIlIlI.setPowered(true);
                    this.trigger(llllllllllllIIllllIlIllllllIlIlI);
                }
                else if (!llllllllllllIIllllIlIllllllIlIIl && llllllllllllIIllllIlIllllllIlIII) {
                    llllllllllllIIllllIlIllllllIlIlI.setPowered(false);
                }
            }
        }
    }
    
    static {
        MODE = PropertyEnum.create("mode", TileEntityStructure.Mode.class);
    }
    
    public BlockStructure() {
        super(Material.IRON, MapColor.SILVER);
        this.setDefaultState(this.blockState.getBaseState());
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIIllllIllIIIIIlIlIlI, final BlockPos llllllllllllIIllllIllIIIIIlIlIIl, final IBlockState llllllllllllIIllllIllIIIIIllIIlI, final EntityPlayer llllllllllllIIllllIllIIIIIllIIIl, final EnumHand llllllllllllIIllllIllIIIIIllIIII, final EnumFacing llllllllllllIIllllIllIIIIIlIllll, final float llllllllllllIIllllIllIIIIIlIlllI, final float llllllllllllIIllllIllIIIIIlIllIl, final float llllllllllllIIllllIllIIIIIlIllII) {
        final TileEntity llllllllllllIIllllIllIIIIIlIlIll = llllllllllllIIllllIllIIIIIlIlIlI.getTileEntity(llllllllllllIIllllIllIIIIIlIlIIl);
        return llllllllllllIIllllIllIIIIIlIlIll instanceof TileEntityStructure && ((TileEntityStructure)llllllllllllIIllllIllIIIIIlIlIll).usedBy(llllllllllllIIllllIllIIIIIllIIIl);
    }
}

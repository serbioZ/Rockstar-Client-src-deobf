// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.StringUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import org.apache.logging.log4j.LogManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.GameRules;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.world.World;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import org.apache.logging.log4j.Logger;
import net.minecraft.block.properties.PropertyBool;

public class BlockCommandBlock extends BlockContainer
{
    public static final /* synthetic */ PropertyBool CONDITIONAL;
    private static final /* synthetic */ Logger field_193388_c;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllIIlIIlllllllllllIIIII) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public int tickRate(final World lllllllllllIIlIlIIIIIIIIIIlIIIIl) {
        return 1;
    }
    
    public BlockCommandBlock(final MapColor lllllllllllIIlIlIIIIIIIIIlllIIlI) {
        super(Material.IRON, lllllllllllIIlIlIIIIIIIIIlllIIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, false));
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIlIIlllllllllllIIIlI) {
        return 0;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllIIlIlIIIIIIIIIIIIllII) {
        return true;
    }
    
    private static void func_193386_c(final World lllllllllllIIlIIlllllllllIIllllI, final BlockPos lllllllllllIIlIIlllllllllIIlllIl, EnumFacing lllllllllllIIlIIlllllllllIIlllII) {
        final BlockPos.MutableBlockPos lllllllllllIIlIIlllllllllIlIIlll = new BlockPos.MutableBlockPos(lllllllllllIIlIIlllllllllIIlllIl);
        final GameRules lllllllllllIIlIIlllllllllIlIIllI = lllllllllllIIlIIlllllllllIIllllI.getGameRules();
        int lllllllllllIIlIIlllllllllIlIIlIl = lllllllllllIIlIIlllllllllIlIIllI.getInt("maxCommandChainLength");
        while (lllllllllllIIlIIlllllllllIlIIlIl-- > 0) {
            lllllllllllIIlIIlllllllllIlIIlll.move((EnumFacing)lllllllllllIIlIIlllllllllIIlllII);
            final IBlockState lllllllllllIIlIIlllllllllIlIIlII = lllllllllllIIlIIlllllllllIIllllI.getBlockState(lllllllllllIIlIIlllllllllIlIIlll);
            final Block lllllllllllIIlIIlllllllllIlIIIll = lllllllllllIIlIIlllllllllIlIIlII.getBlock();
            if (lllllllllllIIlIIlllllllllIlIIIll != Blocks.CHAIN_COMMAND_BLOCK) {
                break;
            }
            final TileEntity lllllllllllIIlIIlllllllllIlIIIlI = lllllllllllIIlIIlllllllllIIllllI.getTileEntity(lllllllllllIIlIIlllllllllIlIIlll);
            if (!(lllllllllllIIlIIlllllllllIlIIIlI instanceof TileEntityCommandBlock)) {
                break;
            }
            final TileEntityCommandBlock lllllllllllIIlIIlllllllllIlIIIIl = (TileEntityCommandBlock)lllllllllllIIlIIlllllllllIlIIIlI;
            if (lllllllllllIIlIIlllllllllIlIIIIl.getMode() != TileEntityCommandBlock.Mode.SEQUENCE) {
                break;
            }
            if (lllllllllllIIlIIlllllllllIlIIIIl.isPowered() || lllllllllllIIlIIlllllllllIlIIIIl.isAuto()) {
                final CommandBlockBaseLogic lllllllllllIIlIIlllllllllIlIIIII = lllllllllllIIlIIlllllllllIlIIIIl.getCommandBlockLogic();
                if (lllllllllllIIlIIlllllllllIlIIIIl.setConditionMet()) {
                    if (!lllllllllllIIlIIlllllllllIlIIIII.trigger(lllllllllllIIlIIlllllllllIIllllI)) {
                        break;
                    }
                    lllllllllllIIlIIlllllllllIIllllI.updateComparatorOutputLevel(lllllllllllIIlIIlllllllllIlIIlll, lllllllllllIIlIIlllllllllIlIIIll);
                }
                else if (lllllllllllIIlIIlllllllllIlIIIIl.isConditional()) {
                    lllllllllllIIlIIlllllllllIlIIIII.setSuccessCount(0);
                }
            }
            lllllllllllIIlIIlllllllllIIlllII = lllllllllllIIlIIlllllllllIlIIlII.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING);
        }
        if (lllllllllllIIlIIlllllllllIlIIlIl <= 0) {
            final int lllllllllllIIlIIlllllllllIIlllll = Math.max(lllllllllllIIlIIlllllllllIlIIllI.getInt("maxCommandChainLength"), 0);
            BlockCommandBlock.field_193388_c.warn("Commandblock chain tried to execure more than " + lllllllllllIIlIIlllllllllIIlllll + " steps!");
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllIIlIIllllllllllllIllI, final BlockPos lllllllllllIIlIIllllllllllllIlIl, final IBlockState lllllllllllIIlIIllllllllllllIlII, final EntityLivingBase lllllllllllIIlIIllllllllllllIIll, final ItemStack lllllllllllIIlIIlllllllllllIlIIl) {
        final TileEntity lllllllllllIIlIIllllllllllllIIIl = lllllllllllIIlIIllllllllllllIllI.getTileEntity(lllllllllllIIlIIllllllllllllIlIl);
        if (lllllllllllIIlIIllllllllllllIIIl instanceof TileEntityCommandBlock) {
            final TileEntityCommandBlock lllllllllllIIlIIllllllllllllIIII = (TileEntityCommandBlock)lllllllllllIIlIIllllllllllllIIIl;
            final CommandBlockBaseLogic lllllllllllIIlIIlllllllllllIllll = lllllllllllIIlIIllllllllllllIIII.getCommandBlockLogic();
            if (lllllllllllIIlIIlllllllllllIlIIl.hasDisplayName()) {
                lllllllllllIIlIIlllllllllllIllll.setName(lllllllllllIIlIIlllllllllllIlIIl.getDisplayName());
            }
            if (!lllllllllllIIlIIllllllllllllIllI.isRemote) {
                final NBTTagCompound lllllllllllIIlIIlllllllllllIlllI = lllllllllllIIlIIlllllllllllIlIIl.getTagCompound();
                if (lllllllllllIIlIIlllllllllllIlllI == null || !lllllllllllIIlIIlllllllllllIlllI.hasKey("BlockEntityTag", 10)) {
                    lllllllllllIIlIIlllllllllllIllll.setTrackOutput(lllllllllllIIlIIllllllllllllIllI.getGameRules().getBoolean("sendCommandFeedback"));
                    lllllllllllIIlIIllllllllllllIIII.setAuto(this == Blocks.CHAIN_COMMAND_BLOCK);
                }
                if (lllllllllllIIlIIllllllllllllIIII.getMode() == TileEntityCommandBlock.Mode.SEQUENCE) {
                    final boolean lllllllllllIIlIIlllllllllllIllIl = lllllllllllIIlIIllllllllllllIllI.isBlockPowered(lllllllllllIIlIIllllllllllllIlIl);
                    lllllllllllIIlIIllllllllllllIIII.setPowered(lllllllllllIIlIIlllllllllllIllIl);
                }
            }
        }
    }
    
    static {
        field_193388_c = LogManager.getLogger();
        FACING = BlockDirectional.FACING;
        CONDITIONAL = PropertyBool.create("conditional");
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIIllllllllllIlIllI) {
        return lllllllllllIIlIIllllllllllIlIllI.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING).getIndex() | (lllllllllllIIlIIllllllllllIlIllI.getValue((IProperty<Boolean>)BlockCommandBlock.CONDITIONAL) ? 8 : 0);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlIIllllllllllIlIIII, final Rotation lllllllllllIIlIIllllllllllIIllll) {
        return lllllllllllIIlIIllllllllllIlIIII.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, lllllllllllIIlIIllllllllllIIllll.rotate(lllllllllllIIlIIllllllllllIlIIII.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING)));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIlIlIIIIIIIIIllIIIIl, final World lllllllllllIIlIlIIIIIIIIIllIIIII, final BlockPos lllllllllllIIlIlIIIIIIIIIlIlllll, final Block lllllllllllIIlIlIIIIIIIIIlIllllI, final BlockPos lllllllllllIIlIlIIIIIIIIIlIlllIl) {
        if (!lllllllllllIIlIlIIIIIIIIIllIIIII.isRemote) {
            final TileEntity lllllllllllIIlIlIIIIIIIIIlIlllII = lllllllllllIIlIlIIIIIIIIIllIIIII.getTileEntity(lllllllllllIIlIlIIIIIIIIIlIlllll);
            if (lllllllllllIIlIlIIIIIIIIIlIlllII instanceof TileEntityCommandBlock) {
                final TileEntityCommandBlock lllllllllllIIlIlIIIIIIIIIlIllIll = (TileEntityCommandBlock)lllllllllllIIlIlIIIIIIIIIlIlllII;
                final boolean lllllllllllIIlIlIIIIIIIIIlIllIlI = lllllllllllIIlIlIIIIIIIIIllIIIII.isBlockPowered(lllllllllllIIlIlIIIIIIIIIlIlllll);
                final boolean lllllllllllIIlIlIIIIIIIIIlIllIIl = lllllllllllIIlIlIIIIIIIIIlIllIll.isPowered();
                lllllllllllIIlIlIIIIIIIIIlIllIll.setPowered(lllllllllllIIlIlIIIIIIIIIlIllIlI);
                if (!lllllllllllIIlIlIIIIIIIIIlIllIIl && !lllllllllllIIlIlIIIIIIIIIlIllIll.isAuto() && lllllllllllIIlIlIIIIIIIIIlIllIll.getMode() != TileEntityCommandBlock.Mode.SEQUENCE && lllllllllllIIlIlIIIIIIIIIlIllIlI) {
                    lllllllllllIIlIlIIIIIIIIIlIllIll.setConditionMet();
                    lllllllllllIIlIlIIIIIIIIIllIIIII.scheduleUpdate(lllllllllllIIlIlIIIIIIIIIlIlllll, this, this.tickRate(lllllllllllIIlIlIIIIIIIIIllIIIII));
                }
            }
        }
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllIIlIlIIIIIIIIIIIIIlll, final World lllllllllllIIlIlIIIIIIIIIIIIIIll, final BlockPos lllllllllllIIlIlIIIIIIIIIIIIIIlI) {
        final TileEntity lllllllllllIIlIlIIIIIIIIIIIIIlII = lllllllllllIIlIlIIIIIIIIIIIIIIll.getTileEntity(lllllllllllIIlIlIIIIIIIIIIIIIIlI);
        return (lllllllllllIIlIlIIIIIIIIIIIIIlII instanceof TileEntityCommandBlock) ? ((TileEntityCommandBlock)lllllllllllIIlIlIIIIIIIIIIIIIlII).getCommandBlockLogic().getSuccessCount() : 0;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIlIIllllllllllIIlIIl, final Mirror lllllllllllIIlIIllllllllllIIlIII) {
        return lllllllllllIIlIIllllllllllIIlIIl.withRotation(lllllllllllIIlIIllllllllllIIlIII.toRotation(lllllllllllIIlIIllllllllllIIlIIl.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING)));
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIIlIlIIIIIIIIIllIlllI, final int lllllllllllIIlIlIIIIIIIIIllIllIl) {
        final TileEntityCommandBlock lllllllllllIIlIlIIIIIIIIIllIllII = new TileEntityCommandBlock();
        lllllllllllIIlIlIIIIIIIIIllIllII.setAuto(this == Blocks.CHAIN_COMMAND_BLOCK);
        return lllllllllllIIlIlIIIIIIIIIllIllII;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIlIlIIIIIIIIIIIlIIIl, final BlockPos lllllllllllIIlIlIIIIIIIIIIIlIIII, final IBlockState lllllllllllIIlIlIIIIIIIIIIIllIIl, final EntityPlayer lllllllllllIIlIlIIIIIIIIIIIllIII, final EnumHand lllllllllllIIlIlIIIIIIIIIIIlIlll, final EnumFacing lllllllllllIIlIlIIIIIIIIIIIlIllI, final float lllllllllllIIlIlIIIIIIIIIIIlIlIl, final float lllllllllllIIlIlIIIIIIIIIIIlIlII, final float lllllllllllIIlIlIIIIIIIIIIIlIIll) {
        final TileEntity lllllllllllIIlIlIIIIIIIIIIIlIIlI = lllllllllllIIlIlIIIIIIIIIIIlIIIl.getTileEntity(lllllllllllIIlIlIIIIIIIIIIIlIIII);
        if (lllllllllllIIlIlIIIIIIIIIIIlIIlI instanceof TileEntityCommandBlock && lllllllllllIIlIlIIIIIIIIIIIllIII.canUseCommandBlock()) {
            lllllllllllIIlIlIIIIIIIIIIIllIII.displayGuiCommandBlock((TileEntityCommandBlock)lllllllllllIIlIlIIIIIIIIIIIlIIlI);
            return true;
        }
        return false;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIlIIllllllllllIIIIII, final BlockPos lllllllllllIIlIIlllllllllIllIlll, final EnumFacing lllllllllllIIlIIlllllllllIlllllI, final float lllllllllllIIlIIlllllllllIllllIl, final float lllllllllllIIlIIlllllllllIllllII, final float lllllllllllIIlIIlllllllllIlllIll, final int lllllllllllIIlIIlllllllllIlllIlI, final EntityLivingBase lllllllllllIIlIIlllllllllIlllIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, EnumFacing.func_190914_a(lllllllllllIIlIIlllllllllIllIlll, lllllllllllIIlIIlllllllllIlllIIl)).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, false);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlIIllllllllllIlllII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, EnumFacing.getFront(lllllllllllIIlIIllllllllllIlllII & 0x7)).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, (lllllllllllIIlIIllllllllllIlllII & 0x8) != 0x0);
    }
    
    private void func_193387_a(final IBlockState lllllllllllIIlIlIIIIIIIIIIlIIlll, final World lllllllllllIIlIlIIIIIIIIIIlIIllI, final BlockPos lllllllllllIIlIlIIIIIIIIIIlIlIlI, final CommandBlockBaseLogic lllllllllllIIlIlIIIIIIIIIIlIIlII, final boolean lllllllllllIIlIlIIIIIIIIIIlIIIll) {
        if (lllllllllllIIlIlIIIIIIIIIIlIIIll) {
            lllllllllllIIlIlIIIIIIIIIIlIIlII.trigger(lllllllllllIIlIlIIIIIIIIIIlIIllI);
        }
        else {
            lllllllllllIIlIlIIIIIIIIIIlIIlII.setSuccessCount(0);
        }
        func_193386_c(lllllllllllIIlIlIIIIIIIIIIlIIllI, lllllllllllIIlIlIIIIIIIIIIlIlIlI, lllllllllllIIlIlIIIIIIIIIIlIIlll.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING));
    }
    
    @Override
    public void updateTick(final World lllllllllllIIlIlIIIIIIIIIlIIIllI, final BlockPos lllllllllllIIlIlIIIIIIIIIlIIIlIl, final IBlockState lllllllllllIIlIlIIIIIIIIIlIIIlII, final Random lllllllllllIIlIlIIIIIIIIIlIIIIll) {
        if (!lllllllllllIIlIlIIIIIIIIIlIIIllI.isRemote) {
            final TileEntity lllllllllllIIlIlIIIIIIIIIlIIIIlI = lllllllllllIIlIlIIIIIIIIIlIIIllI.getTileEntity(lllllllllllIIlIlIIIIIIIIIlIIIlIl);
            if (lllllllllllIIlIlIIIIIIIIIlIIIIlI instanceof TileEntityCommandBlock) {
                final TileEntityCommandBlock lllllllllllIIlIlIIIIIIIIIlIIIIIl = (TileEntityCommandBlock)lllllllllllIIlIlIIIIIIIIIlIIIIlI;
                final CommandBlockBaseLogic lllllllllllIIlIlIIIIIIIIIlIIIIII = lllllllllllIIlIlIIIIIIIIIlIIIIIl.getCommandBlockLogic();
                final boolean lllllllllllIIlIlIIIIIIIIIIllllll = !StringUtils.isNullOrEmpty(lllllllllllIIlIlIIIIIIIIIlIIIIII.getCommand());
                final TileEntityCommandBlock.Mode lllllllllllIIlIlIIIIIIIIIIlllllI = lllllllllllIIlIlIIIIIIIIIlIIIIIl.getMode();
                final boolean lllllllllllIIlIlIIIIIIIIIIllllIl = lllllllllllIIlIlIIIIIIIIIlIIIIIl.isConditionMet();
                if (lllllllllllIIlIlIIIIIIIIIIlllllI == TileEntityCommandBlock.Mode.AUTO) {
                    lllllllllllIIlIlIIIIIIIIIlIIIIIl.setConditionMet();
                    if (lllllllllllIIlIlIIIIIIIIIIllllIl) {
                        this.func_193387_a(lllllllllllIIlIlIIIIIIIIIlIIIlII, lllllllllllIIlIlIIIIIIIIIlIIIllI, lllllllllllIIlIlIIIIIIIIIlIIIlIl, lllllllllllIIlIlIIIIIIIIIlIIIIII, lllllllllllIIlIlIIIIIIIIIIllllll);
                    }
                    else if (lllllllllllIIlIlIIIIIIIIIlIIIIIl.isConditional()) {
                        lllllllllllIIlIlIIIIIIIIIlIIIIII.setSuccessCount(0);
                    }
                    if (lllllllllllIIlIlIIIIIIIIIlIIIIIl.isPowered() || lllllllllllIIlIlIIIIIIIIIlIIIIIl.isAuto()) {
                        lllllllllllIIlIlIIIIIIIIIlIIIllI.scheduleUpdate(lllllllllllIIlIlIIIIIIIIIlIIIlIl, this, this.tickRate(lllllllllllIIlIlIIIIIIIIIlIIIllI));
                    }
                }
                else if (lllllllllllIIlIlIIIIIIIIIIlllllI == TileEntityCommandBlock.Mode.REDSTONE) {
                    if (lllllllllllIIlIlIIIIIIIIIIllllIl) {
                        this.func_193387_a(lllllllllllIIlIlIIIIIIIIIlIIIlII, lllllllllllIIlIlIIIIIIIIIlIIIllI, lllllllllllIIlIlIIIIIIIIIlIIIlIl, lllllllllllIIlIlIIIIIIIIIlIIIIII, lllllllllllIIlIlIIIIIIIIIIllllll);
                    }
                    else if (lllllllllllIIlIlIIIIIIIIIlIIIIIl.isConditional()) {
                        lllllllllllIIlIlIIIIIIIIIlIIIIII.setSuccessCount(0);
                    }
                }
                lllllllllllIIlIlIIIIIIIIIlIIIllI.updateComparatorOutputLevel(lllllllllllIIlIlIIIIIIIIIlIIIlIl, this);
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCommandBlock.FACING, BlockCommandBlock.CONDITIONAL });
    }
}

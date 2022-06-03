// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyBool;

public class BlockPressurePlate extends BlockBasePressurePlate
{
    private final /* synthetic */ Sensitivity sensitivity;
    public static final /* synthetic */ PropertyBool POWERED;
    
    @Override
    protected void playClickOnSound(final World llllllllllllIlIIIIlIIllIlIIIIllI, final BlockPos llllllllllllIlIIIIlIIllIlIIIlIII) {
        if (this.blockMaterial == Material.WOOD) {
            llllllllllllIlIIIIlIIllIlIIIIllI.playSound(null, llllllllllllIlIIIIlIIllIlIIIlIII, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.8f);
        }
        else {
            llllllllllllIlIIIIlIIllIlIIIIllI.playSound(null, llllllllllllIlIIIIlIIllIlIIIlIII, SoundEvents.BLOCK_STONE_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    @Override
    protected int getRedstoneStrength(final IBlockState llllllllllllIlIIIIlIIllIlIIlIlIl) {
        return llllllllllllIlIIIIlIIllIlIIlIlIl.getValue((IProperty<Boolean>)BlockPressurePlate.POWERED) ? 15 : 0;
    }
    
    protected BlockPressurePlate(final Material llllllllllllIlIIIIlIIllIlIIllIlI, final Sensitivity llllllllllllIlIIIIlIIllIlIIllIIl) {
        super(llllllllllllIlIIIIlIIllIlIIllIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPressurePlate.POWERED, false));
        this.sensitivity = llllllllllllIlIIIIlIIllIlIIllIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity = BlockPressurePlate.$SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity;
        if ($switch_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity != null) {
            return $switch_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity;
        }
        final double llllllllllllIlIIIIlIIllIIlIlIlll = (Object)new int[Sensitivity.values().length];
        try {
            llllllllllllIlIIIIlIIllIIlIlIlll[Sensitivity.EVERYTHING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIIIIlIIllIIlIlIlll[Sensitivity.MOBS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return BlockPressurePlate.$SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity = (int[])(Object)llllllllllllIlIIIIlIIllIIlIlIlll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPressurePlate.POWERED });
    }
    
    static {
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlIIIIlIIllIIlIlllII) {
        return ((boolean)llllllllllllIlIIIIlIIllIIlIlllII.getValue((IProperty<Boolean>)BlockPressurePlate.POWERED)) ? 1 : 0;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlIIIIlIIllIIllIIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPressurePlate.POWERED, llllllllllllIlIIIIlIIllIIllIIIlI == 1);
    }
    
    @Override
    protected int computeRedstoneStrength(final World llllllllllllIlIIIIlIIllIIllIlIll, final BlockPos llllllllllllIlIIIIlIIllIIllIlIlI) {
        final AxisAlignedBB llllllllllllIlIIIIlIIllIIlllIIIl = BlockPressurePlate.PRESSURE_AABB.offset(llllllllllllIlIIIIlIIllIIllIlIlI);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity()[this.sensitivity.ordinal()]) {
            case 1: {
                final List<? extends Entity> llllllllllllIlIIIIlIIllIIlllIIII = llllllllllllIlIIIIlIIllIIllIlIll.getEntitiesWithinAABBExcludingEntity(null, llllllllllllIlIIIIlIIllIIlllIIIl);
                break;
            }
            case 2: {
                final List<? extends Entity> llllllllllllIlIIIIlIIllIIllIllll = llllllllllllIlIIIIlIIllIIllIlIll.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, llllllllllllIlIIIIlIIllIIlllIIIl);
                break;
            }
            default: {
                return 0;
            }
        }
        final List<? extends Entity> llllllllllllIlIIIIlIIllIIllIlllI;
        if (!llllllllllllIlIIIIlIIllIIllIlllI.isEmpty()) {
            for (final Entity llllllllllllIlIIIIlIIllIIllIllIl : llllllllllllIlIIIIlIIllIIllIlllI) {
                if (!llllllllllllIlIIIIlIIllIIllIllIl.doesEntityNotTriggerPressurePlate()) {
                    return 15;
                }
            }
        }
        return 0;
    }
    
    @Override
    protected IBlockState setRedstoneStrength(final IBlockState llllllllllllIlIIIIlIIllIlIIlIIIl, final int llllllllllllIlIIIIlIIllIlIIIlllI) {
        return llllllllllllIlIIIIlIIllIlIIlIIIl.withProperty((IProperty<Comparable>)BlockPressurePlate.POWERED, llllllllllllIlIIIIlIIllIlIIIlllI > 0);
    }
    
    @Override
    protected void playClickOffSound(final World llllllllllllIlIIIIlIIllIlIIIIIII, final BlockPos llllllllllllIlIIIIlIIllIIlllllII) {
        if (this.blockMaterial == Material.WOOD) {
            llllllllllllIlIIIIlIIllIlIIIIIII.playSound(null, llllllllllllIlIIIIlIIllIIlllllII, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.7f);
        }
        else {
            llllllllllllIlIIIIlIIllIlIIIIIII.playSound(null, llllllllllllIlIIIIlIIllIIlllllII, SoundEvents.BLOCK_STONE_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.5f);
        }
    }
    
    public enum Sensitivity
    {
        MOBS("MOBS", 1), 
        EVERYTHING("EVERYTHING", 0);
        
        private Sensitivity(final String lIllIllIlIIIIll, final int lIllIllIlIIIIlI) {
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure;

import net.minecraft.block.state.IBlockProperties;
import java.util.List;
import net.minecraft.nbt.NBTBase;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.block.BlockDispenser;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;

public abstract class StructureComponent
{
    protected /* synthetic */ int componentType;
    private /* synthetic */ Mirror mirror;
    protected /* synthetic */ StructureBoundingBox boundingBox;
    @Nullable
    private /* synthetic */ EnumFacing coordBaseMode;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private /* synthetic */ Rotation rotation;
    
    protected boolean isLiquidInStructureBoundingBox(final World lllllllllllIllllIllIIllIIIlllIlI, final StructureBoundingBox lllllllllllIllllIllIIllIIIlllIIl) {
        final int lllllllllllIllllIllIIllIIlIIlIII = Math.max(this.boundingBox.minX - 1, lllllllllllIllllIllIIllIIIlllIIl.minX);
        final int lllllllllllIllllIllIIllIIlIIIlll = Math.max(this.boundingBox.minY - 1, lllllllllllIllllIllIIllIIIlllIIl.minY);
        final int lllllllllllIllllIllIIllIIlIIIllI = Math.max(this.boundingBox.minZ - 1, lllllllllllIllllIllIIllIIIlllIIl.minZ);
        final int lllllllllllIllllIllIIllIIlIIIlIl = Math.min(this.boundingBox.maxX + 1, lllllllllllIllllIllIIllIIIlllIIl.maxX);
        final int lllllllllllIllllIllIIllIIlIIIlII = Math.min(this.boundingBox.maxY + 1, lllllllllllIllllIllIIllIIIlllIIl.maxY);
        final int lllllllllllIllllIllIIllIIlIIIIll = Math.min(this.boundingBox.maxZ + 1, lllllllllllIllllIllIIllIIIlllIIl.maxZ);
        final BlockPos.MutableBlockPos lllllllllllIllllIllIIllIIlIIIIlI = new BlockPos.MutableBlockPos();
        for (int lllllllllllIllllIllIIllIIlIIIIIl = lllllllllllIllllIllIIllIIlIIlIII; lllllllllllIllllIllIIllIIlIIIIIl <= lllllllllllIllllIllIIllIIlIIIlIl; ++lllllllllllIllllIllIIllIIlIIIIIl) {
            for (int lllllllllllIllllIllIIllIIlIIIIII = lllllllllllIllllIllIIllIIlIIIllI; lllllllllllIllllIllIIllIIlIIIIII <= lllllllllllIllllIllIIllIIlIIIIll; ++lllllllllllIllllIllIIllIIlIIIIII) {
                if (lllllllllllIllllIllIIllIIIlllIlI.getBlockState(lllllllllllIllllIllIIllIIlIIIIlI.setPos(lllllllllllIllllIllIIllIIlIIIIIl, lllllllllllIllllIllIIllIIlIIIlll, lllllllllllIllllIllIIllIIlIIIIII)).getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllIllllIllIIllIIIlllIlI.getBlockState(lllllllllllIllllIllIIllIIlIIIIlI.setPos(lllllllllllIllllIllIIllIIlIIIIIl, lllllllllllIllllIllIIllIIlIIIlII, lllllllllllIllllIllIIllIIlIIIIII)).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int lllllllllllIllllIllIIllIIIllllll = lllllllllllIllllIllIIllIIlIIlIII; lllllllllllIllllIllIIllIIIllllll <= lllllllllllIllllIllIIllIIlIIIlIl; ++lllllllllllIllllIllIIllIIIllllll) {
            for (int lllllllllllIllllIllIIllIIIlllllI = lllllllllllIllllIllIIllIIlIIIlll; lllllllllllIllllIllIIllIIIlllllI <= lllllllllllIllllIllIIllIIlIIIlII; ++lllllllllllIllllIllIIllIIIlllllI) {
                if (lllllllllllIllllIllIIllIIIlllIlI.getBlockState(lllllllllllIllllIllIIllIIlIIIIlI.setPos(lllllllllllIllllIllIIllIIIllllll, lllllllllllIllllIllIIllIIIlllllI, lllllllllllIllllIllIIllIIlIIIllI)).getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllIllllIllIIllIIIlllIlI.getBlockState(lllllllllllIllllIllIIllIIlIIIIlI.setPos(lllllllllllIllllIllIIllIIIllllll, lllllllllllIllllIllIIllIIIlllllI, lllllllllllIllllIllIIllIIlIIIIll)).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int lllllllllllIllllIllIIllIIIllllIl = lllllllllllIllllIllIIllIIlIIIllI; lllllllllllIllllIllIIllIIIllllIl <= lllllllllllIllllIllIIllIIlIIIIll; ++lllllllllllIllllIllIIllIIIllllIl) {
            for (int lllllllllllIllllIllIIllIIIllllII = lllllllllllIllllIllIIllIIlIIIlll; lllllllllllIllllIllIIllIIIllllII <= lllllllllllIllllIllIIllIIlIIIlII; ++lllllllllllIllllIllIIllIIIllllII) {
                if (lllllllllllIllllIllIIllIIIlllIlI.getBlockState(lllllllllllIllllIllIIllIIlIIIIlI.setPos(lllllllllllIllllIllIIllIIlIIlIII, lllllllllllIllllIllIIllIIIllllII, lllllllllllIllllIllIIllIIIllllIl)).getMaterial().isLiquid()) {
                    return true;
                }
                if (lllllllllllIllllIllIIllIIIlllIlI.getBlockState(lllllllllllIllllIllIIllIIlIIIIlI.setPos(lllllllllllIllllIllIIllIIlIIIlIl, lllllllllllIllllIllIIllIIIllllII, lllllllllllIllllIllIIllIIIllllIl)).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected int getYWithOffset(final int lllllllllllIllllIllIIllIIIlIIIII) {
        return (this.getCoordBaseMode() == null) ? lllllllllllIllllIllIIllIIIlIIIII : (lllllllllllIllllIllIIllIIIlIIIII + this.boundingBox.minY);
    }
    
    protected void fillWithRandomizedBlocks(final World lllllllllllIllllIllIIlIlIlIlllII, final StructureBoundingBox lllllllllllIllllIllIIlIlIlIIllII, final int lllllllllllIllllIllIIlIlIlIIlIll, final int lllllllllllIllllIllIIlIlIlIIlIlI, final int lllllllllllIllllIllIIlIlIlIllIII, final int lllllllllllIllllIllIIlIlIlIIlIII, final int lllllllllllIllllIllIIlIlIlIlIllI, final int lllllllllllIllllIllIIlIlIlIIIllI, final boolean lllllllllllIllllIllIIlIlIlIlIlII, final Random lllllllllllIllllIllIIlIlIlIIIlII, final BlockSelector lllllllllllIllllIllIIlIlIlIlIIlI) {
        for (int lllllllllllIllllIllIIlIlIlIlIIIl = lllllllllllIllllIllIIlIlIlIIlIlI; lllllllllllIllllIllIIlIlIlIlIIIl <= lllllllllllIllllIllIIlIlIlIlIllI; ++lllllllllllIllllIllIIlIlIlIlIIIl) {
            for (int lllllllllllIllllIllIIlIlIlIlIIII = lllllllllllIllllIllIIlIlIlIIlIll; lllllllllllIllllIllIIlIlIlIlIIII <= lllllllllllIllllIllIIlIlIlIIlIII; ++lllllllllllIllllIllIIlIlIlIlIIII) {
                for (int lllllllllllIllllIllIIlIlIlIIllll = lllllllllllIllllIllIIlIlIlIllIII; lllllllllllIllllIllIIlIlIlIIllll <= lllllllllllIllllIllIIlIlIlIIIllI; ++lllllllllllIllllIllIIlIlIlIIllll) {
                    if (!lllllllllllIllllIllIIlIlIlIlIlII || this.getBlockStateFromPos(lllllllllllIllllIllIIlIlIlIlllII, lllllllllllIllllIllIIlIlIlIlIIII, lllllllllllIllllIllIIlIlIlIlIIIl, lllllllllllIllllIllIIlIlIlIIllll, lllllllllllIllllIllIIlIlIlIIllII).getMaterial() != Material.AIR) {
                        lllllllllllIllllIllIIlIlIlIlIIlI.selectBlocks(lllllllllllIllllIllIIlIlIlIIIlII, lllllllllllIllllIllIIlIlIlIlIIII, lllllllllllIllllIllIIlIlIlIlIIIl, lllllllllllIllllIllIIlIlIlIIllll, lllllllllllIllllIllIIlIlIlIlIIIl == lllllllllllIllllIllIIlIlIlIIlIlI || lllllllllllIllllIllIIlIlIlIlIIIl == lllllllllllIllllIllIIlIlIlIlIllI || lllllllllllIllllIllIIlIlIlIlIIII == lllllllllllIllllIllIIlIlIlIIlIll || lllllllllllIllllIllIIlIlIlIlIIII == lllllllllllIllllIllIIlIlIlIIlIII || lllllllllllIllllIllIIlIlIlIIllll == lllllllllllIllllIllIIlIlIlIllIII || lllllllllllIllllIllIIlIlIlIIllll == lllllllllllIllllIllIIlIlIlIIIllI);
                        this.setBlockState(lllllllllllIllllIllIIlIlIlIlllII, lllllllllllIllllIllIIlIlIlIlIIlI.getBlockState(), lllllllllllIllllIllIIlIlIlIlIIII, lllllllllllIllllIllIIlIlIlIlIIIl, lllllllllllIllllIllIIlIlIlIIllll, lllllllllllIllllIllIIlIlIlIIllII);
                    }
                }
            }
        }
    }
    
    protected int func_189916_b(final World lllllllllllIllllIllIIlIlllIlIIII, final int lllllllllllIllllIllIIlIlllIIIlIl, final int lllllllllllIllllIllIIlIlllIIlllI, final int lllllllllllIllllIllIIlIlllIIIIll, final StructureBoundingBox lllllllllllIllllIllIIlIlllIIllII) {
        final int lllllllllllIllllIllIIlIlllIIlIll = this.getXWithOffset(lllllllllllIllllIllIIlIlllIIIlIl, lllllllllllIllllIllIIlIlllIIIIll);
        final int lllllllllllIllllIllIIlIlllIIlIlI = this.getYWithOffset(lllllllllllIllllIllIIlIlllIIlllI + 1);
        final int lllllllllllIllllIllIIlIlllIIlIIl = this.getZWithOffset(lllllllllllIllllIllIIlIlllIIIlIl, lllllllllllIllllIllIIlIlllIIIIll);
        final BlockPos lllllllllllIllllIllIIlIlllIIlIII = new BlockPos(lllllllllllIllllIllIIlIlllIIlIll, lllllllllllIllllIllIIlIlllIIlIlI, lllllllllllIllllIllIIlIlllIIlIIl);
        return lllllllllllIllllIllIIlIlllIIllII.isVecInside(lllllllllllIllllIllIIlIlllIIlIII) ? lllllllllllIllllIllIIlIlllIlIIII.getLightFor(EnumSkyBlock.SKY, lllllllllllIllllIllIIlIlllIIlIII) : EnumSkyBlock.SKY.defaultLightValue;
    }
    
    protected int getZWithOffset(final int lllllllllllIllllIllIIllIIIIllIII, final int lllllllllllIllllIllIIllIIIIlIlll) {
        final EnumFacing lllllllllllIllllIllIIllIIIIlIllI = this.getCoordBaseMode();
        if (lllllllllllIllllIllIIllIIIIlIllI == null) {
            return lllllllllllIllllIllIIllIIIIlIlll;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIllllIllIIllIIIIlIllI.ordinal()]) {
            case 3: {
                return this.boundingBox.maxZ - lllllllllllIllllIllIIllIIIIlIlll;
            }
            case 4: {
                return this.boundingBox.minZ + lllllllllllIllllIllIIllIIIIlIlll;
            }
            case 5:
            case 6: {
                return this.boundingBox.minZ + lllllllllllIllllIllIIllIIIIllIII;
            }
            default: {
                return lllllllllllIllllIllIIllIIIIlIlll;
            }
        }
    }
    
    public int getComponentType() {
        return this.componentType;
    }
    
    public void readStructureBaseNBT(final World lllllllllllIllllIllIIllIIllIllll, final NBTTagCompound lllllllllllIllllIllIIllIIlllIIlI) {
        if (lllllllllllIllllIllIIllIIlllIIlI.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(lllllllllllIllllIllIIllIIlllIIlI.getIntArray("BB"));
        }
        final int lllllllllllIllllIllIIllIIlllIIIl = lllllllllllIllllIllIIllIIlllIIlI.getInteger("O");
        this.setCoordBaseMode((lllllllllllIllllIllIIllIIlllIIIl == -1) ? null : EnumFacing.getHorizontal(lllllllllllIllllIllIIllIIlllIIIl));
        this.componentType = lllllllllllIllllIllIIllIIlllIIlI.getInteger("GD");
        this.readStructureFromNBT(lllllllllllIllllIllIIllIIlllIIlI, lllllllllllIllllIllIIllIIllIllll.getSaveHandler().getStructureTemplateManager());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = StructureComponent.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double lllllllllllIllllIllIIIllllllIlIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIllllIllIIIllllllIlIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllllIllIIIllllllIlIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllllIllIIIllllllIlIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIllllIllIIIllllllIlIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIllllIllIIIllllllIlIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIllllIllIIIllllllIlIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return StructureComponent.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIllllIllIIIllllllIlIl;
    }
    
    protected void func_189915_a(final World lllllllllllIllllIllIIlIIIIIlIIlI, final StructureBoundingBox lllllllllllIllllIllIIlIIIIIllIlI, final Random lllllllllllIllllIllIIlIIIIIllIIl, final int lllllllllllIllllIllIIlIIIIIlIIII, final int lllllllllllIllllIllIIlIIIIIIllll, final int lllllllllllIllllIllIIlIIIIIIlllI, final EnumFacing lllllllllllIllllIllIIlIIIIIIllIl, final BlockDoor lllllllllllIllllIllIIlIIIIIIllII) {
        this.setBlockState(lllllllllllIllllIllIIlIIIIIlIIlI, lllllllllllIllllIllIIlIIIIIIllII.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllIllllIllIIlIIIIIIllIl), lllllllllllIllllIllIIlIIIIIlIIII, lllllllllllIllllIllIIlIIIIIIllll, lllllllllllIllllIllIIlIIIIIIlllI, lllllllllllIllllIllIIlIIIIIllIlI);
        this.setBlockState(lllllllllllIllllIllIIlIIIIIlIIlI, lllllllllllIllllIllIIlIIIIIIllII.getDefaultState().withProperty((IProperty<Comparable>)BlockDoor.FACING, lllllllllllIllllIllIIlIIIIIIllIl).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), lllllllllllIllllIllIIlIIIIIlIIII, lllllllllllIllllIllIIlIIIIIIllll + 1, lllllllllllIllllIllIIlIIIIIIlllI, lllllllllllIllllIllIIlIIIIIllIlI);
    }
    
    protected abstract void writeStructureToNBT(final NBTTagCompound p0);
    
    public void setCoordBaseMode(@Nullable final EnumFacing lllllllllllIllllIllIIIllllllIlll) {
        this.coordBaseMode = lllllllllllIllllIllIIIllllllIlll;
        if (lllllllllllIllllIllIIIllllllIlll == null) {
            this.rotation = Rotation.NONE;
            this.mirror = Mirror.NONE;
        }
        else {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIllllIllIIIllllllIlll.ordinal()]) {
                case 4: {
                    this.mirror = Mirror.LEFT_RIGHT;
                    this.rotation = Rotation.NONE;
                    break;
                }
                case 5: {
                    this.mirror = Mirror.LEFT_RIGHT;
                    this.rotation = Rotation.CLOCKWISE_90;
                    break;
                }
                case 6: {
                    this.mirror = Mirror.NONE;
                    this.rotation = Rotation.CLOCKWISE_90;
                    break;
                }
                default: {
                    this.mirror = Mirror.NONE;
                    this.rotation = Rotation.NONE;
                    break;
                }
            }
        }
    }
    
    protected int getXWithOffset(final int lllllllllllIllllIllIIllIIIlIIllI, final int lllllllllllIllllIllIIllIIIlIlIIl) {
        final EnumFacing lllllllllllIllllIllIIllIIIlIlIII = this.getCoordBaseMode();
        if (lllllllllllIllllIllIIllIIIlIlIII == null) {
            return lllllllllllIllllIllIIllIIIlIIllI;
        }
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIllllIllIIllIIIlIlIII.ordinal()]) {
            case 3:
            case 4: {
                return this.boundingBox.minX + lllllllllllIllllIllIIllIIIlIIllI;
            }
            case 5: {
                return this.boundingBox.maxX - lllllllllllIllllIllIIllIIIlIlIIl;
            }
            case 6: {
                return this.boundingBox.minX + lllllllllllIllllIllIIllIIIlIlIIl;
            }
            default: {
                return lllllllllllIllllIllIIllIIIlIIllI;
            }
        }
    }
    
    public abstract boolean addComponentParts(final World p0, final Random p1, final StructureBoundingBox p2);
    
    public StructureComponent() {
    }
    
    protected abstract void readStructureFromNBT(final NBTTagCompound p0, final TemplateManager p1);
    
    protected IBlockState getBlockStateFromPos(final World lllllllllllIllllIllIIlIllllIlllI, final int lllllllllllIllllIllIIlIllllIllIl, final int lllllllllllIllllIllIIlIllllIllII, final int lllllllllllIllllIllIIlIllllIIIIl, final StructureBoundingBox lllllllllllIllllIllIIlIllllIlIlI) {
        final int lllllllllllIllllIllIIlIllllIlIIl = this.getXWithOffset(lllllllllllIllllIllIIlIllllIllIl, lllllllllllIllllIllIIlIllllIIIIl);
        final int lllllllllllIllllIllIIlIllllIlIII = this.getYWithOffset(lllllllllllIllllIllIIlIllllIllII);
        final int lllllllllllIllllIllIIlIllllIIlll = this.getZWithOffset(lllllllllllIllllIllIIlIllllIllIl, lllllllllllIllllIllIIlIllllIIIIl);
        final BlockPos lllllllllllIllllIllIIlIllllIIllI = new BlockPos(lllllllllllIllllIllIIlIllllIlIIl, lllllllllllIllllIllIIlIllllIlIII, lllllllllllIllllIllIIlIllllIIlll);
        return lllllllllllIllllIllIIlIllllIlIlI.isVecInside(lllllllllllIllllIllIIlIllllIIllI) ? lllllllllllIllllIllIIlIllllIlllI.getBlockState(lllllllllllIllllIllIIlIllllIIllI) : Blocks.AIR.getDefaultState();
    }
    
    protected boolean func_191080_a(final World lllllllllllIllllIllIIlIIIlIIllII, final StructureBoundingBox lllllllllllIllllIllIIlIIIlIlIIlI, final Random lllllllllllIllllIllIIlIIIlIlIIIl, final BlockPos lllllllllllIllllIllIIlIIIlIIlIIl, final ResourceLocation lllllllllllIllllIllIIlIIIlIIllll, @Nullable IBlockState lllllllllllIllllIllIIlIIIlIIIlll) {
        if (lllllllllllIllllIllIIlIIIlIlIIlI.isVecInside(lllllllllllIllllIllIIlIIIlIIlIIl) && lllllllllllIllllIllIIlIIIlIIllII.getBlockState(lllllllllllIllllIllIIlIIIlIIlIIl).getBlock() != Blocks.CHEST) {
            if (lllllllllllIllllIllIIlIIIlIIIlll == null) {
                lllllllllllIllllIllIIlIIIlIIIlll = Blocks.CHEST.correctFacing(lllllllllllIllllIllIIlIIIlIIllII, lllllllllllIllllIllIIlIIIlIIlIIl, Blocks.CHEST.getDefaultState());
            }
            lllllllllllIllllIllIIlIIIlIIllII.setBlockState(lllllllllllIllllIllIIlIIIlIIlIIl, lllllllllllIllllIllIIlIIIlIIIlll, 2);
            final TileEntity lllllllllllIllllIllIIlIIIlIIllIl = lllllllllllIllllIllIIlIIIlIIllII.getTileEntity(lllllllllllIllllIllIIlIIIlIIlIIl);
            if (lllllllllllIllllIllIIlIIIlIIllIl instanceof TileEntityChest) {
                ((TileEntityChest)lllllllllllIllllIllIIlIIIlIIllIl).setLootTable(lllllllllllIllllIllIIlIIIlIIllll, lllllllllllIllllIllIIlIIIlIlIIIl.nextLong());
            }
            return true;
        }
        return false;
    }
    
    protected void clearCurrentPositionBlocksUpwards(final World lllllllllllIllllIllIIlIIlIIllIlI, final int lllllllllllIllllIllIIlIIlIlIIIII, final int lllllllllllIllllIllIIlIIlIIlllll, final int lllllllllllIllllIllIIlIIlIIlIlll, final StructureBoundingBox lllllllllllIllllIllIIlIIlIIlllIl) {
        BlockPos lllllllllllIllllIllIIlIIlIIlllII = new BlockPos(this.getXWithOffset(lllllllllllIllllIllIIlIIlIlIIIII, lllllllllllIllllIllIIlIIlIIlIlll), this.getYWithOffset(lllllllllllIllllIllIIlIIlIIlllll), this.getZWithOffset(lllllllllllIllllIllIIlIIlIlIIIII, lllllllllllIllllIllIIlIIlIIlIlll));
        if (lllllllllllIllllIllIIlIIlIIlllIl.isVecInside(lllllllllllIllllIllIIlIIlIIlllII)) {
            while (!lllllllllllIllllIllIIlIIlIIllIlI.isAirBlock(lllllllllllIllllIllIIlIIlIIlllII) && lllllllllllIllllIllIIlIIlIIlllII.getY() < 255) {
                lllllllllllIllllIllIIlIIlIIllIlI.setBlockState(lllllllllllIllllIllIIlIIlIIlllII, Blocks.AIR.getDefaultState(), 2);
                lllllllllllIllllIllIIlIIlIIlllII = lllllllllllIllllIllIIlIIlIIlllII.up();
            }
        }
    }
    
    protected boolean createDispenser(final World lllllllllllIllllIllIIlIIIIlllIIl, final StructureBoundingBox lllllllllllIllllIllIIlIIIIlIllIl, final Random lllllllllllIllllIllIIlIIIIlIllII, final int lllllllllllIllllIllIIlIIIIllIllI, final int lllllllllllIllllIllIIlIIIIllIlIl, final int lllllllllllIllllIllIIlIIIIlIlIIl, final EnumFacing lllllllllllIllllIllIIlIIIIllIIll, final ResourceLocation lllllllllllIllllIllIIlIIIIllIIlI) {
        final BlockPos lllllllllllIllllIllIIlIIIIllIIIl = new BlockPos(this.getXWithOffset(lllllllllllIllllIllIIlIIIIllIllI, lllllllllllIllllIllIIlIIIIlIlIIl), this.getYWithOffset(lllllllllllIllllIllIIlIIIIllIlIl), this.getZWithOffset(lllllllllllIllllIllIIlIIIIllIllI, lllllllllllIllllIllIIlIIIIlIlIIl));
        if (lllllllllllIllllIllIIlIIIIlIllIl.isVecInside(lllllllllllIllllIllIIlIIIIllIIIl) && lllllllllllIllllIllIIlIIIIlllIIl.getBlockState(lllllllllllIllllIllIIlIIIIllIIIl).getBlock() != Blocks.DISPENSER) {
            this.setBlockState(lllllllllllIllllIllIIlIIIIlllIIl, Blocks.DISPENSER.getDefaultState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, lllllllllllIllllIllIIlIIIIllIIll), lllllllllllIllllIllIIlIIIIllIllI, lllllllllllIllllIllIIlIIIIllIlIl, lllllllllllIllllIllIIlIIIIlIlIIl, lllllllllllIllllIllIIlIIIIlIllIl);
            final TileEntity lllllllllllIllllIllIIlIIIIllIIII = lllllllllllIllllIllIIlIIIIlllIIl.getTileEntity(lllllllllllIllllIllIIlIIIIllIIIl);
            if (lllllllllllIllllIllIIlIIIIllIIII instanceof TileEntityDispenser) {
                ((TileEntityDispenser)lllllllllllIllllIllIIlIIIIllIIII).setLootTable(lllllllllllIllllIllIIlIIIIllIIlI, lllllllllllIllllIllIIlIIIIlIllII.nextLong());
            }
            return true;
        }
        return false;
    }
    
    protected void replaceAirAndLiquidDownwards(final World lllllllllllIllllIllIIlIIIlllllll, final IBlockState lllllllllllIllllIllIIlIIIllllllI, final int lllllllllllIllllIllIIlIIIlllllIl, final int lllllllllllIllllIllIIlIIlIIIIllI, final int lllllllllllIllllIllIIlIIIllllIll, final StructureBoundingBox lllllllllllIllllIllIIlIIlIIIIlII) {
        final int lllllllllllIllllIllIIlIIlIIIIIll = this.getXWithOffset(lllllllllllIllllIllIIlIIIlllllIl, lllllllllllIllllIllIIlIIIllllIll);
        int lllllllllllIllllIllIIlIIlIIIIIlI = this.getYWithOffset(lllllllllllIllllIllIIlIIlIIIIllI);
        final int lllllllllllIllllIllIIlIIlIIIIIIl = this.getZWithOffset(lllllllllllIllllIllIIlIIIlllllIl, lllllllllllIllllIllIIlIIIllllIll);
        if (lllllllllllIllllIllIIlIIlIIIIlII.isVecInside(new BlockPos(lllllllllllIllllIllIIlIIlIIIIIll, lllllllllllIllllIllIIlIIlIIIIIlI, lllllllllllIllllIllIIlIIlIIIIIIl))) {
            while ((lllllllllllIllllIllIIlIIIlllllll.isAirBlock(new BlockPos(lllllllllllIllllIllIIlIIlIIIIIll, lllllllllllIllllIllIIlIIlIIIIIlI, lllllllllllIllllIllIIlIIlIIIIIIl)) || lllllllllllIllllIllIIlIIIlllllll.getBlockState(new BlockPos(lllllllllllIllllIllIIlIIlIIIIIll, lllllllllllIllllIllIIlIIlIIIIIlI, lllllllllllIllllIllIIlIIlIIIIIIl)).getMaterial().isLiquid()) && lllllllllllIllllIllIIlIIlIIIIIlI > 1) {
                lllllllllllIllllIllIIlIIIlllllll.setBlockState(new BlockPos(lllllllllllIllllIllIIlIIlIIIIIll, lllllllllllIllllIllIIlIIlIIIIIlI, lllllllllllIllllIllIIlIIlIIIIIIl), lllllllllllIllllIllIIlIIIllllllI, 2);
                --lllllllllllIllllIllIIlIIlIIIIIlI;
            }
        }
    }
    
    public final NBTTagCompound createStructureBaseNBT() {
        final NBTTagCompound lllllllllllIllllIllIIllIIlllllIl = new NBTTagCompound();
        lllllllllllIllllIllIIllIIlllllIl.setString("id", MapGenStructureIO.getStructureComponentName(this));
        lllllllllllIllllIllIIllIIlllllIl.setTag("BB", this.boundingBox.toNBTTagIntArray());
        final EnumFacing lllllllllllIllllIllIIllIIlllllII = this.getCoordBaseMode();
        lllllllllllIllllIllIIllIIlllllIl.setInteger("O", (lllllllllllIllllIllIIllIIlllllII == null) ? -1 : lllllllllllIllllIllIIllIIlllllII.getHorizontalIndex());
        lllllllllllIllllIllIIllIIlllllIl.setInteger("GD", this.componentType);
        this.writeStructureToNBT(lllllllllllIllllIllIIllIIlllllIl);
        return lllllllllllIllllIllIIllIIlllllIl;
    }
    
    protected void func_189914_a(final World lllllllllllIllllIllIIlIlIIIllIlI, final StructureBoundingBox lllllllllllIllllIllIIlIlIIlIlIll, final Random lllllllllllIllllIllIIlIlIIIllIII, final float lllllllllllIllllIllIIlIlIIIlIlll, final int lllllllllllIllllIllIIlIlIIIlIllI, final int lllllllllllIllllIllIIlIlIIIlIlIl, final int lllllllllllIllllIllIIlIlIIIlIlII, final int lllllllllllIllllIllIIlIlIIIlIIll, final int lllllllllllIllllIllIIlIlIIlIIlII, final int lllllllllllIllllIllIIlIlIIIlIIIl, final IBlockState lllllllllllIllllIllIIlIlIIlIIIlI, final IBlockState lllllllllllIllllIllIIlIlIIIIllll, final boolean lllllllllllIllllIllIIlIlIIIIlllI, final int lllllllllllIllllIllIIlIlIIIIllIl) {
        for (int lllllllllllIllllIllIIlIlIIIllllI = lllllllllllIllllIllIIlIlIIIlIlIl; lllllllllllIllllIllIIlIlIIIllllI <= lllllllllllIllllIllIIlIlIIlIIlII; ++lllllllllllIllllIllIIlIlIIIllllI) {
            for (int lllllllllllIllllIllIIlIlIIIlllIl = lllllllllllIllllIllIIlIlIIIlIllI; lllllllllllIllllIllIIlIlIIIlllIl <= lllllllllllIllllIllIIlIlIIIlIIll; ++lllllllllllIllllIllIIlIlIIIlllIl) {
                for (int lllllllllllIllllIllIIlIlIIIlllII = lllllllllllIllllIllIIlIlIIIlIlII; lllllllllllIllllIllIIlIlIIIlllII <= lllllllllllIllllIllIIlIlIIIlIIIl; ++lllllllllllIllllIllIIlIlIIIlllII) {
                    if (lllllllllllIllllIllIIlIlIIIllIII.nextFloat() <= lllllllllllIllllIllIIlIlIIIlIlll && (!lllllllllllIllllIllIIlIlIIIIlllI || this.getBlockStateFromPos(lllllllllllIllllIllIIlIlIIIllIlI, lllllllllllIllllIllIIlIlIIIlllIl, lllllllllllIllllIllIIlIlIIIllllI, lllllllllllIllllIllIIlIlIIIlllII, lllllllllllIllllIllIIlIlIIlIlIll).getMaterial() != Material.AIR) && (lllllllllllIllllIllIIlIlIIIIllIl <= 0 || this.func_189916_b(lllllllllllIllllIllIIlIlIIIllIlI, lllllllllllIllllIllIIlIlIIIlllIl, lllllllllllIllllIllIIlIlIIIllllI, lllllllllllIllllIllIIlIlIIIlllII, lllllllllllIllllIllIIlIlIIlIlIll) < lllllllllllIllllIllIIlIlIIIIllIl)) {
                        if (lllllllllllIllllIllIIlIlIIIllllI != lllllllllllIllllIllIIlIlIIIlIlIl && lllllllllllIllllIllIIlIlIIIllllI != lllllllllllIllllIllIIlIlIIlIIlII && lllllllllllIllllIllIIlIlIIIlllIl != lllllllllllIllllIllIIlIlIIIlIllI && lllllllllllIllllIllIIlIlIIIlllIl != lllllllllllIllllIllIIlIlIIIlIIll && lllllllllllIllllIllIIlIlIIIlllII != lllllllllllIllllIllIIlIlIIIlIlII && lllllllllllIllllIllIIlIlIIIlllII != lllllllllllIllllIllIIlIlIIIlIIIl) {
                            this.setBlockState(lllllllllllIllllIllIIlIlIIIllIlI, lllllllllllIllllIllIIlIlIIIIllll, lllllllllllIllllIllIIlIlIIIlllIl, lllllllllllIllllIllIIlIlIIIllllI, lllllllllllIllllIllIIlIlIIIlllII, lllllllllllIllllIllIIlIlIIlIlIll);
                        }
                        else {
                            this.setBlockState(lllllllllllIllllIllIIlIlIIIllIlI, lllllllllllIllllIllIIlIlIIlIIIlI, lllllllllllIllllIllIIlIlIIIlllIl, lllllllllllIllllIllIIlIlIIIllllI, lllllllllllIllllIllIIlIlIIIlllII, lllllllllllIllllIllIIlIlIIlIlIll);
                        }
                    }
                }
            }
        }
    }
    
    protected void randomlyRareFillWithBlocks(final World lllllllllllIllllIllIIlIIlIllllll, final StructureBoundingBox lllllllllllIllllIllIIlIIlIlllllI, final int lllllllllllIllllIllIIlIIllIlIlII, final int lllllllllllIllllIllIIlIIlIllllII, final int lllllllllllIllllIllIIlIIlIlllIll, final int lllllllllllIllllIllIIlIIllIlIIIl, final int lllllllllllIllllIllIIlIIlIlllIIl, final int lllllllllllIllllIllIIlIIlIlllIII, final IBlockState lllllllllllIllllIllIIlIIlIllIlll, final boolean lllllllllllIllllIllIIlIIllIIllIl) {
        final float lllllllllllIllllIllIIlIIllIIllII = (float)(lllllllllllIllllIllIIlIIllIlIIIl - lllllllllllIllllIllIIlIIllIlIlII + 1);
        final float lllllllllllIllllIllIIlIIllIIlIll = (float)(lllllllllllIllllIllIIlIIlIlllIIl - lllllllllllIllllIllIIlIIlIllllII + 1);
        final float lllllllllllIllllIllIIlIIllIIlIlI = (float)(lllllllllllIllllIllIIlIIlIlllIII - lllllllllllIllllIllIIlIIlIlllIll + 1);
        final float lllllllllllIllllIllIIlIIllIIlIIl = lllllllllllIllllIllIIlIIllIlIlII + lllllllllllIllllIllIIlIIllIIllII / 2.0f;
        final float lllllllllllIllllIllIIlIIllIIlIII = lllllllllllIllllIllIIlIIlIlllIll + lllllllllllIllllIllIIlIIllIIlIlI / 2.0f;
        for (int lllllllllllIllllIllIIlIIllIIIlll = lllllllllllIllllIllIIlIIlIllllII; lllllllllllIllllIllIIlIIllIIIlll <= lllllllllllIllllIllIIlIIlIlllIIl; ++lllllllllllIllllIllIIlIIllIIIlll) {
            final float lllllllllllIllllIllIIlIIllIIIllI = (lllllllllllIllllIllIIlIIllIIIlll - lllllllllllIllllIllIIlIIlIllllII) / lllllllllllIllllIllIIlIIllIIlIll;
            for (int lllllllllllIllllIllIIlIIllIIIlIl = lllllllllllIllllIllIIlIIllIlIlII; lllllllllllIllllIllIIlIIllIIIlIl <= lllllllllllIllllIllIIlIIllIlIIIl; ++lllllllllllIllllIllIIlIIllIIIlIl) {
                final float lllllllllllIllllIllIIlIIllIIIlII = (lllllllllllIllllIllIIlIIllIIIlIl - lllllllllllIllllIllIIlIIllIIlIIl) / (lllllllllllIllllIllIIlIIllIIllII * 0.5f);
                for (int lllllllllllIllllIllIIlIIllIIIIll = lllllllllllIllllIllIIlIIlIlllIll; lllllllllllIllllIllIIlIIllIIIIll <= lllllllllllIllllIllIIlIIlIlllIII; ++lllllllllllIllllIllIIlIIllIIIIll) {
                    final float lllllllllllIllllIllIIlIIllIIIIlI = (lllllllllllIllllIllIIlIIllIIIIll - lllllllllllIllllIllIIlIIllIIlIII) / (lllllllllllIllllIllIIlIIllIIlIlI * 0.5f);
                    if (!lllllllllllIllllIllIIlIIllIIllIl || this.getBlockStateFromPos(lllllllllllIllllIllIIlIIlIllllll, lllllllllllIllllIllIIlIIllIIIlIl, lllllllllllIllllIllIIlIIllIIIlll, lllllllllllIllllIllIIlIIllIIIIll, lllllllllllIllllIllIIlIIlIlllllI).getMaterial() != Material.AIR) {
                        final float lllllllllllIllllIllIIlIIllIIIIIl = lllllllllllIllllIllIIlIIllIIIlII * lllllllllllIllllIllIIlIIllIIIlII + lllllllllllIllllIllIIlIIllIIIllI * lllllllllllIllllIllIIlIIllIIIllI + lllllllllllIllllIllIIlIIllIIIIlI * lllllllllllIllllIllIIlIIllIIIIlI;
                        if (lllllllllllIllllIllIIlIIllIIIIIl <= 1.05f) {
                            this.setBlockState(lllllllllllIllllIllIIlIIlIllllll, lllllllllllIllllIllIIlIIlIllIlll, lllllllllllIllllIllIIlIIllIIIlIl, lllllllllllIllllIllIIlIIllIIIlll, lllllllllllIllllIllIIlIIllIIIIll, lllllllllllIllllIllIIlIIlIlllllI);
                        }
                    }
                }
            }
        }
    }
    
    protected void randomlyPlaceBlock(final World lllllllllllIllllIllIIlIIllllIllI, final StructureBoundingBox lllllllllllIllllIllIIlIIllllIlIl, final Random lllllllllllIllllIllIIlIIllllllIl, final float lllllllllllIllllIllIIlIIllllllII, final int lllllllllllIllllIllIIlIIlllllIll, final int lllllllllllIllllIllIIlIIllllIIIl, final int lllllllllllIllllIllIIlIIllllIIII, final IBlockState lllllllllllIllllIllIIlIIlllllIII) {
        if (lllllllllllIllllIllIIlIIllllllIl.nextFloat() < lllllllllllIllllIllIIlIIllllllII) {
            this.setBlockState(lllllllllllIllllIllIIlIIllllIllI, lllllllllllIllllIllIIlIIlllllIII, lllllllllllIllllIllIIlIIlllllIll, lllllllllllIllllIllIIlIIllllIIIl, lllllllllllIllllIllIIlIIllllIIII, lllllllllllIllllIllIIlIIllllIlIl);
        }
    }
    
    protected boolean generateChest(final World lllllllllllIllllIllIIlIIIllIllII, final StructureBoundingBox lllllllllllIllllIllIIlIIIllIIIlI, final Random lllllllllllIllllIllIIlIIIllIIIIl, final int lllllllllllIllllIllIIlIIIllIlIIl, final int lllllllllllIllllIllIIlIIIlIlllll, final int lllllllllllIllllIllIIlIIIlIllllI, final ResourceLocation lllllllllllIllllIllIIlIIIlIlllIl) {
        final BlockPos lllllllllllIllllIllIIlIIIllIIlIl = new BlockPos(this.getXWithOffset(lllllllllllIllllIllIIlIIIllIlIIl, lllllllllllIllllIllIIlIIIlIllllI), this.getYWithOffset(lllllllllllIllllIllIIlIIIlIlllll), this.getZWithOffset(lllllllllllIllllIllIIlIIIllIlIIl, lllllllllllIllllIllIIlIIIlIllllI));
        return this.func_191080_a(lllllllllllIllllIllIIlIIIllIllII, lllllllllllIllllIllIIlIIIllIIIlI, lllllllllllIllllIllIIlIIIllIIIIl, lllllllllllIllllIllIIlIIIllIIlIl, lllllllllllIllllIllIIlIIIlIlllIl, null);
    }
    
    protected void fillWithBlocks(final World lllllllllllIllllIllIIlIllIIIlIIl, final StructureBoundingBox lllllllllllIllllIllIIlIllIIIlIII, final int lllllllllllIllllIllIIlIllIIIIlll, final int lllllllllllIllllIllIIlIllIIIIllI, final int lllllllllllIllllIllIIlIllIIIIlIl, final int lllllllllllIllllIllIIlIllIIIIlII, final int lllllllllllIllllIllIIlIllIIIIIll, final int lllllllllllIllllIllIIlIlIlllIIll, final IBlockState lllllllllllIllllIllIIlIllIIIIIIl, final IBlockState lllllllllllIllllIllIIlIlIlllIIIl, final boolean lllllllllllIllllIllIIlIlIlllllll) {
        for (int lllllllllllIllllIllIIlIlIllllllI = lllllllllllIllllIllIIlIllIIIIllI; lllllllllllIllllIllIIlIlIllllllI <= lllllllllllIllllIllIIlIllIIIIIll; ++lllllllllllIllllIllIIlIlIllllllI) {
            for (int lllllllllllIllllIllIIlIlIlllllIl = lllllllllllIllllIllIIlIllIIIIlll; lllllllllllIllllIllIIlIlIlllllIl <= lllllllllllIllllIllIIlIllIIIIlII; ++lllllllllllIllllIllIIlIlIlllllIl) {
                for (int lllllllllllIllllIllIIlIlIlllllII = lllllllllllIllllIllIIlIllIIIIlIl; lllllllllllIllllIllIIlIlIlllllII <= lllllllllllIllllIllIIlIlIlllIIll; ++lllllllllllIllllIllIIlIlIlllllII) {
                    if (!lllllllllllIllllIllIIlIlIlllllll || this.getBlockStateFromPos(lllllllllllIllllIllIIlIllIIIlIIl, lllllllllllIllllIllIIlIlIlllllIl, lllllllllllIllllIllIIlIlIllllllI, lllllllllllIllllIllIIlIlIlllllII, lllllllllllIllllIllIIlIllIIIlIII).getMaterial() != Material.AIR) {
                        if (lllllllllllIllllIllIIlIlIllllllI != lllllllllllIllllIllIIlIllIIIIllI && lllllllllllIllllIllIIlIlIllllllI != lllllllllllIllllIllIIlIllIIIIIll && lllllllllllIllllIllIIlIlIlllllIl != lllllllllllIllllIllIIlIllIIIIlll && lllllllllllIllllIllIIlIlIlllllIl != lllllllllllIllllIllIIlIllIIIIlII && lllllllllllIllllIllIIlIlIlllllII != lllllllllllIllllIllIIlIllIIIIlIl && lllllllllllIllllIllIIlIlIlllllII != lllllllllllIllllIllIIlIlIlllIIll) {
                            this.setBlockState(lllllllllllIllllIllIIlIllIIIlIIl, lllllllllllIllllIllIIlIlIlllIIIl, lllllllllllIllllIllIIlIlIlllllIl, lllllllllllIllllIllIIlIlIllllllI, lllllllllllIllllIllIIlIlIlllllII, lllllllllllIllllIllIIlIllIIIlIII);
                        }
                        else {
                            this.setBlockState(lllllllllllIllllIllIIlIllIIIlIIl, lllllllllllIllllIllIIlIllIIIIIIl, lllllllllllIllllIllIIlIlIlllllIl, lllllllllllIllllIllIIlIlIllllllI, lllllllllllIllllIllIIlIlIlllllII, lllllllllllIllllIllIIlIllIIIlIII);
                        }
                    }
                }
            }
        }
    }
    
    @Nullable
    public EnumFacing getCoordBaseMode() {
        return this.coordBaseMode;
    }
    
    protected void setBlockState(final World lllllllllllIllllIllIIllIIIIIIIII, IBlockState lllllllllllIllllIllIIlIlllllllll, final int lllllllllllIllllIllIIllIIIIIIllI, final int lllllllllllIllllIllIIllIIIIIIlIl, final int lllllllllllIllllIllIIllIIIIIIlII, final StructureBoundingBox lllllllllllIllllIllIIllIIIIIIIll) {
        final BlockPos lllllllllllIllllIllIIllIIIIIIIlI = new BlockPos(this.getXWithOffset(lllllllllllIllllIllIIllIIIIIIllI, lllllllllllIllllIllIIllIIIIIIlII), this.getYWithOffset(lllllllllllIllllIllIIllIIIIIIlIl), this.getZWithOffset(lllllllllllIllllIllIIllIIIIIIllI, lllllllllllIllllIllIIllIIIIIIlII));
        if (lllllllllllIllllIllIIllIIIIIIIll.isVecInside(lllllllllllIllllIllIIllIIIIIIIlI)) {
            if (this.mirror != Mirror.NONE) {
                lllllllllllIllllIllIIlIlllllllll = ((IBlockProperties)lllllllllllIllllIllIIlIlllllllll).withMirror(this.mirror);
            }
            if (this.rotation != Rotation.NONE) {
                lllllllllllIllllIllIIlIlllllllll = ((IBlockProperties)lllllllllllIllllIllIIlIlllllllll).withRotation(this.rotation);
            }
            lllllllllllIllllIllIIllIIIIIIIII.setBlockState(lllllllllllIllllIllIIllIIIIIIIlI, (IBlockState)lllllllllllIllllIllIIlIlllllllll, 2);
        }
    }
    
    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    public void offset(final int lllllllllllIllllIllIIlIIIIIIIIlI, final int lllllllllllIllllIllIIlIIIIIIIlIl, final int lllllllllllIllllIllIIlIIIIIIIIII) {
        this.boundingBox.offset(lllllllllllIllllIllIIlIIIIIIIIlI, lllllllllllIllllIllIIlIIIIIIIlIl, lllllllllllIllllIllIIlIIIIIIIIII);
    }
    
    public static StructureComponent findIntersecting(final List<StructureComponent> lllllllllllIllllIllIIllIIlIllllI, final StructureBoundingBox lllllllllllIllllIllIIllIIlIllIlI) {
        for (final StructureComponent lllllllllllIllllIllIIllIIlIlllII : lllllllllllIllllIllIIllIIlIllllI) {
            if (lllllllllllIllllIllIIllIIlIlllII.getBoundingBox() != null && lllllllllllIllllIllIIllIIlIlllII.getBoundingBox().intersectsWith(lllllllllllIllllIllIIllIIlIllIlI)) {
                return lllllllllllIllllIllIIllIIlIlllII;
            }
        }
        return null;
    }
    
    public void buildComponent(final StructureComponent lllllllllllIllllIllIIllIIllIlIll, final List<StructureComponent> lllllllllllIllllIllIIllIIllIlIlI, final Random lllllllllllIllllIllIIllIIllIlIIl) {
    }
    
    protected StructureComponent(final int lllllllllllIllllIllIIllIlIIIIIlI) {
        this.componentType = lllllllllllIllllIllIIllIlIIIIIlI;
    }
    
    protected void fillWithAir(final World lllllllllllIllllIllIIlIllIlIIlII, final StructureBoundingBox lllllllllllIllllIllIIlIllIlIllll, final int lllllllllllIllllIllIIlIllIlIIIlI, final int lllllllllllIllllIllIIlIllIlIllIl, final int lllllllllllIllllIllIIlIllIlIllII, final int lllllllllllIllllIllIIlIllIlIlIll, final int lllllllllllIllllIllIIlIllIIllllI, final int lllllllllllIllllIllIIlIllIIlllIl) {
        for (int lllllllllllIllllIllIIlIllIlIlIII = lllllllllllIllllIllIIlIllIlIllIl; lllllllllllIllllIllIIlIllIlIlIII <= lllllllllllIllllIllIIlIllIIllllI; ++lllllllllllIllllIllIIlIllIlIlIII) {
            for (int lllllllllllIllllIllIIlIllIlIIlll = lllllllllllIllllIllIIlIllIlIIIlI; lllllllllllIllllIllIIlIllIlIIlll <= lllllllllllIllllIllIIlIllIlIlIll; ++lllllllllllIllllIllIIlIllIlIIlll) {
                for (int lllllllllllIllllIllIIlIllIlIIllI = lllllllllllIllllIllIIlIllIlIllII; lllllllllllIllllIllIIlIllIlIIllI <= lllllllllllIllllIllIIlIllIIlllIl; ++lllllllllllIllllIllIIlIllIlIIllI) {
                    this.setBlockState(lllllllllllIllllIllIIlIllIlIIlII, Blocks.AIR.getDefaultState(), lllllllllllIllllIllIIlIllIlIIlll, lllllllllllIllllIllIIlIllIlIlIII, lllllllllllIllllIllIIlIllIlIIllI, lllllllllllIllllIllIIlIllIlIllll);
                }
            }
        }
    }
    
    public abstract static class BlockSelector
    {
        protected /* synthetic */ IBlockState blockstate;
        
        public abstract void selectBlocks(final Random p0, final int p1, final int p2, final int p3, final boolean p4);
        
        public BlockSelector() {
            this.blockstate = Blocks.AIR.getDefaultState();
        }
        
        public IBlockState getBlockState() {
            return this.blockstate;
        }
    }
}

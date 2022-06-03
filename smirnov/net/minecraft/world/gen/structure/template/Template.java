// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.structure.template;

import net.minecraft.util.ObjectIntIdentityMap;
import java.util.Iterator;
import java.util.Collection;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import com.google.common.base.Predicate;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.datafix.IFixType;
import net.minecraft.util.datafix.IDataFixer;
import net.minecraft.util.datafix.IDataWalker;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityList;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.init.Blocks;
import com.google.common.collect.Maps;
import java.util.Map;
import com.google.common.collect.Lists;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import java.util.List;
import net.minecraft.util.math.BlockPos;

public class Template
{
    private /* synthetic */ BlockPos size;
    private /* synthetic */ String author;
    private final /* synthetic */ List<BlockInfo> blocks;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private final /* synthetic */ List<EntityInfo> entities;
    
    private static BlockPos transformedBlockPos(final BlockPos llllllllllllIIllllIllIlIlIlllIII, final Mirror llllllllllllIIllllIllIlIlIllIlll, final Rotation llllllllllllIIllllIllIlIlIlIllll) {
        int llllllllllllIIllllIllIlIlIllIlIl = llllllllllllIIllllIllIlIlIlllIII.getX();
        final int llllllllllllIIllllIllIlIlIllIlII = llllllllllllIIllllIllIlIlIlllIII.getY();
        int llllllllllllIIllllIllIlIlIllIIll = llllllllllllIIllllIllIlIlIlllIII.getZ();
        boolean llllllllllllIIllllIllIlIlIllIIlI = true;
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllIIllllIllIlIlIllIlll.ordinal()]) {
            case 2: {
                llllllllllllIIllllIllIlIlIllIIll = -llllllllllllIIllllIllIlIlIllIIll;
                break;
            }
            case 3: {
                llllllllllllIIllllIllIlIlIllIlIl = -llllllllllllIIllllIllIlIlIllIlIl;
                break;
            }
            default: {
                llllllllllllIIllllIllIlIlIllIIlI = false;
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIIllllIllIlIlIlIllll.ordinal()]) {
            case 4: {
                return new BlockPos(llllllllllllIIllllIllIlIlIllIIll, llllllllllllIIllllIllIlIlIllIlII, -llllllllllllIIllllIllIlIlIllIlIl);
            }
            case 2: {
                return new BlockPos(-llllllllllllIIllllIllIlIlIllIIll, llllllllllllIIllllIllIlIlIllIlII, llllllllllllIIllllIllIlIlIllIlIl);
            }
            case 3: {
                return new BlockPos(-llllllllllllIIllllIllIlIlIllIlIl, llllllllllllIIllllIllIlIlIllIlII, -llllllllllllIIllllIllIlIlIllIIll);
            }
            default: {
                return llllllllllllIIllllIllIlIlIllIIlI ? new BlockPos(llllllllllllIIllllIllIlIlIllIlIl, llllllllllllIIllllIllIlIlIllIlII, llllllllllllIIllllIllIlIlIllIIll) : llllllllllllIIllllIllIlIlIlllIII;
            }
        }
    }
    
    public BlockPos calculateConnectedPos(final PlacementSettings llllllllllllIIllllIllIllIlIllIIl, final BlockPos llllllllllllIIllllIllIllIlIllIII, final PlacementSettings llllllllllllIIllllIllIllIlIlllIl, final BlockPos llllllllllllIIllllIllIllIlIlIllI) {
        final BlockPos llllllllllllIIllllIllIllIlIllIll = transformedBlockPos(llllllllllllIIllllIllIllIlIllIIl, llllllllllllIIllllIllIllIlIllIII);
        final BlockPos llllllllllllIIllllIllIllIlIllIlI = transformedBlockPos(llllllllllllIIllllIllIllIlIlllIl, llllllllllllIIllllIllIllIlIlIllI);
        return llllllllllllIIllllIllIllIlIllIll.subtract(llllllllllllIIllllIllIllIlIllIlI);
    }
    
    public void addBlocksToWorld(final World llllllllllllIIllllIllIllIIllllII, final BlockPos llllllllllllIIllllIllIllIIlllIll, final PlacementSettings llllllllllllIIllllIllIllIIllIllI) {
        this.addBlocksToWorld(llllllllllllIIllllIllIllIIllllII, llllllllllllIIllllIllIllIIlllIll, new BlockRotationProcessor(llllllllllllIIllllIllIllIIlllIll, llllllllllllIIllllIllIllIIllIllI), llllllllllllIIllllIllIllIIllIllI, 2);
    }
    
    public BlockPos getZeroPositionWithTransform(final BlockPos llllllllllllIIllllIllIlIlIIlIIII, final Mirror llllllllllllIIllllIllIlIlIIIlIll, final Rotation llllllllllllIIllllIllIlIlIIIlllI) {
        return func_191157_a(llllllllllllIIllllIllIlIlIIlIIII, llllllllllllIIllllIllIlIlIIIlIll, llllllllllllIIllllIllIlIlIIIlllI, this.getSize().getX(), this.getSize().getZ());
    }
    
    public static BlockPos func_191157_a(final BlockPos llllllllllllIIllllIllIlIlIIIIIIl, final Mirror llllllllllllIIllllIllIlIlIIIIIII, final Rotation llllllllllllIIllllIllIlIIlllIlll, int llllllllllllIIllllIllIlIIllllllI, int llllllllllllIIllllIllIlIIlllllIl) {
        --llllllllllllIIllllIllIlIIllllllI;
        --llllllllllllIIllllIllIlIIlllllIl;
        final int llllllllllllIIllllIllIlIIlllllII = (llllllllllllIIllllIllIlIlIIIIIII == Mirror.FRONT_BACK) ? llllllllllllIIllllIllIlIIllllllI : 0;
        final int llllllllllllIIllllIllIlIIllllIll = (llllllllllllIIllllIllIlIlIIIIIII == Mirror.LEFT_RIGHT) ? llllllllllllIIllllIllIlIIlllllIl : 0;
        BlockPos llllllllllllIIllllIllIlIIllllIlI = llllllllllllIIllllIllIlIlIIIIIIl;
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIIllllIllIlIIlllIlll.ordinal()]) {
            case 4: {
                llllllllllllIIllllIllIlIIllllIlI = llllllllllllIIllllIllIlIlIIIIIIl.add(llllllllllllIIllllIllIlIIllllIll, 0, llllllllllllIIllllIllIlIIllllllI - llllllllllllIIllllIllIlIIlllllII);
                break;
            }
            case 2: {
                llllllllllllIIllllIllIlIIllllIlI = llllllllllllIIllllIllIlIlIIIIIIl.add(llllllllllllIIllllIllIlIIlllllIl - llllllllllllIIllllIllIlIIllllIll, 0, llllllllllllIIllllIllIlIIlllllII);
                break;
            }
            case 3: {
                llllllllllllIIllllIllIlIIllllIlI = llllllllllllIIllllIllIlIlIIIIIIl.add(llllllllllllIIllllIllIlIIllllllI - llllllllllllIIllllIllIlIIlllllII, 0, llllllllllllIIllllIllIlIIlllllIl - llllllllllllIIllllIllIlIIllllIll);
                break;
            }
            case 1: {
                llllllllllllIIllllIllIlIIllllIlI = llllllllllllIIllllIllIlIlIIIIIIl.add(llllllllllllIIllllIllIlIIlllllII, 0, llllllllllllIIllllIllIlIIllllIll);
                break;
            }
        }
        return llllllllllllIIllllIllIlIIllllIlI;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public Template() {
        this.blocks = (List<BlockInfo>)Lists.newArrayList();
        this.entities = (List<EntityInfo>)Lists.newArrayList();
        this.size = BlockPos.ORIGIN;
        this.author = "?";
    }
    
    public BlockPos transformedSize(final Rotation llllllllllllIIllllIllIlIllIIIIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIIllllIllIlIllIIIIII.ordinal()]) {
            case 2:
            case 4: {
                return new BlockPos(this.size.getZ(), this.size.getY(), this.size.getX());
            }
            default: {
                return this.size;
            }
        }
    }
    
    public Map<BlockPos, String> getDataBlocks(final BlockPos llllllllllllIIllllIllIllIllIllll, final PlacementSettings llllllllllllIIllllIllIllIllIlllI) {
        final Map<BlockPos, String> llllllllllllIIllllIllIllIlllIllI = (Map<BlockPos, String>)Maps.newHashMap();
        final StructureBoundingBox llllllllllllIIllllIllIllIlllIlIl = llllllllllllIIllllIllIllIllIlllI.getBoundingBox();
        for (final BlockInfo llllllllllllIIllllIllIllIlllIlII : this.blocks) {
            final BlockPos llllllllllllIIllllIllIllIlllIIll = transformedBlockPos(llllllllllllIIllllIllIllIllIlllI, llllllllllllIIllllIllIllIlllIlII.pos).add(llllllllllllIIllllIllIllIllIllll);
            if (llllllllllllIIllllIllIllIlllIlIl == null || llllllllllllIIllllIllIllIlllIlIl.isVecInside(llllllllllllIIllllIllIllIlllIIll)) {
                final IBlockState llllllllllllIIllllIllIllIlllIIlI = llllllllllllIIllllIllIllIlllIlII.blockState;
                if (llllllllllllIIllllIllIllIlllIIlI.getBlock() != Blocks.STRUCTURE_BLOCK || llllllllllllIIllllIllIllIlllIlII.tileentityData == null) {
                    continue;
                }
                final TileEntityStructure.Mode llllllllllllIIllllIllIllIlllIIIl = TileEntityStructure.Mode.valueOf(llllllllllllIIllllIllIllIlllIlII.tileentityData.getString("mode"));
                if (llllllllllllIIllllIllIllIlllIIIl != TileEntityStructure.Mode.DATA) {
                    continue;
                }
                llllllllllllIIllllIllIllIlllIllI.put(llllllllllllIIllllIllIllIlllIIll, llllllllllllIIllllIllIllIlllIlII.tileentityData.getString("metadata"));
            }
        }
        return llllllllllllIIllllIllIllIlllIllI;
    }
    
    private NBTTagList writeDoubles(final double... llllllllllllIIllllIllIlIIIIIlIlI) {
        final NBTTagList llllllllllllIIllllIllIlIIIIIlIIl = new NBTTagList();
        final Exception llllllllllllIIllllIllIlIIIIIIIlI = (Object)llllllllllllIIllllIllIlIIIIIlIlI;
        for (short llllllllllllIIllllIllIlIIIIIIIll = (short)llllllllllllIIllllIllIlIIIIIlIlI.length, llllllllllllIIllllIllIlIIIIIIlII = 0; llllllllllllIIllllIllIlIIIIIIlII < llllllllllllIIllllIllIlIIIIIIIll; ++llllllllllllIIllllIllIlIIIIIIlII) {
            final double llllllllllllIIllllIllIlIIIIIlIII = llllllllllllIIllllIllIlIIIIIIIlI[llllllllllllIIllllIllIlIIIIIIlII];
            llllllllllllIIllllIllIlIIIIIlIIl.appendTag(new NBTTagDouble(llllllllllllIIllllIllIlIIIIIlIII));
        }
        return llllllllllllIIllllIllIlIIIIIlIIl;
    }
    
    private void addEntitiesToWorld(final World llllllllllllIIllllIllIlIllIlIIll, final BlockPos llllllllllllIIllllIllIlIlllIIIlI, final Mirror llllllllllllIIllllIllIlIllIlIIIl, final Rotation llllllllllllIIllllIllIlIlllIIIII, @Nullable final StructureBoundingBox llllllllllllIIllllIllIlIllIIllll) {
        for (final EntityInfo llllllllllllIIllllIllIlIllIllllI : this.entities) {
            final BlockPos llllllllllllIIllllIllIlIllIlllIl = transformedBlockPos(llllllllllllIIllllIllIlIllIllllI.blockPos, llllllllllllIIllllIllIlIllIlIIIl, llllllllllllIIllllIllIlIlllIIIII).add(llllllllllllIIllllIllIlIlllIIIlI);
            if (llllllllllllIIllllIllIlIllIIllll == null || llllllllllllIIllllIllIlIllIIllll.isVecInside(llllllllllllIIllllIllIlIllIlllIl)) {
                final NBTTagCompound llllllllllllIIllllIllIlIllIlllII = llllllllllllIIllllIllIlIllIllllI.entityData;
                final Vec3d llllllllllllIIllllIllIlIllIllIll = transformedVec3d(llllllllllllIIllllIllIlIllIllllI.pos, llllllllllllIIllllIllIlIllIlIIIl, llllllllllllIIllllIllIlIlllIIIII);
                final Vec3d llllllllllllIIllllIllIlIllIllIlI = llllllllllllIIllllIllIlIllIllIll.addVector(llllllllllllIIllllIllIlIlllIIIlI.getX(), llllllllllllIIllllIllIlIlllIIIlI.getY(), llllllllllllIIllllIllIlIlllIIIlI.getZ());
                final NBTTagList llllllllllllIIllllIllIlIllIllIIl = new NBTTagList();
                llllllllllllIIllllIllIlIllIllIIl.appendTag(new NBTTagDouble(llllllllllllIIllllIllIlIllIllIlI.xCoord));
                llllllllllllIIllllIllIlIllIllIIl.appendTag(new NBTTagDouble(llllllllllllIIllllIllIlIllIllIlI.yCoord));
                llllllllllllIIllllIllIlIllIllIIl.appendTag(new NBTTagDouble(llllllllllllIIllllIllIlIllIllIlI.zCoord));
                llllllllllllIIllllIllIlIllIlllII.setTag("Pos", llllllllllllIIllllIllIlIllIllIIl);
                llllllllllllIIllllIllIlIllIlllII.setUniqueId("UUID", UUID.randomUUID());
                Entity llllllllllllIIllllIllIlIllIlIlll = null;
                try {
                    final Entity llllllllllllIIllllIllIlIllIllIII = EntityList.createEntityFromNBT(llllllllllllIIllllIllIlIllIlllII, llllllllllllIIllllIllIlIllIlIIll);
                }
                catch (Exception llllllllllllIIllllIllIlIllIlIllI) {
                    llllllllllllIIllllIllIlIllIlIlll = null;
                }
                if (llllllllllllIIllllIllIlIllIlIlll == null) {
                    continue;
                }
                float llllllllllllIIllllIllIlIllIlIlIl = llllllllllllIIllllIllIlIllIlIlll.getMirroredYaw(llllllllllllIIllllIllIlIllIlIIIl);
                llllllllllllIIllllIllIlIllIlIlIl += llllllllllllIIllllIllIlIllIlIlll.rotationYaw - llllllllllllIIllllIllIlIllIlIlll.getRotatedYaw(llllllllllllIIllllIllIlIlllIIIII);
                llllllllllllIIllllIllIlIllIlIlll.setLocationAndAngles(llllllllllllIIllllIllIlIllIllIlI.xCoord, llllllllllllIIllllIllIlIllIllIlI.yCoord, llllllllllllIIllllIllIlIllIllIlI.zCoord, llllllllllllIIllllIllIlIllIlIlIl, llllllllllllIIllllIllIlIllIlIlll.rotationPitch);
                llllllllllllIIllllIllIlIllIlIIll.spawnEntityInWorld(llllllllllllIIllllIllIlIllIlIlll);
            }
        }
    }
    
    public static void func_191158_a(final DataFixer llllllllllllIIllllIllIlIIlllIIII) {
        llllllllllllIIllllIllIlIIlllIIII.registerWalker(FixTypes.STRUCTURE, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllIllIlIlIIlIIIIIIIllIl, final NBTTagCompound lllllllllllIllIlIlIIlIIIIIIIIIll, final int lllllllllllIllIlIlIIlIIIIIIIlIll) {
                if (lllllllllllIllIlIlIIlIIIIIIIIIll.hasKey("entities", 9)) {
                    final NBTTagList lllllllllllIllIlIlIIlIIIIIIIlIlI = lllllllllllIllIlIlIIlIIIIIIIIIll.getTagList("entities", 10);
                    for (int lllllllllllIllIlIlIIlIIIIIIIlIIl = 0; lllllllllllIllIlIlIIlIIIIIIIlIIl < lllllllllllIllIlIlIIlIIIIIIIlIlI.tagCount(); ++lllllllllllIllIlIlIIlIIIIIIIlIIl) {
                        final NBTTagCompound lllllllllllIllIlIlIIlIIIIIIIlIII = (NBTTagCompound)lllllllllllIllIlIlIIlIIIIIIIlIlI.get(lllllllllllIllIlIlIIlIIIIIIIlIIl);
                        if (lllllllllllIllIlIlIIlIIIIIIIlIII.hasKey("nbt", 10)) {
                            lllllllllllIllIlIlIIlIIIIIIIlIII.setTag("nbt", lllllllllllIllIlIlIIlIIIIIIIllIl.process(FixTypes.ENTITY, lllllllllllIllIlIlIIlIIIIIIIlIII.getCompoundTag("nbt"), lllllllllllIllIlIlIIlIIIIIIIlIll));
                        }
                    }
                }
                if (lllllllllllIllIlIlIIlIIIIIIIIIll.hasKey("blocks", 9)) {
                    final NBTTagList lllllllllllIllIlIlIIlIIIIIIIIlll = lllllllllllIllIlIlIIlIIIIIIIIIll.getTagList("blocks", 10);
                    for (int lllllllllllIllIlIlIIlIIIIIIIIllI = 0; lllllllllllIllIlIlIIlIIIIIIIIllI < lllllllllllIllIlIlIIlIIIIIIIIlll.tagCount(); ++lllllllllllIllIlIlIIlIIIIIIIIllI) {
                        final NBTTagCompound lllllllllllIllIlIlIIlIIIIIIIIlIl = (NBTTagCompound)lllllllllllIllIlIlIIlIIIIIIIIlll.get(lllllllllllIllIlIlIIlIIIIIIIIllI);
                        if (lllllllllllIllIlIlIIlIIIIIIIIlIl.hasKey("nbt", 10)) {
                            lllllllllllIllIlIlIIlIIIIIIIIlIl.setTag("nbt", lllllllllllIllIlIlIIlIIIIIIIllIl.process(FixTypes.BLOCK_ENTITY, lllllllllllIllIlIlIIlIIIIIIIIlIl.getCompoundTag("nbt"), lllllllllllIllIlIlIIlIIIIIIIlIll));
                        }
                    }
                }
                return lllllllllllIllIlIlIIlIIIIIIIIIll;
            }
        });
    }
    
    private NBTTagList writeInts(final int... llllllllllllIIllllIllIlIIIIllIlI) {
        final NBTTagList llllllllllllIIllllIllIlIIIIllIIl = new NBTTagList();
        final double llllllllllllIIllllIllIlIIIIlIIlI = (Object)llllllllllllIIllllIllIlIIIIllIlI;
        final double llllllllllllIIllllIllIlIIIIlIIll = llllllllllllIIllllIllIlIIIIllIlI.length;
        for (byte llllllllllllIIllllIllIlIIIIlIlII = 0; llllllllllllIIllllIllIlIIIIlIlII < llllllllllllIIllllIllIlIIIIlIIll; ++llllllllllllIIllllIllIlIIIIlIlII) {
            final int llllllllllllIIllllIllIlIIIIllIII = llllllllllllIIllllIllIlIIIIlIIlI[llllllllllllIIllllIllIlIIIIlIlII];
            llllllllllllIIllllIllIlIIIIllIIl.appendTag(new NBTTagInt(llllllllllllIIllllIllIlIIIIllIII));
        }
        return llllllllllllIIllllIllIlIIIIllIIl;
    }
    
    public BlockPos getSize() {
        return this.size;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = Template.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final String llllllllllllIIllllIllIlIIIIIIIII = (Object)new int[Rotation.values().length];
        try {
            llllllllllllIIllllIllIlIIIIIIIII[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIllllIllIlIIIIIIIII[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIllllIllIlIIIIIIIII[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIllllIllIlIIIIIIIII[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Template.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllIIllllIllIlIIIIIIIII;
    }
    
    public void addBlocksToWorld(final World llllllllllllIIllllIllIllIIlIllll, final BlockPos llllllllllllIIllllIllIllIIlIlllI, final PlacementSettings llllllllllllIIllllIllIllIIlIlIII, final int llllllllllllIIllllIllIllIIlIIlll) {
        this.addBlocksToWorld(llllllllllllIIllllIllIllIIlIllll, llllllllllllIIllllIllIllIIlIlllI, new BlockRotationProcessor(llllllllllllIIllllIllIllIIlIlllI, llllllllllllIIllllIllIllIIlIlIII), llllllllllllIIllllIllIllIIlIlIII, llllllllllllIIllllIllIllIIlIIlll);
    }
    
    public void addBlocksToWorldChunk(final World llllllllllllIIllllIllIllIlIIlIII, final BlockPos llllllllllllIIllllIllIllIlIIIIll, final PlacementSettings llllllllllllIIllllIllIllIlIIIIlI) {
        llllllllllllIIllllIllIllIlIIIIlI.setBoundingBoxFromChunk();
        this.addBlocksToWorld(llllllllllllIIllllIllIllIlIIlIII, llllllllllllIIllllIllIllIlIIIIll, llllllllllllIIllllIllIllIlIIIIlI);
    }
    
    private static Vec3d transformedVec3d(final Vec3d llllllllllllIIllllIllIlIlIlIIIll, final Mirror llllllllllllIIllllIllIlIlIlIIIlI, final Rotation llllllllllllIIllllIllIlIlIIllIlI) {
        double llllllllllllIIllllIllIlIlIlIIIII = llllllllllllIIllllIllIlIlIlIIIll.xCoord;
        final double llllllllllllIIllllIllIlIlIIlllll = llllllllllllIIllllIllIlIlIlIIIll.yCoord;
        double llllllllllllIIllllIllIlIlIIllllI = llllllllllllIIllllIllIlIlIlIIIll.zCoord;
        boolean llllllllllllIIllllIllIlIlIIlllIl = true;
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[llllllllllllIIllllIllIlIlIlIIIlI.ordinal()]) {
            case 2: {
                llllllllllllIIllllIllIlIlIIllllI = 1.0 - llllllllllllIIllllIllIlIlIIllllI;
                break;
            }
            case 3: {
                llllllllllllIIllllIllIlIlIlIIIII = 1.0 - llllllllllllIIllllIllIlIlIlIIIII;
                break;
            }
            default: {
                llllllllllllIIllllIllIlIlIIlllIl = false;
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllIIllllIllIlIlIIllIlI.ordinal()]) {
            case 4: {
                return new Vec3d(llllllllllllIIllllIllIlIlIIllllI, llllllllllllIIllllIllIlIlIIlllll, 1.0 - llllllllllllIIllllIllIlIlIlIIIII);
            }
            case 2: {
                return new Vec3d(1.0 - llllllllllllIIllllIllIlIlIIllllI, llllllllllllIIllllIllIlIlIIlllll, llllllllllllIIllllIllIlIlIlIIIII);
            }
            case 3: {
                return new Vec3d(1.0 - llllllllllllIIllllIllIlIlIlIIIII, llllllllllllIIllllIllIlIlIIlllll, 1.0 - llllllllllllIIllllIllIlIlIIllllI);
            }
            default: {
                return llllllllllllIIllllIllIlIlIIlllIl ? new Vec3d(llllllllllllIIllllIllIlIlIlIIIII, llllllllllllIIllllIllIlIlIIlllll, llllllllllllIIllllIllIlIlIIllllI) : llllllllllllIIllllIllIlIlIlIIIll;
            }
        }
    }
    
    public void setAuthor(final String llllllllllllIIllllIllIllllIllIlI) {
        this.author = llllllllllllIIllllIllIllllIllIlI;
    }
    
    public void addBlocksToWorld(final World llllllllllllIIllllIllIllIIIlIlIl, final BlockPos llllllllllllIIllllIllIllIIIlIlII, @Nullable final ITemplateProcessor llllllllllllIIllllIllIllIIIIIIII, final PlacementSettings llllllllllllIIllllIllIlIllllllll, final int llllllllllllIIllllIllIllIIIlIIIl) {
        if ((!this.blocks.isEmpty() || (!llllllllllllIIllllIllIlIllllllll.getIgnoreEntities() && !this.entities.isEmpty())) && this.size.getX() >= 1 && this.size.getY() >= 1 && this.size.getZ() >= 1) {
            final Block llllllllllllIIllllIllIllIIIlIIII = llllllllllllIIllllIllIlIllllllll.getReplacedBlock();
            final StructureBoundingBox llllllllllllIIllllIllIllIIIIllll = llllllllllllIIllllIllIlIllllllll.getBoundingBox();
            for (final BlockInfo llllllllllllIIllllIllIllIIIIlllI : this.blocks) {
                final BlockPos llllllllllllIIllllIllIllIIIIllIl = transformedBlockPos(llllllllllllIIllllIllIlIllllllll, llllllllllllIIllllIllIllIIIIlllI.pos).add(llllllllllllIIllllIllIllIIIlIlII);
                final BlockInfo llllllllllllIIllllIllIllIIIIllII = (llllllllllllIIllllIllIllIIIIIIII != null) ? llllllllllllIIllllIllIllIIIIIIII.processBlock(llllllllllllIIllllIllIllIIIlIlIl, llllllllllllIIllllIllIllIIIIllIl, llllllllllllIIllllIllIllIIIIlllI) : llllllllllllIIllllIllIllIIIIlllI;
                if (llllllllllllIIllllIllIllIIIIllII != null) {
                    final Block llllllllllllIIllllIllIllIIIIlIll = llllllllllllIIllllIllIllIIIIllII.blockState.getBlock();
                    if ((llllllllllllIIllllIllIllIIIlIIII != null && llllllllllllIIllllIllIllIIIlIIII == llllllllllllIIllllIllIllIIIIlIll) || (llllllllllllIIllllIllIlIllllllll.getIgnoreStructureBlock() && llllllllllllIIllllIllIllIIIIlIll == Blocks.STRUCTURE_BLOCK) || (llllllllllllIIllllIllIllIIIIllll != null && !llllllllllllIIllllIllIllIIIIllll.isVecInside(llllllllllllIIllllIllIllIIIIllIl))) {
                        continue;
                    }
                    final IBlockState llllllllllllIIllllIllIllIIIIlIlI = llllllllllllIIllllIllIllIIIIllII.blockState.withMirror(llllllllllllIIllllIllIlIllllllll.getMirror());
                    final IBlockState llllllllllllIIllllIllIllIIIIlIIl = llllllllllllIIllllIllIllIIIIlIlI.withRotation(llllllllllllIIllllIllIlIllllllll.getRotation());
                    if (llllllllllllIIllllIllIllIIIIllII.tileentityData != null) {
                        final TileEntity llllllllllllIIllllIllIllIIIIlIII = llllllllllllIIllllIllIllIIIlIlIl.getTileEntity(llllllllllllIIllllIllIllIIIIllIl);
                        if (llllllllllllIIllllIllIllIIIIlIII != null) {
                            if (llllllllllllIIllllIllIllIIIIlIII instanceof IInventory) {
                                ((IInventory)llllllllllllIIllllIllIllIIIIlIII).clear();
                            }
                            llllllllllllIIllllIllIllIIIlIlIl.setBlockState(llllllllllllIIllllIllIllIIIIllIl, Blocks.BARRIER.getDefaultState(), 4);
                        }
                    }
                    if (!llllllllllllIIllllIllIllIIIlIlIl.setBlockState(llllllllllllIIllllIllIllIIIIllIl, llllllllllllIIllllIllIllIIIIlIIl, llllllllllllIIllllIllIllIIIlIIIl) || llllllllllllIIllllIllIllIIIIllII.tileentityData == null) {
                        continue;
                    }
                    final TileEntity llllllllllllIIllllIllIllIIIIIlll = llllllllllllIIllllIllIllIIIlIlIl.getTileEntity(llllllllllllIIllllIllIllIIIIllIl);
                    if (llllllllllllIIllllIllIllIIIIIlll == null) {
                        continue;
                    }
                    llllllllllllIIllllIllIllIIIIllII.tileentityData.setInteger("x", llllllllllllIIllllIllIllIIIIllIl.getX());
                    llllllllllllIIllllIllIllIIIIllII.tileentityData.setInteger("y", llllllllllllIIllllIllIllIIIIllIl.getY());
                    llllllllllllIIllllIllIllIIIIllII.tileentityData.setInteger("z", llllllllllllIIllllIllIllIIIIllIl.getZ());
                    llllllllllllIIllllIllIllIIIIIlll.readFromNBT(llllllllllllIIllllIllIllIIIIllII.tileentityData);
                    llllllllllllIIllllIllIllIIIIIlll.mirror(llllllllllllIIllllIllIlIllllllll.getMirror());
                    llllllllllllIIllllIllIllIIIIIlll.rotate(llllllllllllIIllllIllIlIllllllll.getRotation());
                }
            }
            for (final BlockInfo llllllllllllIIllllIllIllIIIIIllI : this.blocks) {
                if (llllllllllllIIllllIllIllIIIlIIII == null || llllllllllllIIllllIllIllIIIlIIII != llllllllllllIIllllIllIllIIIIIllI.blockState.getBlock()) {
                    final BlockPos llllllllllllIIllllIllIllIIIIIlIl = transformedBlockPos(llllllllllllIIllllIllIlIllllllll, llllllllllllIIllllIllIllIIIIIllI.pos).add(llllllllllllIIllllIllIllIIIlIlII);
                    if (llllllllllllIIllllIllIllIIIIllll != null && !llllllllllllIIllllIllIllIIIIllll.isVecInside(llllllllllllIIllllIllIllIIIIIlIl)) {
                        continue;
                    }
                    llllllllllllIIllllIllIllIIIlIlIl.notifyNeighborsRespectDebug(llllllllllllIIllllIllIllIIIIIlIl, llllllllllllIIllllIllIllIIIIIllI.blockState.getBlock(), false);
                    if (llllllllllllIIllllIllIllIIIIIllI.tileentityData == null) {
                        continue;
                    }
                    final TileEntity llllllllllllIIllllIllIllIIIIIlII = llllllllllllIIllllIllIllIIIlIlIl.getTileEntity(llllllllllllIIllllIllIllIIIIIlIl);
                    if (llllllllllllIIllllIllIllIIIIIlII == null) {
                        continue;
                    }
                    llllllllllllIIllllIllIllIIIIIlII.markDirty();
                }
            }
            if (!llllllllllllIIllllIllIlIllllllll.getIgnoreEntities()) {
                this.addEntitiesToWorld(llllllllllllIIllllIllIllIIIlIlIl, llllllllllllIIllllIllIllIIIlIlII, llllllllllllIIllllIllIlIllllllll.getMirror(), llllllllllllIIllllIllIlIllllllll.getRotation(), llllllllllllIIllllIllIllIIIIllll);
            }
        }
    }
    
    public void read(final NBTTagCompound llllllllllllIIllllIllIlIIIlIlllI) {
        this.blocks.clear();
        this.entities.clear();
        final NBTTagList llllllllllllIIllllIllIlIIlIIIIll = llllllllllllIIllllIllIlIIIlIlllI.getTagList("size", 3);
        this.size = new BlockPos(llllllllllllIIllllIllIlIIlIIIIll.getIntAt(0), llllllllllllIIllllIllIlIIlIIIIll.getIntAt(1), llllllllllllIIllllIllIlIIlIIIIll.getIntAt(2));
        this.author = llllllllllllIIllllIllIlIIIlIlllI.getString("author");
        final BasicPalette llllllllllllIIllllIllIlIIlIIIIlI = new BasicPalette(null);
        final NBTTagList llllllllllllIIllllIllIlIIlIIIIIl = llllllllllllIIllllIllIlIIIlIlllI.getTagList("palette", 10);
        for (int llllllllllllIIllllIllIlIIlIIIIII = 0; llllllllllllIIllllIllIlIIlIIIIII < llllllllllllIIllllIllIlIIlIIIIIl.tagCount(); ++llllllllllllIIllllIllIlIIlIIIIII) {
            llllllllllllIIllllIllIlIIlIIIIlI.addMapping(NBTUtil.readBlockState(llllllllllllIIllllIllIlIIlIIIIIl.getCompoundTagAt(llllllllllllIIllllIllIlIIlIIIIII)), llllllllllllIIllllIllIlIIlIIIIII);
        }
        final NBTTagList llllllllllllIIllllIllIlIIIllllll = llllllllllllIIllllIllIlIIIlIlllI.getTagList("blocks", 10);
        for (int llllllllllllIIllllIllIlIIIlllllI = 0; llllllllllllIIllllIllIlIIIlllllI < llllllllllllIIllllIllIlIIIllllll.tagCount(); ++llllllllllllIIllllIllIlIIIlllllI) {
            final NBTTagCompound llllllllllllIIllllIllIlIIIllllIl = llllllllllllIIllllIllIlIIIllllll.getCompoundTagAt(llllllllllllIIllllIllIlIIIlllllI);
            final NBTTagList llllllllllllIIllllIllIlIIIllllII = llllllllllllIIllllIllIlIIIllllIl.getTagList("pos", 3);
            final BlockPos llllllllllllIIllllIllIlIIIlllIll = new BlockPos(llllllllllllIIllllIllIlIIIllllII.getIntAt(0), llllllllllllIIllllIllIlIIIllllII.getIntAt(1), llllllllllllIIllllIllIlIIIllllII.getIntAt(2));
            final IBlockState llllllllllllIIllllIllIlIIIlllIlI = llllllllllllIIllllIllIlIIlIIIIlI.stateFor(llllllllllllIIllllIllIlIIIllllIl.getInteger("state"));
            NBTTagCompound llllllllllllIIllllIllIlIIIlllIII = null;
            if (llllllllllllIIllllIllIlIIIllllIl.hasKey("nbt")) {
                final NBTTagCompound llllllllllllIIllllIllIlIIIlllIIl = llllllllllllIIllllIllIlIIIllllIl.getCompoundTag("nbt");
            }
            else {
                llllllllllllIIllllIllIlIIIlllIII = null;
            }
            this.blocks.add(new BlockInfo(llllllllllllIIllllIllIlIIIlllIll, llllllllllllIIllllIllIlIIIlllIlI, llllllllllllIIllllIllIlIIIlllIII));
        }
        final NBTTagList llllllllllllIIllllIllIlIIIllIlll = llllllllllllIIllllIllIlIIIlIlllI.getTagList("entities", 10);
        for (int llllllllllllIIllllIllIlIIIllIllI = 0; llllllllllllIIllllIllIlIIIllIllI < llllllllllllIIllllIllIlIIIllIlll.tagCount(); ++llllllllllllIIllllIllIlIIIllIllI) {
            final NBTTagCompound llllllllllllIIllllIllIlIIIllIlIl = llllllllllllIIllllIllIlIIIllIlll.getCompoundTagAt(llllllllllllIIllllIllIlIIIllIllI);
            final NBTTagList llllllllllllIIllllIllIlIIIllIlII = llllllllllllIIllllIllIlIIIllIlIl.getTagList("pos", 6);
            final Vec3d llllllllllllIIllllIllIlIIIllIIll = new Vec3d(llllllllllllIIllllIllIlIIIllIlII.getDoubleAt(0), llllllllllllIIllllIllIlIIIllIlII.getDoubleAt(1), llllllllllllIIllllIllIlIIIllIlII.getDoubleAt(2));
            final NBTTagList llllllllllllIIllllIllIlIIIllIIlI = llllllllllllIIllllIllIlIIIllIlIl.getTagList("blockPos", 3);
            final BlockPos llllllllllllIIllllIllIlIIIllIIIl = new BlockPos(llllllllllllIIllllIllIlIIIllIIlI.getIntAt(0), llllllllllllIIllllIllIlIIIllIIlI.getIntAt(1), llllllllllllIIllllIllIlIIIllIIlI.getIntAt(2));
            if (llllllllllllIIllllIllIlIIIllIlIl.hasKey("nbt")) {
                final NBTTagCompound llllllllllllIIllllIllIlIIIllIIII = llllllllllllIIllllIllIlIIIllIlIl.getCompoundTag("nbt");
                this.entities.add(new EntityInfo(llllllllllllIIllllIllIlIIIllIIll, llllllllllllIIllllIllIlIIIllIIIl, llllllllllllIIllllIllIlIIIllIIII));
            }
        }
    }
    
    public static BlockPos transformedBlockPos(final PlacementSettings llllllllllllIIllllIllIllIlIIllll, final BlockPos llllllllllllIIllllIllIllIlIIlllI) {
        return transformedBlockPos(llllllllllllIIllllIllIllIlIIlllI, llllllllllllIIllllIllIllIlIIllll.getMirror(), llllllllllllIIllllIllIllIlIIllll.getRotation());
    }
    
    private void takeEntitiesFromWorld(final World llllllllllllIIllllIllIlllIIlIllI, final BlockPos llllllllllllIIllllIllIlllIIlIlIl, final BlockPos llllllllllllIIllllIllIlllIIlIlII) {
        final List<Entity> llllllllllllIIllllIllIlllIIlIIll = llllllllllllIIllllIllIlllIIlIllI.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, new AxisAlignedBB(llllllllllllIIllllIllIlllIIlIlIl, llllllllllllIIllllIllIlllIIlIlII), (com.google.common.base.Predicate<? super Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllIllllllIlIllIIllIIIll) {
                return !(lllllllllllIllllllIlIllIIllIIIll instanceof EntityPlayer);
            }
        });
        this.entities.clear();
        for (final Entity llllllllllllIIllllIllIlllIIlIIlI : llllllllllllIIllllIllIlllIIlIIll) {
            final Vec3d llllllllllllIIllllIllIlllIIlIIIl = new Vec3d(llllllllllllIIllllIllIlllIIlIIlI.posX - llllllllllllIIllllIllIlllIIlIlIl.getX(), llllllllllllIIllllIllIlllIIlIIlI.posY - llllllllllllIIllllIllIlllIIlIlIl.getY(), llllllllllllIIllllIllIlllIIlIIlI.posZ - llllllllllllIIllllIllIlllIIlIlIl.getZ());
            final NBTTagCompound llllllllllllIIllllIllIlllIIlIIII = new NBTTagCompound();
            llllllllllllIIllllIllIlllIIlIIlI.writeToNBTOptional(llllllllllllIIllllIllIlllIIlIIII);
            BlockPos llllllllllllIIllllIllIlllIIIlllI = null;
            if (llllllllllllIIllllIllIlllIIlIIlI instanceof EntityPainting) {
                final BlockPos llllllllllllIIllllIllIlllIIIllll = ((EntityPainting)llllllllllllIIllllIllIlllIIlIIlI).getHangingPosition().subtract(llllllllllllIIllllIllIlllIIlIlIl);
            }
            else {
                llllllllllllIIllllIllIlllIIIlllI = new BlockPos(llllllllllllIIllllIllIlllIIlIIIl);
            }
            this.entities.add(new EntityInfo(llllllllllllIIllllIllIlllIIlIIIl, llllllllllllIIllllIllIlllIIIlllI, llllllllllllIIllllIllIlllIIlIIII));
        }
    }
    
    public void takeBlocksFromWorld(final World llllllllllllIIllllIllIllllIIIIll, final BlockPos llllllllllllIIllllIllIlllIllIIIl, final BlockPos llllllllllllIIllllIllIlllIllIIII, final boolean llllllllllllIIllllIllIlllIlIllll, @Nullable final Block llllllllllllIIllllIllIlllIlIlllI) {
        if (llllllllllllIIllllIllIlllIllIIII.getX() >= 1 && llllllllllllIIllllIllIlllIllIIII.getY() >= 1 && llllllllllllIIllllIllIlllIllIIII.getZ() >= 1) {
            final BlockPos llllllllllllIIllllIllIlllIlllllI = llllllllllllIIllllIllIlllIllIIIl.add(llllllllllllIIllllIllIlllIllIIII).add(-1, -1, -1);
            final List<BlockInfo> llllllllllllIIllllIllIlllIllllIl = (List<BlockInfo>)Lists.newArrayList();
            final List<BlockInfo> llllllllllllIIllllIllIlllIllllII = (List<BlockInfo>)Lists.newArrayList();
            final List<BlockInfo> llllllllllllIIllllIllIlllIlllIll = (List<BlockInfo>)Lists.newArrayList();
            final BlockPos llllllllllllIIllllIllIlllIlllIlI = new BlockPos(Math.min(llllllllllllIIllllIllIlllIllIIIl.getX(), llllllllllllIIllllIllIlllIlllllI.getX()), Math.min(llllllllllllIIllllIllIlllIllIIIl.getY(), llllllllllllIIllllIllIlllIlllllI.getY()), Math.min(llllllllllllIIllllIllIlllIllIIIl.getZ(), llllllllllllIIllllIllIlllIlllllI.getZ()));
            final BlockPos llllllllllllIIllllIllIlllIlllIIl = new BlockPos(Math.max(llllllllllllIIllllIllIlllIllIIIl.getX(), llllllllllllIIllllIllIlllIlllllI.getX()), Math.max(llllllllllllIIllllIllIlllIllIIIl.getY(), llllllllllllIIllllIllIlllIlllllI.getY()), Math.max(llllllllllllIIllllIllIlllIllIIIl.getZ(), llllllllllllIIllllIllIlllIlllllI.getZ()));
            this.size = llllllllllllIIllllIllIlllIllIIII;
            for (final BlockPos.MutableBlockPos llllllllllllIIllllIllIlllIlllIII : BlockPos.getAllInBoxMutable(llllllllllllIIllllIllIlllIlllIlI, llllllllllllIIllllIllIlllIlllIIl)) {
                final BlockPos llllllllllllIIllllIllIlllIllIlll = llllllllllllIIllllIllIlllIlllIII.subtract(llllllllllllIIllllIllIlllIlllIlI);
                final IBlockState llllllllllllIIllllIllIlllIllIllI = llllllllllllIIllllIllIllllIIIIll.getBlockState(llllllllllllIIllllIllIlllIlllIII);
                if (llllllllllllIIllllIllIlllIlIlllI == null || llllllllllllIIllllIllIlllIlIlllI != llllllllllllIIllllIllIlllIllIllI.getBlock()) {
                    final TileEntity llllllllllllIIllllIllIlllIllIlIl = llllllllllllIIllllIllIllllIIIIll.getTileEntity(llllllllllllIIllllIllIlllIlllIII);
                    if (llllllllllllIIllllIllIlllIllIlIl != null) {
                        final NBTTagCompound llllllllllllIIllllIllIlllIllIlII = llllllllllllIIllllIllIlllIllIlIl.writeToNBT(new NBTTagCompound());
                        llllllllllllIIllllIllIlllIllIlII.removeTag("x");
                        llllllllllllIIllllIllIlllIllIlII.removeTag("y");
                        llllllllllllIIllllIllIlllIllIlII.removeTag("z");
                        llllllllllllIIllllIllIlllIllllII.add(new BlockInfo(llllllllllllIIllllIllIlllIllIlll, llllllllllllIIllllIllIlllIllIllI, llllllllllllIIllllIllIlllIllIlII));
                    }
                    else if (!llllllllllllIIllllIllIlllIllIllI.isFullBlock() && !llllllllllllIIllllIllIlllIllIllI.isFullCube()) {
                        llllllllllllIIllllIllIlllIlllIll.add(new BlockInfo(llllllllllllIIllllIllIlllIllIlll, llllllllllllIIllllIllIlllIllIllI, null));
                    }
                    else {
                        llllllllllllIIllllIllIlllIllllIl.add(new BlockInfo(llllllllllllIIllllIllIlllIllIlll, llllllllllllIIllllIllIlllIllIllI, null));
                    }
                }
            }
            this.blocks.clear();
            this.blocks.addAll(llllllllllllIIllllIllIlllIllllIl);
            this.blocks.addAll(llllllllllllIIllllIllIlllIllllII);
            this.blocks.addAll(llllllllllllIIllllIllIlllIlllIll);
            if (llllllllllllIIllllIllIlllIlIllll) {
                this.takeEntitiesFromWorld(llllllllllllIIllllIllIllllIIIIll, llllllllllllIIllllIllIlllIlllIlI, llllllllllllIIllllIllIlllIlllIIl.add(1, 1, 1));
            }
            else {
                this.entities.clear();
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = Template.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final String llllllllllllIIllllIllIIllllllllI = (Object)new int[Mirror.values().length];
        try {
            llllllllllllIIllllIllIIllllllllI[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIllllIllIIllllllllI[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIllllIllIIllllllllI[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Template.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)llllllllllllIIllllIllIIllllllllI;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIIllllIllIlIIlIllIlI) {
        final BasicPalette llllllllllllIIllllIllIlIIllIIlII = new BasicPalette(null);
        final NBTTagList llllllllllllIIllllIllIlIIllIIIll = new NBTTagList();
        for (final BlockInfo llllllllllllIIllllIllIlIIllIIIlI : this.blocks) {
            final NBTTagCompound llllllllllllIIllllIllIlIIllIIIIl = new NBTTagCompound();
            llllllllllllIIllllIllIlIIllIIIIl.setTag("pos", this.writeInts(llllllllllllIIllllIllIlIIllIIIlI.pos.getX(), llllllllllllIIllllIllIlIIllIIIlI.pos.getY(), llllllllllllIIllllIllIlIIllIIIlI.pos.getZ()));
            llllllllllllIIllllIllIlIIllIIIIl.setInteger("state", llllllllllllIIllllIllIlIIllIIlII.idFor(llllllllllllIIllllIllIlIIllIIIlI.blockState));
            if (llllllllllllIIllllIllIlIIllIIIlI.tileentityData != null) {
                llllllllllllIIllllIllIlIIllIIIIl.setTag("nbt", llllllllllllIIllllIllIlIIllIIIlI.tileentityData);
            }
            llllllllllllIIllllIllIlIIllIIIll.appendTag(llllllllllllIIllllIllIlIIllIIIIl);
        }
        final NBTTagList llllllllllllIIllllIllIlIIllIIIII = new NBTTagList();
        for (final EntityInfo llllllllllllIIllllIllIlIIlIlllll : this.entities) {
            final NBTTagCompound llllllllllllIIllllIllIlIIlIllllI = new NBTTagCompound();
            llllllllllllIIllllIllIlIIlIllllI.setTag("pos", this.writeDoubles(llllllllllllIIllllIllIlIIlIlllll.pos.xCoord, llllllllllllIIllllIllIlIIlIlllll.pos.yCoord, llllllllllllIIllllIllIlIIlIlllll.pos.zCoord));
            llllllllllllIIllllIllIlIIlIllllI.setTag("blockPos", this.writeInts(llllllllllllIIllllIllIlIIlIlllll.blockPos.getX(), llllllllllllIIllllIllIlIIlIlllll.blockPos.getY(), llllllllllllIIllllIllIlIIlIlllll.blockPos.getZ()));
            if (llllllllllllIIllllIllIlIIlIlllll.entityData != null) {
                llllllllllllIIllllIllIlIIlIllllI.setTag("nbt", llllllllllllIIllllIllIlIIlIlllll.entityData);
            }
            llllllllllllIIllllIllIlIIllIIIII.appendTag(llllllllllllIIllllIllIlIIlIllllI);
        }
        final NBTTagList llllllllllllIIllllIllIlIIlIlllIl = new NBTTagList();
        for (final IBlockState llllllllllllIIllllIllIlIIlIlllII : llllllllllllIIllllIllIlIIllIIlII) {
            llllllllllllIIllllIllIlIIlIlllIl.appendTag(NBTUtil.writeBlockState(new NBTTagCompound(), llllllllllllIIllllIllIlIIlIlllII));
        }
        llllllllllllIIllllIllIlIIlIllIlI.setTag("palette", llllllllllllIIllllIllIlIIlIlllIl);
        llllllllllllIIllllIllIlIIlIllIlI.setTag("blocks", llllllllllllIIllllIllIlIIllIIIll);
        llllllllllllIIllllIllIlIIlIllIlI.setTag("entities", llllllllllllIIllllIllIlIIllIIIII);
        llllllllllllIIllllIllIlIIlIllIlI.setTag("size", this.writeInts(this.size.getX(), this.size.getY(), this.size.getZ()));
        llllllllllllIIllllIllIlIIlIllIlI.setString("author", this.author);
        llllllllllllIIllllIllIlIIlIllIlI.setInteger("DataVersion", 1343);
        return llllllllllllIIllllIllIlIIlIllIlI;
    }
    
    public static class BlockInfo
    {
        public final /* synthetic */ BlockPos pos;
        public final /* synthetic */ NBTTagCompound tileentityData;
        public final /* synthetic */ IBlockState blockState;
        
        public BlockInfo(final BlockPos lllllllllllIIIIIlIlIIlllIIIIIIII, final IBlockState lllllllllllIIIIIlIlIIllIllllllll, @Nullable final NBTTagCompound lllllllllllIIIIIlIlIIlllIIIIIIlI) {
            this.pos = lllllllllllIIIIIlIlIIlllIIIIIIII;
            this.blockState = lllllllllllIIIIIlIlIIllIllllllll;
            this.tileentityData = lllllllllllIIIIIlIlIIlllIIIIIIlI;
        }
    }
    
    static class BasicPalette implements Iterable<IBlockState>
    {
        final /* synthetic */ ObjectIntIdentityMap<IBlockState> ids;
        private /* synthetic */ int lastId;
        public static final /* synthetic */ IBlockState DEFAULT_BLOCK_STATE;
        
        public void addMapping(final IBlockState lllllllllllIlllIIIlIIlllIlIIllll, final int lllllllllllIlllIIIlIIlllIlIIlllI) {
            this.ids.put(lllllllllllIlllIIIlIIlllIlIIllll, lllllllllllIlllIIIlIIlllIlIIlllI);
        }
        
        private BasicPalette() {
            this.ids = new ObjectIntIdentityMap<IBlockState>(16);
        }
        
        @Nullable
        public IBlockState stateFor(final int lllllllllllIlllIIIlIIlllIlIllIII) {
            final IBlockState lllllllllllIlllIIIlIIlllIlIllIlI = this.ids.getByValue(lllllllllllIlllIIIlIIlllIlIllIII);
            return (lllllllllllIlllIIIlIIlllIlIllIlI == null) ? BasicPalette.DEFAULT_BLOCK_STATE : lllllllllllIlllIIIlIIlllIlIllIlI;
        }
        
        public int idFor(final IBlockState lllllllllllIlllIIIlIIlllIllIIIIl) {
            int lllllllllllIlllIIIlIIlllIllIIIll = this.ids.get(lllllllllllIlllIIIlIIlllIllIIIIl);
            if (lllllllllllIlllIIIlIIlllIllIIIll == -1) {
                lllllllllllIlllIIIlIIlllIllIIIll = this.lastId++;
                this.ids.put(lllllllllllIlllIIIlIIlllIllIIIIl, lllllllllllIlllIIIlIIlllIllIIIll);
            }
            return lllllllllllIlllIIIlIIlllIllIIIll;
        }
        
        static {
            DEFAULT_BLOCK_STATE = Blocks.AIR.getDefaultState();
        }
        
        @Override
        public Iterator<IBlockState> iterator() {
            return this.ids.iterator();
        }
    }
    
    public static class EntityInfo
    {
        public final /* synthetic */ BlockPos blockPos;
        public final /* synthetic */ Vec3d pos;
        public final /* synthetic */ NBTTagCompound entityData;
        
        public EntityInfo(final Vec3d lllllllllllllllllIIlIllIIllIIlll, final BlockPos lllllllllllllllllIIlIllIIllIlIlI, final NBTTagCompound lllllllllllllllllIIlIllIIllIIlIl) {
            this.pos = lllllllllllllllllIIlIllIIllIIlll;
            this.blockPos = lllllllllllllllllIIlIllIIllIlIlI;
            this.entityData = lllllllllllllllllIIlIllIIllIIlIl;
        }
    }
}

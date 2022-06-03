// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.IStringSerializable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStructure;
import io.netty.buffer.ByteBuf;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.StringUtils;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.ITextComponent;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.BlockPos;

public class TileEntityStructure extends TileEntity
{
    private /* synthetic */ BlockPos position;
    private /* synthetic */ boolean ignoreEntities;
    private /* synthetic */ String name;
    private /* synthetic */ float integrity;
    private /* synthetic */ BlockPos size;
    private /* synthetic */ Mirror mirror;
    private /* synthetic */ Rotation rotation;
    private /* synthetic */ boolean powered;
    private /* synthetic */ boolean showBoundingBox;
    private /* synthetic */ long seed;
    private /* synthetic */ String author;
    private /* synthetic */ Mode mode;
    private /* synthetic */ boolean showAir;
    private /* synthetic */ String metadata;
    
    private List<TileEntityStructure> getNearbyCornerBlocks(final BlockPos lllllllllllIlIIIIlIlIIlIlIIlIllI, final BlockPos lllllllllllIlIIIIlIlIIlIlIIIlllI) {
        final List<TileEntityStructure> lllllllllllIlIIIIlIlIIlIlIIlIlII = (List<TileEntityStructure>)Lists.newArrayList();
        for (final BlockPos.MutableBlockPos lllllllllllIlIIIIlIlIIlIlIIlIIll : BlockPos.getAllInBoxMutable(lllllllllllIlIIIIlIlIIlIlIIlIllI, lllllllllllIlIIIIlIlIIlIlIIIlllI)) {
            final IBlockState lllllllllllIlIIIIlIlIIlIlIIlIIlI = this.world.getBlockState(lllllllllllIlIIIIlIlIIlIlIIlIIll);
            if (lllllllllllIlIIIIlIlIIlIlIIlIIlI.getBlock() == Blocks.STRUCTURE_BLOCK) {
                final TileEntity lllllllllllIlIIIIlIlIIlIlIIlIIIl = this.world.getTileEntity(lllllllllllIlIIIIlIlIIlIlIIlIIll);
                if (lllllllllllIlIIIIlIlIIlIlIIlIIIl == null || !(lllllllllllIlIIIIlIlIIlIlIIlIIIl instanceof TileEntityStructure)) {
                    continue;
                }
                lllllllllllIlIIIIlIlIIlIlIIlIlII.add((TileEntityStructure)lllllllllllIlIIIIlIlIIlIlIIlIIIl);
            }
        }
        return lllllllllllIlIIIIlIlIIlIlIIlIlII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = TileEntityStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        }
        final long lllllllllllIlIIIIlIlIIIlllllllIl = (Object)new int[Mode.values().length];
        try {
            lllllllllllIlIIIIlIlIIIlllllllIl[Mode.CORNER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlIIIIlIlIIIlllllllIl[Mode.DATA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlIIIIlIlIIIlllllllIl[Mode.LOAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlIIIIlIlIIIlllllllIl[Mode.SAVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return TileEntityStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = (int[])(Object)lllllllllllIlIIIIlIlIIIlllllllIl;
    }
    
    public boolean load() {
        return this.load(true);
    }
    
    public void setPosition(final BlockPos lllllllllllIlIIIIlIlIIllIIIlIIlI) {
        this.position = lllllllllllIlIIIIlIlIIllIIIlIIlI;
    }
    
    public boolean showsBoundingBox() {
        return this.showBoundingBox;
    }
    
    private List<TileEntityStructure> filterRelatedCornerBlocks(final List<TileEntityStructure> lllllllllllIlIIIIlIlIIlIlIlIIlII) {
        final Iterable<TileEntityStructure> lllllllllllIlIIIIlIlIIlIlIlIIIll = (Iterable<TileEntityStructure>)Iterables.filter((Iterable)lllllllllllIlIIIIlIlIIlIlIlIIlII, (Predicate)new Predicate<TileEntityStructure>() {
            public boolean apply(@Nullable final TileEntityStructure llllllllllllIlIIIIlIIIIllIIIlIIl) {
                return llllllllllllIlIIIIlIIIIllIIIlIIl.mode == Mode.CORNER && TileEntityStructure.this.name.equals(llllllllllllIlIIIIlIIIIllIIIlIIl.name);
            }
        });
        return (List<TileEntityStructure>)Lists.newArrayList((Iterable)lllllllllllIlIIIIlIlIIlIlIlIIIll);
    }
    
    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation("structure_block.hover." + this.mode.modeName, new Object[] { (this.mode == Mode.DATA) ? this.metadata : this.name });
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public void setName(final String lllllllllllIlIIIIlIlIIllIIlIlIlI) {
        String lllllllllllIlIIIIlIlIIllIIlIlIIl = lllllllllllIlIIIIlIlIIllIIlIlIlI;
        final short lllllllllllIlIIIIlIlIIllIIlIIIIl;
        final Exception lllllllllllIlIIIIlIlIIllIIlIIIlI = (Exception)((char[])(Object)(lllllllllllIlIIIIlIlIIllIIlIIIIl = (short)(Object)ChatAllowedCharacters.ILLEGAL_STRUCTURE_CHARACTERS)).length;
        for (float lllllllllllIlIIIIlIlIIllIIlIIIll = 0; lllllllllllIlIIIIlIlIIllIIlIIIll < lllllllllllIlIIIIlIlIIllIIlIIIlI; ++lllllllllllIlIIIIlIlIIllIIlIIIll) {
            final char lllllllllllIlIIIIlIlIIllIIlIlIII = lllllllllllIlIIIIlIlIIllIIlIIIIl[lllllllllllIlIIIIlIlIIllIIlIIIll];
            lllllllllllIlIIIIlIlIIllIIlIlIIl = lllllllllllIlIIIIlIlIIllIIlIlIIl.replace(lllllllllllIlIIIIlIlIIllIIlIlIII, '_');
        }
        this.name = lllllllllllIlIIIIlIlIIllIIlIlIIl;
    }
    
    public boolean save(final boolean lllllllllllIlIIIIlIlIIlIIlIlllII) {
        if (this.mode == Mode.SAVE && !this.world.isRemote && !StringUtils.isNullOrEmpty(this.name)) {
            final BlockPos lllllllllllIlIIIIlIlIIlIIllIIIlI = this.getPos().add(this.position);
            final WorldServer lllllllllllIlIIIIlIlIIlIIllIIIIl = (WorldServer)this.world;
            final MinecraftServer lllllllllllIlIIIIlIlIIlIIllIIIII = this.world.getMinecraftServer();
            final TemplateManager lllllllllllIlIIIIlIlIIlIIlIlllll = lllllllllllIlIIIIlIlIIlIIllIIIIl.getStructureTemplateManager();
            final Template lllllllllllIlIIIIlIlIIlIIlIllllI = lllllllllllIlIIIIlIlIIlIIlIlllll.getTemplate(lllllllllllIlIIIIlIlIIlIIllIIIII, new ResourceLocation(this.name));
            lllllllllllIlIIIIlIlIIlIIlIllllI.takeBlocksFromWorld(this.world, lllllllllllIlIIIIlIlIIlIIllIIIlI, this.size, !this.ignoreEntities, Blocks.STRUCTURE_VOID);
            lllllllllllIlIIIIlIlIIlIIlIllllI.setAuthor(this.author);
            return !lllllllllllIlIIIIlIlIIlIIlIlllII || lllllllllllIlIIIIlIlIIlIIlIlllll.writeTemplate(lllllllllllIlIIIIlIlIIlIIllIIIII, new ResourceLocation(this.name));
        }
        return false;
    }
    
    public Mirror getMirror() {
        return this.mirror;
    }
    
    public boolean load(final boolean lllllllllllIlIIIIlIlIIlIIIlllIll) {
        if (this.mode != Mode.LOAD || this.world.isRemote || StringUtils.isNullOrEmpty(this.name)) {
            return false;
        }
        final BlockPos lllllllllllIlIIIIlIlIIlIIlIIIllI = this.getPos();
        final BlockPos lllllllllllIlIIIIlIlIIlIIlIIIlIl = lllllllllllIlIIIIlIlIIlIIlIIIllI.add(this.position);
        final WorldServer lllllllllllIlIIIIlIlIIlIIlIIIlII = (WorldServer)this.world;
        final MinecraftServer lllllllllllIlIIIIlIlIIlIIlIIIIll = this.world.getMinecraftServer();
        final TemplateManager lllllllllllIlIIIIlIlIIlIIlIIIIlI = lllllllllllIlIIIIlIlIIlIIlIIIlII.getStructureTemplateManager();
        final Template lllllllllllIlIIIIlIlIIlIIlIIIIIl = lllllllllllIlIIIIlIlIIlIIlIIIIlI.get(lllllllllllIlIIIIlIlIIlIIlIIIIll, new ResourceLocation(this.name));
        if (lllllllllllIlIIIIlIlIIlIIlIIIIIl == null) {
            return false;
        }
        if (!StringUtils.isNullOrEmpty(lllllllllllIlIIIIlIlIIlIIlIIIIIl.getAuthor())) {
            this.author = lllllllllllIlIIIIlIlIIlIIlIIIIIl.getAuthor();
        }
        final BlockPos lllllllllllIlIIIIlIlIIlIIlIIIIII = lllllllllllIlIIIIlIlIIlIIlIIIIIl.getSize();
        final boolean lllllllllllIlIIIIlIlIIlIIIllllll = this.size.equals(lllllllllllIlIIIIlIlIIlIIlIIIIII);
        if (!lllllllllllIlIIIIlIlIIlIIIllllll) {
            this.size = lllllllllllIlIIIIlIlIIlIIlIIIIII;
            this.markDirty();
            final IBlockState lllllllllllIlIIIIlIlIIlIIIlllllI = this.world.getBlockState(lllllllllllIlIIIIlIlIIlIIlIIIllI);
            this.world.notifyBlockUpdate(lllllllllllIlIIIIlIlIIlIIlIIIllI, lllllllllllIlIIIIlIlIIlIIIlllllI, lllllllllllIlIIIIlIlIIlIIIlllllI, 3);
        }
        if (lllllllllllIlIIIIlIlIIlIIIlllIll && !lllllllllllIlIIIIlIlIIlIIIllllll) {
            return false;
        }
        final PlacementSettings lllllllllllIlIIIIlIlIIlIIIllllIl = new PlacementSettings().setMirror(this.mirror).setRotation(this.rotation).setIgnoreEntities(this.ignoreEntities).setChunk(null).setReplacedBlock(null).setIgnoreStructureBlock(false);
        if (this.integrity < 1.0f) {
            lllllllllllIlIIIIlIlIIlIIIllllIl.setIntegrity(MathHelper.clamp(this.integrity, 0.0f, 1.0f)).setSeed(this.seed);
        }
        lllllllllllIlIIIIlIlIIlIIlIIIIIl.addBlocksToWorldChunk(this.world, lllllllllllIlIIIIlIlIIlIIlIIIlIl, lllllllllllIlIIIIlIlIIlIIIllllIl);
        return true;
    }
    
    public void setSeed(final long lllllllllllIlIIIIlIlIIlIllIIIllI) {
        this.seed = lllllllllllIlIIIIlIlIIlIllIIIllI;
    }
    
    public boolean detectSize() {
        if (this.mode != Mode.SAVE) {
            return false;
        }
        final BlockPos lllllllllllIlIIIIlIlIIlIlIlllIIl = this.getPos();
        final int lllllllllllIlIIIIlIlIIlIlIlllIII = 80;
        final BlockPos lllllllllllIlIIIIlIlIIlIlIllIlll = new BlockPos(lllllllllllIlIIIIlIlIIlIlIlllIIl.getX() - 80, 0, lllllllllllIlIIIIlIlIIlIlIlllIIl.getZ() - 80);
        final BlockPos lllllllllllIlIIIIlIlIIlIlIllIllI = new BlockPos(lllllllllllIlIIIIlIlIIlIlIlllIIl.getX() + 80, 255, lllllllllllIlIIIIlIlIIlIlIlllIIl.getZ() + 80);
        final List<TileEntityStructure> lllllllllllIlIIIIlIlIIlIlIllIlIl = this.getNearbyCornerBlocks(lllllllllllIlIIIIlIlIIlIlIllIlll, lllllllllllIlIIIIlIlIIlIlIllIllI);
        final List<TileEntityStructure> lllllllllllIlIIIIlIlIIlIlIllIlII = this.filterRelatedCornerBlocks(lllllllllllIlIIIIlIlIIlIlIllIlIl);
        if (lllllllllllIlIIIIlIlIIlIlIllIlII.size() < 1) {
            return false;
        }
        final StructureBoundingBox lllllllllllIlIIIIlIlIIlIlIllIIll = this.calculateEnclosingBoundingBox(lllllllllllIlIIIIlIlIIlIlIlllIIl, lllllllllllIlIIIIlIlIIlIlIllIlII);
        if (lllllllllllIlIIIIlIlIIlIlIllIIll.maxX - lllllllllllIlIIIIlIlIIlIlIllIIll.minX > 1 && lllllllllllIlIIIIlIlIIlIlIllIIll.maxY - lllllllllllIlIIIIlIlIIlIlIllIIll.minY > 1 && lllllllllllIlIIIIlIlIIlIlIllIIll.maxZ - lllllllllllIlIIIIlIlIIlIlIllIIll.minZ > 1) {
            this.position = new BlockPos(lllllllllllIlIIIIlIlIIlIlIllIIll.minX - lllllllllllIlIIIIlIlIIlIlIlllIIl.getX() + 1, lllllllllllIlIIIIlIlIIlIlIllIIll.minY - lllllllllllIlIIIIlIlIIlIlIlllIIl.getY() + 1, lllllllllllIlIIIIlIlIIlIlIllIIll.minZ - lllllllllllIlIIIIlIlIIlIlIlllIIl.getZ() + 1);
            this.size = new BlockPos(lllllllllllIlIIIIlIlIIlIlIllIIll.maxX - lllllllllllIlIIIIlIlIIlIlIllIIll.minX - 1, lllllllllllIlIIIIlIlIIlIlIllIIll.maxY - lllllllllllIlIIIIlIlIIlIlIllIIll.minY - 1, lllllllllllIlIIIIlIlIIlIlIllIIll.maxZ - lllllllllllIlIIIIlIlIIlIlIllIIll.minZ - 1);
            this.markDirty();
            final IBlockState lllllllllllIlIIIIlIlIIlIlIllIIlI = this.world.getBlockState(lllllllllllIlIIIIlIlIIlIlIlllIIl);
            this.world.notifyBlockUpdate(lllllllllllIlIIIIlIlIIlIlIlllIIl, lllllllllllIlIIIIlIlIIlIlIllIIlI, lllllllllllIlIIIIlIlIIlIlIllIIlI, 3);
            return true;
        }
        return false;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIlIIIIlIlIIllIllIlIlI) {
        super.writeToNBT(lllllllllllIlIIIIlIlIIllIllIlIlI);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setString("name", this.name);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setString("author", this.author);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setString("metadata", this.metadata);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setInteger("posX", this.position.getX());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setInteger("posY", this.position.getY());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setInteger("posZ", this.position.getZ());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setInteger("sizeX", this.size.getX());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setInteger("sizeY", this.size.getY());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setInteger("sizeZ", this.size.getZ());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setString("rotation", this.rotation.toString());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setString("mirror", this.mirror.toString());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setString("mode", this.mode.toString());
        lllllllllllIlIIIIlIlIIllIllIlIlI.setBoolean("ignoreEntities", this.ignoreEntities);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setBoolean("powered", this.powered);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setBoolean("showair", this.showAir);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setBoolean("showboundingbox", this.showBoundingBox);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setFloat("integrity", this.integrity);
        lllllllllllIlIIIIlIlIIllIllIlIlI.setLong("seed", this.seed);
        return lllllllllllIlIIIIlIlIIllIllIlIlI;
    }
    
    public void writeCoordinates(final ByteBuf lllllllllllIlIIIIlIlIIlIIlllIIIl) {
        lllllllllllIlIIIIlIlIIlIIlllIIIl.writeInt(this.pos.getX());
        lllllllllllIlIIIIlIlIIlIIlllIIIl.writeInt(this.pos.getY());
        lllllllllllIlIIIIlIlIIlIIlllIIIl.writeInt(this.pos.getZ());
    }
    
    public void setMetadata(final String lllllllllllIlIIIIlIlIIlIlllIlllI) {
        this.metadata = lllllllllllIlIIIIlIlIIlIlllIlllI;
    }
    
    public boolean save() {
        return this.save(true);
    }
    
    public String getMetadata() {
        return this.metadata;
    }
    
    public boolean isPowered() {
        return this.powered;
    }
    
    public float getIntegrity() {
        return this.integrity;
    }
    
    public void setShowAir(final boolean lllllllllllIlIIIIlIlIIlIIIIIllIl) {
        this.showAir = lllllllllllIlIIIIlIlIIlIIIIIllIl;
    }
    
    public void setPowered(final boolean lllllllllllIlIIIIlIlIIlIIIIlIllI) {
        this.powered = lllllllllllIlIIIIlIlIIlIIIIlIllI;
    }
    
    private StructureBoundingBox calculateEnclosingBoundingBox(final BlockPos lllllllllllIlIIIIlIlIIlIIllllIlI, final List<TileEntityStructure> lllllllllllIlIIIIlIlIIlIlIIIIIII) {
        StructureBoundingBox lllllllllllIlIIIIlIlIIlIIllllllI = null;
        if (lllllllllllIlIIIIlIlIIlIlIIIIIII.size() > 1) {
            final BlockPos lllllllllllIlIIIIlIlIIlIIlllllIl = lllllllllllIlIIIIlIlIIlIlIIIIIII.get(0).getPos();
            final StructureBoundingBox lllllllllllIlIIIIlIlIIlIIlllllll = new StructureBoundingBox(lllllllllllIlIIIIlIlIIlIIlllllIl, lllllllllllIlIIIIlIlIIlIIlllllIl);
        }
        else {
            lllllllllllIlIIIIlIlIIlIIllllllI = new StructureBoundingBox(lllllllllllIlIIIIlIlIIlIIllllIlI, lllllllllllIlIIIIlIlIIlIIllllIlI);
        }
        for (final TileEntityStructure lllllllllllIlIIIIlIlIIlIIlllllII : lllllllllllIlIIIIlIlIIlIlIIIIIII) {
            final BlockPos lllllllllllIlIIIIlIlIIlIIllllIll = lllllllllllIlIIIIlIlIIlIIlllllII.getPos();
            if (lllllllllllIlIIIIlIlIIlIIllllIll.getX() < lllllllllllIlIIIIlIlIIlIIllllllI.minX) {
                lllllllllllIlIIIIlIlIIlIIllllllI.minX = lllllllllllIlIIIIlIlIIlIIllllIll.getX();
            }
            else if (lllllllllllIlIIIIlIlIIlIIllllIll.getX() > lllllllllllIlIIIIlIlIIlIIllllllI.maxX) {
                lllllllllllIlIIIIlIlIIlIIllllllI.maxX = lllllllllllIlIIIIlIlIIlIIllllIll.getX();
            }
            if (lllllllllllIlIIIIlIlIIlIIllllIll.getY() < lllllllllllIlIIIIlIlIIlIIllllllI.minY) {
                lllllllllllIlIIIIlIlIIlIIllllllI.minY = lllllllllllIlIIIIlIlIIlIIllllIll.getY();
            }
            else if (lllllllllllIlIIIIlIlIIlIIllllIll.getY() > lllllllllllIlIIIIlIlIIlIIllllllI.maxY) {
                lllllllllllIlIIIIlIlIIlIIllllllI.maxY = lllllllllllIlIIIIlIlIIlIIllllIll.getY();
            }
            if (lllllllllllIlIIIIlIlIIlIIllllIll.getZ() < lllllllllllIlIIIIlIlIIlIIllllllI.minZ) {
                lllllllllllIlIIIIlIlIIlIIllllllI.minZ = lllllllllllIlIIIIlIlIIlIIllllIll.getZ();
            }
            else {
                if (lllllllllllIlIIIIlIlIIlIIllllIll.getZ() <= lllllllllllIlIIIIlIlIIlIIllllllI.maxZ) {
                    continue;
                }
                lllllllllllIlIIIIlIlIIlIIllllllI.maxZ = lllllllllllIlIIIIlIlIIlIIllllIll.getZ();
            }
        }
        return lllllllllllIlIIIIlIlIIlIIllllllI;
    }
    
    public void setRotation(final Rotation lllllllllllIlIIIIlIlIIlIlllllIIl) {
        this.rotation = lllllllllllIlIIIIlIlIIlIlllllIIl;
    }
    
    public void unloadStructure() {
        final WorldServer lllllllllllIlIIIIlIlIIlIIIlIllIl = (WorldServer)this.world;
        final TemplateManager lllllllllllIlIIIIlIlIIlIIIlIllII = lllllllllllIlIIIIlIlIIlIIIlIllIl.getStructureTemplateManager();
        lllllllllllIlIIIIlIlIIlIIIlIllII.remove(new ResourceLocation(this.name));
    }
    
    public void setShowBoundingBox(final boolean lllllllllllIlIIIIlIlIIlIIIIIIlII) {
        this.showBoundingBox = lllllllllllIlIIIIlIlIIlIIIIIIlII;
    }
    
    public boolean ignoresEntities() {
        return this.ignoreEntities;
    }
    
    public boolean showsAir() {
        return this.showAir;
    }
    
    public void setIgnoresEntities(final boolean lllllllllllIlIIIIlIlIIlIllIllIII) {
        this.ignoreEntities = lllllllllllIlIIIIlIlIIlIllIllIII;
    }
    
    public void setIntegrity(final float lllllllllllIlIIIIlIlIIlIllIIllIl) {
        this.integrity = lllllllllllIlIIIIlIlIIlIllIIllIl;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public BlockPos getStructureSize() {
        return this.size;
    }
    
    public boolean isStructureLoadable() {
        if (this.mode == Mode.LOAD && !this.world.isRemote) {
            final WorldServer lllllllllllIlIIIIlIlIIlIIIlIIIll = (WorldServer)this.world;
            final MinecraftServer lllllllllllIlIIIIlIlIIlIIIlIIIlI = this.world.getMinecraftServer();
            final TemplateManager lllllllllllIlIIIIlIlIIlIIIlIIIIl = lllllllllllIlIIIIlIlIIlIIIlIIIll.getStructureTemplateManager();
            return lllllllllllIlIIIIlIlIIlIIIlIIIIl.get(lllllllllllIlIIIIlIlIIlIIIlIIIlI, new ResourceLocation(this.name)) != null;
        }
        return false;
    }
    
    public void nextMode() {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode()[this.getMode().ordinal()]) {
            case 1: {
                this.setMode(Mode.LOAD);
                break;
            }
            case 2: {
                this.setMode(Mode.CORNER);
                break;
            }
            case 3: {
                this.setMode(Mode.DATA);
                break;
            }
            case 4: {
                this.setMode(Mode.SAVE);
                break;
            }
        }
    }
    
    public void setMode(final Mode lllllllllllIlIIIIlIlIIlIlllIIIll) {
        this.mode = lllllllllllIlIIIIlIlIIlIlllIIIll;
        final IBlockState lllllllllllIlIIIIlIlIIlIlllIIlIl = this.world.getBlockState(this.getPos());
        if (lllllllllllIlIIIIlIlIIlIlllIIlIl.getBlock() == Blocks.STRUCTURE_BLOCK) {
            this.world.setBlockState(this.getPos(), lllllllllllIlIIIIlIlIIlIlllIIlIl.withProperty(BlockStructure.MODE, lllllllllllIlIIIIlIlIIlIlllIIIll), 2);
        }
    }
    
    private void updateBlockState() {
        if (this.world != null) {
            final BlockPos lllllllllllIlIIIIlIlIIllIlIIIllI = this.getPos();
            final IBlockState lllllllllllIlIIIIlIlIIllIlIIIlIl = this.world.getBlockState(lllllllllllIlIIIIlIlIIllIlIIIllI);
            if (lllllllllllIlIIIIlIlIIllIlIIIlIl.getBlock() == Blocks.STRUCTURE_BLOCK) {
                this.world.setBlockState(lllllllllllIlIIIIlIlIIllIlIIIllI, lllllllllllIlIIIIlIlIIllIlIIIlIl.withProperty(BlockStructure.MODE, this.mode), 2);
            }
        }
    }
    
    public TileEntityStructure() {
        this.name = "";
        this.author = "";
        this.metadata = "";
        this.position = new BlockPos(0, 1, 0);
        this.size = BlockPos.ORIGIN;
        this.mirror = Mirror.NONE;
        this.rotation = Rotation.NONE;
        this.mode = Mode.DATA;
        this.ignoreEntities = true;
        this.showBoundingBox = true;
        this.integrity = 1.0f;
    }
    
    public Mode getMode() {
        return this.mode;
    }
    
    public void setSize(final BlockPos lllllllllllIlIIIIlIlIIllIIIIlIIl) {
        this.size = lllllllllllIlIIIIlIlIIllIIIIlIIl;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIlIIIIlIlIIllIlIlIIlI) {
        super.readFromNBT(lllllllllllIlIIIIlIlIIllIlIlIIlI);
        this.setName(lllllllllllIlIIIIlIlIIllIlIlIIlI.getString("name"));
        this.author = lllllllllllIlIIIIlIlIIllIlIlIIlI.getString("author");
        this.metadata = lllllllllllIlIIIIlIlIIllIlIlIIlI.getString("metadata");
        final int lllllllllllIlIIIIlIlIIllIlIlllII = MathHelper.clamp(lllllllllllIlIIIIlIlIIllIlIlIIlI.getInteger("posX"), -32, 32);
        final int lllllllllllIlIIIIlIlIIllIlIllIll = MathHelper.clamp(lllllllllllIlIIIIlIlIIllIlIlIIlI.getInteger("posY"), -32, 32);
        final int lllllllllllIlIIIIlIlIIllIlIllIlI = MathHelper.clamp(lllllllllllIlIIIIlIlIIllIlIlIIlI.getInteger("posZ"), -32, 32);
        this.position = new BlockPos(lllllllllllIlIIIIlIlIIllIlIlllII, lllllllllllIlIIIIlIlIIllIlIllIll, lllllllllllIlIIIIlIlIIllIlIllIlI);
        final int lllllllllllIlIIIIlIlIIllIlIllIIl = MathHelper.clamp(lllllllllllIlIIIIlIlIIllIlIlIIlI.getInteger("sizeX"), 0, 32);
        final int lllllllllllIlIIIIlIlIIllIlIllIII = MathHelper.clamp(lllllllllllIlIIIIlIlIIllIlIlIIlI.getInteger("sizeY"), 0, 32);
        final int lllllllllllIlIIIIlIlIIllIlIlIlll = MathHelper.clamp(lllllllllllIlIIIIlIlIIllIlIlIIlI.getInteger("sizeZ"), 0, 32);
        this.size = new BlockPos(lllllllllllIlIIIIlIlIIllIlIllIIl, lllllllllllIlIIIIlIlIIllIlIllIII, lllllllllllIlIIIIlIlIIllIlIlIlll);
        try {
            this.rotation = Rotation.valueOf(lllllllllllIlIIIIlIlIIllIlIlIIlI.getString("rotation"));
        }
        catch (IllegalArgumentException lllllllllllIlIIIIlIlIIllIlIlIllI) {
            this.rotation = Rotation.NONE;
        }
        try {
            this.mirror = Mirror.valueOf(lllllllllllIlIIIIlIlIIllIlIlIIlI.getString("mirror"));
        }
        catch (IllegalArgumentException lllllllllllIlIIIIlIlIIllIlIlIlIl) {
            this.mirror = Mirror.NONE;
        }
        try {
            this.mode = Mode.valueOf(lllllllllllIlIIIIlIlIIllIlIlIIlI.getString("mode"));
        }
        catch (IllegalArgumentException lllllllllllIlIIIIlIlIIllIlIlIlII) {
            this.mode = Mode.DATA;
        }
        this.ignoreEntities = lllllllllllIlIIIIlIlIIllIlIlIIlI.getBoolean("ignoreEntities");
        this.powered = lllllllllllIlIIIIlIlIIllIlIlIIlI.getBoolean("powered");
        this.showAir = lllllllllllIlIIIIlIlIIllIlIlIIlI.getBoolean("showair");
        this.showBoundingBox = lllllllllllIlIIIIlIlIIllIlIlIIlI.getBoolean("showboundingbox");
        if (lllllllllllIlIIIIlIlIIllIlIlIIlI.hasKey("integrity")) {
            this.integrity = lllllllllllIlIIIIlIlIIllIlIlIIlI.getFloat("integrity");
        }
        else {
            this.integrity = 1.0f;
        }
        this.seed = lllllllllllIlIIIIlIlIIllIlIlIIlI.getLong("seed");
        this.updateBlockState();
    }
    
    public long getSeed() {
        return this.seed;
    }
    
    public Rotation getRotation() {
        return this.rotation;
    }
    
    public void setMirror(final Mirror lllllllllllIlIIIIlIlIIllIIIIIIII) {
        this.mirror = lllllllllllIlIIIIlIlIIllIIIIIIII;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 7, this.getUpdateTag());
    }
    
    public String getName() {
        return this.name;
    }
    
    public void createdBy(final EntityLivingBase lllllllllllIlIIIIlIlIIllIIIllIll) {
        if (!StringUtils.isNullOrEmpty(lllllllllllIlIIIIlIlIIllIIIllIll.getName())) {
            this.author = lllllllllllIlIIIIlIlIIllIIIllIll.getName();
        }
    }
    
    public boolean usedBy(final EntityPlayer lllllllllllIlIIIIlIlIIllIIlllIII) {
        if (!lllllllllllIlIIIIlIlIIllIIlllIII.canUseCommandBlock()) {
            return false;
        }
        if (lllllllllllIlIIIIlIlIIllIIlllIII.getEntityWorld().isRemote) {
            lllllllllllIlIIIIlIlIIllIIlllIII.openEditStructure(this);
        }
        return true;
    }
    
    public enum Mode implements IStringSerializable
    {
        private final /* synthetic */ int modeId;
        
        DATA("DATA", 3, "data", 3), 
        SAVE("SAVE", 0, "save", 0);
        
        private static final /* synthetic */ Mode[] MODES;
        
        CORNER("CORNER", 2, "corner", 2);
        
        private final /* synthetic */ String modeName;
        
        LOAD("LOAD", 1, "load", 1);
        
        static {
            MODES = new Mode[values().length];
            final char llllllllllllllIIllIIIllIIlIlllll;
            final int llllllllllllllIIllIIIllIIllIIIII = ((Mode[])(Object)(llllllllllllllIIllIIIllIIlIlllll = (char)(Object)values())).length;
            for (float llllllllllllllIIllIIIllIIllIIIIl = 0; llllllllllllllIIllIIIllIIllIIIIl < llllllllllllllIIllIIIllIIllIIIII; ++llllllllllllllIIllIIIllIIllIIIIl) {
                final Mode llllllllllllllIIllIIIllIIllIIIll = llllllllllllllIIllIIIllIIlIlllll[llllllllllllllIIllIIIllIIllIIIIl];
                Mode.MODES[llllllllllllllIIllIIIllIIllIIIll.getModeId()] = llllllllllllllIIllIIIllIIllIIIll;
            }
        }
        
        public int getModeId() {
            return this.modeId;
        }
        
        public static Mode getById(final int llllllllllllllIIllIIIllIIlIIlIIl) {
            return (llllllllllllllIIllIIIllIIlIIlIIl >= 0 && llllllllllllllIIllIIIllIIlIIlIIl < Mode.MODES.length) ? Mode.MODES[llllllllllllllIIllIIIllIIlIIlIIl] : Mode.MODES[0];
        }
        
        @Override
        public String getName() {
            return this.modeName;
        }
        
        private Mode(final String llllllllllllllIIllIIIllIIlIlIlIl, final int llllllllllllllIIllIIIllIIlIlIlII, final String llllllllllllllIIllIIIllIIlIlIIll, final int llllllllllllllIIllIIIllIIlIlIIlI) {
            this.modeName = llllllllllllllIIllIIIllIIlIlIIll;
            this.modeId = llllllllllllllIIllIIIllIIlIlIIlI;
        }
    }
}

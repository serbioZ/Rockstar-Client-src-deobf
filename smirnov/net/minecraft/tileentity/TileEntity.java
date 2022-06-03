// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.BlockJukebox;
import org.apache.logging.log4j.LogManager;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

public abstract class TileEntity
{
    private static final /* synthetic */ RegistryNamespaced<ResourceLocation, Class<? extends TileEntity>> field_190562_f;
    protected /* synthetic */ Block blockType;
    private /* synthetic */ int blockMetadata;
    protected /* synthetic */ World world;
    private static final /* synthetic */ Logger LOGGER;
    protected /* synthetic */ BlockPos pos;
    protected /* synthetic */ boolean tileEntityInvalid;
    
    public void setPos(final BlockPos lllllllllllIIlllIIlIIlIIIlIllIII) {
        this.pos = lllllllllllIIlllIIlIIlIIIlIllIII.toImmutable();
    }
    
    @Nullable
    public ITextComponent getDisplayName() {
        return null;
    }
    
    public void updateContainingBlockInfo() {
        this.blockType = null;
        this.blockMetadata = -1;
    }
    
    public void setWorldObj(final World lllllllllllIIlllIIlIIlIIllIIlIII) {
        this.world = lllllllllllIIlllIIlIIlIIllIIlIII;
    }
    
    public void invalidate() {
        this.tileEntityInvalid = true;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        field_190562_f = new RegistryNamespaced<ResourceLocation, Class<? extends TileEntity>>();
        func_190560_a("furnace", TileEntityFurnace.class);
        func_190560_a("chest", TileEntityChest.class);
        func_190560_a("ender_chest", TileEntityEnderChest.class);
        func_190560_a("jukebox", BlockJukebox.TileEntityJukebox.class);
        func_190560_a("dispenser", TileEntityDispenser.class);
        func_190560_a("dropper", TileEntityDropper.class);
        func_190560_a("sign", TileEntitySign.class);
        func_190560_a("mob_spawner", TileEntityMobSpawner.class);
        func_190560_a("noteblock", TileEntityNote.class);
        func_190560_a("piston", TileEntityPiston.class);
        func_190560_a("brewing_stand", TileEntityBrewingStand.class);
        func_190560_a("enchanting_table", TileEntityEnchantmentTable.class);
        func_190560_a("end_portal", TileEntityEndPortal.class);
        func_190560_a("beacon", TileEntityBeacon.class);
        func_190560_a("skull", TileEntitySkull.class);
        func_190560_a("daylight_detector", TileEntityDaylightDetector.class);
        func_190560_a("hopper", TileEntityHopper.class);
        func_190560_a("comparator", TileEntityComparator.class);
        func_190560_a("flower_pot", TileEntityFlowerPot.class);
        func_190560_a("banner", TileEntityBanner.class);
        func_190560_a("structure_block", TileEntityStructure.class);
        func_190560_a("end_gateway", TileEntityEndGateway.class);
        func_190560_a("command_block", TileEntityCommandBlock.class);
        func_190560_a("shulker_box", TileEntityShulkerBox.class);
        func_190560_a("bed", TileEntityBed.class);
    }
    
    public boolean hasWorldObj() {
        return this.world != null;
    }
    
    public NBTTagCompound getUpdateTag() {
        return this.writeInternal(new NBTTagCompound());
    }
    
    public World getWorld() {
        return this.world;
    }
    
    public boolean onlyOpsCanSetNbt() {
        return false;
    }
    
    public void addInfoToCrashReport(final CrashReportCategory lllllllllllIIlllIIlIIlIIIlIllllI) {
        lllllllllllIIlllIIlIIlIIIlIllllI.setDetail("Name", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return TileEntity.field_190562_f.getNameForObject(TileEntity.this.getClass()) + " // " + TileEntity.this.getClass().getCanonicalName();
            }
        });
        if (this.world != null) {
            CrashReportCategory.addBlockInfo(lllllllllllIIlllIIlIIlIIIlIllllI, this.pos, this.getBlockType(), this.getBlockMetadata());
            lllllllllllIIlllIIlIIlIIIlIllllI.setDetail("Actual block type", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    final int llllllllllllIIlIIIIlIlIlIIIlIlll = Block.getIdFromBlock(TileEntity.this.world.getBlockState(TileEntity.this.pos).getBlock());
                    try {
                        return String.format("ID #%d (%s // %s)", llllllllllllIIlIIIIlIlIlIIIlIlll, Block.getBlockById(llllllllllllIIlIIIIlIlIlIIIlIlll).getUnlocalizedName(), Block.getBlockById(llllllllllllIIlIIIIlIlIlIIIlIlll).getClass().getCanonicalName());
                    }
                    catch (Throwable llllllllllllIIlIIIIlIlIlIIIlIllI) {
                        return "ID #" + llllllllllllIIlIIIIlIlIlIIIlIlll;
                    }
                }
            });
            lllllllllllIIlllIIlIIlIIIlIllllI.setDetail("Actual block data value", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    final IBlockState llllllllllIlllIllIlIIIIllIIIIlII = TileEntity.this.world.getBlockState(TileEntity.this.pos);
                    final int llllllllllIlllIllIlIIIIllIIIIIll = llllllllllIlllIllIlIIIIllIIIIlII.getBlock().getMetaFromState(llllllllllIlllIllIlIIIIllIIIIlII);
                    if (llllllllllIlllIllIlIIIIllIIIIIll < 0) {
                        return "Unknown? (Got " + llllllllllIlllIllIlIIIIllIIIIIll + ")";
                    }
                    final String llllllllllIlllIllIlIIIIllIIIIIlI = String.format("%4s", Integer.toBinaryString(llllllllllIlllIllIlIIIIllIIIIIll)).replace(" ", "0");
                    return String.format("%1$d / 0x%1$X / 0b%2$s", llllllllllIlllIllIlIIIIllIIIIIll, llllllllllIlllIllIlIIIIllIIIIIlI);
                }
            });
        }
    }
    
    private static void func_190560_a(final String lllllllllllIIlllIIlIIlIIllIlIlll, final Class<? extends TileEntity> lllllllllllIIlllIIlIIlIIllIlIlII) {
        TileEntity.field_190562_f.putObject(new ResourceLocation(lllllllllllIIlllIIlIIlIIllIlIlll), lllllllllllIIlllIIlIIlIIllIlIlII);
    }
    
    private NBTTagCompound writeInternal(final NBTTagCompound lllllllllllIIlllIIlIIlIIlIllIlII) {
        final ResourceLocation lllllllllllIIlllIIlIIlIIlIllIIll = TileEntity.field_190562_f.getNameForObject(this.getClass());
        if (lllllllllllIIlllIIlIIlIIlIllIIll == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        }
        lllllllllllIIlllIIlIIlIIlIllIlII.setString("id", lllllllllllIIlllIIlIIlIIlIllIIll.toString());
        lllllllllllIIlllIIlIIlIIlIllIlII.setInteger("x", this.pos.getX());
        lllllllllllIIlllIIlIIlIIlIllIlII.setInteger("y", this.pos.getY());
        lllllllllllIIlllIIlIIlIIlIllIlII.setInteger("z", this.pos.getZ());
        return lllllllllllIIlllIIlIIlIIlIllIlII;
    }
    
    public void mirror(final Mirror lllllllllllIIlllIIlIIlIIIlIlIIII) {
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllIIlllIIlIIlIIllIIIIIl) {
        this.pos = new BlockPos(lllllllllllIIlllIIlIIlIIllIIIIIl.getInteger("x"), lllllllllllIIlllIIlIIlIIllIIIIIl.getInteger("y"), lllllllllllIIlllIIlIIlIIllIIIIIl.getInteger("z"));
    }
    
    public boolean isInvalid() {
        return this.tileEntityInvalid;
    }
    
    public double getMaxRenderDistanceSquared() {
        return 4096.0;
    }
    
    protected void setWorldCreate(final World lllllllllllIIlllIIlIIlIIlIIlllIl) {
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIIlllIIlIIlIIlIlllIIl) {
        return this.writeInternal(lllllllllllIIlllIIlIIlIIlIlllIIl);
    }
    
    public int getBlockMetadata() {
        if (this.blockMetadata == -1) {
            final IBlockState lllllllllllIIlllIIlIIlIIlIIllIIl = this.world.getBlockState(this.pos);
            this.blockMetadata = lllllllllllIIlllIIlIIlIIlIIllIIl.getBlock().getMetaFromState(lllllllllllIIlllIIlIIlIIlIIllIIl);
        }
        return this.blockMetadata;
    }
    
    @Nullable
    public static TileEntity create(final World lllllllllllIIlllIIlIIlIIlIlIlIlI, final NBTTagCompound lllllllllllIIlllIIlIIlIIlIlIIIlI) {
        TileEntity lllllllllllIIlllIIlIIlIIlIlIlIII = null;
        final String lllllllllllIIlllIIlIIlIIlIlIIlll = lllllllllllIIlllIIlIIlIIlIlIIIlI.getString("id");
        try {
            final Class<? extends TileEntity> lllllllllllIIlllIIlIIlIIlIlIIllI = TileEntity.field_190562_f.getObject(new ResourceLocation(lllllllllllIIlllIIlIIlIIlIlIIlll));
            if (lllllllllllIIlllIIlIIlIIlIlIIllI != null) {
                lllllllllllIIlllIIlIIlIIlIlIlIII = (TileEntity)lllllllllllIIlllIIlIIlIIlIlIIllI.newInstance();
            }
        }
        catch (Throwable lllllllllllIIlllIIlIIlIIlIlIIlIl) {
            TileEntity.LOGGER.error("Failed to create block entity {}", (Object)lllllllllllIIlllIIlIIlIIlIlIIlll, (Object)lllllllllllIIlllIIlIIlIIlIlIIlIl);
        }
        if (lllllllllllIIlllIIlIIlIIlIlIlIII != null) {
            try {
                lllllllllllIIlllIIlIIlIIlIlIlIII.setWorldCreate(lllllllllllIIlllIIlIIlIIlIlIlIlI);
                lllllllllllIIlllIIlIIlIIlIlIlIII.readFromNBT(lllllllllllIIlllIIlIIlIIlIlIIIlI);
            }
            catch (Throwable lllllllllllIIlllIIlIIlIIlIlIIlII) {
                TileEntity.LOGGER.error("Failed to load data for block entity {}", (Object)lllllllllllIIlllIIlIIlIIlIlIIlll, (Object)lllllllllllIIlllIIlIIlIIlIlIIlII);
                lllllllllllIIlllIIlIIlIIlIlIlIII = null;
            }
        }
        else {
            TileEntity.LOGGER.warn("Skipping BlockEntity with id {}", (Object)lllllllllllIIlllIIlIIlIIlIlIIlll);
        }
        return lllllllllllIIlllIIlIIlIIlIlIlIII;
    }
    
    public double getDistanceSq(final double lllllllllllIIlllIIlIIlIIlIIIlIII, final double lllllllllllIIlllIIlIIlIIlIIIIIII, final double lllllllllllIIlllIIlIIlIIlIIIIllI) {
        final double lllllllllllIIlllIIlIIlIIlIIIIlIl = this.pos.getX() + 0.5 - lllllllllllIIlllIIlIIlIIlIIIlIII;
        final double lllllllllllIIlllIIlIIlIIlIIIIlII = this.pos.getY() + 0.5 - lllllllllllIIlllIIlIIlIIlIIIIIII;
        final double lllllllllllIIlllIIlIIlIIlIIIIIll = this.pos.getZ() + 0.5 - lllllllllllIIlllIIlIIlIIlIIIIllI;
        return lllllllllllIIlllIIlIIlIIlIIIIlIl * lllllllllllIIlllIIlIIlIIlIIIIlIl + lllllllllllIIlllIIlIIlIIlIIIIlII * lllllllllllIIlllIIlIIlIIlIIIIlII + lllllllllllIIlllIIlIIlIIlIIIIIll * lllllllllllIIlllIIlIIlIIlIIIIIll;
    }
    
    @Nullable
    public static ResourceLocation func_190559_a(final Class<? extends TileEntity> lllllllllllIIlllIIlIIlIIllIlIIIl) {
        return TileEntity.field_190562_f.getNameForObject(lllllllllllIIlllIIlIIlIIllIlIIIl);
    }
    
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return null;
    }
    
    public Block getBlockType() {
        if (this.blockType == null && this.world != null) {
            this.blockType = this.world.getBlockState(this.pos).getBlock();
        }
        return this.blockType;
    }
    
    public TileEntity() {
        this.pos = BlockPos.ORIGIN;
        this.blockMetadata = -1;
    }
    
    public void validate() {
        this.tileEntityInvalid = false;
    }
    
    public boolean receiveClientEvent(final int lllllllllllIIlllIIlIIlIIIllIIllI, final int lllllllllllIIlllIIlIIlIIIllIIlIl) {
        return false;
    }
    
    public void rotate(final Rotation lllllllllllIIlllIIlIIlIIIlIlIIlI) {
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public void markDirty() {
        if (this.world != null) {
            final IBlockState lllllllllllIIlllIIlIIlIIlIIlIIll = this.world.getBlockState(this.pos);
            this.blockMetadata = lllllllllllIIlllIIlIIlIIlIIlIIll.getBlock().getMetaFromState(lllllllllllIIlllIIlIIlIIlIIlIIll);
            this.world.markChunkDirty(this.pos, this);
            if (this.getBlockType() != Blocks.AIR) {
                this.world.updateComparatorOutputLevel(this.pos, this.getBlockType());
            }
        }
    }
}

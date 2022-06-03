// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import net.minecraft.init.Items;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.potion.PotionEffect;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Arrays;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumFacing;
import java.util.Collection;
import java.util.Collections;
import com.google.common.collect.Sets;
import net.minecraft.init.MobEffects;
import java.util.Set;
import net.minecraft.item.ItemStack;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.potion.Potion;
import net.minecraft.util.ITickable;
import net.minecraft.inventory.ISidedInventory;

public class TileEntityBeacon extends TileEntityLockable implements ISidedInventory, ITickable
{
    @Nullable
    private /* synthetic */ Potion secondaryEffect;
    private /* synthetic */ float beamRenderScale;
    private /* synthetic */ long beamRenderCounter;
    public static final /* synthetic */ Potion[][] EFFECTS_LIST;
    private final /* synthetic */ List<BeamSegment> beamSegments;
    private /* synthetic */ boolean isComplete;
    private /* synthetic */ ItemStack payment;
    private /* synthetic */ String customName;
    private /* synthetic */ int levels;
    @Nullable
    private /* synthetic */ Potion primaryEffect;
    private static final /* synthetic */ Set<Potion> VALID_EFFECTS;
    
    @Override
    public int getFieldCount() {
        return 3;
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllIIIIIIlIlIIlIlllIIllI) {
        return (lllllllllllIIIIIIlIlIIlIlllIIllI == 0) ? this.payment : ItemStack.field_190927_a;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.beacon";
    }
    
    public void updateBeacon() {
        if (this.world != null) {
            this.updateSegmentColors();
            this.addEffectsToPlayers();
        }
    }
    
    static {
        EFFECTS_LIST = new Potion[][] { { MobEffects.SPEED, MobEffects.HASTE }, { MobEffects.RESISTANCE, MobEffects.JUMP_BOOST }, { MobEffects.STRENGTH }, { MobEffects.REGENERATION } };
        VALID_EFFECTS = Sets.newHashSet();
        final float lllllllllllIIIIIIlIlIIllIlllIIIl;
        final short lllllllllllIIIIIIlIlIIllIlllIIlI = (short)((Potion[][])(Object)(lllllllllllIIIIIIlIlIIllIlllIIIl = (float)(Object)TileEntityBeacon.EFFECTS_LIST)).length;
        for (Exception lllllllllllIIIIIIlIlIIllIlllIIll = (Exception)0; lllllllllllIIIIIIlIlIIllIlllIIll < lllllllllllIIIIIIlIlIIllIlllIIlI; ++lllllllllllIIIIIIlIlIIllIlllIIll) {
            final Potion[] lllllllllllIIIIIIlIlIIllIlllIlIl = lllllllllllIIIIIIlIlIIllIlllIIIl[lllllllllllIIIIIIlIlIIllIlllIIll];
            Collections.addAll(TileEntityBeacon.VALID_EFFECTS, lllllllllllIIIIIIlIlIIllIlllIlIl);
        }
    }
    
    @Override
    public boolean canInsertItem(final int lllllllllllIIIIIIlIlIIlIlIIIIlII, final ItemStack lllllllllllIIIIIIlIlIIlIlIIIIIll, final EnumFacing lllllllllllIIIIIIlIlIIlIlIIIIIlI) {
        return false;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllIIIIIIlIlIIlIlIlIIlII, final EntityPlayer lllllllllllIIIIIIlIlIIlIlIlIIllI) {
        return new ContainerBeacon(lllllllllllIIIIIIlIlIIlIlIlIIlII, this);
    }
    
    public int func_191979_s() {
        return this.levels;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIIIIIIlIlIIlIllllIllI) {
        super.readFromNBT(lllllllllllIIIIIIlIlIIlIllllIllI);
        this.primaryEffect = isBeaconEffect(lllllllllllIIIIIIlIlIIlIllllIllI.getInteger("Primary"));
        this.secondaryEffect = isBeaconEffect(lllllllllllIIIIIIlIlIIlIllllIllI.getInteger("Secondary"));
        this.levels = lllllllllllIIIIIIlIlIIlIllllIllI.getInteger("Levels");
    }
    
    @Nullable
    private static Potion isBeaconEffect(final int lllllllllllIIIIIIlIlIIlIllllllIl) {
        final Potion lllllllllllIIIIIIlIlIIlIlllllllI = Potion.getPotionById(lllllllllllIIIIIIlIlIIlIllllllIl);
        return TileEntityBeacon.VALID_EFFECTS.contains(lllllllllllIIIIIIlIlIIlIlllllllI) ? lllllllllllIIIIIIlIlIIlIlllllllI : null;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllIIIIIIlIlIIlIlIllIIll) {
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllIIIIIIlIlIIlIllIIlIIl, final ItemStack lllllllllllIIIIIIlIlIIlIllIIlIII) {
        if (lllllllllllIIIIIIlIlIIlIllIIlIIl == 0) {
            this.payment = lllllllllllIIIIIIlIlIIlIllIIlIII;
        }
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIIIIIIlIlIIlIllllIIII) {
        super.writeToNBT(lllllllllllIIIIIIlIlIIlIllllIIII);
        lllllllllllIIIIIIlIlIIlIllllIIII.setInteger("Primary", Potion.getIdFromPotion(this.primaryEffect));
        lllllllllllIIIIIIlIlIIlIllllIIII.setInteger("Secondary", Potion.getIdFromPotion(this.secondaryEffect));
        lllllllllllIIIIIIlIlIIlIllllIIII.setInteger("Levels", this.levels);
        return lllllllllllIIIIIIlIlIIlIllllIIII;
    }
    
    @Override
    public void clear() {
        this.payment = ItemStack.field_190927_a;
    }
    
    private void updateSegmentColors() {
        final int lllllllllllIIIIIIlIlIIllIIllIlII = this.pos.getX();
        final int lllllllllllIIIIIIlIlIIllIIllIIll = this.pos.getY();
        final int lllllllllllIIIIIIlIlIIllIIllIIlI = this.pos.getZ();
        final int lllllllllllIIIIIIlIlIIllIIllIIIl = this.levels;
        this.levels = 0;
        this.beamSegments.clear();
        this.isComplete = true;
        BeamSegment lllllllllllIIIIIIlIlIIllIIllIIII = new BeamSegment(EnumDyeColor.WHITE.func_193349_f());
        this.beamSegments.add(lllllllllllIIIIIIlIlIIllIIllIIII);
        boolean lllllllllllIIIIIIlIlIIllIIlIllll = true;
        final BlockPos.MutableBlockPos lllllllllllIIIIIIlIlIIllIIlIlllI = new BlockPos.MutableBlockPos();
        for (int lllllllllllIIIIIIlIlIIllIIlIllIl = lllllllllllIIIIIIlIlIIllIIllIIll + 1; lllllllllllIIIIIIlIlIIllIIlIllIl < 256; ++lllllllllllIIIIIIlIlIIllIIlIllIl) {
            final IBlockState lllllllllllIIIIIIlIlIIllIIlIllII = this.world.getBlockState(lllllllllllIIIIIIlIlIIllIIlIlllI.setPos(lllllllllllIIIIIIlIlIIllIIllIlII, lllllllllllIIIIIIlIlIIllIIlIllIl, lllllllllllIIIIIIlIlIIllIIllIIlI));
            float[] lllllllllllIIIIIIlIlIIllIIlIlIlI = null;
            if (lllllllllllIIIIIIlIlIIllIIlIllII.getBlock() == Blocks.STAINED_GLASS) {
                final float[] lllllllllllIIIIIIlIlIIllIIlIlIll = lllllllllllIIIIIIlIlIIllIIlIllII.getValue(BlockStainedGlass.COLOR).func_193349_f();
            }
            else if (lllllllllllIIIIIIlIlIIllIIlIllII.getBlock() != Blocks.STAINED_GLASS_PANE) {
                if (lllllllllllIIIIIIlIlIIllIIlIllII.getLightOpacity() >= 15 && lllllllllllIIIIIIlIlIIllIIlIllII.getBlock() != Blocks.BEDROCK) {
                    this.isComplete = false;
                    this.beamSegments.clear();
                    break;
                }
                lllllllllllIIIIIIlIlIIllIIllIIII.incrementHeight();
                continue;
            }
            else {
                lllllllllllIIIIIIlIlIIllIIlIlIlI = lllllllllllIIIIIIlIlIIllIIlIllII.getValue(BlockStainedGlassPane.COLOR).func_193349_f();
            }
            if (!lllllllllllIIIIIIlIlIIllIIlIllll) {
                lllllllllllIIIIIIlIlIIllIIlIlIlI = new float[] { (lllllllllllIIIIIIlIlIIllIIllIIII.getColors()[0] + lllllllllllIIIIIIlIlIIllIIlIlIlI[0]) / 2.0f, (lllllllllllIIIIIIlIlIIllIIllIIII.getColors()[1] + lllllllllllIIIIIIlIlIIllIIlIlIlI[1]) / 2.0f, (lllllllllllIIIIIIlIlIIllIIllIIII.getColors()[2] + lllllllllllIIIIIIlIlIIllIIlIlIlI[2]) / 2.0f };
            }
            if (Arrays.equals(lllllllllllIIIIIIlIlIIllIIlIlIlI, lllllllllllIIIIIIlIlIIllIIllIIII.getColors())) {
                lllllllllllIIIIIIlIlIIllIIllIIII.incrementHeight();
            }
            else {
                lllllllllllIIIIIIlIlIIllIIllIIII = new BeamSegment(lllllllllllIIIIIIlIlIIllIIlIlIlI);
                this.beamSegments.add(lllllllllllIIIIIIlIlIIllIIllIIII);
            }
            lllllllllllIIIIIIlIlIIllIIlIllll = false;
        }
        if (this.isComplete) {
            for (int lllllllllllIIIIIIlIlIIllIIlIlIIl = 1; lllllllllllIIIIIIlIlIIllIIlIlIIl <= 4; this.levels = lllllllllllIIIIIIlIlIIllIIlIlIIl++) {
                final int lllllllllllIIIIIIlIlIIllIIlIlIII = lllllllllllIIIIIIlIlIIllIIllIIll - lllllllllllIIIIIIlIlIIllIIlIlIIl;
                if (lllllllllllIIIIIIlIlIIllIIlIlIII < 0) {
                    break;
                }
                boolean lllllllllllIIIIIIlIlIIllIIlIIlll = true;
                for (int lllllllllllIIIIIIlIlIIllIIlIIllI = lllllllllllIIIIIIlIlIIllIIllIlII - lllllllllllIIIIIIlIlIIllIIlIlIIl; lllllllllllIIIIIIlIlIIllIIlIIllI <= lllllllllllIIIIIIlIlIIllIIllIlII + lllllllllllIIIIIIlIlIIllIIlIlIIl && lllllllllllIIIIIIlIlIIllIIlIIlll; ++lllllllllllIIIIIIlIlIIllIIlIIllI) {
                    for (int lllllllllllIIIIIIlIlIIllIIlIIlIl = lllllllllllIIIIIIlIlIIllIIllIIlI - lllllllllllIIIIIIlIlIIllIIlIlIIl; lllllllllllIIIIIIlIlIIllIIlIIlIl <= lllllllllllIIIIIIlIlIIllIIllIIlI + lllllllllllIIIIIIlIlIIllIIlIlIIl; ++lllllllllllIIIIIIlIlIIllIIlIIlIl) {
                        final Block lllllllllllIIIIIIlIlIIllIIlIIlII = this.world.getBlockState(new BlockPos(lllllllllllIIIIIIlIlIIllIIlIIllI, lllllllllllIIIIIIlIlIIllIIlIlIII, lllllllllllIIIIIIlIlIIllIIlIIlIl)).getBlock();
                        if (lllllllllllIIIIIIlIlIIllIIlIIlII != Blocks.EMERALD_BLOCK && lllllllllllIIIIIIlIlIIllIIlIIlII != Blocks.GOLD_BLOCK && lllllllllllIIIIIIlIlIIllIIlIIlII != Blocks.DIAMOND_BLOCK && lllllllllllIIIIIIlIlIIllIIlIIlII != Blocks.IRON_BLOCK) {
                            lllllllllllIIIIIIlIlIIllIIlIIlll = false;
                            break;
                        }
                    }
                }
                if (!lllllllllllIIIIIIlIlIIllIIlIIlll) {
                    break;
                }
            }
            if (this.levels == 0) {
                this.isComplete = false;
            }
        }
        if (!this.world.isRemote && lllllllllllIIIIIIlIlIIllIIllIIIl < this.levels) {
            for (final EntityPlayerMP lllllllllllIIIIIIlIlIIllIIlIIIll : this.world.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, new AxisAlignedBB(lllllllllllIIIIIIlIlIIllIIllIlII, lllllllllllIIIIIIlIlIIllIIllIIll, lllllllllllIIIIIIlIlIIllIIllIIlI, lllllllllllIIIIIIlIlIIllIIllIlII, lllllllllllIIIIIIlIlIIllIIllIIll - 4, lllllllllllIIIIIIlIlIIllIIllIIlI).expand(10.0, 5.0, 10.0))) {
                CriteriaTriggers.field_192131_k.func_192180_a(lllllllllllIIIIIIlIlIIllIIlIIIll, this);
            }
        }
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing lllllllllllIIIIIIlIlIIlIlIIIIllI) {
        return new int[0];
    }
    
    @Override
    public int getField(final int lllllllllllIIIIIIlIlIIlIlIIllllI) {
        switch (lllllllllllIIIIIIlIlIIlIlIIllllI) {
            case 0: {
                return this.levels;
            }
            case 1: {
                return Potion.getIdFromPotion(this.primaryEffect);
            }
            case 2: {
                return Potion.getIdFromPotion(this.secondaryEffect);
            }
            default: {
                return 0;
            }
        }
    }
    
    @Override
    public void setField(final int lllllllllllIIIIIIlIlIIlIlIIlIllI, final int lllllllllllIIIIIIlIlIIlIlIIlIlIl) {
        switch (lllllllllllIIIIIIlIlIIlIlIIlIllI) {
            case 0: {
                this.levels = lllllllllllIIIIIIlIlIIlIlIIlIlIl;
                break;
            }
            case 1: {
                this.primaryEffect = isBeaconEffect(lllllllllllIIIIIIlIlIIlIlIIlIlIl);
                break;
            }
            case 2: {
                this.secondaryEffect = isBeaconEffect(lllllllllllIIIIIIlIlIIlIlIIlIlIl);
                break;
            }
        }
    }
    
    public float shouldBeamRender() {
        if (!this.isComplete) {
            return 0.0f;
        }
        final int lllllllllllIIIIIIlIlIIllIIIIlllI = (int)(this.world.getTotalWorldTime() - this.beamRenderCounter);
        this.beamRenderCounter = this.world.getTotalWorldTime();
        if (lllllllllllIIIIIIlIlIIllIIIIlllI > 1) {
            this.beamRenderScale -= lllllllllllIIIIIIlIlIIllIIIIlllI / 40.0f;
            if (this.beamRenderScale < 0.0f) {
                this.beamRenderScale = 0.0f;
            }
        }
        this.beamRenderScale += 0.025f;
        if (this.beamRenderScale > 1.0f) {
            this.beamRenderScale = 1.0f;
        }
        return this.beamRenderScale;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllIIIIIIlIlIIlIllIlllII, final int lllllllllllIIIIIIlIlIIlIllIlllll) {
        if (lllllllllllIIIIIIlIlIIlIllIlllII != 0 || this.payment.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        if (lllllllllllIIIIIIlIlIIlIllIlllll >= this.payment.func_190916_E()) {
            final ItemStack lllllllllllIIIIIIlIlIIlIllIllllI = this.payment;
            this.payment = ItemStack.field_190927_a;
            return lllllllllllIIIIIIlIlIIlIllIllllI;
        }
        return this.payment.splitStack(lllllllllllIIIIIIlIlIIlIllIlllll);
    }
    
    public int getLevels() {
        return this.levels;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllIIIIIIlIlIIlIlIllIIIl) {
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllIIIIIIlIlIIlIllIlIIlI) {
        if (lllllllllllIIIIIIlIlIIlIllIlIIlI == 0) {
            final ItemStack lllllllllllIIIIIIlIlIIlIllIlIlII = this.payment;
            this.payment = ItemStack.field_190927_a;
            return lllllllllllIIIIIIlIlIIlIllIlIlII;
        }
        return ItemStack.field_190927_a;
    }
    
    private void addEffectsToPlayers() {
        if (this.isComplete && this.levels > 0 && !this.world.isRemote && this.primaryEffect != null) {
            final double lllllllllllIIIIIIlIlIIllIlIllIll = this.levels * 10 + 10;
            int lllllllllllIIIIIIlIlIIllIlIllIlI = 0;
            if (this.levels >= 4 && this.primaryEffect == this.secondaryEffect) {
                lllllllllllIIIIIIlIlIIllIlIllIlI = 1;
            }
            final int lllllllllllIIIIIIlIlIIllIlIllIIl = (9 + this.levels * 2) * 20;
            final int lllllllllllIIIIIIlIlIIllIlIllIII = this.pos.getX();
            final int lllllllllllIIIIIIlIlIIllIlIlIlll = this.pos.getY();
            final int lllllllllllIIIIIIlIlIIllIlIlIllI = this.pos.getZ();
            final AxisAlignedBB lllllllllllIIIIIIlIlIIllIlIlIlIl = new AxisAlignedBB(lllllllllllIIIIIIlIlIIllIlIllIII, lllllllllllIIIIIIlIlIIllIlIlIlll, lllllllllllIIIIIIlIlIIllIlIlIllI, lllllllllllIIIIIIlIlIIllIlIllIII + 1, lllllllllllIIIIIIlIlIIllIlIlIlll + 1, lllllllllllIIIIIIlIlIIllIlIlIllI + 1).expandXyz(lllllllllllIIIIIIlIlIIllIlIllIll).addCoord(0.0, this.world.getHeight(), 0.0);
            final List<EntityPlayer> lllllllllllIIIIIIlIlIIllIlIlIlII = this.world.getEntitiesWithinAABB((Class<? extends EntityPlayer>)EntityPlayer.class, lllllllllllIIIIIIlIlIIllIlIlIlIl);
            for (final EntityPlayer lllllllllllIIIIIIlIlIIllIlIlIIll : lllllllllllIIIIIIlIlIIllIlIlIlII) {
                lllllllllllIIIIIIlIlIIllIlIlIIll.addPotionEffect(new PotionEffect(this.primaryEffect, lllllllllllIIIIIIlIlIIllIlIllIIl, lllllllllllIIIIIIlIlIIllIlIllIlI, true, true));
            }
            if (this.levels >= 4 && this.primaryEffect != this.secondaryEffect && this.secondaryEffect != null) {
                for (final EntityPlayer lllllllllllIIIIIIlIlIIllIlIlIIlI : lllllllllllIIIIIIlIlIIllIlIlIlII) {
                    lllllllllllIIIIIIlIlIIllIlIlIIlI.addPotionEffect(new PotionEffect(this.secondaryEffect, lllllllllllIIIIIIlIlIIllIlIllIIl, 0, true, true));
                }
            }
        }
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 1;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllIIIIIIlIlIIlIlIllIlll) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllIIIIIIlIlIIlIlIllIlll.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllIIIIIIlIlIIlIlIIIlIIl, final int lllllllllllIIIIIIlIlIIlIlIIIlIll) {
        if (lllllllllllIIIIIIlIlIIlIlIIIlIIl == 1) {
            this.updateBeacon();
            return true;
        }
        return super.receiveClientEvent(lllllllllllIIIIIIlIlIIlIlIIIlIIl, lllllllllllIIIIIIlIlIIlIlIIIlIll);
    }
    
    @Override
    public boolean func_191420_l() {
        return this.payment.func_190926_b();
    }
    
    public void setName(final String lllllllllllIIIIIIlIlIIlIlIllllII) {
        this.customName = lllllllllllIIIIIIlIlIIlIlIllllII;
    }
    
    public List<BeamSegment> getBeamSegments() {
        return this.beamSegments;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }
    
    @Override
    public void update() {
        if (this.world.getTotalWorldTime() % 80L == 0L) {
            this.updateBeacon();
        }
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:beacon";
    }
    
    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllIIIIIIlIlIIlIlIlIlllI, final ItemStack lllllllllllIIIIIIlIlIIlIlIlIllIl) {
        return lllllllllllIIIIIIlIlIIlIlIlIllIl.getItem() == Items.EMERALD || lllllllllllIIIIIIlIlIIlIlIlIllIl.getItem() == Items.DIAMOND || lllllllllllIIIIIIlIlIIlIlIlIllIl.getItem() == Items.GOLD_INGOT || lllllllllllIIIIIIlIlIIlIlIlIllIl.getItem() == Items.IRON_INGOT;
    }
    
    @Override
    public boolean canExtractItem(final int lllllllllllIIIIIIlIlIIlIlIIIIIII, final ItemStack lllllllllllIIIIIIlIlIIlIIlllllll, final EnumFacing lllllllllllIIIIIIlIlIIlIIllllllI) {
        return false;
    }
    
    public TileEntityBeacon() {
        this.beamSegments = (List<BeamSegment>)Lists.newArrayList();
        this.levels = -1;
        this.payment = ItemStack.field_190927_a;
    }
    
    public static class BeamSegment
    {
        private final /* synthetic */ float[] colors;
        private /* synthetic */ int height;
        
        protected void incrementHeight() {
            ++this.height;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public BeamSegment(final float[] llllllllllllIIlIllllIllIlIlIlIIl) {
            this.colors = llllllllllllIIlIllllIllIlIlIlIIl;
            this.height = 1;
        }
        
        public float[] getColors() {
            return this.colors;
        }
    }
}

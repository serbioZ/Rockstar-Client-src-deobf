// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemHoe;
import java.util.Comparator;
import java.util.function.Predicate;
import ru.rockstar.api.utils.world.BlockHelper;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import ru.rockstar.api.utils.combat.RotationHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.block.BlockCrops;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockFarmland;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.combat.EntityHelper;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.block.Block;
import net.minecraft.network.play.server.SPacketBlockChange;
import ru.rockstar.api.event.event.EventReceivePacket;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSeeds;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import ru.rockstar.client.features.Feature;

public class AutoFarm extends Feature
{
    /* synthetic */ ArrayList<BlockPos> crops;
    private final /* synthetic */ BooleanSetting autoHoe;
    /* synthetic */ TimerHelper timerHelper2;
    /* synthetic */ TimerHelper timerHelper;
    private final /* synthetic */ NumberSetting delay;
    private final /* synthetic */ NumberSetting radius;
    /* synthetic */ ArrayList<BlockPos> check;
    private final /* synthetic */ BooleanSetting autoFarm;
    
    public static int searchSeeds() {
        for (int lIllIIlIllIllIl = 0; lIllIIlIllIllIl < 45; ++lIllIIlIllIllIl) {
            final ItemStack lIllIIlIllIllII = AutoFarm.mc.player.inventoryContainer.getSlot(lIllIIlIllIllIl).getStack();
            if (lIllIIlIllIllII.getItem() instanceof ItemSeeds) {
                return lIllIIlIllIllIl;
            }
        }
        return -1;
    }
    
    @EventTarget
    public void onReceivePacket(final EventReceivePacket lIllIIlIIIllIIl) {
        if (this.autoFarm.getBoolValue()) {
            if (lIllIIlIIIllIIl.getPacket() instanceof SPacketBlockChange) {
                final SPacketBlockChange lIllIIlIIIlllIl = (SPacketBlockChange)lIllIIlIIIllIIl.getPacket();
                if (this.isEnabled(Block.getIdFromBlock(lIllIIlIIIlllIl.getBlockState().getBlock()))) {
                    this.crops.add(lIllIIlIIIlllIl.getBlockPosition());
                }
            }
            else if (lIllIIlIIIllIIl.getPacket() instanceof SPacketMultiBlockChange) {
                final SPacketMultiBlockChange lIllIIlIIIlllII = (SPacketMultiBlockChange)lIllIIlIIIllIIl.getPacket();
                final float lIllIIlIIIlIlII;
                final short lIllIIlIIIlIlIl = (short)((SPacketMultiBlockChange.BlockUpdateData[])(Object)(lIllIIlIIIlIlII = (float)(Object)lIllIIlIIIlllII.getChangedBlocks())).length;
                for (boolean lIllIIlIIIlIllI = false; (lIllIIlIIIlIllI ? 1 : 0) < lIllIIlIIIlIlIl; ++lIllIIlIIIlIllI) {
                    final SPacketMultiBlockChange.BlockUpdateData lIllIIlIIIllIll = lIllIIlIIIlIlII[lIllIIlIIIlIllI];
                    if (this.isEnabled(Block.getIdFromBlock(lIllIIlIIIllIll.getBlockState().getBlock()))) {
                        this.crops.add(lIllIIlIIIllIll.getPos());
                    }
                }
            }
        }
    }
    
    private boolean isCheck(final int lIllIIlIIIlIIII) {
        int lIllIIlIIIIllll = 0;
        if (lIllIIlIIIlIIII != 0) {
            lIllIIlIIIIllll = 59;
        }
        return lIllIIlIIIlIIII != 0 && lIllIIlIIIlIIII == lIllIIlIIIIllll;
    }
    
    public AutoFarm() {
        super("Auto Farm", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0441\u0430\u0434\u0438\u0442 \u0438 \u043b\u043e\u043c\u0430\u0435\u0442 \u0443\u0440\u043e\u0436\u0430\u0439", 0, Category.PLAYER);
        this.crops = new ArrayList<BlockPos>();
        this.check = new ArrayList<BlockPos>();
        this.timerHelper = new TimerHelper();
        this.timerHelper2 = new TimerHelper();
        this.autoFarm = new BooleanSetting("Auto Farm", true, () -> true);
        this.autoHoe = new BooleanSetting("Auto Hoe", false, () -> true);
        this.delay = new NumberSetting("Farm Delay", 2.0f, 0.0f, 10.0f, 0.1f, () -> true);
        this.radius = new NumberSetting("Farm Radius", 4.0f, 1.0f, 7.0f, 0.1f, () -> true);
        this.addSettings(this.autoFarm, this.autoHoe, this.delay, this.radius);
    }
    
    private boolean isOnCrops() {
        for (double lIllIIlIlIlllll = AutoFarm.mc.player.boundingBox.minX; lIllIIlIlIlllll < AutoFarm.mc.player.boundingBox.maxX; lIllIIlIlIlllll += 0.009999999776482582) {
            for (double lIllIIlIlIllllI = AutoFarm.mc.player.boundingBox.minZ; lIllIIlIlIllllI < AutoFarm.mc.player.boundingBox.maxZ; lIllIIlIlIllllI += 0.009999999776482582) {
                final Block lIllIIlIlIlllIl = AutoFarm.mc.world.getBlockState(new BlockPos(lIllIIlIlIlllll, AutoFarm.mc.player.posY - 0.1, lIllIIlIlIllllI)).getBlock();
                if (!(lIllIIlIlIlllIl instanceof BlockFarmland) && !(lIllIIlIlIlllIl instanceof BlockCarrot) && !(lIllIIlIlIlllIl instanceof BlockSoulSand) && !(lIllIIlIlIlllIl instanceof BlockSand) && !(lIllIIlIlIlllIl instanceof BlockAir)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean IsValidBlockPos(final BlockPos lIllIIlIlIlIlII) {
        final IBlockState lIllIIlIlIlIlIl = AutoFarm.mc.world.getBlockState(lIllIIlIlIlIlII);
        return (lIllIIlIlIlIlIl.getBlock() instanceof BlockFarmland || lIllIIlIlIlIlIl.getBlock() instanceof BlockSand || lIllIIlIlIlIlIl.getBlock() instanceof BlockSoulSand) && AutoFarm.mc.world.getBlockState(lIllIIlIlIlIlII.up()).getBlock() == Blocks.AIR;
    }
    
    @EventTarget
    public void onPre(final EventPreMotionUpdate lIllIIlIIlIllll) {
        if (this.autoFarm.getBoolValue()) {
            final ArrayList<BlockPos> lIllIIlIIlllIlI = this.getBlocks(this.radius.getNumberValue(), this.radius.getNumberValue(), this.radius.getNumberValue());
            for (final BlockPos lIllIIlIIlllIIl : lIllIIlIIlllIlI) {
                final IBlockState lIllIIlIIlllIII = AutoFarm.mc.world.getBlockState(lIllIIlIIlllIIl);
                if (this.isCheck(Block.getIdFromBlock(lIllIIlIIlllIII.getBlock()))) {
                    if (!this.isCheck(0)) {
                        this.check.add(lIllIIlIIlllIIl);
                    }
                    final Block lIllIIlIIllIlll = AutoFarm.mc.world.getBlockState(lIllIIlIIlllIIl).getBlock();
                    final BlockPos lIllIIlIIllIllI = lIllIIlIIlllIIl.down(1);
                    if (!(lIllIIlIIllIlll instanceof BlockCrops) && !(lIllIIlIIllIlll instanceof BlockCarrot)) {
                        continue;
                    }
                    final BlockCrops lIllIIlIIllIlIl = (BlockCrops)lIllIIlIIllIlll;
                    if (lIllIIlIIllIlIl.canGrow(AutoFarm.mc.world, lIllIIlIIlllIIl, lIllIIlIIlllIII, true) || !this.timerHelper.hasReached(this.delay.getNumberValue() * 100.0f) || lIllIIlIIlllIIl == null) {
                        continue;
                    }
                    final float[] lIllIIlIIllIlII = RotationHelper.getRotationVector(new Vec3d(lIllIIlIIlllIIl.getX() + 0.5f, lIllIIlIIlllIIl.getY() + 0.5f, lIllIIlIIlllIIl.getZ() + 0.5f), true, 2.0f, 2.0f, 360.0f);
                    lIllIIlIIlIllll.setYaw(lIllIIlIIllIlII[0]);
                    lIllIIlIIlIllll.setPitch(lIllIIlIIllIlII[1]);
                    AutoFarm.mc.player.renderYawOffset = lIllIIlIIllIlII[0];
                    AutoFarm.mc.player.rotationYawHead = lIllIIlIIllIlII[0];
                    AutoFarm.mc.player.rotationPitchHead = lIllIIlIIllIlII[1];
                    AutoFarm.mc.playerController.onPlayerDamageBlock(lIllIIlIIlllIIl, AutoFarm.mc.player.getHorizontalFacing());
                    AutoFarm.mc.player.swingArm(EnumHand.MAIN_HAND);
                    if (doesHaveSeeds()) {
                        AutoFarm.mc.player.connection.sendPacket(new CPacketHeldItemChange(getSlotWithSeeds()));
                        AutoFarm.mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(lIllIIlIIllIllI, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                        AutoFarm.mc.player.swingArm(EnumHand.MAIN_HAND);
                    }
                    this.timerHelper.reset();
                }
            }
        }
        final BlockPos lIllIIlIIllIIll = BlockHelper.getSphere(BlockHelper.getPlayerPos(), this.radius.getNumberValue(), 6, false, true).stream().filter(this::IsValidBlockPos).min(Comparator.comparing(lIllIIIllllIIIl -> EntityHelper.getDistanceOfEntityToBlock(AutoFarm.mc.player, lIllIIIllllIIIl))).orElse(null);
        final Vec3d lIllIIlIIllIIlI = new Vec3d(0.0, 0.0, 0.0);
        if (this.timerHelper.hasReached(this.delay.getNumberValue() * 100.0f) && this.isOnCrops() && lIllIIlIIllIIll != null && doesHaveSeeds()) {
            final float[] lIllIIlIIllIIIl = RotationHelper.getRotationVector(new Vec3d(lIllIIlIIllIIll.getX() + 0.5f, lIllIIlIIllIIll.getY() + 0.5f, lIllIIlIIllIIll.getZ() + 0.5f), true, 2.0f, 2.0f, 360.0f);
            lIllIIlIIlIllll.setYaw(lIllIIlIIllIIIl[0]);
            lIllIIlIIlIllll.setPitch(lIllIIlIIllIIIl[1]);
            AutoFarm.mc.player.renderYawOffset = lIllIIlIIllIIIl[0];
            AutoFarm.mc.player.rotationYawHead = lIllIIlIIllIIIl[0];
            AutoFarm.mc.player.rotationPitchHead = lIllIIlIIllIIIl[1];
            AutoFarm.mc.player.connection.sendPacket(new CPacketHeldItemChange(getSlotWithSeeds()));
            AutoFarm.mc.playerController.processRightClickBlock(AutoFarm.mc.player, AutoFarm.mc.world, lIllIIlIIllIIll, EnumFacing.VALUES[0].getOpposite(), lIllIIlIIllIIlI, EnumHand.MAIN_HAND);
            this.timerHelper.reset();
        }
    }
    
    private ArrayList<BlockPos> getBlocks(final float lIllIIIlllllIlI, final float lIllIIIlllllIIl, final float lIllIIIlllllIII) {
        final BlockPos lIllIIIllllllII = new BlockPos(AutoFarm.mc.player.posX - lIllIIIlllllIlI, AutoFarm.mc.player.posY - lIllIIIlllllIIl, AutoFarm.mc.player.posZ - lIllIIIlllllIII);
        final BlockPos lIllIIIlllllIll = new BlockPos(AutoFarm.mc.player.posX + lIllIIIlllllIlI, AutoFarm.mc.player.posY + lIllIIIlllllIIl, AutoFarm.mc.player.posZ + lIllIIIlllllIII);
        return BlockHelper.getAllInBox(lIllIIIllllllII, lIllIIIlllllIll);
    }
    
    private boolean isEnabled(final int lIllIIlIIIIlIIl) {
        int lIllIIlIIIIlIII = 0;
        if (lIllIIlIIIIlIIl != 0) {
            lIllIIlIIIIlIII = 59;
        }
        return lIllIIlIIIIlIIl != 0 && lIllIIlIIIIlIIl == lIllIIlIIIIlIII;
    }
    
    @Override
    public void onEnable() {
        this.crops.clear();
        this.check.clear();
        super.onEnable();
    }
    
    public static int getSlotWithSeeds() {
        for (int lIllIIlIllIlIII = 0; lIllIIlIllIlIII < 9; ++lIllIIlIllIlIII) {
            AutoFarm.mc.player.inventory.getStackInSlot(lIllIIlIllIlIII);
            if (AutoFarm.mc.player.inventory.getStackInSlot(lIllIIlIllIlIII).getItem() instanceof ItemSeeds) {
                return lIllIIlIllIlIII;
            }
        }
        return 0;
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lIllIIlIlIIlIIl) {
        if (AutoFarm.mc.player == null && AutoFarm.mc.world == null) {
            return;
        }
        final BlockPos lIllIIlIlIIllII = BlockHelper.getSphere(BlockHelper.getPlayerPos(), this.radius.getNumberValue(), 6, false, true).stream().filter(BlockHelper::IsValidBlockPos).min(Comparator.comparing(lIllIIIllllIlII -> EntityHelper.getDistanceOfEntityToBlock(AutoFarm.mc.player, lIllIIIllllIlII))).orElse(null);
        if (lIllIIlIlIIllII != null && AutoFarm.mc.player.getHeldItemMainhand().getItem() instanceof ItemHoe) {
            final float[] lIllIIlIlIIlIll = RotationHelper.getRotationVector(new Vec3d(lIllIIlIlIIllII.getX() + 0.5f, lIllIIlIlIIllII.getY() + 0.5f, lIllIIlIlIIllII.getZ() + 0.5f), true, 2.0f, 2.0f, 360.0f);
            lIllIIlIlIIlIIl.setYaw(lIllIIlIlIIlIll[0]);
            lIllIIlIlIIlIIl.setPitch(lIllIIlIlIIlIll[1]);
            AutoFarm.mc.player.renderYawOffset = lIllIIlIlIIlIll[0];
            AutoFarm.mc.player.rotationYawHead = lIllIIlIlIIlIll[0];
            AutoFarm.mc.player.rotationPitchHead = lIllIIlIlIIlIll[1];
            if (this.timerHelper2.hasReached(this.delay.getNumberValue() * 100.0f)) {
                AutoFarm.mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(lIllIIlIlIIllII, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                AutoFarm.mc.player.swingArm(EnumHand.MAIN_HAND);
                this.timerHelper2.reset();
            }
        }
        if (!doesHaveSeeds() && searchSeeds() != -1) {
            AutoFarm.mc.playerController.windowClick(0, searchSeeds(), 1, ClickType.QUICK_MOVE, AutoFarm.mc.player);
        }
    }
    
    public static boolean doesHaveSeeds() {
        for (int lIllIIlIlllIIIl = 0; lIllIIlIlllIIIl < 9; ++lIllIIlIlllIIIl) {
            AutoFarm.mc.player.inventory.getStackInSlot(lIllIIlIlllIIIl);
            if (AutoFarm.mc.player.inventory.getStackInSlot(lIllIIlIlllIIIl).getItem() instanceof ItemSeeds) {
                return true;
            }
        }
        return false;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import ru.rockstar.api.utils.combat.RotationHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.item.EntityEnderCrystal;
import ru.rockstar.api.utils.world.InventoryHelper;
import java.util.Comparator;
import java.util.function.Predicate;
import ru.rockstar.api.utils.world.BlockHelper;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.item.ItemBlock;
import net.minecraft.entity.Entity;
import ru.rockstar.api.utils.combat.EntityHelper;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import net.minecraft.util.math.BlockPos;
import java.util.ArrayList;
import ru.rockstar.client.features.Feature;

public class AntiCrystal extends Feature
{
    private final /* synthetic */ ArrayList<BlockPos> invalidPositions;
    private final /* synthetic */ BooleanSetting obsidianCheck;
    private final /* synthetic */ BooleanSetting bedrockCheck;
    private final /* synthetic */ NumberSetting rangeToBlock;
    private final /* synthetic */ BooleanSetting throughWalls;
    private final /* synthetic */ NumberSetting delay;
    private final /* synthetic */ TimerHelper timerHelper;
    
    public AntiCrystal() {
        super("AntiCrystal", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0441\u0442\u0430\u0432\u0438\u0442 \u0431\u043b\u043e\u043a \u043d\u0430 \u043e\u0431\u0441\u0438\u0434\u0438\u0430\u043d/\u0431\u0435\u0434\u0440\u043e\u043a", 0, Category.COMBAT);
        this.timerHelper = new TimerHelper();
        this.invalidPositions = new ArrayList<BlockPos>();
        this.throughWalls = new BooleanSetting("Walls", true, () -> true);
        this.obsidianCheck = new BooleanSetting("Obsidian Check", true, () -> true);
        this.bedrockCheck = new BooleanSetting("Bedrock Check", false, () -> true);
        this.rangeToBlock = new NumberSetting("Range", 5.0f, 3.0f, 6.0f, 0.1f, () -> true);
        this.delay = new NumberSetting("Delay", 0.0f, 0.0f, 2000.0f, 100.0f, () -> true);
        this.addSettings(this.obsidianCheck, this.bedrockCheck, this.throughWalls, this.rangeToBlock, this.delay);
    }
    
    public static int getSlotWithBlock() {
        for (int llllllllllllIIIlIlIllIIlllIllllI = 0; llllllllllllIIIlIlIllIIlllIllllI < 9; ++llllllllllllIIIlIlIllIIlllIllllI) {
            AntiCrystal.mc.player.inventory.getStackInSlot(llllllllllllIIIlIlIllIIlllIllllI);
            if (AntiCrystal.mc.player.inventory.getStackInSlot(llllllllllllIIIlIlIllIIlllIllllI).getItem() instanceof ItemBlock) {
                return llllllllllllIIIlIlIllIIlllIllllI;
            }
        }
        return -1;
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate llllllllllllIIIlIlIllIIlllIIIllI) {
        this.setSuffix(new StringBuilder().append((int)this.rangeToBlock.getNumberValue()).toString(), true);
        final int llllllllllllIIIlIlIllIIlllIIlIll = AntiCrystal.mc.player.inventory.currentItem;
        final BlockPos llllllllllllIIIlIlIllIIlllIIlIlI = BlockHelper.getSphere(BlockHelper.getPlayerPos(), this.rangeToBlock.getNumberValue(), 6, false, true).stream().filter(this::IsValidBlockPos).min(Comparator.comparing(llllllllllllIIIlIlIllIIlllIIIIII -> EntityHelper.getDistanceOfEntityToBlock(AntiCrystal.mc.player, llllllllllllIIIlIlIllIIlllIIIIII))).orElse(null);
        if (InventoryHelper.doesHotbarHaveBlock() && llllllllllllIIIlIlIllIIlllIIlIlI != null && this.timerHelper.hasReached(this.delay.getNumberValue()) && getSlotWithBlock() != -1) {
            if (!AntiCrystal.mc.world.isAirBlock(llllllllllllIIIlIlIllIIlllIIlIlI.up(1))) {
                this.invalidPositions.add(llllllllllllIIIlIlIllIIlllIIlIlI);
            }
            for (final Entity llllllllllllIIIlIlIllIIlllIIlIIl : AntiCrystal.mc.world.loadedEntityList) {
                if (llllllllllllIIIlIlIllIIlllIIlIIl instanceof EntityEnderCrystal && llllllllllllIIIlIlIllIIlllIIlIIl.getPosition().getX() == llllllllllllIIIlIlIllIIlllIIlIlI.getX() && llllllllllllIIIlIlIllIIlllIIlIIl.getPosition().getZ() == llllllllllllIIIlIlIllIIlllIIlIlI.getZ()) {
                    return;
                }
            }
            if (!this.invalidPositions.contains(llllllllllllIIIlIlIllIIlllIIlIlI)) {
                if (AntiCrystal.mc.world.rayTraceBlocks(new Vec3d(AntiCrystal.mc.player.posX, AntiCrystal.mc.player.posY + AntiCrystal.mc.player.getEyeHeight(), AntiCrystal.mc.player.posZ), new Vec3d(llllllllllllIIIlIlIllIIlllIIlIlI.getX(), llllllllllllIIIlIlIllIIlllIIlIlI.getY(), llllllllllllIIIlIlIllIIlllIIlIlI.getZ()), false, true, false) != null && !this.throughWalls.getBoolValue()) {
                    return;
                }
                final float[] llllllllllllIIIlIlIllIIlllIIlIII = RotationHelper.getRotationVector(new Vec3d(llllllllllllIIIlIlIllIIlllIIlIlI.getX() + 0.5, llllllllllllIIIlIlIllIIlllIIlIlI.getY() + 1.4, llllllllllllIIIlIlIllIIlllIIlIlI.getZ() + 0.5), true, 2.0f, 2.0f, 360.0f);
                llllllllllllIIIlIlIllIIlllIIIllI.setYaw(llllllllllllIIIlIlIllIIlllIIlIII[0]);
                llllllllllllIIIlIlIllIIlllIIIllI.setPitch(llllllllllllIIIlIlIllIIlllIIlIII[1]);
                AntiCrystal.mc.player.renderYawOffset = llllllllllllIIIlIlIllIIlllIIlIII[0];
                AntiCrystal.mc.player.rotationYawHead = llllllllllllIIIlIlIllIIlllIIlIII[0];
                AntiCrystal.mc.player.rotationPitchHead = llllllllllllIIIlIlIllIIlllIIlIII[1];
                AntiCrystal.mc.player.inventory.currentItem = getSlotWithBlock();
                AntiCrystal.mc.playerController.processRightClickBlock(AntiCrystal.mc.player, AntiCrystal.mc.world, llllllllllllIIIlIlIllIIlllIIlIlI, EnumFacing.UP, new Vec3d(llllllllllllIIIlIlIllIIlllIIlIlI.getX(), llllllllllllIIIlIlIllIIlllIIlIlI.getY(), llllllllllllIIIlIlIllIIlllIIlIlI.getZ()), EnumHand.MAIN_HAND);
                AntiCrystal.mc.player.swingArm(EnumHand.MAIN_HAND);
                AntiCrystal.mc.player.inventory.currentItem = llllllllllllIIIlIlIllIIlllIIlIll;
                this.timerHelper.reset();
            }
        }
    }
    
    private boolean IsValidBlockPos(final BlockPos llllllllllllIIIlIlIllIIlllIllIII) {
        final IBlockState llllllllllllIIIlIlIllIIlllIlIlll = AntiCrystal.mc.world.getBlockState(llllllllllllIIIlIlIllIIlllIllIII);
        return ((llllllllllllIIIlIlIllIIlllIlIlll.getBlock() instanceof BlockObsidian && this.obsidianCheck.getBoolValue()) || (llllllllllllIIIlIlIllIIlllIlIlll.getBlock() == Block.getBlockById(7) && this.bedrockCheck.getBoolValue())) && AntiCrystal.mc.world.getBlockState(llllllllllllIIIlIlIllIIlllIllIII.up()).getBlock() == Blocks.AIR;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.block.BlockAir;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.EnumFacing;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import java.util.Arrays;
import net.minecraft.init.Blocks;
import ru.rockstar.api.utils.combat.RotationHelper;
import ru.rockstar.api.event.event.EventStrafe;
import ru.rockstar.api.event.event.EventSafeWalk;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import net.minecraft.network.Packet;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketEntityAction;
import ru.rockstar.api.utils.math.MathematicHelper;
import ru.rockstar.api.utils.movement.MovementHelper;
import ru.rockstar.api.utils.world.InventoryHelper;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.event.event.EventRender2D;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import java.util.List;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class Scaffold extends Feature
{
    private /* synthetic */ int slot;
    private final /* synthetic */ NumberSetting delay;
    public /* synthetic */ ListSetting sneakMode;
    public static /* synthetic */ NumberSetting rotationSpeed;
    public /* synthetic */ NumberSetting rotPitchRandom;
    public /* synthetic */ NumberSetting placeOffset;
    private final /* synthetic */ BooleanSetting jump;
    public static /* synthetic */ BooleanSetting down;
    public /* synthetic */ NumberSetting sneakSpeed;
    public /* synthetic */ NumberSetting rotYawRandom;
    public static /* synthetic */ BooleanSetting sprintoff;
    public static /* synthetic */ BooleanSetting rotationRandom;
    private final /* synthetic */ NumberSetting speed;
    public static /* synthetic */ BlockData data;
    public /* synthetic */ NumberSetting sneakChance;
    public /* synthetic */ NumberSetting rotationOffset;
    private final /* synthetic */ TimerHelper time;
    private final /* synthetic */ BooleanSetting safewalk;
    public static /* synthetic */ boolean isSneaking;
    public /* synthetic */ BooleanSetting airCheck;
    public /* synthetic */ BooleanSetting sneak;
    private final /* synthetic */ ListSetting towerMode;
    private final /* synthetic */ NumberSetting delayRandom;
    private final /* synthetic */ ListSetting blockRotation;
    private final /* synthetic */ BooleanSetting swing;
    public static /* synthetic */ List<Block> invalidBlocks;
    private final /* synthetic */ BooleanSetting rotStrafe;
    private final /* synthetic */ NumberSetting chance;
    
    private boolean isValidItem(final Item lllllllllllIlIllIIllIIlIIlllIlIl) {
        if (lllllllllllIlIllIIllIIlIIlllIlIl instanceof ItemBlock) {
            final ItemBlock lllllllllllIlIllIIllIIlIIlllIlll = (ItemBlock)lllllllllllIlIllIIllIIlIIlllIlIl;
            final Block lllllllllllIlIllIIllIIlIIlllIllI = lllllllllllIlIllIIllIIlIIlllIlll.getBlock();
            return !Scaffold.invalidBlocks.contains(lllllllllllIlIllIIllIIlIIlllIllI);
        }
        return false;
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D lllllllllllIlIllIIllIIlIlIIIllll) {
        final float lllllllllllIlIllIIllIIlIlIIlIIll = (float)lllllllllllIlIllIIllIIlIlIIIllll.getResolution().getScaledWidth();
        final float lllllllllllIlIllIIllIIlIlIIlIIlI = (float)lllllllllllIlIllIIllIIlIlIIIllll.getResolution().getScaledHeight();
        final String lllllllllllIlIllIIllIIlIlIIlIIIl = String.valueOf(this.getBlockCount()) + " Blocks";
        GlStateManager.pushMatrix();
        GlStateManager.translate(23.0f, 15.0f, 0.0f);
        DrawHelper.drawRectWithGlow(lllllllllllIlIllIIllIIlIlIIlIIll / 2.0f + 88.0f - 200.0f - Scaffold.mc.neverlose500_17.getStringWidth(lllllllllllIlIllIIllIIlIlIIlIIIl), lllllllllllIlIllIIllIIlIlIIlIIlI / 2.0f - Scaffold.mc.neverlose500_17.getStringHeight(lllllllllllIlIllIIllIIlIlIIlIIIl) + 59.0f + 110.0f, lllllllllllIlIllIIllIIlIlIIlIIll / 2.0f + Scaffold.mc.neverlose500_18.getStringHeight(lllllllllllIlIllIIllIIlIlIIlIIIl) + 2.0f - 200.0f, lllllllllllIlIllIIllIIlIlIIlIIlI / 2.0f - Scaffold.mc.neverlose500_18.getStringHeight(lllllllllllIlIllIIllIIlIlIIlIIIl) / 2.0f - 55.0f + 190.0f, 5.0, 10.0, new Color(31, 31, 31, 255));
        Scaffold.mc.neverlose500_17.drawStringWithShadow(lllllllllllIlIllIIllIIlIlIIlIIIl, lllllllllllIlIllIIllIIlIlIIlIIll / 2.0f + 49.0f - 200.0f - Scaffold.mc.neverlose500_17.getStringWidth(lllllllllllIlIllIIllIIlIlIIlIIIl), lllllllllllIlIllIIllIIlIlIIlIIlI / 2.0f - 6.0f + 150.0f, -1);
        GlStateManager.popMatrix();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIlIllIIllIIlIlIlIlIII) {
        if (InventoryHelper.doesHotbarHaveBlock() && Scaffold.data != null) {
            int lllllllllllIlIllIIllIIlIlIlIIlll = -1;
            final int lllllllllllIlIllIIllIIlIlIlIIllI = Scaffold.mc.player.inventory.currentItem;
            final BlockPos lllllllllllIlIllIIllIIlIlIlIIlIl = Scaffold.data.pos;
            final Vec3d lllllllllllIlIllIIllIIlIlIlIIlII = this.getVectorToPlace(Scaffold.data);
            for (int lllllllllllIlIllIIllIIlIlIlIIIll = 0; lllllllllllIlIllIIllIIlIlIlIIIll < 9; ++lllllllllllIlIllIIllIIlIlIlIIIll) {
                final ItemStack lllllllllllIlIllIIllIIlIlIlIIIlI = Scaffold.mc.player.inventory.getStackInSlot(lllllllllllIlIllIIllIIlIlIlIIIll);
                if (this.isValidItem(lllllllllllIlIllIIllIIlIlIlIIIlI.getItem())) {
                    lllllllllllIlIllIIllIIlIlIlIIlll = lllllllllllIlIllIIllIIlIlIlIIIll;
                }
            }
            if (lllllllllllIlIllIIllIIlIlIlIIlll != -1) {
                if (this.jump.getBoolValue() && !Scaffold.mc.gameSettings.keyBindJump.isKeyDown() && Scaffold.mc.player.onGround) {
                    Scaffold.mc.player.jump();
                }
                if (!this.jump.getBoolValue() && InventoryHelper.doesHotbarHaveBlock() && MovementHelper.isMoving() && !Scaffold.mc.gameSettings.keyBindJump.isKeyDown() && this.sneak.getBoolValue() && MathematicHelper.randomizeFloat(0.0f, 100.0f) <= this.sneakChance.getNumberValue() && InventoryHelper.doesHotbarHaveBlock()) {
                    if (this.canSneak()) {
                        if (this.sneakMode.currentMode.equals("Packet")) {
                            Scaffold.mc.player.connection.sendPacket(new CPacketEntityAction(Scaffold.mc.player, CPacketEntityAction.Action.START_RIDING_JUMP));
                            Scaffold.mc.player.connection.sendPacket(new CPacketEntityAction(Scaffold.mc.player, CPacketEntityAction.Action.START_SNEAKING));
                        }
                        else if (this.sneakMode.currentMode.equals("Client")) {
                            Scaffold.mc.gameSettings.keyBindSneak.pressed = true;
                        }
                    }
                    else if (this.sneakMode.currentMode.equals("Packet")) {
                        Scaffold.mc.player.connection.sendPacket(new CPacketEntityAction(Scaffold.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
                    }
                    else if (this.sneakMode.currentMode.equals("Client")) {
                        Scaffold.mc.gameSettings.keyBindSneak.pressed = false;
                    }
                }
                if (this.time.hasReached(this.delay.getNumberValue() + MathematicHelper.randomizeFloat(0.0f, this.delayRandom.getNumberValue())) && this.canPlace()) {
                    if (MathematicHelper.randomizeFloat(0.0f, 100.0f) <= this.chance.getNumberValue()) {
                        Scaffold.mc.player.inventory.currentItem = lllllllllllIlIllIIllIIlIlIlIIlll;
                    }
                    Scaffold.mc.playerController.processRightClickBlock(Scaffold.mc.player, Scaffold.mc.world, lllllllllllIlIllIIllIIlIlIlIIlIl, Scaffold.data.face, lllllllllllIlIllIIllIIlIlIlIIlII, EnumHand.MAIN_HAND);
                    if (this.swing.getBoolValue()) {
                        Scaffold.mc.player.swingArm(EnumHand.MAIN_HAND);
                    }
                    else {
                        Scaffold.mc.player.connection.sendPacket(new CPacketAnimation(EnumHand.MAIN_HAND));
                    }
                    Scaffold.mc.player.inventory.currentItem = lllllllllllIlIllIIllIIlIlIlIIllI;
                    this.time.reset();
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        Scaffold.mc.player.inventory.currentItem = this.slot;
        Scaffold.mc.timer.timerSpeed = 1.0f;
        Scaffold.mc.player.connection.sendPacket(new CPacketEntityAction(Scaffold.mc.player, CPacketEntityAction.Action.STOP_SNEAKING));
        Scaffold.mc.gameSettings.keyBindSneak.pressed = false;
        super.onDisable();
    }
    
    @EventTarget
    public void onSafe(final EventSafeWalk lllllllllllIlIllIIllIIlIllIIlIll) {
        if (this.safewalk.getBoolValue() && !Scaffold.isSneaking) {
            lllllllllllIlIllIIllIIlIllIIlIll.setCancelled(Scaffold.mc.player.onGround);
        }
    }
    
    @EventTarget
    public void onStrafeMotion(final EventStrafe lllllllllllIlIllIIllIIlIllIlIIll) {
        if (this.rotStrafe.getBoolValue()) {
            lllllllllllIlIllIIllIIlIllIlIIll.setCancelled(true);
            MovementHelper.calculateSilentMove(lllllllllllIlIllIIllIIlIllIlIIll, RotationHelper.Rotation.packetYaw);
        }
    }
    
    static {
        Scaffold.invalidBlocks = Arrays.asList(Blocks.ENCHANTING_TABLE, Blocks.FURNACE, Blocks.CARPET, Blocks.CRAFTING_TABLE, Blocks.TRAPPED_CHEST, Blocks.CHEST, Blocks.DISPENSER, Blocks.AIR, Blocks.WATER, Blocks.LAVA, Blocks.FLOWING_WATER, Blocks.FLOWING_LAVA, Blocks.SAND, Blocks.SNOW_LAYER, Blocks.TORCH, Blocks.ANVIL, Blocks.JUKEBOX, Blocks.STONE_BUTTON, Blocks.WOODEN_BUTTON, Blocks.LEVER, Blocks.NOTEBLOCK, Blocks.STONE_PRESSURE_PLATE, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.WOODEN_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Blocks.STONE_SLAB, Blocks.WOODEN_SLAB, Blocks.STONE_SLAB2, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM, Blocks.YELLOW_FLOWER, Blocks.RED_FLOWER, Blocks.ANVIL, Blocks.GLASS_PANE, Blocks.STAINED_GLASS_PANE, Blocks.IRON_BARS, Blocks.CACTUS, Blocks.LADDER, Blocks.WEB, Blocks.PUMPKIN);
        Scaffold.rotationRandom = new BooleanSetting("Rotation Random", true, () -> true);
        Scaffold.rotationSpeed = new NumberSetting("Rotation Speed", 360.0f, 1.0f, 360.0f, 1.0f, () -> true);
    }
    
    public Scaffold() {
        super("Scaffold", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0441\u0442\u0430\u0432\u0438\u0442 \u043f\u043e\u0434 \u0432\u0430\u0441 \u0431\u043b\u043e\u043a\u0438", 0, Category.MOVEMENT);
        this.time = new TimerHelper();
        this.rotPitchRandom = new NumberSetting("Rotation Pitch Random", 2.0f, 0.0f, 8.0f, 0.01f, () -> Scaffold.rotationRandom.getBoolValue());
        this.rotYawRandom = new NumberSetting("Rotation Yaw Random", 2.0f, 0.0f, 8.0f, 0.01f, () -> Scaffold.rotationRandom.getBoolValue());
        this.airCheck = new BooleanSetting("Check Air", true, () -> true);
        this.sneak = new BooleanSetting("Sneak", true, () -> true);
        this.sneakChance = new NumberSetting("Sneak Chance", 100.0f, 0.0f, 100.0f, 1.0f, () -> this.sneak.getBoolValue());
        this.sneakSpeed = new NumberSetting("Sneak Speed", 0.05f, 0.01f, 1.0f, 0.01f, () -> this.sneak.getBoolValue());
        this.sneakMode = new ListSetting("Sneak Mode", "Packet", () -> this.sneak.getBoolValue(), new String[] { "Packet", "Client" });
        this.rotationOffset = new NumberSetting("Rotation Offset", 0.25f, 0.0f, 1.0f, 0.01f, () -> true);
        this.placeOffset = new NumberSetting("Place Offset", 0.2f, 0.01f, 0.3f, 0.01f, () -> true);
        this.blockRotation = new ListSetting("BlockRotation Mode", "Matrix", () -> true, new String[] { "Matrix", "None" });
        this.towerMode = new ListSetting("Tower Mode", "Matrix", () -> true, new String[] { "Matrix", "NCP", "Default" });
        this.chance = new NumberSetting("Chance", 100.0f, 0.0f, 100.0f, 1.0f, () -> true);
        this.delay = new NumberSetting("Min Delay", 0.0f, 0.0f, 300.0f, 1.0f, () -> true);
        this.delayRandom = new NumberSetting("Random Delay", 0.0f, 0.0f, 1000.0f, 1.0f, () -> true);
        this.speed = new NumberSetting("Speed", 0.6f, 0.05f, 1.2f, 0.01f, () -> true);
        Scaffold.sprintoff = new BooleanSetting("Stop Sprinting", true, () -> true);
        this.safewalk = new BooleanSetting("SafeWalk", true, () -> true);
        this.jump = new BooleanSetting("Jump", false, () -> true);
        Scaffold.down = new BooleanSetting("DownWard", false, () -> true);
        this.swing = new BooleanSetting("SwingHand", false, () -> true);
        this.rotStrafe = new BooleanSetting("Rotation Strafe", false, () -> true);
        this.addSettings(this.blockRotation, this.towerMode, this.chance, this.delay, this.delayRandom, this.rotationOffset, this.placeOffset, Scaffold.rotationSpeed, Scaffold.rotationRandom, this.rotYawRandom, this.rotPitchRandom, this.speed, this.sneak, this.sneakMode, this.sneakChance, this.sneakSpeed, Scaffold.sprintoff, this.airCheck, this.safewalk, this.jump, Scaffold.down, this.swing, this.rotStrafe);
    }
    
    public BlockData getBlockData(BlockPos lllllllllllIlIllIIllIIlIIllIlIIl) {
        BlockData lllllllllllIlIllIIllIIlIIllIllII = null;
        int lllllllllllIlIllIIllIIlIIllIlIll = 0;
        while (lllllllllllIlIllIIllIIlIIllIllII == null) {
            if (lllllllllllIlIllIIllIIlIIllIlIll >= 2) {
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 0, 1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 0, 1), EnumFacing.NORTH, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 0, -1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 0, -1), EnumFacing.SOUTH, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, 0))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, 0), EnumFacing.WEST, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, 0))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, 0), EnumFacing.EAST, null);
                break;
            }
            if (Scaffold.mc.gameSettings.keyBindJump.isKeyDown() && this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, -1, 0))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, -1, 0), EnumFacing.UP, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 1, 0)) && Scaffold.isSneaking) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 1, 0), EnumFacing.DOWN, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 1, 1)) && Scaffold.isSneaking) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 1, 1), EnumFacing.DOWN, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 1, -1)) && Scaffold.isSneaking) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(0, 1, -1), EnumFacing.DOWN, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 1, 0)) && Scaffold.isSneaking) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 1, 0), EnumFacing.DOWN, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 1, 0)) && Scaffold.isSneaking) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 1, 0), EnumFacing.DOWN, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, 1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, 1), EnumFacing.NORTH, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, -1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, -1), EnumFacing.SOUTH, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, 1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, 1), EnumFacing.WEST, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, -1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, -1), EnumFacing.EAST, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, 1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, 1), EnumFacing.NORTH, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, -1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, -1), EnumFacing.SOUTH, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, -1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(1, 0, -1), EnumFacing.WEST, null);
                break;
            }
            if (this.isBlockPosAir(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, 1))) {
                lllllllllllIlIllIIllIIlIIllIllII = new BlockData(((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).add(-1, 0, 1), EnumFacing.EAST, null);
                break;
            }
            lllllllllllIlIllIIllIIlIIllIlIIl = ((BlockPos)lllllllllllIlIllIIllIIlIIllIlIIl).down();
            ++lllllllllllIlIllIIllIIlIIllIlIll;
        }
        return lllllllllllIlIllIIllIIlIIllIllII;
    }
    
    private boolean canSneak() {
        final BlockPos lllllllllllIlIllIIllIIlIlllIIlIl = new BlockPos(Scaffold.mc.player.posX - this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posY - this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posZ - this.sneakSpeed.getNumberValue());
        final BlockPos lllllllllllIlIllIIllIIlIlllIIlII = new BlockPos(Scaffold.mc.player.posX - this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posY - this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posZ + this.sneakSpeed.getNumberValue());
        final BlockPos lllllllllllIlIllIIllIIlIlllIIIll = new BlockPos(Scaffold.mc.player.posX + this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posY - this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posZ + this.sneakSpeed.getNumberValue());
        final BlockPos lllllllllllIlIllIIllIIlIlllIIIlI = new BlockPos(Scaffold.mc.player.posX + this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posY - this.sneakSpeed.getNumberValue(), Scaffold.mc.player.posZ - this.sneakSpeed.getNumberValue());
        return Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIlllIIlIl).getBlock() == Blocks.AIR && Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIlllIIlII).getBlock() == Blocks.AIR && Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIlllIIIll).getBlock() == Blocks.AIR && Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIlllIIIlI).getBlock() == Blocks.AIR;
    }
    
    @Override
    public void onEnable() {
        this.slot = Scaffold.mc.player.inventory.currentItem;
        Scaffold.data = null;
        super.onEnable();
    }
    
    public static int searchBlock() {
        for (int lllllllllllIlIllIIllIIlIlllllllI = 0; lllllllllllIlIllIIllIIlIlllllllI < 45; ++lllllllllllIlIllIIllIIlIlllllllI) {
            final ItemStack lllllllllllIlIllIIllIIlIllllllIl = Scaffold.mc.player.inventoryContainer.getSlot(lllllllllllIlIllIIllIIlIlllllllI).getStack();
            if (lllllllllllIlIllIIllIIlIllllllIl.getItem() instanceof ItemBlock) {
                return lllllllllllIlIllIIllIIlIlllllllI;
            }
        }
        return -1;
    }
    
    public Block getBlockByPos(final BlockPos lllllllllllIlIllIIllIIlIIIllIlII) {
        return Scaffold.mc.world.getBlockState(lllllllllllIlIllIIllIIlIIIllIlII).getBlock();
    }
    
    private boolean canPlace() {
        final BlockPos lllllllllllIlIllIIllIIlIllllIlII = new BlockPos(Scaffold.mc.player.posX - this.placeOffset.getNumberValue(), Scaffold.mc.player.posY - this.placeOffset.getNumberValue(), Scaffold.mc.player.posZ - this.placeOffset.getNumberValue());
        final BlockPos lllllllllllIlIllIIllIIlIllllIIll = new BlockPos(Scaffold.mc.player.posX - this.placeOffset.getNumberValue(), Scaffold.mc.player.posY - this.placeOffset.getNumberValue(), Scaffold.mc.player.posZ + this.placeOffset.getNumberValue());
        final BlockPos lllllllllllIlIllIIllIIlIllllIIlI = new BlockPos(Scaffold.mc.player.posX + this.placeOffset.getNumberValue(), Scaffold.mc.player.posY - this.placeOffset.getNumberValue(), Scaffold.mc.player.posZ + this.placeOffset.getNumberValue());
        final BlockPos lllllllllllIlIllIIllIIlIllllIIIl = new BlockPos(Scaffold.mc.player.posX + this.placeOffset.getNumberValue(), Scaffold.mc.player.posY - this.placeOffset.getNumberValue(), Scaffold.mc.player.posZ - this.placeOffset.getNumberValue());
        return Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIllllIlII).getBlock() == Blocks.AIR && Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIllllIIll).getBlock() == Blocks.AIR && Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIllllIIlI).getBlock() == Blocks.AIR && Scaffold.mc.player.world.getBlockState(lllllllllllIlIllIIllIIlIllllIIIl).getBlock() == Blocks.AIR;
    }
    
    public boolean isBlockPosAir(final BlockPos lllllllllllIlIllIIllIIlIIIlllIIl) {
        return this.getBlockByPos(lllllllllllIlIllIIllIIlIIIlllIIl) != Blocks.AIR && !(this.getBlockByPos(lllllllllllIlIllIIllIIlIIIlllIIl) instanceof BlockLiquid);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIlIllIIllIIlIllIIIIIl) {
        final String lllllllllllIlIllIIllIIlIllIIIIII = this.towerMode.getCurrentMode();
        this.setSuffix(this.blockRotation.getCurrentMode(), true);
        if (lllllllllllIlIllIIllIIlIllIIIIII.equalsIgnoreCase("Matrix")) {
            if (!MovementHelper.isMoving()) {
                if (Scaffold.mc.player.onGround && Scaffold.mc.gameSettings.keyBindJump.isKeyDown()) {
                    Scaffold.mc.player.jump();
                }
                if (Scaffold.mc.player.motionY > 0.0 && !Scaffold.mc.player.onGround) {
                    final EntityPlayerSP player = Scaffold.mc.player;
                    player.motionY -= 0.00994;
                }
                else {
                    final EntityPlayerSP player2 = Scaffold.mc.player;
                    player2.motionY -= 0.00995;
                }
            }
        }
        else if (lllllllllllIlIllIIllIIlIllIIIIII.equalsIgnoreCase("NCP") && !MovementHelper.isMoving()) {
            if (Scaffold.mc.player.onGround && Scaffold.mc.gameSettings.keyBindJump.isKeyDown()) {
                Scaffold.mc.player.jump();
            }
            final float lllllllllllIlIllIIllIIlIlIllllll = -2.0f;
            if (Scaffold.mc.player.motionY < 0.1 && !(Scaffold.mc.world.getBlockState(new BlockPos(Scaffold.mc.player.posX, Scaffold.mc.player.posY, Scaffold.mc.player.posZ).add(0.0, lllllllllllIlIllIIllIIlIlIllllll, 0.0)).getBlock() instanceof BlockAir)) {
                final EntityPlayerSP player3 = Scaffold.mc.player;
                player3.motionY -= 190.0;
            }
        }
        if (Scaffold.mc.gameSettings.keyBindSneak.pressed && Scaffold.down.getBoolValue()) {
            Scaffold.mc.gameSettings.keyBindSneak.pressed = false;
            Scaffold.isSneaking = true;
        }
        else {
            Scaffold.isSneaking = false;
        }
        if (Scaffold.mc.player.onGround) {
            final EntityPlayerSP player4 = Scaffold.mc.player;
            player4.motionX *= this.speed.getNumberValue() + 1.0f;
            final EntityPlayerSP player5 = Scaffold.mc.player;
            player5.motionZ *= this.speed.getNumberValue() + 1.0f;
        }
        if (!InventoryHelper.doesHotbarHaveBlock() && !(Scaffold.mc.player.getHeldItemOffhand().getItem() instanceof ItemBlock) && searchBlock() != -1) {
            Scaffold.mc.playerController.windowClick(0, searchBlock(), 1, ClickType.QUICK_MOVE, Scaffold.mc.player);
        }
        final BlockPos lllllllllllIlIllIIllIIlIlIllllII = Scaffold.isSneaking ? new BlockPos(Scaffold.mc.player).add(1, -1, 0).down() : new BlockPos(Scaffold.mc.player).add(0, -1, 0);
        for (double lllllllllllIlIllIIllIIlIlIllllIl = Scaffold.mc.player.posY - 1.0; lllllllllllIlIllIIllIIlIlIllllIl > 0.0; --lllllllllllIlIllIIllIIlIlIllllIl) {
            final BlockData lllllllllllIlIllIIllIIlIlIlllIll = this.getBlockData(lllllllllllIlIllIIllIIlIlIllllII);
            if (lllllllllllIlIllIIllIIlIlIlllIll != null) {
                final double lllllllllllIlIllIIllIIlIlIlllllI = Scaffold.mc.player.posY - lllllllllllIlIllIIllIIlIlIllllIl;
                if (lllllllllllIlIllIIllIIlIlIlllllI <= 7.0) {
                    Scaffold.data = lllllllllllIlIllIIllIIlIlIlllIll;
                }
            }
        }
        if (Scaffold.sprintoff.getBoolValue()) {
            Scaffold.mc.player.setSprinting(false);
        }
        if (Scaffold.data != null && this.slot != -1 && !Scaffold.mc.player.isInLiquid()) {
            final Vec3d lllllllllllIlIllIIllIIlIlIlllIlI = this.getVectorToRotate(Scaffold.data);
            if (this.blockRotation.getOptions().equalsIgnoreCase("Matrix")) {
                final float[] lllllllllllIlIllIIllIIlIlIlllIIl = RotationHelper.getRotationVector(lllllllllllIlIllIIllIIlIlIlllIlI, Scaffold.rotationRandom.getBoolValue(), this.rotYawRandom.getNumberValue(), this.rotPitchRandom.getNumberValue(), Scaffold.rotationSpeed.getNumberValue());
                lllllllllllIlIllIIllIIlIllIIIIIl.setYaw(lllllllllllIlIllIIllIIlIlIlllIIl[0]);
                lllllllllllIlIllIIllIIlIllIIIIIl.setPitch(lllllllllllIlIllIIllIIlIlIlllIIl[1]);
                if (Scaffold.mc.world.getBlockState(lllllllllllIlIllIIllIIlIlIllllII).getBlock() == Blocks.AIR && !this.airCheck.getBoolValue()) {
                    Scaffold.mc.player.renderYawOffset = lllllllllllIlIllIIllIIlIlIlllIIl[0];
                    Scaffold.mc.player.rotationYawHead = lllllllllllIlIllIIllIIlIlIlllIIl[0];
                    Scaffold.mc.player.rotationPitchHead = lllllllllllIlIllIIllIIlIlIlllIIl[1];
                }
                else {
                    Scaffold.mc.player.renderYawOffset = lllllllllllIlIllIIllIIlIlIlllIIl[0];
                    Scaffold.mc.player.rotationYawHead = lllllllllllIlIllIIllIIlIlIlllIIl[0];
                    Scaffold.mc.player.rotationPitchHead = lllllllllllIlIllIIllIIlIlIlllIIl[1];
                }
            }
        }
    }
    
    private Vec3d getVectorToRotate(final BlockData lllllllllllIlIllIIllIIlIIlIIIIlI) {
        final BlockPos lllllllllllIlIllIIllIIlIIlIIlIII = lllllllllllIlIllIIllIIlIIlIIIIlI.pos;
        final EnumFacing lllllllllllIlIllIIllIIlIIlIIIlll = lllllllllllIlIllIIllIIlIIlIIIIlI.face;
        double lllllllllllIlIllIIllIIlIIlIIIllI = lllllllllllIlIllIIllIIlIIlIIlIII.getX() + 0.5;
        double lllllllllllIlIllIIllIIlIIlIIIlIl = lllllllllllIlIllIIllIIlIIlIIlIII.getY() + 0.5;
        double lllllllllllIlIllIIllIIlIIlIIIlII = lllllllllllIlIllIIllIIlIIlIIlIII.getZ() + 0.5;
        if (lllllllllllIlIllIIllIIlIIlIIIlll == EnumFacing.UP || lllllllllllIlIllIIllIIlIIlIIIlll == EnumFacing.DOWN) {
            lllllllllllIlIllIIllIIlIIlIIIllI += 0.4;
            lllllllllllIlIllIIllIIlIIlIIIlII += 0.4;
        }
        else {
            lllllllllllIlIllIIllIIlIIlIIIlIl += 0.4;
        }
        if (lllllllllllIlIllIIllIIlIIlIIIlll == EnumFacing.WEST || lllllllllllIlIllIIllIIlIIlIIIlll == EnumFacing.EAST) {
            lllllllllllIlIllIIllIIlIIlIIIlII += this.rotationOffset.getNumberValue();
        }
        if (lllllllllllIlIllIIllIIlIIlIIIlll == EnumFacing.SOUTH || lllllllllllIlIllIIllIIlIIlIIIlll == EnumFacing.NORTH) {
            lllllllllllIlIllIIllIIlIIlIIIllI += this.rotationOffset.getNumberValue();
        }
        return new Vec3d(lllllllllllIlIllIIllIIlIIlIIIllI, lllllllllllIlIllIIllIIlIIlIIIlIl, lllllllllllIlIllIIllIIlIIlIIIlII);
    }
    
    private int getBlockCount() {
        int lllllllllllIlIllIIllIIlIlIIIIlIl = 0;
        for (int lllllllllllIlIllIIllIIlIlIIIIlII = 0; lllllllllllIlIllIIllIIlIlIIIIlII < 45; ++lllllllllllIlIllIIllIIlIlIIIIlII) {
            if (Scaffold.mc.player.inventoryContainer.getSlot(lllllllllllIlIllIIllIIlIlIIIIlII).getHasStack()) {
                final ItemStack lllllllllllIlIllIIllIIlIlIIIIIll = Scaffold.mc.player.inventoryContainer.getSlot(lllllllllllIlIllIIllIIlIlIIIIlII).getStack();
                final Item lllllllllllIlIllIIllIIlIlIIIIIlI = lllllllllllIlIllIIllIIlIlIIIIIll.getItem();
                if (this.isValidItem(lllllllllllIlIllIIllIIlIlIIIIIlI)) {
                    lllllllllllIlIllIIllIIlIlIIIIlIl += lllllllllllIlIllIIllIIlIlIIIIIll.stackSize;
                }
            }
        }
        return lllllllllllIlIllIIllIIlIlIIIIlIl;
    }
    
    private Vec3d getVectorToPlace(final BlockData lllllllllllIlIllIIllIIlIIlIlIlll) {
        final BlockPos lllllllllllIlIllIIllIIlIIlIlllIl = lllllllllllIlIllIIllIIlIIlIlIlll.pos;
        final EnumFacing lllllllllllIlIllIIllIIlIIlIlllII = lllllllllllIlIllIIllIIlIIlIlIlll.face;
        double lllllllllllIlIllIIllIIlIIlIllIll = lllllllllllIlIllIIllIIlIIlIlllIl.getX() + 0.5;
        double lllllllllllIlIllIIllIIlIIlIllIlI = lllllllllllIlIllIIllIIlIIlIlllIl.getY() + 0.5;
        double lllllllllllIlIllIIllIIlIIlIllIIl = lllllllllllIlIllIIllIIlIIlIlllIl.getZ() + 0.5;
        if (lllllllllllIlIllIIllIIlIIlIlllII == EnumFacing.UP || lllllllllllIlIllIIllIIlIIlIlllII == EnumFacing.DOWN) {
            lllllllllllIlIllIIllIIlIIlIllIll += 0.3;
            lllllllllllIlIllIIllIIlIIlIllIIl += 0.3;
        }
        else {
            lllllllllllIlIllIIllIIlIIlIllIlI += 0.5;
        }
        if (lllllllllllIlIllIIllIIlIIlIlllII == EnumFacing.WEST || lllllllllllIlIllIIllIIlIIlIlllII == EnumFacing.EAST) {
            lllllllllllIlIllIIllIIlIIlIllIIl += this.placeOffset.getNumberValue();
        }
        if (lllllllllllIlIllIIllIIlIIlIlllII == EnumFacing.SOUTH || lllllllllllIlIllIIllIIlIIlIlllII == EnumFacing.NORTH) {
            lllllllllllIlIllIIllIIlIIlIllIll += this.placeOffset.getNumberValue();
        }
        return new Vec3d(lllllllllllIlIllIIllIIlIIlIllIll, lllllllllllIlIllIIllIIlIIlIllIlI, lllllllllllIlIllIIllIIlIIlIllIIl);
    }
    
    private static class BlockData
    {
        public /* synthetic */ EnumFacing face;
        public /* synthetic */ BlockPos pos;
        
        private BlockData(final BlockPos llllllllllllIllIlllllIIllllIllIl, final EnumFacing llllllllllllIllIlllllIIllllIllll) {
            this.pos = llllllllllllIllIlllllIIllllIllIl;
            this.face = llllllllllllIllIlllllIIllllIllll;
        }
    }
}

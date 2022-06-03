// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.movement;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.client.entity.EntityPlayerSP;
import ru.rockstar.api.event.event.EventLiquidSolid;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import ru.rockstar.api.utils.movement.MovementHelper;
import net.minecraft.init.MobEffects;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class Jesus extends Feature
{
    private final /* synthetic */ BooleanSetting autoMotionStop;
    private final /* synthetic */ BooleanSetting autoWaterDown;
    private final /* synthetic */ BooleanSetting speedCheck;
    public static /* synthetic */ BooleanSetting useTimer;
    public static /* synthetic */ NumberSetting speed;
    private final /* synthetic */ NumberSetting timerSpeed;
    public static /* synthetic */ ListSetting mode;
    public static /* synthetic */ NumberSetting motionUp;
    public static /* synthetic */ NumberSetting NCPSpeed;
    private /* synthetic */ int waterTicks;
    
    static {
        Jesus.mode = new ListSetting("Jesus Mode", "Matrix", () -> true, new String[] { "Matrix", "ReallyWorld", "Matrix Zoom", "NCP" });
        Jesus.speed = new NumberSetting("Speed", 0.65f, 0.1f, 10.0f, 0.01f, () -> !Jesus.mode.currentMode.equals("NCP"));
        Jesus.NCPSpeed = new NumberSetting("NCP Speed", 0.25f, 0.01f, 0.5f, 0.01f, () -> Jesus.mode.currentMode.equals("NCP"));
        Jesus.motionUp = new NumberSetting("Motion Up", 0.42f, 0.1f, 2.0f, 0.01f, () -> Jesus.mode.currentMode.equals("Matrix"));
        Jesus.useTimer = new BooleanSetting("Use Timer", false, () -> true);
    }
    
    private boolean isWater() {
        final BlockPos lllllllllllIIIIIlIllIIIlIIIIIIlI = new BlockPos(Jesus.mc.player.posX - 0.5, Jesus.mc.player.posY - 0.5, Jesus.mc.player.posZ - 0.5);
        final BlockPos lllllllllllIIIIIlIllIIIlIIIIIIIl = new BlockPos(Jesus.mc.player.posX - 0.5, Jesus.mc.player.posY - 0.5, Jesus.mc.player.posZ + 0.5);
        final BlockPos lllllllllllIIIIIlIllIIIlIIIIIIII = new BlockPos(Jesus.mc.player.posX + 0.5, Jesus.mc.player.posY - 0.5, Jesus.mc.player.posZ + 0.5);
        final BlockPos lllllllllllIIIIIlIllIIIIllllllll = new BlockPos(Jesus.mc.player.posX + 0.5, Jesus.mc.player.posY - 0.5, Jesus.mc.player.posZ - 0.5);
        return (Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIlIIIIIIlI).getBlock() == Blocks.WATER && Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIlIIIIIIIl).getBlock() == Blocks.WATER && Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIlIIIIIIII).getBlock() == Blocks.WATER && Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIIllllllll).getBlock() == Blocks.WATER) || (Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIlIIIIIIlI).getBlock() == Blocks.LAVA && Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIlIIIIIIIl).getBlock() == Blocks.LAVA && Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIlIIIIIIII).getBlock() == Blocks.LAVA && Jesus.mc.player.world.getBlockState(lllllllllllIIIIIlIllIIIIllllllll).getBlock() == Blocks.LAVA);
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate lllllllllllIIIIIlIllIIIIlllIllll) {
        this.setSuffix(Jesus.mode.getCurrentMode(), true);
        if (Jesus.mc.player.isPotionActive(MobEffects.SPEED) || !this.speedCheck.getBoolValue()) {
            final BlockPos lllllllllllIIIIIlIllIIIIlllIlllI = new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY - 0.1, Jesus.mc.player.posZ);
            final Block lllllllllllIIIIIlIllIIIIlllIllIl = Jesus.mc.world.getBlockState(lllllllllllIIIIIlIllIIIIlllIlllI).getBlock();
            if (Jesus.useTimer.getBoolValue()) {
                Jesus.mc.timer.timerSpeed = this.timerSpeed.getNumberValue();
            }
            if (Jesus.mode.currentMode.equalsIgnoreCase("Matrix")) {
                if (Jesus.mc.player.isInLiquid() && Jesus.mc.player.motionY < 0.0) {
                    Jesus.mc.player.motionY = Jesus.motionUp.getNumberValue();
                    MovementHelper.setSpeed(Jesus.speed.getNumberValue());
                }
            }
            else if (Jesus.mode.currentMode.equalsIgnoreCase("NCP") && this.isWater() && lllllllllllIIIIIlIllIIIIlllIllIl instanceof BlockLiquid) {
                final double lllllllllllIIIIIlIllIIIIlllIllII = Jesus.mc.player.posX;
                final WorldClient lllllllllllIIIIIlIllIIIIlllIlIll = Jesus.mc.world;
                final double lllllllllllIIIIIlIllIIIIlllIlIlI = Jesus.mc.player.posY - 0.5;
                if (lllllllllllIIIIIlIllIIIIlllIlIll.getBlockState(new BlockPos(lllllllllllIIIIIlIllIIIIlllIllII, lllllllllllIIIIIlIllIIIIlllIlIlI, Jesus.mc.player.posZ)).getBlock() == Block.getBlockById(9) && !Jesus.mc.player.onGround) {
                    MovementHelper.setSpeed(0.025);
                }
                final WorldClient lllllllllllIIIIIlIllIIIIlllIlIIl = Jesus.mc.world;
                final double lllllllllllIIIIIlIllIIIIlllIlIII = Jesus.mc.player.posX;
                final double lllllllllllIIIIIlIllIIIIlllIIlll = Jesus.mc.player.posY + 2.0E-7;
                if (lllllllllllIIIIIlIllIIIIlllIlIIl.getBlockState(new BlockPos(lllllllllllIIIIIlIllIIIIlllIlIII, lllllllllllIIIIIlIllIIIIlllIIlll, Jesus.mc.player.posZ)).getBlock() == Block.getBlockById(9)) {
                    Jesus.mc.player.motionY = 0.07;
                    Jesus.mc.timer.timerSpeed = 1.1f;
                    Jesus.mc.player.speedInAir = 0.2f;
                    if (Jesus.mc.player.isCollidedHorizontally) {
                        MovementHelper.setSpeed(0.0);
                        Jesus.mc.player.speedInAir = 0.001f;
                        Jesus.mc.player.motionY = 0.20000000298023224;
                        Jesus.mc.player.motionX = 0.0;
                        Jesus.mc.player.motionZ = 0.0;
                    }
                }
            }
            else if (Jesus.mode.currentMode.equalsIgnoreCase("ReallyWorld")) {
                Jesus.mc.player.speedInAir = 0.02f;
                lllllllllllIIIIIlIllIIIIlllIllll.setGround(true);
                if (Jesus.mc.world.getBlockState(new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY - 0.001f * Jesus.speed.getNumberValue(), Jesus.mc.player.posZ)).getBlock() == Block.getBlockById(9) && !Jesus.mc.player.onGround) {
                    MovementHelper.setSpeed(9.0);
                    Jesus.mc.player.jumpMovementFactor = 0.01f;
                }
                if (Jesus.mc.world.getBlockState(new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY, Jesus.mc.player.posZ)).getBlock() == Block.getBlockById(9)) {
                    Jesus.mc.player.motionX = 0.0;
                    Jesus.mc.player.motionY = 0.04700000074505806;
                    Jesus.mc.player.jumpMovementFactor = 0.01f;
                    Jesus.mc.player.motionZ = 0.0;
                }
                if (Jesus.mc.world.getBlockState(new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY + 1.0, Jesus.mc.player.posZ)).getBlock() == Block.getBlockById(9)) {
                    Jesus.mc.player.motionY = 0.18;
                }
            }
            else if (Jesus.mode.currentMode.equalsIgnoreCase("Matrix Zoom")) {
                if (Jesus.mc.world.getBlockState(new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY - 0.20000000298023224, Jesus.mc.player.posZ)).getBlock() instanceof BlockLiquid && !Jesus.mc.player.onGround) {
                    MovementHelper.setSpeed(Jesus.speed.getNumberValue());
                }
                if (Jesus.mc.world.getBlockState(new BlockPos(Jesus.mc.player.posX, Jesus.mc.player.posY + 9.999999747378752E-5, Jesus.mc.player.posZ)).getBlock() instanceof BlockLiquid) {
                    Jesus.mc.player.motionX = 0.0;
                    Jesus.mc.player.motionZ = 0.0;
                    Jesus.mc.player.motionY = 0.05000000074505806;
                }
            }
        }
    }
    
    @EventTarget
    public void onLiquidBB(final EventLiquidSolid lllllllllllIIIIIlIllIIIlIIIIlIII) {
        if (!Jesus.mode.currentMode.equals("ReallyWorld")) {
            Jesus.mode.currentMode.equals("NCP");
        }
    }
    
    @Override
    public void onDisable() {
        Jesus.mc.player.speedInAir = 0.02f;
        Jesus.mc.timer.timerSpeed = 1.0f;
        if (Jesus.mode.currentMode.equals("ReallyWorld") && this.autoWaterDown.getBoolValue()) {
            final EntityPlayerSP player;
            final EntityPlayerSP lllllllllllIIIIIlIllIIIlIIIIllII = player = Jesus.mc.player;
            player.motionY -= 500.0;
        }
        this.waterTicks = 0;
        super.onDisable();
    }
    
    public Jesus() {
        super("Jesus", "\u0411\u0435\u0433 \u043f\u043e \u0432\u043e\u0434\u0435", 0, Category.MOVEMENT);
        Jesus.speed = new NumberSetting("Speed", 10.0f, 1.0f, 35.0f, 1.0f, () -> true);
        this.timerSpeed = new NumberSetting("Timer Speed", 1.05f, 1.01f, 1.5f, 0.01f, () -> Jesus.useTimer.getBoolValue());
        this.speedCheck = new BooleanSetting("Speed Potion Check", false, () -> true);
        this.autoMotionStop = new BooleanSetting("Auto Motion Stop", true, () -> Jesus.mode.currentMode.equals("ReallyWorld"));
        this.autoWaterDown = new BooleanSetting("Auto Water Down", false, () -> Jesus.mode.currentMode.equals("ReallyWorld"));
        this.waterTicks = 0;
        this.addSettings(Jesus.mode, Jesus.speed, Jesus.NCPSpeed, Jesus.useTimer, this.timerSpeed, Jesus.motionUp, this.speedCheck, this.autoWaterDown, this.autoMotionStop);
    }
}

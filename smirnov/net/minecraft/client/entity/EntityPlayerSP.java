// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.entity;

import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import ru.rockstar.api.event.event.EventMotion;
import ru.rockstar.api.event.event.MoveEvent;
import net.minecraft.entity.MoverType;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.item.Item;
import net.minecraft.client.gui.GuiScreenBook;
import ru.rockstar.api.event.event.EventPostMotionUpdate;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.rockstar.api.event.event.EventUpdate;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.tileentity.TileEntityCommandBlock;
import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.play.client.CPacketChatMessage;
import ru.rockstar.api.event.event.EventMessage;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiEditStructure;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.util.text.ITextComponent;
import ru.rockstar.client.features.impl.misc.FreeCam;
import ru.rockstar.client.features.impl.player.NoClip;
import ru.rockstar.client.features.impl.player.NoPush;
import net.minecraft.util.DamageSource;
import net.minecraft.network.play.client.CPacketRecipeInfo;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.item.ItemElytra;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.movement.NoSlowDown;
import ru.rockstar.Main;
import net.minecraft.init.MobEffects;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.stats.StatBase;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.tileentity.TileEntitySign;
import javax.annotation.Nullable;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.world.IWorldNameable;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.world.IInteractionObject;
import net.minecraft.client.audio.ElytraSound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiEditCommandBlockMinecart;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovementInput;
import net.minecraft.stats.RecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.util.EnumHand;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.combat.LPositionHelper;

public class EntityPlayerSP extends AbstractClientPlayer
{
    public /* synthetic */ float prevRenderArmYaw;
    private /* synthetic */ float horseJumpPower;
    public /* synthetic */ float prevRenderArmPitch;
    private /* synthetic */ float PrePitch;
    private /* synthetic */ boolean wasFallFlying;
    protected /* synthetic */ int sprintToggleTimer;
    private /* synthetic */ int permissionLevel;
    private /* synthetic */ LPositionHelper location;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ int sprintingTicksLeft;
    private /* synthetic */ boolean rowingBoat;
    private /* synthetic */ float PreYaw;
    private /* synthetic */ double lastReportedPosZ;
    private /* synthetic */ boolean serverSneakState;
    private /* synthetic */ int autoJumpTime;
    private /* synthetic */ EnumHand activeHand;
    private /* synthetic */ double lastReportedPosX;
    public final /* synthetic */ NetHandlerPlayClient connection;
    private /* synthetic */ boolean autoJumpEnabled;
    public /* synthetic */ float renderArmYaw;
    private final /* synthetic */ StatisticsManager statWriter;
    private /* synthetic */ boolean handActive;
    private /* synthetic */ int positionUpdateTicks;
    private /* synthetic */ float lastReportedYaw;
    private /* synthetic */ boolean hasValidHealth;
    private /* synthetic */ double lastReportedPosY;
    private /* synthetic */ boolean serverSprintState;
    public /* synthetic */ float prevTimeInPortal;
    private /* synthetic */ boolean prevOnGround;
    private final /* synthetic */ RecipeBook field_192036_cb;
    private /* synthetic */ int horseJumpPowerCounter;
    private /* synthetic */ float lastReportedPitch;
    private /* synthetic */ String serverBrand;
    public /* synthetic */ float timeInPortal;
    public /* synthetic */ float renderArmPitch;
    public /* synthetic */ MovementInput movementInput;
    
    @Override
    public boolean isServerWorld() {
        return true;
    }
    
    public float[] getHeadRotations() {
        return new float[] { this.rotationYawHead, this.rotationPitchHead };
    }
    
    @Override
    public boolean startRiding(final Entity llllllllllllIIlIIIIllIIlIlIIIIll, final boolean llllllllllllIIlIIIIllIIlIlIIIlIl) {
        if (!super.startRiding(llllllllllllIIlIIIIllIIlIlIIIIll, llllllllllllIIlIIIIllIIlIlIIIlIl)) {
            return false;
        }
        if (llllllllllllIIlIIIIllIIlIlIIIIll instanceof EntityMinecart) {
            this.mc.getSoundHandler().playSound(new MovingSoundMinecartRiding(this, (EntityMinecart)llllllllllllIIlIIIIllIIlIlIIIIll));
        }
        if (llllllllllllIIlIIIIllIIlIlIIIIll instanceof EntityBoat) {
            this.prevRotationYaw = llllllllllllIIlIIIIllIIlIlIIIIll.rotationYaw;
            this.rotationYaw = llllllllllllIIlIIIIllIIlIlIIIIll.rotationYaw;
            this.setRotationYawHead(llllllllllllIIlIIIIllIIlIlIIIIll.rotationYaw);
        }
        return true;
    }
    
    @Override
    public void displayGuiEditCommandCart(final CommandBlockBaseLogic llllllllllllIIlIIIIllIIIIIIIlIll) {
        this.mc.displayGuiScreen(new GuiEditCommandBlockMinecart(llllllllllllIIlIIIIllIIIIIIIlIll));
    }
    
    public boolean isAutoJumpEnabled() {
        return this.autoJumpEnabled;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllIIlIIIIllIIIIIlIIllI) {
        super.notifyDataManagerChange(llllllllllllIIlIIIIllIIIIIlIIllI);
        if (EntityPlayerSP.HAND_STATES.equals(llllllllllllIIlIIIIllIIIIIlIIllI)) {
            final boolean llllllllllllIIlIIIIllIIIIIlIIlIl = (this.dataManager.get(EntityPlayerSP.HAND_STATES) & 0x1) > 0;
            final EnumHand llllllllllllIIlIIIIllIIIIIlIIlII = ((this.dataManager.get(EntityPlayerSP.HAND_STATES) & 0x2) > 0) ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
            if (llllllllllllIIlIIIIllIIIIIlIIlIl && !this.handActive) {
                this.setActiveHand(llllllllllllIIlIIIIllIIIIIlIIlII);
            }
            else if (!llllllllllllIIlIIIIllIIIIIlIIlIl && this.handActive) {
                this.resetActiveHand();
            }
        }
        if (EntityPlayerSP.FLAGS.equals(llllllllllllIIlIIIIllIIIIIlIIllI) && this.isElytraFlying() && !this.wasFallFlying) {
            this.mc.getSoundHandler().playSound(new ElytraSound(this));
        }
    }
    
    @Override
    public EnumHand getActiveHand() {
        return this.activeHand;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int llllllllllllIIlIIIIllIIIIlIlIlII, final String llllllllllllIIlIIIIllIIIIlIlIllI) {
        return llllllllllllIIlIIIIllIIIIlIlIlII <= this.getPermissionLevel();
    }
    
    @Override
    public void setSprinting(final boolean llllllllllllIIlIIIIllIIIIllIllIl) {
        super.setSprinting(llllllllllllIIlIIIIllIIIIllIllIl);
        this.sprintingTicksLeft = 0;
    }
    
    @Override
    public void displayGui(final IInteractionObject llllllllllllIIlIIIIlIlllllIllIll) {
        final String llllllllllllIIlIIIIlIlllllIlllIl = llllllllllllIIlIIIIlIlllllIllIll.getGuiID();
        if ("minecraft:crafting_table".equals(llllllllllllIIlIIIIlIlllllIlllIl)) {
            this.mc.displayGuiScreen(new GuiCrafting(this.inventory, this.world));
        }
        else if ("minecraft:enchanting_table".equals(llllllllllllIIlIIIIlIlllllIlllIl)) {
            this.mc.displayGuiScreen(new GuiEnchantment(this.inventory, this.world, llllllllllllIIlIIIIlIlllllIllIll));
        }
        else if ("minecraft:anvil".equals(llllllllllllIIlIIIIlIlllllIlllIl)) {
            this.mc.displayGuiScreen(new GuiRepair(this.inventory, this.world));
        }
    }
    
    public void setPermissionLevel(final int llllllllllllIIlIIIIllIIIlIlIIIII) {
        this.permissionLevel = llllllllllllIIlIIIIllIIIlIlIIIII;
    }
    
    @Nullable
    @Override
    public EntityItem dropItem(final boolean llllllllllllIIlIIIIllIIlIIIIIlII) {
        final CPacketPlayerDigging.Action llllllllllllIIlIIIIllIIlIIIIIIll = llllllllllllIIlIIIIllIIlIIIIIlII ? CPacketPlayerDigging.Action.DROP_ALL_ITEMS : CPacketPlayerDigging.Action.DROP_ITEM;
        this.connection.sendPacket(new CPacketPlayerDigging(llllllllllllIIlIIIIllIIlIIIIIIll, BlockPos.ORIGIN, EnumFacing.DOWN));
        return null;
    }
    
    @Override
    public void openEditSign(final TileEntitySign llllllllllllIIlIIIIllIIIIIIlIIll) {
        this.mc.displayGuiScreen(new GuiEditSign(llllllllllllIIlIIIIllIIIIIIlIIll));
    }
    
    @Override
    public void addStat(final StatBase llllllllllllIIlIIIIllIIIllIIllII, final int llllllllllllIIlIIIIllIIIllIIlIll) {
        if (llllllllllllIIlIIIIllIIIllIIllII != null && llllllllllllIIlIIIIllIIIllIIllII.isIndependent) {
            super.addStat(llllllllllllIIlIIIIllIIIllIIllII, llllllllllllIIlIIIIllIIIllIIlIll);
        }
    }
    
    @Override
    public void openGuiHorseInventory(final AbstractHorse llllllllllllIIlIIIIlIllllllIIlII, final IInventory llllllllllllIIlIIIIlIllllllIIIll) {
        this.mc.displayGuiScreen(new GuiScreenHorseInventory(this.inventory, llllllllllllIIlIIIIlIllllllIIIll, llllllllllllIIlIIIIlIllllllIIlII));
    }
    
    @Override
    public void onLivingUpdate() {
        ++this.sprintingTicksLeft;
        if (this.sprintToggleTimer > 0) {
            --this.sprintToggleTimer;
        }
        this.prevTimeInPortal = this.timeInPortal;
        if (this.inPortal) {
            if (this.mc.currentScreen != null && !this.mc.currentScreen.doesGuiPauseGame()) {
                if (this.mc.currentScreen instanceof GuiContainer) {
                    this.closeScreen();
                }
                this.mc.displayGuiScreen(null);
            }
            if (this.timeInPortal == 0.0f) {
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.BLOCK_PORTAL_TRIGGER, this.rand.nextFloat() * 0.4f + 0.8f));
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
            }
            this.inPortal = false;
        }
        else if (this.isPotionActive(MobEffects.NAUSEA) && this.getActivePotionEffect(MobEffects.NAUSEA).getDuration() > 60) {
            this.timeInPortal += 0.006666667f;
            if (this.timeInPortal > 1.0f) {
                this.timeInPortal = 1.0f;
            }
        }
        else {
            if (this.timeInPortal > 0.0f) {
                this.timeInPortal -= 0.05f;
            }
            if (this.timeInPortal < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
        final boolean llllllllllllIIlIIIIlIllllIllIIIl = this.movementInput.jump;
        final boolean llllllllllllIIlIIIIlIllllIllIIII = this.movementInput.sneak;
        final float llllllllllllIIlIIIIlIllllIlIllll = 0.8f;
        final boolean llllllllllllIIlIIIIlIllllIlIlllI = MovementInput.moveForward >= 0.8f;
        this.movementInput.updatePlayerMoveState();
        this.mc.func_193032_ao().func_193293_a(this.movementInput);
        if (this.isHandActive() && !this.isRiding()) {
            MovementInput.moveStrafe *= (Main.featureDirector.getFeatureByClass(NoSlowDown.class).isToggled() ? (NoSlowDown.percentage.getNumberValue() / 100.0f) : 0.2f);
            MovementInput.moveForward *= (Main.featureDirector.getFeatureByClass(NoSlowDown.class).isToggled() ? (NoSlowDown.percentage.getNumberValue() / 100.0f) : 0.2f);
            this.sprintToggleTimer = 0;
        }
        boolean llllllllllllIIlIIIIlIllllIlIllIl = false;
        if (this.autoJumpTime > 0) {
            --this.autoJumpTime;
            llllllllllllIIlIIIIlIllllIlIllIl = true;
            this.movementInput.jump = true;
        }
        final AxisAlignedBB llllllllllllIIlIIIIlIllllIlIllII = this.getEntityBoundingBox();
        this.pushOutOfBlocks(this.posX - this.width * 0.35, llllllllllllIIlIIIIlIllllIlIllII.minY + 0.5, this.posZ + this.width * 0.35);
        this.pushOutOfBlocks(this.posX - this.width * 0.35, llllllllllllIIlIIIIlIllllIlIllII.minY + 0.5, this.posZ - this.width * 0.35);
        this.pushOutOfBlocks(this.posX + this.width * 0.35, llllllllllllIIlIIIIlIllllIlIllII.minY + 0.5, this.posZ - this.width * 0.35);
        this.pushOutOfBlocks(this.posX + this.width * 0.35, llllllllllllIIlIIIIlIllllIlIllII.minY + 0.5, this.posZ + this.width * 0.35);
        final boolean llllllllllllIIlIIIIlIllllIlIlIll = this.getFoodStats().getFoodLevel() > 6.0f || this.capabilities.allowFlying;
        if (this.onGround && !llllllllllllIIlIIIIlIllllIllIIII && !llllllllllllIIlIIIIlIllllIlIlllI && MovementInput.moveForward >= 0.8f && !this.isSprinting() && llllllllllllIIlIIIIlIllllIlIlIll && !this.isHandActive() && !this.isPotionActive(MobEffects.BLINDNESS)) {
            if (this.sprintToggleTimer <= 0 && !this.mc.gameSettings.keyBindSprint.isKeyDown()) {
                this.sprintToggleTimer = 7;
            }
            else {
                this.setSprinting(true);
            }
        }
        if (!this.isSprinting() && MovementInput.moveForward >= 0.8f && llllllllllllIIlIIIIlIllllIlIlIll && !this.isHandActive() && !this.isPotionActive(MobEffects.BLINDNESS) && this.mc.gameSettings.keyBindSprint.isKeyDown()) {
            this.setSprinting(true);
        }
        if (this.isSprinting() && (MovementInput.moveForward < 0.8f || this.isCollidedHorizontally || !llllllllllllIIlIIIIlIllllIlIlIll)) {
            this.setSprinting(false);
        }
        if (this.capabilities.allowFlying) {
            if (this.mc.playerController.isSpectatorMode()) {
                if (!this.capabilities.isFlying) {
                    this.capabilities.isFlying = true;
                    this.sendPlayerAbilities();
                }
            }
            else if (!llllllllllllIIlIIIIlIllllIllIIIl && this.movementInput.jump && !llllllllllllIIlIIIIlIllllIlIllIl) {
                if (this.flyToggleTimer == 0) {
                    this.flyToggleTimer = 7;
                }
                else {
                    this.capabilities.isFlying = !this.capabilities.isFlying;
                    this.sendPlayerAbilities();
                    this.flyToggleTimer = 0;
                }
            }
        }
        if (this.movementInput.jump && !llllllllllllIIlIIIIlIllllIllIIIl && !this.onGround && this.motionY < 0.0 && !this.isElytraFlying() && !this.capabilities.isFlying) {
            final ItemStack llllllllllllIIlIIIIlIllllIlIlIlI = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (llllllllllllIIlIIIIlIllllIlIlIlI.getItem() == Items.ELYTRA && ItemElytra.isBroken(llllllllllllIIlIIIIlIllllIlIlIlI)) {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_FALL_FLYING));
            }
        }
        this.wasFallFlying = this.isElytraFlying();
        if (this.capabilities.isFlying && this.isCurrentViewEntity()) {
            if (this.movementInput.sneak) {
                MovementInput.moveStrafe /= (float)0.3;
                MovementInput.moveForward /= (float)0.3;
                this.motionY -= this.capabilities.getFlySpeed() * 3.0f;
            }
            if (this.movementInput.jump) {
                this.motionY += this.capabilities.getFlySpeed() * 3.0f;
            }
        }
        if (this.isRidingHorse()) {
            final IJumpingMount llllllllllllIIlIIIIlIllllIlIlIIl = (IJumpingMount)this.getRidingEntity();
            if (this.horseJumpPowerCounter < 0) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter == 0) {
                    this.horseJumpPower = 0.0f;
                }
            }
            if (llllllllllllIIlIIIIlIllllIllIIIl && !this.movementInput.jump) {
                this.horseJumpPowerCounter = -10;
                llllllllllllIIlIIIIlIllllIlIlIIl.setJumpPower(MathHelper.floor(this.getHorseJumpPower() * 100.0f));
                this.sendHorseJump();
            }
            else if (!llllllllllllIIlIIIIlIllllIllIIIl && this.movementInput.jump) {
                this.horseJumpPowerCounter = 0;
                this.horseJumpPower = 0.0f;
            }
            else if (llllllllllllIIlIIIIlIllllIllIIIl) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter < 10) {
                    this.horseJumpPower = this.horseJumpPowerCounter * 0.1f;
                }
                else {
                    this.horseJumpPower = 0.8f + 2.0f / (this.horseJumpPowerCounter - 9) * 0.1f;
                }
            }
        }
        else {
            this.horseJumpPower = 0.0f;
        }
        super.onLivingUpdate();
        if (this.onGround && this.capabilities.isFlying && !this.mc.playerController.isSpectatorMode()) {
            this.capabilities.isFlying = false;
            this.sendPlayerAbilities();
        }
    }
    
    public EntityPlayerSP(final Minecraft llllllllllllIIlIIIIllIIlIllIllll, final World llllllllllllIIlIIIIllIIlIllIlIII, final NetHandlerPlayClient llllllllllllIIlIIIIllIIlIllIllIl, final StatisticsManager llllllllllllIIlIIIIllIIlIllIIllI, final RecipeBook llllllllllllIIlIIIIllIIlIllIIlIl) {
        super(llllllllllllIIlIIIIllIIlIllIlIII, llllllllllllIIlIIIIllIIlIllIllIl.getGameProfile());
        this.permissionLevel = 0;
        this.autoJumpEnabled = true;
        this.connection = llllllllllllIIlIIIIllIIlIllIllIl;
        this.statWriter = llllllllllllIIlIIIIllIIlIllIIllI;
        this.field_192036_cb = llllllllllllIIlIIIIllIIlIllIIlIl;
        this.mc = llllllllllllIIlIIIIllIIlIllIllll;
        this.dimension = 0;
    }
    
    public void func_193103_a(final IRecipe llllllllllllIIlIIIIllIIIlIlIlIll) {
        if (this.field_192036_cb.func_194076_e(llllllllllllIIlIIIIllIIIlIlIlIll)) {
            this.field_192036_cb.func_194074_f(llllllllllllIIlIIIIllIIIlIlIlIll);
            this.connection.sendPacket(new CPacketRecipeInfo(llllllllllllIIlIIIIllIIIlIlIlIll));
        }
    }
    
    public LPositionHelper getLocation() {
        if (this.location == null) {
            this.location = new LPositionHelper(this.mc.player.posX, this.mc.player.posY, this.mc.player.posZ, this.mc.player.onGround);
        }
        this.location.setX(this.mc.player.posX);
        this.location.setY(this.mc.player.posY);
        this.location.setZ(this.mc.player.posZ);
        this.location.setOnGround(this.mc.player.onGround);
        return this.location;
    }
    
    public void setPlayerSPHealth(final float llllllllllllIIlIIIIllIIIllIlIlIl) {
        if (this.hasValidHealth) {
            final float llllllllllllIIlIIIIllIIIllIlIlII = this.getHealth() - llllllllllllIIlIIIIllIIIllIlIlIl;
            if (llllllllllllIIlIIIIllIIIllIlIlII <= 0.0f) {
                this.setHealth(llllllllllllIIlIIIIllIIIllIlIlIl);
                if (llllllllllllIIlIIIIllIIIllIlIlII < 0.0f) {
                    this.hurtResistantTime = this.maxHurtResistantTime / 2;
                }
            }
            else {
                this.lastDamage = llllllllllllIIlIIIIllIIIllIlIlII;
                this.setHealth(this.getHealth());
                this.hurtResistantTime = this.maxHurtResistantTime;
                this.damageEntity(DamageSource.generic, llllllllllllIIlIIIIllIIIllIlIlII);
                this.maxHurtTime = 10;
                this.hurtTime = this.maxHurtTime;
            }
        }
        else {
            this.setHealth(llllllllllllIIlIIIIllIIIllIlIlIl);
            this.hasValidHealth = true;
        }
    }
    
    @Override
    protected boolean pushOutOfBlocks(final double llllllllllllIIlIIIIllIIIlIIIlIll, final double llllllllllllIIlIIIIllIIIlIIIIIII, final double llllllllllllIIlIIIIllIIIlIIIlIIl) {
        if (Main.featureDirector.getFeatureByClass(NoPush.class).isToggled() || Main.featureDirector.getFeatureByClass(NoClip.class).isToggled() || NoPush.pushblocks.getBoolValue() || Main.featureDirector.getFeatureByClass(FreeCam.class).isToggled()) {
            return false;
        }
        final BlockPos llllllllllllIIlIIIIllIIIlIIIlIII = new BlockPos(llllllllllllIIlIIIIllIIIlIIIlIll, llllllllllllIIlIIIIllIIIlIIIIIII, llllllllllllIIlIIIIllIIIlIIIlIIl);
        final double llllllllllllIIlIIIIllIIIlIIIIlll = llllllllllllIIlIIIIllIIIlIIIlIll - llllllllllllIIlIIIIllIIIlIIIlIII.getX();
        final double llllllllllllIIlIIIIllIIIlIIIIllI = llllllllllllIIlIIIIllIIIlIIIlIIl - llllllllllllIIlIIIIllIIIlIIIlIII.getZ();
        if (!this.isOpenBlockSpace(llllllllllllIIlIIIIllIIIlIIIlIII)) {
            int llllllllllllIIlIIIIllIIIlIIIIlIl = -1;
            double llllllllllllIIlIIIIllIIIlIIIIlII = 9999.0;
            if (this.isOpenBlockSpace(llllllllllllIIlIIIIllIIIlIIIlIII.west()) && llllllllllllIIlIIIIllIIIlIIIIlll < llllllllllllIIlIIIIllIIIlIIIIlII) {
                llllllllllllIIlIIIIllIIIlIIIIlII = llllllllllllIIlIIIIllIIIlIIIIlll;
                llllllllllllIIlIIIIllIIIlIIIIlIl = 0;
            }
            if (this.isOpenBlockSpace(llllllllllllIIlIIIIllIIIlIIIlIII.east()) && 1.0 - llllllllllllIIlIIIIllIIIlIIIIlll < llllllllllllIIlIIIIllIIIlIIIIlII) {
                llllllllllllIIlIIIIllIIIlIIIIlII = 1.0 - llllllllllllIIlIIIIllIIIlIIIIlll;
                llllllllllllIIlIIIIllIIIlIIIIlIl = 1;
            }
            if (this.isOpenBlockSpace(llllllllllllIIlIIIIllIIIlIIIlIII.north()) && llllllllllllIIlIIIIllIIIlIIIIllI < llllllllllllIIlIIIIllIIIlIIIIlII) {
                llllllllllllIIlIIIIllIIIlIIIIlII = llllllllllllIIlIIIIllIIIlIIIIllI;
                llllllllllllIIlIIIIllIIIlIIIIlIl = 4;
            }
            if (this.isOpenBlockSpace(llllllllllllIIlIIIIllIIIlIIIlIII.south()) && 1.0 - llllllllllllIIlIIIIllIIIlIIIIllI < llllllllllllIIlIIIIllIIIlIIIIlII) {
                llllllllllllIIlIIIIllIIIlIIIIlII = 1.0 - llllllllllllIIlIIIIllIIIlIIIIllI;
                llllllllllllIIlIIIIllIIIlIIIIlIl = 5;
            }
            final float llllllllllllIIlIIIIllIIIlIIIIIll = 0.1f;
            if (llllllllllllIIlIIIIllIIIlIIIIlIl == 0) {
                this.motionX = -0.10000000149011612;
            }
            if (llllllllllllIIlIIIIllIIIlIIIIlIl == 1) {
                this.motionX = 0.10000000149011612;
            }
            if (llllllllllllIIlIIIIllIIIlIIIIlIl == 4) {
                this.motionZ = -0.10000000149011612;
            }
            if (llllllllllllIIlIIIIllIIIlIIIIlIl == 5) {
                this.motionZ = 0.10000000149011612;
            }
        }
        return false;
    }
    
    @Override
    public void addChatComponentMessage(final ITextComponent llllllllllllIIlIIIIllIIIlIIllIll, final boolean llllllllllllIIlIIIIllIIIlIIllIlI) {
        if (llllllllllllIIlIIIIllIIIlIIllIlI) {
            this.mc.ingameGUI.setRecordPlaying(llllllllllllIIlIIIIllIIIlIIllIll, false);
        }
        else {
            this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllIIlIIIIllIIIlIIllIll);
        }
    }
    
    @Override
    public void openEditStructure(final TileEntityStructure llllllllllllIIlIIIIlIlllllllllll) {
        this.mc.displayGuiScreen(new GuiEditStructure(llllllllllllIIlIIIIlIlllllllllll));
    }
    
    public void setHeadRotations(final float[] llllllllllllIIlIIIIllIIlIlIlIIll) {
        this.setHeadRotations(llllllllllllIIlIIIIllIIlIlIlIIll[0], llllllllllllIIlIIIIllIIlIlIlIIll[1]);
    }
    
    @Override
    public void displayGUIChest(final IInventory llllllllllllIIlIIIIlIllllllIllIl) {
        final String llllllllllllIIlIIIIlIllllllIllll = (llllllllllllIIlIIIIlIllllllIllIl instanceof IInteractionObject) ? ((IInteractionObject)llllllllllllIIlIIIIlIllllllIllIl).getGuiID() : "minecraft:container";
        if ("minecraft:chest".equals(llllllllllllIIlIIIIlIllllllIllll)) {
            this.mc.displayGuiScreen(new GuiChest(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
        }
        else if ("minecraft:hopper".equals(llllllllllllIIlIIIIlIllllllIllll)) {
            this.mc.displayGuiScreen(new GuiHopper(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
        }
        else if ("minecraft:furnace".equals(llllllllllllIIlIIIIlIllllllIllll)) {
            this.mc.displayGuiScreen(new GuiFurnace(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
        }
        else if ("minecraft:brewing_stand".equals(llllllllllllIIlIIIIlIllllllIllll)) {
            this.mc.displayGuiScreen(new GuiBrewingStand(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
        }
        else if ("minecraft:beacon".equals(llllllllllllIIlIIIIlIllllllIllll)) {
            this.mc.displayGuiScreen(new GuiBeacon(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
        }
        else if (!"minecraft:dispenser".equals(llllllllllllIIlIIIIlIllllllIllll) && !"minecraft:dropper".equals(llllllllllllIIlIIIIlIllllllIllll)) {
            if ("minecraft:shulker_box".equals(llllllllllllIIlIIIIlIllllllIllll)) {
                this.mc.displayGuiScreen(new GuiShulkerBox(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
            }
            else {
                this.mc.displayGuiScreen(new GuiChest(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
            }
        }
        else {
            this.mc.displayGuiScreen(new GuiDispenser(this.inventory, llllllllllllIIlIIIIlIllllllIllIl));
        }
    }
    
    public float getHorseJumpPower() {
        return this.horseJumpPower;
    }
    
    @Override
    public void respawnPlayer() {
        this.connection.sendPacket(new CPacketClientStatus(CPacketClientStatus.State.PERFORM_RESPAWN));
    }
    
    public void sendHorseInventory() {
        this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.OPEN_INVENTORY));
    }
    
    public StatisticsManager getStatFileWriter() {
        return this.statWriter;
    }
    
    public void setXPStats(final float llllllllllllIIlIIIIllIIIIllIIIll, final int llllllllllllIIlIIIIllIIIIllIIllI, final int llllllllllllIIlIIIIllIIIIllIIIIl) {
        this.experience = llllllllllllIIlIIIIllIIIIllIIIll;
        this.experienceTotal = llllllllllllIIlIIIIllIIIIllIIllI;
        this.experienceLevel = llllllllllllIIlIIIIllIIIIllIIIIl;
    }
    
    @Override
    public void addChatMessage(final ITextComponent llllllllllllIIlIIIIllIIIIlIlllIl) {
        this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllIIlIIIIllIIIIlIlllIl);
    }
    
    @Override
    public void playSound(final SoundEvent llllllllllllIIlIIIIllIIIIlIIIlIl, final float llllllllllllIIlIIIIllIIIIlIIIlII, final float llllllllllllIIlIIIIllIIIIIllllll) {
        this.world.playSound(this.posX, this.posY, this.posZ, llllllllllllIIlIIIIllIIIIlIIIlIl, this.getSoundCategory(), llllllllllllIIlIIIIllIIIIlIIIlII, llllllllllllIIlIIIIllIIIIIllllll, false);
    }
    
    protected boolean isCurrentViewEntity() {
        return this.mc.getRenderViewEntity() == this;
    }
    
    @Override
    public boolean isSneaking() {
        final boolean llllllllllllIIlIIIIlIlllllIIIlII = this.movementInput != null && this.movementInput.sneak;
        return llllllllllllIIlIIIIlIlllllIIIlII && !this.sleeping;
    }
    
    public RecipeBook func_192035_E() {
        return this.field_192036_cb;
    }
    
    private boolean isOpenBlockSpace(final BlockPos llllllllllllIIlIIIIllIIIIlllIlIl) {
        return !this.world.getBlockState(llllllllllllIIlIIIIllIIIIlllIlIl).isNormalCube() && !this.world.getBlockState(llllllllllllIIlIIIIllIIIIlllIlIl.up()).isNormalCube();
    }
    
    @Override
    public void onEnchantmentCritical(final Entity llllllllllllIIlIIIIlIlllllIIlIII) {
        this.mc.effectRenderer.emitParticleAtEntity(llllllllllllIIlIIIIlIlllllIIlIII, EnumParticleTypes.CRIT_MAGIC);
    }
    
    @Override
    protected ItemStack dropItemAndGetStack(final EntityItem llllllllllllIIlIIIIllIIIlllllllI) {
        return ItemStack.field_190927_a;
    }
    
    public void sendChatMessage(final String llllllllllllIIlIIIIllIIIllllIllI) {
        final EventMessage llllllllllllIIlIIIIllIIIlllllIII = new EventMessage(llllllllllllIIlIIIIllIIIllllIllI);
        llllllllllllIIlIIIIllIIIlllllIII.call();
        if (!llllllllllllIIlIIIIllIIIlllllIII.isCancelled()) {
            this.connection.sendPacket(new CPacketChatMessage(llllllllllllIIlIIIIllIIIlllllIII.getMessage()));
        }
    }
    
    public boolean killaurachecks() {
        return this.mc.player.isInLava() || this.mc.player.isInWater() || this.mc.player.isOnLadder() || this.mc.player.isInWeb;
    }
    
    public boolean isRidingHorse() {
        final Entity llllllllllllIIlIIIIllIIIIIIlllII = this.getRidingEntity();
        return this.isRiding() && llllllllllllIIlIIIIllIIIIIIlllII instanceof IJumpingMount && ((IJumpingMount)llllllllllllIIlIIIIllIIIIIIlllII).canJump();
    }
    
    @Override
    public boolean isHandActive() {
        return this.handActive;
    }
    
    @Override
    public void updateRidden() {
        super.updateRidden();
        this.rowingBoat = false;
        if (this.getRidingEntity() instanceof EntityBoat) {
            final EntityBoat llllllllllllIIlIIIIlIllllIIlllII = (EntityBoat)this.getRidingEntity();
            llllllllllllIIlIIIIlIllllIIlllII.updateInputs(this.movementInput.leftKeyDown, this.movementInput.rightKeyDown, this.movementInput.forwardKeyDown, this.movementInput.backKeyDown);
            this.rowingBoat |= (this.movementInput.leftKeyDown || this.movementInput.rightKeyDown || this.movementInput.forwardKeyDown || this.movementInput.backKeyDown);
        }
    }
    
    public boolean isMoving() {
        return !this.isSneaking() && (MovementInput.moveForward != 0.0f || MovementInput.moveStrafe != 0.0f);
    }
    
    public int getPermissionLevel() {
        return this.permissionLevel;
    }
    
    public String getServerBrand() {
        return this.serverBrand;
    }
    
    @Override
    public boolean isUser() {
        return true;
    }
    
    protected void updateAutoJump(final float llllllllllllIIlIIIIlIlllIIIllIlI, final float llllllllllllIIlIIIIlIlllIlIIlIII) {
        if (this.isAutoJumpEnabled() && this.autoJumpTime <= 0 && this.onGround && !this.isSneaking() && !this.isRiding()) {
            final Vec2f llllllllllllIIlIIIIlIlllIlIIIlll = this.movementInput.getMoveVector();
            if (llllllllllllIIlIIIIlIlllIlIIIlll.x != 0.0f || llllllllllllIIlIIIIlIlllIlIIIlll.y != 0.0f) {
                final Vec3d llllllllllllIIlIIIIlIlllIlIIIllI = new Vec3d(this.posX, this.getEntityBoundingBox().minY, this.posZ);
                final double llllllllllllIIlIIIIlIlllIlIIIlIl = this.posX + llllllllllllIIlIIIIlIlllIIIllIlI;
                final double llllllllllllIIlIIIIlIlllIlIIIlII = this.posZ + llllllllllllIIlIIIIlIlllIlIIlIII;
                final Vec3d llllllllllllIIlIIIIlIlllIlIIIIll = new Vec3d(llllllllllllIIlIIIIlIlllIlIIIlIl, this.getEntityBoundingBox().minY, llllllllllllIIlIIIIlIlllIlIIIlII);
                Vec3d llllllllllllIIlIIIIlIlllIlIIIIlI = new Vec3d(llllllllllllIIlIIIIlIlllIIIllIlI, 0.0, llllllllllllIIlIIIIlIlllIlIIlIII);
                final float llllllllllllIIlIIIIlIlllIlIIIIIl = this.getAIMoveSpeed();
                float llllllllllllIIlIIIIlIlllIlIIIIII = (float)llllllllllllIIlIIIIlIlllIlIIIIlI.lengthSquared();
                if (llllllllllllIIlIIIIlIlllIlIIIIII <= 0.001f) {
                    final float llllllllllllIIlIIIIlIlllIIllllll = llllllllllllIIlIIIIlIlllIlIIIIIl * llllllllllllIIlIIIIlIlllIlIIIlll.x;
                    final float llllllllllllIIlIIIIlIlllIIlllllI = llllllllllllIIlIIIIlIlllIlIIIIIl * llllllllllllIIlIIIIlIlllIlIIIlll.y;
                    final float llllllllllllIIlIIIIlIlllIIllllIl = MathHelper.sin(this.rotationYaw * 0.017453292f);
                    final float llllllllllllIIlIIIIlIlllIIllllII = MathHelper.cos(this.rotationYaw * 0.017453292f);
                    llllllllllllIIlIIIIlIlllIlIIIIlI = new Vec3d(llllllllllllIIlIIIIlIlllIIllllll * llllllllllllIIlIIIIlIlllIIllllII - llllllllllllIIlIIIIlIlllIIlllllI * llllllllllllIIlIIIIlIlllIIllllIl, llllllllllllIIlIIIIlIlllIlIIIIlI.yCoord, llllllllllllIIlIIIIlIlllIIlllllI * llllllllllllIIlIIIIlIlllIIllllII + llllllllllllIIlIIIIlIlllIIllllll * llllllllllllIIlIIIIlIlllIIllllIl);
                    llllllllllllIIlIIIIlIlllIlIIIIII = (float)llllllllllllIIlIIIIlIlllIlIIIIlI.lengthSquared();
                    if (llllllllllllIIlIIIIlIlllIlIIIIII <= 0.001f) {
                        return;
                    }
                }
                final float llllllllllllIIlIIIIlIlllIIlllIll = (float)MathHelper.fastInvSqrt(llllllllllllIIlIIIIlIlllIlIIIIII);
                final Vec3d llllllllllllIIlIIIIlIlllIIlllIlI = llllllllllllIIlIIIIlIlllIlIIIIlI.scale(llllllllllllIIlIIIIlIlllIIlllIll);
                final Vec3d llllllllllllIIlIIIIlIlllIIlllIIl = this.getForward();
                final float llllllllllllIIlIIIIlIlllIIlllIII = (float)(llllllllllllIIlIIIIlIlllIIlllIIl.xCoord * llllllllllllIIlIIIIlIlllIIlllIlI.xCoord + llllllllllllIIlIIIIlIlllIIlllIIl.zCoord * llllllllllllIIlIIIIlIlllIIlllIlI.zCoord);
                if (llllllllllllIIlIIIIlIlllIIlllIII >= -0.15f) {
                    BlockPos llllllllllllIIlIIIIlIlllIIllIlll = new BlockPos(this.posX, this.getEntityBoundingBox().maxY, this.posZ);
                    final IBlockState llllllllllllIIlIIIIlIlllIIllIllI = this.world.getBlockState(llllllllllllIIlIIIIlIlllIIllIlll);
                    if (llllllllllllIIlIIIIlIlllIIllIllI.getCollisionBoundingBox(this.world, llllllllllllIIlIIIIlIlllIIllIlll) == null) {
                        llllllllllllIIlIIIIlIlllIIllIlll = llllllllllllIIlIIIIlIlllIIllIlll.up();
                        final IBlockState llllllllllllIIlIIIIlIlllIIllIlIl = this.world.getBlockState(llllllllllllIIlIIIIlIlllIIllIlll);
                        if (llllllllllllIIlIIIIlIlllIIllIlIl.getCollisionBoundingBox(this.world, llllllllllllIIlIIIIlIlllIIllIlll) == null) {
                            final float llllllllllllIIlIIIIlIlllIIllIlII = 7.0f;
                            float llllllllllllIIlIIIIlIlllIIllIIll = 1.2f;
                            if (this.isPotionActive(MobEffects.JUMP_BOOST)) {
                                llllllllllllIIlIIIIlIlllIIllIIll += (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.75f;
                            }
                            final float llllllllllllIIlIIIIlIlllIIllIIlI = Math.max(llllllllllllIIlIIIIlIlllIlIIIIIl * 7.0f, 1.0f / llllllllllllIIlIIIIlIlllIIlllIll);
                            Vec3d llllllllllllIIlIIIIlIlllIIllIIIl = llllllllllllIIlIIIIlIlllIlIIIIll.add(llllllllllllIIlIIIIlIlllIIlllIlI.scale(llllllllllllIIlIIIIlIlllIIllIIlI));
                            final float llllllllllllIIlIIIIlIlllIIllIIII = this.width;
                            final float llllllllllllIIlIIIIlIlllIIlIllll = this.height;
                            final AxisAlignedBB llllllllllllIIlIIIIlIlllIIlIlllI = new AxisAlignedBB(llllllllllllIIlIIIIlIlllIlIIIllI, llllllllllllIIlIIIIlIlllIIllIIIl.addVector(0.0, llllllllllllIIlIIIIlIlllIIlIllll, 0.0)).expand(llllllllllllIIlIIIIlIlllIIllIIII, 0.0, llllllllllllIIlIIIIlIlllIIllIIII);
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIllIl = llllllllllllIIlIIIIlIlllIlIIIllI.addVector(0.0, 0.5099999904632568, 0.0);
                            llllllllllllIIlIIIIlIlllIIllIIIl = llllllllllllIIlIIIIlIlllIIllIIIl.addVector(0.0, 0.5099999904632568, 0.0);
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIllII = llllllllllllIIlIIIIlIlllIIlllIlI.crossProduct(new Vec3d(0.0, 1.0, 0.0));
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIlIll = llllllllllllIIlIIIIlIlllIIlIllII.scale(llllllllllllIIlIIIIlIlllIIllIIII * 0.5f);
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIlIlI = llllllllllllIIlIIIIlIlllIIlIllIl.subtract(llllllllllllIIlIIIIlIlllIIlIlIll);
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIlIIl = llllllllllllIIlIIIIlIlllIIllIIIl.subtract(llllllllllllIIlIIIIlIlllIIlIlIll);
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIlIII = llllllllllllIIlIIIIlIlllIIlIllIl.add(llllllllllllIIlIIIIlIlllIIlIlIll);
                            final Vec3d llllllllllllIIlIIIIlIlllIIlIIlll = llllllllllllIIlIIIIlIlllIIllIIIl.add(llllllllllllIIlIIIIlIlllIIlIlIll);
                            final List<AxisAlignedBB> llllllllllllIIlIIIIlIlllIIlIIllI = this.world.getCollisionBoxes(this, llllllllllllIIlIIIIlIlllIIlIlllI);
                            if (!llllllllllllIIlIIIIlIlllIIlIIllI.isEmpty()) {}
                            float llllllllllllIIlIIIIlIlllIIlIIlIl = Float.MIN_VALUE;
                            for (final AxisAlignedBB llllllllllllIIlIIIIlIlllIIlIIlII : llllllllllllIIlIIIIlIlllIIlIIllI) {
                                if (llllllllllllIIlIIIIlIlllIIlIIlII.intersects(llllllllllllIIlIIIIlIlllIIlIlIlI, llllllllllllIIlIIIIlIlllIIlIlIIl) || llllllllllllIIlIIIIlIlllIIlIIlII.intersects(llllllllllllIIlIIIIlIlllIIlIlIII, llllllllllllIIlIIIIlIlllIIlIIlll)) {
                                    llllllllllllIIlIIIIlIlllIIlIIlIl = (float)llllllllllllIIlIIIIlIlllIIlIIlII.maxY;
                                    final Vec3d llllllllllllIIlIIIIlIlllIIlIIIll = llllllllllllIIlIIIIlIlllIIlIIlII.getCenter();
                                    final BlockPos llllllllllllIIlIIIIlIlllIIlIIIlI = new BlockPos(llllllllllllIIlIIIIlIlllIIlIIIll);
                                    for (int llllllllllllIIlIIIIlIlllIIlIIIIl = 1; llllllllllllIIlIIIIlIlllIIlIIIIl < llllllllllllIIlIIIIlIlllIIllIIll; ++llllllllllllIIlIIIIlIlllIIlIIIIl) {
                                        final BlockPos llllllllllllIIlIIIIlIlllIIlIIIII = llllllllllllIIlIIIIlIlllIIlIIIlI.up(llllllllllllIIlIIIIlIlllIIlIIIIl);
                                        final IBlockState llllllllllllIIlIIIIlIlllIIIlllll = this.world.getBlockState(llllllllllllIIlIIIIlIlllIIlIIIII);
                                        final AxisAlignedBB llllllllllllIIlIIIIlIlllIIIllllI;
                                        if ((llllllllllllIIlIIIIlIlllIIIllllI = llllllllllllIIlIIIIlIlllIIIlllll.getCollisionBoundingBox(this.world, llllllllllllIIlIIIIlIlllIIlIIIII)) != null) {
                                            llllllllllllIIlIIIIlIlllIIlIIlIl = (float)llllllllllllIIlIIIIlIlllIIIllllI.maxY + llllllllllllIIlIIIIlIlllIIlIIIII.getY();
                                            if (llllllllllllIIlIIIIlIlllIIlIIlIl - this.getEntityBoundingBox().minY > llllllllllllIIlIIIIlIlllIIllIIll) {
                                                return;
                                            }
                                        }
                                        if (llllllllllllIIlIIIIlIlllIIlIIIIl > 1) {
                                            llllllllllllIIlIIIIlIlllIIllIlll = llllllllllllIIlIIIIlIlllIIllIlll.up();
                                            final IBlockState llllllllllllIIlIIIIlIlllIIIlllIl = this.world.getBlockState(llllllllllllIIlIIIIlIlllIIllIlll);
                                            if (llllllllllllIIlIIIIlIlllIIIlllIl.getCollisionBoundingBox(this.world, llllllllllllIIlIIIIlIlllIIllIlll) != null) {
                                                return;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                            if (llllllllllllIIlIIIIlIlllIIlIIlIl != Float.MIN_VALUE) {
                                final float llllllllllllIIlIIIIlIlllIIIlllII = (float)(llllllllllllIIlIIIIlIlllIIlIIlIl - this.getEntityBoundingBox().minY);
                                if (llllllllllllIIlIIIIlIlllIIIlllII > 0.5f && llllllllllllIIlIIIIlIlllIIIlllII <= llllllllllllIIlIIIIlIlllIIllIIll) {
                                    this.autoJumpTime = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void displayGuiCommandBlock(final TileEntityCommandBlock llllllllllllIIlIIIIllIIIIIIIIlIl) {
        this.mc.displayGuiScreen(new GuiCommandBlock(llllllllllllIIlIIIIllIIIIIIIIlIl));
    }
    
    public boolean isRowingBoat() {
        return this.rowingBoat;
    }
    
    @Override
    public void onUpdate() {
        final EventUpdate llllllllllllIIlIIIIllIIlIIllIllI = new EventUpdate();
        llllllllllllIIlIIIIllIIlIIllIllI.call();
        if (this.world.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
            super.onUpdate();
            if (this.isRiding()) {
                this.connection.sendPacket(new CPacketPlayer.Rotation(this.rotationYaw, this.rotationPitch, this.onGround));
                this.connection.sendPacket(new CPacketInput(this.moveStrafing, this.field_191988_bg, this.movementInput.jump, this.movementInput.sneak));
                final Entity llllllllllllIIlIIIIllIIlIIllIlIl = this.getLowestRidingEntity();
                if (llllllllllllIIlIIIIllIIlIIllIlIl != this && llllllllllllIIlIIIIllIIlIIllIlIl.canPassengerSteer()) {
                    this.connection.sendPacket(new CPacketVehicleMove(llllllllllllIIlIIIIllIIlIIllIlIl));
                }
            }
            else {
                this.onUpdateWalkingPlayer();
                final EventPostMotionUpdate llllllllllllIIlIIIIllIIlIIllIlII = new EventPostMotionUpdate(this.rotationYaw, this.rotationPitch, this.onGround, this.posY);
                llllllllllllIIlIIIIllIIlIIllIlII.call();
                if (!Main.featureDirector.getFeatureByClass(FreeCam.class).isToggled()) {
                    this.rotationYaw = this.PreYaw;
                    this.rotationPitch = this.PrePitch;
                }
            }
        }
    }
    
    @Override
    public void openBook(final ItemStack llllllllllllIIlIIIIlIllllllllIlI, final EnumHand llllllllllllIIlIIIIlIllllllllIIl) {
        final Item llllllllllllIIlIIIIlIllllllllIII = llllllllllllIIlIIIIlIllllllllIlI.getItem();
        if (llllllllllllIIlIIIIlIllllllllIII == Items.WRITABLE_BOOK) {
            this.mc.displayGuiScreen(new GuiScreenBook(this, llllllllllllIIlIIIIlIllllllllIlI, true));
        }
    }
    
    @Override
    public void displayVillagerTradeGui(final IMerchant llllllllllllIIlIIIIlIlllllIlIllI) {
        this.mc.displayGuiScreen(new GuiMerchant(this.inventory, llllllllllllIIlIIIIlIlllllIlIllI, this.world));
    }
    
    @Override
    public void moveEntity(final MoverType llllllllllllIIlIIIIlIllllIIIIlll, final double llllllllllllIIlIIIIlIllllIIIIllI, final double llllllllllllIIlIIIIlIlllIlllllIl, final double llllllllllllIIlIIIIlIlllIlllllII) {
        final MoveEvent llllllllllllIIlIIIIlIllllIIIIIll = new MoveEvent(llllllllllllIIlIIIIlIllllIIIIllI, llllllllllllIIlIIIIlIlllIlllllIl, llllllllllllIIlIIIIlIlllIlllllII);
        llllllllllllIIlIIIIlIllllIIIIIll.call();
        final double llllllllllllIIlIIIIlIllllIIIIIlI = llllllllllllIIlIIIIlIllllIIIIIll.getX();
        final double llllllllllllIIlIIIIlIllllIIIIIIl = llllllllllllIIlIIIIlIllllIIIIIll.getZ();
        super.moveEntity(llllllllllllIIlIIIIlIllllIIIIlll, llllllllllllIIlIIIIlIllllIIIIIlI, llllllllllllIIlIIIIlIllllIIIIIll.getY(), llllllllllllIIlIIIIlIllllIIIIIIl);
        this.updateAutoJump((float)(this.posX - llllllllllllIIlIIIIlIllllIIIIIlI), (float)(this.posZ - llllllllllllIIlIIIIlIllllIIIIIIl));
    }
    
    public void setServerBrand(final String llllllllllllIIlIIIIllIIIlIlllIII) {
        this.serverBrand = llllllllllllIIlIIIIllIIIlIlllIII;
    }
    
    @Override
    public void setActiveHand(final EnumHand llllllllllllIIlIIIIllIIIIIlllIIl) {
        final ItemStack llllllllllllIIlIIIIllIIIIIlllIII = this.getHeldItem(llllllllllllIIlIIIIllIIIIIlllIIl);
        if (!llllllllllllIIlIIIIllIIIIIlllIII.func_190926_b() && !this.isHandActive()) {
            super.setActiveHand(llllllllllllIIlIIIIllIIIIIlllIIl);
            this.handActive = true;
            this.activeHand = llllllllllllIIlIIIIllIIIIIlllIIl;
        }
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
    
    public void setHeadRotations(final float llllllllllllIIlIIIIllIIlIlIllIlI, final float llllllllllllIIlIIIIllIIlIlIlllII) {
        this.rotationYawHead = llllllllllllIIlIIIIllIIlIlIllIlI;
        this.rotationPitchHead = llllllllllllIIlIIIIllIIlIlIlllII;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllIIlIIIIllIIlIllIIIll, final float llllllllllllIIlIIIIllIIlIllIIIlI) {
        return false;
    }
    
    @Override
    public void resetActiveHand() {
        super.resetActiveHand();
        this.handActive = false;
    }
    
    private void onUpdateWalkingPlayer() {
        if (Main.featureDirector.getFeatureByClass(FreeCam.class).isToggled()) {
            return;
        }
        final EventMotion llllllllllllIIlIIIIllIIlIIlIIIlI = new EventMotion(this.mc.player.posX, this.getEntityBoundingBox().minY, this.mc.player.posZ, this.mc.player.rotationYaw, this.mc.player.rotationPitch, this.isSneaking(), this.mc.player.onGround);
        llllllllllllIIlIIIIllIIlIIlIIIlI.call();
        final EventPreMotionUpdate llllllllllllIIlIIIIllIIlIIlIIIIl = new EventPreMotionUpdate(this.rotationYaw, this.rotationPitch, this.posY, this.getLocation());
        llllllllllllIIlIIIIllIIlIIlIIIIl.call();
        this.PreYaw = this.rotationYaw;
        this.PrePitch = this.rotationPitch;
        this.rotationYaw = llllllllllllIIlIIIIllIIlIIlIIIIl.getYaw();
        this.rotationPitch = llllllllllllIIlIIIIllIIlIIlIIIIl.getPitch();
        final boolean llllllllllllIIlIIIIllIIlIIlIIIII = this.isSprinting();
        if (llllllllllllIIlIIIIllIIlIIlIIIII != this.serverSprintState) {
            if (llllllllllllIIlIIIIllIIlIIlIIIII) {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_SPRINTING));
            }
            else {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            this.serverSprintState = llllllllllllIIlIIIIllIIlIIlIIIII;
        }
        final boolean llllllllllllIIlIIIIllIIlIIIlllll = this.isSneaking();
        if (llllllllllllIIlIIIIllIIlIIIlllll != this.serverSneakState) {
            if (llllllllllllIIlIIIIllIIlIIIlllll) {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_SNEAKING));
            }
            else {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            this.serverSneakState = llllllllllllIIlIIIIllIIlIIIlllll;
        }
        if (this.isCurrentViewEntity()) {
            final AxisAlignedBB llllllllllllIIlIIIIllIIlIIIllllI = this.getEntityBoundingBox();
            final double llllllllllllIIlIIIIllIIlIIIlllIl = this.posX - this.lastReportedPosX;
            final double llllllllllllIIlIIIIllIIlIIIlllII = llllllllllllIIlIIIIllIIlIIIllllI.minY - this.lastReportedPosY;
            final double llllllllllllIIlIIIIllIIlIIIllIll = this.posZ - this.lastReportedPosZ;
            final double llllllllllllIIlIIIIllIIlIIIllIlI = this.rotationYaw - this.lastReportedYaw;
            final double llllllllllllIIlIIIIllIIlIIIllIIl = this.rotationPitch - this.lastReportedPitch;
            ++this.positionUpdateTicks;
            boolean llllllllllllIIlIIIIllIIlIIIllIII = llllllllllllIIlIIIIllIIlIIIlllIl * llllllllllllIIlIIIIllIIlIIIlllIl + llllllllllllIIlIIIIllIIlIIIlllII * llllllllllllIIlIIIIllIIlIIIlllII + llllllllllllIIlIIIIllIIlIIIllIll * llllllllllllIIlIIIIllIIlIIIllIll > 9.0E-4 || this.positionUpdateTicks >= 20;
            final boolean llllllllllllIIlIIIIllIIlIIIlIlll = llllllllllllIIlIIIIllIIlIIIllIlI != 0.0 || llllllllllllIIlIIIIllIIlIIIllIIl != 0.0;
            if (!Main.featureDirector.getFeatureByClass(FreeCam.class).isToggled()) {
                if (this.isRiding()) {
                    this.connection.sendPacket(new CPacketPlayer.PositionRotation(this.motionX, -999.0, this.motionZ, this.rotationYaw, this.rotationPitch, this.onGround));
                    llllllllllllIIlIIIIllIIlIIIllIII = false;
                }
                else if (llllllllllllIIlIIIIllIIlIIIllIII && llllllllllllIIlIIIIllIIlIIIlIlll) {
                    this.connection.sendPacket(new CPacketPlayer.PositionRotation(this.posX, llllllllllllIIlIIIIllIIlIIIllllI.minY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
                }
                else if (llllllllllllIIlIIIIllIIlIIIllIII) {
                    this.connection.sendPacket(new CPacketPlayer.Position(this.posX, llllllllllllIIlIIIIllIIlIIIllllI.minY, this.posZ, this.onGround));
                }
                else if (llllllllllllIIlIIIIllIIlIIIlIlll) {
                    this.connection.sendPacket(new CPacketPlayer.Rotation(this.rotationYaw, this.rotationPitch, this.onGround));
                }
                else if (this.prevOnGround != this.onGround) {
                    this.connection.sendPacket(new CPacketPlayer(this.onGround));
                }
            }
            if (llllllllllllIIlIIIIllIIlIIIllIII) {
                this.lastReportedPosX = this.posX;
                this.lastReportedPosY = llllllllllllIIlIIIIllIIlIIIllllI.minY;
                this.lastReportedPosZ = this.posZ;
                this.positionUpdateTicks = 0;
            }
            if (llllllllllllIIlIIIIllIIlIIIlIlll) {
                this.lastReportedYaw = this.rotationYaw;
                this.lastReportedPitch = this.rotationPitch;
            }
            this.prevOnGround = this.onGround;
            this.autoJumpEnabled = this.mc.gameSettings.autoJump;
        }
        final EventMotion llllllllllllIIlIIIIllIIlIIIlIllI = new EventMotion();
        llllllllllllIIlIIIIllIIlIIIlIllI.call();
    }
    
    public void updateEntityActionState() {
        super.updateEntityActionState();
        if (this.isCurrentViewEntity()) {
            this.moveStrafing = MovementInput.moveStrafe;
            this.field_191988_bg = MovementInput.moveForward;
            this.isJumping = this.movementInput.jump;
            this.prevRenderArmYaw = this.renderArmYaw;
            this.prevRenderArmPitch = this.renderArmPitch;
            this.renderArmPitch += (float)((this.rotationPitch - this.renderArmPitch) * 0.5);
            this.renderArmYaw += (float)((this.rotationYaw - this.renderArmYaw) * 0.5);
        }
    }
    
    @Override
    public void sendPlayerAbilities() {
        this.connection.sendPacket(new CPacketPlayerAbilities(this.capabilities));
    }
    
    @Override
    protected void damageEntity(final DamageSource llllllllllllIIlIIIIllIIIlllIIIIl, final float llllllllllllIIlIIIIllIIIlllIIIII) {
        if (!this.isEntityInvulnerable(llllllllllllIIlIIIIllIIIlllIIIIl)) {
            this.setHealth(this.getHealth() - llllllllllllIIlIIIIllIIIlllIIIII);
        }
    }
    
    public float[] getRotations() {
        return new float[] { this.rotationYaw, this.rotationPitch };
    }
    
    public void closeScreenAndDropStack() {
        this.inventory.setItemStack(ItemStack.field_190927_a);
        super.closeScreen();
        this.mc.displayGuiScreen(null);
    }
    
    public boolean isInLiquid() {
        return this.mc.player.isInLava() || this.mc.player.isInWater();
    }
    
    @Override
    public void heal(final float llllllllllllIIlIIIIllIIlIlIIlIll) {
    }
    
    @Override
    public void dismountRidingEntity() {
        super.dismountRidingEntity();
        this.rowingBoat = false;
    }
    
    @Nullable
    @Override
    public PotionEffect removeActivePotionEffect(@Nullable final Potion llllllllllllIIlIIIIlIllllIIlIIIl) {
        if (llllllllllllIIlIIIIlIllllIIlIIIl == MobEffects.NAUSEA) {
            this.prevTimeInPortal = 0.0f;
            this.timeInPortal = 0.0f;
        }
        return super.removeActivePotionEffect(llllllllllllIIlIIIIlIllllIIlIIIl);
    }
    
    protected void sendHorseJump() {
        this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_RIDING_JUMP, MathHelper.floor(this.getHorseJumpPower() * 100.0f)));
    }
    
    public void closeScreen() {
        this.connection.sendPacket(new CPacketCloseWindow(this.openContainer.windowId));
        this.closeScreenAndDropStack();
    }
    
    @Override
    public Vec3d getLook(final float llllllllllllIIlIIIIllIIlIIllllII) {
        return Entity.getVectorForRotation(this.rotationPitch, this.rotationYaw);
    }
    
    @Override
    public void onCriticalHit(final Entity llllllllllllIIlIIIIlIlllllIIlllI) {
        this.mc.effectRenderer.emitParticleAtEntity(llllllllllllIIlIIIIlIlllllIIlllI, EnumParticleTypes.CRIT);
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllIIlIIIIllIIIIlIlIIII) {
        if (llllllllllllIIlIIIIllIIIIlIlIIII >= 24 && llllllllllllIIlIIIIllIIIIlIlIIII <= 28) {
            this.setPermissionLevel(llllllllllllIIlIIIIllIIIIlIlIIII - 24);
        }
        else {
            super.handleStatusUpdate(llllllllllllIIlIIIIllIIIIlIlIIII);
        }
    }
    
    @Override
    public void swingArm(final EnumHand llllllllllllIIlIIIIllIIIlllIlllI) {
        super.swingArm(llllllllllllIIlIIIIllIIIlllIlllI);
        this.connection.sendPacket(new CPacketAnimation(llllllllllllIIlIIIIllIIIlllIlllI));
    }
}

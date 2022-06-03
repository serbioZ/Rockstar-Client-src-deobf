// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.combat;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.event.event.EventPreMotionUpdate;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.client.gui.GuiBossOverlay;
import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class AutoPotion extends Feature
{
    public /* synthetic */ BooleanSetting onlyKT;
    public /* synthetic */ NumberSetting delay;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions;
    public /* synthetic */ BooleanSetting onlyGround;
    
    public boolean isStackPotion(final ItemStack llllllllllllIIIIlllIIIIlllllIIIl, final Potions llllllllllllIIIIlllIIIIllllIlIll) {
        if (llllllllllllIIIIlllIIIIlllllIIIl == null) {
            return false;
        }
        final Item llllllllllllIIIIlllIIIIllllIllll = llllllllllllIIIIlllIIIIlllllIIIl.getItem();
        if (llllllllllllIIIIlllIIIIllllIllll == Items.SPLASH_POTION) {
            int llllllllllllIIIIlllIIIIllllIlllI = 5;
            switch ($SWITCH_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions()[llllllllllllIIIIlllIIIIllllIlIll.ordinal()]) {
                case 1: {
                    llllllllllllIIIIlllIIIIllllIlllI = 5;
                    break;
                }
                case 2: {
                    llllllllllllIIIIlllIIIIllllIlllI = 1;
                    break;
                }
                case 3: {
                    llllllllllllIIIIlllIIIIllllIlllI = 12;
                    break;
                }
            }
            for (final PotionEffect llllllllllllIIIIlllIIIIllllIllIl : PotionUtils.getEffectsFromStack(llllllllllllIIIIlllIIIIlllllIIIl)) {
                if (llllllllllllIIIIlllIIIIllllIllIl.getPotion() == Potion.getPotionById(llllllllllllIIIIlllIIIIllllIlllI)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public AutoPotion() {
        super("AutoPotion", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0431\u0440\u043e\u0441\u0430\u0435\u0442 \u0437\u0435\u043b\u044c\u044f \u043d\u0430\u0445\u043e\u0434\u044f\u0449\u0438\u0435\u0441\u044f \u0432 \u0445\u043e\u0442\u0431\u0430\u0440\u0435(\u0431\u044b\u0441\u0442\u0440\u044b\u0435 \u0441\u043b\u043e\u0442\u044b)", 0, Category.COMBAT);
        this.onlyGround = new BooleanSetting("Only Ground", true, () -> true);
        this.onlyKT = new BooleanSetting("KT Only", true, () -> true);
        this.delay = new NumberSetting("Delay", 500.0f, 0.0f, 600.0f, 10.0f, () -> true);
        this.addSettings(this.delay, this.onlyGround, this.onlyKT);
    }
    
    public void throwPot(final Potions llllllllllllIIIIlllIIIlIIIIIllII) {
        final int llllllllllllIIIIlllIIIlIIIIIlllI = this.getPotion(llllllllllllIIIIlllIIIlIIIIIllII);
        if (AutoPotion.mc.player.rotationPitchHead == 90.0f && AutoPotion.timerHelper.hasReached(this.delay.getNumberValue())) {
            if (this.onlyKT.getBoolValue()) {
                if (GuiBossOverlay.pot) {
                    AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(llllllllllllIIIIlllIIIlIIIIIlllI));
                    AutoPotion.mc.playerController.updateController();
                    AutoPotion.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    AutoPotion.mc.playerController.updateController();
                    AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(AutoPotion.mc.player.inventory.currentItem));
                    AutoPotion.timerHelper.reset();
                }
            }
            else {
                AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(llllllllllllIIIIlllIIIlIIIIIlllI));
                AutoPotion.mc.playerController.updateController();
                AutoPotion.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoPotion.mc.playerController.updateController();
                AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(AutoPotion.mc.player.inventory.currentItem));
                AutoPotion.timerHelper.reset();
            }
        }
    }
    
    public boolean isPotion(final Potions llllllllllllIIIIlllIIIIlllllllIl) {
        for (int llllllllllllIIIIlllIIIIlllllllII = 0; llllllllllllIIIIlllIIIIlllllllII < 9; ++llllllllllllIIIIlllIIIIlllllllII) {
            if (this.isStackPotion(AutoPotion.mc.player.inventory.getStackInSlot(llllllllllllIIIIlllIIIIlllllllII), llllllllllllIIIIlllIIIIlllllllIl)) {
                return true;
            }
        }
        return false;
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotionUpdate llllllllllllIIIIlllIIIlIIIIlIllI) {
        if (this.onlyKT.getBoolValue()) {
            if (GuiBossOverlay.pot) {
                if (this.onlyGround.getBoolValue() && !AutoPotion.mc.player.onGround) {
                    return;
                }
                if (!AutoPotion.mc.player.isPotionActive(Potion.getPotionById(1)) && this.isPotion(Potions.SPEED)) {
                    llllllllllllIIIIlllIIIlIIIIlIllI.setPitch(90.0f);
                    AutoPotion.mc.player.rotationPitchHead = 90.0f;
                    if (llllllllllllIIIIlllIIIlIIIIlIllI.getPitch() == 90.0f) {
                        this.throwPot(Potions.SPEED);
                    }
                }
                else if (!AutoPotion.mc.player.isPotionActive(Potion.getPotionById(5)) && this.isPotion(Potions.STRENGTH)) {
                    llllllllllllIIIIlllIIIlIIIIlIllI.setPitch(90.0f);
                    AutoPotion.mc.player.rotationPitchHead = 90.0f;
                    if (llllllllllllIIIIlllIIIlIIIIlIllI.getPitch() == 90.0f) {
                        this.throwPot(Potions.STRENGTH);
                    }
                }
                else if (!AutoPotion.mc.player.isPotionActive(Potion.getPotionById(12)) && this.isPotion(Potions.FIRERES)) {
                    llllllllllllIIIIlllIIIlIIIIlIllI.setPitch(90.0f);
                    AutoPotion.mc.player.rotationPitchHead = 90.0f;
                    if (llllllllllllIIIIlllIIIlIIIIlIllI.getPitch() == 90.0f) {
                        this.throwPot(Potions.FIRERES);
                    }
                }
            }
        }
        else {
            if (this.onlyGround.getBoolValue() && !AutoPotion.mc.player.onGround) {
                return;
            }
            if (!AutoPotion.mc.player.isPotionActive(Potion.getPotionById(12)) && this.isPotion(Potions.FIRERES)) {
                AutoPotion.mc.player.rotationPitchHead = 90.0f;
                llllllllllllIIIIlllIIIlIIIIlIllI.setPitch(90.0f);
                if (llllllllllllIIIIlllIIIlIIIIlIllI.getPitch() == 90.0f && AutoPotion.mc.player.rotationPitchHead == 90.0f) {
                    this.throwPot(Potions.FIRERES);
                }
            }
            else if (!AutoPotion.mc.player.isPotionActive(Potion.getPotionById(1)) && this.isPotion(Potions.SPEED)) {
                AutoPotion.mc.player.rotationPitchHead = 90.0f;
                llllllllllllIIIIlllIIIlIIIIlIllI.setPitch(90.0f);
                if (llllllllllllIIIIlllIIIlIIIIlIllI.getPitch() == 90.0f && AutoPotion.mc.player.rotationPitchHead == 90.0f) {
                    this.throwPot(Potions.SPEED);
                }
            }
            else if (!AutoPotion.mc.player.isPotionActive(Potion.getPotionById(5)) && this.isPotion(Potions.STRENGTH)) {
                AutoPotion.mc.player.rotationPitchHead = 90.0f;
                llllllllllllIIIIlllIIIlIIIIlIllI.setPitch(90.0f);
                if (llllllllllllIIIIlllIIIlIIIIlIllI.getPitch() == 90.0f && AutoPotion.mc.player.rotationPitchHead == 90.0f) {
                    this.throwPot(Potions.STRENGTH);
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions() {
        final int[] $switch_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions = AutoPotion.$SWITCH_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions;
        if ($switch_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions != null) {
            return $switch_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions;
        }
        final double llllllllllllIIIIlllIIIIllllIIlIl = (Object)new int[Potions.values().length];
        try {
            llllllllllllIIIIlllIIIIllllIIlIl[Potions.FIRERES.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIIlllIIIIllllIIlIl[Potions.SPEED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIIlllIIIIllllIIlIl[Potions.STRENGTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return AutoPotion.$SWITCH_TABLE$ru$rockstar$client$features$impl$combat$AutoPotion$Potions = (int[])(Object)llllllllllllIIIIlllIIIIllllIIlIl;
    }
    
    public int getPotion(final Potions llllllllllllIIIIlllIIIlIIIIIIllI) {
        for (int llllllllllllIIIIlllIIIlIIIIIIlIl = 0; llllllllllllIIIIlllIIIlIIIIIIlIl < 9; ++llllllllllllIIIIlllIIIlIIIIIIlIl) {
            if (this.isStackPotion(AutoPotion.mc.player.inventory.getStackInSlot(llllllllllllIIIIlllIIIlIIIIIIlIl), llllllllllllIIIIlllIIIlIIIIIIllI)) {
                return llllllllllllIIIIlllIIIlIIIIIIlIl;
            }
        }
        return -1;
    }
    
    public enum Potions
    {
        STRENGTH("STRENGTH", 0), 
        SPEED("SPEED", 1), 
        FIRERES("FIRERES", 2);
        
        private Potions(final String lllllllllllIlIlllllllllIIllllIll, final int lllllllllllIlIlllllllllIIllllIlI) {
        }
    }
}

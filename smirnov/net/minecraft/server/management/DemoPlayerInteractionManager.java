// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

public class DemoPlayerInteractionManager extends PlayerInteractionManager
{
    private /* synthetic */ boolean displayedIntro;
    private /* synthetic */ int demoEndedReminder;
    private /* synthetic */ int gameModeTicks;
    private /* synthetic */ boolean demoTimeExpired;
    
    @Override
    public void blockRemoving(final BlockPos lllllllllllIIIIllllllIllllIlIIlI) {
        if (!this.demoTimeExpired) {
            super.blockRemoving(lllllllllllIIIIllllllIllllIlIIlI);
        }
    }
    
    public DemoPlayerInteractionManager(final World lllllllllllIIIIllllllIlllllIlIll) {
        super(lllllllllllIIIIllllllIlllllIlIll);
    }
    
    @Override
    public EnumActionResult processRightClick(final EntityPlayer lllllllllllIIIIllllllIlllIlllllI, final World lllllllllllIIIIllllllIllllIIIIlI, final ItemStack lllllllllllIIIIllllllIllllIIIIIl, final EnumHand lllllllllllIIIIllllllIllllIIIIII) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
            return EnumActionResult.PASS;
        }
        return super.processRightClick(lllllllllllIIIIllllllIlllIlllllI, lllllllllllIIIIllllllIllllIIIIlI, lllllllllllIIIIllllllIllllIIIIIl, lllllllllllIIIIllllllIllllIIIIII);
    }
    
    @Override
    public boolean tryHarvestBlock(final BlockPos lllllllllllIIIIllllllIllllIIlIlI) {
        return !this.demoTimeExpired && super.tryHarvestBlock(lllllllllllIIIIllllllIllllIIlIlI);
    }
    
    @Override
    public EnumActionResult processRightClickBlock(final EntityPlayer lllllllllllIIIIllllllIlllIlIllll, final World lllllllllllIIIIllllllIlllIlIIlII, final ItemStack lllllllllllIIIIllllllIlllIlIIIll, final EnumHand lllllllllllIIIIllllllIlllIlIllII, final BlockPos lllllllllllIIIIllllllIlllIlIlIll, final EnumFacing lllllllllllIIIIllllllIlllIlIIIII, final float lllllllllllIIIIllllllIlllIIlllll, final float lllllllllllIIIIllllllIlllIIllllI, final float lllllllllllIIIIllllllIlllIlIIlll) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
            return EnumActionResult.PASS;
        }
        return super.processRightClickBlock(lllllllllllIIIIllllllIlllIlIllll, lllllllllllIIIIllllllIlllIlIIlII, lllllllllllIIIIllllllIlllIlIIIll, lllllllllllIIIIllllllIlllIlIllII, lllllllllllIIIIllllllIlllIlIlIll, lllllllllllIIIIllllllIlllIlIIIII, lllllllllllIIIIllllllIlllIIlllll, lllllllllllIIIIllllllIlllIIllllI, lllllllllllIIIIllllllIlllIlIIlll);
    }
    
    @Override
    public void onBlockClicked(final BlockPos lllllllllllIIIIllllllIllllIlIlll, final EnumFacing lllllllllllIIIIllllllIllllIllIIl) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
        }
        else {
            super.onBlockClicked(lllllllllllIIIIllllllIllllIlIlll, lllllllllllIIIIllllllIllllIllIIl);
        }
    }
    
    private void sendDemoReminder() {
        if (this.demoEndedReminder > 100) {
            this.thisPlayerMP.addChatMessage(new TextComponentTranslation("demo.reminder", new Object[0]));
            this.demoEndedReminder = 0;
        }
    }
    
    @Override
    public void updateBlockRemoving() {
        super.updateBlockRemoving();
        ++this.gameModeTicks;
        final long lllllllllllIIIIllllllIlllllIIllI = this.theWorld.getTotalWorldTime();
        final long lllllllllllIIIIllllllIlllllIIlIl = lllllllllllIIIIllllllIlllllIIllI / 24000L + 1L;
        if (!this.displayedIntro && this.gameModeTicks > 20) {
            this.displayedIntro = true;
            this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 0.0f));
        }
        this.demoTimeExpired = (lllllllllllIIIIllllllIlllllIIllI > 120500L);
        if (this.demoTimeExpired) {
            ++this.demoEndedReminder;
        }
        if (lllllllllllIIIIllllllIlllllIIllI % 24000L == 500L) {
            if (lllllllllllIIIIllllllIlllllIIlIl <= 6L) {
                this.thisPlayerMP.addChatMessage(new TextComponentTranslation("demo.day." + lllllllllllIIIIllllllIlllllIIlIl, new Object[0]));
            }
        }
        else if (lllllllllllIIIIllllllIlllllIIlIl == 1L) {
            if (lllllllllllIIIIllllllIlllllIIllI == 100L) {
                this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 101.0f));
            }
            else if (lllllllllllIIIIllllllIlllllIIllI == 175L) {
                this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 102.0f));
            }
            else if (lllllllllllIIIIllllllIlllllIIllI == 250L) {
                this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 103.0f));
            }
        }
        else if (lllllllllllIIIIllllllIlllllIIlIl == 5L && lllllllllllIIIIllllllIlllllIIllI % 24000L == 22000L) {
            this.thisPlayerMP.addChatMessage(new TextComponentTranslation("demo.day.warning", new Object[0]));
        }
    }
}

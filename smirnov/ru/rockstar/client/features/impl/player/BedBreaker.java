// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.player;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import ru.rockstar.api.utils.combat.RotationHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.Block;
import ru.rockstar.api.event.event.EventPreMotion;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.event.event.Event3D;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.ui.settings.impl.ListSetting;
import ru.rockstar.api.utils.world.TimerHelper;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.features.Feature;

public class BedBreaker extends Feature
{
    private final /* synthetic */ NumberSetting fuckerDelay;
    public static /* synthetic */ NumberSetting rad;
    private final /* synthetic */ TimerHelper timerUtils;
    private /* synthetic */ int blockid;
    private /* synthetic */ int yPos;
    private /* synthetic */ int zPos;
    private final /* synthetic */ ListSetting mode;
    private /* synthetic */ int xPos;
    /* synthetic */ Minecraft mc;
    
    @EventTarget
    public void onRender3D(final Event3D lllllllllllIIlIIlIIlIlllIIlIllIl) {
        final int lllllllllllIIlIIlIIlIlllIIlIllII = (int)this.mc.player.posX;
        final int lllllllllllIIlIIlIIlIlllIIlIlIll = (int)this.mc.player.posZ;
        for (int lllllllllllIIlIIlIIlIlllIIlIlIlI = (int)this.mc.player.posY, lllllllllllIIlIIlIIlIlllIIlIlIIl = (int)BedBreaker.rad.getNumberValue(), lllllllllllIIlIIlIIlIlllIIlIlIII = lllllllllllIIlIIlIIlIlllIIlIlIlI - lllllllllllIIlIIlIIlIlllIIlIlIIl; lllllllllllIIlIIlIIlIlllIIlIlIII <= lllllllllllIIlIIlIIlIlllIIlIlIlI + lllllllllllIIlIIlIIlIlllIIlIlIIl; ++lllllllllllIIlIIlIIlIlllIIlIlIII) {
            for (int lllllllllllIIlIIlIIlIlllIIlIIlll = lllllllllllIIlIIlIIlIlllIIlIllII - lllllllllllIIlIIlIIlIlllIIlIlIIl; lllllllllllIIlIIlIIlIlllIIlIIlll <= lllllllllllIIlIIlIIlIlllIIlIllII + lllllllllllIIlIIlIIlIlllIIlIlIIl; ++lllllllllllIIlIIlIIlIlllIIlIIlll) {
                for (int lllllllllllIIlIIlIIlIlllIIlIIllI = lllllllllllIIlIIlIIlIlllIIlIlIll - lllllllllllIIlIIlIIlIlllIIlIlIIl; lllllllllllIIlIIlIIlIlllIIlIIllI <= lllllllllllIIlIIlIIlIlllIIlIlIll + lllllllllllIIlIIlIIlIlllIIlIlIIl; ++lllllllllllIIlIIlIIlIlllIIlIIllI) {
                    final BlockPos lllllllllllIIlIIlIIlIlllIIlIIlIl = new BlockPos(lllllllllllIIlIIlIIlIlllIIlIIlll, lllllllllllIIlIIlIIlIlllIIlIlIII, lllllllllllIIlIIlIIlIlllIIlIIllI);
                    if (this.mc.world.getBlockState(lllllllllllIIlIIlIIlIlllIIlIIlIl).getBlock() == Blocks.BED && lllllllllllIIlIIlIIlIlllIIlIIlIl != null && this.mc.world.getBlockState(lllllllllllIIlIIlIIlIlllIIlIIlIl).getBlock() != Blocks.AIR) {
                        DrawHelper.blockEsp(lllllllllllIIlIIlIIlIlllIIlIIlIl, Color.RED, true);
                    }
                }
            }
        }
    }
    
    @EventTarget
    public void onPreMotion(final EventPreMotion lllllllllllIIlIIlIIlIlllIlIIlIIl) {
        final float lllllllllllIIlIIlIIlIlllIlIIlIII = BedBreaker.rad.getNumberValue();
        for (int lllllllllllIIlIIlIIlIlllIlIIIlll = (int)(-lllllllllllIIlIIlIIlIlllIlIIlIII); lllllllllllIIlIIlIIlIlllIlIIIlll < lllllllllllIIlIIlIIlIlllIlIIlIII; ++lllllllllllIIlIIlIIlIlllIlIIIlll) {
            for (int lllllllllllIIlIIlIIlIlllIlIIIllI = (int)lllllllllllIIlIIlIIlIlllIlIIlIII; lllllllllllIIlIIlIIlIlllIlIIIllI > -lllllllllllIIlIIlIIlIlllIlIIlIII; --lllllllllllIIlIIlIIlIlllIlIIIllI) {
                for (int lllllllllllIIlIIlIIlIlllIlIIIlIl = (int)(-lllllllllllIIlIIlIIlIlllIlIIlIII); lllllllllllIIlIIlIIlIlllIlIIIlIl < lllllllllllIIlIIlIIlIlllIlIIlIII; ++lllllllllllIIlIIlIIlIlllIlIIIlIl) {
                    this.xPos = (int)this.mc.player.posX + lllllllllllIIlIIlIIlIlllIlIIIlll;
                    this.yPos = (int)this.mc.player.posY + lllllllllllIIlIIlIIlIlllIlIIIllI;
                    this.zPos = (int)this.mc.player.posZ + lllllllllllIIlIIlIIlIlllIlIIIlIl;
                    final BlockPos lllllllllllIIlIIlIIlIlllIlIIIlII = new BlockPos(this.xPos, this.yPos, this.zPos);
                    final Block lllllllllllIIlIIlIIlIlllIlIIIIll = this.mc.world.getBlockState(lllllllllllIIlIIlIIlIlllIlIIIlII).getBlock();
                    final short lllllllllllIIlIIlIIlIlllIIlllIIl;
                    switch (((String)(lllllllllllIIlIIlIIlIlllIIlllIIl = (short)this.mode.getOptions())).hashCode()) {
                        case 66657: {
                            if (!((String)lllllllllllIIlIIlIIlIlllIIlllIIl).equals("Bed")) {
                                break;
                            }
                            this.blockid = 26;
                            break;
                        }
                        case 2092632: {
                            if (!((String)lllllllllllIIlIIlIIlIlllIIlllIIl).equals("Cake")) {
                                break;
                            }
                            this.blockid = 354;
                            break;
                        }
                    }
                    if (Block.getIdFromBlock(lllllllllllIIlIIlIIlIlllIlIIIIll) == this.blockid) {
                        if (lllllllllllIIlIIlIIlIlllIlIIIIll != null || lllllllllllIIlIIlIIlIlllIlIIIlII != null) {
                            final float[] lllllllllllIIlIIlIIlIlllIlIIIIlI = RotationHelper.getRotationVector(new Vec3d(lllllllllllIIlIIlIIlIlllIlIIIlII.getX() + 0.5f, lllllllllllIIlIIlIIlIlllIlIIIlII.getY() + 0.5f, lllllllllllIIlIIlIIlIlllIlIIIlII.getZ() + 0.5f), true, 2.0f, 2.0f, 360.0f);
                            lllllllllllIIlIIlIIlIlllIlIIlIIl.setYaw(lllllllllllIIlIIlIIlIlllIlIIIIlI[0]);
                            lllllllllllIIlIIlIIlIlllIlIIlIIl.setPitch(lllllllllllIIlIIlIIlIlllIlIIIIlI[1]);
                            this.mc.player.renderYawOffset = lllllllllllIIlIIlIIlIlllIlIIIIlI[0];
                            this.mc.player.rotationYawHead = lllllllllllIIlIIlIIlIlllIlIIIIlI[0];
                            this.mc.player.rotationPitchHead = lllllllllllIIlIIlIIlIlllIlIIIIlI[1];
                            this.mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(lllllllllllIIlIIlIIlIlllIlIIIlII, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                            if (this.timerUtils.hasReached(this.fuckerDelay.getNumberValue())) {
                                this.mc.player.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(lllllllllllIIlIIlIIlIlllIlIIIlII, EnumFacing.UP, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
                                this.mc.player.swingArm(EnumHand.MAIN_HAND);
                                this.timerUtils.reset();
                            }
                        }
                    }
                }
            }
        }
    }
    
    public BedBreaker() {
        super("BedBreaker", "\u0410\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0440\u0443\u0448\u0438\u0442 \u043a\u0440\u043e\u0432\u0430\u0442\u0438 \u0438 \u0442\u043e\u0440\u0442\u044b \u0441\u043a\u0432\u043e\u0437\u044c \u0431\u043b\u043e\u043a\u0438", 0, Category.PLAYER);
        this.timerUtils = new TimerHelper();
        this.mc = Minecraft.getMinecraft();
        this.mode = new ListSetting("Block", "Bed", () -> true, new String[] { "Bed", "Cake" });
        BedBreaker.rad = new NumberSetting("Fucker Radius", 4.0f, 1.0f, 6.0f, 0.5f, () -> true);
        this.fuckerDelay = new NumberSetting("Fucker Delay", 100.0f, 0.0f, 1000.0f, 50.0f, () -> true);
        this.addSettings(this.mode, BedBreaker.rad, this.fuckerDelay);
    }
}

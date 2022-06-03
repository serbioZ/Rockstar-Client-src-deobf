// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.world.BossInfo;

public class BossInfoClient extends BossInfo
{
    protected /* synthetic */ long percentSetTime;
    protected /* synthetic */ float rawPercent;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = BossInfoClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        }
        final char lllllllllllIIIIllIllIlIllIIIIlIl = (Object)new int[SPacketUpdateBossInfo.Operation.values().length];
        try {
            lllllllllllIIIIllIllIlIllIIIIlIl[SPacketUpdateBossInfo.Operation.ADD.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIIIllIllIlIllIIIIlIl[SPacketUpdateBossInfo.Operation.REMOVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIIIllIllIlIllIIIIlIl[SPacketUpdateBossInfo.Operation.UPDATE_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIIIllIllIlIllIIIIlIl[SPacketUpdateBossInfo.Operation.UPDATE_PCT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIIIllIllIlIllIIIIlIl[SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIIIllIllIlIllIIIIlIl[SPacketUpdateBossInfo.Operation.UPDATE_STYLE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BossInfoClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = (int[])(Object)lllllllllllIIIIllIllIlIllIIIIlIl;
    }
    
    @Override
    public void setPercent(final float lllllllllllIIIIllIllIlIllIIlIllI) {
        this.percent = this.getPercent();
        this.rawPercent = lllllllllllIIIIllIllIlIllIIlIllI;
        this.percentSetTime = Minecraft.getSystemTime();
    }
    
    @Override
    public float getPercent() {
        final long lllllllllllIIIIllIllIlIllIIlIIIl = Minecraft.getSystemTime() - this.percentSetTime;
        final float lllllllllllIIIIllIllIlIllIIlIIII = MathHelper.clamp(lllllllllllIIIIllIllIlIllIIlIIIl / 100.0f, 0.0f, 1.0f);
        return this.percent + (this.rawPercent - this.percent) * lllllllllllIIIIllIllIlIllIIlIIII;
    }
    
    public BossInfoClient(final SPacketUpdateBossInfo lllllllllllIIIIllIllIlIllIIllllI) {
        super(lllllllllllIIIIllIllIlIllIIllllI.getUniqueId(), lllllllllllIIIIllIllIlIllIIllllI.getName(), lllllllllllIIIIllIllIlIllIIllllI.getColor(), lllllllllllIIIIllIllIlIllIIllllI.getOverlay());
        this.rawPercent = lllllllllllIIIIllIllIlIllIIllllI.getPercent();
        this.percent = lllllllllllIIIIllIllIlIllIIllllI.getPercent();
        this.percentSetTime = Minecraft.getSystemTime();
        this.setDarkenSky(lllllllllllIIIIllIllIlIllIIllllI.shouldDarkenSky());
        this.setPlayEndBossMusic(lllllllllllIIIIllIllIlIllIIllllI.shouldPlayEndBossMusic());
        this.setCreateFog(lllllllllllIIIIllIllIlIllIIllllI.shouldCreateFog());
    }
    
    public void updateFromPacket(final SPacketUpdateBossInfo lllllllllllIIIIllIllIlIllIIIIlll) {
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation()[lllllllllllIIIIllIllIlIllIIIIlll.getOperation().ordinal()]) {
            case 4: {
                this.setName(lllllllllllIIIIllIllIlIllIIIIlll.getName());
                break;
            }
            case 3: {
                this.setPercent(lllllllllllIIIIllIllIlIllIIIIlll.getPercent());
                break;
            }
            case 5: {
                this.setColor(lllllllllllIIIIllIllIlIllIIIIlll.getColor());
                this.setOverlay(lllllllllllIIIIllIllIlIllIIIIlll.getOverlay());
                break;
            }
            case 6: {
                this.setDarkenSky(lllllllllllIIIIllIllIlIllIIIIlll.shouldDarkenSky());
                this.setPlayEndBossMusic(lllllllllllIIIIllIllIlIllIIIIlll.shouldPlayEndBossMusic());
                break;
            }
        }
    }
}

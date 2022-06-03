// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.SoundCategory;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundEvent;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class ServerWorldEventHandler implements IWorldEventListener
{
    private final /* synthetic */ WorldServer theWorldServer;
    private final /* synthetic */ MinecraftServer mcServer;
    
    @Override
    public void playEvent(final EntityPlayer lllllllllllIIIIIIIIllIIIIlIlIIII, final int lllllllllllIIIIIIIIllIIIIlIIlIlI, final BlockPos lllllllllllIIIIIIIIllIIIIlIIlllI, final int lllllllllllIIIIIIIIllIIIIlIIlIII) {
        this.mcServer.getPlayerList().sendToAllNearExcept(lllllllllllIIIIIIIIllIIIIlIlIIII, lllllllllllIIIIIIIIllIIIIlIIlllI.getX(), lllllllllllIIIIIIIIllIIIIlIIlllI.getY(), lllllllllllIIIIIIIIllIIIIlIIlllI.getZ(), 64.0, this.theWorldServer.provider.getDimensionType().getId(), new SPacketEffect(lllllllllllIIIIIIIIllIIIIlIIlIlI, lllllllllllIIIIIIIIllIIIIlIIlllI, lllllllllllIIIIIIIIllIIIIlIIlIII, false));
    }
    
    @Override
    public void func_190570_a(final int lllllllllllIIIIIIIIllIIIlIIlllIl, final boolean lllllllllllIIIIIIIIllIIIlIIlllII, final boolean lllllllllllIIIIIIIIllIIIlIIllIll, final double lllllllllllIIIIIIIIllIIIlIIllIlI, final double lllllllllllIIIIIIIIllIIIlIIllIIl, final double lllllllllllIIIIIIIIllIIIlIIllIII, final double lllllllllllIIIIIIIIllIIIlIIlIlll, final double lllllllllllIIIIIIIIllIIIlIIlIllI, final double lllllllllllIIIIIIIIllIIIlIIlIlIl, final int... lllllllllllIIIIIIIIllIIIlIIlIlII) {
    }
    
    @Override
    public void notifyLightSet(final BlockPos lllllllllllIIIIIIIIllIIIIlIllIlI) {
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int lllllllllllIIIIIIIIllIIIIllIlIll, final int lllllllllllIIIIIIIIllIIIIllIlIlI, final int lllllllllllIIIIIIIIllIIIIllIlIIl, final int lllllllllllIIIIIIIIllIIIIllIlIII, final int lllllllllllIIIIIIIIllIIIIllIIlll, final int lllllllllllIIIIIIIIllIIIIllIIllI) {
    }
    
    public ServerWorldEventHandler(final MinecraftServer lllllllllllIIIIIIIIllIIIlIlIlIlI, final WorldServer lllllllllllIIIIIIIIllIIIlIlIllII) {
        this.mcServer = lllllllllllIIIIIIIIllIIIlIlIlIlI;
        this.theWorldServer = lllllllllllIIIIIIIIllIIIlIlIllII;
    }
    
    @Override
    public void playRecord(final SoundEvent lllllllllllIIIIIIIIllIIIIlIllIII, final BlockPos lllllllllllIIIIIIIIllIIIIlIlIlll) {
    }
    
    @Override
    public void onEntityRemoved(final Entity lllllllllllIIIIIIIIllIIIlIIIlIII) {
        this.theWorldServer.getEntityTracker().untrackEntity(lllllllllllIIIIIIIIllIIIlIIIlIII);
        this.theWorldServer.getScoreboard().removeEntity(lllllllllllIIIIIIIIllIIIlIIIlIII);
        if (lllllllllllIIIIIIIIllIIIlIIIlIII instanceof EntityPlayerMP) {
            this.theWorldServer.provider.onPlayerRemoved((EntityPlayerMP)lllllllllllIIIIIIIIllIIIlIIIlIII);
        }
    }
    
    @Override
    public void broadcastSound(final int lllllllllllIIIIIIIIllIIIIIlllllI, final BlockPos lllllllllllIIIIIIIIllIIIIIllllIl, final int lllllllllllIIIIIIIIllIIIIIllllII) {
        this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketEffect(lllllllllllIIIIIIIIllIIIIIlllllI, lllllllllllIIIIIIIIllIIIIIllllIl, lllllllllllIIIIIIIIllIIIIIllllII, true));
    }
    
    @Override
    public void sendBlockBreakProgress(final int lllllllllllIIIIIIIIllIIIIIlIlIIl, final BlockPos lllllllllllIIIIIIIIllIIIIIlIlIII, final int lllllllllllIIIIIIIIllIIIIIlIIlll) {
        for (final EntityPlayerMP lllllllllllIIIIIIIIllIIIIIlIlllI : this.mcServer.getPlayerList().getPlayerList()) {
            if (lllllllllllIIIIIIIIllIIIIIlIlllI != null && lllllllllllIIIIIIIIllIIIIIlIlllI.world == this.theWorldServer && lllllllllllIIIIIIIIllIIIIIlIlllI.getEntityId() != lllllllllllIIIIIIIIllIIIIIlIlIIl) {
                final double lllllllllllIIIIIIIIllIIIIIlIllIl = lllllllllllIIIIIIIIllIIIIIlIlIII.getX() - lllllllllllIIIIIIIIllIIIIIlIlllI.posX;
                final double lllllllllllIIIIIIIIllIIIIIlIllII = lllllllllllIIIIIIIIllIIIIIlIlIII.getY() - lllllllllllIIIIIIIIllIIIIIlIlllI.posY;
                final double lllllllllllIIIIIIIIllIIIIIlIlIll = lllllllllllIIIIIIIIllIIIIIlIlIII.getZ() - lllllllllllIIIIIIIIllIIIIIlIlllI.posZ;
                if (lllllllllllIIIIIIIIllIIIIIlIllIl * lllllllllllIIIIIIIIllIIIIIlIllIl + lllllllllllIIIIIIIIllIIIIIlIllII * lllllllllllIIIIIIIIllIIIIIlIllII + lllllllllllIIIIIIIIllIIIIIlIlIll * lllllllllllIIIIIIIIllIIIIIlIlIll >= 1024.0) {
                    continue;
                }
                lllllllllllIIIIIIIIllIIIIIlIlllI.connection.sendPacket(new SPacketBlockBreakAnim(lllllllllllIIIIIIIIllIIIIIlIlIIl, lllllllllllIIIIIIIIllIIIIIlIlIII, lllllllllllIIIIIIIIllIIIIIlIIlll));
            }
        }
    }
    
    @Override
    public void notifyBlockUpdate(final World lllllllllllIIIIIIIIllIIIIllIIIlI, final BlockPos lllllllllllIIIIIIIIllIIIIllIIIIl, final IBlockState lllllllllllIIIIIIIIllIIIIllIIIII, final IBlockState lllllllllllIIIIIIIIllIIIIlIlllll, final int lllllllllllIIIIIIIIllIIIIlIllllI) {
        this.theWorldServer.getPlayerChunkMap().markBlockForUpdate(lllllllllllIIIIIIIIllIIIIllIIIIl);
    }
    
    @Override
    public void onEntityAdded(final Entity lllllllllllIIIIIIIIllIIIlIIlIIII) {
        this.theWorldServer.getEntityTracker().trackEntity(lllllllllllIIIIIIIIllIIIlIIlIIII);
        if (lllllllllllIIIIIIIIllIIIlIIlIIII instanceof EntityPlayerMP) {
            this.theWorldServer.provider.onPlayerAdded((EntityPlayerMP)lllllllllllIIIIIIIIllIIIlIIlIIII);
        }
    }
    
    @Override
    public void playSoundToAllNearExcept(@Nullable final EntityPlayer lllllllllllIIIIIIIIllIIIIlllIlII, final SoundEvent lllllllllllIIIIIIIIllIIIIlllllII, final SoundCategory lllllllllllIIIIIIIIllIIIIllllIll, final double lllllllllllIIIIIIIIllIIIIlllIIIl, final double lllllllllllIIIIIIIIllIIIIlllIIII, final double lllllllllllIIIIIIIIllIIIIllllIII, final float lllllllllllIIIIIIIIllIIIIlllIlll, final float lllllllllllIIIIIIIIllIIIIlllIllI) {
        this.mcServer.getPlayerList().sendToAllNearExcept(lllllllllllIIIIIIIIllIIIIlllIlII, lllllllllllIIIIIIIIllIIIIlllIIIl, lllllllllllIIIIIIIIllIIIIlllIIII, lllllllllllIIIIIIIIllIIIIllllIII, (lllllllllllIIIIIIIIllIIIIlllIlll > 1.0f) ? ((double)(16.0f * lllllllllllIIIIIIIIllIIIIlllIlll)) : 16.0, this.theWorldServer.provider.getDimensionType().getId(), new SPacketSoundEffect(lllllllllllIIIIIIIIllIIIIlllllII, lllllllllllIIIIIIIIllIIIIllllIll, lllllllllllIIIIIIIIllIIIIlllIIIl, lllllllllllIIIIIIIIllIIIIlllIIII, lllllllllllIIIIIIIIllIIIIllllIII, lllllllllllIIIIIIIIllIIIIlllIlll, lllllllllllIIIIIIIIllIIIIlllIllI));
    }
    
    @Override
    public void spawnParticle(final int lllllllllllIIIIIIIIllIIIlIlIIlll, final boolean lllllllllllIIIIIIIIllIIIlIlIIllI, final double lllllllllllIIIIIIIIllIIIlIlIIlIl, final double lllllllllllIIIIIIIIllIIIlIlIIlII, final double lllllllllllIIIIIIIIllIIIlIlIIIll, final double lllllllllllIIIIIIIIllIIIlIlIIIlI, final double lllllllllllIIIIIIIIllIIIlIlIIIIl, final double lllllllllllIIIIIIIIllIIIlIlIIIII, final int... lllllllllllIIIIIIIIllIIIlIIlllll) {
    }
}

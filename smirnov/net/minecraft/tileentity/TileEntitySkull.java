// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import java.util.UUID;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.Rotation;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import javax.annotation.Nullable;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockSkull;
import net.minecraft.util.Mirror;
import net.minecraft.nbt.NBTTagCompound;
import com.google.common.collect.Iterables;
import com.mojang.authlib.properties.Property;
import net.minecraft.util.StringUtils;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.management.PlayerProfileCache;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import net.minecraft.util.ITickable;

public class TileEntitySkull extends TileEntity implements ITickable
{
    private /* synthetic */ boolean dragonAnimated;
    private static /* synthetic */ MinecraftSessionService sessionService;
    private static /* synthetic */ PlayerProfileCache profileCache;
    private /* synthetic */ int dragonAnimatedTicks;
    private /* synthetic */ int skullRotation;
    private /* synthetic */ int skullType;
    private /* synthetic */ GameProfile playerProfile;
    
    public static GameProfile updateGameprofile(final GameProfile lllllllllllIIIIIIlIIIIlllIllIIII) {
        if (lllllllllllIIIIIIlIIIIlllIllIIII == null || StringUtils.isNullOrEmpty(lllllllllllIIIIIIlIIIIlllIllIIII.getName())) {
            return lllllllllllIIIIIIlIIIIlllIllIIII;
        }
        if (lllllllllllIIIIIIlIIIIlllIllIIII.isComplete() && lllllllllllIIIIIIlIIIIlllIllIIII.getProperties().containsKey((Object)"textures")) {
            return lllllllllllIIIIIIlIIIIlllIllIIII;
        }
        if (TileEntitySkull.profileCache == null || TileEntitySkull.sessionService == null) {
            return lllllllllllIIIIIIlIIIIlllIllIIII;
        }
        GameProfile lllllllllllIIIIIIlIIIIlllIlIllll = TileEntitySkull.profileCache.getGameProfileForUsername(lllllllllllIIIIIIlIIIIlllIllIIII.getName());
        if (lllllllllllIIIIIIlIIIIlllIlIllll == null) {
            return lllllllllllIIIIIIlIIIIlllIllIIII;
        }
        final Property lllllllllllIIIIIIlIIIIlllIlIlllI = (Property)Iterables.getFirst((Iterable)lllllllllllIIIIIIlIIIIlllIlIllll.getProperties().get((Object)"textures"), (Object)null);
        if (lllllllllllIIIIIIlIIIIlllIlIlllI == null) {
            lllllllllllIIIIIIlIIIIlllIlIllll = TileEntitySkull.sessionService.fillProfileProperties(lllllllllllIIIIIIlIIIIlllIlIllll, true);
        }
        return lllllllllllIIIIIIlIIIIlllIlIllll;
    }
    
    public int getSkullType() {
        return this.skullType;
    }
    
    private void updatePlayerProfile() {
        this.playerProfile = updateGameprofile(this.playerProfile);
        this.markDirty();
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    @Override
    public void mirror(final Mirror lllllllllllIIIIIIlIIIIlllIIllIll) {
        if (this.world != null && this.world.getBlockState(this.getPos()).getValue((IProperty<Comparable>)BlockSkull.FACING) == EnumFacing.UP) {
            this.skullRotation = lllllllllllIIIIIIlIIIIlllIIllIll.mirrorRotation(this.skullRotation, 16);
        }
    }
    
    @Override
    public void update() {
        if (this.skullType == 5) {
            if (this.world.isBlockPowered(this.pos)) {
                this.dragonAnimated = true;
                ++this.dragonAnimatedTicks;
            }
            else {
                this.dragonAnimated = false;
            }
        }
    }
    
    @Nullable
    public GameProfile getPlayerProfile() {
        return this.playerProfile;
    }
    
    public void setPlayerProfile(@Nullable final GameProfile lllllllllllIIIIIIlIIIIlllIllIlll) {
        this.skullType = 3;
        this.playerProfile = lllllllllllIIIIIIlIIIIlllIllIlll;
        this.updatePlayerProfile();
    }
    
    public static void setProfileCache(final PlayerProfileCache lllllllllllIIIIIIlIIIIlllllIlIlI) {
        TileEntitySkull.profileCache = lllllllllllIIIIIIlIIIIlllllIlIlI;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 4, this.getUpdateTag());
    }
    
    @Override
    public void rotate(final Rotation lllllllllllIIIIIIlIIIIlllIIlIlIl) {
        if (this.world != null && this.world.getBlockState(this.getPos()).getValue((IProperty<Comparable>)BlockSkull.FACING) == EnumFacing.UP) {
            this.skullRotation = lllllllllllIIIIIIlIIIIlllIIlIlIl.rotate(this.skullRotation, 16);
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIIIIIIlIIIIlllllIIIlI) {
        super.writeToNBT(lllllllllllIIIIIIlIIIIlllllIIIlI);
        lllllllllllIIIIIIlIIIIlllllIIIlI.setByte("SkullType", (byte)(this.skullType & 0xFF));
        lllllllllllIIIIIIlIIIIlllllIIIlI.setByte("Rot", (byte)(this.skullRotation & 0xFF));
        if (this.playerProfile != null) {
            final NBTTagCompound lllllllllllIIIIIIlIIIIlllllIIIIl = new NBTTagCompound();
            NBTUtil.writeGameProfile(lllllllllllIIIIIIlIIIIlllllIIIIl, this.playerProfile);
            lllllllllllIIIIIIlIIIIlllllIIIlI.setTag("Owner", lllllllllllIIIIIIlIIIIlllllIIIIl);
        }
        return lllllllllllIIIIIIlIIIIlllllIIIlI;
    }
    
    public void setSkullRotation(final int lllllllllllIIIIIIlIIIIlllIIlllll) {
        this.skullRotation = lllllllllllIIIIIIlIIIIlllIIlllll;
    }
    
    public void setType(final int lllllllllllIIIIIIlIIIIlllIllllll) {
        this.skullType = lllllllllllIIIIIIlIIIIlllIllllll;
        this.playerProfile = null;
    }
    
    public float getAnimationProgress(final float lllllllllllIIIIIIlIIIIllllIIlllI) {
        return this.dragonAnimated ? (this.dragonAnimatedTicks + lllllllllllIIIIIIlIIIIllllIIlllI) : ((float)this.dragonAnimatedTicks);
    }
    
    public static void setSessionService(final MinecraftSessionService lllllllllllIIIIIIlIIIIlllllIIlll) {
        TileEntitySkull.sessionService = lllllllllllIIIIIIlIIIIlllllIIlll;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIIIIIIlIIIIllllIlIllI) {
        super.readFromNBT(lllllllllllIIIIIIlIIIIllllIlIllI);
        this.skullType = lllllllllllIIIIIIlIIIIllllIlIllI.getByte("SkullType");
        this.skullRotation = lllllllllllIIIIIIlIIIIllllIlIllI.getByte("Rot");
        if (this.skullType == 3) {
            if (lllllllllllIIIIIIlIIIIllllIlIllI.hasKey("Owner", 10)) {
                this.playerProfile = NBTUtil.readGameProfileFromNBT(lllllllllllIIIIIIlIIIIllllIlIllI.getCompoundTag("Owner"));
            }
            else if (lllllllllllIIIIIIlIIIIllllIlIllI.hasKey("ExtraType", 8)) {
                final String lllllllllllIIIIIIlIIIIllllIllIII = lllllllllllIIIIIIlIIIIllllIlIllI.getString("ExtraType");
                if (!StringUtils.isNullOrEmpty(lllllllllllIIIIIIlIIIIllllIllIII)) {
                    this.playerProfile = new GameProfile((UUID)null, lllllllllllIIIIIIlIIIIllllIllIII);
                    this.updatePlayerProfile();
                }
            }
        }
    }
    
    public int getSkullRotation() {
        return this.skullRotation;
    }
}

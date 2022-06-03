// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.network.play.server.SPacketMaps;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.math.MathHelper;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.network.Packet;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Map;

public class MapData extends WorldSavedData
{
    public /* synthetic */ int xCenter;
    public /* synthetic */ int zCenter;
    public /* synthetic */ byte[] colors;
    private final /* synthetic */ Map<EntityPlayer, MapInfo> playersHashMap;
    public /* synthetic */ Map<String, MapDecoration> mapDecorations;
    public /* synthetic */ List<MapInfo> playersArrayList;
    public /* synthetic */ byte dimension;
    public /* synthetic */ byte scale;
    public /* synthetic */ boolean trackingPosition;
    public /* synthetic */ boolean field_191096_f;
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIllIlIlIllIlIIIlllIIl) {
        lllllllllllIllIlIlIllIlIIIlllIIl.setByte("dimension", this.dimension);
        lllllllllllIllIlIlIllIlIIIlllIIl.setInteger("xCenter", this.xCenter);
        lllllllllllIllIlIlIllIlIIIlllIIl.setInteger("zCenter", this.zCenter);
        lllllllllllIllIlIlIllIlIIIlllIIl.setByte("scale", this.scale);
        lllllllllllIllIlIlIllIlIIIlllIIl.setShort("width", (short)128);
        lllllllllllIllIlIlIllIlIIIlllIIl.setShort("height", (short)128);
        lllllllllllIllIlIlIllIlIIIlllIIl.setByteArray("colors", this.colors);
        lllllllllllIllIlIlIllIlIIIlllIIl.setBoolean("trackingPosition", this.trackingPosition);
        lllllllllllIllIlIlIllIlIIIlllIIl.setBoolean("unlimitedTracking", this.field_191096_f);
        return lllllllllllIllIlIlIllIlIIIlllIIl;
    }
    
    @Nullable
    public Packet<?> getMapPacket(final ItemStack lllllllllllIllIlIlIllIIlllIlIlIl, final World lllllllllllIllIlIlIllIIlllIlIlII, final EntityPlayer lllllllllllIllIlIlIllIIlllIlIIll) {
        final MapInfo lllllllllllIllIlIlIllIIlllIlIIlI = this.playersHashMap.get(lllllllllllIllIlIlIllIIlllIlIIll);
        return (lllllllllllIllIlIlIllIIlllIlIIlI == null) ? null : lllllllllllIllIlIlIllIIlllIlIIlI.getPacket(lllllllllllIllIlIlIllIIlllIlIlIl);
    }
    
    public static void func_191094_a(final ItemStack lllllllllllIllIlIlIllIlIIIIllIII, final BlockPos lllllllllllIllIlIlIllIlIIIIlIlll, final String lllllllllllIllIlIlIllIlIIIIIlllI, final MapDecoration.Type lllllllllllIllIlIlIllIlIIIIIllIl) {
        NBTTagList lllllllllllIllIlIlIllIlIIIIlIIll = null;
        if (lllllllllllIllIlIlIllIlIIIIllIII.hasTagCompound() && lllllllllllIllIlIlIllIlIIIIllIII.getTagCompound().hasKey("Decorations", 9)) {
            final NBTTagList lllllllllllIllIlIlIllIlIIIIlIlII = lllllllllllIllIlIlIllIlIIIIllIII.getTagCompound().getTagList("Decorations", 10);
        }
        else {
            lllllllllllIllIlIlIllIlIIIIlIIll = new NBTTagList();
            lllllllllllIllIlIlIllIlIIIIllIII.setTagInfo("Decorations", lllllllllllIllIlIlIllIlIIIIlIIll);
        }
        final NBTTagCompound lllllllllllIllIlIlIllIlIIIIlIIlI = new NBTTagCompound();
        lllllllllllIllIlIlIllIlIIIIlIIlI.setByte("type", lllllllllllIllIlIlIllIlIIIIIllIl.func_191163_a());
        lllllllllllIllIlIlIllIlIIIIlIIlI.setString("id", lllllllllllIllIlIlIllIlIIIIIlllI);
        lllllllllllIllIlIlIllIlIIIIlIIlI.setDouble("x", lllllllllllIllIlIlIllIlIIIIlIlll.getX());
        lllllllllllIllIlIlIllIlIIIIlIIlI.setDouble("z", lllllllllllIllIlIlIllIlIIIIlIlll.getZ());
        lllllllllllIllIlIlIllIlIIIIlIIlI.setDouble("rot", 180.0);
        lllllllllllIllIlIlIllIlIIIIlIIll.appendTag(lllllllllllIllIlIlIllIlIIIIlIIlI);
        if (lllllllllllIllIlIlIllIlIIIIIllIl.func_191162_c()) {
            final NBTTagCompound lllllllllllIllIlIlIllIlIIIIlIIIl = lllllllllllIllIlIlIllIlIIIIllIII.func_190925_c("display");
            lllllllllllIllIlIlIllIlIIIIlIIIl.setInteger("MapColor", lllllllllllIllIlIlIllIlIIIIIllIl.func_191161_d());
        }
    }
    
    public void calculateMapCenter(final double lllllllllllIllIlIlIllIlIIllIlIlI, final double lllllllllllIllIlIlIllIlIIllIIIlI, final int lllllllllllIllIlIlIllIlIIllIIIIl) {
        final int lllllllllllIllIlIlIllIlIIllIIlll = 128 * (1 << lllllllllllIllIlIlIllIlIIllIIIIl);
        final int lllllllllllIllIlIlIllIlIIllIIllI = MathHelper.floor((lllllllllllIllIlIlIllIlIIllIlIlI + 64.0) / lllllllllllIllIlIlIllIlIIllIIlll);
        final int lllllllllllIllIlIlIllIlIIllIIlIl = MathHelper.floor((lllllllllllIllIlIlIllIlIIllIIIlI + 64.0) / lllllllllllIllIlIlIllIlIIllIIlll);
        this.xCenter = lllllllllllIllIlIlIllIlIIllIIllI * lllllllllllIllIlIlIllIlIIllIIlll + lllllllllllIllIlIlIllIlIIllIIlll / 2 - 64;
        this.zCenter = lllllllllllIllIlIlIllIlIIllIIlIl * lllllllllllIllIlIlIllIlIIllIIlll + lllllllllllIllIlIlIllIlIIllIIlll / 2 - 64;
    }
    
    public void updateVisiblePlayers(final EntityPlayer lllllllllllIllIlIlIllIlIIIlIllll, final ItemStack lllllllllllIllIlIlIllIlIIIlIIIll) {
        if (!this.playersHashMap.containsKey(lllllllllllIllIlIlIllIlIIIlIllll)) {
            final MapInfo lllllllllllIllIlIlIllIlIIIlIllIl = new MapInfo(lllllllllllIllIlIlIllIlIIIlIllll);
            this.playersHashMap.put(lllllllllllIllIlIlIllIlIIIlIllll, lllllllllllIllIlIlIllIlIIIlIllIl);
            this.playersArrayList.add(lllllllllllIllIlIlIllIlIIIlIllIl);
        }
        if (!lllllllllllIllIlIlIllIlIIIlIllll.inventory.hasItemStack(lllllllllllIllIlIlIllIlIIIlIIIll)) {
            this.mapDecorations.remove(lllllllllllIllIlIlIllIlIIIlIllll.getName());
        }
        for (int lllllllllllIllIlIlIllIlIIIlIllII = 0; lllllllllllIllIlIlIllIlIIIlIllII < this.playersArrayList.size(); ++lllllllllllIllIlIlIllIlIIIlIllII) {
            final MapInfo lllllllllllIllIlIlIllIlIIIlIlIll = this.playersArrayList.get(lllllllllllIllIlIlIllIlIIIlIllII);
            if (!lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.isDead && (lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.inventory.hasItemStack(lllllllllllIllIlIlIllIlIIIlIIIll) || lllllllllllIllIlIlIllIlIIIlIIIll.isOnItemFrame())) {
                if (!lllllllllllIllIlIlIllIlIIIlIIIll.isOnItemFrame() && lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.dimension == this.dimension && this.trackingPosition) {
                    this.func_191095_a(MapDecoration.Type.PLAYER, lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.world, lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.getName(), lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.posX, lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.posZ, lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj.rotationYaw);
                }
            }
            else {
                this.playersHashMap.remove(lllllllllllIllIlIlIllIlIIIlIlIll.entityplayerObj);
                this.playersArrayList.remove(lllllllllllIllIlIlIllIlIIIlIlIll);
            }
        }
        if (lllllllllllIllIlIlIllIlIIIlIIIll.isOnItemFrame() && this.trackingPosition) {
            final EntityItemFrame lllllllllllIllIlIlIllIlIIIlIlIlI = lllllllllllIllIlIlIllIlIIIlIIIll.getItemFrame();
            final BlockPos lllllllllllIllIlIlIllIlIIIlIlIIl = lllllllllllIllIlIlIllIlIIIlIlIlI.getHangingPosition();
            this.func_191095_a(MapDecoration.Type.FRAME, lllllllllllIllIlIlIllIlIIIlIllll.world, "frame-" + lllllllllllIllIlIlIllIlIIIlIlIlI.getEntityId(), lllllllllllIllIlIlIllIlIIIlIlIIl.getX(), lllllllllllIllIlIlIllIlIIIlIlIIl.getZ(), lllllllllllIllIlIlIllIlIIIlIlIlI.facingDirection.getHorizontalIndex() * 90);
        }
        if (lllllllllllIllIlIlIllIlIIIlIIIll.hasTagCompound() && lllllllllllIllIlIlIllIlIIIlIIIll.getTagCompound().hasKey("Decorations", 9)) {
            final NBTTagList lllllllllllIllIlIlIllIlIIIlIlIII = lllllllllllIllIlIlIllIlIIIlIIIll.getTagCompound().getTagList("Decorations", 10);
            for (int lllllllllllIllIlIlIllIlIIIlIIlll = 0; lllllllllllIllIlIlIllIlIIIlIIlll < lllllllllllIllIlIlIllIlIIIlIlIII.tagCount(); ++lllllllllllIllIlIlIllIlIIIlIIlll) {
                final NBTTagCompound lllllllllllIllIlIlIllIlIIIlIIllI = lllllllllllIllIlIlIllIlIIIlIlIII.getCompoundTagAt(lllllllllllIllIlIlIllIlIIIlIIlll);
                if (!this.mapDecorations.containsKey(lllllllllllIllIlIlIllIlIIIlIIllI.getString("id"))) {
                    this.func_191095_a(MapDecoration.Type.func_191159_a(lllllllllllIllIlIlIllIlIIIlIIllI.getByte("type")), lllllllllllIllIlIlIllIlIIIlIllll.world, lllllllllllIllIlIlIllIlIIIlIIllI.getString("id"), lllllllllllIllIlIlIllIlIIIlIIllI.getDouble("x"), lllllllllllIllIlIlIllIlIIIlIIllI.getDouble("z"), lllllllllllIllIlIlIllIlIIIlIIllI.getDouble("rot"));
                }
            }
        }
    }
    
    private void func_191095_a(MapDecoration.Type lllllllllllIllIlIlIllIIllllIlIII, final World lllllllllllIllIlIlIllIIllllIIlll, final String lllllllllllIllIlIlIllIIlllllIlll, final double lllllllllllIllIlIlIllIIlllllIllI, final double lllllllllllIllIlIlIllIIllllIIlII, double lllllllllllIllIlIlIllIIlllllIlII) {
        final int lllllllllllIllIlIlIllIIlllllIIll = 1 << this.scale;
        final float lllllllllllIllIlIlIllIIlllllIIlI = (float)(lllllllllllIllIlIlIllIIlllllIllI - this.xCenter) / lllllllllllIllIlIlIllIIlllllIIll;
        final float lllllllllllIllIlIlIllIIlllllIIIl = (float)(lllllllllllIllIlIlIllIIllllIIlII - this.zCenter) / lllllllllllIllIlIlIllIIlllllIIll;
        byte lllllllllllIllIlIlIllIIlllllIIII = (byte)(lllllllllllIllIlIlIllIIlllllIIlI * 2.0f + 0.5);
        byte lllllllllllIllIlIlIllIIllllIllll = (byte)(lllllllllllIllIlIlIllIIlllllIIIl * 2.0f + 0.5);
        final int lllllllllllIllIlIlIllIIllllIlllI = 63;
        byte lllllllllllIllIlIlIllIIllllIllII = 0;
        if (lllllllllllIllIlIlIllIIlllllIIlI >= -63.0f && lllllllllllIllIlIlIllIIlllllIIIl >= -63.0f && lllllllllllIllIlIlIllIIlllllIIlI <= 63.0f && lllllllllllIllIlIlIllIIlllllIIIl <= 63.0f) {
            lllllllllllIllIlIlIllIIlllllIlII += ((lllllllllllIllIlIlIllIIlllllIlII < 0.0) ? -8.0 : 8.0);
            byte lllllllllllIllIlIlIllIIllllIllIl = (byte)(lllllllllllIllIlIlIllIIlllllIlII * 16.0 / 360.0);
            if (this.dimension < 0) {
                final int lllllllllllIllIlIlIllIIllllIlIll = (int)(lllllllllllIllIlIlIllIIllllIIlll.getWorldInfo().getWorldTime() / 10L);
                lllllllllllIllIlIlIllIIllllIllIl = (byte)(lllllllllllIllIlIlIllIIllllIlIll * lllllllllllIllIlIlIllIIllllIlIll * 34187121 + lllllllllllIllIlIlIllIIllllIlIll * 121 >> 15 & 0xF);
            }
        }
        else {
            if (lllllllllllIllIlIlIllIIllllIlIII != MapDecoration.Type.PLAYER) {
                this.mapDecorations.remove(lllllllllllIllIlIlIllIIlllllIlll);
                return;
            }
            final int lllllllllllIllIlIlIllIIllllIlIlI = 320;
            if (Math.abs(lllllllllllIllIlIlIllIIlllllIIlI) < 320.0f && Math.abs(lllllllllllIllIlIlIllIIlllllIIIl) < 320.0f) {
                lllllllllllIllIlIlIllIIllllIlIII = MapDecoration.Type.PLAYER_OFF_MAP;
            }
            else {
                if (!this.field_191096_f) {
                    this.mapDecorations.remove(lllllllllllIllIlIlIllIIlllllIlll);
                    return;
                }
                lllllllllllIllIlIlIllIIllllIlIII = MapDecoration.Type.PLAYER_OFF_LIMITS;
            }
            lllllllllllIllIlIlIllIIllllIllII = 0;
            if (lllllllllllIllIlIlIllIIlllllIIlI <= -63.0f) {
                lllllllllllIllIlIlIllIIlllllIIII = -128;
            }
            if (lllllllllllIllIlIlIllIIlllllIIIl <= -63.0f) {
                lllllllllllIllIlIlIllIIllllIllll = -128;
            }
            if (lllllllllllIllIlIlIllIIlllllIIlI >= 63.0f) {
                lllllllllllIllIlIlIllIIlllllIIII = 127;
            }
            if (lllllllllllIllIlIlIllIIlllllIIIl >= 63.0f) {
                lllllllllllIllIlIlIllIIllllIllll = 127;
            }
        }
        this.mapDecorations.put(lllllllllllIllIlIlIllIIlllllIlll, new MapDecoration((MapDecoration.Type)lllllllllllIllIlIlIllIIllllIlIII, lllllllllllIllIlIlIllIIlllllIIII, lllllllllllIllIlIlIllIIllllIllll, lllllllllllIllIlIlIllIIllllIllII));
    }
    
    public MapInfo getMapInfo(final EntityPlayer lllllllllllIllIlIlIllIIllIlllIll) {
        MapInfo lllllllllllIllIlIlIllIIllIlllIlI = this.playersHashMap.get(lllllllllllIllIlIlIllIIllIlllIll);
        if (lllllllllllIllIlIlIllIIllIlllIlI == null) {
            lllllllllllIllIlIlIllIIllIlllIlI = new MapInfo(lllllllllllIllIlIlIllIIllIlllIll);
            this.playersHashMap.put(lllllllllllIllIlIlIllIIllIlllIll, lllllllllllIllIlIlIllIIllIlllIlI);
            this.playersArrayList.add(lllllllllllIllIlIlIllIIllIlllIlI);
        }
        return lllllllllllIllIlIlIllIIllIlllIlI;
    }
    
    public void updateMapData(final int lllllllllllIllIlIlIllIIlllIIIIll, final int lllllllllllIllIlIlIllIIlllIIIIlI) {
        super.markDirty();
        for (final MapInfo lllllllllllIllIlIlIllIIlllIIIlIl : this.playersArrayList) {
            lllllllllllIllIlIlIllIIlllIIIlIl.update(lllllllllllIllIlIlIllIIlllIIIIll, lllllllllllIllIlIlIllIIlllIIIIlI);
        }
    }
    
    public MapData(final String lllllllllllIllIlIlIllIlIIlllIIll) {
        super(lllllllllllIllIlIlIllIlIIlllIIll);
        this.colors = new byte[16384];
        this.playersArrayList = (List<MapInfo>)Lists.newArrayList();
        this.playersHashMap = (Map<EntityPlayer, MapInfo>)Maps.newHashMap();
        this.mapDecorations = (Map<String, MapDecoration>)Maps.newLinkedHashMap();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIllIlIlIllIlIIlIIIllI) {
        this.dimension = lllllllllllIllIlIlIllIlIIlIIIllI.getByte("dimension");
        this.xCenter = lllllllllllIllIlIlIllIlIIlIIIllI.getInteger("xCenter");
        this.zCenter = lllllllllllIllIlIlIllIlIIlIIIllI.getInteger("zCenter");
        this.scale = lllllllllllIllIlIlIllIlIIlIIIllI.getByte("scale");
        this.scale = (byte)MathHelper.clamp(this.scale, 0, 4);
        if (lllllllllllIllIlIlIllIlIIlIIIllI.hasKey("trackingPosition", 1)) {
            this.trackingPosition = lllllllllllIllIlIlIllIlIIlIIIllI.getBoolean("trackingPosition");
        }
        else {
            this.trackingPosition = true;
        }
        this.field_191096_f = lllllllllllIllIlIlIllIlIIlIIIllI.getBoolean("unlimitedTracking");
        final int lllllllllllIllIlIlIllIlIIlIlIIII = lllllllllllIllIlIlIllIlIIlIIIllI.getShort("width");
        final int lllllllllllIllIlIlIllIlIIlIIllll = lllllllllllIllIlIlIllIlIIlIIIllI.getShort("height");
        if (lllllllllllIllIlIlIllIlIIlIlIIII == 128 && lllllllllllIllIlIlIllIlIIlIIllll == 128) {
            this.colors = lllllllllllIllIlIlIllIlIIlIIIllI.getByteArray("colors");
        }
        else {
            final byte[] lllllllllllIllIlIlIllIlIIlIIlllI = lllllllllllIllIlIlIllIlIIlIIIllI.getByteArray("colors");
            this.colors = new byte[16384];
            final int lllllllllllIllIlIlIllIlIIlIIllIl = (128 - lllllllllllIllIlIlIllIlIIlIlIIII) / 2;
            final int lllllllllllIllIlIlIllIlIIlIIllII = (128 - lllllllllllIllIlIlIllIlIIlIIllll) / 2;
            for (int lllllllllllIllIlIlIllIlIIlIIlIll = 0; lllllllllllIllIlIlIllIlIIlIIlIll < lllllllllllIllIlIlIllIlIIlIIllll; ++lllllllllllIllIlIlIllIlIIlIIlIll) {
                final int lllllllllllIllIlIlIllIlIIlIIlIlI = lllllllllllIllIlIlIllIlIIlIIlIll + lllllllllllIllIlIlIllIlIIlIIllII;
                if (lllllllllllIllIlIlIllIlIIlIIlIlI >= 0 || lllllllllllIllIlIlIllIlIIlIIlIlI < 128) {
                    for (int lllllllllllIllIlIlIllIlIIlIIlIIl = 0; lllllllllllIllIlIlIllIlIIlIIlIIl < lllllllllllIllIlIlIllIlIIlIlIIII; ++lllllllllllIllIlIlIllIlIIlIIlIIl) {
                        final int lllllllllllIllIlIlIllIlIIlIIlIII = lllllllllllIllIlIlIllIlIIlIIlIIl + lllllllllllIllIlIlIllIlIIlIIllIl;
                        if (lllllllllllIllIlIlIllIlIIlIIlIII >= 0 || lllllllllllIllIlIlIllIlIIlIIlIII < 128) {
                            this.colors[lllllllllllIllIlIlIllIlIIlIIlIII + lllllllllllIllIlIlIllIlIIlIIlIlI * 128] = lllllllllllIllIlIlIllIlIIlIIlllI[lllllllllllIllIlIlIllIlIIlIIlIIl + lllllllllllIllIlIlIllIlIIlIIlIll * lllllllllllIllIlIlIllIlIIlIlIIII];
                        }
                    }
                }
            }
        }
    }
    
    public class MapInfo
    {
        private /* synthetic */ int minY;
        private /* synthetic */ int maxY;
        private /* synthetic */ boolean isDirty;
        private /* synthetic */ int minX;
        private /* synthetic */ int tick;
        public final /* synthetic */ EntityPlayer entityplayerObj;
        private /* synthetic */ int maxX;
        
        public void update(final int llllllllllIllllIIIlIIIIIIlIIIIIl, final int llllllllllIllllIIIlIIIIIIlIIIIII) {
            if (this.isDirty) {
                this.minX = Math.min(this.minX, llllllllllIllllIIIlIIIIIIlIIIIIl);
                this.minY = Math.min(this.minY, llllllllllIllllIIIlIIIIIIlIIIIII);
                this.maxX = Math.max(this.maxX, llllllllllIllllIIIlIIIIIIlIIIIIl);
                this.maxY = Math.max(this.maxY, llllllllllIllllIIIlIIIIIIlIIIIII);
            }
            else {
                this.isDirty = true;
                this.minX = llllllllllIllllIIIlIIIIIIlIIIIIl;
                this.minY = llllllllllIllllIIIlIIIIIIlIIIIII;
                this.maxX = llllllllllIllllIIIlIIIIIIlIIIIIl;
                this.maxY = llllllllllIllllIIIlIIIIIIlIIIIII;
            }
        }
        
        public MapInfo(final EntityPlayer llllllllllIllllIIIlIIIIIIlIlIIlI) {
            this.isDirty = true;
            this.maxX = 127;
            this.maxY = 127;
            this.entityplayerObj = llllllllllIllllIIIlIIIIIIlIlIIlI;
        }
        
        @Nullable
        public Packet<?> getPacket(final ItemStack llllllllllIllllIIIlIIIIIIlIIlIll) {
            if (this.isDirty) {
                this.isDirty = false;
                return new SPacketMaps(llllllllllIllllIIIlIIIIIIlIIlIll.getMetadata(), MapData.this.scale, MapData.this.trackingPosition, MapData.this.mapDecorations.values(), MapData.this.colors, this.minX, this.minY, this.maxX + 1 - this.minX, this.maxY + 1 - this.minY);
            }
            return (this.tick++ % 5 == 0) ? new SPacketMaps(llllllllllIllllIIIlIIIIIIlIIlIll.getMetadata(), MapData.this.scale, MapData.this.trackingPosition, MapData.this.mapDecorations.values(), MapData.this.colors, 0, 0, 0, 0) : null;
        }
    }
}

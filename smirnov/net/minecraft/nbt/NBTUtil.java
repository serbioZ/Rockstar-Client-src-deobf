// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

import net.minecraft.util.StringUtils;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.init.Blocks;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import com.google.common.annotations.VisibleForTesting;
import java.util.Iterator;
import com.google.common.base.Optional;
import net.minecraft.block.state.IBlockState;
import javax.annotation.Nullable;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.math.BlockPos;
import java.util.UUID;
import net.minecraft.block.properties.IProperty;
import org.apache.logging.log4j.Logger;

public final class NBTUtil
{
    private static final /* synthetic */ Logger field_193591_a;
    
    private static <T extends Comparable<T>> String getName(final IProperty<T> llllllllllllIlIlIlIIlIIIlIlIIIIl, final Comparable<?> llllllllllllIlIlIlIIlIIIlIlIIIII) {
        return llllllllllllIlIlIlIIlIIIlIlIIIIl.getName((T)llllllllllllIlIlIlIIlIIIlIlIIIII);
    }
    
    public static NBTTagCompound createUUIDTag(final UUID llllllllllllIlIlIlIIlIIIlllIllII) {
        final NBTTagCompound llllllllllllIlIlIlIIlIIIlllIllIl = new NBTTagCompound();
        llllllllllllIlIlIlIIlIIIlllIllIl.setLong("M", llllllllllllIlIlIlIIlIIIlllIllII.getMostSignificantBits());
        llllllllllllIlIlIlIIlIIIlllIllIl.setLong("L", llllllllllllIlIlIlIIlIIIlllIllII.getLeastSignificantBits());
        return llllllllllllIlIlIlIIlIIIlllIllIl;
    }
    
    public static BlockPos getPosFromTag(final NBTTagCompound llllllllllllIlIlIlIIlIIIlllIIllI) {
        return new BlockPos(llllllllllllIlIlIlIIlIIIlllIIllI.getInteger("X"), llllllllllllIlIlIlIIlIIIlllIIllI.getInteger("Y"), llllllllllllIlIlIlIIlIIIlllIIllI.getInteger("Z"));
    }
    
    @Nullable
    public static GameProfile readGameProfileFromNBT(final NBTTagCompound llllllllllllIlIlIlIIlIIlIIllIlII) {
        String llllllllllllIlIlIlIIlIIlIlIIIIIl = null;
        String llllllllllllIlIlIlIIlIIlIlIIIIII = null;
        if (llllllllllllIlIlIlIIlIIlIIllIlII.hasKey("Name", 8)) {
            llllllllllllIlIlIlIIlIIlIlIIIIIl = llllllllllllIlIlIlIIlIIlIIllIlII.getString("Name");
        }
        Label_0040: {
            if (!llllllllllllIlIlIlIIlIIlIIllIlII.hasKey("Id", 8)) {
                break Label_0040;
            }
            llllllllllllIlIlIlIIlIIlIlIIIIII = llllllllllllIlIlIlIIlIIlIIllIlII.getString("Id");
            try {
                UUID llllllllllllIlIlIlIIlIIlIIlllllI = null;
                try {
                    final UUID llllllllllllIlIlIlIIlIIlIIllllll = UUID.fromString(llllllllllllIlIlIlIIlIIlIlIIIIII);
                }
                catch (Throwable llllllllllllIlIlIlIIlIIlIIllllIl) {
                    llllllllllllIlIlIlIIlIIlIIlllllI = null;
                }
                final GameProfile llllllllllllIlIlIlIIlIIlIIllllII = new GameProfile(llllllllllllIlIlIlIIlIIlIIlllllI, llllllllllllIlIlIlIIlIIlIlIIIIIl);
                if (llllllllllllIlIlIlIIlIIlIIllIlII.hasKey("Properties", 10)) {
                    final NBTTagCompound llllllllllllIlIlIlIIlIIlIIlllIll = llllllllllllIlIlIlIIlIIlIIllIlII.getCompoundTag("Properties");
                    for (final String llllllllllllIlIlIlIIlIIlIIlllIlI : llllllllllllIlIlIlIIlIIlIIlllIll.getKeySet()) {
                        final NBTTagList llllllllllllIlIlIlIIlIIlIIlllIIl = llllllllllllIlIlIlIIlIIlIIlllIll.getTagList(llllllllllllIlIlIlIIlIIlIIlllIlI, 10);
                        for (int llllllllllllIlIlIlIIlIIlIIlllIII = 0; llllllllllllIlIlIlIIlIIlIIlllIII < llllllllllllIlIlIlIIlIIlIIlllIIl.tagCount(); ++llllllllllllIlIlIlIIlIIlIIlllIII) {
                            final NBTTagCompound llllllllllllIlIlIlIIlIIlIIllIlll = llllllllllllIlIlIlIIlIIlIIlllIIl.getCompoundTagAt(llllllllllllIlIlIlIIlIIlIIlllIII);
                            final String llllllllllllIlIlIlIIlIIlIIllIllI = llllllllllllIlIlIlIIlIIlIIllIlll.getString("Value");
                            if (llllllllllllIlIlIlIIlIIlIIllIlll.hasKey("Signature", 8)) {
                                llllllllllllIlIlIlIIlIIlIIllllII.getProperties().put((Object)llllllllllllIlIlIlIIlIIlIIlllIlI, (Object)new Property(llllllllllllIlIlIlIIlIIlIIlllIlI, llllllllllllIlIlIlIIlIIlIIllIllI, llllllllllllIlIlIlIIlIIlIIllIlll.getString("Signature")));
                            }
                            else {
                                llllllllllllIlIlIlIIlIIlIIllllII.getProperties().put((Object)llllllllllllIlIlIlIIlIIlIIlllIlI, (Object)new Property(llllllllllllIlIlIlIIlIIlIIlllIlI, llllllllllllIlIlIlIIlIIlIIllIllI));
                            }
                        }
                    }
                }
                return llllllllllllIlIlIlIIlIIlIIllllII;
            }
            catch (Throwable llllllllllllIlIlIlIIlIIlIIllIlIl) {
                return null;
            }
        }
    }
    
    public static UUID getUUIDFromTag(final NBTTagCompound llllllllllllIlIlIlIIlIIIlllIlIIl) {
        return new UUID(llllllllllllIlIlIlIIlIIIlllIlIIl.getLong("M"), llllllllllllIlIlIlIIlIIIlllIlIIl.getLong("L"));
    }
    
    private static <T extends Comparable<T>> IBlockState func_193590_a(final IBlockState llllllllllllIlIlIlIIlIIIlIlllIll, final IProperty<T> llllllllllllIlIlIlIIlIIIllIIIIII, final String llllllllllllIlIlIlIIlIIIlIlllIIl, final NBTTagCompound llllllllllllIlIlIlIIlIIIlIlllllI, final NBTTagCompound llllllllllllIlIlIlIIlIIIlIllllIl) {
        final Optional<T> llllllllllllIlIlIlIIlIIIlIllllII = llllllllllllIlIlIlIIlIIIllIIIIII.parseValue(llllllllllllIlIlIlIIlIIIlIlllllI.getString(llllllllllllIlIlIlIIlIIIlIlllIIl));
        if (llllllllllllIlIlIlIIlIIIlIllllII.isPresent()) {
            return llllllllllllIlIlIlIIlIIIlIlllIll.withProperty(llllllllllllIlIlIlIIlIIIllIIIIII, llllllllllllIlIlIlIIlIIIlIllllII.get());
        }
        NBTUtil.field_193591_a.warn("Unable to read property: {} with value: {} for blockstate: {}", (Object)llllllllllllIlIlIlIIlIIIlIlllIIl, (Object)llllllllllllIlIlIlIIlIIIlIlllllI.getString(llllllllllllIlIlIlIIlIIIlIlllIIl), (Object)llllllllllllIlIlIlIIlIIIlIllllIl.toString());
        return llllllllllllIlIlIlIIlIIIlIlllIll;
    }
    
    @VisibleForTesting
    public static boolean areNBTEquals(final NBTBase llllllllllllIlIlIlIIlIIIlllllIIl, final NBTBase llllllllllllIlIlIlIIlIIlIIIIIlIl, final boolean llllllllllllIlIlIlIIlIIlIIIIIlII) {
        if (llllllllllllIlIlIlIIlIIIlllllIIl == llllllllllllIlIlIlIIlIIlIIIIIlIl) {
            return true;
        }
        if (llllllllllllIlIlIlIIlIIIlllllIIl == null) {
            return true;
        }
        if (llllllllllllIlIlIlIIlIIlIIIIIlIl == null) {
            return false;
        }
        if (!llllllllllllIlIlIlIIlIIIlllllIIl.getClass().equals(llllllllllllIlIlIlIIlIIlIIIIIlIl.getClass())) {
            return false;
        }
        if (llllllllllllIlIlIlIIlIIIlllllIIl instanceof NBTTagCompound) {
            final NBTTagCompound llllllllllllIlIlIlIIlIIlIIIIIIll = (NBTTagCompound)llllllllllllIlIlIlIIlIIIlllllIIl;
            final NBTTagCompound llllllllllllIlIlIlIIlIIlIIIIIIlI = (NBTTagCompound)llllllllllllIlIlIlIIlIIlIIIIIlIl;
            for (final String llllllllllllIlIlIlIIlIIlIIIIIIIl : llllllllllllIlIlIlIIlIIlIIIIIIll.getKeySet()) {
                final NBTBase llllllllllllIlIlIlIIlIIlIIIIIIII = llllllllllllIlIlIlIIlIIlIIIIIIll.getTag(llllllllllllIlIlIlIIlIIlIIIIIIIl);
                if (!areNBTEquals(llllllllllllIlIlIlIIlIIlIIIIIIII, llllllllllllIlIlIlIIlIIlIIIIIIlI.getTag(llllllllllllIlIlIlIIlIIlIIIIIIIl), llllllllllllIlIlIlIIlIIlIIIIIlII)) {
                    return false;
                }
            }
            return true;
        }
        if (!(llllllllllllIlIlIlIIlIIIlllllIIl instanceof NBTTagList) || !llllllllllllIlIlIlIIlIIlIIIIIlII) {
            return llllllllllllIlIlIlIIlIIIlllllIIl.equals(llllllllllllIlIlIlIIlIIlIIIIIlIl);
        }
        final NBTTagList llllllllllllIlIlIlIIlIIIllllllll = (NBTTagList)llllllllllllIlIlIlIIlIIIlllllIIl;
        final NBTTagList llllllllllllIlIlIlIIlIIIlllllllI = (NBTTagList)llllllllllllIlIlIlIIlIIlIIIIIlIl;
        if (llllllllllllIlIlIlIIlIIIllllllll.hasNoTags()) {
            return llllllllllllIlIlIlIIlIIIlllllllI.hasNoTags();
        }
        for (int llllllllllllIlIlIlIIlIIIllllllIl = 0; llllllllllllIlIlIlIIlIIIllllllIl < llllllllllllIlIlIlIIlIIIllllllll.tagCount(); ++llllllllllllIlIlIlIIlIIIllllllIl) {
            final NBTBase llllllllllllIlIlIlIIlIIIllllllII = llllllllllllIlIlIlIIlIIIllllllll.get(llllllllllllIlIlIlIIlIIIllllllIl);
            boolean llllllllllllIlIlIlIIlIIIlllllIll = false;
            for (int llllllllllllIlIlIlIIlIIIlllllIlI = 0; llllllllllllIlIlIlIIlIIIlllllIlI < llllllllllllIlIlIlIIlIIIlllllllI.tagCount(); ++llllllllllllIlIlIlIIlIIIlllllIlI) {
                if (areNBTEquals(llllllllllllIlIlIlIIlIIIllllllII, llllllllllllIlIlIlIIlIIIlllllllI.get(llllllllllllIlIlIlIIlIIIlllllIlI), llllllllllllIlIlIlIIlIIlIIIIIlII)) {
                    llllllllllllIlIlIlIIlIIIlllllIll = true;
                    break;
                }
            }
            if (!llllllllllllIlIlIlIIlIIIlllllIll) {
                return false;
            }
        }
        return true;
    }
    
    static {
        field_193591_a = LogManager.getLogger();
    }
    
    public static NBTTagCompound createPosTag(final BlockPos llllllllllllIlIlIlIIlIIIlllIIIlI) {
        final NBTTagCompound llllllllllllIlIlIlIIlIIIlllIIIIl = new NBTTagCompound();
        llllllllllllIlIlIlIIlIIIlllIIIIl.setInteger("X", llllllllllllIlIlIlIIlIIIlllIIIlI.getX());
        llllllllllllIlIlIlIIlIIIlllIIIIl.setInteger("Y", llllllllllllIlIlIlIIlIIIlllIIIlI.getY());
        llllllllllllIlIlIlIIlIIIlllIIIIl.setInteger("Z", llllllllllllIlIlIlIIlIIIlllIIIlI.getZ());
        return llllllllllllIlIlIlIIlIIIlllIIIIl;
    }
    
    public static NBTTagCompound writeBlockState(final NBTTagCompound llllllllllllIlIlIlIIlIIIlIlIllll, final IBlockState llllllllllllIlIlIlIIlIIIlIlIlllI) {
        llllllllllllIlIlIlIIlIIIlIlIllll.setString("Name", Block.REGISTRY.getNameForObject(llllllllllllIlIlIlIIlIIIlIlIlllI.getBlock()).toString());
        if (!llllllllllllIlIlIlIIlIIIlIlIlllI.getProperties().isEmpty()) {
            final NBTTagCompound llllllllllllIlIlIlIIlIIIlIlIllIl = new NBTTagCompound();
            for (final Map.Entry<IProperty<?>, Comparable<?>> llllllllllllIlIlIlIIlIIIlIlIlIll : llllllllllllIlIlIlIIlIIIlIlIlllI.getProperties().entrySet()) {
                final IProperty<?> llllllllllllIlIlIlIIlIIIlIlIlIlI = llllllllllllIlIlIlIIlIIIlIlIlIll.getKey();
                llllllllllllIlIlIlIIlIIIlIlIllIl.setString(llllllllllllIlIlIlIIlIIIlIlIlIlI.getName(), getName(llllllllllllIlIlIlIIlIIIlIlIlIlI, llllllllllllIlIlIlIIlIIIlIlIlIll.getValue()));
            }
            llllllllllllIlIlIlIIlIIIlIlIllll.setTag("Properties", llllllllllllIlIlIlIIlIIIlIlIllIl);
        }
        return llllllllllllIlIlIlIIlIIIlIlIllll;
    }
    
    public static IBlockState readBlockState(final NBTTagCompound llllllllllllIlIlIlIIlIIIllIlIllI) {
        if (!llllllllllllIlIlIlIIlIIIllIlIllI.hasKey("Name", 8)) {
            return Blocks.AIR.getDefaultState();
        }
        final Block llllllllllllIlIlIlIIlIIIllIlIlIl = Block.REGISTRY.getObject(new ResourceLocation(llllllllllllIlIlIlIIlIIIllIlIllI.getString("Name")));
        IBlockState llllllllllllIlIlIlIIlIIIllIlIlII = llllllllllllIlIlIlIIlIIIllIlIlIl.getDefaultState();
        if (llllllllllllIlIlIlIIlIIIllIlIllI.hasKey("Properties", 10)) {
            final NBTTagCompound llllllllllllIlIlIlIIlIIIllIlIIll = llllllllllllIlIlIlIIlIIIllIlIllI.getCompoundTag("Properties");
            final BlockStateContainer llllllllllllIlIlIlIIlIIIllIlIIlI = llllllllllllIlIlIlIIlIIIllIlIlIl.getBlockState();
            for (final String llllllllllllIlIlIlIIlIIIllIlIIIl : llllllllllllIlIlIlIIlIIIllIlIIll.getKeySet()) {
                final IProperty<?> llllllllllllIlIlIlIIlIIIllIlIIII = llllllllllllIlIlIlIIlIIIllIlIIlI.getProperty(llllllllllllIlIlIlIIlIIIllIlIIIl);
                if (llllllllllllIlIlIlIIlIIIllIlIIII != null) {
                    llllllllllllIlIlIlIIlIIIllIlIlII = func_193590_a(llllllllllllIlIlIlIIlIIIllIlIlII, llllllllllllIlIlIlIIlIIIllIlIIII, llllllllllllIlIlIlIIlIIIllIlIIIl, llllllllllllIlIlIlIIlIIIllIlIIll, llllllllllllIlIlIlIIlIIIllIlIllI);
                }
            }
        }
        return llllllllllllIlIlIlIIlIIIllIlIlII;
    }
    
    public static NBTTagCompound writeGameProfile(final NBTTagCompound llllllllllllIlIlIlIIlIIlIIIllIII, final GameProfile llllllllllllIlIlIlIIlIIlIIIlIlll) {
        if (!StringUtils.isNullOrEmpty(llllllllllllIlIlIlIIlIIlIIIlIlll.getName())) {
            llllllllllllIlIlIlIIlIIlIIIllIII.setString("Name", llllllllllllIlIlIlIIlIIlIIIlIlll.getName());
        }
        if (llllllllllllIlIlIlIIlIIlIIIlIlll.getId() != null) {
            llllllllllllIlIlIlIIlIIlIIIllIII.setString("Id", llllllllllllIlIlIlIIlIIlIIIlIlll.getId().toString());
        }
        if (!llllllllllllIlIlIlIIlIIlIIIlIlll.getProperties().isEmpty()) {
            final NBTTagCompound llllllllllllIlIlIlIIlIIlIIIlllIl = new NBTTagCompound();
            for (final String llllllllllllIlIlIlIIlIIlIIIlllII : llllllllllllIlIlIlIIlIIlIIIlIlll.getProperties().keySet()) {
                final NBTTagList llllllllllllIlIlIlIIlIIlIIIllIll = new NBTTagList();
                for (final Property llllllllllllIlIlIlIIlIIlIIIllIlI : llllllllllllIlIlIlIIlIIlIIIlIlll.getProperties().get((Object)llllllllllllIlIlIlIIlIIlIIIlllII)) {
                    final NBTTagCompound llllllllllllIlIlIlIIlIIlIIIllIIl = new NBTTagCompound();
                    llllllllllllIlIlIlIIlIIlIIIllIIl.setString("Value", llllllllllllIlIlIlIIlIIlIIIllIlI.getValue());
                    if (llllllllllllIlIlIlIIlIIlIIIllIlI.hasSignature()) {
                        llllllllllllIlIlIlIIlIIlIIIllIIl.setString("Signature", llllllllllllIlIlIlIIlIIlIIIllIlI.getSignature());
                    }
                    llllllllllllIlIlIlIIlIIlIIIllIll.appendTag(llllllllllllIlIlIlIIlIIlIIIllIIl);
                }
                llllllllllllIlIlIlIIlIIlIIIlllIl.setTag(llllllllllllIlIlIlIIlIIlIIIlllII, llllllllllllIlIlIlIIlIIlIIIllIll);
            }
            llllllllllllIlIlIlIIlIIlIIIllIII.setTag("Properties", llllllllllllIlIlIlIIlIIlIIIlllIl);
        }
        return llllllllllllIlIlIlIIlIIlIIIllIII;
    }
}

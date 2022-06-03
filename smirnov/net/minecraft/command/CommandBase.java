// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import com.google.common.base.Predicates;
import com.google.common.base.Predicate;
import net.minecraft.item.Item;
import java.util.Iterator;
import net.minecraft.block.state.BlockStateContainer;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Map;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Iterables;
import com.google.common.base.Functions;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;
import java.util.Collection;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.UUID;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.google.gson.JsonParseException;
import net.minecraft.block.properties.IProperty;
import net.minecraft.server.MinecraftServer;
import com.google.common.primitives.Doubles;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import java.util.Collections;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import com.google.common.base.Splitter;

public abstract class CommandBase implements ICommand
{
    private static final /* synthetic */ Splitter field_190796_b;
    private static final /* synthetic */ Splitter field_190797_c;
    private static /* synthetic */ ICommandListener commandListener;
    
    public static int parseInt(final String lllllllllllIIIlIllllIlIIlIlIlllI, final int lllllllllllIIIlIllllIlIIlIlIlIIl, final int lllllllllllIIIlIllllIlIIlIlIllII) throws NumberInvalidException {
        final int lllllllllllIIIlIllllIlIIlIlIlIll = parseInt(lllllllllllIIIlIllllIlIIlIlIlllI);
        if (lllllllllllIIIlIllllIlIIlIlIlIll < lllllllllllIIIlIllllIlIIlIlIlIIl) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { lllllllllllIIIlIllllIlIIlIlIlIll, lllllllllllIIIlIllllIlIIlIlIlIIl });
        }
        if (lllllllllllIIIlIllllIlIIlIlIlIll > lllllllllllIIIlIllllIlIIlIlIllII) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { lllllllllllIIIlIllllIlIIlIlIlIll, lllllllllllIIIlIllllIlIIlIlIllII });
        }
        return lllllllllllIIIlIllllIlIIlIlIlIll;
    }
    
    @Override
    public int compareTo(final ICommand lllllllllllIIIlIllllIIlIlIlllIII) {
        return this.getCommandName().compareTo(lllllllllllIIIlIllllIIlIlIlllIII.getCommandName());
    }
    
    public static long parseLong(final String lllllllllllIIIlIllllIlIIlIlIIIlI) throws NumberInvalidException {
        try {
            return Long.parseLong(lllllllllllIIIlIllllIlIIlIlIIIlI);
        }
        catch (NumberFormatException lllllllllllIIIlIllllIlIIlIlIIIll) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllIIIlIllllIlIIlIlIIIlI });
        }
    }
    
    public static List<String> getTabCompletionCoordinate(final String[] lllllllllllIIIlIllllIIllIIIlIIIl, final int lllllllllllIIIlIllllIIllIIIlIlll, @Nullable final BlockPos lllllllllllIIIlIllllIIllIIIlIllI) {
        if (lllllllllllIIIlIllllIIllIIIlIllI == null) {
            return (List<String>)Lists.newArrayList((Object[])new String[] { "~" });
        }
        final int lllllllllllIIIlIllllIIllIIIlIlIl = lllllllllllIIIlIllllIIllIIIlIIIl.length - 1;
        String lllllllllllIIIlIllllIIllIIIlIIlI = null;
        if (lllllllllllIIIlIllllIIllIIIlIlIl == lllllllllllIIIlIllllIIllIIIlIlll) {
            final String lllllllllllIIIlIllllIIllIIIlIlII = Integer.toString(lllllllllllIIIlIllllIIllIIIlIllI.getX());
        }
        else if (lllllllllllIIIlIllllIIllIIIlIlIl == lllllllllllIIIlIllllIIllIIIlIlll + 1) {
            final String lllllllllllIIIlIllllIIllIIIlIIll = Integer.toString(lllllllllllIIIlIllllIIllIIIlIllI.getY());
        }
        else {
            if (lllllllllllIIIlIllllIIllIIIlIlIl != lllllllllllIIIlIllllIIllIIIlIlll + 2) {
                return Collections.emptyList();
            }
            lllllllllllIIIlIllllIIllIIIlIIlI = Integer.toString(lllllllllllIIIlIllllIIllIIIlIllI.getZ());
        }
        return (List<String>)Lists.newArrayList((Object[])new String[] { lllllllllllIIIlIllllIIllIIIlIIlI });
    }
    
    public static BlockPos parseBlockPos(final ICommandSender lllllllllllIIIlIllllIlIIlIIIlIlI, final String[] lllllllllllIIIlIllllIlIIlIIIlIIl, final int lllllllllllIIIlIllllIlIIlIIIllIl, final boolean lllllllllllIIIlIllllIlIIlIIIIlll) throws NumberInvalidException {
        final BlockPos lllllllllllIIIlIllllIlIIlIIIlIll = lllllllllllIIIlIllllIlIIlIIIlIlI.getPosition();
        return new BlockPos(parseDouble(lllllllllllIIIlIllllIlIIlIIIlIll.getX(), lllllllllllIIIlIllllIlIIlIIIlIIl[lllllllllllIIIlIllllIlIIlIIIllIl], -30000000, 30000000, lllllllllllIIIlIllllIlIIlIIIIlll), parseDouble(lllllllllllIIIlIllllIlIIlIIIlIll.getY(), lllllllllllIIIlIllllIlIIlIIIlIIl[lllllllllllIIIlIllllIlIIlIIIllIl + 1], 0, 256, false), parseDouble(lllllllllllIIIlIllllIlIIlIIIlIll.getZ(), lllllllllllIIIlIllllIlIIlIIIlIIl[lllllllllllIIIlIllllIlIIlIIIllIl + 2], -30000000, 30000000, lllllllllllIIIlIllllIlIIlIIIIlll));
    }
    
    public static void notifyCommandListener(final ICommandSender lllllllllllIIIlIllllIIlIllIIlIlI, final ICommand lllllllllllIIIlIllllIIlIllIIIlII, final int lllllllllllIIIlIllllIIlIllIIlIII, final String lllllllllllIIIlIllllIIlIllIIIIlI, final Object... lllllllllllIIIlIllllIIlIllIIIllI) {
        if (CommandBase.commandListener != null) {
            CommandBase.commandListener.notifyListener(lllllllllllIIIlIllllIIlIllIIlIlI, lllllllllllIIIlIllllIIlIllIIIlII, lllllllllllIIIlIllllIIlIllIIlIII, lllllllllllIIIlIllllIIlIllIIIIlI, lllllllllllIIIlIllllIIlIllIIIllI);
        }
    }
    
    public static String joinNiceString(final Object[] lllllllllllIIIlIllllIIllIIlIllIl) {
        final StringBuilder lllllllllllIIIlIllllIIllIIllIIII = new StringBuilder();
        for (int lllllllllllIIIlIllllIIllIIlIllll = 0; lllllllllllIIIlIllllIIllIIlIllll < lllllllllllIIIlIllllIIllIIlIllIl.length; ++lllllllllllIIIlIllllIIllIIlIllll) {
            final String lllllllllllIIIlIllllIIllIIlIlllI = lllllllllllIIIlIllllIIllIIlIllIl[lllllllllllIIIlIllllIIllIIlIllll].toString();
            if (lllllllllllIIIlIllllIIllIIlIllll > 0) {
                if (lllllllllllIIIlIllllIIllIIlIllll == lllllllllllIIIlIllllIIllIIlIllIl.length - 1) {
                    lllllllllllIIIlIllllIIllIIllIIII.append(" and ");
                }
                else {
                    lllllllllllIIIlIllllIIllIIllIIII.append(", ");
                }
            }
            lllllllllllIIIlIllllIIllIIllIIII.append(lllllllllllIIIlIllllIIllIIlIlllI);
        }
        return lllllllllllIIIlIllllIIllIIllIIII.toString();
    }
    
    public static NBTTagCompound entityToNBT(final Entity lllllllllllIIIlIllllIlIIllIlIIlI) {
        final NBTTagCompound lllllllllllIIIlIllllIlIIllIlIIIl = lllllllllllIIIlIllllIlIIllIlIIlI.writeToNBT(new NBTTagCompound());
        if (lllllllllllIIIlIllllIlIIllIlIIlI instanceof EntityPlayer) {
            final ItemStack lllllllllllIIIlIllllIlIIllIlIIII = ((EntityPlayer)lllllllllllIIIlIllllIlIIllIlIIlI).inventory.getCurrentItem();
            if (!lllllllllllIIIlIllllIlIIllIlIIII.func_190926_b()) {
                lllllllllllIIIlIllllIlIIllIlIIIl.setTag("SelectedItem", lllllllllllIIIlIllllIlIIllIlIIII.writeToNBT(new NBTTagCompound()));
            }
        }
        return lllllllllllIIIlIllllIlIIllIlIIIl;
    }
    
    public static double parseDouble(final String lllllllllllIIIlIllllIlIIlIIIIIll) throws NumberInvalidException {
        try {
            final double lllllllllllIIIlIllllIlIIlIIIIIlI = Double.parseDouble(lllllllllllIIIlIllllIlIIlIIIIIll);
            if (!Doubles.isFinite(lllllllllllIIIlIllllIlIIlIIIIIlI)) {
                throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllIIIlIllllIlIIlIIIIIll });
            }
            return lllllllllllIIIlIllllIlIIlIIIIIlI;
        }
        catch (NumberFormatException lllllllllllIIIlIllllIlIIlIIIIIIl) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllIIIlIllllIlIIlIIIIIll });
        }
    }
    
    @Override
    public boolean checkPermission(final MinecraftServer lllllllllllIIIlIllllIlIIllIIIlll, final ICommandSender lllllllllllIIIlIllllIlIIllIIIlII) {
        return lllllllllllIIIlIllllIlIIllIIIlII.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }
    
    public static int parseInt(final String lllllllllllIIIlIllllIlIIlIlllIlI) throws NumberInvalidException {
        try {
            return Integer.parseInt(lllllllllllIIIlIllllIlIIlIlllIlI);
        }
        catch (NumberFormatException lllllllllllIIIlIllllIlIIlIlllIll) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllIIIlIllllIlIIlIlllIlI });
        }
    }
    
    @Nullable
    private static <T extends Comparable<T>> T func_190792_a(final IProperty<T> lllllllllllIIIlIllllIIllIIllIlll, final String lllllllllllIIIlIllllIIllIIllIllI) {
        return (T)lllllllllllIIIlIllllIIllIIllIlll.parseValue(lllllllllllIIIlIllllIIllIIllIllI).orNull();
    }
    
    protected static SyntaxErrorException toSyntaxException(final JsonParseException lllllllllllIIIlIllllIlIIllIllIll) {
        final Throwable lllllllllllIIIlIllllIlIIllIllIlI = ExceptionUtils.getRootCause((Throwable)lllllllllllIIIlIllllIlIIllIllIll);
        String lllllllllllIIIlIllllIlIIllIllIIl = "";
        if (lllllllllllIIIlIllllIlIIllIllIlI != null) {
            lllllllllllIIIlIllllIlIIllIllIIl = lllllllllllIIIlIllllIlIIllIllIlI.getMessage();
            if (lllllllllllIIIlIllllIlIIllIllIIl.contains("setLenient")) {
                lllllllllllIIIlIllllIlIIllIllIIl = lllllllllllIIIlIllllIlIIllIllIIl.substring(lllllllllllIIIlIllllIlIIllIllIIl.indexOf("to accept ") + 10);
            }
        }
        return new SyntaxErrorException("commands.tellraw.jsonException", new Object[] { lllllllllllIIIlIllllIlIIllIllIIl });
    }
    
    public static <T extends Entity> T getEntity(final MinecraftServer lllllllllllIIIlIllllIlIIIIllIlll, final ICommandSender lllllllllllIIIlIllllIlIIIIlIllll, final String lllllllllllIIIlIllllIlIIIIllIlIl, final Class<? extends T> lllllllllllIIIlIllllIlIIIIllIlII) throws EntityNotFoundException, CommandException {
        Entity lllllllllllIIIlIllllIlIIIIllIIll = EntitySelector.matchOneEntity(lllllllllllIIIlIllllIlIIIIlIllll, lllllllllllIIIlIllllIlIIIIllIlIl, (Class<? extends Entity>)lllllllllllIIIlIllllIlIIIIllIlII);
        if (lllllllllllIIIlIllllIlIIIIllIIll == null) {
            lllllllllllIIIlIllllIlIIIIllIIll = lllllllllllIIIlIllllIlIIIIllIlll.getPlayerList().getPlayerByUsername(lllllllllllIIIlIllllIlIIIIllIlIl);
        }
        if (lllllllllllIIIlIllllIlIIIIllIIll == null) {
            try {
                final UUID lllllllllllIIIlIllllIlIIIIllIIlI = UUID.fromString(lllllllllllIIIlIllllIlIIIIllIlIl);
                lllllllllllIIIlIllllIlIIIIllIIll = lllllllllllIIIlIllllIlIIIIllIlll.getEntityFromUuid(lllllllllllIIIlIllllIlIIIIllIIlI);
                if (lllllllllllIIIlIllllIlIIIIllIIll == null) {
                    lllllllllllIIIlIllllIlIIIIllIIll = lllllllllllIIIlIllllIlIIIIllIlll.getPlayerList().getPlayerByUUID(lllllllllllIIIlIllllIlIIIIllIIlI);
                }
            }
            catch (IllegalArgumentException lllllllllllIIIlIllllIlIIIIllIIIl) {
                if (lllllllllllIIIlIllllIlIIIIllIlIl.split("-").length == 5) {
                    throw new EntityNotFoundException("commands.generic.entity.invalidUuid", new Object[] { lllllllllllIIIlIllllIlIIIIllIlIl });
                }
            }
        }
        if (lllllllllllIIIlIllllIlIIIIllIIll != null && lllllllllllIIIlIllllIlIIIIllIlII.isAssignableFrom(lllllllllllIIIlIllllIlIIIIllIIll.getClass())) {
            return (T)lllllllllllIIIlIllllIlIIIIllIIll;
        }
        throw new EntityNotFoundException(lllllllllllIIIlIllllIlIIIIllIlIl);
    }
    
    public static long parseLong(final String lllllllllllIIIlIllllIlIIlIIlllII, final long lllllllllllIIIlIllllIlIIlIIlIlll, final long lllllllllllIIIlIllllIlIIlIIlIllI) throws NumberInvalidException {
        final long lllllllllllIIIlIllllIlIIlIIllIIl = parseLong(lllllllllllIIIlIllllIlIIlIIlllII);
        if (lllllllllllIIIlIllllIlIIlIIllIIl < lllllllllllIIIlIllllIlIIlIIlIlll) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { lllllllllllIIIlIllllIlIIlIIllIIl, lllllllllllIIIlIllllIlIIlIIlIlll });
        }
        if (lllllllllllIIIlIllllIlIIlIIllIIl > lllllllllllIIIlIllllIlIIlIIlIllI) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { lllllllllllIIIlIllllIlIIlIIllIIl, lllllllllllIIIlIllllIlIIlIIlIllI });
        }
        return lllllllllllIIIlIllllIlIIlIIllIIl;
    }
    
    public static String getEntityName(final MinecraftServer lllllllllllIIIlIllllIlIIIIIlIIII, final ICommandSender lllllllllllIIIlIllllIlIIIIIIllll, final String lllllllllllIIIlIllllIlIIIIIIlIIl) throws EntityNotFoundException, CommandException {
        try {
            return getPlayer(lllllllllllIIIlIllllIlIIIIIlIIII, lllllllllllIIIlIllllIlIIIIIIllll, lllllllllllIIIlIllllIlIIIIIIlIIl).getName();
        }
        catch (PlayerNotFoundException lllllllllllIIIlIllllIlIIIIIIllIl) {
            try {
                return getEntity(lllllllllllIIIlIllllIlIIIIIlIIII, lllllllllllIIIlIllllIlIIIIIIllll, lllllllllllIIIlIllllIlIIIIIIlIIl).getCachedUniqueIdString();
            }
            catch (EntityNotFoundException lllllllllllIIIlIllllIlIIIIIIllII) {
                if (EntitySelector.hasArguments(lllllllllllIIIlIllllIlIIIIIIlIIl)) {
                    throw lllllllllllIIIlIllllIlIIIIIIllII;
                }
                return lllllllllllIIIlIllllIlIIIIIIlIIl;
            }
        }
    }
    
    private static EntityPlayerMP func_193512_a(final MinecraftServer lllllllllllIIIlIllllIlIIIlIIlIlI, @Nullable EntityPlayerMP lllllllllllIIIlIllllIlIIIlIIlIIl, final String lllllllllllIIIlIllllIlIIIlIIlIll) throws CommandException {
        if (lllllllllllIIIlIllllIlIIIlIIlIIl == null) {
            try {
                lllllllllllIIIlIllllIlIIIlIIlIIl = lllllllllllIIIlIllllIlIIIlIIlIlI.getPlayerList().getPlayerByUUID(UUID.fromString(lllllllllllIIIlIllllIlIIIlIIlIll));
            }
            catch (IllegalArgumentException ex) {}
        }
        if (lllllllllllIIIlIllllIlIIIlIIlIIl == null) {
            lllllllllllIIIlIllllIlIIIlIIlIIl = lllllllllllIIIlIllllIlIIIlIIlIlI.getPlayerList().getPlayerByUsername(lllllllllllIIIlIllllIlIIIlIIlIll);
        }
        if (lllllllllllIIIlIllllIlIIIlIIlIIl == null) {
            throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[] { lllllllllllIIIlIllllIlIIIlIIlIll });
        }
        return lllllllllllIIIlIllllIlIIIlIIlIIl;
    }
    
    public static int parseInt(final String lllllllllllIIIlIllllIlIIlIllIlII, final int lllllllllllIIIlIllllIlIIlIllIIll) throws NumberInvalidException {
        return parseInt(lllllllllllIIIlIllllIlIIlIllIlII, lllllllllllIIIlIllllIlIIlIllIIll, Integer.MAX_VALUE);
    }
    
    public static String joinNiceStringFromCollection(final Collection<String> lllllllllllIIIlIllllIIllIIIlllll) {
        return joinNiceString(lllllllllllIIIlIllllIIllIIIlllll.toArray(new String[lllllllllllIIIlIllllIIllIIIlllll.size()]));
    }
    
    public static double parseDouble(final double lllllllllllIIIlIllllIIlllIlIIIll, String lllllllllllIIIlIllllIIlllIIllIlI, final int lllllllllllIIIlIllllIIlllIIllIIl, final int lllllllllllIIIlIllllIIlllIlIIIII, final boolean lllllllllllIIIlIllllIIlllIIlllll) throws NumberInvalidException {
        final boolean lllllllllllIIIlIllllIIlllIIllllI = ((String)lllllllllllIIIlIllllIIlllIIllIlI).startsWith("~");
        if (lllllllllllIIIlIllllIIlllIIllllI && Double.isNaN(lllllllllllIIIlIllllIIlllIlIIIll)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllIIIlIllllIIlllIlIIIll });
        }
        double lllllllllllIIIlIllllIIlllIIlllIl = lllllllllllIIIlIllllIIlllIIllllI ? lllllllllllIIIlIllllIIlllIlIIIll : 0.0;
        if (!lllllllllllIIIlIllllIIlllIIllllI || ((String)lllllllllllIIIlIllllIIlllIIllIlI).length() > 1) {
            final boolean lllllllllllIIIlIllllIIlllIIlllII = ((String)lllllllllllIIIlIllllIIlllIIllIlI).contains(".");
            if (lllllllllllIIIlIllllIIlllIIllllI) {
                lllllllllllIIIlIllllIIlllIIllIlI = ((String)lllllllllllIIIlIllllIIlllIIllIlI).substring(1);
            }
            lllllllllllIIIlIllllIIlllIIlllIl += parseDouble((String)lllllllllllIIIlIllllIIlllIIllIlI);
            if (!lllllllllllIIIlIllllIIlllIIlllII && !lllllllllllIIIlIllllIIlllIIllllI && lllllllllllIIIlIllllIIlllIIlllll) {
                lllllllllllIIIlIllllIIlllIIlllIl += 0.5;
            }
        }
        if (lllllllllllIIIlIllllIIlllIIllIIl != 0 || lllllllllllIIIlIllllIIlllIlIIIII != 0) {
            if (lllllllllllIIIlIllllIIlllIIlllIl < lllllllllllIIIlIllllIIlllIIllIIl) {
                throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { String.format("%.2f", lllllllllllIIIlIllllIIlllIIlllIl), lllllllllllIIIlIllllIIlllIIllIIl });
            }
            if (lllllllllllIIIlIllllIIlllIIlllIl > lllllllllllIIIlIllllIIlllIlIIIII) {
                throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { String.format("%.2f", lllllllllllIIIlIllllIIlllIIlllIl), lllllllllllIIIlIllllIIlllIlIIIII });
            }
        }
        return lllllllllllIIIlIllllIIlllIIlllIl;
    }
    
    public static boolean doesStringStartWith(final String lllllllllllIIIlIllllIIlIlllllIII, final String lllllllllllIIIlIllllIIlIlllllIIl) {
        return lllllllllllIIIlIllllIIlIlllllIIl.regionMatches(true, 0, lllllllllllIIIlIllllIIlIlllllIII, 0, lllllllllllIIIlIllllIIlIlllllIII.length());
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIIIlIllllIIlIllIlllIl, final int lllllllllllIIIlIllllIIlIllIlllII) {
        return false;
    }
    
    static {
        field_190796_b = Splitter.on(',');
        field_190797_c = Splitter.on('=').limit(2);
    }
    
    public static double parseDouble(final String lllllllllllIIIlIllllIlIIIllllIlI, final double lllllllllllIIIlIllllIlIIIllllIIl) throws NumberInvalidException {
        return parseDouble(lllllllllllIIIlIllllIlIIIllllIlI, lllllllllllIIIlIllllIlIIIllllIIl, Double.MAX_VALUE);
    }
    
    @Override
    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }
    
    public static List<EntityPlayerMP> func_193513_a(final MinecraftServer lllllllllllIIIlIllllIlIIIllIIIlI, final ICommandSender lllllllllllIIIlIllllIlIIIlIlllIl, final String lllllllllllIIIlIllllIlIIIlIlllII) throws CommandException {
        final List<EntityPlayerMP> lllllllllllIIIlIllllIlIIIlIlllll = EntitySelector.func_193531_b(lllllllllllIIIlIllllIlIIIlIlllIl, lllllllllllIIIlIllllIlIIIlIlllII);
        return lllllllllllIIIlIllllIlIIIlIlllll.isEmpty() ? Lists.newArrayList((Object[])new EntityPlayerMP[] { func_193512_a(lllllllllllIIIlIllllIlIIIllIIIlI, null, lllllllllllIIIlIllllIlIIIlIlllII) }) : lllllllllllIIIlIllllIlIIIlIlllll;
    }
    
    public static double parseDouble(final String lllllllllllIIIlIllllIlIIIlllIlII, final double lllllllllllIIIlIllllIlIIIlllIIll, final double lllllllllllIIIlIllllIlIIIllIlllI) throws NumberInvalidException {
        final double lllllllllllIIIlIllllIlIIIlllIIIl = parseDouble(lllllllllllIIIlIllllIlIIIlllIlII);
        if (lllllllllllIIIlIllllIlIIIlllIIIl < lllllllllllIIIlIllllIlIIIlllIIll) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { String.format("%.2f", lllllllllllIIIlIllllIlIIIlllIIIl), String.format("%.2f", lllllllllllIIIlIllllIlIIIlllIIll) });
        }
        if (lllllllllllIIIlIllllIlIIIlllIIIl > lllllllllllIIIlIllllIlIIIllIlllI) {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { String.format("%.2f", lllllllllllIIIlIllllIlIIIlllIIIl), String.format("%.2f", lllllllllllIIIlIllllIlIIIllIlllI) });
        }
        return lllllllllllIIIlIllllIlIIIlllIIIl;
    }
    
    public static ITextComponent join(final List<ITextComponent> lllllllllllIIIlIllllIIllIIlIIIll) {
        final ITextComponent lllllllllllIIIlIllllIIllIIlIIlIl = new TextComponentString("");
        for (int lllllllllllIIIlIllllIIllIIlIIlII = 0; lllllllllllIIIlIllllIIllIIlIIlII < lllllllllllIIIlIllllIIllIIlIIIll.size(); ++lllllllllllIIIlIllllIIllIIlIIlII) {
            if (lllllllllllIIIlIllllIIllIIlIIlII > 0) {
                if (lllllllllllIIIlIllllIIllIIlIIlII == lllllllllllIIIlIllllIIllIIlIIIll.size() - 1) {
                    lllllllllllIIIlIllllIIllIIlIIlIl.appendText(" and ");
                }
                else if (lllllllllllIIIlIllllIIllIIlIIlII > 0) {
                    lllllllllllIIIlIllllIIllIIlIIlIl.appendText(", ");
                }
            }
            lllllllllllIIIlIllllIIllIIlIIlIl.appendSibling(lllllllllllIIIlIllllIIllIIlIIIll.get(lllllllllllIIIlIllllIIllIIlIIlII));
        }
        return lllllllllllIIIlIllllIIllIIlIIlIl;
    }
    
    public static ITextComponent getChatComponentFromNthArg(final ICommandSender lllllllllllIIIlIllllIlIIIIIIIIll, final String[] lllllllllllIIIlIllllIlIIIIIIIIlI, final int lllllllllllIIIlIllllIlIIIIIIIIIl) throws CommandException, PlayerNotFoundException {
        return getChatComponentFromNthArg(lllllllllllIIIlIllllIlIIIIIIIIll, lllllllllllIIIlIllllIlIIIIIIIIlI, lllllllllllIIIlIllllIlIIIIIIIIIl, false);
    }
    
    public static String buildString(final String[] lllllllllllIIIlIllllIIlllllIIIII, final int lllllllllllIIIlIllllIIllllIllIlI) {
        final StringBuilder lllllllllllIIIlIllllIIllllIllllI = new StringBuilder();
        for (int lllllllllllIIIlIllllIIllllIlllIl = lllllllllllIIIlIllllIIllllIllIlI; lllllllllllIIIlIllllIIllllIlllIl < lllllllllllIIIlIllllIIlllllIIIII.length; ++lllllllllllIIIlIllllIIllllIlllIl) {
            if (lllllllllllIIIlIllllIIllllIlllIl > lllllllllllIIIlIllllIIllllIllIlI) {
                lllllllllllIIIlIllllIIllllIllllI.append(" ");
            }
            final String lllllllllllIIIlIllllIIllllIlllII = lllllllllllIIIlIllllIIlllllIIIII[lllllllllllIIIlIllllIIllllIlllIl];
            lllllllllllIIIlIllllIIllllIllllI.append(lllllllllllIIIlIllllIIllllIlllII);
        }
        return lllllllllllIIIlIllllIIllllIllllI.toString();
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIIIlIllllIlIIllIIIIlI, final ICommandSender lllllllllllIIIlIllllIlIIllIIIIIl, final String[] lllllllllllIIIlIllllIlIIllIIIIII, @Nullable final BlockPos lllllllllllIIIlIllllIlIIlIllllll) {
        return Collections.emptyList();
    }
    
    public int getRequiredPermissionLevel() {
        return 4;
    }
    
    public static EntityPlayerMP getPlayer(final MinecraftServer lllllllllllIIIlIllllIlIIIlIlIlll, final ICommandSender lllllllllllIIIlIllllIlIIIlIlIIll, final String lllllllllllIIIlIllllIlIIIlIlIIlI) throws CommandException, PlayerNotFoundException {
        return func_193512_a(lllllllllllIIIlIllllIlIIIlIlIlll, EntitySelector.matchOnePlayer(lllllllllllIIIlIllllIlIIIlIlIIll, lllllllllllIIIlIllllIlIIIlIlIIlI), lllllllllllIIIlIllllIlIIIlIlIIlI);
    }
    
    public static List<String> getListOfStringsMatchingLastWord(final String[] lllllllllllIIIlIllllIIlIlllIIlII, final Collection<?> lllllllllllIIIlIllllIIlIlllIlIIl) {
        final String lllllllllllIIIlIllllIIlIlllIlIII = lllllllllllIIIlIllllIIlIlllIIlII[lllllllllllIIIlIllllIIlIlllIIlII.length - 1];
        final List<String> lllllllllllIIIlIllllIIlIlllIIlll = (List<String>)Lists.newArrayList();
        if (!lllllllllllIIIlIllllIIlIlllIlIIl.isEmpty()) {
            for (final String lllllllllllIIIlIllllIIlIlllIIllI : Iterables.transform((Iterable)lllllllllllIIIlIllllIIlIlllIlIIl, Functions.toStringFunction())) {
                if (doesStringStartWith(lllllllllllIIIlIllllIIlIlllIlIII, lllllllllllIIIlIllllIIlIlllIIllI)) {
                    lllllllllllIIIlIllllIIlIlllIIlll.add(lllllllllllIIIlIllllIIlIlllIIllI);
                }
            }
            if (lllllllllllIIIlIllllIIlIlllIIlll.isEmpty()) {
                for (final Object lllllllllllIIIlIllllIIlIlllIIlIl : lllllllllllIIIlIllllIIlIlllIlIIl) {
                    if (lllllllllllIIIlIllllIIlIlllIIlIl instanceof ResourceLocation && doesStringStartWith(lllllllllllIIIlIllllIIlIlllIlIII, ((ResourceLocation)lllllllllllIIIlIllllIIlIlllIIlIl).getResourcePath())) {
                        lllllllllllIIIlIllllIIlIlllIIlll.add(String.valueOf(lllllllllllIIIlIllllIIlIlllIIlIl));
                    }
                }
            }
        }
        return lllllllllllIIIlIllllIIlIlllIIlll;
    }
    
    public static CoordinateArg parseCoordinate(final double lllllllllllIIIlIllllIIlllIllllII, String lllllllllllIIIlIllllIIlllIlllIll, final int lllllllllllIIIlIllllIIllllIIIIll, final int lllllllllllIIIlIllllIIlllIlllIIl, final boolean lllllllllllIIIlIllllIIlllIlllIII) throws NumberInvalidException {
        final boolean lllllllllllIIIlIllllIIllllIIIIII = lllllllllllIIIlIllllIIlllIlllIll.startsWith("~");
        if (lllllllllllIIIlIllllIIllllIIIIII && Double.isNaN(lllllllllllIIIlIllllIIlllIllllII)) {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { lllllllllllIIIlIllllIIlllIllllII });
        }
        double lllllllllllIIIlIllllIIlllIllllll = 0.0;
        if (!lllllllllllIIIlIllllIIllllIIIIII || lllllllllllIIIlIllllIIlllIlllIll.length() > 1) {
            final boolean lllllllllllIIIlIllllIIlllIlllllI = lllllllllllIIIlIllllIIlllIlllIll.contains(".");
            if (lllllllllllIIIlIllllIIllllIIIIII) {
                lllllllllllIIIlIllllIIlllIlllIll = lllllllllllIIIlIllllIIlllIlllIll.substring(1);
            }
            lllllllllllIIIlIllllIIlllIllllll += parseDouble(lllllllllllIIIlIllllIIlllIlllIll);
            if (!lllllllllllIIIlIllllIIlllIlllllI && !lllllllllllIIIlIllllIIllllIIIIII && lllllllllllIIIlIllllIIlllIlllIII) {
                lllllllllllIIIlIllllIIlllIllllll += 0.5;
            }
        }
        final double lllllllllllIIIlIllllIIlllIllllIl = lllllllllllIIIlIllllIIlllIllllll + (lllllllllllIIIlIllllIIllllIIIIII ? lllllllllllIIIlIllllIIlllIllllII : 0.0);
        if (lllllllllllIIIlIllllIIllllIIIIll != 0 || lllllllllllIIIlIllllIIlllIlllIIl != 0) {
            if (lllllllllllIIIlIllllIIlllIllllIl < lllllllllllIIIlIllllIIllllIIIIll) {
                throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { String.format("%.2f", lllllllllllIIIlIllllIIlllIllllIl), lllllllllllIIIlIllllIIllllIIIIll });
            }
            if (lllllllllllIIIlIllllIIlllIllllIl > lllllllllllIIIlIllllIIlllIlllIIl) {
                throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { String.format("%.2f", lllllllllllIIIlIllllIIlllIllllIl), lllllllllllIIIlIllllIIlllIlllIIl });
            }
        }
        return new CoordinateArg(lllllllllllIIIlIllllIIlllIllllIl, lllllllllllIIIlIllllIIlllIllllll, lllllllllllIIIlIllllIIllllIIIIII);
    }
    
    public static IBlockState func_190794_a(final Block lllllllllllIIIlIllllIIllIlllIIll, final String lllllllllllIIIlIllllIIllIlllIIlI) throws NumberInvalidException, InvalidBlockStateException {
        try {
            final int lllllllllllIIIlIllllIIllIllllIIl = Integer.parseInt(lllllllllllIIIlIllllIIllIlllIIlI);
            if (lllllllllllIIIlIllllIIllIllllIIl < 0) {
                throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { lllllllllllIIIlIllllIIllIllllIIl, 0 });
            }
            if (lllllllllllIIIlIllllIIllIllllIIl > 15) {
                throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { lllllllllllIIIlIllllIIllIllllIIl, 15 });
            }
            return lllllllllllIIIlIllllIIllIlllIIll.getStateFromMeta(Integer.parseInt(lllllllllllIIIlIllllIIllIlllIIlI));
        }
        catch (RuntimeException lllllllllllIIIlIllllIIllIllllIII) {
            try {
                final Map<IProperty<?>, Comparable<?>> lllllllllllIIIlIllllIIllIlllIlll = func_190795_c(lllllllllllIIIlIllllIIllIlllIIll, lllllllllllIIIlIllllIIllIlllIIlI);
                IBlockState lllllllllllIIIlIllllIIllIlllIllI = lllllllllllIIIlIllllIIllIlllIIll.getDefaultState();
                for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllIIIlIllllIIllIlllIlIl : lllllllllllIIIlIllllIIllIlllIlll.entrySet()) {
                    lllllllllllIIIlIllllIIllIlllIllI = func_190793_a(lllllllllllIIIlIllllIIllIlllIllI, lllllllllllIIIlIllllIIllIlllIlIl.getKey(), lllllllllllIIIlIllllIIllIlllIlIl.getValue());
                }
                return lllllllllllIIIlIllllIIllIlllIllI;
            }
            catch (RuntimeException lllllllllllIIIlIllllIIllIlllIlII) {
                throw new InvalidBlockStateException("commands.generic.blockstate.invalid", new Object[] { lllllllllllIIIlIllllIIllIlllIIlI, Block.REGISTRY.getNameForObject(lllllllllllIIIlIllllIIllIlllIIll) });
            }
        }
    }
    
    public static List<String> getListOfStringsMatchingLastWord(final String[] lllllllllllIIIlIllllIIlIllllIIlI, final String... lllllllllllIIIlIllllIIlIllllIIIl) {
        return getListOfStringsMatchingLastWord(lllllllllllIIIlIllllIIlIllllIIlI, Arrays.asList(lllllllllllIIIlIllllIIlIllllIIIl));
    }
    
    public static double parseDouble(final double lllllllllllIIIlIllllIIlllIlIlllI, final String lllllllllllIIIlIllllIIlllIlIllIl, final boolean lllllllllllIIIlIllllIIlllIlIllII) throws NumberInvalidException {
        return parseDouble(lllllllllllIIIlIllllIIlllIlIlllI, lllllllllllIIIlIllllIIlllIlIllIl, -30000000, 30000000, lllllllllllIIIlIllllIIlllIlIllII);
    }
    
    public static boolean parseBoolean(final String lllllllllllIIIlIllllIlIIIllIlIll) throws CommandException {
        if ("true".equals(lllllllllllIIIlIllllIlIIIllIlIll) || "1".equals(lllllllllllIIIlIllllIlIIIllIlIll)) {
            return true;
        }
        if (!"false".equals(lllllllllllIIIlIllllIlIIIllIlIll) && !"0".equals(lllllllllllIIIlIllllIlIIIllIlIll)) {
            throw new CommandException("commands.generic.boolean.invalid", new Object[] { lllllllllllIIIlIllllIlIIIllIlIll });
        }
        return false;
    }
    
    private static Map<IProperty<?>, Comparable<?>> func_190795_c(final Block lllllllllllIIIlIllllIIllIlIIIlII, final String lllllllllllIIIlIllllIIllIlIIIIll) throws InvalidBlockStateException {
        final Map<IProperty<?>, Comparable<?>> lllllllllllIIIlIllllIIllIlIIlIll = (Map<IProperty<?>, Comparable<?>>)Maps.newHashMap();
        if ("default".equals(lllllllllllIIIlIllllIIllIlIIIIll)) {
            return (Map<IProperty<?>, Comparable<?>>)lllllllllllIIIlIllllIIllIlIIIlII.getDefaultState().getProperties();
        }
        final BlockStateContainer lllllllllllIIIlIllllIIllIlIIlIlI = lllllllllllIIIlIllllIIllIlIIIlII.getBlockState();
        for (final String lllllllllllIIIlIllllIIllIlIIlIII : CommandBase.field_190796_b.split((CharSequence)lllllllllllIIIlIllllIIllIlIIIIll)) {
            final Iterator<String> lllllllllllIIIlIllllIIllIlIIIlll = CommandBase.field_190797_c.split((CharSequence)lllllllllllIIIlIllllIIllIlIIlIII).iterator();
            if (lllllllllllIIIlIllllIIllIlIIIlll.hasNext()) {
                final IProperty<?> lllllllllllIIIlIllllIIllIlIIIllI = lllllllllllIIIlIllllIIllIlIIlIlI.getProperty(lllllllllllIIIlIllllIIllIlIIIlll.next());
                if (lllllllllllIIIlIllllIIllIlIIIllI != null) {
                    if (lllllllllllIIIlIllllIIllIlIIIlll.hasNext()) {
                        final Comparable<?> lllllllllllIIIlIllllIIllIlIIIlIl = func_190792_a(lllllllllllIIIlIllllIIllIlIIIllI, lllllllllllIIIlIllllIIllIlIIIlll.next());
                        if (lllllllllllIIIlIllllIIllIlIIIlIl != null) {
                            lllllllllllIIIlIllllIIllIlIIlIll.put(lllllllllllIIIlIllllIIllIlIIIllI, lllllllllllIIIlIllllIIllIlIIIlIl);
                            continue;
                        }
                    }
                }
            }
            throw new InvalidBlockStateException("commands.generic.blockstate.invalid", new Object[] { lllllllllllIIIlIllllIIllIlIIIIll, Block.REGISTRY.getNameForObject(lllllllllllIIIlIllllIIllIlIIIlII) });
        }
        return lllllllllllIIIlIllllIIllIlIIlIll;
    }
    
    public static Item getItemByText(final ICommandSender lllllllllllIIIlIllllIIlllIIlIIII, final String lllllllllllIIIlIllllIIlllIIIllll) throws NumberInvalidException {
        final ResourceLocation lllllllllllIIIlIllllIIlllIIIlllI = new ResourceLocation(lllllllllllIIIlIllllIIlllIIIllll);
        final Item lllllllllllIIIlIllllIIlllIIIllIl = Item.REGISTRY.getObject(lllllllllllIIIlIllllIIlllIIIlllI);
        if (lllllllllllIIIlIllllIIlllIIIllIl == null) {
            throw new NumberInvalidException("commands.give.item.notFound", new Object[] { lllllllllllIIIlIllllIIlllIIIlllI });
        }
        return lllllllllllIIIlIllllIIlllIIIllIl;
    }
    
    public static Block getBlockByText(final ICommandSender lllllllllllIIIlIllllIIlllIIIIlll, final String lllllllllllIIIlIllllIIlllIIIIllI) throws NumberInvalidException {
        final ResourceLocation lllllllllllIIIlIllllIIlllIIIIlIl = new ResourceLocation(lllllllllllIIIlIllllIIlllIIIIllI);
        if (!Block.REGISTRY.containsKey(lllllllllllIIIlIllllIIlllIIIIlIl)) {
            throw new NumberInvalidException("commands.give.block.notFound", new Object[] { lllllllllllIIIlIllllIIlllIIIIlIl });
        }
        return Block.REGISTRY.getObject(lllllllllllIIIlIllllIIlllIIIIlIl);
    }
    
    public static Predicate<IBlockState> func_190791_b(final Block lllllllllllIIIlIllllIIllIlIllIlI, final String lllllllllllIIIlIllllIIllIlIllIIl) throws InvalidBlockStateException {
        if (!"*".equals(lllllllllllIIIlIllllIIllIlIllIIl) && !"-1".equals(lllllllllllIIIlIllllIIllIlIllIIl)) {
            try {
                final int lllllllllllIIIlIllllIIllIlIlllIl = Integer.parseInt(lllllllllllIIIlIllllIIllIlIllIIl);
                return (Predicate<IBlockState>)new Predicate<IBlockState>() {
                    public boolean apply(@Nullable final IBlockState lllllllllllIlIIIlllIllIIllllIlll) {
                        return lllllllllllIIIlIllllIIllIlIlllIl == lllllllllllIlIIIlllIllIIllllIlll.getBlock().getMetaFromState(lllllllllllIlIIIlllIllIIllllIlll);
                    }
                };
            }
            catch (RuntimeException lllllllllllIIIlIllllIIllIlIlllII) {
                final Map<IProperty<?>, Comparable<?>> lllllllllllIIIlIllllIIllIlIllIll = func_190795_c(lllllllllllIIIlIllllIIllIlIllIlI, lllllllllllIIIlIllllIIllIlIllIIl);
                return (Predicate<IBlockState>)new Predicate<IBlockState>() {
                    public boolean apply(@Nullable final IBlockState lllllllllllIlIIIlllIIllllIIlIlII) {
                        if (lllllllllllIlIIIlllIIllllIIlIlII != null && lllllllllllIIIlIllllIIllIlIllIlI == lllllllllllIlIIIlllIIllllIIlIlII.getBlock()) {
                            for (final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllIlIIIlllIIllllIIlIIll : lllllllllllIIIlIllllIIllIlIllIll.entrySet()) {
                                if (!lllllllllllIlIIIlllIIllllIIlIlII.getValue(lllllllllllIlIIIlllIIllllIIlIIll.getKey()).equals(lllllllllllIlIIIlllIIllllIIlIIll.getValue())) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                };
            }
        }
        return (Predicate<IBlockState>)Predicates.alwaysTrue();
    }
    
    public static EntityPlayerMP getCommandSenderAsPlayer(final ICommandSender lllllllllllIIIlIllllIlIIIllIIlll) throws PlayerNotFoundException {
        if (lllllllllllIIIlIllllIlIIIllIIlll instanceof EntityPlayerMP) {
            return (EntityPlayerMP)lllllllllllIIIlIllllIlIIIllIIlll;
        }
        throw new PlayerNotFoundException("commands.generic.player.unspecified");
    }
    
    public static void notifyCommandListener(final ICommandSender lllllllllllIIIlIllllIIlIllIlIIll, final ICommand lllllllllllIIIlIllllIIlIllIlIIlI, final String lllllllllllIIIlIllllIIlIllIlIIIl, final Object... lllllllllllIIIlIllllIIlIllIlIIII) {
        notifyCommandListener(lllllllllllIIIlIllllIIlIllIlIIll, lllllllllllIIIlIllllIIlIllIlIIlI, 0, lllllllllllIIIlIllllIIlIllIlIIIl, lllllllllllIIIlIllllIIlIllIlIIII);
    }
    
    private static <T extends Comparable<T>> IBlockState func_190793_a(final IBlockState lllllllllllIIIlIllllIIllIllIIllI, final IProperty<T> lllllllllllIIIlIllllIIllIllIIlIl, final Comparable<?> lllllllllllIIIlIllllIIllIllIIlll) {
        return lllllllllllIIIlIllllIIllIllIIllI.withProperty(lllllllllllIIIlIllllIIllIllIIlIl, lllllllllllIIIlIllllIIllIllIIlll);
    }
    
    public static CoordinateArg parseCoordinate(final double lllllllllllIIIlIllllIIllllIlIIII, final String lllllllllllIIIlIllllIIllllIIllll, final boolean lllllllllllIIIlIllllIIllllIlIIIl) throws NumberInvalidException {
        return parseCoordinate(lllllllllllIIIlIllllIIllllIlIIII, lllllllllllIIIlIllllIIllllIIllll, -30000000, 30000000, lllllllllllIIIlIllllIIllllIlIIIl);
    }
    
    public static List<String> getTabCompletionCoordinateXZ(final String[] lllllllllllIIIlIllllIIllIIIIIlll, final int lllllllllllIIIlIllllIIllIIIIIllI, @Nullable final BlockPos lllllllllllIIIlIllllIIllIIIIIlIl) {
        if (lllllllllllIIIlIllllIIllIIIIIlIl == null) {
            return (List<String>)Lists.newArrayList((Object[])new String[] { "~" });
        }
        final int lllllllllllIIIlIllllIIllIIIIIlII = lllllllllllIIIlIllllIIllIIIIIlll.length - 1;
        String lllllllllllIIIlIllllIIllIIIIIIlI = null;
        if (lllllllllllIIIlIllllIIllIIIIIlII == lllllllllllIIIlIllllIIllIIIIIllI) {
            final String lllllllllllIIIlIllllIIllIIIIIIll = Integer.toString(lllllllllllIIIlIllllIIllIIIIIlIl.getX());
        }
        else {
            if (lllllllllllIIIlIllllIIllIIIIIlII != lllllllllllIIIlIllllIIllIIIIIllI + 1) {
                return Collections.emptyList();
            }
            lllllllllllIIIlIllllIIllIIIIIIlI = Integer.toString(lllllllllllIIIlIllllIIllIIIIIlIl.getZ());
        }
        return (List<String>)Lists.newArrayList((Object[])new String[] { lllllllllllIIIlIllllIIllIIIIIIlI });
    }
    
    public static Entity getEntity(final MinecraftServer lllllllllllIIIlIllllIlIIIlIIIIII, final ICommandSender lllllllllllIIIlIllllIlIIIIllllll, final String lllllllllllIIIlIllllIlIIIlIIIIIl) throws EntityNotFoundException, CommandException {
        return getEntity(lllllllllllIIIlIllllIlIIIlIIIIII, lllllllllllIIIlIllllIlIIIIllllll, lllllllllllIIIlIllllIlIIIlIIIIIl, (Class<? extends Entity>)Entity.class);
    }
    
    public static List<Entity> getEntityList(final MinecraftServer lllllllllllIIIlIllllIlIIIIlIIlll, final ICommandSender lllllllllllIIIlIllllIlIIIIlIIIll, final String lllllllllllIIIlIllllIlIIIIlIIIlI) throws EntityNotFoundException, CommandException {
        return EntitySelector.hasArguments(lllllllllllIIIlIllllIlIIIIlIIIlI) ? EntitySelector.matchEntities(lllllllllllIIIlIllllIlIIIIlIIIll, lllllllllllIIIlIllllIlIIIIlIIIlI, (Class<? extends Entity>)Entity.class) : Lists.newArrayList((Object[])new Entity[] { getEntity(lllllllllllIIIlIllllIlIIIIlIIlll, lllllllllllIIIlIllllIlIIIIlIIIll, lllllllllllIIIlIllllIlIIIIlIIIlI) });
    }
    
    public static ITextComponent getChatComponentFromNthArg(final ICommandSender lllllllllllIIIlIllllIIllllllIlIl, final String[] lllllllllllIIIlIllllIIllllllIlII, final int lllllllllllIIIlIllllIIlllllIlIll, final boolean lllllllllllIIIlIllllIIllllllIIlI) throws PlayerNotFoundException, CommandException {
        final ITextComponent lllllllllllIIIlIllllIIllllllIIIl = new TextComponentString("");
        for (int lllllllllllIIIlIllllIIllllllIIII = lllllllllllIIIlIllllIIlllllIlIll; lllllllllllIIIlIllllIIllllllIIII < lllllllllllIIIlIllllIIllllllIlII.length; ++lllllllllllIIIlIllllIIllllllIIII) {
            if (lllllllllllIIIlIllllIIllllllIIII > lllllllllllIIIlIllllIIlllllIlIll) {
                lllllllllllIIIlIllllIIllllllIIIl.appendText(" ");
            }
            ITextComponent lllllllllllIIIlIllllIIlllllIllll = new TextComponentString(lllllllllllIIIlIllllIIllllllIlII[lllllllllllIIIlIllllIIllllllIIII]);
            if (lllllllllllIIIlIllllIIllllllIIlI) {
                final ITextComponent lllllllllllIIIlIllllIIlllllIlllI = EntitySelector.matchEntitiesToTextComponent(lllllllllllIIIlIllllIIllllllIlIl, lllllllllllIIIlIllllIIllllllIlII[lllllllllllIIIlIllllIIllllllIIII]);
                if (lllllllllllIIIlIllllIIlllllIlllI == null) {
                    if (EntitySelector.hasArguments(lllllllllllIIIlIllllIIllllllIlII[lllllllllllIIIlIllllIIllllllIIII])) {
                        throw new PlayerNotFoundException("commands.generic.selector.notFound", new Object[] { lllllllllllIIIlIllllIIllllllIlII[lllllllllllIIIlIllllIIllllllIIII] });
                    }
                }
                else {
                    lllllllllllIIIlIllllIIlllllIllll = lllllllllllIIIlIllllIIlllllIlllI;
                }
            }
            lllllllllllIIIlIllllIIllllllIIIl.appendSibling(lllllllllllIIIlIllllIIlllllIllll);
        }
        return lllllllllllIIIlIllllIIllllllIIIl;
    }
    
    public static void setCommandListener(final ICommandListener lllllllllllIIIlIllllIIlIlIllllll) {
        CommandBase.commandListener = lllllllllllIIIlIllllIIlIlIllllll;
    }
    
    public static String getPlayerName(final MinecraftServer lllllllllllIIIlIllllIlIIIIIlllIl, final ICommandSender lllllllllllIIIlIllllIlIIIIIlllII, final String lllllllllllIIIlIllllIlIIIIIllIll) throws PlayerNotFoundException, CommandException {
        try {
            return getPlayer(lllllllllllIIIlIllllIlIIIIIlllIl, lllllllllllIIIlIllllIlIIIIIlllII, lllllllllllIIIlIllllIlIIIIIllIll).getName();
        }
        catch (CommandException lllllllllllIIIlIllllIlIIIIIllIlI) {
            if (EntitySelector.hasArguments(lllllllllllIIIlIllllIlIIIIIllIll)) {
                throw lllllllllllIIIlIllllIlIIIIIllIlI;
            }
            return lllllllllllIIIlIllllIlIIIIIllIll;
        }
    }
    
    public static class CoordinateArg
    {
        private final /* synthetic */ boolean isRelative;
        private final /* synthetic */ double result;
        private final /* synthetic */ double amount;
        
        public double getAmount() {
            return this.amount;
        }
        
        protected CoordinateArg(final double lllllllllllIlllIIIlIIllIIlllllll, final double lllllllllllIlllIIIlIIllIlIIIIIlI, final boolean lllllllllllIlllIIIlIIllIIlllllIl) {
            this.result = lllllllllllIlllIIIlIIllIIlllllll;
            this.amount = lllllllllllIlllIIIlIIllIlIIIIIlI;
            this.isRelative = lllllllllllIlllIIIlIIllIIlllllIl;
        }
        
        public boolean isRelative() {
            return this.isRelative;
        }
        
        public double getResult() {
            return this.result;
        }
    }
}

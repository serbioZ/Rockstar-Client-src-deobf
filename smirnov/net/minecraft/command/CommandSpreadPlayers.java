// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.block.material.Material;
import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.Set;
import com.google.common.collect.Sets;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Random;
import net.minecraft.scoreboard.Team;
import java.util.Map;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import com.google.common.collect.Maps;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandSpreadPlayers extends CommandBase
{
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllllIllIllIIIIIllIII, final ICommandSender llllllllllllllllIllIllIIIIIlIlll, final String[] llllllllllllllllIllIllIIIIIlIlII, @Nullable final BlockPos llllllllllllllllIllIllIIIIIlIlIl) {
        return (llllllllllllllllIllIllIIIIIlIlII.length >= 1 && llllllllllllllllIllIllIIIIIlIlII.length <= 2) ? CommandBase.getTabCompletionCoordinateXZ(llllllllllllllllIllIllIIIIIlIlII, 0, llllllllllllllllIllIllIIIIIlIlIl) : Collections.emptyList();
    }
    
    private double setPlayerPositions(final List<Entity> llllllllllllllllIllIllIIIlIIIlll, final World llllllllllllllllIllIllIIIlIlIlIl, final Position[] llllllllllllllllIllIllIIIlIIIlIl, final boolean llllllllllllllllIllIllIIIlIIIlII) {
        double llllllllllllllllIllIllIIIlIlIIlI = 0.0;
        int llllllllllllllllIllIllIIIlIlIIIl = 0;
        final Map<Team, Position> llllllllllllllllIllIllIIIlIlIIII = (Map<Team, Position>)Maps.newHashMap();
        for (int llllllllllllllllIllIllIIIlIIllll = 0; llllllllllllllllIllIllIIIlIIllll < llllllllllllllllIllIllIIIlIIIlll.size(); ++llllllllllllllllIllIllIIIlIIllll) {
            final Entity llllllllllllllllIllIllIIIlIIlllI = llllllllllllllllIllIllIIIlIIIlll.get(llllllllllllllllIllIllIIIlIIllll);
            Position llllllllllllllllIllIllIIIlIIllII = null;
            if (llllllllllllllllIllIllIIIlIIIlII) {
                final Team llllllllllllllllIllIllIIIlIIlIll = (llllllllllllllllIllIllIIIlIIlllI instanceof EntityPlayer) ? llllllllllllllllIllIllIIIlIIlllI.getTeam() : null;
                if (!llllllllllllllllIllIllIIIlIlIIII.containsKey(llllllllllllllllIllIllIIIlIIlIll)) {
                    llllllllllllllllIllIllIIIlIlIIII.put(llllllllllllllllIllIllIIIlIIlIll, llllllllllllllllIllIllIIIlIIIlIl[llllllllllllllllIllIllIIIlIlIIIl++]);
                }
                final Position llllllllllllllllIllIllIIIlIIllIl = llllllllllllllllIllIllIIIlIlIIII.get(llllllllllllllllIllIllIIIlIIlIll);
            }
            else {
                llllllllllllllllIllIllIIIlIIllII = llllllllllllllllIllIllIIIlIIIlIl[llllllllllllllllIllIllIIIlIlIIIl++];
            }
            llllllllllllllllIllIllIIIlIIlllI.setPositionAndUpdate(MathHelper.floor(llllllllllllllllIllIllIIIlIIllII.x) + 0.5f, llllllllllllllllIllIllIIIlIIllII.getSpawnY(llllllllllllllllIllIllIIIlIlIlIl), MathHelper.floor(llllllllllllllllIllIllIIIlIIllII.z) + 0.5);
            double llllllllllllllllIllIllIIIlIIlIlI = Double.MAX_VALUE;
            final float llllllllllllllllIllIllIIIIlllIIl = (Object)llllllllllllllllIllIllIIIlIIIlIl;
            final double llllllllllllllllIllIllIIIIlllIlI = llllllllllllllllIllIllIIIlIIIlIl.length;
            for (String llllllllllllllllIllIllIIIIlllIll = (String)0; llllllllllllllllIllIllIIIIlllIll < llllllllllllllllIllIllIIIIlllIlI; ++llllllllllllllllIllIllIIIIlllIll) {
                final Position llllllllllllllllIllIllIIIlIIlIIl = llllllllllllllllIllIllIIIIlllIIl[llllllllllllllllIllIllIIIIlllIll];
                if (llllllllllllllllIllIllIIIlIIllII != llllllllllllllllIllIllIIIlIIlIIl) {
                    final double llllllllllllllllIllIllIIIlIIlIII = llllllllllllllllIllIllIIIlIIllII.dist(llllllllllllllllIllIllIIIlIIlIIl);
                    llllllllllllllllIllIllIIIlIIlIlI = Math.min(llllllllllllllllIllIllIIIlIIlIII, llllllllllllllllIllIllIIIlIIlIlI);
                }
            }
            llllllllllllllllIllIllIIIlIlIIlI += llllllllllllllllIllIllIIIlIIlIlI;
        }
        llllllllllllllllIllIllIIIlIlIIlI /= llllllllllllllllIllIllIIIlIIIlll.size();
        return llllllllllllllllIllIllIIIlIlIIlI;
    }
    
    private void spread(final ICommandSender llllllllllllllllIllIllIIllIIIIIl, final List<Entity> llllllllllllllllIllIllIIllIIIIII, final Position llllllllllllllllIllIllIIllIIllll, final double llllllllllllllllIllIllIIlIlllllI, final double llllllllllllllllIllIllIIllIIllIl, final World llllllllllllllllIllIllIIllIIllII, final boolean llllllllllllllllIllIllIIlIlllIll) throws CommandException {
        final Random llllllllllllllllIllIllIIllIIlIlI = new Random();
        final double llllllllllllllllIllIllIIllIIlIIl = llllllllllllllllIllIllIIllIIllll.x - llllllllllllllllIllIllIIllIIllIl;
        final double llllllllllllllllIllIllIIllIIlIII = llllllllllllllllIllIllIIllIIllll.z - llllllllllllllllIllIllIIllIIllIl;
        final double llllllllllllllllIllIllIIllIIIlll = llllllllllllllllIllIllIIllIIllll.x + llllllllllllllllIllIllIIllIIllIl;
        final double llllllllllllllllIllIllIIllIIIllI = llllllllllllllllIllIllIIllIIllll.z + llllllllllllllllIllIllIIllIIllIl;
        final Position[] llllllllllllllllIllIllIIllIIIlIl = this.createInitialPositions(llllllllllllllllIllIllIIllIIlIlI, llllllllllllllllIllIllIIlIlllIll ? this.getNumberOfTeams(llllllllllllllllIllIllIIllIIIIII) : llllllllllllllllIllIllIIllIIIIII.size(), llllllllllllllllIllIllIIllIIlIIl, llllllllllllllllIllIllIIllIIlIII, llllllllllllllllIllIllIIllIIIlll, llllllllllllllllIllIllIIllIIIllI);
        final int llllllllllllllllIllIllIIllIIIlII = this.spreadPositions(llllllllllllllllIllIllIIllIIllll, llllllllllllllllIllIllIIlIlllllI, llllllllllllllllIllIllIIllIIllII, llllllllllllllllIllIllIIllIIlIlI, llllllllllllllllIllIllIIllIIlIIl, llllllllllllllllIllIllIIllIIlIII, llllllllllllllllIllIllIIllIIIlll, llllllllllllllllIllIllIIllIIIllI, llllllllllllllllIllIllIIllIIIlIl, llllllllllllllllIllIllIIlIlllIll);
        final double llllllllllllllllIllIllIIllIIIIll = this.setPlayerPositions(llllllllllllllllIllIllIIllIIIIII, llllllllllllllllIllIllIIllIIllII, llllllllllllllllIllIllIIllIIIlIl, llllllllllllllllIllIllIIlIlllIll);
        CommandBase.notifyCommandListener(llllllllllllllllIllIllIIllIIIIIl, this, "commands.spreadplayers.success." + (llllllllllllllllIllIllIIlIlllIll ? "teams" : "players"), llllllllllllllllIllIllIIllIIIlIl.length, llllllllllllllllIllIllIIllIIllll.x, llllllllllllllllIllIllIIllIIllll.z);
        if (llllllllllllllllIllIllIIllIIIlIl.length > 1) {
            llllllllllllllllIllIllIIllIIIIIl.addChatMessage(new TextComponentTranslation("commands.spreadplayers.info." + (llllllllllllllllIllIllIIlIlllIll ? "teams" : "players"), new Object[] { String.format("%.2f", llllllllllllllllIllIllIIllIIIIll), llllllllllllllllIllIllIIllIIIlII }));
        }
    }
    
    private int getNumberOfTeams(final List<Entity> llllllllllllllllIllIllIIlIlIllIl) {
        final Set<Team> llllllllllllllllIllIllIIlIlIllII = (Set<Team>)Sets.newHashSet();
        for (final Entity llllllllllllllllIllIllIIlIlIlIll : llllllllllllllllIllIllIIlIlIllIl) {
            if (llllllllllllllllIllIllIIlIlIlIll instanceof EntityPlayer) {
                llllllllllllllllIllIllIIlIlIllII.add(llllllllllllllllIllIllIIlIlIlIll.getTeam());
            }
            else {
                llllllllllllllllIllIllIIlIlIllII.add(null);
            }
        }
        return llllllllllllllllIllIllIIlIlIllII.size();
    }
    
    private int spreadPositions(final Position llllllllllllllllIllIllIIlIIlIIIl, final double llllllllllllllllIllIllIIIllllIlI, final World llllllllllllllllIllIllIIlIIIllll, final Random llllllllllllllllIllIllIIIllllIII, final double llllllllllllllllIllIllIIIlllIlll, final double llllllllllllllllIllIllIIlIIIllII, final double llllllllllllllllIllIllIIlIIIlIll, final double llllllllllllllllIllIllIIIlllIlII, final Position[] llllllllllllllllIllIllIIlIIIlIIl, final boolean llllllllllllllllIllIllIIlIIIlIII) throws CommandException {
        boolean llllllllllllllllIllIllIIlIIIIlll = true;
        double llllllllllllllllIllIllIIlIIIIllI = 3.4028234663852886E38;
        int llllllllllllllllIllIllIIlIIIIlIl;
        for (llllllllllllllllIllIllIIlIIIIlIl = 0; llllllllllllllllIllIllIIlIIIIlIl < 10000 && llllllllllllllllIllIllIIlIIIIlll; ++llllllllllllllllIllIllIIlIIIIlIl) {
            llllllllllllllllIllIllIIlIIIIlll = false;
            llllllllllllllllIllIllIIlIIIIllI = 3.4028234663852886E38;
            for (int llllllllllllllllIllIllIIlIIIIlII = 0; llllllllllllllllIllIllIIlIIIIlII < llllllllllllllllIllIllIIlIIIlIIl.length; ++llllllllllllllllIllIllIIlIIIIlII) {
                final Position llllllllllllllllIllIllIIlIIIIIll = llllllllllllllllIllIllIIlIIIlIIl[llllllllllllllllIllIllIIlIIIIlII];
                int llllllllllllllllIllIllIIlIIIIIlI = 0;
                final Position llllllllllllllllIllIllIIlIIIIIIl = new Position();
                for (int llllllllllllllllIllIllIIlIIIIIII = 0; llllllllllllllllIllIllIIlIIIIIII < llllllllllllllllIllIllIIlIIIlIIl.length; ++llllllllllllllllIllIllIIlIIIIIII) {
                    if (llllllllllllllllIllIllIIlIIIIlII != llllllllllllllllIllIllIIlIIIIIII) {
                        final Position llllllllllllllllIllIllIIIlllllll = llllllllllllllllIllIllIIlIIIlIIl[llllllllllllllllIllIllIIlIIIIIII];
                        final double llllllllllllllllIllIllIIIllllllI = llllllllllllllllIllIllIIlIIIIIll.dist(llllllllllllllllIllIllIIIlllllll);
                        llllllllllllllllIllIllIIlIIIIllI = Math.min(llllllllllllllllIllIllIIIllllllI, llllllllllllllllIllIllIIlIIIIllI);
                        if (llllllllllllllllIllIllIIIllllllI < llllllllllllllllIllIllIIIllllIlI) {
                            ++llllllllllllllllIllIllIIlIIIIIlI;
                            final Position position = llllllllllllllllIllIllIIlIIIIIIl;
                            position.x += llllllllllllllllIllIllIIIlllllll.x - llllllllllllllllIllIllIIlIIIIIll.x;
                            final Position position2 = llllllllllllllllIllIllIIlIIIIIIl;
                            position2.z += llllllllllllllllIllIllIIIlllllll.z - llllllllllllllllIllIllIIlIIIIIll.z;
                        }
                    }
                }
                if (llllllllllllllllIllIllIIlIIIIIlI > 0) {
                    final Position position3 = llllllllllllllllIllIllIIlIIIIIIl;
                    position3.x /= llllllllllllllllIllIllIIlIIIIIlI;
                    final Position position4 = llllllllllllllllIllIllIIlIIIIIIl;
                    position4.z /= llllllllllllllllIllIllIIlIIIIIlI;
                    final double llllllllllllllllIllIllIIIlllllIl = llllllllllllllllIllIllIIlIIIIIIl.getLength();
                    if (llllllllllllllllIllIllIIIlllllIl > 0.0) {
                        llllllllllllllllIllIllIIlIIIIIIl.normalize();
                        llllllllllllllllIllIllIIlIIIIIll.moveAway(llllllllllllllllIllIllIIlIIIIIIl);
                    }
                    else {
                        llllllllllllllllIllIllIIlIIIIIll.randomize(llllllllllllllllIllIllIIIllllIII, llllllllllllllllIllIllIIIlllIlll, llllllllllllllllIllIllIIlIIIllII, llllllllllllllllIllIllIIlIIIlIll, llllllllllllllllIllIllIIIlllIlII);
                    }
                    llllllllllllllllIllIllIIlIIIIlll = true;
                }
                if (llllllllllllllllIllIllIIlIIIIIll.clamp(llllllllllllllllIllIllIIIlllIlll, llllllllllllllllIllIllIIlIIIllII, llllllllllllllllIllIllIIlIIIlIll, llllllllllllllllIllIllIIIlllIlII)) {
                    llllllllllllllllIllIllIIlIIIIlll = true;
                }
            }
            if (!llllllllllllllllIllIllIIlIIIIlll) {
                final String llllllllllllllllIllIllIIIllIlIll = (Object)llllllllllllllllIllIllIIlIIIlIIl;
                final double llllllllllllllllIllIllIIIllIllII = llllllllllllllllIllIllIIlIIIlIIl.length;
                for (final Position llllllllllllllllIllIllIIIlllllII : llllllllllllllllIllIllIIIllIlIll) {
                    if (!llllllllllllllllIllIllIIIlllllII.isSafe(llllllllllllllllIllIllIIlIIIllll)) {
                        llllllllllllllllIllIllIIIlllllII.randomize(llllllllllllllllIllIllIIIllllIII, llllllllllllllllIllIllIIIlllIlll, llllllllllllllllIllIllIIlIIIllII, llllllllllllllllIllIllIIlIIIlIll, llllllllllllllllIllIllIIIlllIlII);
                        llllllllllllllllIllIllIIlIIIIlll = true;
                    }
                }
            }
        }
        if (llllllllllllllllIllIllIIlIIIIlIl >= 10000) {
            throw new CommandException("commands.spreadplayers.failure." + (llllllllllllllllIllIllIIlIIIlIII ? "teams" : "players"), new Object[] { llllllllllllllllIllIllIIlIIIlIIl.length, llllllllllllllllIllIllIIlIIlIIIl.x, llllllllllllllllIllIllIIlIIlIIIl.z, String.format("%.2f", llllllllllllllllIllIllIIlIIIIllI) });
        }
        return llllllllllllllllIllIllIIlIIIIlIl;
    }
    
    @Override
    public String getCommandName() {
        return "spreadplayers";
    }
    
    private Position[] createInitialPositions(final Random llllllllllllllllIllIllIIIIlIIlII, final int llllllllllllllllIllIllIIIIlIIIll, final double llllllllllllllllIllIllIIIIlIIIlI, final double llllllllllllllllIllIllIIIIlIIIIl, final double llllllllllllllllIllIllIIIIlIlIIl, final double llllllllllllllllIllIllIIIIIlllll) {
        final Position[] llllllllllllllllIllIllIIIIlIIlll = new Position[llllllllllllllllIllIllIIIIlIIIll];
        for (int llllllllllllllllIllIllIIIIlIIllI = 0; llllllllllllllllIllIllIIIIlIIllI < llllllllllllllllIllIllIIIIlIIlll.length; ++llllllllllllllllIllIllIIIIlIIllI) {
            final Position llllllllllllllllIllIllIIIIlIIlIl = new Position();
            llllllllllllllllIllIllIIIIlIIlIl.randomize(llllllllllllllllIllIllIIIIlIIlII, llllllllllllllllIllIllIIIIlIIIlI, llllllllllllllllIllIllIIIIlIIIIl, llllllllllllllllIllIllIIIIlIlIIl, llllllllllllllllIllIllIIIIIlllll);
            llllllllllllllllIllIllIIIIlIIlll[llllllllllllllllIllIllIIIIlIIllI] = llllllllllllllllIllIllIIIIlIIlIl;
        }
        return llllllllllllllllIllIllIIIIlIIlll;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllllIllIllIIlllIllll, final ICommandSender llllllllllllllllIllIllIIlllIlllI, final String[] llllllllllllllllIllIllIIllllllII) throws CommandException {
        if (llllllllllllllllIllIllIIllllllII.length < 6) {
            throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]);
        }
        int llllllllllllllllIllIllIIlllllIll = 0;
        final BlockPos llllllllllllllllIllIllIIlllllIlI = llllllllllllllllIllIllIIlllIlllI.getPosition();
        final double llllllllllllllllIllIllIIlllllIIl = CommandBase.parseDouble(llllllllllllllllIllIllIIlllllIlI.getX(), llllllllllllllllIllIllIIllllllII[llllllllllllllllIllIllIIlllllIll++], true);
        final double llllllllllllllllIllIllIIlllllIII = CommandBase.parseDouble(llllllllllllllllIllIllIIlllllIlI.getZ(), llllllllllllllllIllIllIIllllllII[llllllllllllllllIllIllIIlllllIll++], true);
        final double llllllllllllllllIllIllIIllllIlll = CommandBase.parseDouble(llllllllllllllllIllIllIIllllllII[llllllllllllllllIllIllIIlllllIll++], 0.0);
        final double llllllllllllllllIllIllIIllllIllI = CommandBase.parseDouble(llllllllllllllllIllIllIIllllllII[llllllllllllllllIllIllIIlllllIll++], llllllllllllllllIllIllIIllllIlll + 1.0);
        final boolean llllllllllllllllIllIllIIllllIlIl = CommandBase.parseBoolean(llllllllllllllllIllIllIIllllllII[llllllllllllllllIllIllIIlllllIll++]);
        final List<Entity> llllllllllllllllIllIllIIllllIlII = (List<Entity>)Lists.newArrayList();
        while (llllllllllllllllIllIllIIlllllIll < llllllllllllllllIllIllIIllllllII.length) {
            final String llllllllllllllllIllIllIIllllIIll = llllllllllllllllIllIllIIllllllII[llllllllllllllllIllIllIIlllllIll++];
            if (EntitySelector.hasArguments(llllllllllllllllIllIllIIllllIIll)) {
                final List<Entity> llllllllllllllllIllIllIIllllIIlI = EntitySelector.matchEntities(llllllllllllllllIllIllIIlllIlllI, llllllllllllllllIllIllIIllllIIll, (Class<? extends Entity>)Entity.class);
                if (llllllllllllllllIllIllIIllllIIlI.isEmpty()) {
                    throw new EntityNotFoundException("commands.generic.selector.notFound", new Object[] { llllllllllllllllIllIllIIllllIIll });
                }
                llllllllllllllllIllIllIIllllIlII.addAll(llllllllllllllllIllIllIIllllIIlI);
            }
            else {
                final EntityPlayer llllllllllllllllIllIllIIllllIIIl = llllllllllllllllIllIllIIlllIllll.getPlayerList().getPlayerByUsername(llllllllllllllllIllIllIIllllIIll);
                if (llllllllllllllllIllIllIIllllIIIl == null) {
                    throw new PlayerNotFoundException("commands.generic.player.notFound", new Object[] { llllllllllllllllIllIllIIllllIIll });
                }
                llllllllllllllllIllIllIIllllIlII.add(llllllllllllllllIllIllIIllllIIIl);
            }
        }
        llllllllllllllllIllIllIIlllIlllI.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, llllllllllllllllIllIllIIllllIlII.size());
        if (llllllllllllllllIllIllIIllllIlII.isEmpty()) {
            throw new EntityNotFoundException("commands.spreadplayers.noop");
        }
        llllllllllllllllIllIllIIlllIlllI.addChatMessage(new TextComponentTranslation("commands.spreadplayers.spreading." + (llllllllllllllllIllIllIIllllIlIl ? "teams" : "players"), new Object[] { llllllllllllllllIllIllIIllllIlII.size(), llllllllllllllllIllIllIIllllIllI, llllllllllllllllIllIllIIlllllIIl, llllllllllllllllIllIllIIlllllIII, llllllllllllllllIllIllIIllllIlll }));
        this.spread(llllllllllllllllIllIllIIlllIlllI, llllllllllllllllIllIllIIllllIlII, new Position(llllllllllllllllIllIllIIlllllIIl, llllllllllllllllIllIllIIlllllIII), llllllllllllllllIllIllIIllllIlll, llllllllllllllllIllIllIIllllIllI, llllllllllllllllIllIllIIllllIlII.get(0).world, llllllllllllllllIllIllIIllllIlIl);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllllIllIllIlIIIIlllI) {
        return "commands.spreadplayers.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    static class Position
    {
        /* synthetic */ double z;
        /* synthetic */ double x;
        
        Position() {
        }
        
        Position(final double lllllllllllIlllIlIlIlllllllIIlll, final double lllllllllllIlllIlIlIlllllllIIIll) {
            this.x = lllllllllllIlllIlIlIlllllllIIlll;
            this.z = lllllllllllIlllIlIlIlllllllIIIll;
        }
        
        float getLength() {
            return MathHelper.sqrt(this.x * this.x + this.z * this.z);
        }
        
        public void moveAway(final Position lllllllllllIlllIlIlIllllllIIlIII) {
            this.x -= lllllllllllIlllIlIlIllllllIIlIII.x;
            this.z -= lllllllllllIlllIlIlIllllllIIlIII.z;
        }
        
        void normalize() {
            final double lllllllllllIlllIlIlIllllllIlIIll = this.getLength();
            this.x /= lllllllllllIlllIlIlIllllllIlIIll;
            this.z /= lllllllllllIlllIlIlIllllllIlIIll;
        }
        
        public void randomize(final Random lllllllllllIlllIlIlIlllllIIllIIl, final double lllllllllllIlllIlIlIlllllIIllIII, final double lllllllllllIlllIlIlIlllllIIlIIIl, final double lllllllllllIlllIlIlIlllllIIlIllI, final double lllllllllllIlllIlIlIlllllIIIllll) {
            this.x = MathHelper.nextDouble(lllllllllllIlllIlIlIlllllIIllIIl, lllllllllllIlllIlIlIlllllIIllIII, lllllllllllIlllIlIlIlllllIIlIllI);
            this.z = MathHelper.nextDouble(lllllllllllIlllIlIlIlllllIIllIIl, lllllllllllIlllIlIlIlllllIIlIIIl, lllllllllllIlllIlIlIlllllIIIllll);
        }
        
        public int getSpawnY(final World lllllllllllIlllIlIlIlllllIllIIIl) {
            BlockPos lllllllllllIlllIlIlIlllllIllIIII = new BlockPos(this.x, 256.0, this.z);
            while (lllllllllllIlllIlIlIlllllIllIIII.getY() > 0) {
                lllllllllllIlllIlIlIlllllIllIIII = lllllllllllIlllIlIlIlllllIllIIII.down();
                if (lllllllllllIlllIlIlIlllllIllIIIl.getBlockState(lllllllllllIlllIlIlIlllllIllIIII).getMaterial() != Material.AIR) {
                    return lllllllllllIlllIlIlIlllllIllIIII.getY() + 1;
                }
            }
            return 257;
        }
        
        public boolean clamp(final double lllllllllllIlllIlIlIllllllIIIIII, final double lllllllllllIlllIlIlIlllllIlllIIl, final double lllllllllllIlllIlIlIlllllIlllllI, final double lllllllllllIlllIlIlIlllllIllllIl) {
            boolean lllllllllllIlllIlIlIlllllIllllII = false;
            if (this.x < lllllllllllIlllIlIlIllllllIIIIII) {
                this.x = lllllllllllIlllIlIlIllllllIIIIII;
                lllllllllllIlllIlIlIlllllIllllII = true;
            }
            else if (this.x > lllllllllllIlllIlIlIlllllIlllllI) {
                this.x = lllllllllllIlllIlIlIlllllIlllllI;
                lllllllllllIlllIlIlIlllllIllllII = true;
            }
            if (this.z < lllllllllllIlllIlIlIlllllIlllIIl) {
                this.z = lllllllllllIlllIlIlIlllllIlllIIl;
                lllllllllllIlllIlIlIlllllIllllII = true;
            }
            else if (this.z > lllllllllllIlllIlIlIlllllIllllIl) {
                this.z = lllllllllllIlllIlIlIlllllIllllIl;
                lllllllllllIlllIlIlIlllllIllllII = true;
            }
            return lllllllllllIlllIlIlIlllllIllllII;
        }
        
        public boolean isSafe(final World lllllllllllIlllIlIlIlllllIlIIlll) {
            BlockPos lllllllllllIlllIlIlIlllllIlIIllI = new BlockPos(this.x, 256.0, this.z);
            while (lllllllllllIlllIlIlIlllllIlIIllI.getY() > 0) {
                lllllllllllIlllIlIlIlllllIlIIllI = lllllllllllIlllIlIlIlllllIlIIllI.down();
                final Material lllllllllllIlllIlIlIlllllIlIIlIl = lllllllllllIlllIlIlIlllllIlIIlll.getBlockState(lllllllllllIlllIlIlIlllllIlIIllI).getMaterial();
                if (lllllllllllIlllIlIlIlllllIlIIlIl != Material.AIR) {
                    return !lllllllllllIlllIlIlIlllllIlIIlIl.isLiquid() && lllllllllllIlllIlIlIlllllIlIIlIl != Material.FIRE;
                }
            }
            return false;
        }
        
        double dist(final Position lllllllllllIlllIlIlIllllllIllIIl) {
            final double lllllllllllIlllIlIlIllllllIlllII = this.x - lllllllllllIlllIlIlIllllllIllIIl.x;
            final double lllllllllllIlllIlIlIllllllIllIll = this.z - lllllllllllIlllIlIlIllllllIllIIl.z;
            return Math.sqrt(lllllllllllIlllIlIlIllllllIlllII * lllllllllllIlllIlIlIllllllIlllII + lllllllllllIlllIlIlIllllllIllIll * lllllllllllIlllIlIlIllllllIllIll);
        }
    }
}

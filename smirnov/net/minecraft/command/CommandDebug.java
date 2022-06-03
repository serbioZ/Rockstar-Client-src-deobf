// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import java.io.Writer;
import org.apache.commons.io.IOUtils;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;

public class CommandDebug extends CommandBase
{
    private /* synthetic */ int profileStartTick;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ long profileStartTime;
    
    private static String getWittyComment() {
        final String[] lllllllllllllIIIlIIIlIllllllllII = { "Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server." };
        try {
            return lllllllllllllIIIlIIIlIllllllllII[(int)(System.nanoTime() % lllllllllllllIIIlIIIlIllllllllII.length)];
        }
        catch (Throwable lllllllllllllIIIlIIIlIlllllllIll) {
            return "Witty comment unavailable :(";
        }
    }
    
    private void appendProfilerResults(final int lllllllllllllIIIlIIIllIIIIIlIIII, final String lllllllllllllIIIlIIIllIIIIIIIlIl, final StringBuilder lllllllllllllIIIlIIIllIIIIIIIlII, final MinecraftServer lllllllllllllIIIlIIIllIIIIIIllIl) {
        final List<Profiler.Result> lllllllllllllIIIlIIIllIIIIIIllII = lllllllllllllIIIlIIIllIIIIIIllIl.theProfiler.getProfilingData(lllllllllllllIIIlIIIllIIIIIIIlIl);
        if (lllllllllllllIIIlIIIllIIIIIIllII != null && lllllllllllllIIIlIIIllIIIIIIllII.size() >= 3) {
            for (int lllllllllllllIIIlIIIllIIIIIIlIll = 1; lllllllllllllIIIlIIIllIIIIIIlIll < lllllllllllllIIIlIIIllIIIIIIllII.size(); ++lllllllllllllIIIlIIIllIIIIIIlIll) {
                final Profiler.Result lllllllllllllIIIlIIIllIIIIIIlIlI = lllllllllllllIIIlIIIllIIIIIIllII.get(lllllllllllllIIIlIIIllIIIIIIlIll);
                lllllllllllllIIIlIIIllIIIIIIIlII.append(String.format("[%02d] ", lllllllllllllIIIlIIIllIIIIIlIIII));
                for (int lllllllllllllIIIlIIIllIIIIIIlIIl = 0; lllllllllllllIIIlIIIllIIIIIIlIIl < lllllllllllllIIIlIIIllIIIIIlIIII; ++lllllllllllllIIIlIIIllIIIIIIlIIl) {
                    lllllllllllllIIIlIIIllIIIIIIIlII.append("|   ");
                }
                lllllllllllllIIIlIIIllIIIIIIIlII.append(lllllllllllllIIIlIIIllIIIIIIlIlI.profilerName).append(" - ").append(String.format("%.2f", lllllllllllllIIIlIIIllIIIIIIlIlI.usePercentage)).append("%/").append(String.format("%.2f", lllllllllllllIIIlIIIllIIIIIIlIlI.totalUsePercentage)).append("%\n");
                if (!"unspecified".equals(lllllllllllllIIIlIIIllIIIIIIlIlI.profilerName)) {
                    try {
                        this.appendProfilerResults(lllllllllllllIIIlIIIllIIIIIlIIII + 1, String.valueOf(lllllllllllllIIIlIIIllIIIIIIIlIl) + "." + lllllllllllllIIIlIIIllIIIIIIlIlI.profilerName, lllllllllllllIIIlIIIllIIIIIIIlII, lllllllllllllIIIlIIIllIIIIIIllIl);
                    }
                    catch (Exception lllllllllllllIIIlIIIllIIIIIIlIII) {
                        lllllllllllllIIIlIIIllIIIIIIIlII.append("[[ EXCEPTION ").append(lllllllllllllIIIlIIIllIIIIIIlIII).append(" ]]");
                    }
                }
            }
        }
    }
    
    @Override
    public String getCommandName() {
        return "debug";
    }
    
    private void saveProfilerResults(final long lllllllllllllIIIlIIIllIIIIllIIII, final int lllllllllllllIIIlIIIllIIIIllIllI, final MinecraftServer lllllllllllllIIIlIIIllIIIIlIlllI) {
        final File lllllllllllllIIIlIIIllIIIIllIlII = new File(lllllllllllllIIIlIIIllIIIIlIlllI.getFile("debug"), "profile-results-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + ".txt");
        lllllllllllllIIIlIIIllIIIIllIlII.getParentFile().mkdirs();
        Writer lllllllllllllIIIlIIIllIIIIllIIll = null;
        try {
            lllllllllllllIIIlIIIllIIIIllIIll = new OutputStreamWriter(new FileOutputStream(lllllllllllllIIIlIIIllIIIIllIlII), StandardCharsets.UTF_8);
            lllllllllllllIIIlIIIllIIIIllIIll.write(this.getProfilerResults(lllllllllllllIIIlIIIllIIIIllIIII, lllllllllllllIIIlIIIllIIIIllIllI, lllllllllllllIIIlIIIllIIIIlIlllI));
        }
        catch (Throwable lllllllllllllIIIlIIIllIIIIllIIlI) {
            CommandDebug.LOGGER.error("Could not save profiler results to {}", (Object)lllllllllllllIIIlIIIllIIIIllIlII, (Object)lllllllllllllIIIlIIIllIIIIllIIlI);
            return;
        }
        finally {
            IOUtils.closeQuietly(lllllllllllllIIIlIIIllIIIIllIIll);
        }
        IOUtils.closeQuietly(lllllllllllllIIIlIIIllIIIIllIIll);
    }
    
    private String getProfilerResults(final long lllllllllllllIIIlIIIllIIIIlIIIll, final int lllllllllllllIIIlIIIllIIIIIlllIl, final MinecraftServer lllllllllllllIIIlIIIllIIIIlIIIIl) {
        final StringBuilder lllllllllllllIIIlIIIllIIIIlIIIII = new StringBuilder();
        lllllllllllllIIIlIIIllIIIIlIIIII.append("---- Minecraft Profiler Results ----\n");
        lllllllllllllIIIlIIIllIIIIlIIIII.append("// ");
        lllllllllllllIIIlIIIllIIIIlIIIII.append(getWittyComment());
        lllllllllllllIIIlIIIllIIIIlIIIII.append("\n\n");
        lllllllllllllIIIlIIIllIIIIlIIIII.append("Time span: ").append(lllllllllllllIIIlIIIllIIIIlIIIll).append(" ms\n");
        lllllllllllllIIIlIIIllIIIIlIIIII.append("Tick span: ").append(lllllllllllllIIIlIIIllIIIIIlllIl).append(" ticks\n");
        lllllllllllllIIIlIIIllIIIIlIIIII.append("// This is approximately ").append(String.format("%.2f", lllllllllllllIIIlIIIllIIIIIlllIl / (lllllllllllllIIIlIIIllIIIIlIIIll / 1000.0f))).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
        lllllllllllllIIIlIIIllIIIIlIIIII.append("--- BEGIN PROFILE DUMP ---\n\n");
        this.appendProfilerResults(0, "root", lllllllllllllIIIlIIIllIIIIlIIIII, lllllllllllllIIIlIIIllIIIIlIIIIl);
        lllllllllllllIIIlIIIllIIIIlIIIII.append("--- END PROFILE DUMP ---\n\n");
        return lllllllllllllIIIlIIIllIIIIlIIIII.toString();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllIIIlIIIllIIIlIllIIl) {
        return "commands.debug.usage";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllIIIlIIIllIIIlIIllll, final ICommandSender lllllllllllllIIIlIIIllIIIlIIlllI, final String[] lllllllllllllIIIlIIIllIIIlIIllIl) throws CommandException {
        if (lllllllllllllIIIlIIIllIIIlIIllIl.length < 1) {
            throw new WrongUsageException("commands.debug.usage", new Object[0]);
        }
        if ("start".equals(lllllllllllllIIIlIIIllIIIlIIllIl[0])) {
            if (lllllllllllllIIIlIIIllIIIlIIllIl.length != 1) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            CommandBase.notifyCommandListener(lllllllllllllIIIlIIIllIIIlIIlllI, this, "commands.debug.start", new Object[0]);
            lllllllllllllIIIlIIIllIIIlIIllll.enableProfiling();
            this.profileStartTime = MinecraftServer.getCurrentTimeMillis();
            this.profileStartTick = lllllllllllllIIIlIIIllIIIlIIllll.getTickCounter();
        }
        else {
            if (!"stop".equals(lllllllllllllIIIlIIIllIIIlIIllIl[0])) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            if (lllllllllllllIIIlIIIllIIIlIIllIl.length != 1) {
                throw new WrongUsageException("commands.debug.usage", new Object[0]);
            }
            if (!lllllllllllllIIIlIIIllIIIlIIllll.theProfiler.profilingEnabled) {
                throw new CommandException("commands.debug.notStarted", new Object[0]);
            }
            final long lllllllllllllIIIlIIIllIIIlIIllII = MinecraftServer.getCurrentTimeMillis();
            final int lllllllllllllIIIlIIIllIIIlIIlIll = lllllllllllllIIIlIIIllIIIlIIllll.getTickCounter();
            final long lllllllllllllIIIlIIIllIIIlIIlIlI = lllllllllllllIIIlIIIllIIIlIIllII - this.profileStartTime;
            final int lllllllllllllIIIlIIIllIIIlIIlIIl = lllllllllllllIIIlIIIllIIIlIIlIll - this.profileStartTick;
            this.saveProfilerResults(lllllllllllllIIIlIIIllIIIlIIlIlI, lllllllllllllIIIlIIIllIIIlIIlIIl, lllllllllllllIIIlIIIllIIIlIIllll);
            lllllllllllllIIIlIIIllIIIlIIllll.theProfiler.profilingEnabled = false;
            CommandBase.notifyCommandListener(lllllllllllllIIIlIIIllIIIlIIlllI, this, "commands.debug.stop", String.format("%.2f", lllllllllllllIIIlIIIllIIIlIIlIlI / 1000.0f), lllllllllllllIIIlIIIllIIIlIIlIIl);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllIIIlIIIlIllllllIllI, final ICommandSender lllllllllllllIIIlIIIlIllllllIlIl, final String[] lllllllllllllIIIlIIIlIllllllIlII, @Nullable final BlockPos lllllllllllllIIIlIIIlIllllllIIll) {
        return (lllllllllllllIIIlIIIlIllllllIlII.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllIIIlIIIlIllllllIlII, "start", "stop") : Collections.emptyList();
    }
}

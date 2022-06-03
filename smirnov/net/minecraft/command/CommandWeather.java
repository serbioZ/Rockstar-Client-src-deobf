// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.World;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;

public class CommandWeather extends CommandBase
{
    @Override
    public String getCommandName() {
        return "weather";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIIIllllIIlIIlIIIIII, final ICommandSender llllllllllllIIIIllllIIlIIIllllll, final String[] llllllllllllIIIIllllIIlIIIlllllI, @Nullable final BlockPos llllllllllllIIIIllllIIlIIIllllIl) {
        return (llllllllllllIIIIllllIIlIIIlllllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIIIllllIIlIIIlllllI, "clear", "rain", "thunder") : Collections.emptyList();
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIIIllllIIlIIlIIlIII, final ICommandSender llllllllllllIIIIllllIIlIIlIIlllI, final String[] llllllllllllIIIIllllIIlIIlIIIllI) throws CommandException {
        if (llllllllllllIIIIllllIIlIIlIIIllI.length >= 1 && llllllllllllIIIIllllIIlIIlIIIllI.length <= 2) {
            int llllllllllllIIIIllllIIlIIlIIllII = (300 + new Random().nextInt(600)) * 20;
            if (llllllllllllIIIIllllIIlIIlIIIllI.length >= 2) {
                llllllllllllIIIIllllIIlIIlIIllII = CommandBase.parseInt(llllllllllllIIIIllllIIlIIlIIIllI[1], 1, 1000000) * 20;
            }
            final World llllllllllllIIIIllllIIlIIlIIlIll = llllllllllllIIIIllllIIlIIlIIlIII.worldServers[0];
            final WorldInfo llllllllllllIIIIllllIIlIIlIIlIlI = llllllllllllIIIIllllIIlIIlIIlIll.getWorldInfo();
            if ("clear".equalsIgnoreCase(llllllllllllIIIIllllIIlIIlIIIllI[0])) {
                llllllllllllIIIIllllIIlIIlIIlIlI.setCleanWeatherTime(llllllllllllIIIIllllIIlIIlIIllII);
                llllllllllllIIIIllllIIlIIlIIlIlI.setRainTime(0);
                llllllllllllIIIIllllIIlIIlIIlIlI.setThunderTime(0);
                llllllllllllIIIIllllIIlIIlIIlIlI.setRaining(false);
                llllllllllllIIIIllllIIlIIlIIlIlI.setThundering(false);
                CommandBase.notifyCommandListener(llllllllllllIIIIllllIIlIIlIIlllI, this, "commands.weather.clear", new Object[0]);
            }
            else if ("rain".equalsIgnoreCase(llllllllllllIIIIllllIIlIIlIIIllI[0])) {
                llllllllllllIIIIllllIIlIIlIIlIlI.setCleanWeatherTime(0);
                llllllllllllIIIIllllIIlIIlIIlIlI.setRainTime(llllllllllllIIIIllllIIlIIlIIllII);
                llllllllllllIIIIllllIIlIIlIIlIlI.setThunderTime(llllllllllllIIIIllllIIlIIlIIllII);
                llllllllllllIIIIllllIIlIIlIIlIlI.setRaining(true);
                llllllllllllIIIIllllIIlIIlIIlIlI.setThundering(false);
                CommandBase.notifyCommandListener(llllllllllllIIIIllllIIlIIlIIlllI, this, "commands.weather.rain", new Object[0]);
            }
            else {
                if (!"thunder".equalsIgnoreCase(llllllllllllIIIIllllIIlIIlIIIllI[0])) {
                    throw new WrongUsageException("commands.weather.usage", new Object[0]);
                }
                llllllllllllIIIIllllIIlIIlIIlIlI.setCleanWeatherTime(0);
                llllllllllllIIIIllllIIlIIlIIlIlI.setRainTime(llllllllllllIIIIllllIIlIIlIIllII);
                llllllllllllIIIIllllIIlIIlIIlIlI.setThunderTime(llllllllllllIIIIllllIIlIIlIIllII);
                llllllllllllIIIIllllIIlIIlIIlIlI.setRaining(true);
                llllllllllllIIIIllllIIlIIlIIlIlI.setThundering(true);
                CommandBase.notifyCommandListener(llllllllllllIIIIllllIIlIIlIIlllI, this, "commands.weather.thunder", new Object[0]);
            }
            return;
        }
        throw new WrongUsageException("commands.weather.usage", new Object[0]);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIIIllllIIlIIlIllIII) {
        return "commands.weather.usage";
    }
}

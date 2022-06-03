// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import java.util.Date;
import net.minecraft.server.MinecraftServer;
import java.text.SimpleDateFormat;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;

public abstract class CommandBlockBaseLogic implements ICommandSender
{
    private final /* synthetic */ CommandResultStats resultStats;
    private /* synthetic */ String customName;
    private /* synthetic */ String commandStored;
    private /* synthetic */ boolean trackOutput;
    private /* synthetic */ boolean field_193042_c;
    private /* synthetic */ int successCount;
    private /* synthetic */ ITextComponent lastOutput;
    private /* synthetic */ long field_193041_b;
    private static final /* synthetic */ SimpleDateFormat TIMESTAMP_FORMAT;
    
    @Override
    public boolean sendCommandFeedback() {
        final MinecraftServer lllllllllllIlIllllIIIIIIlIIIlIII = this.getServer();
        return lllllllllllIlIllllIIIIIIlIIIlIII == null || !lllllllllllIlIllllIIIIIIlIIIlIII.isAnvilFileSet() || lllllllllllIlIllllIIIIIIlIIIlIII.worldServers[0].getGameRules().getBoolean("commandBlockOutput");
    }
    
    static {
        TIMESTAMP_FORMAT = new SimpleDateFormat("HH:mm:ss");
    }
    
    public void setCommand(final String lllllllllllIlIllllIIIIIIlIllIIlI) {
        this.commandStored = lllllllllllIlIllllIIIIIIlIllIIlI;
        this.successCount = 0;
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllIlIllllIIIIIIlIIIllII) {
        if (this.trackOutput && this.getEntityWorld() != null && !this.getEntityWorld().isRemote) {
            this.lastOutput = new TextComponentString("[" + CommandBlockBaseLogic.TIMESTAMP_FORMAT.format(new Date()) + "] ").appendSibling(lllllllllllIlIllllIIIIIIlIIIllII);
            this.updateCommand();
        }
    }
    
    public void setName(final String lllllllllllIlIllllIIIIIIlIIlIIlI) {
        this.customName = lllllllllllIlIllllIIIIIIlIIlIIlI;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllIlIllllIIIIIIlIllIllI, final String lllllllllllIlIllllIIIIIIlIllIlll) {
        return lllllllllllIlIllllIIIIIIlIllIllI <= 2;
    }
    
    public void readDataFromNBT(final NBTTagCompound lllllllllllIlIllllIIIIIIlIllllll) {
        this.commandStored = lllllllllllIlIllllIIIIIIlIllllll.getString("Command");
        this.successCount = lllllllllllIlIllllIIIIIIlIllllll.getInteger("SuccessCount");
        if (lllllllllllIlIllllIIIIIIlIllllll.hasKey("CustomName", 8)) {
            this.customName = lllllllllllIlIllllIIIIIIlIllllll.getString("CustomName");
        }
        if (lllllllllllIlIllllIIIIIIlIllllll.hasKey("TrackOutput", 1)) {
            this.trackOutput = lllllllllllIlIllllIIIIIIlIllllll.getBoolean("TrackOutput");
        }
        if (lllllllllllIlIllllIIIIIIlIllllll.hasKey("LastOutput", 8) && this.trackOutput) {
            try {
                this.lastOutput = ITextComponent.Serializer.jsonToComponent(lllllllllllIlIllllIIIIIIlIllllll.getString("LastOutput"));
            }
            catch (Throwable lllllllllllIlIllllIIIIIIlIlllllI) {
                this.lastOutput = new TextComponentString(lllllllllllIlIllllIIIIIIlIlllllI.getMessage());
            }
        }
        else {
            this.lastOutput = null;
        }
        if (lllllllllllIlIllllIIIIIIlIllllll.hasKey("UpdateLastExecution")) {
            this.field_193042_c = lllllllllllIlIllllIIIIIIlIllllll.getBoolean("UpdateLastExecution");
        }
        if (this.field_193042_c && lllllllllllIlIllllIIIIIIlIllllll.hasKey("LastExecution")) {
            this.field_193041_b = lllllllllllIlIllllIIIIIIlIllllll.getLong("LastExecution");
        }
        else {
            this.field_193041_b = -1L;
        }
        this.resultStats.readStatsFromNBT(lllllllllllIlIllllIIIIIIlIllllll);
    }
    
    public boolean trigger(final World lllllllllllIlIllllIIIIIIlIlIIlIl) {
        if (lllllllllllIlIllllIIIIIIlIlIIlIl.isRemote || lllllllllllIlIllllIIIIIIlIlIIlIl.getTotalWorldTime() == this.field_193041_b) {
            return false;
        }
        if ("Searge".equalsIgnoreCase(this.commandStored)) {
            this.lastOutput = new TextComponentString("#itzlipofutzli");
            this.successCount = 1;
            return true;
        }
        final MinecraftServer lllllllllllIlIllllIIIIIIlIlIIlII = this.getServer();
        Label_0166: {
            if (lllllllllllIlIllllIIIIIIlIlIIlII != null && lllllllllllIlIllllIIIIIIlIlIIlII.isAnvilFileSet() && lllllllllllIlIllllIIIIIIlIlIIlII.isCommandBlockEnabled()) {
                try {
                    this.lastOutput = null;
                    this.successCount = lllllllllllIlIllllIIIIIIlIlIIlII.getCommandManager().executeCommand(this, this.commandStored);
                    break Label_0166;
                }
                catch (Throwable lllllllllllIlIllllIIIIIIlIlIIIll) {
                    final CrashReport lllllllllllIlIllllIIIIIIlIlIIIlI = CrashReport.makeCrashReport(lllllllllllIlIllllIIIIIIlIlIIIll, "Executing command block");
                    final CrashReportCategory lllllllllllIlIllllIIIIIIlIlIIIIl = lllllllllllIlIllllIIIIIIlIlIIIlI.makeCategory("Command to be executed");
                    lllllllllllIlIllllIIIIIIlIlIIIIl.setDetail("Command", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return CommandBlockBaseLogic.this.getCommand();
                        }
                    });
                    lllllllllllIlIllllIIIIIIlIlIIIIl.setDetail("Name", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return CommandBlockBaseLogic.this.getName();
                        }
                    });
                    throw new ReportedException(lllllllllllIlIllllIIIIIIlIlIIIlI);
                }
            }
            this.successCount = 0;
        }
        if (this.field_193042_c) {
            this.field_193041_b = lllllllllllIlIllllIIIIIIlIlIIlIl.getTotalWorldTime();
        }
        else {
            this.field_193041_b = -1L;
        }
        return true;
    }
    
    public abstract void fillInInfo(final ByteBuf p0);
    
    @Override
    public void setCommandStat(final CommandResultStats.Type lllllllllllIlIllllIIIIIIIllllllI, final int lllllllllllIlIllllIIIIIIlIIIIIII) {
        this.resultStats.setCommandStatForSender(this.getServer(), this, lllllllllllIlIllllIIIIIIIllllllI, lllllllllllIlIllllIIIIIIlIIIIIII);
    }
    
    public String getCommand() {
        return this.commandStored;
    }
    
    public boolean tryOpenEditCommandBlock(final EntityPlayer lllllllllllIlIllllIIIIIIIllIlIII) {
        if (!lllllllllllIlIllllIIIIIIIllIlIII.canUseCommandBlock()) {
            return false;
        }
        if (lllllllllllIlIllllIIIIIIIllIlIII.getEntityWorld().isRemote) {
            lllllllllllIlIllllIIIIIIIllIlIII.displayGuiEditCommandCart(this);
        }
        return true;
    }
    
    public int getSuccessCount() {
        return this.successCount;
    }
    
    public ITextComponent getLastOutput() {
        return (this.lastOutput == null) ? new TextComponentString("") : this.lastOutput;
    }
    
    public boolean shouldTrackOutput() {
        return this.trackOutput;
    }
    
    @Override
    public String getName() {
        return this.customName;
    }
    
    public void setSuccessCount(final int lllllllllllIlIllllIIIIIIllIIllll) {
        this.successCount = lllllllllllIlIllllIIIIIIllIIllll;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIlIllllIIIIIIllIIIllI) {
        lllllllllllIlIllllIIIIIIllIIIllI.setString("Command", this.commandStored);
        lllllllllllIlIllllIIIIIIllIIIllI.setInteger("SuccessCount", this.successCount);
        lllllllllllIlIllllIIIIIIllIIIllI.setString("CustomName", this.customName);
        lllllllllllIlIllllIIIIIIllIIIllI.setBoolean("TrackOutput", this.trackOutput);
        if (this.lastOutput != null && this.trackOutput) {
            lllllllllllIlIllllIIIIIIllIIIllI.setString("LastOutput", ITextComponent.Serializer.componentToJson(this.lastOutput));
        }
        lllllllllllIlIllllIIIIIIllIIIllI.setBoolean("UpdateLastExecution", this.field_193042_c);
        if (this.field_193042_c && this.field_193041_b > 0L) {
            lllllllllllIlIllllIIIIIIllIIIllI.setLong("LastExecution", this.field_193041_b);
        }
        this.resultStats.writeStatsToNBT(lllllllllllIlIllllIIIIIIllIIIllI);
        return lllllllllllIlIllllIIIIIIllIIIllI;
    }
    
    public CommandBlockBaseLogic() {
        this.field_193041_b = -1L;
        this.field_193042_c = true;
        this.trackOutput = true;
        this.commandStored = "";
        this.customName = "@";
        this.resultStats = new CommandResultStats();
    }
    
    public CommandResultStats getCommandResultStats() {
        return this.resultStats;
    }
    
    public void setTrackOutput(final boolean lllllllllllIlIllllIIIIIIIlllIIll) {
        this.trackOutput = lllllllllllIlIllllIIIIIIIlllIIll;
    }
    
    public void setLastOutput(@Nullable final ITextComponent lllllllllllIlIllllIIIIIIIllllIIl) {
        this.lastOutput = lllllllllllIlIllllIIIIIIIllllIIl;
    }
    
    public abstract int getCommandBlockType();
    
    public abstract void updateCommand();
}

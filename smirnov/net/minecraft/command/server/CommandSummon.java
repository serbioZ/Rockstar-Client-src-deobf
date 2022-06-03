// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.command.ICommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ResourceLocation;
import net.minecraft.command.CommandException;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.Collection;
import net.minecraft.entity.EntityList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;

public class CommandSummon extends CommandBase
{
    @Override
    public String getCommandName() {
        return "summon";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIllIIIIIlIIlIIlIIlI, final ICommandSender llllllllllllIIllIIIIIlIIlIIlIIIl, final String[] llllllllllllIIllIIIIIlIIlIIlIIII, @Nullable final BlockPos llllllllllllIIllIIIIIlIIlIIIllll) {
        if (llllllllllllIIllIIIIIlIIlIIlIIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIllIIIIIlIIlIIlIIII, EntityList.getEntityNameList());
        }
        return (llllllllllllIIllIIIIIlIIlIIlIIII.length > 1 && llllllllllllIIllIIIIIlIIlIIlIIII.length <= 4) ? CommandBase.getTabCompletionCoordinate(llllllllllllIIllIIIIIlIIlIIlIIII, 1, llllllllllllIIllIIIIIlIIlIIIllll) : Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIllIIIIIlIIllIIIIlI) {
        return "commands.summon.usage";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIllIIIIIlIIlIllIIlI, final ICommandSender llllllllllllIIllIIIIIlIIlIllIIIl, final String[] llllllllllllIIllIIIIIlIIlIllIIII) throws CommandException {
        if (llllllllllllIIllIIIIIlIIlIllIIII.length < 1) {
            throw new WrongUsageException("commands.summon.usage", new Object[0]);
        }
        final String llllllllllllIIllIIIIIlIIlIlIllll = llllllllllllIIllIIIIIlIIlIllIIII[0];
        BlockPos llllllllllllIIllIIIIIlIIlIlIlllI = llllllllllllIIllIIIIIlIIlIllIIIl.getPosition();
        final Vec3d llllllllllllIIllIIIIIlIIlIlIllIl = llllllllllllIIllIIIIIlIIlIllIIIl.getPositionVector();
        double llllllllllllIIllIIIIIlIIlIlIllII = llllllllllllIIllIIIIIlIIlIlIllIl.xCoord;
        double llllllllllllIIllIIIIIlIIlIlIlIll = llllllllllllIIllIIIIIlIIlIlIllIl.yCoord;
        double llllllllllllIIllIIIIIlIIlIlIlIlI = llllllllllllIIllIIIIIlIIlIlIllIl.zCoord;
        if (llllllllllllIIllIIIIIlIIlIllIIII.length >= 4) {
            llllllllllllIIllIIIIIlIIlIlIllII = CommandBase.parseDouble(llllllllllllIIllIIIIIlIIlIlIllII, llllllllllllIIllIIIIIlIIlIllIIII[1], true);
            llllllllllllIIllIIIIIlIIlIlIlIll = CommandBase.parseDouble(llllllllllllIIllIIIIIlIIlIlIlIll, llllllllllllIIllIIIIIlIIlIllIIII[2], false);
            llllllllllllIIllIIIIIlIIlIlIlIlI = CommandBase.parseDouble(llllllllllllIIllIIIIIlIIlIlIlIlI, llllllllllllIIllIIIIIlIIlIllIIII[3], true);
            llllllllllllIIllIIIIIlIIlIlIlllI = new BlockPos(llllllllllllIIllIIIIIlIIlIlIllII, llllllllllllIIllIIIIIlIIlIlIlIll, llllllllllllIIllIIIIIlIIlIlIlIlI);
        }
        final World llllllllllllIIllIIIIIlIIlIlIlIIl = llllllllllllIIllIIIIIlIIlIllIIIl.getEntityWorld();
        if (!llllllllllllIIllIIIIIlIIlIlIlIIl.isBlockLoaded(llllllllllllIIllIIIIIlIIlIlIlllI)) {
            throw new CommandException("commands.summon.outOfWorld", new Object[0]);
        }
        if (EntityList.field_191307_a.equals(new ResourceLocation(llllllllllllIIllIIIIIlIIlIlIllll))) {
            llllllllllllIIllIIIIIlIIlIlIlIIl.addWeatherEffect(new EntityLightningBolt(llllllllllllIIllIIIIIlIIlIlIlIIl, llllllllllllIIllIIIIIlIIlIlIllII, llllllllllllIIllIIIIIlIIlIlIlIll, llllllllllllIIllIIIIIlIIlIlIlIlI, false));
            CommandBase.notifyCommandListener(llllllllllllIIllIIIIIlIIlIllIIIl, this, "commands.summon.success", new Object[0]);
        }
        else {
            NBTTagCompound llllllllllllIIllIIIIIlIIlIlIlIII = new NBTTagCompound();
            boolean llllllllllllIIllIIIIIlIIlIlIIlll = false;
            if (llllllllllllIIllIIIIIlIIlIllIIII.length >= 5) {
                final String llllllllllllIIllIIIIIlIIlIlIIllI = CommandBase.buildString(llllllllllllIIllIIIIIlIIlIllIIII, 4);
                try {
                    llllllllllllIIllIIIIIlIIlIlIlIII = JsonToNBT.getTagFromJson(llllllllllllIIllIIIIIlIIlIlIIllI);
                    llllllllllllIIllIIIIIlIIlIlIIlll = true;
                }
                catch (NBTException llllllllllllIIllIIIIIlIIlIlIIlIl) {
                    throw new CommandException("commands.summon.tagError", new Object[] { llllllllllllIIllIIIIIlIIlIlIIlIl.getMessage() });
                }
            }
            llllllllllllIIllIIIIIlIIlIlIlIII.setString("id", llllllllllllIIllIIIIIlIIlIlIllll);
            final Entity llllllllllllIIllIIIIIlIIlIlIIlII = AnvilChunkLoader.readWorldEntityPos(llllllllllllIIllIIIIIlIIlIlIlIII, llllllllllllIIllIIIIIlIIlIlIlIIl, llllllllllllIIllIIIIIlIIlIlIllII, llllllllllllIIllIIIIIlIIlIlIlIll, llllllllllllIIllIIIIIlIIlIlIlIlI, true);
            if (llllllllllllIIllIIIIIlIIlIlIIlII == null) {
                throw new CommandException("commands.summon.failed", new Object[0]);
            }
            llllllllllllIIllIIIIIlIIlIlIIlII.setLocationAndAngles(llllllllllllIIllIIIIIlIIlIlIllII, llllllllllllIIllIIIIIlIIlIlIlIll, llllllllllllIIllIIIIIlIIlIlIlIlI, llllllllllllIIllIIIIIlIIlIlIIlII.rotationYaw, llllllllllllIIllIIIIIlIIlIlIIlII.rotationPitch);
            if (!llllllllllllIIllIIIIIlIIlIlIIlll && llllllllllllIIllIIIIIlIIlIlIIlII instanceof EntityLiving) {
                ((EntityLiving)llllllllllllIIllIIIIIlIIlIlIIlII).onInitialSpawn(llllllllllllIIllIIIIIlIIlIlIlIIl.getDifficultyForLocation(new BlockPos(llllllllllllIIllIIIIIlIIlIlIIlII)), null);
            }
            CommandBase.notifyCommandListener(llllllllllllIIllIIIIIlIIlIllIIIl, this, "commands.summon.success", new Object[0]);
        }
    }
}

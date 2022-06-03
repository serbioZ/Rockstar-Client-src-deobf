// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command.server;

import java.util.Set;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import java.util.EnumSet;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.command.CommandException;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommand;
import net.minecraft.command.WrongUsageException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class CommandTeleport extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllIlllllllIIllllIlllIIlI) {
        return "commands.teleport.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllIlllllllIIllllIIlIIllI, final ICommandSender llllllllllIlllllllIIllllIIlIIlIl, final String[] llllllllllIlllllllIIllllIIlIIlII, @Nullable final BlockPos llllllllllIlllllllIIllllIIlIIIll) {
        if (llllllllllIlllllllIIllllIIlIIlII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllIlllllllIIllllIIlIIlII, llllllllllIlllllllIIllllIIlIIllI.getAllUsernames());
        }
        return (llllllllllIlllllllIIllllIIlIIlII.length > 1 && llllllllllIlllllllIIllllIIlIIlII.length <= 4) ? CommandBase.getTabCompletionCoordinate(llllllllllIlllllllIIllllIIlIIlII, 1, llllllllllIlllllllIIllllIIlIIIll) : Collections.emptyList();
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllIlllllllIIllllIIIlllIl, final int llllllllllIlllllllIIllllIIIllIll) {
        return llllllllllIlllllllIIllllIIIllIll == 0;
    }
    
    @Override
    public String getCommandName() {
        return "teleport";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllIlllllllIIllllIllIIIlI, final ICommandSender llllllllllIlllllllIIllllIllIIIIl, final String[] llllllllllIlllllllIIllllIlIlIIlI) throws CommandException {
        if (llllllllllIlllllllIIllllIlIlIIlI.length < 4) {
            throw new WrongUsageException("commands.teleport.usage", new Object[0]);
        }
        final Entity llllllllllIlllllllIIllllIlIlllll = CommandBase.getEntity(llllllllllIlllllllIIllllIllIIIlI, llllllllllIlllllllIIllllIllIIIIl, llllllllllIlllllllIIllllIlIlIIlI[0]);
        if (llllllllllIlllllllIIllllIlIlllll.world != null) {
            final int llllllllllIlllllllIIllllIlIllllI = 4096;
            final Vec3d llllllllllIlllllllIIllllIlIlllIl = llllllllllIlllllllIIllllIllIIIIl.getPositionVector();
            int llllllllllIlllllllIIllllIlIlllII = 1;
            final CoordinateArg llllllllllIlllllllIIllllIlIllIll = CommandBase.parseCoordinate(llllllllllIlllllllIIllllIlIlllIl.xCoord, llllllllllIlllllllIIllllIlIlIIlI[llllllllllIlllllllIIllllIlIlllII++], true);
            final CoordinateArg llllllllllIlllllllIIllllIlIllIlI = CommandBase.parseCoordinate(llllllllllIlllllllIIllllIlIlllIl.yCoord, llllllllllIlllllllIIllllIlIlIIlI[llllllllllIlllllllIIllllIlIlllII++], -4096, 4096, false);
            final CoordinateArg llllllllllIlllllllIIllllIlIllIIl = CommandBase.parseCoordinate(llllllllllIlllllllIIllllIlIlllIl.zCoord, llllllllllIlllllllIIllllIlIlIIlI[llllllllllIlllllllIIllllIlIlllII++], true);
            final Entity llllllllllIlllllllIIllllIlIllIII = (llllllllllIlllllllIIllllIllIIIIl.getCommandSenderEntity() == null) ? llllllllllIlllllllIIllllIlIlllll : llllllllllIlllllllIIllllIllIIIIl.getCommandSenderEntity();
            final CoordinateArg llllllllllIlllllllIIllllIlIlIlll = CommandBase.parseCoordinate((llllllllllIlllllllIIllllIlIlIIlI.length > llllllllllIlllllllIIllllIlIlllII) ? ((double)llllllllllIlllllllIIllllIlIllIII.rotationYaw) : ((double)llllllllllIlllllllIIllllIlIlllll.rotationYaw), (llllllllllIlllllllIIllllIlIlIIlI.length > llllllllllIlllllllIIllllIlIlllII) ? llllllllllIlllllllIIllllIlIlIIlI[llllllllllIlllllllIIllllIlIlllII] : "~", false);
            ++llllllllllIlllllllIIllllIlIlllII;
            final CoordinateArg llllllllllIlllllllIIllllIlIlIllI = CommandBase.parseCoordinate((llllllllllIlllllllIIllllIlIlIIlI.length > llllllllllIlllllllIIllllIlIlllII) ? ((double)llllllllllIlllllllIIllllIlIllIII.rotationPitch) : ((double)llllllllllIlllllllIIllllIlIlllll.rotationPitch), (llllllllllIlllllllIIllllIlIlIIlI.length > llllllllllIlllllllIIllllIlIlllII) ? llllllllllIlllllllIIllllIlIlIIlI[llllllllllIlllllllIIllllIlIlllII] : "~", false);
            doTeleport(llllllllllIlllllllIIllllIlIlllll, llllllllllIlllllllIIllllIlIllIll, llllllllllIlllllllIIllllIlIllIlI, llllllllllIlllllllIIllllIlIllIIl, llllllllllIlllllllIIllllIlIlIlll, llllllllllIlllllllIIllllIlIlIllI);
            CommandBase.notifyCommandListener(llllllllllIlllllllIIllllIllIIIIl, this, "commands.teleport.success.coordinates", llllllllllIlllllllIIllllIlIlllll.getName(), llllllllllIlllllllIIllllIlIllIll.getResult(), llllllllllIlllllllIIllllIlIllIlI.getResult(), llllllllllIlllllllIIllllIlIllIIl.getResult());
        }
    }
    
    private static void doTeleport(final Entity llllllllllIlllllllIIllllIIlllllI, final CoordinateArg llllllllllIlllllllIIllllIIllllIl, final CoordinateArg llllllllllIlllllllIIllllIIllllII, final CoordinateArg llllllllllIlllllllIIllllIIllIIII, final CoordinateArg llllllllllIlllllllIIllllIIlllIlI, final CoordinateArg llllllllllIlllllllIIllllIIlllIIl) {
        if (llllllllllIlllllllIIllllIIlllllI instanceof EntityPlayerMP) {
            final Set<SPacketPlayerPosLook.EnumFlags> llllllllllIlllllllIIllllIIlllIII = EnumSet.noneOf(SPacketPlayerPosLook.EnumFlags.class);
            float llllllllllIlllllllIIllllIIllIlll = (float)llllllllllIlllllllIIllllIIlllIlI.getAmount();
            if (llllllllllIlllllllIIllllIIlllIlI.isRelative()) {
                llllllllllIlllllllIIllllIIlllIII.add(SPacketPlayerPosLook.EnumFlags.Y_ROT);
            }
            else {
                llllllllllIlllllllIIllllIIllIlll = MathHelper.wrapDegrees(llllllllllIlllllllIIllllIIllIlll);
            }
            float llllllllllIlllllllIIllllIIllIllI = (float)llllllllllIlllllllIIllllIIlllIIl.getAmount();
            if (llllllllllIlllllllIIllllIIlllIIl.isRelative()) {
                llllllllllIlllllllIIllllIIlllIII.add(SPacketPlayerPosLook.EnumFlags.X_ROT);
            }
            else {
                llllllllllIlllllllIIllllIIllIllI = MathHelper.wrapDegrees(llllllllllIlllllllIIllllIIllIllI);
            }
            llllllllllIlllllllIIllllIIlllllI.dismountRidingEntity();
            ((EntityPlayerMP)llllllllllIlllllllIIllllIIlllllI).connection.setPlayerLocation(llllllllllIlllllllIIllllIIllllIl.getResult(), llllllllllIlllllllIIllllIIllllII.getResult(), llllllllllIlllllllIIllllIIllIIII.getResult(), llllllllllIlllllllIIllllIIllIlll, llllllllllIlllllllIIllllIIllIllI, llllllllllIlllllllIIllllIIlllIII);
            llllllllllIlllllllIIllllIIlllllI.setRotationYawHead(llllllllllIlllllllIIllllIIllIlll);
        }
        else {
            final float llllllllllIlllllllIIllllIIllIlIl = (float)MathHelper.wrapDegrees(llllllllllIlllllllIIllllIIlllIlI.getResult());
            float llllllllllIlllllllIIllllIIllIlII = (float)MathHelper.wrapDegrees(llllllllllIlllllllIIllllIIlllIIl.getResult());
            llllllllllIlllllllIIllllIIllIlII = MathHelper.clamp(llllllllllIlllllllIIllllIIllIlII, -90.0f, 90.0f);
            llllllllllIlllllllIIllllIIlllllI.setLocationAndAngles(llllllllllIlllllllIIllllIIllllIl.getResult(), llllllllllIlllllllIIllllIIllllII.getResult(), llllllllllIlllllllIIllllIIllIIII.getResult(), llllllllllIlllllllIIllllIIllIlIl, llllllllllIlllllllIIllllIIllIlII);
            llllllllllIlllllllIIllllIIlllllI.setRotationYawHead(llllllllllIlllllllIIllllIIllIlIl);
        }
        if (!(llllllllllIlllllllIIllllIIlllllI instanceof EntityLivingBase) || !((EntityLivingBase)llllllllllIlllllllIIllllIIlllllI).isElytraFlying()) {
            llllllllllIlllllllIIllllIIlllllI.motionY = 0.0;
            llllllllllIlllllllIIllllIIlllllI.onGround = true;
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}

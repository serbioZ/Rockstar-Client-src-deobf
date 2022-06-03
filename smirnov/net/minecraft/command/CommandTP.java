// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Set;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import java.util.EnumSet;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandTP extends CommandBase
{
    @Override
    public String getCommandName() {
        return "tp";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIlIIIIIIllIllIllIIll, final int llllllllllllIlIIIIIIllIllIllIIIl) {
        return llllllllllllIlIIIIIIllIllIllIIIl == 0;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIlIIIIIIlllIIIIIIlIl) {
        return "commands.tp.usage";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIlIIIIIIllIllllIIlll, final ICommandSender llllllllllllIlIIIIIIllIlllllIlIl, final String[] llllllllllllIlIIIIIIllIllllIIlIl) throws CommandException {
        if (llllllllllllIlIIIIIIllIllllIIlIl.length < 1) {
            throw new WrongUsageException("commands.tp.usage", new Object[0]);
        }
        int llllllllllllIlIIIIIIllIlllllIIll = 0;
        Entity llllllllllllIlIIIIIIllIlllllIIIl = null;
        if (llllllllllllIlIIIIIIllIllllIIlIl.length != 2 && llllllllllllIlIIIIIIllIllllIIlIl.length != 4 && llllllllllllIlIIIIIIllIllllIIlIl.length != 6) {
            final Entity llllllllllllIlIIIIIIllIlllllIIlI = CommandBase.getCommandSenderAsPlayer(llllllllllllIlIIIIIIllIlllllIlIl);
        }
        else {
            llllllllllllIlIIIIIIllIlllllIIIl = CommandBase.getEntity(llllllllllllIlIIIIIIllIllllIIlll, llllllllllllIlIIIIIIllIlllllIlIl, llllllllllllIlIIIIIIllIllllIIlIl[0]);
            llllllllllllIlIIIIIIllIlllllIIll = 1;
        }
        if (llllllllllllIlIIIIIIllIllllIIlIl.length != 1 && llllllllllllIlIIIIIIllIllllIIlIl.length != 2) {
            if (llllllllllllIlIIIIIIllIllllIIlIl.length < llllllllllllIlIIIIIIllIlllllIIll + 3) {
                throw new WrongUsageException("commands.tp.usage", new Object[0]);
            }
            if (llllllllllllIlIIIIIIllIlllllIIIl.world != null) {
                final int llllllllllllIlIIIIIIllIlllllIIII = 4096;
                int llllllllllllIlIIIIIIllIllllIllll = llllllllllllIlIIIIIIllIlllllIIll + 1;
                final CoordinateArg llllllllllllIlIIIIIIllIllllIlllI = CommandBase.parseCoordinate(llllllllllllIlIIIIIIllIlllllIIIl.posX, llllllllllllIlIIIIIIllIllllIIlIl[llllllllllllIlIIIIIIllIlllllIIll], true);
                final CoordinateArg llllllllllllIlIIIIIIllIllllIllIl = CommandBase.parseCoordinate(llllllllllllIlIIIIIIllIlllllIIIl.posY, llllllllllllIlIIIIIIllIllllIIlIl[llllllllllllIlIIIIIIllIllllIllll++], -4096, 4096, false);
                final CoordinateArg llllllllllllIlIIIIIIllIllllIllII = CommandBase.parseCoordinate(llllllllllllIlIIIIIIllIlllllIIIl.posZ, llllllllllllIlIIIIIIllIllllIIlIl[llllllllllllIlIIIIIIllIllllIllll++], true);
                final CoordinateArg llllllllllllIlIIIIIIllIllllIlIll = CommandBase.parseCoordinate(llllllllllllIlIIIIIIllIlllllIIIl.rotationYaw, (llllllllllllIlIIIIIIllIllllIIlIl.length > llllllllllllIlIIIIIIllIllllIllll) ? llllllllllllIlIIIIIIllIllllIIlIl[llllllllllllIlIIIIIIllIllllIllll++] : "~", false);
                final CoordinateArg llllllllllllIlIIIIIIllIllllIlIlI = CommandBase.parseCoordinate(llllllllllllIlIIIIIIllIlllllIIIl.rotationPitch, (llllllllllllIlIIIIIIllIllllIIlIl.length > llllllllllllIlIIIIIIllIllllIllll) ? llllllllllllIlIIIIIIllIllllIIlIl[llllllllllllIlIIIIIIllIllllIllll] : "~", false);
                teleportEntityToCoordinates(llllllllllllIlIIIIIIllIlllllIIIl, llllllllllllIlIIIIIIllIllllIlllI, llllllllllllIlIIIIIIllIllllIllIl, llllllllllllIlIIIIIIllIllllIllII, llllllllllllIlIIIIIIllIllllIlIll, llllllllllllIlIIIIIIllIllllIlIlI);
                CommandBase.notifyCommandListener(llllllllllllIlIIIIIIllIlllllIlIl, this, "commands.tp.success.coordinates", llllllllllllIlIIIIIIllIlllllIIIl.getName(), llllllllllllIlIIIIIIllIllllIlllI.getResult(), llllllllllllIlIIIIIIllIllllIllIl.getResult(), llllllllllllIlIIIIIIllIllllIllII.getResult());
            }
        }
        else {
            final Entity llllllllllllIlIIIIIIllIllllIlIIl = CommandBase.getEntity(llllllllllllIlIIIIIIllIllllIIlll, llllllllllllIlIIIIIIllIlllllIlIl, llllllllllllIlIIIIIIllIllllIIlIl[llllllllllllIlIIIIIIllIllllIIlIl.length - 1]);
            if (llllllllllllIlIIIIIIllIllllIlIIl.world != llllllllllllIlIIIIIIllIlllllIIIl.world) {
                throw new CommandException("commands.tp.notSameDimension", new Object[0]);
            }
            llllllllllllIlIIIIIIllIlllllIIIl.dismountRidingEntity();
            if (llllllllllllIlIIIIIIllIlllllIIIl instanceof EntityPlayerMP) {
                ((EntityPlayerMP)llllllllllllIlIIIIIIllIlllllIIIl).connection.setPlayerLocation(llllllllllllIlIIIIIIllIllllIlIIl.posX, llllllllllllIlIIIIIIllIllllIlIIl.posY, llllllllllllIlIIIIIIllIllllIlIIl.posZ, llllllllllllIlIIIIIIllIllllIlIIl.rotationYaw, llllllllllllIlIIIIIIllIllllIlIIl.rotationPitch);
            }
            else {
                llllllllllllIlIIIIIIllIlllllIIIl.setLocationAndAngles(llllllllllllIlIIIIIIllIllllIlIIl.posX, llllllllllllIlIIIIIIllIllllIlIIl.posY, llllllllllllIlIIIIIIllIllllIlIIl.posZ, llllllllllllIlIIIIIIllIllllIlIIl.rotationYaw, llllllllllllIlIIIIIIllIllllIlIIl.rotationPitch);
            }
            CommandBase.notifyCommandListener(llllllllllllIlIIIIIIllIlllllIlIl, this, "commands.tp.success", llllllllllllIlIIIIIIllIlllllIIIl.getName(), llllllllllllIlIIIIIIllIllllIlIIl.getName());
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIlIIIIIIllIllIlllIll, final ICommandSender llllllllllllIlIIIIIIllIllIlllIlI, final String[] llllllllllllIlIIIIIIllIllIllIllI, @Nullable final BlockPos llllllllllllIlIIIIIIllIllIlllIII) {
        return (llllllllllllIlIIIIIIllIllIllIllI.length != 1 && llllllllllllIlIIIIIIllIllIllIllI.length != 2) ? Collections.emptyList() : CommandBase.getListOfStringsMatchingLastWord(llllllllllllIlIIIIIIllIllIllIllI, llllllllllllIlIIIIIIllIllIlllIll.getAllUsernames());
    }
    
    private static void teleportEntityToCoordinates(final Entity llllllllllllIlIIIIIIllIlllIIIlll, final CoordinateArg llllllllllllIlIIIIIIllIlllIIIllI, final CoordinateArg llllllllllllIlIIIIIIllIlllIIIlIl, final CoordinateArg llllllllllllIlIIIIIIllIlllIIllll, final CoordinateArg llllllllllllIlIIIIIIllIlllIIIIll, final CoordinateArg llllllllllllIlIIIIIIllIlllIIIIlI) {
        if (llllllllllllIlIIIIIIllIlllIIIlll instanceof EntityPlayerMP) {
            final Set<SPacketPlayerPosLook.EnumFlags> llllllllllllIlIIIIIIllIlllIIllII = EnumSet.noneOf(SPacketPlayerPosLook.EnumFlags.class);
            if (llllllllllllIlIIIIIIllIlllIIIllI.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIllII.add(SPacketPlayerPosLook.EnumFlags.X);
            }
            if (llllllllllllIlIIIIIIllIlllIIIlIl.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIllII.add(SPacketPlayerPosLook.EnumFlags.Y);
            }
            if (llllllllllllIlIIIIIIllIlllIIllll.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIllII.add(SPacketPlayerPosLook.EnumFlags.Z);
            }
            if (llllllllllllIlIIIIIIllIlllIIIIlI.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIllII.add(SPacketPlayerPosLook.EnumFlags.X_ROT);
            }
            if (llllllllllllIlIIIIIIllIlllIIIIll.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIllII.add(SPacketPlayerPosLook.EnumFlags.Y_ROT);
            }
            float llllllllllllIlIIIIIIllIlllIIlIll = (float)llllllllllllIlIIIIIIllIlllIIIIll.getAmount();
            if (!llllllllllllIlIIIIIIllIlllIIIIll.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIlIll = MathHelper.wrapDegrees(llllllllllllIlIIIIIIllIlllIIlIll);
            }
            float llllllllllllIlIIIIIIllIlllIIlIlI = (float)llllllllllllIlIIIIIIllIlllIIIIlI.getAmount();
            if (!llllllllllllIlIIIIIIllIlllIIIIlI.isRelative()) {
                llllllllllllIlIIIIIIllIlllIIlIlI = MathHelper.wrapDegrees(llllllllllllIlIIIIIIllIlllIIlIlI);
            }
            llllllllllllIlIIIIIIllIlllIIIlll.dismountRidingEntity();
            ((EntityPlayerMP)llllllllllllIlIIIIIIllIlllIIIlll).connection.setPlayerLocation(llllllllllllIlIIIIIIllIlllIIIllI.getAmount(), llllllllllllIlIIIIIIllIlllIIIlIl.getAmount(), llllllllllllIlIIIIIIllIlllIIllll.getAmount(), llllllllllllIlIIIIIIllIlllIIlIll, llllllllllllIlIIIIIIllIlllIIlIlI, llllllllllllIlIIIIIIllIlllIIllII);
            llllllllllllIlIIIIIIllIlllIIIlll.setRotationYawHead(llllllllllllIlIIIIIIllIlllIIlIll);
        }
        else {
            final float llllllllllllIlIIIIIIllIlllIIlIIl = (float)MathHelper.wrapDegrees(llllllllllllIlIIIIIIllIlllIIIIll.getResult());
            float llllllllllllIlIIIIIIllIlllIIlIII = (float)MathHelper.wrapDegrees(llllllllllllIlIIIIIIllIlllIIIIlI.getResult());
            llllllllllllIlIIIIIIllIlllIIlIII = MathHelper.clamp(llllllllllllIlIIIIIIllIlllIIlIII, -90.0f, 90.0f);
            llllllllllllIlIIIIIIllIlllIIIlll.setLocationAndAngles(llllllllllllIlIIIIIIllIlllIIIllI.getResult(), llllllllllllIlIIIIIIllIlllIIIlIl.getResult(), llllllllllllIlIIIIIIllIlllIIllll.getResult(), llllllllllllIlIIIIIIllIlllIIlIIl, llllllllllllIlIIIIIIllIlllIIlIII);
            llllllllllllIlIIIIIIllIlllIIIlll.setRotationYawHead(llllllllllllIlIIIIIIllIlllIIlIIl);
        }
        if (!(llllllllllllIlIIIIIIllIlllIIIlll instanceof EntityLivingBase) || !((EntityLivingBase)llllllllllllIlIIIIIIllIlllIIIlll).isElytraFlying()) {
            llllllllllllIlIIIIIIllIlllIIIlll.motionY = 0.0;
            llllllllllllIlIIIIIIllIlllIIIlll.onGround = true;
        }
    }
}

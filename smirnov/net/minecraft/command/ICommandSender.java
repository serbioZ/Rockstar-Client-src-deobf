// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.ITextComponent;

public interface ICommandSender
{
    default ITextComponent getDisplayName() {
        return new TextComponentString(this.getName());
    }
    
    default void setCommandStat(final CommandResultStats.Type lllllllllllIIlIlllIlllIllIIllIlI, final int lllllllllllIIlIlllIlllIllIIllIIl) {
    }
    
    World getEntityWorld();
    
    String getName();
    
    default void addChatMessage(final ITextComponent lllllllllllIIlIlllIlllIllIlIIIII) {
    }
    
    default Vec3d getPositionVector() {
        return Vec3d.ZERO;
    }
    
    boolean canCommandSenderUseCommand(final int p0, final String p1);
    
    default BlockPos getPosition() {
        return BlockPos.ORIGIN;
    }
    
    default boolean sendCommandFeedback() {
        return false;
    }
    
    @Nullable
    default Entity getCommandSenderEntity() {
        return null;
    }
    
    @Nullable
    MinecraftServer getServer();
}

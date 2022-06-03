// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;
import java.util.Objects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import javax.annotation.Nullable;

public class CommandSenderWrapper implements ICommandSender
{
    @Nullable
    private final /* synthetic */ Integer field_194004_d;
    private final /* synthetic */ ICommandSender field_193043_a;
    @Nullable
    private final /* synthetic */ Entity field_194005_e;
    @Nullable
    private final /* synthetic */ Boolean field_194006_f;
    @Nullable
    private final /* synthetic */ BlockPos field_194003_c;
    @Nullable
    private final /* synthetic */ Vec3d field_194002_b;
    
    public CommandSenderWrapper func_194000_i() {
        return (this.field_194002_b != null) ? this : new CommandSenderWrapper(this.field_193043_a, this.getPositionVector(), this.getPosition(), this.field_194004_d, this.field_194005_e, this.field_194006_f);
    }
    
    @Override
    public BlockPos getPosition() {
        if (this.field_194003_c != null) {
            return this.field_194003_c;
        }
        return (this.field_194005_e != null) ? this.field_194005_e.getPosition() : this.field_193043_a.getPosition();
    }
    
    @Nullable
    @Override
    public Entity getCommandSenderEntity() {
        return (this.field_194005_e != null) ? this.field_194005_e.getCommandSenderEntity() : this.field_193043_a.getCommandSenderEntity();
    }
    
    public CommandSenderWrapper(final ICommandSender lllllllllllIIIlIIlIIIlIIlIlIlIIl, @Nullable final Vec3d lllllllllllIIIlIIlIIIlIIlIlIlIII, @Nullable final BlockPos lllllllllllIIIlIIlIIIlIIlIlIlllI, @Nullable final Integer lllllllllllIIIlIIlIIIlIIlIlIIllI, @Nullable final Entity lllllllllllIIIlIIlIIIlIIlIlIllII, @Nullable final Boolean lllllllllllIIIlIIlIIIlIIlIlIIlII) {
        this.field_193043_a = lllllllllllIIIlIIlIIIlIIlIlIlIIl;
        this.field_194002_b = lllllllllllIIIlIIlIIIlIIlIlIlIII;
        this.field_194003_c = lllllllllllIIIlIIlIIIlIIlIlIlllI;
        this.field_194004_d = lllllllllllIIIlIIlIIIlIIlIlIIllI;
        this.field_194005_e = lllllllllllIIIlIIlIIIlIIlIlIllII;
        this.field_194006_f = lllllllllllIIIlIIlIIIlIIlIlIIlII;
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return (this.field_194006_f != null) ? this.field_194006_f : this.field_193043_a.sendCommandFeedback();
    }
    
    public CommandSenderWrapper func_193999_a(final int lllllllllllIIIlIIlIIIlIIlIIlIIlI) {
        return (this.field_194004_d != null && this.field_194004_d <= lllllllllllIIIlIIlIIIlIIlIIlIIlI) ? this : new CommandSenderWrapper(this.field_193043_a, this.field_194002_b, this.field_194003_c, lllllllllllIIIlIIlIIIlIIlIIlIIlI, this.field_194005_e, this.field_194006_f);
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return (this.field_194005_e != null) ? this.field_194005_e.getDisplayName() : this.field_193043_a.getDisplayName();
    }
    
    public CommandSenderWrapper func_193997_a(final Entity lllllllllllIIIlIIlIIIlIIlIIllIIl, final Vec3d lllllllllllIIIlIIlIIIlIIlIIllIll) {
        return (this.field_194005_e == lllllllllllIIIlIIlIIIlIIlIIllIIl && Objects.equals(this.field_194002_b, lllllllllllIIIlIIlIIIlIIlIIllIll)) ? this : new CommandSenderWrapper(this.field_193043_a, lllllllllllIIIlIIlIIIlIIlIIllIll, new BlockPos(lllllllllllIIIlIIlIIIlIIlIIllIll), this.field_194004_d, lllllllllllIIIlIIlIIIlIIlIIllIIl, this.field_194006_f);
    }
    
    @Override
    public Vec3d getPositionVector() {
        if (this.field_194002_b != null) {
            return this.field_194002_b;
        }
        return (this.field_194005_e != null) ? this.field_194005_e.getPositionVector() : this.field_193043_a.getPositionVector();
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllIIIlIIlIIIlIIIllllIII, final String lllllllllllIIIlIIlIIIlIIIlllIlII) {
        return (this.field_194004_d == null || this.field_194004_d >= lllllllllllIIIlIIlIIIlIIIllllIII) && this.field_193043_a.canCommandSenderUseCommand(lllllllllllIIIlIIlIIIlIIIllllIII, lllllllllllIIIlIIlIIIlIIIlllIlII);
    }
    
    @Override
    public String getName() {
        return (this.field_194005_e != null) ? this.field_194005_e.getName() : this.field_193043_a.getName();
    }
    
    public static CommandSenderWrapper func_193998_a(final ICommandSender lllllllllllIIIlIIlIIIlIIlIlIIIlI) {
        return (CommandSenderWrapper)((lllllllllllIIIlIIlIIIlIIlIlIIIlI instanceof CommandSenderWrapper) ? lllllllllllIIIlIIlIIIlIIlIlIIIlI : new CommandSenderWrapper(lllllllllllIIIlIIlIIIlIIlIlIIIlI, null, null, null, null, null));
    }
    
    @Override
    public void setCommandStat(final CommandResultStats.Type lllllllllllIIIlIIlIIIlIIIlIlllIl, final int lllllllllllIIIlIIlIIIlIIIlIlllII) {
        if (this.field_194005_e != null) {
            this.field_194005_e.setCommandStat(lllllllllllIIIlIIlIIIlIIIlIlllIl, lllllllllllIIIlIIlIIIlIIIlIlllII);
        }
        else {
            this.field_193043_a.setCommandStat(lllllllllllIIIlIIlIIIlIIIlIlllIl, lllllllllllIIIlIIlIIIlIIIlIlllII);
        }
    }
    
    public CommandSenderWrapper func_194001_a(final boolean lllllllllllIIIlIIlIIIlIIlIIIllII) {
        return (this.field_194006_f == null || (this.field_194006_f && !lllllllllllIIIlIIlIIIlIIlIIIllII)) ? new CommandSenderWrapper(this.field_193043_a, this.field_194002_b, this.field_194003_c, this.field_194004_d, this.field_194005_e, lllllllllllIIIlIIlIIIlIIlIIIllII) : this;
    }
    
    @Nullable
    @Override
    public MinecraftServer getServer() {
        return this.field_193043_a.getServer();
    }
    
    @Override
    public World getEntityWorld() {
        return (this.field_194005_e != null) ? this.field_194005_e.getEntityWorld() : this.field_193043_a.getEntityWorld();
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllIIIlIIlIIIlIIIlllllll) {
        if (this.field_194006_f == null || this.field_194006_f) {
            this.field_193043_a.addChatMessage(lllllllllllIIIlIIlIIIlIIIlllllll);
        }
    }
}

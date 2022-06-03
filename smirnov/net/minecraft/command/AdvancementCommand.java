// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import net.minecraft.advancements.CriterionProgress;
import net.minecraft.advancements.PlayerAdvancements;
import java.util.Collections;
import java.util.Collection;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.util.ResourceLocation;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.MinecraftServer;

public class AdvancementCommand extends CommandBase
{
    public static Advancement func_192551_a(final MinecraftServer lllllllllllIllIllllIlllIIlIllIll, final String lllllllllllIllIllllIlllIIlIlllIl) throws CommandException {
        final Advancement lllllllllllIllIllllIlllIIlIlllII = lllllllllllIllIllllIlllIIlIllIll.func_191949_aK().func_192778_a(new ResourceLocation(lllllllllllIllIllllIlllIIlIlllIl));
        if (lllllllllllIllIllllIlllIIlIlllII == null) {
            throw new CommandException("commands.advancement.advancementNotFound", new Object[] { lllllllllllIllIllllIlllIIlIlllIl });
        }
        return lllllllllllIllIllllIlllIIlIlllII;
    }
    
    private List<Advancement> func_193514_a(final Advancement lllllllllllIllIllllIlllIlIllIIIl, final Mode lllllllllllIllIllllIlllIlIllIIII) {
        final List<Advancement> lllllllllllIllIllllIlllIlIllIlII = (List<Advancement>)Lists.newArrayList();
        if (lllllllllllIllIllllIlllIlIllIIII.field_193555_h) {
            for (Advancement lllllllllllIllIllllIlllIlIllIIll = lllllllllllIllIllllIlllIlIllIIIl.func_192070_b(); lllllllllllIllIllllIlllIlIllIIll != null; lllllllllllIllIllllIlllIlIllIIll = lllllllllllIllIllllIlllIlIllIIll.func_192070_b()) {
                lllllllllllIllIllllIlllIlIllIlII.add(lllllllllllIllIllllIlllIlIllIIll);
            }
        }
        lllllllllllIllIllllIlllIlIllIlII.add(lllllllllllIllIllllIlllIlIllIIIl);
        if (lllllllllllIllIllllIlllIlIllIIII.field_193556_i) {
            this.func_193515_a(lllllllllllIllIllllIlllIlIllIIIl, lllllllllllIllIllllIlllIlIllIlII);
        }
        return lllllllllllIllIllllIlllIlIllIlII;
    }
    
    private void func_192552_c(final ICommandSender lllllllllllIllIllllIlllIlIIlIIlI, final EntityPlayerMP lllllllllllIllIllllIlllIlIIIllII, final Advancement lllllllllllIllIllllIlllIlIIlIIII) throws CommandException {
        final AdvancementProgress lllllllllllIllIllllIlllIlIIIllll = lllllllllllIllIllllIlllIlIIIllII.func_192039_O().func_192747_a(lllllllllllIllIllllIlllIlIIlIIII);
        if (!lllllllllllIllIllllIlllIlIIIllll.func_192105_a()) {
            throw new CommandException("commands.advancement.test.advancement.notDone", new Object[] { lllllllllllIllIllllIlllIlIIIllII.getName(), lllllllllllIllIllllIlllIlIIlIIII.func_192067_g() });
        }
        CommandBase.notifyCommandListener(lllllllllllIllIllllIlllIlIIlIIlI, this, "commands.advancement.test.advancement.success", lllllllllllIllIllllIlllIlIIIllII.getName(), lllllllllllIllIllllIlllIlIIlIIII.func_192067_g());
    }
    
    @Override
    public String getCommandName() {
        return "advancement";
    }
    
    private List<ResourceLocation> func_193517_a(final MinecraftServer lllllllllllIllIllllIlllIIllIllll) {
        final List<ResourceLocation> lllllllllllIllIllllIlllIIllIlllI = (List<ResourceLocation>)Lists.newArrayList();
        for (final Advancement lllllllllllIllIllllIlllIIllIllIl : lllllllllllIllIllllIlllIIllIllll.func_191949_aK().func_192780_b()) {
            lllllllllllIllIllllIlllIIllIlllI.add(lllllllllllIllIllllIlllIIllIllIl.func_192067_g());
        }
        return lllllllllllIllIllllIlllIIllIlllI;
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIllIllllIlllIllllIIII, final ICommandSender lllllllllllIllIllllIlllIlllIllll, final String[] lllllllllllIllIllllIlllIllllIlIl) throws CommandException {
        if (lllllllllllIllIllllIlllIllllIlIl.length < 1) {
            throw new WrongUsageException("commands.advancement.usage", new Object[0]);
        }
        final ActionType lllllllllllIllIllllIlllIllllIlII = ActionType.func_193536_a(lllllllllllIllIllllIlllIllllIlIl[0]);
        if (lllllllllllIllIllllIlllIllllIlII != null) {
            if (lllllllllllIllIllllIlllIllllIlIl.length < 3) {
                throw lllllllllllIllIllllIlllIllllIlII.func_193534_a();
            }
            final EntityPlayerMP lllllllllllIllIllllIlllIllllIIll = CommandBase.getPlayer(lllllllllllIllIllllIlllIllllIIII, lllllllllllIllIllllIlllIlllIllll, lllllllllllIllIllllIlllIllllIlIl[1]);
            final Mode lllllllllllIllIllllIlllIllllIIlI = Mode.func_193547_a(lllllllllllIllIllllIlllIllllIlIl[2]);
            if (lllllllllllIllIllllIlllIllllIIlI == null) {
                throw lllllllllllIllIllllIlllIllllIlII.func_193534_a();
            }
            this.func_193516_a(lllllllllllIllIllllIlllIllllIIII, lllllllllllIllIllllIlllIlllIllll, lllllllllllIllIllllIlllIllllIlIl, lllllllllllIllIllllIlllIllllIIll, lllllllllllIllIllllIlllIllllIlII, lllllllllllIllIllllIlllIllllIIlI);
        }
        else {
            if (!"test".equals(lllllllllllIllIllllIlllIllllIlIl[0])) {
                throw new WrongUsageException("commands.advancement.usage", new Object[0]);
            }
            if (lllllllllllIllIllllIlllIllllIlIl.length == 3) {
                this.func_192552_c(lllllllllllIllIllllIlllIlllIllll, CommandBase.getPlayer(lllllllllllIllIllllIlllIllllIIII, lllllllllllIllIllllIlllIlllIllll, lllllllllllIllIllllIlllIllllIlIl[1]), func_192551_a(lllllllllllIllIllllIlllIllllIIII, lllllllllllIllIllllIlllIllllIlIl[2]));
            }
            else {
                if (lllllllllllIllIllllIlllIllllIlIl.length != 4) {
                    throw new WrongUsageException("commands.advancement.test.usage", new Object[0]);
                }
                this.func_192554_c(lllllllllllIllIllllIlllIlllIllll, CommandBase.getPlayer(lllllllllllIllIllllIlllIllllIIII, lllllllllllIllIllllIlllIlllIllll, lllllllllllIllIllllIlllIllllIlIl[1]), func_192551_a(lllllllllllIllIllllIlllIllllIIII, lllllllllllIllIllllIlllIllllIlIl[2]), lllllllllllIllIllllIlllIllllIlIl[3]);
            }
        }
    }
    
    private void func_193516_a(final MinecraftServer lllllllllllIllIllllIlllIllIlllll, final ICommandSender lllllllllllIllIllllIlllIllIlIIlI, final String[] lllllllllllIllIllllIlllIllIlIIIl, final EntityPlayerMP lllllllllllIllIllllIlllIllIlllII, final ActionType lllllllllllIllIllllIlllIllIIllll, final Mode lllllllllllIllIllllIlllIllIllIlI) throws CommandException {
        if (lllllllllllIllIllllIlllIllIllIlI == Mode.EVERYTHING) {
            if (lllllllllllIllIllllIlllIllIlIIIl.length != 3) {
                throw lllllllllllIllIllllIlllIllIllIlI.func_193544_a(lllllllllllIllIllllIlllIllIIllll);
            }
            final int lllllllllllIllIllllIlllIllIllIIl = lllllllllllIllIllllIlllIllIIllll.func_193532_a(lllllllllllIllIllllIlllIllIlllII, lllllllllllIllIllllIlllIllIlllll.func_191949_aK().func_192780_b());
            if (lllllllllllIllIllllIlllIllIllIIl == 0) {
                throw lllllllllllIllIllllIlllIllIllIlI.func_193543_a(lllllllllllIllIllllIlllIllIIllll, lllllllllllIllIllllIlllIllIlllII.getName());
            }
            lllllllllllIllIllllIlllIllIllIlI.func_193546_a(lllllllllllIllIllllIlllIllIlIIlI, this, lllllllllllIllIllllIlllIllIIllll, lllllllllllIllIllllIlllIllIlllII.getName(), lllllllllllIllIllllIlllIllIllIIl);
        }
        else {
            if (lllllllllllIllIllllIlllIllIlIIIl.length < 4) {
                throw lllllllllllIllIllllIlllIllIllIlI.func_193544_a(lllllllllllIllIllllIlllIllIIllll);
            }
            final Advancement lllllllllllIllIllllIlllIllIllIII = func_192551_a(lllllllllllIllIllllIlllIllIlllll, lllllllllllIllIllllIlllIllIlIIIl[3]);
            if (lllllllllllIllIllllIlllIllIllIlI == Mode.ONLY && lllllllllllIllIllllIlllIllIlIIIl.length == 5) {
                final String lllllllllllIllIllllIlllIllIlIlll = lllllllllllIllIllllIlllIllIlIIIl[4];
                if (!lllllllllllIllIllllIlllIllIllIII.func_192073_f().keySet().contains(lllllllllllIllIllllIlllIllIlIlll)) {
                    throw new CommandException("commands.advancement.criterionNotFound", new Object[] { lllllllllllIllIllllIlllIllIllIII.func_192067_g(), lllllllllllIllIllllIlllIllIlIIIl[4] });
                }
                if (!lllllllllllIllIllllIlllIllIIllll.func_193535_a(lllllllllllIllIllllIlllIllIlllII, lllllllllllIllIllllIlllIllIllIII, lllllllllllIllIllllIlllIllIlIlll)) {
                    throw new CommandException(String.valueOf(lllllllllllIllIllllIlllIllIIllll.field_193541_d) + ".criterion.failed", new Object[] { lllllllllllIllIllllIlllIllIllIII.func_192067_g(), lllllllllllIllIllllIlllIllIlllII.getName(), lllllllllllIllIllllIlllIllIlIlll });
                }
                CommandBase.notifyCommandListener(lllllllllllIllIllllIlllIllIlIIlI, this, String.valueOf(lllllllllllIllIllllIlllIllIIllll.field_193541_d) + ".criterion.success", lllllllllllIllIllllIlllIllIllIII.func_192067_g(), lllllllllllIllIllllIlllIllIlllII.getName(), lllllllllllIllIllllIlllIllIlIlll);
            }
            else {
                if (lllllllllllIllIllllIlllIllIlIIIl.length != 4) {
                    throw lllllllllllIllIllllIlllIllIllIlI.func_193544_a(lllllllllllIllIllllIlllIllIIllll);
                }
                final List<Advancement> lllllllllllIllIllllIlllIllIlIllI = this.func_193514_a(lllllllllllIllIllllIlllIllIllIII, lllllllllllIllIllllIlllIllIllIlI);
                final int lllllllllllIllIllllIlllIllIlIlIl = lllllllllllIllIllllIlllIllIIllll.func_193532_a(lllllllllllIllIllllIlllIllIlllII, lllllllllllIllIllllIlllIllIlIllI);
                if (lllllllllllIllIllllIlllIllIlIlIl == 0) {
                    throw lllllllllllIllIllllIlllIllIllIlI.func_193543_a(lllllllllllIllIllllIlllIllIIllll, lllllllllllIllIllllIlllIllIllIII.func_192067_g(), lllllllllllIllIllllIlllIllIlllII.getName());
                }
                lllllllllllIllIllllIlllIllIllIlI.func_193546_a(lllllllllllIllIllllIlllIllIlIIlI, this, lllllllllllIllIllllIlllIllIIllll, lllllllllllIllIllllIlllIllIllIII.func_192067_g(), lllllllllllIllIllllIlllIllIlllII.getName(), lllllllllllIllIllllIlllIllIlIlIl);
            }
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIllIllllIlllIlIIIIIlI, final ICommandSender lllllllllllIllIllllIlllIlIIIIIIl, final String[] lllllllllllIllIllllIlllIIllllIII, @Nullable final BlockPos lllllllllllIllIllllIlllIIlllllll) {
        if (lllllllllllIllIllllIlllIIllllIII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, "grant", "revoke", "test");
        }
        final ActionType lllllllllllIllIllllIlllIIllllllI = ActionType.func_193536_a(lllllllllllIllIllllIlllIIllllIII[0]);
        if (lllllllllllIllIllllIlllIIllllllI != null) {
            if (lllllllllllIllIllllIlllIIllllIII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, lllllllllllIllIllllIlllIlIIIIIlI.getAllUsernames());
            }
            if (lllllllllllIllIllllIlllIIllllIII.length == 3) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, Mode.field_193553_f);
            }
            final Mode lllllllllllIllIllllIlllIIlllllIl = Mode.func_193547_a(lllllllllllIllIllllIlllIIllllIII[2]);
            if (lllllllllllIllIllllIlllIIlllllIl != null && lllllllllllIllIllllIlllIIlllllIl != Mode.EVERYTHING) {
                if (lllllllllllIllIllllIlllIIllllIII.length == 4) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, this.func_193517_a(lllllllllllIllIllllIlllIlIIIIIlI));
                }
                if (lllllllllllIllIllllIlllIIllllIII.length == 5 && lllllllllllIllIllllIlllIIlllllIl == Mode.ONLY) {
                    final Advancement lllllllllllIllIllllIlllIIlllllII = lllllllllllIllIllllIlllIlIIIIIlI.func_191949_aK().func_192778_a(new ResourceLocation(lllllllllllIllIllllIlllIIllllIII[3]));
                    if (lllllllllllIllIllllIlllIIlllllII != null) {
                        return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, lllllllllllIllIllllIlllIIlllllII.func_192073_f().keySet());
                    }
                }
            }
        }
        if ("test".equals(lllllllllllIllIllllIlllIIllllIII[0])) {
            if (lllllllllllIllIllllIlllIIllllIII.length == 2) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, lllllllllllIllIllllIlllIlIIIIIlI.getAllUsernames());
            }
            if (lllllllllllIllIllllIlllIIllllIII.length == 3) {
                return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, this.func_193517_a(lllllllllllIllIllllIlllIlIIIIIlI));
            }
            if (lllllllllllIllIllllIlllIIllllIII.length == 4) {
                final Advancement lllllllllllIllIllllIlllIIllllIll = lllllllllllIllIllllIlllIlIIIIIlI.func_191949_aK().func_192778_a(new ResourceLocation(lllllllllllIllIllllIlllIIllllIII[2]));
                if (lllllllllllIllIllllIlllIIllllIll != null) {
                    return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIllIllllIlllIIllllIII, lllllllllllIllIllllIlllIIllllIll.func_192073_f().keySet());
                }
            }
        }
        return Collections.emptyList();
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIllIllllIllllIIIIIIII) {
        return "commands.advancement.usage";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllIllIllllIlllIIllIIIll, final int lllllllllllIllIllllIlllIIllIIIlI) {
        return lllllllllllIllIllllIlllIIllIIIll.length > 1 && ("grant".equals(lllllllllllIllIllllIlllIIllIIIll[0]) || "revoke".equals(lllllllllllIllIllllIlllIIllIIIll[0]) || "test".equals(lllllllllllIllIllllIlllIIllIIIll[0])) && lllllllllllIllIllllIlllIIllIIIlI == 1;
    }
    
    private void func_192554_c(final ICommandSender lllllllllllIllIllllIlllIlIlIIlIl, final EntityPlayerMP lllllllllllIllIllllIlllIlIlIIlII, final Advancement lllllllllllIllIllllIlllIlIIlllII, final String lllllllllllIllIllllIlllIlIIllIll) throws CommandException {
        final PlayerAdvancements lllllllllllIllIllllIlllIlIlIIIIl = lllllllllllIllIllllIlllIlIlIIlII.func_192039_O();
        final CriterionProgress lllllllllllIllIllllIlllIlIlIIIII = lllllllllllIllIllllIlllIlIlIIIIl.func_192747_a(lllllllllllIllIllllIlllIlIIlllII).func_192106_c(lllllllllllIllIllllIlllIlIIllIll);
        if (lllllllllllIllIllllIlllIlIlIIIII == null) {
            throw new CommandException("commands.advancement.criterionNotFound", new Object[] { lllllllllllIllIllllIlllIlIIlllII.func_192067_g(), lllllllllllIllIllllIlllIlIIllIll });
        }
        if (!lllllllllllIllIllllIlllIlIlIIIII.func_192151_a()) {
            throw new CommandException("commands.advancement.test.criterion.notDone", new Object[] { lllllllllllIllIllllIlllIlIlIIlII.getName(), lllllllllllIllIllllIlllIlIIlllII.func_192067_g(), lllllllllllIllIllllIlllIlIIllIll });
        }
        CommandBase.notifyCommandListener(lllllllllllIllIllllIlllIlIlIIlIl, this, "commands.advancement.test.criterion.success", lllllllllllIllIllllIlllIlIlIIlII.getName(), lllllllllllIllIllllIlllIlIIlllII.func_192067_g(), lllllllllllIllIllllIlllIlIIllIll);
    }
    
    private void func_193515_a(final Advancement lllllllllllIllIllllIlllIllIIIlII, final List<Advancement> lllllllllllIllIllllIlllIllIIIIll) {
        for (final Advancement lllllllllllIllIllllIlllIllIIIIlI : lllllllllllIllIllllIlllIllIIIlII.func_192069_e()) {
            lllllllllllIllIllllIlllIllIIIIll.add(lllllllllllIllIllllIlllIllIIIIlI);
            this.func_193515_a(lllllllllllIllIllllIlllIllIIIIlI, lllllllllllIllIllllIlllIllIIIIll);
        }
    }
    
    enum Mode
    {
        static final /* synthetic */ String[] field_193553_f;
        final /* synthetic */ boolean field_193555_h;
        
        THROUGH("THROUGH", 1, "through", true, true), 
        UNTIL("UNTIL", 3, "until", true, false), 
        FROM("FROM", 2, "from", false, true), 
        EVERYTHING("EVERYTHING", 4, "everything", true, true);
        
        final /* synthetic */ boolean field_193556_i;
        final /* synthetic */ String field_193554_g;
        
        ONLY("ONLY", 0, "only", false, false);
        
        void func_193546_a(final ICommandSender lllllllllllIIIlIIlIlIIlIllIIIIIl, final AdvancementCommand lllllllllllIIIlIIlIlIIlIllIIIIII, final ActionType lllllllllllIIIlIIlIlIIlIlIllllll, final Object... lllllllllllIIIlIIlIlIIlIllIIIIll) {
            CommandBase.notifyCommandListener(lllllllllllIIIlIIlIlIIlIllIIIIIl, lllllllllllIIIlIIlIlIIlIllIIIIII, String.valueOf(lllllllllllIIIlIIlIlIIlIlIllllll.field_193541_d) + "." + this.field_193554_g + ".success", lllllllllllIIIlIIlIlIIlIllIIIIll);
        }
        
        static {
            field_193553_f = new String[values().length];
            for (int lllllllllllIIIlIIlIlIIlIlllIllIl = 0; lllllllllllIIIlIIlIlIIlIlllIllIl < values().length; ++lllllllllllIIIlIIlIlIIlIlllIllIl) {
                Mode.field_193553_f[lllllllllllIIIlIIlIlIIlIlllIllIl] = values()[lllllllllllIIIlIIlIlIIlIlllIllIl].field_193554_g;
            }
        }
        
        CommandException func_193544_a(final ActionType lllllllllllIIIlIIlIlIIlIllIIllIl) {
            return new CommandException(String.valueOf(lllllllllllIIIlIIlIlIIlIllIIllIl.field_193541_d) + "." + this.field_193554_g + ".usage", new Object[0]);
        }
        
        CommandException func_193543_a(final ActionType lllllllllllIIIlIIlIlIIlIllIlIlII, final Object... lllllllllllIIIlIIlIlIIlIllIlIIll) {
            return new CommandException(String.valueOf(lllllllllllIIIlIIlIlIIlIllIlIlII.field_193541_d) + "." + this.field_193554_g + ".failed", lllllllllllIIIlIIlIlIIlIllIlIIll);
        }
        
        private Mode(final String lllllllllllIIIlIIlIlIIlIlllIIIII, final int lllllllllllIIIlIIlIlIIlIllIlllll, final String lllllllllllIIIlIIlIlIIlIllIllllI, final boolean lllllllllllIIIlIIlIlIIlIlllIIIll, final boolean lllllllllllIIIlIIlIlIIlIlllIIIlI) {
            this.field_193554_g = lllllllllllIIIlIIlIlIIlIllIllllI;
            this.field_193555_h = lllllllllllIIIlIIlIlIIlIlllIIIll;
            this.field_193556_i = lllllllllllIIIlIIlIlIIlIlllIIIlI;
        }
        
        @Nullable
        static Mode func_193547_a(final String lllllllllllIIIlIIlIlIIlIlIllIllI) {
            final double lllllllllllIIIlIIlIlIIlIlIllIIlI;
            final byte lllllllllllIIIlIIlIlIIlIlIllIIll = (byte)((Mode[])(Object)(lllllllllllIIIlIIlIlIIlIlIllIIlI = (double)(Object)values())).length;
            for (String lllllllllllIIIlIIlIlIIlIlIllIlII = (String)0; lllllllllllIIIlIIlIlIIlIlIllIlII < lllllllllllIIIlIIlIlIIlIlIllIIll; ++lllllllllllIIIlIIlIlIIlIlIllIlII) {
                final Mode lllllllllllIIIlIIlIlIIlIlIllIlll = lllllllllllIIIlIIlIlIIlIlIllIIlI[lllllllllllIIIlIIlIlIIlIlIllIlII];
                if (lllllllllllIIIlIIlIlIIlIlIllIlll.field_193554_g.equals(lllllllllllIIIlIIlIlIIlIlIllIllI)) {
                    return lllllllllllIIIlIIlIlIIlIlIllIlll;
                }
            }
            return null;
        }
    }
    
    enum ActionType
    {
        REVOKE(1, "revoke") {
            @Override
            protected boolean func_193537_a(final EntityPlayerMP llllllllllIllllIIIIllIIlIIIIIlII, final Advancement llllllllllIllllIIIIllIIlIIIIIIll) {
                final AdvancementProgress llllllllllIllllIIIIllIIlIIIIIIlI = llllllllllIllllIIIIllIIlIIIIIlII.func_192039_O().func_192747_a(llllllllllIllllIIIIllIIlIIIIIIll);
                if (!llllllllllIllllIIIIllIIlIIIIIIlI.func_192108_b()) {
                    return false;
                }
                for (final String llllllllllIllllIIIIllIIlIIIIIIIl : llllllllllIllllIIIIllIIlIIIIIIlI.func_192102_e()) {
                    llllllllllIllllIIIIllIIlIIIIIlII.func_192039_O().func_192744_b(llllllllllIllllIIIIllIIlIIIIIIll, llllllllllIllllIIIIllIIlIIIIIIIl);
                }
                return true;
            }
            
            @Override
            protected boolean func_193535_a(final EntityPlayerMP llllllllllIllllIIIIllIIIllllIlII, final Advancement llllllllllIllllIIIIllIIIllllIllI, final String llllllllllIllllIIIIllIIIllllIlIl) {
                return llllllllllIllllIIIIllIIIllllIlII.func_192039_O().func_192744_b(llllllllllIllllIIIIllIIIllllIllI, llllllllllIllllIIIIllIIIllllIlIl);
            }
        }, 
        GRANT(0, "grant") {
            @Override
            protected boolean func_193537_a(final EntityPlayerMP lllllllllllIlllIlIlllllIIIlIIlIl, final Advancement lllllllllllIlllIlIlllllIIIlIlIII) {
                final AdvancementProgress lllllllllllIlllIlIlllllIIIlIIlll = lllllllllllIlllIlIlllllIIIlIIlIl.func_192039_O().func_192747_a(lllllllllllIlllIlIlllllIIIlIlIII);
                if (lllllllllllIlllIlIlllllIIIlIIlll.func_192105_a()) {
                    return false;
                }
                for (final String lllllllllllIlllIlIlllllIIIlIIllI : lllllllllllIlllIlIlllllIIIlIIlll.func_192107_d()) {
                    lllllllllllIlllIlIlllllIIIlIIlIl.func_192039_O().func_192750_a(lllllllllllIlllIlIlllllIIIlIlIII, lllllllllllIlllIlIlllllIIIlIIllI);
                }
                return true;
            }
            
            @Override
            protected boolean func_193535_a(final EntityPlayerMP lllllllllllIlllIlIlllllIIIIlllII, final Advancement lllllllllllIlllIlIlllllIIIIllIII, final String lllllllllllIlllIlIlllllIIIIlIlll) {
                return lllllllllllIlllIlIlllllIIIIlllII.func_192039_O().func_192750_a(lllllllllllIlllIlIlllllIIIIllIII, lllllllllllIlllIlIlllllIIIIlIlll);
            }
        };
        
        final /* synthetic */ String field_193541_d;
        final /* synthetic */ String field_193540_c;
        
        public int func_193532_a(final EntityPlayerMP lllllllllllIIlIllllIlIIllllIIlll, final Iterable<Advancement> lllllllllllIIlIllllIlIIllllIIllI) {
            int lllllllllllIIlIllllIlIIllllIlIlI = 0;
            for (final Advancement lllllllllllIIlIllllIlIIllllIlIIl : lllllllllllIIlIllllIlIIllllIIllI) {
                if (this.func_193537_a(lllllllllllIIlIllllIlIIllllIIlll, lllllllllllIIlIllllIlIIllllIlIIl)) {
                    ++lllllllllllIIlIllllIlIIllllIlIlI;
                }
            }
            return lllllllllllIIlIllllIlIIllllIlIlI;
        }
        
        @Nullable
        static ActionType func_193536_a(final String lllllllllllIIlIllllIlIIlllllllIl) {
            final short lllllllllllIIlIllllIlIIlllllIlll;
            final char lllllllllllIIlIllllIlIIllllllIII = (char)((ActionType[])(Object)(lllllllllllIIlIllllIlIIlllllIlll = (short)(Object)values())).length;
            for (long lllllllllllIIlIllllIlIIllllllIIl = 0; lllllllllllIIlIllllIlIIllllllIIl < lllllllllllIIlIllllIlIIllllllIII; ++lllllllllllIIlIllllIlIIllllllIIl) {
                final ActionType lllllllllllIIlIllllIlIIlllllllII = lllllllllllIIlIllllIlIIlllllIlll[lllllllllllIIlIllllIlIIllllllIIl];
                if (lllllllllllIIlIllllIlIIlllllllII.field_193540_c.equals(lllllllllllIIlIllllIlIIlllllllIl)) {
                    return lllllllllllIIlIllllIlIIlllllllII;
                }
            }
            return null;
        }
        
        CommandException func_193534_a() {
            return new CommandException(String.valueOf(this.field_193541_d) + ".usage", new Object[0]);
        }
        
        protected abstract boolean func_193537_a(final EntityPlayerMP p0, final Advancement p1);
        
        protected abstract boolean func_193535_a(final EntityPlayerMP p0, final Advancement p1, final String p2);
        
        private ActionType(final String lllllllllllIIlIllllIlIlIIIIIIlIl, final int lllllllllllIIlIllllIlIlIIIIIIlII, final String lllllllllllIIlIllllIlIlIIIIIIlll) {
            this.field_193540_c = lllllllllllIIlIllllIlIlIIIIIIlll;
            this.field_193541_d = "commands.advancement." + lllllllllllIIlIllllIlIlIIIIIIlll;
        }
    }
}

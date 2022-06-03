// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;

public class CommandEffect extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllIIIllIIIIIlIIllIlIII) {
        return "commands.effect.usage";
    }
    
    @Override
    public String getCommandName() {
        return "effect";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllIIIllIIIIIlIIlIIlllI, final ICommandSender llllllllllllIIIllIIIIIlIIlIIllIl, final String[] llllllllllllIIIllIIIIIlIIlIIllII) throws CommandException {
        if (llllllllllllIIIllIIIIIlIIlIIllII.length < 2) {
            throw new WrongUsageException("commands.effect.usage", new Object[0]);
        }
        final EntityLivingBase llllllllllllIIIllIIIIIlIIlIllIII = CommandBase.getEntity(llllllllllllIIIllIIIIIlIIlIIlllI, llllllllllllIIIllIIIIIlIIlIIllIl, llllllllllllIIIllIIIIIlIIlIIllII[0], (Class<? extends EntityLivingBase>)EntityLivingBase.class);
        if ("clear".equals(llllllllllllIIIllIIIIIlIIlIIllII[1])) {
            if (llllllllllllIIIllIIIIIlIIlIllIII.getActivePotionEffects().isEmpty()) {
                throw new CommandException("commands.effect.failure.notActive.all", new Object[] { llllllllllllIIIllIIIIIlIIlIllIII.getName() });
            }
            llllllllllllIIIllIIIIIlIIlIllIII.clearActivePotions();
            CommandBase.notifyCommandListener(llllllllllllIIIllIIIIIlIIlIIllIl, this, "commands.effect.success.removed.all", llllllllllllIIIllIIIIIlIIlIllIII.getName());
        }
        else {
            Potion llllllllllllIIIllIIIIIlIIlIlIllI = null;
            try {
                final Potion llllllllllllIIIllIIIIIlIIlIlIlll = Potion.getPotionById(CommandBase.parseInt(llllllllllllIIIllIIIIIlIIlIIllII[1], 1));
            }
            catch (NumberInvalidException llllllllllllIIIllIIIIIlIIlIlIlIl) {
                llllllllllllIIIllIIIIIlIIlIlIllI = Potion.getPotionFromResourceLocation(llllllllllllIIIllIIIIIlIIlIIllII[1]);
            }
            if (llllllllllllIIIllIIIIIlIIlIlIllI == null) {
                throw new NumberInvalidException("commands.effect.notFound", new Object[] { llllllllllllIIIllIIIIIlIIlIIllII[1] });
            }
            int llllllllllllIIIllIIIIIlIIlIlIlII = 600;
            int llllllllllllIIIllIIIIIlIIlIlIIll = 30;
            int llllllllllllIIIllIIIIIlIIlIlIIlI = 0;
            if (llllllllllllIIIllIIIIIlIIlIIllII.length >= 3) {
                llllllllllllIIIllIIIIIlIIlIlIIll = CommandBase.parseInt(llllllllllllIIIllIIIIIlIIlIIllII[2], 0, 1000000);
                if (llllllllllllIIIllIIIIIlIIlIlIllI.isInstant()) {
                    llllllllllllIIIllIIIIIlIIlIlIlII = llllllllllllIIIllIIIIIlIIlIlIIll;
                }
                else {
                    llllllllllllIIIllIIIIIlIIlIlIlII = llllllllllllIIIllIIIIIlIIlIlIIll * 20;
                }
            }
            else if (llllllllllllIIIllIIIIIlIIlIlIllI.isInstant()) {
                llllllllllllIIIllIIIIIlIIlIlIlII = 1;
            }
            if (llllllllllllIIIllIIIIIlIIlIIllII.length >= 4) {
                llllllllllllIIIllIIIIIlIIlIlIIlI = CommandBase.parseInt(llllllllllllIIIllIIIIIlIIlIIllII[3], 0, 255);
            }
            boolean llllllllllllIIIllIIIIIlIIlIlIIIl = true;
            if (llllllllllllIIIllIIIIIlIIlIIllII.length >= 5 && "true".equalsIgnoreCase(llllllllllllIIIllIIIIIlIIlIIllII[4])) {
                llllllllllllIIIllIIIIIlIIlIlIIIl = false;
            }
            if (llllllllllllIIIllIIIIIlIIlIlIIll > 0) {
                final PotionEffect llllllllllllIIIllIIIIIlIIlIlIIII = new PotionEffect(llllllllllllIIIllIIIIIlIIlIlIllI, llllllllllllIIIllIIIIIlIIlIlIlII, llllllllllllIIIllIIIIIlIIlIlIIlI, false, llllllllllllIIIllIIIIIlIIlIlIIIl);
                llllllllllllIIIllIIIIIlIIlIllIII.addPotionEffect(llllllllllllIIIllIIIIIlIIlIlIIII);
                CommandBase.notifyCommandListener(llllllllllllIIIllIIIIIlIIlIIllIl, this, "commands.effect.success", new TextComponentTranslation(llllllllllllIIIllIIIIIlIIlIlIIII.getEffectName(), new Object[0]), Potion.getIdFromPotion(llllllllllllIIIllIIIIIlIIlIlIllI), llllllllllllIIIllIIIIIlIIlIlIIlI, llllllllllllIIIllIIIIIlIIlIllIII.getName(), llllllllllllIIIllIIIIIlIIlIlIIll);
            }
            else {
                if (!llllllllllllIIIllIIIIIlIIlIllIII.isPotionActive(llllllllllllIIIllIIIIIlIIlIlIllI)) {
                    throw new CommandException("commands.effect.failure.notActive", new Object[] { new TextComponentTranslation(llllllllllllIIIllIIIIIlIIlIlIllI.getName(), new Object[0]), llllllllllllIIIllIIIIIlIIlIllIII.getName() });
                }
                llllllllllllIIIllIIIIIlIIlIllIII.removePotionEffect(llllllllllllIIIllIIIIIlIIlIlIllI);
                CommandBase.notifyCommandListener(llllllllllllIIIllIIIIIlIIlIIllIl, this, "commands.effect.success.removed", new TextComponentTranslation(llllllllllllIIIllIIIIIlIIlIlIllI.getName(), new Object[0]), llllllllllllIIIllIIIIIlIIlIllIII.getName());
            }
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllIIIllIIIIIlIIIlllIIl, final int llllllllllllIIIllIIIIIlIIIlllIII) {
        return llllllllllllIIIllIIIIIlIIIlllIII == 0;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllIIIllIIIIIlIIIllllIl, final ICommandSender llllllllllllIIIllIIIIIlIIlIIIIII, final String[] llllllllllllIIIllIIIIIlIIIllllII, @Nullable final BlockPos llllllllllllIIIllIIIIIlIIIlllllI) {
        if (llllllllllllIIIllIIIIIlIIIllllII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIIllIIIIIlIIIllllII, llllllllllllIIIllIIIIIlIIIllllIl.getAllUsernames());
        }
        if (llllllllllllIIIllIIIIIlIIIllllII.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIIllIIIIIlIIIllllII, Potion.REGISTRY.getKeys());
        }
        return (llllllllllllIIIllIIIIIlIIIllllII.length == 5) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllIIIllIIIIIlIIIllllII, "true", "false") : Collections.emptyList();
    }
}

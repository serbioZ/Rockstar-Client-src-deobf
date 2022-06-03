// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;

public class CommandEnchant extends CommandBase
{
    @Override
    public String getCommandName() {
        return "enchant";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIllllIlIllIIIIllI, final ICommandSender llllllllllllllIIllllIlIlIlllIlll, final String[] llllllllllllllIIllllIlIlIlllIllI) throws CommandException {
        if (llllllllllllllIIllllIlIlIlllIllI.length < 2) {
            throw new WrongUsageException("commands.enchant.usage", new Object[0]);
        }
        final EntityLivingBase llllllllllllllIIllllIlIllIIIIIll = CommandBase.getEntity(llllllllllllllIIllllIlIllIIIIllI, llllllllllllllIIllllIlIlIlllIlll, llllllllllllllIIllllIlIlIlllIllI[0], (Class<? extends EntityLivingBase>)EntityLivingBase.class);
        llllllllllllllIIllllIlIlIlllIlll.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 0);
        Enchantment llllllllllllllIIllllIlIllIIIIIIl = null;
        try {
            final Enchantment llllllllllllllIIllllIlIllIIIIIlI = Enchantment.getEnchantmentByID(CommandBase.parseInt(llllllllllllllIIllllIlIlIlllIllI[1], 0));
        }
        catch (NumberInvalidException llllllllllllllIIllllIlIllIIIIIII) {
            llllllllllllllIIllllIlIllIIIIIIl = Enchantment.getEnchantmentByLocation(llllllllllllllIIllllIlIlIlllIllI[1]);
        }
        if (llllllllllllllIIllllIlIllIIIIIIl == null) {
            throw new NumberInvalidException("commands.enchant.notFound", new Object[] { llllllllllllllIIllllIlIlIlllIllI[1] });
        }
        int llllllllllllllIIllllIlIlIlllllll = 1;
        final ItemStack llllllllllllllIIllllIlIlIllllllI = llllllllllllllIIllllIlIllIIIIIll.getHeldItemMainhand();
        if (llllllllllllllIIllllIlIlIllllllI.func_190926_b()) {
            throw new CommandException("commands.enchant.noItem", new Object[0]);
        }
        if (!llllllllllllllIIllllIlIllIIIIIIl.canApply(llllllllllllllIIllllIlIlIllllllI)) {
            throw new CommandException("commands.enchant.cantEnchant", new Object[0]);
        }
        if (llllllllllllllIIllllIlIlIlllIllI.length >= 3) {
            llllllllllllllIIllllIlIlIlllllll = CommandBase.parseInt(llllllllllllllIIllllIlIlIlllIllI[2], llllllllllllllIIllllIlIllIIIIIIl.getMinLevel(), llllllllllllllIIllllIlIllIIIIIIl.getMaxLevel());
        }
        if (llllllllllllllIIllllIlIlIllllllI.hasTagCompound()) {
            final NBTTagList llllllllllllllIIllllIlIlIlllllIl = llllllllllllllIIllllIlIlIllllllI.getEnchantmentTagList();
            for (int llllllllllllllIIllllIlIlIlllllII = 0; llllllllllllllIIllllIlIlIlllllII < llllllllllllllIIllllIlIlIlllllIl.tagCount(); ++llllllllllllllIIllllIlIlIlllllII) {
                final int llllllllllllllIIllllIlIlIllllIll = llllllllllllllIIllllIlIlIlllllIl.getCompoundTagAt(llllllllllllllIIllllIlIlIlllllII).getShort("id");
                if (Enchantment.getEnchantmentByID(llllllllllllllIIllllIlIlIllllIll) != null) {
                    final Enchantment llllllllllllllIIllllIlIlIllllIlI = Enchantment.getEnchantmentByID(llllllllllllllIIllllIlIlIllllIll);
                    if (!llllllllllllllIIllllIlIllIIIIIIl.func_191560_c(llllllllllllllIIllllIlIlIllllIlI)) {
                        throw new CommandException("commands.enchant.cantCombine", new Object[] { llllllllllllllIIllllIlIllIIIIIIl.getTranslatedName(llllllllllllllIIllllIlIlIlllllll), llllllllllllllIIllllIlIlIllllIlI.getTranslatedName(llllllllllllllIIllllIlIlIlllllIl.getCompoundTagAt(llllllllllllllIIllllIlIlIlllllII).getShort("lvl")) });
                    }
                }
            }
        }
        llllllllllllllIIllllIlIlIllllllI.addEnchantment(llllllllllllllIIllllIlIllIIIIIIl, llllllllllllllIIllllIlIlIlllllll);
        CommandBase.notifyCommandListener(llllllllllllllIIllllIlIlIlllIlll, this, "commands.enchant.success", new Object[0]);
        llllllllllllllIIllllIlIlIlllIlll.setCommandStat(CommandResultStats.Type.AFFECTED_ITEMS, 1);
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIllllIlIllIIlIlII) {
        return "commands.enchant.usage";
    }
    
    @Override
    public boolean isUsernameIndex(final String[] llllllllllllllIIllllIlIlIllIIIlI, final int llllllllllllllIIllllIlIlIllIIIIl) {
        return llllllllllllllIIllllIlIlIllIIIIl == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIllllIlIlIllIIllI, final ICommandSender llllllllllllllIIllllIlIlIllIlIIl, final String[] llllllllllllllIIllllIlIlIllIIlIl, @Nullable final BlockPos llllllllllllllIIllllIlIlIllIIlll) {
        if (llllllllllllllIIllllIlIlIllIIlIl.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIllllIlIlIllIIlIl, llllllllllllllIIllllIlIlIllIIllI.getAllUsernames());
        }
        return (llllllllllllllIIllllIlIlIllIIlIl.length == 2) ? CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIIllllIlIlIllIIlIl, Enchantment.REGISTRY.getKeys()) : Collections.emptyList();
    }
}

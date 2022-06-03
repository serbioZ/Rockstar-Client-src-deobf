// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.command;

import java.util.Collections;
import java.util.Collection;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import com.google.common.collect.Lists;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import java.util.List;

public class RecipeCommand extends CommandBase
{
    private List<IRecipe> func_192556_d() {
        return (List<IRecipe>)Lists.newArrayList((Iterable)CraftingManager.field_193380_a);
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllIlIIlIIllIllIlllIIlll, final ICommandSender lllllllllllIlIIlIIllIllIllllIIII, final String[] lllllllllllIlIIlIIllIllIlllIIlIl) throws CommandException {
        if (lllllllllllIlIIlIIllIllIlllIIlIl.length < 2) {
            throw new WrongUsageException("commands.recipe.usage", new Object[0]);
        }
        final boolean lllllllllllIlIIlIIllIllIlllIlllI = "give".equalsIgnoreCase(lllllllllllIlIIlIIllIllIlllIIlIl[0]);
        final boolean lllllllllllIlIIlIIllIllIlllIllIl = "take".equalsIgnoreCase(lllllllllllIlIIlIIllIllIlllIIlIl[0]);
        if (!lllllllllllIlIIlIIllIllIlllIlllI && !lllllllllllIlIIlIIllIllIlllIllIl) {
            throw new WrongUsageException("commands.recipe.usage", new Object[0]);
        }
        for (final EntityPlayerMP lllllllllllIlIIlIIllIllIlllIllII : CommandBase.func_193513_a(lllllllllllIlIIlIIllIllIlllIIlll, lllllllllllIlIIlIIllIllIllllIIII, lllllllllllIlIIlIIllIllIlllIIlIl[1])) {
            if ("*".equals(lllllllllllIlIIlIIllIllIlllIIlIl[2])) {
                if (lllllllllllIlIIlIIllIllIlllIlllI) {
                    lllllllllllIlIIlIIllIllIlllIllII.func_192021_a(this.func_192556_d());
                    CommandBase.notifyCommandListener(lllllllllllIlIIlIIllIllIllllIIII, this, "commands.recipe.give.success.all", lllllllllllIlIIlIIllIllIlllIllII.getName());
                }
                else {
                    lllllllllllIlIIlIIllIllIlllIllII.func_192022_b(this.func_192556_d());
                    CommandBase.notifyCommandListener(lllllllllllIlIIlIIllIllIllllIIII, this, "commands.recipe.take.success.all", lllllllllllIlIIlIIllIllIlllIllII.getName());
                }
            }
            else {
                final IRecipe lllllllllllIlIIlIIllIllIlllIlIll = CraftingManager.func_193373_a(new ResourceLocation(lllllllllllIlIIlIIllIllIlllIIlIl[2]));
                if (lllllllllllIlIIlIIllIllIlllIlIll == null) {
                    throw new CommandException("commands.recipe.unknownrecipe", new Object[] { lllllllllllIlIIlIIllIllIlllIIlIl[2] });
                }
                if (lllllllllllIlIIlIIllIllIlllIlIll.func_192399_d()) {
                    throw new CommandException("commands.recipe.unsupported", new Object[] { lllllllllllIlIIlIIllIllIlllIIlIl[2] });
                }
                final List<IRecipe> lllllllllllIlIIlIIllIllIlllIlIlI = (List<IRecipe>)Lists.newArrayList((Object[])new IRecipe[] { lllllllllllIlIIlIIllIllIlllIlIll });
                if (lllllllllllIlIIlIIllIllIlllIlllI == lllllllllllIlIIlIIllIllIlllIllII.func_192037_E().func_193830_f(lllllllllllIlIIlIIllIllIlllIlIll)) {
                    final String lllllllllllIlIIlIIllIllIlllIlIIl = lllllllllllIlIIlIIllIllIlllIlllI ? "commands.recipe.alreadyHave" : "commands.recipe.dontHave";
                    throw new CommandException(lllllllllllIlIIlIIllIllIlllIlIIl, new Object[] { lllllllllllIlIIlIIllIllIlllIllII.getName(), lllllllllllIlIIlIIllIllIlllIlIll.getRecipeOutput().getDisplayName() });
                }
                if (lllllllllllIlIIlIIllIllIlllIlllI) {
                    lllllllllllIlIIlIIllIllIlllIllII.func_192021_a(lllllllllllIlIIlIIllIllIlllIlIlI);
                    CommandBase.notifyCommandListener(lllllllllllIlIIlIIllIllIllllIIII, this, "commands.recipe.give.success.one", lllllllllllIlIIlIIllIllIlllIllII.getName(), lllllllllllIlIIlIIllIllIlllIlIll.getRecipeOutput().getDisplayName());
                }
                else {
                    lllllllllllIlIIlIIllIllIlllIllII.func_192022_b(lllllllllllIlIIlIIllIllIlllIlIlI);
                    CommandBase.notifyCommandListener(lllllllllllIlIIlIIllIllIllllIIII, this, "commands.recipe.take.success.one", lllllllllllIlIIlIIllIllIlllIlIll.getRecipeOutput().getDisplayName(), lllllllllllIlIIlIIllIllIlllIllII.getName());
                }
            }
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllIlIIlIIllIllIllIlIlIl, final ICommandSender lllllllllllIlIIlIIllIllIllIllIII, final String[] lllllllllllIlIIlIIllIllIllIlIlII, @Nullable final BlockPos lllllllllllIlIIlIIllIllIllIlIllI) {
        if (lllllllllllIlIIlIIllIllIllIlIlII.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIIlIIllIllIllIlIlII, "give", "take");
        }
        if (lllllllllllIlIIlIIllIllIllIlIlII.length == 2) {
            return CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIIlIIllIllIllIlIlII, lllllllllllIlIIlIIllIllIllIlIlIl.getAllUsernames());
        }
        return (lllllllllllIlIIlIIllIllIllIlIlII.length == 3) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllIlIIlIIllIllIllIlIlII, CraftingManager.field_193380_a.getKeys()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllIlIIlIIllIllIlllllllI) {
        return "commands.recipe.usage";
    }
    
    @Override
    public String getCommandName() {
        return "recipe";
    }
}

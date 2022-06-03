// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import java.util.List;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import net.minecraft.entity.player.EntityPlayer;
import java.util.UUID;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.Agent;
import java.util.Iterator;
import com.google.common.collect.Iterators;
import net.minecraft.util.StringUtils;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import com.mojang.authlib.ProfileLookupCallback;
import java.util.Collection;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;
import java.io.File;

public class PreYggdrasilConverter
{
    private static final /* synthetic */ Logger LOGGER;
    
    private static void lookupNames(final MinecraftServer lllllllllllIIIlIIIIllIIIlllIllIl, final Collection<String> lllllllllllIIIlIIIIllIIIlllIllII, final ProfileLookupCallback lllllllllllIIIlIIIIllIIIllllIIlI) {
        final String[] lllllllllllIIIlIIIIllIIIllllIIIl = (String[])Iterators.toArray((Iterator)Iterators.filter((Iterator)lllllllllllIIIlIIIIllIIIlllIllII.iterator(), (Predicate)new Predicate<String>() {
            public boolean apply(@Nullable final String lllllllllllIlllllIIIlllIIllIIIIl) {
                return !StringUtils.isNullOrEmpty(lllllllllllIlllllIIIlllIIllIIIIl);
            }
        }), (Class)String.class);
        if (lllllllllllIIIlIIIIllIIIlllIllIl.isServerInOnlineMode()) {
            lllllllllllIIIlIIIIllIIIlllIllIl.getGameProfileRepository().findProfilesByNames(lllllllllllIIIlIIIIllIIIllllIIIl, Agent.MINECRAFT, lllllllllllIIIlIIIIllIIIllllIIlI);
        }
        else {
            final float lllllllllllIIIlIIIIllIIIlllIIllI;
            final float lllllllllllIIIlIIIIllIIIlllIIlll = ((String[])(Object)(lllllllllllIIIlIIIIllIIIlllIIllI = (float)(Object)lllllllllllIIIlIIIIllIIIllllIIIl)).length;
            for (double lllllllllllIIIlIIIIllIIIlllIlIII = 0; lllllllllllIIIlIIIIllIIIlllIlIII < lllllllllllIIIlIIIIllIIIlllIIlll; ++lllllllllllIIIlIIIIllIIIlllIlIII) {
                final String lllllllllllIIIlIIIIllIIIllllIIII = lllllllllllIIIlIIIIllIIIlllIIllI[lllllllllllIIIlIIIIllIIIlllIlIII];
                final UUID lllllllllllIIIlIIIIllIIIlllIllll = EntityPlayer.getUUID(new GameProfile((UUID)null, lllllllllllIIIlIIIIllIIIllllIIII));
                final GameProfile lllllllllllIIIlIIIIllIIIlllIlllI = new GameProfile(lllllllllllIIIlIIIIllIIIlllIllll, lllllllllllIIIlIIIIllIIIllllIIII);
                lllllllllllIIIlIIIIllIIIllllIIlI.onProfileLookupSucceeded(lllllllllllIIIlIIIIllIIIlllIlllI);
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        OLD_IPBAN_FILE = new File("banned-ips.txt");
        OLD_PLAYERBAN_FILE = new File("banned-players.txt");
        OLD_OPS_FILE = new File("ops.txt");
        OLD_WHITELIST_FILE = new File("white-list.txt");
    }
    
    public static String convertMobOwnerIfNeeded(final MinecraftServer lllllllllllIIIlIIIIllIIIllIllIIl, final String lllllllllllIIIlIIIIllIIIllIllIII) {
        if (StringUtils.isNullOrEmpty(lllllllllllIIIlIIIIllIIIllIllIII) || lllllllllllIIIlIIIIllIIIllIllIII.length() > 16) {
            return lllllllllllIIIlIIIIllIIIllIllIII;
        }
        final GameProfile lllllllllllIIIlIIIIllIIIllIlllII = lllllllllllIIIlIIIIllIIIllIllIIl.getPlayerProfileCache().getGameProfileForUsername(lllllllllllIIIlIIIIllIIIllIllIII);
        if (lllllllllllIIIlIIIIllIIIllIlllII != null && lllllllllllIIIlIIIIllIIIllIlllII.getId() != null) {
            return lllllllllllIIIlIIIIllIIIllIlllII.getId().toString();
        }
        if (!lllllllllllIIIlIIIIllIIIllIllIIl.isSinglePlayer() && lllllllllllIIIlIIIIllIIIllIllIIl.isServerInOnlineMode()) {
            final List<GameProfile> lllllllllllIIIlIIIIllIIIllIllIll = (List<GameProfile>)Lists.newArrayList();
            final ProfileLookupCallback lllllllllllIIIlIIIIllIIIllIllIlI = (ProfileLookupCallback)new ProfileLookupCallback() {
                public void onProfileLookupSucceeded(final GameProfile lllllllllllllllllllllllIIIIlllIl) {
                    lllllllllllIIIlIIIIllIIIllIllIIl.getPlayerProfileCache().addEntry(lllllllllllllllllllllllIIIIlllIl);
                    lllllllllllIIIlIIIIllIIIllIllIll.add(lllllllllllllllllllllllIIIIlllIl);
                }
                
                public void onProfileLookupFailed(final GameProfile lllllllllllllllllllllllIIIIlIlll, final Exception lllllllllllllllllllllllIIIIlIllI) {
                    PreYggdrasilConverter.LOGGER.warn("Could not lookup user whitelist entry for {}", (Object)lllllllllllllllllllllllIIIIlIlll.getName(), (Object)lllllllllllllllllllllllIIIIlIllI);
                }
            };
            lookupNames(lllllllllllIIIlIIIIllIIIllIllIIl, Lists.newArrayList((Object[])new String[] { lllllllllllIIIlIIIIllIIIllIllIII }), lllllllllllIIIlIIIIllIIIllIllIlI);
            return (!lllllllllllIIIlIIIIllIIIllIllIll.isEmpty() && lllllllllllIIIlIIIIllIIIllIllIll.get(0).getId() != null) ? lllllllllllIIIlIIIIllIIIllIllIll.get(0).getId().toString() : "";
        }
        return EntityPlayer.getUUID(new GameProfile((UUID)null, lllllllllllIIIlIIIIllIIIllIllIII)).toString();
    }
}

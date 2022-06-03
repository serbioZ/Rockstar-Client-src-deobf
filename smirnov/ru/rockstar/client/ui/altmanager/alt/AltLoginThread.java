// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager.alt;

import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.net.Proxy;
import ru.rockstar.client.ui.altmanager.althening.api.AltService;
import ru.rockstar.client.ui.altmanager.GuiAltManager;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.Session;
import net.minecraft.client.Minecraft;

public class AltLoginThread extends Thread
{
    private final /* synthetic */ Alt alt;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ String status;
    
    public void setStatus(final String llllllllllllIIIlllIIllIlIlIlIllI) {
        this.status = llllllllllllIIIlllIIllIlIlIlIllI;
    }
    
    @Override
    public void run() {
        if (this.alt.getPassword().equals("")) {
            this.mc.session = new Session(this.alt.getUsername(), "", "", "mojang");
            this.status = TextFormatting.GREEN + "Logged in - " + ChatFormatting.RED + this.alt.getUsername() + ChatFormatting.BOLD + " (non license)";
        }
        else {
            this.status = "Logging in...";
            final Session llllllllllllIIIlllIIllIlIlIlIIlI = this.createSession(this.alt.getUsername(), this.alt.getPassword());
            if (llllllllllllIIIlllIIllIlIlIlIIlI == null) {
                this.status = "Connect failed!";
                if (this.alt.getStatus().equals(Alt.Status.Unchecked)) {
                    this.alt.setStatus(Alt.Status.NotWorking);
                }
            }
            else {
                AltManager.lastAlt = new Alt(this.alt.getUsername(), this.alt.getPassword());
                this.status = TextFormatting.GREEN + "Logged in - " + ChatFormatting.RED + llllllllllllIIIlllIIllIlIlIlIIlI.getUsername() + ChatFormatting.BOLD + " (license)";
                this.alt.setMask(llllllllllllIIIlllIIllIlIlIlIIlI.getUsername());
                this.mc.session = llllllllllllIIIlllIIllIlIlIlIIlI;
            }
        }
    }
    
    private Session createSession(final String llllllllllllIIIlllIIllIlIllIlIIl, final String llllllllllllIIIlllIIllIlIllIlIII) {
        try {
            GuiAltManager.altService.switchService(AltService.EnumAltService.MOJANG);
            final YggdrasilAuthenticationService llllllllllllIIIlllIIllIlIllIIlll = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
            final YggdrasilUserAuthentication llllllllllllIIIlllIIllIlIllIIllI = (YggdrasilUserAuthentication)llllllllllllIIIlllIIllIlIllIIlll.createUserAuthentication(Agent.MINECRAFT);
            llllllllllllIIIlllIIllIlIllIIllI.setUsername(llllllllllllIIIlllIIllIlIllIlIIl);
            llllllllllllIIIlllIIllIlIllIIllI.setPassword(llllllllllllIIIlllIIllIlIllIlIII);
            try {
                llllllllllllIIIlllIIllIlIllIIllI.logIn();
                return new Session(llllllllllllIIIlllIIllIlIllIIllI.getSelectedProfile().getName(), llllllllllllIIIlllIIllIlIllIIllI.getSelectedProfile().getId().toString(), llllllllllllIIIlllIIllIlIllIIllI.getAuthenticatedToken(), "mojang");
            }
            catch (AuthenticationException llllllllllllIIIlllIIllIlIllIIlIl) {
                return null;
            }
        }
        catch (Exception llllllllllllIIIlllIIllIlIllIIlII) {
            return null;
        }
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public AltLoginThread(final Alt llllllllllllIIIlllIIllIlIlllIIII) {
        this.mc = Minecraft.getMinecraft();
        this.alt = llllllllllllIIIlllIIllIlIlllIIII;
        this.status = "\u0420\u2019\u0412§7Waiting...";
    }
}

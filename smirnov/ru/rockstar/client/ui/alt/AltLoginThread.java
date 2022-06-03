// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.alt;

import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.net.Proxy;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.Session;
import net.minecraft.client.Minecraft;

public final class AltLoginThread extends Thread
{
    private /* synthetic */ String status;
    private final /* synthetic */ String password;
    private final /* synthetic */ String username;
    private final /* synthetic */ Minecraft mc;
    
    public String getStatus() {
        return this.status;
    }
    
    @Override
    public void run() {
        if (this.password.equals("")) {
            this.mc.session = new Session(this.username, "", "", "mojang");
            final Session llllllllllllIlIlIllIllIlIlIIIIll = this.createSession(this.username, this.password);
            this.status = TextFormatting.WHITE + "ur nickname - " + ChatFormatting.GRAY + this.username;
            return;
        }
        this.status = TextFormatting.YELLOW + "Logging in...";
        final Session llllllllllllIlIlIllIllIlIlIIIIlI = this.createSession(this.username, this.password);
        if (llllllllllllIlIlIllIllIlIlIIIIlI == null) {
            this.status = TextFormatting.RED + "Login failed!";
        }
        else {
            this.status = TextFormatting.WHITE + "ur nickname - " + ChatFormatting.GRAY + llllllllllllIlIlIllIllIlIlIIIIlI.getUsername();
            this.mc.session = llllllllllllIlIlIllIllIlIlIIIIlI;
        }
    }
    
    public AltLoginThread(final String llllllllllllIlIlIllIllIlIlIllIll, final String llllllllllllIlIlIllIllIlIlIlllIl) {
        super("Alt Login Thread");
        this.mc = Minecraft.getMinecraft();
        this.username = llllllllllllIlIlIllIllIlIlIllIll;
        this.password = llllllllllllIlIlIllIllIlIlIlllIl;
        this.status = TextFormatting.GRAY + "Waiting...";
    }
    
    private Session createSession(final String llllllllllllIlIlIllIllIlIlIlIIll, final String llllllllllllIlIlIllIllIlIlIlIIlI) {
        final YggdrasilAuthenticationService llllllllllllIlIlIllIllIlIlIlIIIl = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        final YggdrasilUserAuthentication llllllllllllIlIlIllIllIlIlIlIIII = (YggdrasilUserAuthentication)llllllllllllIlIlIllIllIlIlIlIIIl.createUserAuthentication(Agent.MINECRAFT);
        llllllllllllIlIlIllIllIlIlIlIIII.setUsername(llllllllllllIlIlIllIllIlIlIlIIll);
        llllllllllllIlIlIllIllIlIlIlIIII.setPassword(llllllllllllIlIlIllIllIlIlIlIIlI);
        try {
            llllllllllllIlIlIllIllIlIlIlIIII.logIn();
            return new Session(llllllllllllIlIlIllIllIlIlIlIIII.getSelectedProfile().getName(), llllllllllllIlIlIllIllIlIlIlIIII.getSelectedProfile().getId().toString(), llllllllllllIlIlIllIllIlIlIlIIII.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException llllllllllllIlIlIllIllIlIlIIllll) {
            llllllllllllIlIlIllIllIlIlIIllll.printStackTrace();
            return null;
        }
    }
    
    public void setStatus(final String llllllllllllIlIlIllIllIlIIllllII) {
        this.status = llllllllllllIlIlIllIllIlIIllllII;
    }
}

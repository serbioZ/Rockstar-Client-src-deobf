// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager.alt;

import net.minecraft.util.text.TextFormatting;

public class Alt
{
    private final /* synthetic */ String username;
    private /* synthetic */ String password;
    private /* synthetic */ Status status;
    private /* synthetic */ String mask;
    
    public String getMask() {
        return this.mask;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setStatus(final Status lllllllllllIlIlIlIlIlIlIIIlllIII) {
        this.status = lllllllllllIlIlIlIlIlIlIIIlllIII;
    }
    
    public void setMask(final String lllllllllllIlIlIlIlIlIlIIIlIllll) {
        this.mask = lllllllllllIlIlIlIlIlIlIIIlIllll;
    }
    
    public Alt(final String lllllllllllIlIlIlIlIlIlIIlIIlIIl, final String lllllllllllIlIlIlIlIlIlIIlIIIIll, final String lllllllllllIlIlIlIlIlIlIIlIIIIlI, final Status lllllllllllIlIlIlIlIlIlIIlIIIllI) {
        this.username = lllllllllllIlIlIlIlIlIlIIlIIlIIl;
        this.password = lllllllllllIlIlIlIlIlIlIIlIIIIll;
        this.mask = lllllllllllIlIlIlIlIlIlIIlIIIIlI;
        this.status = lllllllllllIlIlIlIlIlIlIIlIIIllI;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public Alt(final String lllllllllllIlIlIlIlIlIlIIlIlllIl, final String lllllllllllIlIlIlIlIlIlIIlIlllII) {
        this(lllllllllllIlIlIlIlIlIlIIlIlllIl, lllllllllllIlIlIlIlIlIlIIlIlllII, Status.Unchecked);
    }
    
    public void setPassword(final String lllllllllllIlIlIlIlIlIlIIIlIlIII) {
        this.password = lllllllllllIlIlIlIlIlIlIIIlIlIII;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public Alt(final String lllllllllllIlIlIlIlIlIlIIlIlIIlI, final String lllllllllllIlIlIlIlIlIlIIlIlIIIl, final Status lllllllllllIlIlIlIlIlIlIIlIlIIII) {
        this(lllllllllllIlIlIlIlIlIlIIlIlIIlI, lllllllllllIlIlIlIlIlIlIIlIlIIIl, "", lllllllllllIlIlIlIlIlIlIIlIlIIII);
    }
    
    public enum Status
    {
        Working("Working", 0, TextFormatting.GREEN + "Working"), 
        Banned("Banned", 1, TextFormatting.RED + "Banned"), 
        Unchecked("Unchecked", 2, TextFormatting.YELLOW + "Unchecked"), 
        NotWorking("NotWorking", 3, TextFormatting.RED + "Not Working");
        
        private final /* synthetic */ String formatted;
        
        public String toFormatted() {
            return this.formatted;
        }
        
        private Status(final String lllllllllllIlIIIlIllIlIIIllIlIIl, final int lllllllllllIlIIIlIllIlIIIllIlIII, final String lllllllllllIlIIIlIllIlIIIllIlIll) {
            this.formatted = lllllllllllIlIIIlIllIlIIIllIlIll;
        }
    }
}

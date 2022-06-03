// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import java.text.ParseException;
import com.google.gson.JsonObject;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class UserListEntryBan<T> extends UserListEntry<T>
{
    public static final /* synthetic */ SimpleDateFormat DATE_FORMAT;
    protected final /* synthetic */ Date banEndDate;
    protected final /* synthetic */ Date banStartDate;
    protected final /* synthetic */ String reason;
    protected final /* synthetic */ String bannedBy;
    
    public Date getBanEndDate() {
        return this.banEndDate;
    }
    
    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    }
    
    public UserListEntryBan(final T lllllllllllllIlllIllIIlIlIllllII, final Date lllllllllllllIlllIllIIlIlIlllIll, final String lllllllllllllIlllIllIIlIlIlllIlI, final Date lllllllllllllIlllIllIIlIlIllllll, final String lllllllllllllIlllIllIIlIlIlllllI) {
        super(lllllllllllllIlllIllIIlIlIllllII);
        this.banStartDate = ((lllllllllllllIlllIllIIlIlIlllIll == null) ? new Date() : lllllllllllllIlllIllIIlIlIlllIll);
        this.bannedBy = ((lllllllllllllIlllIllIIlIlIlllIlI == null) ? "(Unknown)" : lllllllllllllIlllIllIIlIlIlllIlI);
        this.banEndDate = lllllllllllllIlllIllIIlIlIllllll;
        this.reason = ((lllllllllllllIlllIllIIlIlIlllllI == null) ? "Banned by an operator." : lllllllllllllIlllIllIIlIlIlllllI);
    }
    
    @Override
    boolean hasBanExpired() {
        return this.banEndDate != null && this.banEndDate.before(new Date());
    }
    
    public String getBanReason() {
        return this.reason;
    }
    
    @Override
    protected void onSerialization(final JsonObject lllllllllllllIlllIllIIlIlIIlIlII) {
        lllllllllllllIlllIllIIlIlIIlIlII.addProperty("created", UserListEntryBan.DATE_FORMAT.format(this.banStartDate));
        lllllllllllllIlllIllIIlIlIIlIlII.addProperty("source", this.bannedBy);
        lllllllllllllIlllIllIIlIlIIlIlII.addProperty("expires", (this.banEndDate == null) ? "forever" : UserListEntryBan.DATE_FORMAT.format(this.banEndDate));
        lllllllllllllIlllIllIIlIlIIlIlII.addProperty("reason", this.reason);
    }
    
    protected UserListEntryBan(final T lllllllllllllIlllIllIIlIlIlIIlll, final JsonObject lllllllllllllIlllIllIIlIlIlIIllI) {
        super(lllllllllllllIlllIllIIlIlIlIIlll, lllllllllllllIlllIllIIlIlIlIIllI);
        Date lllllllllllllIlllIllIIlIlIlIllIl = null;
        try {
            final Date lllllllllllllIlllIllIIlIlIlIlllI = lllllllllllllIlllIllIIlIlIlIIllI.has("created") ? UserListEntryBan.DATE_FORMAT.parse(lllllllllllllIlllIllIIlIlIlIIllI.get("created").getAsString()) : new Date();
        }
        catch (ParseException lllllllllllllIlllIllIIlIlIlIllII) {
            lllllllllllllIlllIllIIlIlIlIllIl = new Date();
        }
        this.banStartDate = lllllllllllllIlllIllIIlIlIlIllIl;
        this.bannedBy = (lllllllllllllIlllIllIIlIlIlIIllI.has("source") ? lllllllllllllIlllIllIIlIlIlIIllI.get("source").getAsString() : "(Unknown)");
        Date lllllllllllllIlllIllIIlIlIlIlIlI = null;
        try {
            final Date lllllllllllllIlllIllIIlIlIlIlIll = lllllllllllllIlllIllIIlIlIlIIllI.has("expires") ? UserListEntryBan.DATE_FORMAT.parse(lllllllllllllIlllIllIIlIlIlIIllI.get("expires").getAsString()) : null;
        }
        catch (ParseException lllllllllllllIlllIllIIlIlIlIlIIl) {
            lllllllllllllIlllIllIIlIlIlIlIlI = null;
        }
        this.banEndDate = lllllllllllllIlllIllIIlIlIlIlIlI;
        this.reason = (lllllllllllllIlllIllIIlIlIlIIllI.has("reason") ? lllllllllllllIlllIllIIlIlIlIIllI.get("reason").getAsString() : "Banned by an operator.");
    }
}

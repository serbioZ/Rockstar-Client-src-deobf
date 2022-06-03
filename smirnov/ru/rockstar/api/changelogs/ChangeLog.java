// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.changelogs;

public class ChangeLog
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$api$changelogs$ChangeType;
    protected /* synthetic */ String changeName;
    protected /* synthetic */ ChangeType type;
    
    public ChangeType getType() {
        return this.type;
    }
    
    public ChangeLog(final String lllllllllllllIlllIlIIIlIIlIllIIl, final ChangeType lllllllllllllIlllIlIIIlIIlIlIlIl) {
        this.changeName = lllllllllllllIlllIlIIIlIIlIllIIl;
        this.type = lllllllllllllIlllIlIIIlIIlIlIlIl;
        switch ($SWITCH_TABLE$ru$rockstar$api$changelogs$ChangeType()[lllllllllllllIlllIlIIIlIIlIlIlIl.ordinal()]) {
            case 9: {
                this.changeName = "    §7[§6!§7] New §f" + this.changeName;
                break;
            }
            case 1: {
                this.changeName = "    §7[§a+§7] Added §f" + this.changeName;
                break;
            }
            case 4: {
                this.changeName = "    §7[§9*§7] Recoded §f" + this.changeName;
                break;
            }
            case 3: {
                this.changeName = "    §7[§d/§7] Improved §f" + this.changeName;
                break;
            }
            case 2: {
                this.changeName = "    §7[§c-§7] Deleted §f" + this.changeName;
                break;
            }
            case 5: {
                this.changeName = "    §7[§b/§7] Fixed §f" + this.changeName;
                break;
            }
            case 7: {
                this.changeName = "    §7[§9->§7] Moved §f" + this.changeName;
                break;
            }
            case 8: {
                this.changeName = "    §7[§9!§7] Renamed §f" + this.changeName;
                break;
            }
            case 6: {
                this.changeName = " " + this.changeName;
                break;
            }
        }
    }
    
    public String getLogName() {
        return this.changeName;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$ru$rockstar$api$changelogs$ChangeType() {
        final int[] $switch_TABLE$ru$rockstar$api$changelogs$ChangeType = ChangeLog.$SWITCH_TABLE$ru$rockstar$api$changelogs$ChangeType;
        if ($switch_TABLE$ru$rockstar$api$changelogs$ChangeType != null) {
            return $switch_TABLE$ru$rockstar$api$changelogs$ChangeType;
        }
        final float lllllllllllllIlllIlIIIlIIlIIllIl = (Object)new int[ChangeType.values().length];
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.ADD.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.DELETE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.FIXED.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.IMPROVED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.MOVED.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.NEW.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.NONE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.RECODE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllIlllIlIIIlIIlIIllIl[ChangeType.RENAMED.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        return ChangeLog.$SWITCH_TABLE$ru$rockstar$api$changelogs$ChangeType = (int[])(Object)lllllllllllllIlllIlIIIlIIlIIllIl;
    }
}

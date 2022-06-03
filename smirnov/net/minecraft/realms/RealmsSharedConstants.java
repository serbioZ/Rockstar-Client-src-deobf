// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.util.ChatAllowedCharacters;

public class RealmsSharedConstants
{
    public static /* synthetic */ int NETWORK_PROTOCOL_VERSION;
    public static /* synthetic */ int TICKS_PER_SECOND;
    public static /* synthetic */ char[] ILLEGAL_FILE_CHARACTERS;
    public static /* synthetic */ String VERSION_STRING;
    
    static {
        RealmsSharedConstants.NETWORK_PROTOCOL_VERSION = 340;
        RealmsSharedConstants.TICKS_PER_SECOND = 20;
        RealmsSharedConstants.VERSION_STRING = "1.12.2";
        RealmsSharedConstants.ILLEGAL_FILE_CHARACTERS = ChatAllowedCharacters.ILLEGAL_FILE_CHARACTERS;
    }
}

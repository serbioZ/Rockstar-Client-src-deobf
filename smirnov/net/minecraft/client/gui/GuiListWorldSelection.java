// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class GuiListWorldSelection extends GuiListExtended
{
    private final /* synthetic */ List<GuiListWorldSelectionEntry> entries;
    private final /* synthetic */ GuiWorldSelection worldSelectionObj;
    private /* synthetic */ int selectedIdx;
    
    public GuiListWorldSelection(final GuiWorldSelection lllllllllllIllIlIIIIIIllIIlIllII, final Minecraft lllllllllllIllIlIIIIIIllIIlIIIll, final int lllllllllllIllIlIIIIIIllIIlIlIlI, final int lllllllllllIllIlIIIIIIllIIlIIIIl, final int lllllllllllIllIlIIIIIIllIIlIIIII, final int lllllllllllIllIlIIIIIIllIIIlllll, final int lllllllllllIllIlIIIIIIllIIlIIllI) {
        super(lllllllllllIllIlIIIIIIllIIlIIIll, lllllllllllIllIlIIIIIIllIIlIlIlI, lllllllllllIllIlIIIIIIllIIlIIIIl, lllllllllllIllIlIIIIIIllIIlIIIII, lllllllllllIllIlIIIIIIllIIIlllll, lllllllllllIllIlIIIIIIllIIlIIllI);
        this.entries = (List<GuiListWorldSelectionEntry>)Lists.newArrayList();
        this.selectedIdx = -1;
        this.worldSelectionObj = lllllllllllIllIlIIIIIIllIIlIllII;
        this.refreshList();
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 20;
    }
    
    public GuiWorldSelection getGuiWorldSelection() {
        return this.worldSelectionObj;
    }
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 50;
    }
    
    public void refreshList() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/GuiListWorldSelection.mc:Lnet/minecraft/client/Minecraft;
        //     4: invokevirtual   net/minecraft/client/Minecraft.getSaveLoader:()Lnet/minecraft/world/storage/ISaveFormat;
        //     7: astore_1        /* lllllllllllIllIlIIIIIIllIIIlIIIl */
        //     8: aload_1         /* lllllllllllIllIlIIIIIIllIIIlIlll */
        //     9: invokeinterface net/minecraft/world/storage/ISaveFormat.getSaveList:()Ljava/util/List;
        //    14: astore_2        /* lllllllllllIllIlIIIIIIllIIIlIllI */
        //    15: goto            58
        //    18: astore_3        /* lllllllllllIllIlIIIIIIllIIIIllll */
        //    19: getstatic       net/minecraft/client/gui/GuiListWorldSelection.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    22: ldc             "Couldn't load level list"
        //    24: aload_3         /* lllllllllllIllIlIIIIIIllIIIlIlII */
        //    25: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    30: aload_0         /* lllllllllllIllIlIIIIIIllIIIllIII */
        //    31: getfield        net/minecraft/client/gui/GuiListWorldSelection.mc:Lnet/minecraft/client/Minecraft;
        //    34: new             Lnet/minecraft/client/gui/GuiErrorScreen;
        //    37: dup            
        //    38: ldc             "selectWorld.unable_to_load"
        //    40: iconst_0       
        //    41: anewarray       Ljava/lang/Object;
        //    44: invokestatic    net/minecraft/client/resources/I18n.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    47: aload_3         /* lllllllllllIllIlIIIIIIllIIIlIlII */
        //    48: invokevirtual   net/minecraft/client/AnvilConverterException.getMessage:()Ljava/lang/String;
        //    51: invokespecial   net/minecraft/client/gui/GuiErrorScreen.<init>:(Ljava/lang/String;Ljava/lang/String;)V
        //    54: invokevirtual   net/minecraft/client/Minecraft.displayGuiScreen:(Lnet/minecraft/client/gui/GuiScreen;)V
        //    57: return         
        //    58: aload_2         /* lllllllllllIllIlIIIIIIllIIIlIlIl */
        //    59: invokestatic    java/util/Collections.sort:(Ljava/util/List;)V
        //    62: aload_2         /* lllllllllllIllIlIIIIIIllIIIlIlIl */
        //    63: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    68: astore          lllllllllllIllIlIIIIIIllIIIIlllI
        //    70: goto            110
        //    73: aload           lllllllllllIllIlIIIIIIllIIIIlllI
        //    75: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    80: checkcast       Lnet/minecraft/world/storage/WorldSummary;
        //    83: astore_3        /* lllllllllllIllIlIIIIIIllIIIIllll */
        //    84: aload_0         /* lllllllllllIllIlIIIIIIllIIIllIII */
        //    85: getfield        net/minecraft/client/gui/GuiListWorldSelection.entries:Ljava/util/List;
        //    88: new             Lnet/minecraft/client/gui/GuiListWorldSelectionEntry;
        //    91: dup            
        //    92: aload_0         /* lllllllllllIllIlIIIIIIllIIIllIII */
        //    93: aload_3         /* lllllllllllIllIlIIIIIIllIIIlIIll */
        //    94: aload_0         /* lllllllllllIllIlIIIIIIllIIIllIII */
        //    95: getfield        net/minecraft/client/gui/GuiListWorldSelection.mc:Lnet/minecraft/client/Minecraft;
        //    98: invokevirtual   net/minecraft/client/Minecraft.getSaveLoader:()Lnet/minecraft/world/storage/ISaveFormat;
        //   101: invokespecial   net/minecraft/client/gui/GuiListWorldSelectionEntry.<init>:(Lnet/minecraft/client/gui/GuiListWorldSelection;Lnet/minecraft/world/storage/WorldSummary;Lnet/minecraft/world/storage/ISaveFormat;)V
        //   104: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   109: pop            
        //   110: aload           lllllllllllIllIlIIIIIIllIIIIlllI
        //   112: invokeinterface java/util/Iterator.hasNext:()Z
        //   117: ifne            73
        //   120: return         
        //    StackMapTable: 00 04 FF 00 12 00 02 07 00 02 07 00 62 00 01 07 00 57 FC 00 27 07 00 8F FD 00 0E 00 07 00 95 24
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                          
        //  -----  -----  -----  -----  ----------------------------------------------
        //  8      15     18     58     Lnet/minecraft/client/AnvilConverterException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void selectWorld(final int lllllllllllIllIlIIIIIIlIlllllIIl) {
        this.selectedIdx = lllllllllllIllIlIIIIIIlIlllllIIl;
        this.worldSelectionObj.selectWorld(this.getSelectedWorld());
    }
    
    @Override
    protected boolean isSelected(final int lllllllllllIllIlIIIIIIlIllllIlIl) {
        return lllllllllllIllIlIIIIIIlIllllIlIl == this.selectedIdx;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Nullable
    public GuiListWorldSelectionEntry getSelectedWorld() {
        return (this.selectedIdx >= 0 && this.selectedIdx < this.getSize()) ? this.getListEntry(this.selectedIdx) : null;
    }
    
    @Override
    public GuiListWorldSelectionEntry getListEntry(final int lllllllllllIllIlIIIIIIllIIIIlIlI) {
        return this.entries.get(lllllllllllIllIlIIIIIIllIIIIlIlI);
    }
    
    @Override
    protected int getSize() {
        return this.entries.size();
    }
}

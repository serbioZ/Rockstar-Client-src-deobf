// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.inventory;

import net.minecraft.util.math.BlockPos;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.input.Keyboard;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import com.google.common.collect.Lists;
import net.minecraft.util.ChatAllowedCharacters;
import java.io.IOException;
import net.minecraft.client.resources.I18n;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.Mirror;
import java.text.DecimalFormat;
import net.minecraft.util.Rotation;
import java.util.List;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public class GuiEditStructure extends GuiScreen
{
    private /* synthetic */ GuiTextField sizeZEdit;
    private /* synthetic */ GuiButton mirrorButton;
    private /* synthetic */ GuiButton loadButton;
    private /* synthetic */ TileEntityStructure.Mode mode;
    private final /* synthetic */ List<GuiTextField> tabOrder;
    private /* synthetic */ GuiButton rotateNinetyDegreesButton;
    private /* synthetic */ GuiButton showEntitiesButton;
    private /* synthetic */ boolean showBoundingBox;
    private /* synthetic */ GuiButton detectSizeButton;
    private /* synthetic */ GuiTextField posXEdit;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
    private /* synthetic */ GuiTextField integrityEdit;
    private /* synthetic */ GuiButton showBoundingBoxButton;
    private /* synthetic */ Rotation rotation;
    private /* synthetic */ GuiButton saveButton;
    private /* synthetic */ GuiButton cancelButton;
    private /* synthetic */ GuiButton rotateZeroDegreesButton;
    private /* synthetic */ GuiTextField dataEdit;
    public static final /* synthetic */ int[] LEGAL_KEY_CODES;
    private /* synthetic */ GuiTextField nameEdit;
    private /* synthetic */ GuiTextField sizeXEdit;
    private /* synthetic */ GuiTextField posYEdit;
    private /* synthetic */ GuiButton rotate270DegressButton;
    private /* synthetic */ GuiButton showAirButton;
    private /* synthetic */ boolean showAir;
    private /* synthetic */ boolean ignoreEntities;
    private /* synthetic */ GuiButton doneButton;
    private final /* synthetic */ DecimalFormat decimalFormat;
    private /* synthetic */ Mirror mirror;
    private /* synthetic */ GuiButton rotate180DegreesButton;
    private final /* synthetic */ TileEntityStructure tileStructure;
    private /* synthetic */ GuiButton modeButton;
    private /* synthetic */ GuiTextField sizeYEdit;
    private /* synthetic */ GuiTextField posZEdit;
    private /* synthetic */ GuiTextField seedEdit;
    private static final /* synthetic */ Logger LOGGER;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final float lllllllllllllllllIlllllIlIIIIlll = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllllllIlllllIlIIIIlll[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlllllIlIIIIlll[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlllllIlIIIIlll[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllllllIlllllIlIIIIlll;
    }
    
    private void updateMode() {
        this.nameEdit.setFocused(false);
        this.posXEdit.setFocused(false);
        this.posYEdit.setFocused(false);
        this.posZEdit.setFocused(false);
        this.sizeXEdit.setFocused(false);
        this.sizeYEdit.setFocused(false);
        this.sizeZEdit.setFocused(false);
        this.integrityEdit.setFocused(false);
        this.seedEdit.setFocused(false);
        this.dataEdit.setFocused(false);
        this.nameEdit.setVisible(false);
        this.nameEdit.setFocused(false);
        this.posXEdit.setVisible(false);
        this.posYEdit.setVisible(false);
        this.posZEdit.setVisible(false);
        this.sizeXEdit.setVisible(false);
        this.sizeYEdit.setVisible(false);
        this.sizeZEdit.setVisible(false);
        this.integrityEdit.setVisible(false);
        this.seedEdit.setVisible(false);
        this.dataEdit.setVisible(false);
        this.saveButton.visible = false;
        this.loadButton.visible = false;
        this.detectSizeButton.visible = false;
        this.showEntitiesButton.visible = false;
        this.mirrorButton.visible = false;
        this.rotateZeroDegreesButton.visible = false;
        this.rotateNinetyDegreesButton.visible = false;
        this.rotate180DegreesButton.visible = false;
        this.rotate270DegressButton.visible = false;
        this.showAirButton.visible = false;
        this.showBoundingBoxButton.visible = false;
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode()[this.tileStructure.getMode().ordinal()]) {
            case 1: {
                this.nameEdit.setVisible(true);
                this.nameEdit.setFocused(true);
                this.posXEdit.setVisible(true);
                this.posYEdit.setVisible(true);
                this.posZEdit.setVisible(true);
                this.sizeXEdit.setVisible(true);
                this.sizeYEdit.setVisible(true);
                this.sizeZEdit.setVisible(true);
                this.saveButton.visible = true;
                this.detectSizeButton.visible = true;
                this.showEntitiesButton.visible = true;
                this.showAirButton.visible = true;
                break;
            }
            case 2: {
                this.nameEdit.setVisible(true);
                this.nameEdit.setFocused(true);
                this.posXEdit.setVisible(true);
                this.posYEdit.setVisible(true);
                this.posZEdit.setVisible(true);
                this.integrityEdit.setVisible(true);
                this.seedEdit.setVisible(true);
                this.loadButton.visible = true;
                this.showEntitiesButton.visible = true;
                this.mirrorButton.visible = true;
                this.rotateZeroDegreesButton.visible = true;
                this.rotateNinetyDegreesButton.visible = true;
                this.rotate180DegreesButton.visible = true;
                this.rotate270DegressButton.visible = true;
                this.showBoundingBoxButton.visible = true;
                this.updateDirectionButtons();
                break;
            }
            case 3: {
                this.nameEdit.setVisible(true);
                this.nameEdit.setFocused(true);
                break;
            }
            case 4: {
                this.dataEdit.setVisible(true);
                this.dataEdit.setFocused(true);
                break;
            }
        }
        this.modeButton.displayString = I18n.format("structure_block.mode." + this.tileStructure.getMode().getName(), new Object[0]);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllllIlllllIllIIlllI, final int lllllllllllllllllIlllllIllIIllIl) throws IOException {
        if (this.nameEdit.getVisible() && isValidCharacterForName(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl)) {
            this.nameEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.posXEdit.getVisible()) {
            this.posXEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.posYEdit.getVisible()) {
            this.posYEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.posZEdit.getVisible()) {
            this.posZEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.sizeXEdit.getVisible()) {
            this.sizeXEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.sizeYEdit.getVisible()) {
            this.sizeYEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.sizeZEdit.getVisible()) {
            this.sizeZEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.integrityEdit.getVisible()) {
            this.integrityEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.seedEdit.getVisible()) {
            this.seedEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (this.dataEdit.getVisible()) {
            this.dataEdit.textboxKeyTyped(lllllllllllllllllIlllllIllIIlllI, lllllllllllllllllIlllllIllIIllIl);
        }
        if (lllllllllllllllllIlllllIllIIllIl == 15) {
            GuiTextField lllllllllllllllllIlllllIllIlIIll = null;
            GuiTextField lllllllllllllllllIlllllIllIlIIlI = null;
            for (final GuiTextField lllllllllllllllllIlllllIllIlIIIl : this.tabOrder) {
                if (lllllllllllllllllIlllllIllIlIIll != null && lllllllllllllllllIlllllIllIlIIIl.getVisible()) {
                    lllllllllllllllllIlllllIllIlIIlI = lllllllllllllllllIlllllIllIlIIIl;
                    break;
                }
                if (!lllllllllllllllllIlllllIllIlIIIl.isFocused() || !lllllllllllllllllIlllllIllIlIIIl.getVisible()) {
                    continue;
                }
                lllllllllllllllllIlllllIllIlIIll = lllllllllllllllllIlllllIllIlIIIl;
            }
            if (lllllllllllllllllIlllllIllIlIIll != null && lllllllllllllllllIlllllIllIlIIlI == null) {
                for (final GuiTextField lllllllllllllllllIlllllIllIlIIII : this.tabOrder) {
                    if (lllllllllllllllllIlllllIllIlIIII.getVisible() && lllllllllllllllllIlllllIllIlIIII != lllllllllllllllllIlllllIllIlIIll) {
                        lllllllllllllllllIlllllIllIlIIlI = lllllllllllllllllIlllllIllIlIIII;
                        break;
                    }
                }
            }
            if (lllllllllllllllllIlllllIllIlIIlI != null && lllllllllllllllllIlllllIllIlIIlI != lllllllllllllllllIlllllIllIlIIll) {
                lllllllllllllllllIlllllIllIlIIll.setFocused(false);
                lllllllllllllllllIlllllIllIlIIlI.setFocused(true);
            }
        }
        if (lllllllllllllllllIlllllIllIIllIl != 28 && lllllllllllllllllIlllllIllIIllIl != 156) {
            if (lllllllllllllllllIlllllIllIIllIl == 1) {
                this.actionPerformed(this.cancelButton);
            }
        }
        else {
            this.actionPerformed(this.doneButton);
        }
    }
    
    private void updateMirrorButton() {
        final Mirror lllllllllllllllllIllllllIIIIIlIl = this.tileStructure.getMirror();
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllllllIllllllIIIIIlIl.ordinal()]) {
            case 1: {
                this.mirrorButton.displayString = "|";
                break;
            }
            case 2: {
                this.mirrorButton.displayString = "< >";
                break;
            }
            case 3: {
                this.mirrorButton.displayString = "^ v";
                break;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = GuiEditStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        }
        final short lllllllllllllllllIlllllIlIIIIIll = (Object)new int[TileEntityStructure.Mode.values().length];
        try {
            lllllllllllllllllIlllllIlIIIIIll[TileEntityStructure.Mode.CORNER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlllllIlIIIIIll[TileEntityStructure.Mode.DATA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlllllIlIIIIIll[TileEntityStructure.Mode.LOAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlllllIlIIIIIll[TileEntityStructure.Mode.SAVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GuiEditStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = (int[])(Object)lllllllllllllllllIlllllIlIIIIIll;
    }
    
    private void updateToggleBoundingBox() {
        final boolean lllllllllllllllllIllllllIIIIlIll = this.tileStructure.showsBoundingBox();
        if (lllllllllllllllllIllllllIIIIlIll) {
            this.showBoundingBoxButton.displayString = I18n.format("options.on", new Object[0]);
        }
        else {
            this.showBoundingBoxButton.displayString = I18n.format("options.off", new Object[0]);
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllllIlllllIlIllIIII, final int lllllllllllllllllIlllllIlIlIlIll, final int lllllllllllllllllIlllllIlIlIlIlI) throws IOException {
        super.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        if (this.nameEdit.getVisible()) {
            this.nameEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.posXEdit.getVisible()) {
            this.posXEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.posYEdit.getVisible()) {
            this.posYEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.posZEdit.getVisible()) {
            this.posZEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.sizeXEdit.getVisible()) {
            this.sizeXEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.sizeYEdit.getVisible()) {
            this.sizeYEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.sizeZEdit.getVisible()) {
            this.sizeZEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.integrityEdit.getVisible()) {
            this.integrityEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.seedEdit.getVisible()) {
            this.seedEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
        if (this.dataEdit.getVisible()) {
            this.dataEdit.mouseClicked(lllllllllllllllllIlllllIlIllIIII, lllllllllllllllllIlllllIlIlIlIll, lllllllllllllllllIlllllIlIlIlIlI);
        }
    }
    
    private float parseIntegrity(final String lllllllllllllllllIlllllIlllIIllI) {
        try {
            return Float.valueOf(lllllllllllllllllIlllllIlllIIllI);
        }
        catch (NumberFormatException lllllllllllllllllIlllllIlllIIlll) {
            return 1.0f;
        }
    }
    
    private static boolean isValidCharacterForName(final char lllllllllllllllllIlllllIlIllllII, final int lllllllllllllllllIlllllIllIIIIII) {
        boolean lllllllllllllllllIlllllIlIllllll = true;
        byte lllllllllllllllllIlllllIlIllIllI;
        long lllllllllllllllllIlllllIlIllIlll = ((int[])(Object)(lllllllllllllllllIlllllIlIllIllI = (byte)(Object)GuiEditStructure.LEGAL_KEY_CODES)).length;
        for (String lllllllllllllllllIlllllIlIlllIII = (String)0; lllllllllllllllllIlllllIlIlllIII < lllllllllllllllllIlllllIlIllIlll; ++lllllllllllllllllIlllllIlIlllIII) {
            final int lllllllllllllllllIlllllIlIlllllI = lllllllllllllllllIlllllIlIllIllI[lllllllllllllllllIlllllIlIlllIII];
            if (lllllllllllllllllIlllllIlIlllllI == lllllllllllllllllIlllllIllIIIIII) {
                return true;
            }
        }
        lllllllllllllllllIlllllIlIllIlll = ((char[])(Object)(lllllllllllllllllIlllllIlIllIllI = (byte)(Object)ChatAllowedCharacters.ILLEGAL_STRUCTURE_CHARACTERS)).length;
        for (String lllllllllllllllllIlllllIlIlllIII = (String)0; lllllllllllllllllIlllllIlIlllIII < lllllllllllllllllIlllllIlIllIlll; ++lllllllllllllllllIlllllIlIlllIII) {
            final char lllllllllllllllllIlllllIlIllllIl = lllllllllllllllllIlllllIlIllIllI[lllllllllllllllllIlllllIlIlllIII];
            if (lllllllllllllllllIlllllIlIllllIl == lllllllllllllllllIlllllIlIllllII) {
                lllllllllllllllllIlllllIlIllllll = false;
                break;
            }
        }
        return lllllllllllllllllIlllllIlIllllll;
    }
    
    public GuiEditStructure(final TileEntityStructure lllllllllllllllllIllllllIIlIlllI) {
        this.mirror = Mirror.NONE;
        this.rotation = Rotation.NONE;
        this.mode = TileEntityStructure.Mode.DATA;
        this.tabOrder = (List<GuiTextField>)Lists.newArrayList();
        this.decimalFormat = new DecimalFormat("0.0###");
        this.tileStructure = lllllllllllllllllIllllllIIlIlllI;
        this.decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final short lllllllllllllllllIlllllIlIIIIlIl = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllllIlllllIlIIIIlIl[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlllllIlIIIIlIl[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlllllIlIIIIlIl[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlllllIlIIIIlIl[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllllIlllllIlIIIIlIl;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    private void updateDirectionButtons() {
        this.rotateZeroDegreesButton.enabled = true;
        this.rotateNinetyDegreesButton.enabled = true;
        this.rotate180DegreesButton.enabled = true;
        this.rotate270DegressButton.enabled = true;
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.tileStructure.getRotation().ordinal()]) {
            case 1: {
                this.rotateZeroDegreesButton.enabled = false;
                break;
            }
            case 3: {
                this.rotate180DegreesButton.enabled = false;
                break;
            }
            case 4: {
                this.rotate270DegressButton.enabled = false;
                break;
            }
            case 2: {
                this.rotateNinetyDegreesButton.enabled = false;
                break;
            }
        }
    }
    
    @Override
    public void updateScreen() {
        this.nameEdit.updateCursorCounter();
        this.posXEdit.updateCursorCounter();
        this.posYEdit.updateCursorCounter();
        this.posZEdit.updateCursorCounter();
        this.sizeXEdit.updateCursorCounter();
        this.sizeYEdit.updateCursorCounter();
        this.sizeZEdit.updateCursorCounter();
        this.integrityEdit.updateCursorCounter();
        this.seedEdit.updateCursorCounter();
        this.dataEdit.updateCursorCounter();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        LEGAL_KEY_CODES = new int[] { 203, 205, 14, 211, 199, 207 };
    }
    
    private void updateEntitiesButton() {
        final boolean lllllllllllllllllIllllllIIIlIlll = !this.tileStructure.ignoresEntities();
        if (lllllllllllllllllIllllllIIIlIlll) {
            this.showEntitiesButton.displayString = I18n.format("options.on", new Object[0]);
        }
        else {
            this.showEntitiesButton.displayString = I18n.format("options.off", new Object[0]);
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllllIllllllIIIllIll) throws IOException {
        if (lllllllllllllllllIllllllIIIllIll.enabled) {
            if (lllllllllllllllllIllllllIIIllIll.id == 1) {
                this.tileStructure.setMirror(this.mirror);
                this.tileStructure.setRotation(this.rotation);
                this.tileStructure.setMode(this.mode);
                this.tileStructure.setIgnoresEntities(this.ignoreEntities);
                this.tileStructure.setShowAir(this.showAir);
                this.tileStructure.setShowBoundingBox(this.showBoundingBox);
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 0) {
                if (this.sendToServer(1)) {
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 9) {
                if (this.tileStructure.getMode() == TileEntityStructure.Mode.SAVE) {
                    this.sendToServer(2);
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 10) {
                if (this.tileStructure.getMode() == TileEntityStructure.Mode.LOAD) {
                    this.sendToServer(3);
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 11) {
                this.tileStructure.setRotation(Rotation.NONE);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 12) {
                this.tileStructure.setRotation(Rotation.CLOCKWISE_90);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 13) {
                this.tileStructure.setRotation(Rotation.CLOCKWISE_180);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 14) {
                this.tileStructure.setRotation(Rotation.COUNTERCLOCKWISE_90);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 18) {
                this.tileStructure.nextMode();
                this.updateMode();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 19) {
                if (this.tileStructure.getMode() == TileEntityStructure.Mode.SAVE) {
                    this.sendToServer(4);
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 20) {
                this.tileStructure.setIgnoresEntities(!this.tileStructure.ignoresEntities());
                this.updateEntitiesButton();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 22) {
                this.tileStructure.setShowAir(!this.tileStructure.showsAir());
                this.updateToggleAirButton();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 23) {
                this.tileStructure.setShowBoundingBox(!this.tileStructure.showsBoundingBox());
                this.updateToggleBoundingBox();
            }
            else if (lllllllllllllllllIllllllIIIllIll.id == 21) {
                switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[this.tileStructure.getMirror().ordinal()]) {
                    case 1: {
                        this.tileStructure.setMirror(Mirror.LEFT_RIGHT);
                        break;
                    }
                    case 2: {
                        this.tileStructure.setMirror(Mirror.FRONT_BACK);
                        break;
                    }
                    case 3: {
                        this.tileStructure.setMirror(Mirror.NONE);
                        break;
                    }
                }
                this.updateMirrorButton();
            }
        }
    }
    
    private int parseCoordinate(final String lllllllllllllllllIlllllIlllIIIIl) {
        try {
            return Integer.parseInt(lllllllllllllllllIlllllIlllIIIIl);
        }
        catch (NumberFormatException lllllllllllllllllIlllllIlllIIIII) {
            return 0;
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIlllllIlIIlIIIl, final int lllllllllllllllllIlllllIlIIllllI, final float lllllllllllllllllIlllllIlIIlllIl) {
        this.drawDefaultBackground();
        final TileEntityStructure.Mode lllllllllllllllllIlllllIlIIlllII = this.tileStructure.getMode();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.structureBlock.name", new Object[0]), this.width / 2, 10, 16777215);
        if (lllllllllllllllllIlllllIlIIlllII != TileEntityStructure.Mode.DATA) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.structure_name", new Object[0]), this.width / 2 - 153, 30, 10526880);
            this.nameEdit.drawTextBox();
        }
        if (lllllllllllllllllIlllllIlIIlllII == TileEntityStructure.Mode.LOAD || lllllllllllllllllIlllllIlIIlllII == TileEntityStructure.Mode.SAVE) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.position", new Object[0]), this.width / 2 - 153, 70, 10526880);
            this.posXEdit.drawTextBox();
            this.posYEdit.drawTextBox();
            this.posZEdit.drawTextBox();
            final String lllllllllllllllllIlllllIlIIllIll = I18n.format("structure_block.include_entities", new Object[0]);
            final int lllllllllllllllllIlllllIlIIllIlI = this.fontRendererObj.getStringWidth(lllllllllllllllllIlllllIlIIllIll);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlllllIlIIllIll, this.width / 2 + 154 - lllllllllllllllllIlllllIlIIllIlI, 150, 10526880);
        }
        if (lllllllllllllllllIlllllIlIIlllII == TileEntityStructure.Mode.SAVE) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.size", new Object[0]), this.width / 2 - 153, 110, 10526880);
            this.sizeXEdit.drawTextBox();
            this.sizeYEdit.drawTextBox();
            this.sizeZEdit.drawTextBox();
            final String lllllllllllllllllIlllllIlIIllIIl = I18n.format("structure_block.detect_size", new Object[0]);
            final int lllllllllllllllllIlllllIlIIllIII = this.fontRendererObj.getStringWidth(lllllllllllllllllIlllllIlIIllIIl);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlllllIlIIllIIl, this.width / 2 + 154 - lllllllllllllllllIlllllIlIIllIII, 110, 10526880);
            final String lllllllllllllllllIlllllIlIIlIlll = I18n.format("structure_block.show_air", new Object[0]);
            final int lllllllllllllllllIlllllIlIIlIllI = this.fontRendererObj.getStringWidth(lllllllllllllllllIlllllIlIIlIlll);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlllllIlIIlIlll, this.width / 2 + 154 - lllllllllllllllllIlllllIlIIlIllI, 70, 10526880);
        }
        if (lllllllllllllllllIlllllIlIIlllII == TileEntityStructure.Mode.LOAD) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.integrity", new Object[0]), this.width / 2 - 153, 110, 10526880);
            this.integrityEdit.drawTextBox();
            this.seedEdit.drawTextBox();
            final String lllllllllllllllllIlllllIlIIlIlIl = I18n.format("structure_block.show_boundingbox", new Object[0]);
            final int lllllllllllllllllIlllllIlIIlIlII = this.fontRendererObj.getStringWidth(lllllllllllllllllIlllllIlIIlIlIl);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlllllIlIIlIlIl, this.width / 2 + 154 - lllllllllllllllllIlllllIlIIlIlII, 70, 10526880);
        }
        if (lllllllllllllllllIlllllIlIIlllII == TileEntityStructure.Mode.DATA) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.custom_data", new Object[0]), this.width / 2 - 153, 110, 10526880);
            this.dataEdit.drawTextBox();
        }
        final String lllllllllllllllllIlllllIlIIlIIll = "structure_block.mode_info." + lllllllllllllllllIlllllIlIIlllII.getName();
        this.drawString(this.fontRendererObj, I18n.format(lllllllllllllllllIlllllIlIIlIIll, new Object[0]), this.width / 2 - 153, 174, 10526880);
        super.drawScreen(lllllllllllllllllIlllllIlIIlIIIl, lllllllllllllllllIlllllIlIIllllI, lllllllllllllllllIlllllIlIIlllIl);
    }
    
    private boolean sendToServer(final int lllllllllllllllllIlllllIlllllIII) {
        try {
            final PacketBuffer lllllllllllllllllIlllllIllllIlll = new PacketBuffer(Unpooled.buffer());
            this.tileStructure.writeCoordinates(lllllllllllllllllIlllllIllllIlll);
            lllllllllllllllllIlllllIllllIlll.writeByte(lllllllllllllllllIlllllIlllllIII);
            lllllllllllllllllIlllllIllllIlll.writeString(this.tileStructure.getMode().toString());
            lllllllllllllllllIlllllIllllIlll.writeString(this.nameEdit.getText());
            lllllllllllllllllIlllllIllllIlll.writeInt(this.parseCoordinate(this.posXEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeInt(this.parseCoordinate(this.posYEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeInt(this.parseCoordinate(this.posZEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeInt(this.parseCoordinate(this.sizeXEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeInt(this.parseCoordinate(this.sizeYEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeInt(this.parseCoordinate(this.sizeZEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeString(this.tileStructure.getMirror().toString());
            lllllllllllllllllIlllllIllllIlll.writeString(this.tileStructure.getRotation().toString());
            lllllllllllllllllIlllllIllllIlll.writeString(this.dataEdit.getText());
            lllllllllllllllllIlllllIllllIlll.writeBoolean(this.tileStructure.ignoresEntities());
            lllllllllllllllllIlllllIllllIlll.writeBoolean(this.tileStructure.showsAir());
            lllllllllllllllllIlllllIllllIlll.writeBoolean(this.tileStructure.showsBoundingBox());
            lllllllllllllllllIlllllIllllIlll.writeFloat(this.parseIntegrity(this.integrityEdit.getText()));
            lllllllllllllllllIlllllIllllIlll.writeVarLong(this.parseSeed(this.seedEdit.getText()));
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|Struct", lllllllllllllllllIlllllIllllIlll));
            return true;
        }
        catch (Exception lllllllllllllllllIlllllIllllIllI) {
            GuiEditStructure.LOGGER.warn("Could not send structure block info", (Throwable)lllllllllllllllllIlllllIllllIllI);
            return false;
        }
    }
    
    private void updateToggleAirButton() {
        final boolean lllllllllllllllllIllllllIIIlIIIl = this.tileStructure.showsAir();
        if (lllllllllllllllllIllllllIIIlIIIl) {
            this.showAirButton.displayString = I18n.format("options.on", new Object[0]);
        }
        else {
            this.showAirButton.displayString = I18n.format("options.off", new Object[0]);
        }
    }
    
    private long parseSeed(final String lllllllllllllllllIlllllIlllIllIl) {
        try {
            return Long.valueOf(lllllllllllllllllIlllllIlllIllIl);
        }
        catch (NumberFormatException lllllllllllllllllIlllllIlllIlllI) {
            return 0L;
        }
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.doneButton = this.addButton(new GuiButton(0, this.width / 2 - 4 - 150, 210, 150, 20, I18n.format("gui.done", new Object[0])));
        this.cancelButton = this.addButton(new GuiButton(1, this.width / 2 + 4, 210, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.saveButton = this.addButton(new GuiButton(9, this.width / 2 + 4 + 100, 185, 50, 20, I18n.format("structure_block.button.save", new Object[0])));
        this.loadButton = this.addButton(new GuiButton(10, this.width / 2 + 4 + 100, 185, 50, 20, I18n.format("structure_block.button.load", new Object[0])));
        this.modeButton = this.addButton(new GuiButton(18, this.width / 2 - 4 - 150, 185, 50, 20, "MODE"));
        this.detectSizeButton = this.addButton(new GuiButton(19, this.width / 2 + 4 + 100, 120, 50, 20, I18n.format("structure_block.button.detect_size", new Object[0])));
        this.showEntitiesButton = this.addButton(new GuiButton(20, this.width / 2 + 4 + 100, 160, 50, 20, "ENTITIES"));
        this.mirrorButton = this.addButton(new GuiButton(21, this.width / 2 - 20, 185, 40, 20, "MIRROR"));
        this.showAirButton = this.addButton(new GuiButton(22, this.width / 2 + 4 + 100, 80, 50, 20, "SHOWAIR"));
        this.showBoundingBoxButton = this.addButton(new GuiButton(23, this.width / 2 + 4 + 100, 80, 50, 20, "SHOWBB"));
        this.rotateZeroDegreesButton = this.addButton(new GuiButton(11, this.width / 2 - 1 - 40 - 1 - 40 - 20, 185, 40, 20, "0"));
        this.rotateNinetyDegreesButton = this.addButton(new GuiButton(12, this.width / 2 - 1 - 40 - 20, 185, 40, 20, "90"));
        this.rotate180DegreesButton = this.addButton(new GuiButton(13, this.width / 2 + 1 + 20, 185, 40, 20, "180"));
        this.rotate270DegressButton = this.addButton(new GuiButton(14, this.width / 2 + 1 + 40 + 1 + 20, 185, 40, 20, "270"));
        this.nameEdit = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 152, 40, 300, 20);
        this.nameEdit.setMaxStringLength(64);
        this.nameEdit.setText(this.tileStructure.getName());
        this.tabOrder.add(this.nameEdit);
        final BlockPos lllllllllllllllllIllllllIIlIIllI = this.tileStructure.getPosition();
        this.posXEdit = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 152, 80, 80, 20);
        this.posXEdit.setMaxStringLength(15);
        this.posXEdit.setText(Integer.toString(lllllllllllllllllIllllllIIlIIllI.getX()));
        this.tabOrder.add(this.posXEdit);
        this.posYEdit = new GuiTextField(4, this.fontRendererObj, this.width / 2 - 72, 80, 80, 20);
        this.posYEdit.setMaxStringLength(15);
        this.posYEdit.setText(Integer.toString(lllllllllllllllllIllllllIIlIIllI.getY()));
        this.tabOrder.add(this.posYEdit);
        this.posZEdit = new GuiTextField(5, this.fontRendererObj, this.width / 2 + 8, 80, 80, 20);
        this.posZEdit.setMaxStringLength(15);
        this.posZEdit.setText(Integer.toString(lllllllllllllllllIllllllIIlIIllI.getZ()));
        this.tabOrder.add(this.posZEdit);
        final BlockPos lllllllllllllllllIllllllIIlIIlIl = this.tileStructure.getStructureSize();
        this.sizeXEdit = new GuiTextField(6, this.fontRendererObj, this.width / 2 - 152, 120, 80, 20);
        this.sizeXEdit.setMaxStringLength(15);
        this.sizeXEdit.setText(Integer.toString(lllllllllllllllllIllllllIIlIIlIl.getX()));
        this.tabOrder.add(this.sizeXEdit);
        this.sizeYEdit = new GuiTextField(7, this.fontRendererObj, this.width / 2 - 72, 120, 80, 20);
        this.sizeYEdit.setMaxStringLength(15);
        this.sizeYEdit.setText(Integer.toString(lllllllllllllllllIllllllIIlIIlIl.getY()));
        this.tabOrder.add(this.sizeYEdit);
        this.sizeZEdit = new GuiTextField(8, this.fontRendererObj, this.width / 2 + 8, 120, 80, 20);
        this.sizeZEdit.setMaxStringLength(15);
        this.sizeZEdit.setText(Integer.toString(lllllllllllllllllIllllllIIlIIlIl.getZ()));
        this.tabOrder.add(this.sizeZEdit);
        this.integrityEdit = new GuiTextField(15, this.fontRendererObj, this.width / 2 - 152, 120, 80, 20);
        this.integrityEdit.setMaxStringLength(15);
        this.integrityEdit.setText(this.decimalFormat.format(this.tileStructure.getIntegrity()));
        this.tabOrder.add(this.integrityEdit);
        this.seedEdit = new GuiTextField(16, this.fontRendererObj, this.width / 2 - 72, 120, 80, 20);
        this.seedEdit.setMaxStringLength(31);
        this.seedEdit.setText(Long.toString(this.tileStructure.getSeed()));
        this.tabOrder.add(this.seedEdit);
        this.dataEdit = new GuiTextField(17, this.fontRendererObj, this.width / 2 - 152, 120, 240, 20);
        this.dataEdit.setMaxStringLength(128);
        this.dataEdit.setText(this.tileStructure.getMetadata());
        this.tabOrder.add(this.dataEdit);
        this.mirror = this.tileStructure.getMirror();
        this.updateMirrorButton();
        this.rotation = this.tileStructure.getRotation();
        this.updateDirectionButtons();
        this.mode = this.tileStructure.getMode();
        this.updateMode();
        this.ignoreEntities = this.tileStructure.ignoresEntities();
        this.updateEntitiesButton();
        this.showAir = this.tileStructure.showsAir();
        this.updateToggleAirButton();
        this.showBoundingBox = this.tileStructure.showsBoundingBox();
        this.updateToggleBoundingBox();
    }
}

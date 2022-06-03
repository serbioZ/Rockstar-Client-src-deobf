// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui;

import net.minecraft.client.Minecraft;
import ru.rockstar.security.CFontUser;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.render.ClientHelper;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import ru.rockstar.client.features.impl.display.ClickGUI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;
import ru.rockstar.client.ui.clickgui.component.ExpandableComponent;
import java.io.IOException;
import ru.rockstar.client.ui.settings.button.ImageButton;
import java.util.ArrayList;
import ru.rockstar.api.utils.render.glsandbox.animbackground;
import ru.rockstar.client.ui.clickgui.component.Component;
import ru.rockstar.client.features.Category;
import java.util.List;
import net.minecraft.client.gui.GuiScreen;

public class ClickGuiScreen extends GuiScreen
{
    public /* synthetic */ List<Panel> components;
    public /* synthetic */ boolean exit;
    public /* synthetic */ ScreenHelper screenHelper;
    public /* synthetic */ Category type;
    private /* synthetic */ Component selectedPanel;
    private /* synthetic */ animbackground backgroundShader;
    protected /* synthetic */ ArrayList<ImageButton> imageButtons;
    public static /* synthetic */ boolean escapeKeyInUse;
    
    public static void main(final String[] llllllllllllIIllIllIIllIlllllIlI) throws Exception {
        final String llllllllllllIIllIllIIllIlllllIIl = "http://www.avajava.com/images/avajavalogo.jpg";
        final String llllllllllllIIllIllIIllIlllllIII = "image.jpg";
        saveImage(llllllllllllIIllIllIIllIlllllIIl, llllllllllllIIllIllIIllIlllllIII);
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIIllIllIIllIlIlIIIIl, final int llllllllllllIIllIllIIllIlIIlllIl) throws IOException {
        if (llllllllllllIIllIllIIllIlIIlllIl == 1) {
            this.exit = true;
        }
        if (this.exit) {
            return;
        }
        this.selectedPanel.onKeyPress(llllllllllllIIllIllIIllIlIIlllIl);
        if (!ClickGuiScreen.escapeKeyInUse) {
            super.keyTyped(llllllllllllIIllIllIIllIlIlIIIIl, llllllllllllIIllIllIIllIlIIlllIl);
        }
        ClickGuiScreen.escapeKeyInUse = false;
    }
    
    public ClickGuiScreen() {
        this.components = new ArrayList<Panel>();
        this.exit = false;
        this.imageButtons = new ArrayList<ImageButton>();
        try {
            this.backgroundShader = new animbackground("/noise.fsh");
        }
        catch (IOException llllllllllllIIllIllIIlllIIIIllll) {
            throw new IllegalStateException("Failed to load backgound shader", llllllllllllIIllIllIIlllIIIIllll);
        }
        final int llllllllllllIIllIllIIlllIIIIlllI = 20;
        int llllllllllllIIllIllIIlllIIIIllIl = 5;
        final int llllllllllllIIllIllIIlllIIIIllII = 20;
        final boolean llllllllllllIIllIllIIlllIIIIIIll;
        final char llllllllllllIIllIllIIlllIIIIIlII = (char)((Category[])(Object)(llllllllllllIIllIllIIlllIIIIIIll = (boolean)(Object)Category.values())).length;
        for (Exception llllllllllllIIllIllIIlllIIIIIlIl = (Exception)0; llllllllllllIIllIllIIlllIIIIIlIl < llllllllllllIIllIllIIlllIIIIIlII; ++llllllllllllIIllIllIIlllIIIIIlIl) {
            final Category llllllllllllIIllIllIIlllIIIIlIll = llllllllllllIIllIllIIlllIIIIIIll[llllllllllllIIllIllIIlllIIIIIlIl];
            this.type = llllllllllllIIllIllIIlllIIIIlIll;
            this.components.add(new Panel(llllllllllllIIllIllIIlllIIIIlIll, llllllllllllIIllIllIIlllIIIIllIl, llllllllllllIIllIllIIlllIIIIllII));
            this.selectedPanel = new Panel(llllllllllllIIllIllIIlllIIIIlIll, llllllllllllIIllIllIIlllIIIIllIl, llllllllllllIIllIllIIlllIIIIllII);
            llllllllllllIIllIllIIlllIIIIllIl += llllllllllllIIllIllIIlllIIIIlllI + 85;
        }
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
    }
    
    @Override
    protected void mouseReleased(final int llllllllllllIIllIllIIllIIlllllII, final int llllllllllllIIllIllIIllIIllllIll, final int llllllllllllIIllIllIIllIIllllIII) {
        this.selectedPanel.onMouseRelease(llllllllllllIIllIllIIllIIllllIII);
    }
    
    public static void saveImage(final String llllllllllllIIllIllIIllIlllIlllI, final String llllllllllllIIllIllIIllIlllIIlIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* llllllllllllIIllIllIIllIlllIIllI */
        //     5: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //     8: astore_2        /* llllllllllllIIllIllIIllIlllIIlII */
        //     9: aload_2         /* llllllllllllIIllIllIIllIlllIllII */
        //    10: invokevirtual   java/net/URL.openStream:()Ljava/io/InputStream;
        //    13: astore_3        /* llllllllllllIIllIllIIllIlllIlIll */
        //    14: new             Ljava/io/FileOutputStream;
        //    17: dup            
        //    18: aload_1         /* llllllllllllIIllIllIIllIlllIllIl */
        //    19: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //    22: astore          llllllllllllIIllIllIIllIlllIlIlI
        //    24: sipush          2048
        //    27: newarray        B
        //    29: astore          llllllllllllIIllIllIIllIlllIlIIl
        //    31: goto            44
        //    34: aload           llllllllllllIIllIllIIllIlllIlIlI
        //    36: aload           llllllllllllIIllIllIIllIlllIlIIl
        //    38: iconst_0       
        //    39: iload           llllllllllllIIllIllIIllIlllIlIII
        //    41: invokevirtual   java/io/OutputStream.write:([BII)V
        //    44: aload_3         /* llllllllllllIIllIllIIllIlllIlIll */
        //    45: aload           llllllllllllIIllIllIIllIlllIlIIl
        //    47: invokevirtual   java/io/InputStream.read:([B)I
        //    50: dup            
        //    51: istore          llllllllllllIIllIllIIllIlllIIlll
        //    53: iconst_m1      
        //    54: if_icmpne       34
        //    57: aload_3         /* llllllllllllIIllIllIIllIlllIlIll */
        //    58: invokevirtual   java/io/InputStream.close:()V
        //    61: aload           llllllllllllIIllIllIIllIlllIlIlI
        //    63: invokevirtual   java/io/OutputStream.close:()V
        //    66: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FF 00 22 00 07 07 00 C9 07 00 C9 07 00 9A 07 00 AA 07 00 A1 07 00 CA 01 00 00 FA 00 09
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIIllIllIIllIlIIlIIIl, final int llllllllllllIIllIllIIllIlIIIIlll, final int llllllllllllIIllIllIIllIlIIIIllI) {
        for (final Component llllllllllllIIllIllIIllIlIIIlllI : this.components) {
            final int llllllllllllIIllIllIIllIlIIIllIl = llllllllllllIIllIllIIllIlIIIlllI.getX();
            final int llllllllllllIIllIllIIllIlIIIllII = llllllllllllIIllIllIIllIlIIIlllI.getY();
            int llllllllllllIIllIllIIllIlIIIlIll = llllllllllllIIllIllIIllIlIIIlllI.getHeight();
            if (llllllllllllIIllIllIIllIlIIIlllI instanceof ExpandableComponent) {
                final ExpandableComponent llllllllllllIIllIllIIllIlIIIlIlI = (ExpandableComponent)llllllllllllIIllIllIIllIlIIIlllI;
                if (llllllllllllIIllIllIIllIlIIIlIlI.isExpanded()) {
                    llllllllllllIIllIllIIllIlIIIlIll = llllllllllllIIllIllIIllIlIIIlIlI.getHeightWithExpand();
                }
            }
            if (llllllllllllIIllIllIIllIlIIlIIIl > llllllllllllIIllIllIIllIlIIIllIl && llllllllllllIIllIllIIllIlIIIIlll > llllllllllllIIllIllIIllIlIIIllII && llllllllllllIIllIllIIllIlIIlIIIl < llllllllllllIIllIllIIllIlIIIllIl + llllllllllllIIllIllIIllIlIIIlllI.getWidth() && llllllllllllIIllIllIIllIlIIIIlll < llllllllllllIIllIllIIllIlIIIllII + llllllllllllIIllIllIIllIlIIIlIll) {
                this.selectedPanel = llllllllllllIIllIllIIllIlIIIlllI;
                llllllllllllIIllIllIIllIlIIIlllI.onMouseClick(llllllllllllIIllIllIIllIlIIlIIIl, llllllllllllIIllIllIIllIlIIIIlll, llllllllllllIIllIllIIllIlIIIIllI);
                break;
            }
        }
    }
    
    public void updateMouseWheel() {
        final int llllllllllllIIllIllIIllIlIlIlIll = Mouse.getDWheel();
        for (final Component llllllllllllIIllIllIIllIlIlIlIlI : this.components) {
            if (llllllllllllIIllIllIIllIlIlIlIll > 0) {
                llllllllllllIIllIllIIllIlIlIlIlI.setY(llllllllllllIIllIllIIllIlIlIlIlI.getY() + 15);
            }
            if (llllllllllllIIllIllIIllIlIlIlIll < 0) {
                llllllllllllIIllIllIIllIlIlIlIlI.setY(llllllllllllIIllIllIIllIlIlIlIlI.getY() - 15);
            }
        }
    }
    
    @Override
    public void initGui() {
        final ScaledResolution llllllllllllIIllIllIIllIllllllll = new ScaledResolution(this.mc);
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
        this.imageButtons.clear();
        this.imageButtons.add(new ImageButton(new ResourceLocation("rockstar/config.png"), 5, llllllllllllIIllIllIIllIllllllll.getScaledHeight() - 25, 20, 20, "\u042f \u0433\u0435\u0439, \u043d\u043e \u043d\u0438\u043a\u0442\u043e \u043e\u0431 \u044d\u0442\u043e\u043c \u043d\u0435 \u0443\u0437\u043d\u0430\u0435\u0442", 22));
        this.imageButtons.add(new ImageButton(new ResourceLocation("rockstar/icons/visuals.png"), 25, llllllllllllIIllIllIIllIllllllll.getScaledHeight() - 25, 20, 20, "\u042f \u0433\u0435\u0439, \u043d\u043e \u043d\u0438\u043a\u0442\u043e \u043e\u0431 \u044d\u0442\u043e\u043c \u043d\u0435 \u0443\u0437\u043d\u0430\u0435\u0442", 24));
        if (ClickGUI.blur.getBoolValue()) {
            this.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        super.initGui();
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIllIllIIllIlIlllllI, final int llllllllllllIIllIllIIllIlIllllIl, final float llllllllllllIIllIllIIllIlIllllII) {
        final ScaledResolution llllllllllllIIllIllIIllIllIIllII = new ScaledResolution(this.mc);
        Color llllllllllllIIllIllIIllIllIIlIll = Color.WHITE;
        final Color llllllllllllIIllIllIIllIllIIlIlI = new Color(ClickGUI.color.getColorValue());
        final Color llllllllllllIIllIllIIllIllIIlIIl = new Color(ClickGUI.colorTwo.getColorValue());
        final double llllllllllllIIllIllIIllIllIIlIII = ClickGUI.speed.getNumberValue();
        final int llllllllllllIIllIllIIllIlIllIllI;
        switch (((String)(llllllllllllIIllIllIIllIlIllIllI = (int)ClickGUI.clickGuiColor.currentMode)).hashCode()) {
            case -1808614770: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Static")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = llllllllllllIIllIllIIllIllIIlIlI;
                break;
            }
            case -1656737386: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Rainbow")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = DrawHelper.rainbow(300, 1.0f, 1.0f);
                break;
            }
            case -311641137: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Color Two")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = new Color(DrawHelper.fadeColor(llllllllllllIIllIllIIllIllIIlIlI.getRGB(), llllllllllllIIllIllIIllIllIIlIIl.getRGB(), (float)Math.abs((System.currentTimeMillis() / llllllllllllIIllIllIIllIllIIlIII / llllllllllllIIllIllIIllIllIIlIII + this.height * 6L / 60L * 2L) % 2.0 - 1.0)));
                break;
            }
            case 2181788: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Fade")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = new Color(ClickGUI.color.getColorValue());
                break;
            }
            case 115155230: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Category")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = new Color(this.type.getColor());
                break;
            }
            case 961091784: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Astolfo")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = DrawHelper.astolfo(true, this.width);
                break;
            }
            case 2021122027: {
                if (!((String)llllllllllllIIllIllIIllIlIllIllI).equals("Client")) {
                    break;
                }
                llllllllllllIIllIllIIllIllIIlIll = ClientHelper.getClientColor();
                break;
            }
        }
        final Color llllllllllllIIllIllIIllIllIIIlll = new Color(0, 0, 0, 0);
        final String llllllllllllIIllIllIIllIllIIIllI = ClickGUI.backGroundMode.getOptions();
        if (ClickGUI.background.getBoolValue()) {
            if (llllllllllllIIllIllIIllIllIIIllI.equalsIgnoreCase("Top")) {
                this.drawDefaultBackground();
                this.drawGradientRect(0, 0, llllllllllllIIllIllIIllIllIIllII.getScaledWidth(), llllllllllllIIllIllIIllIllIIllII.getScaledHeight(), llllllllllllIIllIllIIllIllIIlIll.getRGB(), llllllllllllIIllIllIIllIllIIIlll.getRGB());
            }
            else if (llllllllllllIIllIllIIllIllIIIllI.equalsIgnoreCase("Bottom")) {
                this.drawDefaultBackground();
                this.drawGradientRect(0, 0, llllllllllllIIllIllIIllIllIIllII.getScaledWidth(), llllllllllllIIllIllIIllIllIIllII.getScaledHeight(), llllllllllllIIllIllIIllIllIIIlll.getRGB(), llllllllllllIIllIllIIllIllIIlIll.getRGB());
            }
            else if (llllllllllllIIllIllIIllIllIIIllI.equalsIgnoreCase("Everywhere")) {
                this.drawDefaultBackground();
                this.drawGradientRect(0, 0, llllllllllllIIllIllIIllIllIIllII.getScaledWidth(), llllllllllllIIllIllIIllIllIIllII.getScaledHeight(), DrawHelper.setAlpha(llllllllllllIIllIllIIllIllIIlIll, 100).getRGB(), DrawHelper.setAlpha(llllllllllllIIllIllIIllIllIIlIll, 100).getRGB());
            }
            else if (llllllllllllIIllIllIIllIllIIIllI.equalsIgnoreCase("Shader")) {
                GlStateManager.disableCull();
                final long llllllllllllIIllIllIIllIllIIIlIl = System.currentTimeMillis();
                this.backgroundShader.useShader(llllllllllllIIllIllIIllIllIIllII.getScaledWidth() + 80000, llllllllllllIIllIllIIllIllIIllII.getScaledHeight(), (float)llllllllllllIIllIllIIllIlIlllllI, (float)llllllllllllIIllIllIIllIlIllllIl, (System.currentTimeMillis() - llllllllllllIIllIllIIllIllIIIlIl) / 5000.0f);
                GL11.glBegin(7);
                GL11.glVertex2f(-1.0f, -1.0f);
                GL11.glVertex2f(-1.0f, 1.0f);
                GL11.glVertex2f(1.0f, 1.0f);
                GL11.glVertex2f(1.0f, -1.0f);
                GL11.glEnd();
                GL20.glUseProgram(0);
                GlStateManager.disableCull();
            }
        }
        if (ClickGUI.image.getBoolValue()) {
            final int llllllllllllIIllIllIIllIllIIIlII = (int)ClickGUI.imagex.getNumberValue();
            final int llllllllllllIIllIllIIllIllIIIIll = (int)ClickGUI.imagey.getNumberValue();
            final String llllllllllllIIllIllIIllIllIIIIlI = ClickGUI.imagemode.getOptions();
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 260.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside2.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 260.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside3")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside3.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 260.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside4")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside4.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 400.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside5")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside5.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 330.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside6")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside6.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 260.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside7")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside7.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 260.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("DeadInside8")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/deadinside8.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 280.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Allax")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/allax.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Cat")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/cat.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Floppa")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/floppa.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Minecraft")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/minecraft.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 450.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Putin")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/putin.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Slava Bebrow")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/slavabebrow.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 450.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Simple")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/simple.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 450.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan2.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan3")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan3.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 300.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan4")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan4.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 300.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan5")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan5.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan6")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan6.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan7")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan7.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan8")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan8.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan9")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan9.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 450.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan10")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan10.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan11")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan11.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan12")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan12.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan13")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan13.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 400.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan14")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan14.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan15")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan15.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 400.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan16")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan16.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan17")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan17.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan18")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan18.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 300.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan19")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan19.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan20")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan20.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan21")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan21.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 300.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan22")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan22.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan23")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan23.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 300.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan24")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan24.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Tyan25")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/tyan25.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Brawl")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 400.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Brawl2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl2.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Brawl3")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl3.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Brawl4")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl4.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Brawl5")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/brawl5.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 450.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Floppa2")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/floppa2.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            if (llllllllllllIIllIllIIllIllIIIIlI.equalsIgnoreCase("Selli324")) {
                DrawHelper.drawImage(new ResourceLocation("rockstar/clickgui/cow.png"), (float)llllllllllllIIllIllIIllIllIIIlII, (float)llllllllllllIIllIllIIllIllIIIIll, 350.0f, 350.0f, new Color(-1));
            }
            DrawHelper.drawRectWithGlow(llllllllllllIIllIllIIllIllIIllII.getScaledWidth() - this.mc.mntsb_20.getStringWidth("Username: " + CFontUser.username) - 5, llllllllllllIIllIllIIllIllIIllII.getScaledHeight(), llllllllllllIIllIllIIllIllIIllII.getScaledWidth(), llllllllllllIIllIllIIllIllIIllII.getScaledHeight() - 15, 5.0, 13.0, new Color(0, 0, 0, 255));
            this.mc.mntsb_20.drawStringWithShadow("Username: " + CFontUser.username, llllllllllllIIllIllIIllIllIIllII.getScaledWidth() - this.mc.mntsb_20.getStringWidth("Username: " + CFontUser.username) - 3, llllllllllllIIllIllIIllIllIIllII.getScaledHeight() - 10, -1);
        }
        for (final Panel llllllllllllIIllIllIIllIllIIIIIl : this.components) {
            llllllllllllIIllIllIIllIllIIIIIl.drawComponent(llllllllllllIIllIllIIllIllIIllII, llllllllllllIIllIllIIllIlIlllllI, llllllllllllIIllIllIIllIlIllllIl);
        }
        for (final ImageButton llllllllllllIIllIllIIllIllIIIIII : this.imageButtons) {
            llllllllllllIIllIllIIllIllIIIIII.draw(llllllllllllIIllIllIIllIlIlllllI, llllllllllllIIllIllIIllIlIllllIl, Color.WHITE);
            if (Mouse.isButtonDown(0)) {
                llllllllllllIIllIllIIllIllIIIIII.onClick(llllllllllllIIllIllIIllIlIlllllI, llllllllllllIIllIllIIllIlIllllIl);
            }
        }
        this.updateMouseWheel();
        if (this.exit) {
            this.screenHelper.interpolate(0.0f, 0.0f, 2.0);
            if (this.screenHelper.getY() < 200.0f) {
                this.exit = false;
                this.mc.displayGuiScreen(null);
                if (this.mc.currentScreen == null) {
                    this.mc.setIngameFocus();
                }
            }
        }
        else {
            this.screenHelper.interpolate((float)this.width, (float)this.height, 3.0 * Minecraft.frameTime / 6.0);
        }
        super.drawScreen(llllllllllllIIllIllIIllIlIlllllI, llllllllllllIIllIllIIllIlIllllIl, llllllllllllIIllIllIIllIlIllllII);
    }
    
    @Override
    public void onGuiClosed() {
        this.screenHelper = new ScreenHelper(0.0f, 0.0f);
        this.mc.entityRenderer.theShaderGroup = null;
        super.onGuiClosed();
    }
}

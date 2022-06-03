// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager;

import com.mojang.authlib.exceptions.AuthenticationException;
import ru.rockstar.client.ui.altmanager.alt.AltConfig;
import ru.rockstar.Main;
import com.mojang.authlib.Agent;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.net.Proxy;
import com.mojang.realmsclient.gui.ChatFormatting;
import ru.rockstar.client.ui.altmanager.alt.Alt;
import ru.rockstar.client.ui.altmanager.alt.AltManager;
import java.io.IOException;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiScreen;

public class GuiAddAlt extends GuiScreen
{
    private /* synthetic */ PasswordField password;
    private /* synthetic */ String status;
    private /* synthetic */ GuiTextField username;
    private final /* synthetic */ GuiAltManager manager;
    
    @Override
    protected void keyTyped(final char lllllllllllIllIIIIIlIIlIlllIIIll, final int lllllllllllIllIIIIIlIIlIllIlllll) {
        this.username.textboxKeyTyped(lllllllllllIllIIIIIlIIlIlllIIIll, lllllllllllIllIIIIIlIIlIllIlllll);
        this.password.textboxKeyTyped(lllllllllllIllIIIIIlIIlIlllIIIll, lllllllllllIllIIIIIlIIlIllIlllll);
        if (lllllllllllIllIIIIIlIIlIlllIIIll == '\t' && (this.username.isFocused() || this.password.isFocused())) {
            this.username.setFocused(!this.username.isFocused());
            this.password.setFocused(!this.password.isFocused());
        }
        if (lllllllllllIllIIIIIlIIlIlllIIIll == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllIllIIIIIlIIlIlllIllIl, final int lllllllllllIllIIIIIlIIlIllllIIII, final float lllllllllllIllIIIIIlIIlIlllIlIll) {
        DrawHelper.drawBorderedRect(0.0, 0.0, this.width, this.height, 0.5, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
        this.username.drawTextBox();
        this.password.drawTextBox();
        this.mc.neverlose500_18.drawCenteredString("Add Account", this.width / 2.0f, 15.0f, -1);
        if (this.username.getText().isEmpty() && !this.username.isFocused()) {
            this.mc.neverlose500_18.drawStringWithShadow("Username / E-Mail", this.width / 2 - 96, 66.0, -7829368);
        }
        if (this.password.getText().isEmpty() && !this.password.isFocused()) {
            this.mc.neverlose500_18.drawStringWithShadow("Password", this.width / 2 - 96, 106.0, -7829368);
        }
        this.mc.neverlose500_18.drawCenteredString(this.status, this.width / 2.0f, 30.0f, -1);
        super.drawScreen(lllllllllllIllIIIIIlIIlIlllIllIl, lllllllllllIllIIIIIlIIlIllllIIII, lllllllllllIllIIIIIlIIlIlllIlIll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllIllIIIIIlIIllIIIIIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/GuiButton.id:I
        //     4: tableswitch {
        //                0: 32
        //                1: 62
        //                2: 76
        //          default: 137
        //        }
        //    32: new             Lru/rockstar/client/ui/altmanager/GuiAddAlt$AddAltThread;
        //    35: dup            
        //    36: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //    37: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //    38: getfield        ru/rockstar/client/ui/altmanager/GuiAddAlt.username:Lnet/minecraft/client/gui/GuiTextField;
        //    41: invokevirtual   net/minecraft/client/gui/GuiTextField.getText:()Ljava/lang/String;
        //    44: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //    45: getfield        ru/rockstar/client/ui/altmanager/GuiAddAlt.password:Lru/rockstar/client/ui/altmanager/PasswordField;
        //    48: invokevirtual   ru/rockstar/client/ui/altmanager/PasswordField.getText:()Ljava/lang/String;
        //    51: invokespecial   ru/rockstar/client/ui/altmanager/GuiAddAlt$AddAltThread.<init>:(Lru/rockstar/client/ui/altmanager/GuiAddAlt;Ljava/lang/String;Ljava/lang/String;)V
        //    54: astore_2        /* lllllllllllIllIIIIIlIIlIlllllIIl */
        //    55: aload_2         /* lllllllllllIllIIIIIlIIllIIIIIIII */
        //    56: invokevirtual   ru/rockstar/client/ui/altmanager/GuiAddAlt$AddAltThread.start:()V
        //    59: goto            137
        //    62: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //    63: getfield        ru/rockstar/client/ui/altmanager/GuiAddAlt.mc:Lnet/minecraft/client/Minecraft;
        //    66: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //    67: getfield        ru/rockstar/client/ui/altmanager/GuiAddAlt.manager:Lru/rockstar/client/ui/altmanager/GuiAltManager;
        //    70: invokevirtual   net/minecraft/client/Minecraft.displayGuiScreen:(Lnet/minecraft/client/gui/GuiScreen;)V
        //    73: goto            137
        //    76: invokestatic    java/awt/Toolkit.getDefaultToolkit:()Ljava/awt/Toolkit;
        //    79: invokevirtual   java/awt/Toolkit.getSystemClipboard:()Ljava/awt/datatransfer/Clipboard;
        //    82: getstatic       java/awt/datatransfer/DataFlavor.stringFlavor:Ljava/awt/datatransfer/DataFlavor;
        //    85: invokevirtual   java/awt/datatransfer/Clipboard.getData:(Ljava/awt/datatransfer/DataFlavor;)Ljava/lang/Object;
        //    88: checkcast       Ljava/lang/String;
        //    91: astore_3        /* lllllllllllIllIIIIIlIIlIllllllll */
        //    92: goto            98
        //    95: astore          lllllllllllIllIIIIIlIIlIllllllIl
        //    97: return         
        //    98: aload_3         /* lllllllllllIllIIIIIlIIlIlllllllI */
        //    99: ldc             ":"
        //   101: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   104: ifeq            137
        //   107: aload_3         /* lllllllllllIllIIIIIlIIlIlllllllI */
        //   108: ldc             ":"
        //   110: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   113: astore          lllllllllllIllIIIIIlIIlIllllllII
        //   115: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //   116: getfield        ru/rockstar/client/ui/altmanager/GuiAddAlt.username:Lnet/minecraft/client/gui/GuiTextField;
        //   119: aload           lllllllllllIllIIIIIlIIlIllllllII
        //   121: iconst_0       
        //   122: aaload         
        //   123: invokevirtual   net/minecraft/client/gui/GuiTextField.setText:(Ljava/lang/String;)V
        //   126: aload_0         /* lllllllllllIllIIIIIlIIllIIIIIIlI */
        //   127: getfield        ru/rockstar/client/ui/altmanager/GuiAddAlt.password:Lru/rockstar/client/ui/altmanager/PasswordField;
        //   130: aload           lllllllllllIllIIIIIlIIlIllllllII
        //   132: iconst_1       
        //   133: aaload         
        //   134: invokevirtual   ru/rockstar/client/ui/altmanager/PasswordField.setText:(Ljava/lang/String;)V
        //   137: return         
        //    StackMapTable: 00 06 20 1D 0D 52 07 00 A6 FD 00 02 00 07 00 7C F9 00 26
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  76     92     95     98     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiAltButton(0, this.width / 2 - 100, this.height / 4 + 92 + 12, "Login"));
        this.buttonList.add(new GuiAltButton(1, this.width / 2 - 100, this.height / 4 + 116 + 12, "Back"));
        this.buttonList.add(new GuiAltButton(2, this.width / 2 - 100, this.height / 4 + 92 - 12, "Import User:Pass"));
        this.username = new GuiTextField(this.eventButton, Minecraft.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.password = new PasswordField(Minecraft.fontRendererObj, this.width / 2 - 100, 100, 200, 20);
    }
    
    GuiAddAlt(final GuiAltManager lllllllllllIllIIIIIlIIllIIIlIIII) {
        this.status = TextFormatting.GRAY + "Idle...";
        this.manager = lllllllllllIllIIIIIlIIllIIIlIIII;
    }
    
    private static void setStatus(final GuiAddAlt lllllllllllIllIIIIIlIIllIIIIlIll, final String lllllllllllIllIIIIIlIIllIIIIlIII) {
        lllllllllllIllIIIIIlIIllIIIIlIll.status = lllllllllllIllIIIIIlIIllIIIIlIII;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllIllIIIIIlIIlIllIllIII, final int lllllllllllIllIIIIIlIIlIllIlIlll, final int lllllllllllIllIIIIIlIIlIllIlIllI) {
        try {
            super.mouseClicked(lllllllllllIllIIIIIlIIlIllIllIII, lllllllllllIllIIIIIlIIlIllIlIlll, lllllllllllIllIIIIIlIIlIllIlIllI);
        }
        catch (IOException lllllllllllIllIIIIIlIIlIllIlIlIl) {
            lllllllllllIllIIIIIlIIlIllIlIlIl.printStackTrace();
        }
        this.username.mouseClicked(lllllllllllIllIIIIIlIIlIllIllIII, lllllllllllIllIIIIIlIIlIllIlIlll, lllllllllllIllIIIIIlIIlIllIlIllI);
        this.password.mouseClicked(lllllllllllIllIIIIIlIIlIllIllIII, lllllllllllIllIIIIIlIIlIllIlIlll, lllllllllllIllIIIIIlIIlIllIlIllI);
    }
    
    private class AddAltThread extends Thread
    {
        private final /* synthetic */ String password;
        private final /* synthetic */ String username;
        
        @Override
        public void run() {
            if (this.password.equals("")) {
                AltManager.registry.add(new Alt(this.username, ""));
                setStatus(GuiAddAlt.this, TextFormatting.GREEN + "Added alt - " + ChatFormatting.RED + this.username + ChatFormatting.BOLD + "(non license)");
            }
            else {
                setStatus(GuiAddAlt.this, TextFormatting.AQUA + "Trying connect...");
                this.checkAndAddAlt(this.username, this.password);
            }
        }
        
        AddAltThread(final String llllllllllllIIlIllIIIlIllIllllIl, final String llllllllllllIIlIllIIIlIllIllllII) {
            this.username = llllllllllllIIlIllIIIlIllIllllIl;
            this.password = llllllllllllIIlIllIIIlIllIllllII;
            setStatus(GuiAddAlt.this, TextFormatting.GRAY + "Idle...");
        }
        
        private void checkAndAddAlt(final String llllllllllllIIlIllIIIlIllIlIllIl, final String llllllllllllIIlIllIIIlIllIllIIll) {
            try {
                final YggdrasilAuthenticationService llllllllllllIIlIllIIIlIllIllIIlI = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
                final YggdrasilUserAuthentication llllllllllllIIlIllIIIlIllIllIIIl = (YggdrasilUserAuthentication)llllllllllllIIlIllIIIlIllIllIIlI.createUserAuthentication(Agent.MINECRAFT);
                llllllllllllIIlIllIIIlIllIllIIIl.setUsername(llllllllllllIIlIllIIIlIllIlIllIl);
                llllllllllllIIlIllIIIlIllIllIIIl.setPassword(llllllllllllIIlIllIIIlIllIllIIll);
                try {
                    try {
                        Main.instance.fileManager.getFile(AltConfig.class).saveFile();
                    }
                    catch (Exception ex) {}
                    llllllllllllIIlIllIIIlIllIllIIIl.logIn();
                    AltManager.registry.add(new Alt(llllllllllllIIlIllIIIlIllIlIllIl, llllllllllllIIlIllIIIlIllIllIIll, llllllllllllIIlIllIIIlIllIllIIIl.getSelectedProfile().getName(), Alt.Status.Working));
                    setStatus(GuiAddAlt.this, TextFormatting.GREEN + "Added alt - " + ChatFormatting.RED + this.username + ChatFormatting.BOLD + "(license)");
                }
                catch (AuthenticationException llllllllllllIIlIllIIIlIllIllIIII) {
                    setStatus(GuiAddAlt.this, TextFormatting.RED + "Connect failed!");
                    llllllllllllIIlIllIIIlIllIllIIII.printStackTrace();
                }
            }
            catch (Throwable llllllllllllIIlIllIIIlIllIlIllll) {
                setStatus(GuiAddAlt.this, TextFormatting.RED + "Error");
                llllllllllllIIlIllIIIlIllIlIllll.printStackTrace();
            }
        }
    }
}

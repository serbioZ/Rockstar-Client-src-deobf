// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.util.text.event.ClickEvent;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemWrittenBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.Unpooled;
import javax.annotation.Nullable;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;
import net.minecraft.util.text.TextFormatting;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;

public class GuiScreenBook extends GuiScreen
{
    private /* synthetic */ GuiButton buttonDone;
    private /* synthetic */ NextPageButton buttonPreviousPage;
    private /* synthetic */ GuiButton buttonCancel;
    private /* synthetic */ GuiButton buttonFinalize;
    private /* synthetic */ NextPageButton buttonNextPage;
    private /* synthetic */ int currPage;
    private /* synthetic */ int bookTotalPages;
    private /* synthetic */ int cachedPage;
    private static final /* synthetic */ ResourceLocation BOOK_GUI_TEXTURES;
    private final /* synthetic */ boolean bookIsUnsigned;
    private final /* synthetic */ ItemStack bookObj;
    private /* synthetic */ GuiButton buttonSign;
    private /* synthetic */ boolean bookIsModified;
    private /* synthetic */ String bookTitle;
    private /* synthetic */ boolean bookGettingSigned;
    private final /* synthetic */ EntityPlayer editingPlayer;
    private /* synthetic */ List<ITextComponent> cachedComponents;
    private /* synthetic */ NBTTagList bookPages;
    private /* synthetic */ int updateCount;
    
    private void pageSetCurrent(final String llllllllllllIIlIlIlIlIlIllIllIII) {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
            this.bookPages.set(this.currPage, new NBTTagString(llllllllllllIIlIlIlIlIlIllIllIII));
            this.bookIsModified = true;
        }
    }
    
    private void addNewPage() {
        if (this.bookPages != null && this.bookPages.tagCount() < 50) {
            this.bookPages.appendTag(new NBTTagString(""));
            ++this.bookTotalPages;
            this.bookIsModified = true;
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllIIlIlIlIlIlIlllllIlI, final int llllllllllllIIlIlIlIlIlIlllllIIl) throws IOException {
        super.keyTyped(llllllllllllIIlIlIlIlIlIlllllIlI, llllllllllllIIlIlIlIlIlIlllllIIl);
        if (this.bookIsUnsigned) {
            if (this.bookGettingSigned) {
                this.keyTypedInTitle(llllllllllllIIlIlIlIlIlIlllllIlI, llllllllllllIIlIlIlIlIlIlllllIIl);
            }
            else {
                this.keyTypedInBook(llllllllllllIIlIlIlIlIlIlllllIlI, llllllllllllIIlIlIlIlIlIlllllIIl);
            }
        }
    }
    
    private String pageGetCurrent() {
        return (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) ? this.bookPages.getStringTagAt(this.currPage) : "";
    }
    
    private void pageInsertIntoCurrent(final String llllllllllllIIlIlIlIlIlIllIlIIIl) {
        final String llllllllllllIIlIlIlIlIlIllIlIIII = this.pageGetCurrent();
        final String llllllllllllIIlIlIlIlIlIllIIllll = String.valueOf(llllllllllllIIlIlIlIlIlIllIlIIII) + llllllllllllIIlIlIlIlIlIllIlIIIl;
        final int llllllllllllIIlIlIlIlIlIllIIlllI = this.fontRendererObj.splitStringWidth(String.valueOf(llllllllllllIIlIlIlIlIlIllIIllll) + TextFormatting.BLACK + "_", 118);
        if (llllllllllllIIlIlIlIlIlIllIIlllI <= 128 && llllllllllllIIlIlIlIlIlIllIIllll.length() < 256) {
            this.pageSetCurrent(llllllllllllIIlIlIlIlIlIllIIllll);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        if (this.bookIsUnsigned) {
            this.buttonSign = this.addButton(new GuiButton(3, this.width / 2 - 100, 196, 98, 20, I18n.format("book.signButton", new Object[0])));
            this.buttonDone = this.addButton(new GuiButton(0, this.width / 2 + 2, 196, 98, 20, I18n.format("gui.done", new Object[0])));
            this.buttonFinalize = this.addButton(new GuiButton(5, this.width / 2 - 100, 196, 98, 20, I18n.format("book.finalizeButton", new Object[0])));
            this.buttonCancel = this.addButton(new GuiButton(4, this.width / 2 + 2, 196, 98, 20, I18n.format("gui.cancel", new Object[0])));
        }
        else {
            this.buttonDone = this.addButton(new GuiButton(0, this.width / 2 - 100, 196, 200, 20, I18n.format("gui.done", new Object[0])));
        }
        final int llllllllllllIIlIlIlIlIllIIIllllI = (this.width - 192) / 2;
        final int llllllllllllIIlIlIlIlIllIIIlllIl = 2;
        this.buttonNextPage = this.addButton(new NextPageButton(1, llllllllllllIIlIlIlIlIllIIIllllI + 120, 156, true));
        this.buttonPreviousPage = this.addButton(new NextPageButton(2, llllllllllllIIlIlIlIlIllIIIllllI + 38, 156, false));
        this.updateButtons();
    }
    
    public GuiScreenBook(final EntityPlayer llllllllllllIIlIlIlIlIllIIlIlIIl, final ItemStack llllllllllllIIlIlIlIlIllIIlIllIl, final boolean llllllllllllIIlIlIlIlIllIIlIIlll) {
        this.bookTotalPages = 1;
        this.bookTitle = "";
        this.cachedPage = -1;
        this.editingPlayer = llllllllllllIIlIlIlIlIllIIlIlIIl;
        this.bookObj = llllllllllllIIlIlIlIlIllIIlIllIl;
        this.bookIsUnsigned = llllllllllllIIlIlIlIlIllIIlIIlll;
        if (llllllllllllIIlIlIlIlIllIIlIllIl.hasTagCompound()) {
            final NBTTagCompound llllllllllllIIlIlIlIlIllIIlIlIll = llllllllllllIIlIlIlIlIllIIlIllIl.getTagCompound();
            this.bookPages = llllllllllllIIlIlIlIlIllIIlIlIll.getTagList("pages", 8).copy();
            this.bookTotalPages = this.bookPages.tagCount();
            if (this.bookTotalPages < 1) {
                this.bookTotalPages = 1;
            }
        }
        if (this.bookPages == null && llllllllllllIIlIlIlIlIllIIlIIlll) {
            this.bookPages = new NBTTagList();
            this.bookPages.appendTag(new NBTTagString(""));
            this.bookTotalPages = 1;
        }
    }
    
    @Nullable
    public ITextComponent getClickedComponentAt(final int llllllllllllIIlIlIlIlIlIIllIllII, final int llllllllllllIIlIlIlIlIlIIllIlIll) {
        if (this.cachedComponents == null) {
            return null;
        }
        final int llllllllllllIIlIlIlIlIlIIllIlIlI = llllllllllllIIlIlIlIlIlIIllIllII - (this.width - 192) / 2 - 36;
        final int llllllllllllIIlIlIlIlIlIIllIlIIl = llllllllllllIIlIlIlIlIlIIllIlIll - 2 - 16 - 16;
        if (llllllllllllIIlIlIlIlIlIIllIlIlI < 0 || llllllllllllIIlIlIlIlIlIIllIlIIl < 0) {
            return null;
        }
        final int llllllllllllIIlIlIlIlIlIIllIlIII = Math.min(128 / this.fontRendererObj.FONT_HEIGHT, this.cachedComponents.size());
        if (llllllllllllIIlIlIlIlIlIIllIlIlI <= 116 && llllllllllllIIlIlIlIlIlIIllIlIIl < Minecraft.fontRendererObj.FONT_HEIGHT * llllllllllllIIlIlIlIlIlIIllIlIII + llllllllllllIIlIlIlIlIlIIllIlIII) {
            final int llllllllllllIIlIlIlIlIlIIllIIlll = llllllllllllIIlIlIlIlIlIIllIlIIl / Minecraft.fontRendererObj.FONT_HEIGHT;
            if (llllllllllllIIlIlIlIlIlIIllIIlll >= 0 && llllllllllllIIlIlIlIlIlIIllIIlll < this.cachedComponents.size()) {
                final ITextComponent llllllllllllIIlIlIlIlIlIIllIIllI = this.cachedComponents.get(llllllllllllIIlIlIlIlIlIIllIIlll);
                int llllllllllllIIlIlIlIlIlIIllIIlIl = 0;
                for (final ITextComponent llllllllllllIIlIlIlIlIlIIllIIlII : llllllllllllIIlIlIlIlIlIIllIIllI) {
                    if (llllllllllllIIlIlIlIlIlIIllIIlII instanceof TextComponentString) {
                        llllllllllllIIlIlIlIlIlIIllIIlIl += Minecraft.fontRendererObj.getStringWidth(((TextComponentString)llllllllllllIIlIlIlIlIlIIllIIlII).getText());
                        if (llllllllllllIIlIlIlIlIlIIllIIlIl > llllllllllllIIlIlIlIlIlIIllIlIlI) {
                            return llllllllllllIIlIlIlIlIlIIllIIlII;
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    private void sendBookToServer(final boolean llllllllllllIIlIlIlIlIllIIIIlIlI) throws IOException {
        if (this.bookIsUnsigned && this.bookIsModified && this.bookPages != null) {
            while (this.bookPages.tagCount() > 1) {
                final String llllllllllllIIlIlIlIlIllIIIIllll = this.bookPages.getStringTagAt(this.bookPages.tagCount() - 1);
                if (!llllllllllllIIlIlIlIlIllIIIIllll.isEmpty()) {
                    break;
                }
                this.bookPages.removeTag(this.bookPages.tagCount() - 1);
            }
            if (this.bookObj.hasTagCompound()) {
                final NBTTagCompound llllllllllllIIlIlIlIlIllIIIIlllI = this.bookObj.getTagCompound();
                llllllllllllIIlIlIlIlIllIIIIlllI.setTag("pages", this.bookPages);
            }
            else {
                this.bookObj.setTagInfo("pages", this.bookPages);
            }
            String llllllllllllIIlIlIlIlIllIIIIllIl = "MC|BEdit";
            if (llllllllllllIIlIlIlIlIllIIIIlIlI) {
                llllllllllllIIlIlIlIlIllIIIIllIl = "MC|BSign";
                this.bookObj.setTagInfo("author", new NBTTagString(this.editingPlayer.getName()));
                this.bookObj.setTagInfo("title", new NBTTagString(this.bookTitle.trim()));
            }
            final PacketBuffer llllllllllllIIlIlIlIlIllIIIIllII = new PacketBuffer(Unpooled.buffer());
            llllllllllllIIlIlIlIlIllIIIIllII.writeItemStackToBuffer(this.bookObj);
            this.mc.getConnection().sendPacket(new CPacketCustomPayload(llllllllllllIIlIlIlIlIllIIIIllIl, llllllllllllIIlIlIlIlIllIIIIllII));
        }
    }
    
    private void updateButtons() {
        this.buttonNextPage.visible = (!this.bookGettingSigned && (this.currPage < this.bookTotalPages - 1 || this.bookIsUnsigned));
        this.buttonPreviousPage.visible = (!this.bookGettingSigned && this.currPage > 0);
        this.buttonDone.visible = (!this.bookIsUnsigned || !this.bookGettingSigned);
        if (this.bookIsUnsigned) {
            this.buttonSign.visible = !this.bookGettingSigned;
            this.buttonCancel.visible = this.bookGettingSigned;
            this.buttonFinalize.visible = this.bookGettingSigned;
            this.buttonFinalize.enabled = !this.bookTitle.trim().isEmpty();
        }
    }
    
    private void keyTypedInTitle(final char llllllllllllIIlIlIlIlIlIlllIIIlI, final int llllllllllllIIlIlIlIlIlIlllIIlII) throws IOException {
        switch (llllllllllllIIlIlIlIlIlIlllIIlII) {
            case 14: {
                if (!this.bookTitle.isEmpty()) {
                    this.bookTitle = this.bookTitle.substring(0, this.bookTitle.length() - 1);
                    this.updateButtons();
                }
            }
            case 28:
            case 156: {
                if (!this.bookTitle.isEmpty()) {
                    this.sendBookToServer(true);
                    this.mc.displayGuiScreen(null);
                }
            }
            default: {
                if (this.bookTitle.length() < 16 && ChatAllowedCharacters.isAllowedCharacter(llllllllllllIIlIlIlIlIlIlllIIIlI)) {
                    this.bookTitle = String.valueOf(this.bookTitle) + Character.toString(llllllllllllIIlIlIlIlIlIlllIIIlI);
                    this.updateButtons();
                    this.bookIsModified = true;
                }
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllIIlIlIlIlIllIIIIIIlI) throws IOException {
        if (llllllllllllIIlIlIlIlIllIIIIIIlI.enabled) {
            if (llllllllllllIIlIlIlIlIllIIIIIIlI.id == 0) {
                this.mc.displayGuiScreen(null);
                this.sendBookToServer(false);
            }
            else if (llllllllllllIIlIlIlIlIllIIIIIIlI.id == 3 && this.bookIsUnsigned) {
                this.bookGettingSigned = true;
            }
            else if (llllllllllllIIlIlIlIlIllIIIIIIlI.id == 1) {
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                }
                else if (this.bookIsUnsigned) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
            }
            else if (llllllllllllIIlIlIlIlIllIIIIIIlI.id == 2) {
                if (this.currPage > 0) {
                    --this.currPage;
                }
            }
            else if (llllllllllllIIlIlIlIlIllIIIIIIlI.id == 5 && this.bookGettingSigned) {
                this.sendBookToServer(true);
                this.mc.displayGuiScreen(null);
            }
            else if (llllllllllllIIlIlIlIlIllIIIIIIlI.id == 4 && this.bookGettingSigned) {
                this.bookGettingSigned = false;
            }
            this.updateButtons();
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllIIlIlIlIlIlIlIIlIIIl, final int llllllllllllIIlIlIlIlIlIlIIlIIII, final int llllllllllllIIlIlIlIlIlIlIIIllll) throws IOException {
        if (llllllllllllIIlIlIlIlIlIlIIIllll == 0) {
            final ITextComponent llllllllllllIIlIlIlIlIlIlIIIlllI = this.getClickedComponentAt(llllllllllllIIlIlIlIlIlIlIIlIIIl, llllllllllllIIlIlIlIlIlIlIIlIIII);
            if (llllllllllllIIlIlIlIlIlIlIIIlllI != null && this.handleComponentClick(llllllllllllIIlIlIlIlIlIlIIIlllI)) {
                return;
            }
        }
        super.mouseClicked(llllllllllllIIlIlIlIlIlIlIIlIIIl, llllllllllllIIlIlIlIlIlIlIIlIIII, llllllllllllIIlIlIlIlIlIlIIIllll);
    }
    
    @Override
    public void drawScreen(final int llllllllllllIIlIlIlIlIlIlIlIIIll, final int llllllllllllIIlIlIlIlIlIlIlIIIlI, final float llllllllllllIIlIlIlIlIlIlIlllIII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenBook.BOOK_GUI_TEXTURES);
        final int llllllllllllIIlIlIlIlIlIlIllIlll = (this.width - 192) / 2;
        final int llllllllllllIIlIlIlIlIlIlIllIllI = 2;
        this.drawTexturedModalRect(llllllllllllIIlIlIlIlIlIlIllIlll, 2, 0, 0, 192, 192);
        if (this.bookGettingSigned) {
            String llllllllllllIIlIlIlIlIlIlIllIlIl = this.bookTitle;
            if (this.bookIsUnsigned) {
                if (this.updateCount / 6 % 2 == 0) {
                    llllllllllllIIlIlIlIlIlIlIllIlIl = String.valueOf(llllllllllllIIlIlIlIlIlIlIllIlIl) + TextFormatting.BLACK + "_";
                }
                else {
                    llllllllllllIIlIlIlIlIlIlIllIlIl = String.valueOf(llllllllllllIIlIlIlIlIlIlIllIlIl) + TextFormatting.GRAY + "_";
                }
            }
            final String llllllllllllIIlIlIlIlIlIlIllIlII = I18n.format("book.editTitle", new Object[0]);
            final int llllllllllllIIlIlIlIlIlIlIllIIll = this.fontRendererObj.getStringWidth(llllllllllllIIlIlIlIlIlIlIllIlII);
            this.fontRendererObj.drawString(llllllllllllIIlIlIlIlIlIlIllIlII, (float)(llllllllllllIIlIlIlIlIlIlIllIlll + 36 + (116 - llllllllllllIIlIlIlIlIlIlIllIIll) / 2), 34.0f, 0);
            final int llllllllllllIIlIlIlIlIlIlIllIIlI = this.fontRendererObj.getStringWidth(llllllllllllIIlIlIlIlIlIlIllIlIl);
            this.fontRendererObj.drawString(llllllllllllIIlIlIlIlIlIlIllIlIl, (float)(llllllllllllIIlIlIlIlIlIlIllIlll + 36 + (116 - llllllllllllIIlIlIlIlIlIlIllIIlI) / 2), 50.0f, 0);
            final String llllllllllllIIlIlIlIlIlIlIllIIIl = I18n.format("book.byAuthor", this.editingPlayer.getName());
            final int llllllllllllIIlIlIlIlIlIlIllIIII = this.fontRendererObj.getStringWidth(llllllllllllIIlIlIlIlIlIlIllIIIl);
            this.fontRendererObj.drawString(TextFormatting.DARK_GRAY + llllllllllllIIlIlIlIlIlIlIllIIIl, (float)(llllllllllllIIlIlIlIlIlIlIllIlll + 36 + (116 - llllllllllllIIlIlIlIlIlIlIllIIII) / 2), 60.0f, 0);
            final String llllllllllllIIlIlIlIlIlIlIlIllll = I18n.format("book.finalizeWarning", new Object[0]);
            this.fontRendererObj.drawSplitString(llllllllllllIIlIlIlIlIlIlIlIllll, llllllllllllIIlIlIlIlIlIlIllIlll + 36, 82, 116, 0);
        }
        else {
            final String llllllllllllIIlIlIlIlIlIlIlIlllI = I18n.format("book.pageIndicator", this.currPage + 1, this.bookTotalPages);
            String llllllllllllIIlIlIlIlIlIlIlIllIl = "";
            if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
                llllllllllllIIlIlIlIlIlIlIlIllIl = this.bookPages.getStringTagAt(this.currPage);
            }
            if (this.bookIsUnsigned) {
                if (this.fontRendererObj.getBidiFlag()) {
                    llllllllllllIIlIlIlIlIlIlIlIllIl = String.valueOf(llllllllllllIIlIlIlIlIlIlIlIllIl) + "_";
                }
                else if (this.updateCount / 6 % 2 == 0) {
                    llllllllllllIIlIlIlIlIlIlIlIllIl = String.valueOf(llllllllllllIIlIlIlIlIlIlIlIllIl) + TextFormatting.BLACK + "_";
                }
                else {
                    llllllllllllIIlIlIlIlIlIlIlIllIl = String.valueOf(llllllllllllIIlIlIlIlIlIlIlIllIl) + TextFormatting.GRAY + "_";
                }
            }
            else if (this.cachedPage != this.currPage) {
                if (ItemWrittenBook.validBookTagContents(this.bookObj.getTagCompound())) {
                    try {
                        final ITextComponent llllllllllllIIlIlIlIlIlIlIlIllII = ITextComponent.Serializer.jsonToComponent(llllllllllllIIlIlIlIlIlIlIlIllIl);
                        this.cachedComponents = ((llllllllllllIIlIlIlIlIlIlIlIllII != null) ? GuiUtilRenderComponents.splitText(llllllllllllIIlIlIlIlIlIlIlIllII, 116, this.fontRendererObj, true, true) : null);
                    }
                    catch (JsonParseException llllllllllllIIlIlIlIlIlIlIlIlIll) {
                        this.cachedComponents = null;
                    }
                }
                else {
                    final TextComponentString llllllllllllIIlIlIlIlIlIlIlIlIlI = new TextComponentString(TextFormatting.DARK_RED + "* Invalid book tag *");
                    this.cachedComponents = (List<ITextComponent>)Lists.newArrayList((Iterable)llllllllllllIIlIlIlIlIlIlIlIlIlI);
                }
                this.cachedPage = this.currPage;
            }
            final int llllllllllllIIlIlIlIlIlIlIlIlIIl = this.fontRendererObj.getStringWidth(llllllllllllIIlIlIlIlIlIlIlIlllI);
            this.fontRendererObj.drawString(llllllllllllIIlIlIlIlIlIlIlIlllI, (float)(llllllllllllIIlIlIlIlIlIlIllIlll - llllllllllllIIlIlIlIlIlIlIlIlIIl + 192 - 44), 18.0f, 0);
            if (this.cachedComponents == null) {
                this.fontRendererObj.drawSplitString(llllllllllllIIlIlIlIlIlIlIlIllIl, llllllllllllIIlIlIlIlIlIlIllIlll + 36, 34, 116, 0);
            }
            else {
                for (int llllllllllllIIlIlIlIlIlIlIlIlIII = Math.min(128 / this.fontRendererObj.FONT_HEIGHT, this.cachedComponents.size()), llllllllllllIIlIlIlIlIlIlIlIIlll = 0; llllllllllllIIlIlIlIlIlIlIlIIlll < llllllllllllIIlIlIlIlIlIlIlIlIII; ++llllllllllllIIlIlIlIlIlIlIlIIlll) {
                    final ITextComponent llllllllllllIIlIlIlIlIlIlIlIIllI = this.cachedComponents.get(llllllllllllIIlIlIlIlIlIlIlIIlll);
                    this.fontRendererObj.drawString(llllllllllllIIlIlIlIlIlIlIlIIllI.getUnformattedText(), (float)(llllllllllllIIlIlIlIlIlIlIllIlll + 36), (float)(34 + llllllllllllIIlIlIlIlIlIlIlIIlll * this.fontRendererObj.FONT_HEIGHT), 0);
                }
                final ITextComponent llllllllllllIIlIlIlIlIlIlIlIIlIl = this.getClickedComponentAt(llllllllllllIIlIlIlIlIlIlIlIIIll, llllllllllllIIlIlIlIlIlIlIlIIIlI);
                if (llllllllllllIIlIlIlIlIlIlIlIIlIl != null) {
                    this.handleComponentHover(llllllllllllIIlIlIlIlIlIlIlIIlIl, llllllllllllIIlIlIlIlIlIlIlIIIll, llllllllllllIIlIlIlIlIlIlIlIIIlI);
                }
            }
        }
        super.drawScreen(llllllllllllIIlIlIlIlIlIlIlIIIll, llllllllllllIIlIlIlIlIlIlIlIIIlI, llllllllllllIIlIlIlIlIlIlIlllIII);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.updateCount;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        BOOK_GUI_TEXTURES = new ResourceLocation("textures/gui/book.png");
    }
    
    @Override
    public boolean handleComponentClick(final ITextComponent llllllllllllIIlIlIlIlIlIlIIIIIlI) {
        final ClickEvent llllllllllllIIlIlIlIlIlIlIIIIIIl = llllllllllllIIlIlIlIlIlIlIIIIIlI.getStyle().getClickEvent();
        if (llllllllllllIIlIlIlIlIlIlIIIIIIl == null) {
            return false;
        }
        if (llllllllllllIIlIlIlIlIlIlIIIIIIl.getAction() == ClickEvent.Action.CHANGE_PAGE) {
            final String llllllllllllIIlIlIlIlIlIlIIIIIII = llllllllllllIIlIlIlIlIlIlIIIIIIl.getValue();
            try {
                final int llllllllllllIIlIlIlIlIlIIlllllll = Integer.parseInt(llllllllllllIIlIlIlIlIlIlIIIIIII) - 1;
                if (llllllllllllIIlIlIlIlIlIIlllllll >= 0 && llllllllllllIIlIlIlIlIlIIlllllll < this.bookTotalPages && llllllllllllIIlIlIlIlIlIIlllllll != this.currPage) {
                    this.currPage = llllllllllllIIlIlIlIlIlIIlllllll;
                    this.updateButtons();
                    return true;
                }
            }
            catch (Throwable t) {}
            return false;
        }
        final boolean llllllllllllIIlIlIlIlIlIIllllllI = super.handleComponentClick(llllllllllllIIlIlIlIlIlIlIIIIIlI);
        if (llllllllllllIIlIlIlIlIlIIllllllI && llllllllllllIIlIlIlIlIlIlIIIIIIl.getAction() == ClickEvent.Action.RUN_COMMAND) {
            this.mc.displayGuiScreen(null);
        }
        return llllllllllllIIlIlIlIlIlIIllllllI;
    }
    
    private void keyTypedInBook(final char llllllllllllIIlIlIlIlIlIllllIIII, final int llllllllllllIIlIlIlIlIlIlllIlIll) {
        if (GuiScreen.isKeyComboCtrlV(llllllllllllIIlIlIlIlIlIlllIlIll)) {
            this.pageInsertIntoCurrent(GuiScreen.getClipboardString());
        }
        else {
            switch (llllllllllllIIlIlIlIlIlIlllIlIll) {
                case 14: {
                    final String llllllllllllIIlIlIlIlIlIlllIlllI = this.pageGetCurrent();
                    if (!llllllllllllIIlIlIlIlIlIlllIlllI.isEmpty()) {
                        this.pageSetCurrent(llllllllllllIIlIlIlIlIlIlllIlllI.substring(0, llllllllllllIIlIlIlIlIlIlllIlllI.length() - 1));
                    }
                }
                case 28:
                case 156: {
                    this.pageInsertIntoCurrent("\n");
                }
                default: {
                    if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllIIlIlIlIlIlIllllIIII)) {
                        this.pageInsertIntoCurrent(Character.toString(llllllllllllIIlIlIlIlIlIllllIIII));
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    static class NextPageButton extends GuiButton
    {
        private final /* synthetic */ boolean isForward;
        
        public NextPageButton(final int llllllllllllIlIIlIIllIIIIIlIIllI, final int llllllllllllIlIIlIIllIIIIIlIIlIl, final int llllllllllllIlIIlIIllIIIIIlIlIIl, final boolean llllllllllllIlIIlIIllIIIIIlIIIll) {
            super(llllllllllllIlIIlIIllIIIIIlIIllI, llllllllllllIlIIlIIllIIIIIlIIlIl, llllllllllllIlIIlIIllIIIIIlIlIIl, 23, 13, "");
            this.isForward = llllllllllllIlIIlIIllIIIIIlIIIll;
        }
        
        public void func_191745_a(final Minecraft llllllllllllIlIIlIIllIIIIIIlIIlI, final int llllllllllllIlIIlIIllIIIIIIllIIl, final int llllllllllllIlIIlIIllIIIIIIllIII, final float llllllllllllIlIIlIIllIIIIIIlIlll) {
            if (this.visible) {
                final boolean llllllllllllIlIIlIIllIIIIIIlIllI = llllllllllllIlIIlIIllIIIIIIllIIl >= this.xPosition && llllllllllllIlIIlIIllIIIIIIllIII >= this.yPosition && llllllllllllIlIIlIIllIIIIIIllIIl < this.xPosition + this.width && llllllllllllIlIIlIIllIIIIIIllIII < this.yPosition + this.height;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                llllllllllllIlIIlIIllIIIIIIlIIlI.getTextureManager().bindTexture(GuiScreenBook.BOOK_GUI_TEXTURES);
                int llllllllllllIlIIlIIllIIIIIIlIlIl = 0;
                int llllllllllllIlIIlIIllIIIIIIlIlII = 192;
                if (llllllllllllIlIIlIIllIIIIIIlIllI) {
                    llllllllllllIlIIlIIllIIIIIIlIlIl += 23;
                }
                if (!this.isForward) {
                    llllllllllllIlIIlIIllIIIIIIlIlII += 13;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllIlIIlIIllIIIIIIlIlIl, llllllllllllIlIIlIIllIIIIIIlIlII, 23, 13);
            }
        }
    }
}

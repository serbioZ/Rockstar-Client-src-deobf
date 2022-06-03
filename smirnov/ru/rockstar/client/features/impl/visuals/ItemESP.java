// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.client.ui.settings.Setting;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class ItemESP extends Feature
{
    private /* synthetic */ BooleanSetting border;
    private /* synthetic */ ColorSetting borderColor;
    private /* synthetic */ BooleanSetting tag;
    
    @EventTarget
    public void onRender(final Event3D lllllllllllIIlIIIlIIIlIlIlIIIlll) {
        for (final Entity lllllllllllIIlIIIlIIIlIlIlIIllIl : ItemESP.mc.world.loadedEntityList) {
            if (!(lllllllllllIIlIIIlIIIlIlIlIIllIl instanceof EntityItem)) {
                continue;
            }
            final double lllllllllllIIlIIIlIIIlIlIlIIllII = lllllllllllIIlIIIlIIIlIlIlIIllIl.lastTickPosX + (lllllllllllIIlIIIlIIIlIlIlIIllIl.posX - lllllllllllIIlIIIlIIIlIlIlIIllIl.lastTickPosX) * lllllllllllIIlIIIlIIIlIlIlIIIlll.getPartialTicks() - RenderManager.renderPosX - 0.1;
            final double lllllllllllIIlIIIlIIIlIlIlIIlIll = lllllllllllIIlIIIlIIIlIlIlIIllIl.lastTickPosY + (lllllllllllIIlIIIlIIIlIlIlIIllIl.posY - lllllllllllIIlIIIlIIIlIlIlIIllIl.lastTickPosY) * lllllllllllIIlIIIlIIIlIlIlIIIlll.getPartialTicks() - RenderManager.renderPosY;
            final double lllllllllllIIlIIIlIIIlIlIlIIlIlI = lllllllllllIIlIIIlIIIlIlIlIIllIl.lastTickPosZ + (lllllllllllIIlIIIlIIIlIlIlIIllIl.posZ - lllllllllllIIlIIIlIIIlIlIlIIllIl.lastTickPosZ) * lllllllllllIIlIIIlIIIlIlIlIIIlll.getPartialTicks() - RenderManager.renderPosZ - 0.15;
            if (this.tag.getBoolValue()) {
                GL11.glPushMatrix();
                GL11.glDisable(2929);
                GL11.glDisable(3553);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.disableLighting();
                GlStateManager.enableBlend();
                final float lllllllllllIIlIIIlIIIlIlIlIIlIIl = Math.min(Math.max(1.2f * (Minecraft.getMinecraft().player.getDistanceToEntity(lllllllllllIIlIIIlIIIlIlIlIIllIl) * 0.15f), 1.25f), 6.0f) * 0.014f;
                GL11.glTranslatef((float)lllllllllllIIlIIIlIIIlIlIlIIllII, (float)lllllllllllIIlIIIlIIIlIlIlIIlIll + lllllllllllIIlIIIlIIIlIlIlIIllIl.height + 0.5f, (float)lllllllllllIIlIIIlIIIlIlIlIIlIlI);
                GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(-RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
                GL11.glScalef(-lllllllllllIIlIIIlIIIlIlIlIIlIIl, -lllllllllllIIlIIIlIIIlIlIlIIlIIl, lllllllllllIIlIIIlIIIlIlIlIIlIIl);
                Gui.drawRect(-Minecraft.fontRendererObj.getStringWidth(((EntityItem)lllllllllllIIlIIIlIIIlIlIlIIllIl).getEntityItem().getDisplayName()) / 2 - 2, -2.0, Minecraft.fontRendererObj.getStringWidth(((EntityItem)lllllllllllIIlIIIlIIIlIlIlIIllIl).getEntityItem().getDisplayName()) / 2 + 2, 9.0, Integer.MIN_VALUE);
                Minecraft.fontRendererObj.drawStringWithShadow(((EntityItem)lllllllllllIIlIIIlIIIlIlIlIIllIl).getEntityItem().getDisplayName(), (float)(-Minecraft.fontRendererObj.getStringWidth(((EntityItem)lllllllllllIIlIIIlIIIlIlIlIIllIl).getEntityItem().getDisplayName()) / 2), 0.0f, -1);
                GlStateManager.resetColor();
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GL11.glPopMatrix();
            }
            if (!this.border.getBoolValue()) {
                continue;
            }
            DrawHelper.drawEntityBox(lllllllllllIIlIIIlIIIlIlIlIIllIl, new Color(this.borderColor.getColorValue()), true, 0.2f);
        }
    }
    
    public ItemESP() {
        super("ItemESP", "\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0430\u0439\u0442\u0435\u043c\u043e\u0432", 0, Category.VISUALS);
        this.tag = new BooleanSetting("Tag", true, () -> true);
        this.border = new BooleanSetting("Full Box", true, () -> true);
        this.borderColor = new ColorSetting("Border Color", new Color(16777215).getRGB(), () -> this.border.getBoolValue());
        this.addSettings(this.tag, this.border, this.borderColor);
    }
}

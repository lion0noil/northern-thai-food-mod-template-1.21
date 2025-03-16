package net.lion.northernthaifoodmod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PotScreen extends HandledScreen<PotScreenHandler> {
    public static final Identifier GUI_TEXTURE =
            Identifier.of(NorthernThaiFoodMod.MOD_ID, "textures/gui/pot/pot_gui.png");
    public static final Identifier GUI_ARROW_TEXTURE =
            Identifier.of(NorthernThaiFoodMod.MOD_ID, "textures/gui/pot_arrow_progress.png");


    public PotScreen(PotScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Draw the progress arrow (Moving part of the arrow)
        //int progress = handler.getCookProgress(); // Get cooking progress from PotScreenHandler
        //context.drawTexture(GUI_ARROW_TEXTURE, x + 80, y + 28, 176, 14, progress, 16,24,16);


        renderProgressArrow(context,x,y);
    }
    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(GUI_ARROW_TEXTURE, x + 79, y + 30, 0, 0,
                    handler.getCookProgress(), 16, 24, 16);
        }
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context,mouseX,mouseY);
    }

}

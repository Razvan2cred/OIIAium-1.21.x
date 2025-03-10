package net.razvan.oiiamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.entity.custom.OiiaCatEntity;

public class OiiaCatRenderer extends MobRenderer<OiiaCatEntity, OiiaCatModel<OiiaCatEntity>> {
    public OiiaCatRenderer(EntityRendererProvider.Context context) {
        super(context, new OiiaCatModel<>(context.bakeLayer(OiiaCatModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(OiiaCatEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Oiia.MOD_ID, "textures/entity/oiiacat/oiiacat.png");
    }

    @Override
    public void render(OiiaCatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

package com.github.l4852.vanillablocks.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class PlayerInteraction {
    public static enum FullDirection {
        NORTHWEST,
        SOUTHWEST,
        SOUTHEAST,
        NORTHEAST,
        ERROR
    }

    FullDirection f = FullDirection.NORTHEAST;

    public static void sendChatMessage(String message) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        String messageString = (String) message;
        Text text = Text.of(messageString);

        player.sendMessage(text);
    }

    public static FullDirection getDirectionFromVec3d(Vec3d vec) {
        if (vec.x < 0 && vec.z < 0) {
            return FullDirection.NORTHWEST;
        } else if (vec.x < 0 && vec.z > 0) {
            return FullDirection.SOUTHWEST;
        } else if (vec.x > 0 && vec.z > 0) {
            return FullDirection.SOUTHEAST;
        } else if (vec.x > 0 && vec.z < 0) {
            return FullDirection.NORTHEAST;
        }
        return FullDirection.ERROR;
    }
}

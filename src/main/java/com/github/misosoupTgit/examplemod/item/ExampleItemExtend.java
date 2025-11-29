package com.github.misosoupTgit.examplemod.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleItemExtend extends Item {
    public ExampleItemExtend(Item.Properties itemProp) {
        super(itemProp);
    }

    @Override
    // ツールチップ 必要ない時は随時コメントアウト
    public void appendHoverText(@NotNull ItemStack stack, Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("詳細説明：これは特別なアイテムです").withStyle(ChatFormatting.GRAY));
        } else {
            components.add(Component.literal("Shiftを押すと詳細を表示").withStyle(ChatFormatting.DARK_GRAY));
        }
    }
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide) {
            player.sendSystemMessage(Component.literal("アイテムを使いました！"));
            // 体力を0に
            player.setHealth(0);
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
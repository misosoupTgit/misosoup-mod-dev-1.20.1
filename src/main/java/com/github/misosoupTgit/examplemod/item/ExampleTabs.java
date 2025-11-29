package com.github.misosoupTgit.examplemod.item;

import com.github.misosoupTgit.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExampleTabs {
    //レジストリを作成
    public static final DeferredRegister<CreativeModeTab>
            TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    //レジストリにタブを登録
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = TABS.register("example_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.example_tab"))
                    .icon(ExampleItems.EXAMPLE_ITEM.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ExampleItems.EXAMPLE_ITEM.get());
                        pOutput.accept(ExampleItems.EXAMPLE_ITEM_EXTEND.get());
                    }))
                    .build());
    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}

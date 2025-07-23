package com.github.misosoupTgit.examplemod.item;

import com.github.misosoupTgit.examplemod.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExampleItems {

    // レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    // レジストリにアイテムを追加
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new ExampleItem(new ExampleItem.Properties()

            // 耐久値の設定※ここを設定するとスタック数の上限が強制的に1になるため、stacksToは使用不可に
            .durability(50)

            // スタック数上限の設定
//            .stacksTo(16)

            // レアリティの指定 COMMON,UNCOMMON,RARE,EPICが使用可能
            .rarity(Rarity.RARE)

            // アイテムの火炎耐性 マグマや火に入っても消えなくなる
            .fireResistant()

            //

            // 食べれるかどうか、回復する満腹度や食事時のエフェクトなど
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(4)
                    .build())
            )
    );

    // レジストリに登録したアイテムをイベントバスに登録
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

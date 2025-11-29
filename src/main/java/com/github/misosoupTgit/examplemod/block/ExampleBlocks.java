package com.github.misosoupTgit.examplemod.block;

import com.github.misosoupTgit.examplemod.ExampleMod;
import com.github.misosoupTgit.examplemod.item.ExampleItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ExampleBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = registryBlockItem("example_block",() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
    //        .sound(SoundType.ANVIL);
            .destroyTime(0.2f)
//            .noLootTable()
    ));

    private static <T extends Block> RegistryObject<T> registryBlockItem(String name, Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ExampleItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

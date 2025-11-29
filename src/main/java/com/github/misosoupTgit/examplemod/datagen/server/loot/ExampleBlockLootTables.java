package com.github.misosoupTgit.examplemod.datagen.server.loot;

import com.github.misosoupTgit.examplemod.block.ExampleBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ExampleBlockLootTables extends BlockLootSubProvider {
    protected ExampleBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ExampleBlocks.EXAMPLE_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ExampleBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

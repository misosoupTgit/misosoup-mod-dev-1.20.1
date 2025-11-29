package com.github.misosoupTgit.examplemod.datagen.server;

import com.github.misosoupTgit.examplemod.ExampleMod;
import com.github.misosoupTgit.examplemod.block.ExampleBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ExampleBlockTagsProvider extends BlockTagsProvider {
    public ExampleBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ExampleBlocks.EXAMPLE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ExampleBlocks.EXAMPLE_BLOCK.get());
    }
}

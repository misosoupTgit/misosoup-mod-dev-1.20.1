package com.github.misosoupTgit.examplemod.datagen.server;

import com.github.misosoupTgit.examplemod.block.ExampleBlocks;
import com.github.misosoupTgit.examplemod.item.ExampleItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ExampleRecipeProvider extends RecipeProvider {
    public ExampleRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC,
                ExampleItems.EXAMPLE_ITEM.get(),
                RecipeCategory.MISC,
                ExampleBlocks.EXAMPLE_BLOCK.get());
    }

    protected static void nineBlockStorageRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  @NotNull RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  @NotNull RecipeCategory pPackedCategory,
                                                  ItemLike pPacked) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked).unlockedBy(getHasName(pPacked), has(pPacked)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer);
    }

}

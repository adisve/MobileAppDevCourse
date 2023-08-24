package com.example.lab_2.domain.model

data class Recipe(
    val title: String,
    val ingredients: List<IngredientPart>,
    val steps: List<Step>
)

data class IngredientPart(
    val part: String,
    val items: List<IngredientItem>
)

data class IngredientItem(
    val name: String,
    val amount: String,
    val notes: String? = null,
    val instructions: String? = null
)

data class Step(
    val number: Int,
    val instruction: String
)

val applePieRecipe = Recipe(
    title = "Apple Pie",
    ingredients = listOf(
        IngredientPart(
            part = "Crust",
            items = listOf(
                IngredientItem(
                    name = "Pillsbury™ Pie Crusts (2 Count)",
                    amount = "1 box (14.1 oz)",
                    instructions = "softened as directed on box"
                )
            )
        ),
        IngredientPart(
            part = "Filling",
            items = listOf(
                IngredientItem(name = "sliced, peeled apples", amount = "6 cups", notes = "(6 medium)"),
                IngredientItem(name = "sugar", amount = "3/4 cup"),
                IngredientItem(name = "all-purpose flour", amount = "2 tablespoons"),
                IngredientItem(name = "ground cinnamon", amount = "3/4 teaspoon"),
                IngredientItem(name = "salt", amount = "1/4 teaspoon"),
                IngredientItem(name = "ground nutmeg", amount = "1/8 teaspoon"),
                IngredientItem(name = "lemon juice", amount = "1 tablespoon")
            )
        )
    ),
    steps = listOf(
        Step(number = 1, instruction = "Heat oven to 425°F. Place 1 pie crust in ungreased 9-inch glass pie plate. Press firmly against side and bottom."),
        Step(number = 2, instruction = "In large bowl, gently mix filling ingredients; spoon into crust-lined pie plate. Top with second crust. Wrap excess top crust under bottom crust edge, pressing edges together to seal; flute. Cut slits or shapes in several places in top crust."),
        Step(number = 3, instruction = "Bake 40 to 45 minutes or until apples are tender and crust is golden brown. Cover edge of crust with 2- to 3-inch wide strips of foil after first 15 to 20 minutes of baking to prevent excessive browning. Cool on cooling rack at least 2 hours before serving.")
    )
)
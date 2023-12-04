package com.kot.dish.test_data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kot.dish.domain.*;
import com.kot.dish.repository.*;

@Component
@Profile("testdata")
public class DishesTestDataGenerator {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private LabelRepository labelRepository;

	@PostConstruct
	public void generateTestData() {
		buildAndSaveCategories();
		buildAndSaveIngredients();
		buildAndSaveDishes();
		buildAndSaveLabels();
	}

	private void buildAndSaveDishes() {
		createAndSaveDish("Hamburger",
				"Burger",
				BigDecimal.valueOf(2),
				"A hamburger is a type of sandwich consisting of a chopped patty served inside a sliced bun. In addition to meat, a hamburger can have a large number of different seasonings, for example: ketchup and mayonnaise, lettuce, pickled cucumber, cheese or fried onion, tomato.",
				"https://pngimg.com/uploads/burger_sandwich/burger_sandwich_PNG96787.png",
				this::getHamburgerRecipe
		);

		createAndSaveDish("Cheeseburger",
				"Burger",
				BigDecimal.valueOf(2.10),
				"A cheeseburger is a hamburger topped with cheese. Traditionally, the slice of cheese is placed on top of the meat patty. The cheese is usually added to the cooking hamburger patty shortly before serving, which allows the cheese to melt. Cheeseburgers can include variations in structure, ingredients and composition. As with other hamburgers, a cheeseburger may include toppings such as lettuce, tomato, onion, pickles, bacon, mayonnaise, ketchup, and mustard.",
				"https://www.mcdonalds.com.sg/sites/default/files/2023-02/1200x1200_MOP_BBPilot_Cheeseburger_1.png",
				this::getCheeseburgerRecipe
		);

		createAndSaveDish("Double burger",
				"Burger",
				BigDecimal.valueOf(3.50),
				"Although the legendary Double Burger really needs no introduction, please allow us... Tucked in between three soft buns are two all-beef patties, cheddar cheese, ketchup, onion, pickles and iceberg lettuce. Hesburger's own paprika and cucumber mayonnaise add the crowning touch. Oh baby!",
				"https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_600,h_600,dpr_2,f_auto,q_auto/v1621250831/oa_menu/products/menuproduct_burger_double-cheeseburger_sauce.png",
				this::getDoubleBurgerRecipe
		);

		createAndSaveDish("Mushroom burger",
				"Burger",
				BigDecimal.valueOf(3.00),
				"For the healthy and calorie conscious folks we've got this tasty burger. A lentil, mushroom and sun dried tomato pattie packed between a whole wheat bun.",
				"https://prairiepizzas.ca/wp-content/uploads/2020/07/swiss-mashroom-burger.png",
				this::getMushroomBurgerRecipe
		);

		createAndSaveDish("Bacon Cheeseburger",
				"Burger",
				BigDecimal.valueOf(3.50),
				"This burger takes things to the next level with crispy bacon and melted cheese on top of a juicy patty.",
				"https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_600,h_600,dpr_2,f_auto,q_auto/v1633113774/oa_menu/products/menuthumbnail_burger_bacon-cheeseburger.png",
				this::getBaconCheeseburgerRecipe
		);

		createAndSaveDish("Cheese Pizza",
				"Pizza",
				BigDecimal.valueOf(3.00),
				"It should be no shocker that a classic is the statistical favorite. Cheese pizza is one of the most popular choices. It will always be a simple, unadorned masterpiece on its own.",
				"https://www.cicis.com/media/d21b0xj1/mac-and-cheese-pizza.png",
				this::getCheesePizzaRecipe
		);

		createAndSaveDish("Veggie Pizza",
				"Pizza",
				BigDecimal.valueOf(3.00),
				"When you want to jazz up your cheese pizza with color and texture, veggies are the perfect topping. And you’re only limited by your imagination. Everything from peppers and mushrooms, to eggplant and onions make for an exciting and tasty veggie pizza.",
				"https://www.cicis.com/media/nctfaewb/veggie-pizza.png",
				this::getVeggiePizzaRecipe
		);

		createAndSaveDish("Pepperoni Pizza",
				"Pizza",
				BigDecimal.valueOf(2.80),
				"There’s a reason this is one of the most popular types of pizza. Who doesn’t love biting into a crispy, salty round of pepperoni?",
				"https://static.vecteezy.com/system/resources/previews/023/742/403/original/pepperoni-pizza-isolated-illustration-ai-generative-free-png.png",
				this::getPepperoniPizzaRecipe
		);

		createAndSaveDish("Margherita Pizza",
				"Pizza",
				BigDecimal.valueOf(3.05),
				"Deceptively simple, the Margherita pizza is made with basil, fresh mozzarella, and tomatoes. There’s a reason it’s an Italian staple and one of the most popular types of pizza in the country.",
				"https://jow.fr/_next/image?url=https%3A%2F%2Fstatic.jow.fr%2F880x880%2Frecipes%2Fa0Lk7trMz4MOyw.png&w=2560&q=100",
				this::getMargheritaPizzaRecipe
		);

		createAndSaveDish("Meat Lovers Pizza",
				"Pizza",
				BigDecimal.valueOf(4.00),
				"This pizza is loaded with pepperoni, sausage, bacon, and ham for a hearty and satisfying meal.",
				"https://littleceopizza.com/wp-content/uploads/2018/08/meat-600x600.png",
				this::getMeatLoversPizzaRecipe
		);

		createAndSaveDish("Latte",
				"Coffee",
				BigDecimal.valueOf(1.00),
				"This classic drink is typically 1/3 espresso and 2/3 steamed milk, topped with a thin layer of foam, but coffee shops have come up with seemingly endless customizations. You can experiment with flavored syrups like vanilla and pumpkin spice or create a nondairy version by using oat milk. Skilled baristas often swirl the foam into latte art!",
				"https://www.peets.com/cdn/shop/products/iced-latte.png?v=1597269390",
				this::getLatteRecipe
		);

		createAndSaveDish("Cappuccino",
				"Coffee",
				BigDecimal.valueOf(0.75),
				"This espresso-based drink is similar to a latte, but the frothy top layer is thicker. The standard ratio is equal parts espresso, steamed milk, and foam. It's often served in a 6-ounce cup (smaller than a latte cup) and can be topped with a sprinkling of cinnamon.",
				"https://cdn.shopify.com/s/files/1/0319/0764/3436/products/traditional-cappuccino.png?v=1597269389",
				this::getCappuccinoRecipe
		);

		createAndSaveDish("Americano",
				"Coffee",
				BigDecimal.valueOf(0.75),
				"Order this drink and you'll get a shot of espresso diluted with hot water.",
				"https://cdn.shopify.com/s/files/1/0319/0764/3436/products/caffe-americano.png?v=1597269387",
				this::getAmericanoRecipe
		);

		createAndSaveDish("Flat White",
				"Coffee",
				BigDecimal.valueOf(1.10),
				"Like the latte, this drink consists of espresso and steamed milk, but the ratio of espresso to milk is higher. Baristas also fold the milk as it steams, which creates a more velvety texture. The flat white has roots in Australia and New Zealand.",
				"https://grycan.pl/wp-content/uploads/2019/01/flathwhite.png",
				this::getFlatWhiteRecipe
		);

		createAndSaveDish("Iced Coffee",
				"Coffee",
				BigDecimal.valueOf(1.50),
				"A refreshing way to enjoy your coffee on a hot day. Brewed coffee poured over ice and served with your choice of cream and sugar.",
				"https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_600,h_600,dpr_2,f_auto,q_auto/v1603477512/oa_menu/products/menuproduct-coldbrew_2.png",
				this::getIcedCoffeeRecipe
		);

		createAndSaveDish("Breakfast Burrito",
				"Breakfast",
				BigDecimal.valueOf(4.00),
				"Start your day off right with this breakfast burrito filled with scrambled eggs, cheese, potatoes, and your choice of bacon or sausage.",
				"https://res.cloudinary.com/sonic-drive-in/image/upload/c_fit,w_600,h_600,dpr_2,f_auto,q_auto/v1622138834/oa_menu/products/menuproduct_breakfast_burrito-sausage-egg-cheese-jr.png",
				this::getBreakfastBurritoRecipe
		);

		createAndSaveDish("Pancakes",
				"Breakfast",
				BigDecimal.valueOf(3.00),
				"A classic breakfast dish, pancakes are made with a fluffy batter and served with butter and syrup. Add toppings like berries, whipped cream, or chocolate chips for a sweet twist.",
				"https://olo-images-live.imgix.net/16/1641973e8b0e465abb6227325d06f895.png?auto=format%2Ccompress&q=60&cs=tinysrgb&w=528&h=352&fit=crop&s=c4a385991717420f4eb66ab2bc08504c",
				this::getPancakesRecipe
		);

		createAndSaveDish("X-mas Waffles",
				"Christmas",
				BigDecimal.valueOf(3.00),
				"Christmas waffles are a festive variation of traditional waffles, often made during the holiday season. They are typically prepared using a waffle iron and feature ingredients such as seasonal spices like cinnamon, nutmeg, and ginger, along with additions like cranberries, chocolate chips, or a topping of whipped cream and berries. These waffles are enjoyed as a delightful and cozy treat during the Christmas celebrations.",
				"https://iili.io/JIJaehg.png",
				this::xMasWafflesRecipe
		);
	}

	private void createAndSaveDish(String name, String categoryName, BigDecimal price, String description, String imageUrl, Function<DishEntity, RecipeEntity> recipeProvider) {
		DishEntity dishEntity = new DishEntity();
		dishEntity.setName(name);
		dishEntity.setCategory(categoryRepository.findByName(categoryName));
		dishEntity.setPrice(price);
		dishEntity.setDescription(description);
		dishEntity.setImageUrl(imageUrl);
//		dishEntity = dishRepository.save(dishEntity);
//		dishEntity.setRecipe(recipeProvider.apply(dishEntity));
		dishRepository.save(dishEntity);
	}

	public void buildAndSaveCategories() {
//		Map<String, CategoryEntity> categories = new HashMap<>();
//		CategoryEntity sandwich = new CategoryEntity();
//		sandwich.setName("Burger");
//		sandwich.setDescription("A burger is a type of sandwich. It consists of two or more slices of bread (often a bun) and one or more layers of meat and other fillings. In big cities (especially in the West), the sandwich has become an integral part of the food culture.");
//		sandwich.setIconName("Burger");
//		categoryRepository.save(sandwich);
//
//		CategoryEntity pizza = new CategoryEntity();
//		pizza.setName("Pizza");
//		pizza.setDescription("Pizza is an Italian national dish, namely a flatbread, usually round in shape, which is covered with tomato paste and cheese and baked.");
//		pizza.setIconName("pizza");
//		categoryRepository.save(pizza);
//
//		CategoryEntity roll = new CategoryEntity();
//		roll.setName("Roll");
//		roll.setDescription("It is a dish made of pita bread, which is filled with chopped fried meat (lamb, beef, turkey or chicken; in Europe sometimes also pork) with the addition of seasonings, sauces and a salad of fresh vegetables");
//		roll.setIconName("roll");
//		categoryRepository.save(roll);
//
//		CategoryEntity coffee = new CategoryEntity();
//		coffee.setName("Coffee");
//		coffee.setDescription("Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain flowering plants in the Coffea genus. From the coffee fruit, the seeds are separated to produce a stable, raw product: unroasted green coffee. The seeds are then roasted, a process which transforms them into a consumable product: roasted coffee, which is ground into fine particles that are typically steeped in hot water before being filtered out, producing a cup of coffee.\n" +
//				"Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain flowering plants in the Coffea genus. From the coffee fruit, the seeds are separated to produce a stable, raw product: unroasted green coffee. The seeds are then roasted, a process which transforms them into a consumable product: roasted coffee, which is ground into fine particles that are typically steeped in hot water before being filtered out, producing a cup of coffee.");
//		coffee.setIconName("coffee");
//		categoryRepository.save(coffee);
//
//		CategoryEntity breakfast = new CategoryEntity();
//		breakfast.setName("Breakfast");
//		breakfast.setDescription("Breakfast is the first meal of the day, usually eaten in the morning. It typically includes a variety of foods such as eggs, bacon, sausages, pancakes, waffles, oatmeal, cereal, toast, and coffee or tea.");
//		breakfast.setIconName("breakfast");
//		categoryRepository.save(breakfast);

		CategoryEntity christmas = new CategoryEntity();
		christmas.setName("Christmas");
		christmas.setDescription("Christmas is an annual festival commemorating the birth of Jesus Christ, celebrated on December 25th as a religious and cultural holiday by billions of people around the world. It is characterized by gift-giving, festive decorations, traditional meals, including roast turkey, ham, mashed potatoes, gravy, stuffing, cranberry sauce, and special desserts like Christmas pudding or fruitcake.");
		christmas.setIconName("christmas");
		categoryRepository.save(christmas);
	}

	private void buildAndSaveIngredients() {
		saveIngredient("Ground Lean Beef", "Lean ground beef with 7% fat content.", 250.0, 26.0, 17.0, 0.0, 2.5, 0.0);
		saveIngredient("Egg", "Large egg.", 70.0, 6.0, 5.0, 0.6, 0.2, 0.0);
		saveIngredient("Minced Onion", "Finely minced onion.", 40.0, 1.0, 0.1, 9.0, 0.5, 0.0);
		saveIngredient("Fine Dried Bread Crumbs", "Fine dried bread crumbs.", 110.0, 3.5, 0.8, 23.0, 1.0, 0.0);
		saveIngredient("Worcestershire Sauce", "Worcestershire sauce.", 15.0, 0.0, 0.0, 3.0, 0.3, 0.0);
		saveIngredient("Garlic", "Minced garlic cloves.", 4.0, 0.2, 0.0, 1.0, 0.1, 0.0);
		saveIngredient("Cheese", "Sliced cheese.", 100.0, 6.0, 8.0, 1.0, 0.2, 0.0);
		saveIngredient("Portobello Mushrooms", "Large portobello mushrooms, stems removed.", 35.0, 2.0, 0.5, 7.0, 0.7, 0.0);
		saveIngredient("Onion", "Medium-sized onion, sliced.", 44.0, 1.0, 0.1, 10.0, 0.3, 0.0);
		saveIngredient("Olive Oil", "Extra virgin olive oil.", 120.0, 0.0, 14.0, 0.0, 0.1, 0.0);
		saveIngredient("Bacon", "Crispy bacon strips.", 42.0, 3.0, 3.3, 0.0, 0.4, 0.0);
		saveIngredient("Pizza Dough", "Fresh pizza dough.", 285.0, 7.5, 1.8, 58.0, 2.0, 0.0);
		saveIngredient("Pizza Sauce", "Tomato-based pizza sauce.", 50.0, 1.0, 1.5, 9.0, 0.5, 0.0);
		saveIngredient("Mozzarella Cheese", "Shredded mozzarella cheese.", 250.0, 18.0, 22.0, 2.0, 1.5, 0.0);
		saveIngredient("Parmesan Cheese", "Grated Parmesan cheese.", 431.0, 38.0, 29.0, 4.0, 2.0, 0.0);
		saveIngredient("Bell Peppers", "Assorted bell peppers, sliced.", 31.0, 0.9, 0.3, 7.6, 0.6, 0.0);
		saveIngredient("Mushrooms", "Fresh mushrooms, sliced.", 22.0, 3.1, 0.3, 3.3, 0.2, 0.0);
		saveIngredient("Red Onion", "Red onion, thinly sliced.", 40.0, 1.1, 0.1, 9.3, 0.5, 0.0);
		saveIngredient("Black Olives", "Sliced black olives.", 115.0, 0.8, 11.0, 6.3, 1.2, 0.0);
		saveIngredient("Pepperoni", "Sliced pepperoni.", 504.0, 22.0, 45.0, 2.0, 2.5, 0.0);
		saveIngredient("Fresh Basil", "Fresh basil leaves.", 23.0, 3.2, 0.6, 2.7, 0.8, 0.0);
		saveIngredient("Italian Sausage", "Sliced Italian sausage.", 285.0, 13.0, 25.0, 1.0, 1.5, 0.0);
		saveIngredient("Ham", "Sliced ham.", 120.0, 17.0, 4.0, 2.0, 0.7, 0.0);
		saveIngredient("Espresso", "Strong brewed coffee.", 2.0, 0.2, 0.0, 0.3, 0.1, 0.0);
		saveIngredient("Milk", "Steamed milk.", 60.0, 3.0, 3.5, 4.8, 0.2, 0.0);
		saveIngredient("Foam", "Layer of foam on top.", 10.0, 0.1, 0.0, 2.5, 0.1, 0.0);
		saveIngredient("Cocoa Powder", "Unsweetened cocoa powder for dusting.", 12.0, 1.4, 0.8, 3.6, 0.3, 0.0);
		saveIngredient("Coffee", "Brewed coffee, cooled.", 2.0, 0.2, 0.0, 0.3, 0.1, 0.0);
		saveIngredient("Ice Cubes", "Frozen water cubes.", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		saveIngredient("Sweetener (optional)", "Optional sweetener such as sugar or syrup.", 20.0, 0.0, 0.0, 5.0, 1.0, 0.0);
		saveIngredient("Tortilla", "Flour tortilla.", 120.0, 3.0, 2.0, 22.0, 0.5, 0.0);
		saveIngredient("Eggs", "Large eggs.", 70.0, 6.0, 5.0, 0.6, 0.2, 0.0);
		saveIngredient("Cheddar Cheese", "Shredded cheddar cheese.", 110.0, 7.0, 9.0, 1.0, 0.3, 0.0);
		saveIngredient("All-Purpose Flour", "Regular all-purpose flour.", 364.0, 10.3, 1.2, 76.3, 2.5, 0.0);
		saveIngredient("Sugar", "Granulated white sugar.", 387.0, 0.0, 0.0, 99.8, 2.0, 99.8);
		saveIngredient("Baking Powder", "Leavening agent for pancakes.", 5.0, 0.0, 0.0, 2.2, 0.1, 2.2);
		saveIngredient("Salt", "Table salt for flavor.", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		saveIngredient("Butter", "Unsalted butter, melted.", 717.0, 0.9, 81.1, 0.1, 0.4, 0.0);
	}

	private void saveIngredient(String name, String description, double calories, double protein, double fats, double carbohydrates, double carbonDioxide, double sugarPer100Gram) {
		IngredientEntity ingredient = new IngredientEntity();
		ingredient.setName(name);
		ingredient.setDescription(description);
		ingredient.setCalories(calories);
		ingredient.setProteinPer100Gram(protein);
		ingredient.setFatsPer100Gram(fats);
		ingredient.setCarbohydratesPer100Gram(carbohydrates);
		ingredient.setCarbonDioxidePer100Gram(carbonDioxide);
		ingredient.setSugarPer100Gram(sugarPer100Gram);
		ingredientRepository.save(ingredient);
	}

	private RecipeEntity getHamburgerRecipe(DishEntity dish) {
		RecipeEntity hamburgerRecipe = new RecipeEntity();
		hamburgerRecipe.setName("Hamburger Recipe");
		hamburgerRecipe.setDescription("A recipe for making a classic hamburger.");
		List<IngredientEntity> hamburgerIngredients = new ArrayList<>();
		hamburgerIngredients.add(ingredientRepository.findByName("Ground Lean Beef"));
		hamburgerIngredients.add(ingredientRepository.findByName("Minced Onion"));
		hamburgerIngredients.add(ingredientRepository.findByName("Fine Dried Bread Crumbs"));
		hamburgerIngredients.add(ingredientRepository.findByName("Worcestershire Sauce"));
		hamburgerIngredients.add(ingredientRepository.findByName("Garlic"));
		hamburgerRecipe.setIngredients(hamburgerIngredients);
		hamburgerRecipe.setDish(dish);
		return recipeRepository.save(hamburgerRecipe);
	}

	private RecipeEntity getCheeseburgerRecipe(DishEntity dish) {
		RecipeEntity cheeseburgerRecipe = new RecipeEntity();
		cheeseburgerRecipe.setName("Cheeseburger Recipe");
		cheeseburgerRecipe.setDescription("A recipe for making a delicious cheeseburger.");
		List<IngredientEntity> cheeseburgerIngredients = new ArrayList<>();
		cheeseburgerIngredients.add(ingredientRepository.findByName("Ground Lean Beef"));
		cheeseburgerIngredients.add(ingredientRepository.findByName("Egg"));
		cheeseburgerIngredients.add(ingredientRepository.findByName("Minced Onion"));
		cheeseburgerIngredients.add(ingredientRepository.findByName("Fine Dried Bread Crumbs"));
		cheeseburgerIngredients.add(ingredientRepository.findByName("Worcestershire Sauce"));
		cheeseburgerIngredients.add(ingredientRepository.findByName("Garlic"));
		cheeseburgerIngredients.add(ingredientRepository.findByName("Cheese"));
		cheeseburgerRecipe.setIngredients(cheeseburgerIngredients);
		cheeseburgerRecipe.setDish(dish);
		return cheeseburgerRecipe;
	}

	private RecipeEntity getDoubleBurgerRecipe(DishEntity dish) {
		RecipeEntity recipe = new RecipeEntity();
		recipe.setName("Double Burger");
		recipe.setDescription("A recipe for making a double burger. Use Ground Lean Beef X2!!!");
		List<IngredientEntity> ingredients = new ArrayList<>();
		ingredients.add(ingredientRepository.findByName("Ground Lean Beef"));
		ingredients.add(ingredientRepository.findByName("Minced Onion"));
		ingredients.add(ingredientRepository.findByName("Fine Dried Bread Crumbs"));
		ingredients.add(ingredientRepository.findByName("Worcestershire Sauce"));
		ingredients.add(ingredientRepository.findByName("Garlic"));

		recipe.setIngredients(ingredients);
		recipe.setDish(dish);
		return recipe;
	}

	private RecipeEntity getMushroomBurgerRecipe(DishEntity dish) {
		RecipeEntity mushroomBurgerRecipe = new RecipeEntity();
		mushroomBurgerRecipe.setName("Mushroom Burger Recipe");
		mushroomBurgerRecipe.setDescription("A recipe for making a delicious mushroom burger.");
		List<IngredientEntity> mushroomBurgerIngredients = new ArrayList<>();
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Portobello Mushrooms"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Onion"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Garlic"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Olive Oil"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Burger Buns"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Lettuce"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Tomato"));
		mushroomBurgerIngredients.add(ingredientRepository.findByName("Cheese"));
		mushroomBurgerRecipe.setIngredients(mushroomBurgerIngredients);
		mushroomBurgerRecipe.setDish(dish);
		return mushroomBurgerRecipe;
	}

	private RecipeEntity getBaconCheeseburgerRecipe(DishEntity dish) {
		RecipeEntity baconCheeseburgerRecipe = new RecipeEntity();
		baconCheeseburgerRecipe.setName("Bacon Cheeseburger Recipe");
		baconCheeseburgerRecipe.setDescription("A recipe for a delicious bacon cheeseburger.");
		List<IngredientEntity> baconCheeseburgerIngredients = new ArrayList<>();
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Ground Lean Beef"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Bacon"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Cheese"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Onion"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Lettuce"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Tomato"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Pickles"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Mayonnaise"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Ketchup"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Mustard"));
		baconCheeseburgerIngredients.add(ingredientRepository.findByName("Burger Buns"));
		baconCheeseburgerRecipe.setIngredients(baconCheeseburgerIngredients);
		baconCheeseburgerRecipe.setDish(dish);
		return baconCheeseburgerRecipe;
	}

	private RecipeEntity getCheesePizzaRecipe(DishEntity dish) {
		RecipeEntity cheesePizzaRecipe = new RecipeEntity();
		cheesePizzaRecipe.setName("Cheese Pizza Recipe");
		cheesePizzaRecipe.setDescription("A recipe for a delicious cheese pizza.");
		List<IngredientEntity> cheesePizzaIngredients = new ArrayList<>();
		cheesePizzaIngredients.add(ingredientRepository.findByName("Pizza Dough"));
		cheesePizzaIngredients.add(ingredientRepository.findByName("Pizza Sauce"));
		cheesePizzaIngredients.add(ingredientRepository.findByName("Mozzarella Cheese"));
		cheesePizzaIngredients.add(ingredientRepository.findByName("Parmesan Cheese"));
		cheesePizzaIngredients.add(ingredientRepository.findByName("Olive Oil"));
		cheesePizzaRecipe.setIngredients(cheesePizzaIngredients);
		cheesePizzaRecipe.setDish(dish);
		return cheesePizzaRecipe;
	}

	private RecipeEntity getVeggiePizzaRecipe(DishEntity dish) {
		RecipeEntity veggiePizzaRecipe = new RecipeEntity();
		veggiePizzaRecipe.setName("Veggie Pizza Recipe");
		veggiePizzaRecipe.setDescription("A recipe for a delicious veggie pizza.");
		List<IngredientEntity> veggiePizzaIngredients = new ArrayList<>();
		veggiePizzaIngredients.add(ingredientRepository.findByName("Pizza Dough"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Pizza Sauce"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Mozzarella Cheese"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Bell Peppers"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Mushrooms"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Red Onion"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Black Olives"));
		veggiePizzaIngredients.add(ingredientRepository.findByName("Olive Oil"));
		veggiePizzaRecipe.setIngredients(veggiePizzaIngredients);
		veggiePizzaRecipe.setDish(dish);
		return veggiePizzaRecipe;
	}

	private RecipeEntity getPepperoniPizzaRecipe(DishEntity dish) {
		RecipeEntity pepperoniPizzaRecipe = new RecipeEntity();
		pepperoniPizzaRecipe.setName("Pepperoni Pizza Recipe");
		pepperoniPizzaRecipe.setDescription("A recipe for a delicious pepperoni pizza.");
		List<IngredientEntity> pepperoniPizzaIngredients = new ArrayList<>();
		pepperoniPizzaIngredients.add(ingredientRepository.findByName("Pizza Dough"));
		pepperoniPizzaIngredients.add(ingredientRepository.findByName("Pizza Sauce"));
		pepperoniPizzaIngredients.add(ingredientRepository.findByName("Mozzarella Cheese"));
		pepperoniPizzaIngredients.add(ingredientRepository.findByName("Pepperoni"));
		pepperoniPizzaIngredients.add(ingredientRepository.findByName("Olive Oil"));
		pepperoniPizzaRecipe.setIngredients(pepperoniPizzaIngredients);
		pepperoniPizzaRecipe.setDish(dish);
		return pepperoniPizzaRecipe;
	}

	private RecipeEntity getMargheritaPizzaRecipe(DishEntity dish) {
		RecipeEntity margheritaPizzaRecipe = new RecipeEntity();
		margheritaPizzaRecipe.setName("Margherita Pizza Recipe");
		margheritaPizzaRecipe.setDescription("A recipe for a classic Margherita pizza.");
		List<IngredientEntity> margheritaPizzaIngredients = new ArrayList<>();
		margheritaPizzaIngredients.add(ingredientRepository.findByName("Pizza Dough"));
		margheritaPizzaIngredients.add(ingredientRepository.findByName("Pizza Sauce"));
		margheritaPizzaIngredients.add(ingredientRepository.findByName("Mozzarella Cheese"));
		margheritaPizzaIngredients.add(ingredientRepository.findByName("Fresh Basil"));
		margheritaPizzaIngredients.add(ingredientRepository.findByName("Olive Oil"));
		margheritaPizzaRecipe.setIngredients(margheritaPizzaIngredients);
		margheritaPizzaRecipe.setDish(dish);
		return margheritaPizzaRecipe;
	}

	private RecipeEntity getMeatLoversPizzaRecipe(DishEntity dish) {
		RecipeEntity meatLoversPizzaRecipe = new RecipeEntity();
		meatLoversPizzaRecipe.setName("Meat Lovers Pizza Recipe");
		meatLoversPizzaRecipe.setDescription("A recipe for a hearty Meat Lovers pizza.");
		List<IngredientEntity> meatLoversPizzaIngredients = new ArrayList<>();
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Pizza Dough"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Pizza Sauce"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Mozzarella Cheese"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Pepperoni"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Italian Sausage"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Bacon"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Ham"));
		meatLoversPizzaIngredients.add(ingredientRepository.findByName("Olive Oil"));
		meatLoversPizzaRecipe.setIngredients(meatLoversPizzaIngredients);
		meatLoversPizzaRecipe.setDish(dish);
		return meatLoversPizzaRecipe;
	}

	private RecipeEntity getLatteRecipe(DishEntity dish) {
		RecipeEntity latteRecipe = new RecipeEntity();
		latteRecipe.setName("Latte Recipe");
		latteRecipe.setDescription("A recipe for making a classic latte.");
		List<IngredientEntity> latteIngredients = new ArrayList<>();
		latteIngredients.add(ingredientRepository.findByName("Espresso"));
		latteIngredients.add(ingredientRepository.findByName("Milk"));
		latteIngredients.add(ingredientRepository.findByName("Foam"));
		latteRecipe.setIngredients(latteIngredients);
		latteRecipe.setDish(dish);
		return latteRecipe;
	}

	private RecipeEntity getCappuccinoRecipe(DishEntity dish) {
		RecipeEntity cappuccinoRecipe = new RecipeEntity();
		cappuccinoRecipe.setName("Cappuccino Recipe");
		cappuccinoRecipe.setDescription("A recipe for making a classic cappuccino.");
		List<IngredientEntity> cappuccinoIngredients = new ArrayList<>();
		cappuccinoIngredients.add(ingredientRepository.findByName("Espresso"));
		cappuccinoIngredients.add(ingredientRepository.findByName("Milk"));
		cappuccinoIngredients.add(ingredientRepository.findByName("Foam"));
		cappuccinoIngredients.add(ingredientRepository.findByName("Cocoa Powder"));
		cappuccinoRecipe.setIngredients(cappuccinoIngredients);
		cappuccinoRecipe.setDish(dish);
		return cappuccinoRecipe;
	}

	private RecipeEntity getAmericanoRecipe(DishEntity dish) {
		RecipeEntity americanoRecipe = new RecipeEntity();
		americanoRecipe.setName("Americano Recipe");
		americanoRecipe.setDescription("A recipe for making a classic Americano.");
		List<IngredientEntity> americanoIngredients = new ArrayList<>();
		americanoIngredients.add(ingredientRepository.findByName("Espresso"));
		americanoRecipe.setIngredients(americanoIngredients);
		americanoRecipe.setDish(dish);
		return americanoRecipe;
	}

	private RecipeEntity getFlatWhiteRecipe(DishEntity dish) {
		RecipeEntity flatWhiteRecipe = new RecipeEntity();
		flatWhiteRecipe.setName("Flat White Recipe");
		flatWhiteRecipe.setDescription("A recipe for making a delicious flat white.");
		List<IngredientEntity> flatWhiteIngredients = new ArrayList<>();
		flatWhiteIngredients.add(ingredientRepository.findByName("Espresso"));
		flatWhiteIngredients.add(ingredientRepository.findByName("Milk"));
		flatWhiteRecipe.setIngredients(flatWhiteIngredients);
		flatWhiteRecipe.setDish(dish);
		return flatWhiteRecipe;
	}

	private RecipeEntity getIcedCoffeeRecipe(DishEntity dish) {
		RecipeEntity icedCoffeeRecipe = new RecipeEntity();
		icedCoffeeRecipe.setName("Iced Coffee Recipe");
		icedCoffeeRecipe.setDescription("A recipe for making refreshing iced coffee.");
		List<IngredientEntity> icedCoffeeIngredients = new ArrayList<>();
		icedCoffeeIngredients.add(ingredientRepository.findByName("Coffee"));
		icedCoffeeIngredients.add(ingredientRepository.findByName("Ice Cubes"));
		icedCoffeeIngredients.add(ingredientRepository.findByName("Milk"));
		icedCoffeeIngredients.add(ingredientRepository.findByName("Sweetener (optional)"));
		icedCoffeeRecipe.setIngredients(icedCoffeeIngredients);
		icedCoffeeRecipe.setDish(dish);
		return icedCoffeeRecipe;
	}

	private RecipeEntity getBreakfastBurritoRecipe(DishEntity dish) {
		RecipeEntity breakfastBurritoRecipe = new RecipeEntity();
		breakfastBurritoRecipe.setName("Breakfast Burrito Recipe");
		breakfastBurritoRecipe.setDescription("A recipe for a delicious breakfast burrito.");
		List<IngredientEntity> breakfastBurritoIngredients = new ArrayList<>();
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Tortilla"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Eggs"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Bacon"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Cheddar Cheese"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Bell Peppers"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Onion"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Salsa"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Salt"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Pepper"));
		breakfastBurritoIngredients.add(ingredientRepository.findByName("Oil"));
		breakfastBurritoRecipe.setIngredients(breakfastBurritoIngredients);
		breakfastBurritoRecipe.setDish(dish);
		return breakfastBurritoRecipe;
	}

	private RecipeEntity getPancakesRecipe(DishEntity dish) {
		RecipeEntity pancakesRecipe = new RecipeEntity();
		pancakesRecipe.setName("Pancakes Recipe");
		pancakesRecipe.setDescription("A recipe for fluffy and delicious pancakes.");
		List<IngredientEntity> pancakesIngredients = new ArrayList<>();
		pancakesIngredients.add(ingredientRepository.findByName("All-Purpose Flour"));
		pancakesIngredients.add(ingredientRepository.findByName("Sugar"));
		pancakesIngredients.add(ingredientRepository.findByName("Baking Powder"));
		pancakesIngredients.add(ingredientRepository.findByName("Salt"));
		pancakesIngredients.add(ingredientRepository.findByName("Milk"));
		pancakesIngredients.add(ingredientRepository.findByName("Eggs"));
		pancakesIngredients.add(ingredientRepository.findByName("Butter"));
		pancakesRecipe.setIngredients(pancakesIngredients);
		pancakesRecipe.setDish(dish);
		return pancakesRecipe;
	}

	private RecipeEntity xMasWafflesRecipe(DishEntity dish) {
		RecipeEntity pancakesRecipe = new RecipeEntity();
		pancakesRecipe.setName("Waffles");
		pancakesRecipe.setDescription("A recipe for fluffy and delicious Waffles.");
		List<IngredientEntity> pancakesIngredients = new ArrayList<>();
		pancakesIngredients.add(ingredientRepository.findByName("All-Purpose Flour"));
		pancakesIngredients.add(ingredientRepository.findByName("Sugar"));
		pancakesIngredients.add(ingredientRepository.findByName("Baking Powder"));
		pancakesIngredients.add(ingredientRepository.findByName("Salt"));
		pancakesIngredients.add(ingredientRepository.findByName("Milk"));
		pancakesIngredients.add(ingredientRepository.findByName("Eggs"));
		pancakesIngredients.add(ingredientRepository.findByName("Butter"));
		pancakesRecipe.setIngredients(pancakesIngredients);
		pancakesRecipe.setDish(dish);
		return pancakesRecipe;
	}

	private void buildAndSaveLabels() {
		LabelEntity cheap = new LabelEntity();
		cheap.setName("cheap");
		labelRepository.save(cheap);

		LabelEntity eco = new LabelEntity();
		eco.setName("eco");
		labelRepository.save(eco);

		LabelEntity vegeterian = new LabelEntity();
		vegeterian.setName("vegeterian");
		labelRepository.save(vegeterian);

		LabelEntity healthy = new LabelEntity();
		healthy.setName("healthy");
		labelRepository.save(healthy);

		LabelEntity low_calorie = new LabelEntity();
		low_calorie.setName("low_calorie");
		labelRepository.save(low_calorie);

		LabelEntity sweaty = new LabelEntity();
		sweaty.setName("sweaty");
		labelRepository.save(sweaty);

		LabelEntity promotional = new LabelEntity();
		promotional.setName("promotional");
		labelRepository.save(promotional);
	}

}

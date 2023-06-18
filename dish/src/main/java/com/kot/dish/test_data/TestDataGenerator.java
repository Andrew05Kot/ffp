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

import com.kot.dish.domain.CategoryEntity;
import com.kot.dish.domain.DishEntity;
import com.kot.dish.domain.IngredientEntity;
import com.kot.dish.domain.RecipeEntity;
import com.kot.dish.repository.CategoryRepository;
import com.kot.dish.repository.DishRepository;
import com.kot.dish.repository.IngredientRepository;
import com.kot.dish.repository.RecipeRepository;

@Component
@Profile("testdata")
public class TestDataGenerator {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	private RecipeRepository recipeRepository;

	private Map<String, CategoryEntity> categories;

	@PostConstruct
	public void generateTestData() {
		this.categories = buildAndSaveCategories();

		buildAndSaveIngredients();
		buildAndSaveDishes();
	}

	private void buildAndSaveDishes() {
		createAndSave("Hamburger",
				"Hamburger",
				BigDecimal.valueOf(2),
				"A hamburger is a type of sandwich consisting of a chopped patty served inside a sliced bun. In addition to meat, a hamburger can have a large number of different seasonings, for example: ketchup and mayonnaise, lettuce, pickled cucumber, cheese or fried onion, tomato.",
				"https://live.staticflickr.com/5488/9075153360_cb9b2deded_z.jpg",
				this::getHamburgerRecipe
		);

		createAndSave("Cheeseburger",
				"Hamburger",
				BigDecimal.valueOf(2.10),
				"A cheeseburger is a hamburger topped with cheese. Traditionally, the slice of cheese is placed on top of the meat patty. The cheese is usually added to the cooking hamburger patty shortly before serving, which allows the cheese to melt. Cheeseburgers can include variations in structure, ingredients and composition. As with other hamburgers, a cheeseburger may include toppings such as lettuce, tomato, onion, pickles, bacon, mayonnaise, ketchup, and mustard.",
				"https://live.staticflickr.com/7334/27568788370_e101cfd3f6.jpg",
				this::getCheeseburgerRecipe
		);

		createAndSave("Double burger",
				"Hamburger",
				BigDecimal.valueOf(3.50),
				"Although the legendary Double Burger really needs no introduction, please allow us... Tucked in between three soft buns are two all-beef patties, cheddar cheese, ketchup, onion, pickles and iceberg lettuce. Hesburger's own paprika and cucumber mayonnaise add the crowning touch. Oh baby!",
				"https://live.staticflickr.com/1777/42976245025_62ce57d552_k.jpg",
				this::getDoubleBurgerRecipe
		);

		createAndSave("Mushroom burger",
				"Hamburger",
				BigDecimal.valueOf(3.00),
				"For the healthy and calorie conscious folks we've got this tasty burger. A lentil, mushroom and sun dried tomato pattie packed between a whole wheat bun.",
				null,
				this::getMushroomBurgerRecipe
		);

		createAndSave("Bacon Cheeseburger",
				"Hamburger",
				BigDecimal.valueOf(3.50),
				"This burger takes things to the next level with crispy bacon and melted cheese on top of a juicy patty.",
				null,
				this::getBaconCheeseburgerRecipe
		);

		createAndSave("Cheese Pizza",
				"Pizza",
				BigDecimal.valueOf(3.00),
				"It should be no shocker that a classic is the statistical favorite. Cheese pizza is one of the most popular choices. It will always be a simple, unadorned masterpiece on its own.",
				"https://live.staticflickr.com/7165/6707822395_e49eb0fd50_b.jpg",
				this::getCheesePizzaRecipe
		);

		createAndSave("Veggie Pizza",
				"Pizza",
				BigDecimal.valueOf(3.00),
				"When you want to jazz up your cheese pizza with color and texture, veggies are the perfect topping. And you’re only limited by your imagination. Everything from peppers and mushrooms, to eggplant and onions make for an exciting and tasty veggie pizza.",
				"https://live.staticflickr.com/3002/2746214882_377a22ea38_b.jpg",
				this::getVeggiePizzaRecipe
		);

		createAndSave("Pepperoni Pizza",
				"Pizza",
				BigDecimal.valueOf(2.80),
				"There’s a reason this is one of the most popular types of pizza. Who doesn’t love biting into a crispy, salty round of pepperoni?",
				null,
				this::getPepperoniPizzaRecipe
		);


		createAndSave("Margherita Pizza",
				"Pizza",
				BigDecimal.valueOf(3.05),
				"Deceptively simple, the Margherita pizza is made with basil, fresh mozzarella, and tomatoes. There’s a reason it’s an Italian staple and one of the most popular types of pizza in the country.",
				"https://live.staticflickr.com/8699/17144434218_8324b5d89c_b.jpg",
				this::getMargheritaPizzaRecipe
		);

		createAndSave("Meat Lovers Pizza",
				"Pizza",
				BigDecimal.valueOf(4.00),
				"This pizza is loaded with pepperoni, sausage, bacon, and ham for a hearty and satisfying meal.",
				"https://live.staticflickr.com/4025/4547182511_42e46a9818_b.jpg",
				this::getMeatLoversPizzaRecipe
		);

		createAndSave("Latte",
				"Coffee",
				BigDecimal.valueOf(1.00),
				"This classic drink is typically 1/3 espresso and 2/3 steamed milk, topped with a thin layer of foam, but coffee shops have come up with seemingly endless customizations. You can experiment with flavored syrups like vanilla and pumpkin spice or create a nondairy version by using oat milk. Skilled baristas often swirl the foam into latte art!",
				"https://live.staticflickr.com/5553/14122661794_2374c45868_b.jpg",
				this::getLatteRecipe
		);

		createAndSave("Cappuccino",
				"Coffee",
				BigDecimal.valueOf(0.75),
				"This espresso-based drink is similar to a latte, but the frothy top layer is thicker. The standard ratio is equal parts espresso, steamed milk, and foam. It's often served in a 6-ounce cup (smaller than a latte cup) and can be topped with a sprinkling of cinnamon.",
				"https://live.staticflickr.com/65535/51145487162_a019ceb695_b.jpg",
				this::getCappuccinoRecipe
		);

		createAndSave("Americano",
				"Coffee",
				BigDecimal.valueOf(0.75),
				"Order this drink and you'll get a shot of espresso diluted with hot water.",
				null,
				this::getAmericanoRecipe
		);

		createAndSave("Flat White",
				"Coffee",
				BigDecimal.valueOf(1.10),
				"Like the latte, this drink consists of espresso and steamed milk, but the ratio of espresso to milk is higher. Baristas also fold the milk as it steams, which creates a more velvety texture. The flat white has roots in Australia and New Zealand.",
				null,
				this::getFlatWhiteRecipe
		);

		createAndSave("Iced Coffee",
				"Coffee",
				BigDecimal.valueOf(1.50),
				"A refreshing way to enjoy your coffee on a hot day. Brewed coffee poured over ice and served with your choice of cream and sugar.",
				"https://live.staticflickr.com/8785/17833846288_4c1df9d221_b.jpg",
				this::getIcedCoffeeRecipe
		);

		createAndSave("Breakfast Burrito",
				"Breakfast",
				BigDecimal.valueOf(4.00),
				"Start your day off right with this breakfast burrito filled with scrambled eggs, cheese, potatoes, and your choice of bacon or sausage.",
				"https://live.staticflickr.com/8487/8288501304_45ccfb5443_b.jpg",
				this::getBreakfastBurritoRecipe
		);

		createAndSave("Pancakes",
				"Breakfast",
				BigDecimal.valueOf(3.00),
				"A classic breakfast dish, pancakes are made with a fluffy batter and served with butter and syrup. Add toppings like berries, whipped cream, or chocolate chips for a sweet twist.",
				"https://live.staticflickr.com/7662/16958480458_f678f57241_c.jpg",
				this::getPancakesRecipe
		);
	}

	private void createAndSave(String name, String categoryName, BigDecimal price, String description, String imageUrl, Function<DishEntity, RecipeEntity> recipeProvider) {
		DishEntity hamburger = new DishEntity();
		hamburger.setName(name);
		hamburger.setCategory(categories.get(categoryName));
		hamburger.setPrice(price);
		hamburger.setDescription(description);
		hamburger.setImageUrl(imageUrl);
		hamburger.setRecipe(recipeProvider.apply(hamburger));
		dishRepository.save(hamburger);
	}

	public Map<String, CategoryEntity> buildAndSaveCategories() {
		Map<String, CategoryEntity> categories = new HashMap<>();
		CategoryEntity sandwich = new CategoryEntity();
		sandwich.setName("Hamburger");
		sandwich.setDescription("A hamburger is a type of sandwich. It consists of two or more slices of bread (often a bun) and one or more layers of meat and other fillings. In big cities (especially in the West), the sandwich has become an integral part of the food culture.");
		sandwich.setIconName("hamburger");
		categories.put(sandwich.getName(), categoryRepository.save(sandwich));

		CategoryEntity pizza = new CategoryEntity();
		pizza.setName("Pizza");
		pizza.setDescription("Pizza is an Italian national dish, namely a flatbread, usually round in shape, which is covered with tomato paste and cheese and baked.");
		pizza.setIconName("pizza");
		categories.put(pizza.getName(), categoryRepository.save(pizza));

		CategoryEntity roll = new CategoryEntity();
		roll.setName("Roll");
		roll.setDescription("It is a dish made of pita bread, which is filled with chopped fried meat (lamb, beef, turkey or chicken; in Europe sometimes also pork) with the addition of seasonings, sauces and a salad of fresh vegetables");
		roll.setIconName("roll");
		categories.put(roll.getName(), categoryRepository.save(roll));

		CategoryEntity coffee = new CategoryEntity();
		coffee.setName("Coffee");
		coffee.setDescription("Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain flowering plants in the Coffea genus. From the coffee fruit, the seeds are separated to produce a stable, raw product: unroasted green coffee. The seeds are then roasted, a process which transforms them into a consumable product: roasted coffee, which is ground into fine particles that are typically steeped in hot water before being filtered out, producing a cup of coffee.\n" +
				"Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain flowering plants in the Coffea genus. From the coffee fruit, the seeds are separated to produce a stable, raw product: unroasted green coffee. The seeds are then roasted, a process which transforms them into a consumable product: roasted coffee, which is ground into fine particles that are typically steeped in hot water before being filtered out, producing a cup of coffee.");
		coffee.setIconName("coffee");
		categories.put(coffee.getName(), categoryRepository.save(coffee));

		CategoryEntity breakfast = new CategoryEntity();
		breakfast.setName("Breakfast");
		breakfast.setDescription("Breakfast is the first meal of the day, usually eaten in the morning. It typically includes a variety of foods such as eggs, bacon, sausages, pancakes, waffles, oatmeal, cereal, toast, and coffee or tea.");
		breakfast.setIconName("breakfast");
		categories.put(breakfast.getName(), categoryRepository.save(breakfast));

		return categories;
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
		return hamburgerRecipe;
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

}

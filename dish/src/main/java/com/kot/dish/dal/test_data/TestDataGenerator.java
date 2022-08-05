package com.kot.dish.dal.test_data;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kot.dish.dal.entity.CategoryEntity;
import com.kot.dish.dal.entity.DishEntity;
import com.kot.dish.dal.repository.CategoryRepository;
import com.kot.dish.dal.repository.DishRepository;

@Component
public class TestDataGenerator {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private DishRepository dishRepository;

	@PostConstruct
	public void buildAndSaveDishes() {
		Map<String, CategoryEntity> categories = buildAndSaveCategories();

		DishEntity hamburger = new DishEntity();
		hamburger.setName("Hamburger");
		hamburger.setCategory(categories.get("Hamburger"));
		hamburger.setDescription("A hamburger is a type of sandwich consisting of a chopped patty served inside a sliced bun. In addition to meat, a hamburger can have a large number of different seasonings, for example: ketchup and mayonnaise, lettuce, pickled cucumber, cheese or fried onion, tomato.");
		dishRepository.save(hamburger);

		DishEntity cheeseburger = new DishEntity();
		cheeseburger.setName("Cheeseburger");
		cheeseburger.setCategory(categories.get("Hamburger"));
		cheeseburger.setDescription("A cheeseburger is a hamburger topped with cheese. Traditionally, the slice of cheese is placed on top of the meat patty. The cheese is usually added to the cooking hamburger patty shortly before serving, which allows the cheese to melt. Cheeseburgers can include variations in structure, ingredients and composition. As with other hamburgers, a cheeseburger may include toppings such as lettuce, tomato, onion, pickles, bacon, mayonnaise, ketchup, and mustard.");
		dishRepository.save(cheeseburger);

		DishEntity doubleBurger = new DishEntity();
		doubleBurger.setName("Double burger");
		doubleBurger.setCategory(categories.get("Hamburger"));
		doubleBurger.setDescription("Although the legendary Double Burger really needs no introduction, please allow us... Tucked in between three soft buns are two all-beef patties, cheddar cheese, ketchup, onion, pickles and iceberg lettuce. Hesburger's own paprika and cucumber mayonnaise add the crowning touch. Oh baby!");
		dishRepository.save(doubleBurger);

		DishEntity mushroomBurger = new DishEntity();
		mushroomBurger.setName("Mushroom Burger");
		mushroomBurger.setCategory(categories.get("Hamburger"));
		mushroomBurger.setDescription("For the healthy and calorie conscious folks we've got this tasty burger. A lentil, mushroom and sun dried tomato pattie packed between a whole wheat bun.");
		dishRepository.save(mushroomBurger);

		DishEntity cheesePizza = new DishEntity();
		cheesePizza.setName("Cheese Pizza");
		cheesePizza.setCategory(categories.get("Pizza"));
		cheesePizza.setDescription("It should be no shocker that a classic is the statistical favorite. Cheese pizza is one of the most popular choices. It will always be a simple, unadorned masterpiece on its own.");
		dishRepository.save(cheesePizza);

		DishEntity veggiePizza = new DishEntity();
		veggiePizza.setName("Veggie Pizza");
		veggiePizza.setCategory(categories.get("Pizza"));
		veggiePizza.setDescription("When you want to jazz up your cheese pizza with color and texture, veggies are the perfect topping. And you’re only limited by your imagination. Everything from peppers and mushrooms, to eggplant and onions make for an exciting and tasty veggie pizza.");
		dishRepository.save(veggiePizza);

		DishEntity pepperoniPizza = new DishEntity();
		pepperoniPizza.setName("Pepperoni Pizza");
		pepperoniPizza.setCategory(categories.get("Pizza"));
		pepperoniPizza.setDescription("There’s a reason this is one of the most popular types of pizza. Who doesn’t love biting into a crispy, salty round of pepperoni?");
		dishRepository.save(pepperoniPizza);

		DishEntity margheritaPizza = new DishEntity();
		margheritaPizza.setName("Margherita Pizza");
		margheritaPizza.setCategory(categories.get("Pizza"));
		margheritaPizza.setDescription("Deceptively simple, the Margherita pizza is made with basil, fresh mozzarella, and tomatoes. There’s a reason it’s an Italian staple and one of the most popular types of pizza in the country.");
		dishRepository.save(margheritaPizza);

		DishEntity latte = new DishEntity();
		latte.setName("Latte");
		latte.setCategory(categories.get("Coffee"));
		latte.setDescription("This classic drink is typically 1/3 espresso and 2/3 steamed milk, topped with a thin layer of foam, but coffee shops have come up with seemingly endless customizations. You can experiment with flavored syrups like vanilla and pumpkin spice or create a nondairy version by using oat milk. Skilled baristas often swirl the foam into latte art!");
		dishRepository.save(latte);

		DishEntity cappuccino = new DishEntity();
		cappuccino.setName("Cappuccino");
		cappuccino.setCategory(categories.get("Coffee"));
		cappuccino.setDescription("This espresso-based drink is similar to a latte, but the frothy top layer is thicker. The standard ratio is equal parts espresso, steamed milk, and foam. It's often served in a 6-ounce cup (smaller than a latte cup) and can be topped with a sprinkling of cinnamon.");
		dishRepository.save(cappuccino);

		DishEntity americano = new DishEntity();
		americano.setName("Americano");
		americano.setCategory(categories.get("Coffee"));
		americano.setDescription("Order this drink and you'll get a shot of espresso diluted with hot water.");
		dishRepository.save(americano);

		DishEntity flatWhite = new DishEntity();
		flatWhite.setName("Flat White");
		flatWhite.setCategory(categories.get("Coffee"));
		flatWhite.setDescription("Like the latte, this drink consists of espresso and steamed milk, but the ratio of espresso to milk is higher. Baristas also fold the milk as it steams, which creates a more velvety texture. The flat white has roots in Australia and New Zealand.");
		dishRepository.save(flatWhite);
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

		return categories;
	}

}

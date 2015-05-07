package beer;

import java.util.ArrayList;
import java.util.List;

public class Beer {

	private String name;
	private String type;
	private String al;
	private String manufacturer;
	private Ingredient ingredient = new Ingredient();
	private List<Ingredient> ingredients;
	private List<Char> chares;

	private Char chars = new Char();

	public Beer(String name, String type, String al, String manufacturer,
			List<Ingredient> ingredients, Char chars) {
		setName(name);
		setType(type);
		setAl(al);
		setManufacturer(manufacturer);
		setIngredients(ingredients);
		setChars(chars);
	}

	public Beer() {
		// TODO Auto-generated constructor stub
	}

	public Char getChars() {
		return chars;
	}

	public void setChars(Char chars) {
		this.chars = chars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAl() {
		return al;
	}

	public void setAl(String al) {
		this.al = al;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}



	public String toString() {
		return "\nBeer:" + "\n\tname: " + getName() + "\n\ttype: " + getType()
				+ "\n\tAl: " + getAl() + "\n\tmanufacturer: "
				+ getManufacturer() + "\n\tingredients: "
				+ getIngredients().toString() + "\n\tchars: "
				+ getChars().toString();
	}

	public static class Ingredient {

		private String ingredient;
		private String amount;

		public Ingredient() {
		}

		public Ingredient(String ingredient, String amount) {
			setIngredient(ingredient);
			setAmount(amount);
		}

		public String getIngredient() {
			return ingredient;
		}

		public void setIngredient(String ingredient) {
			this.ingredient = ingredient;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String toString() {
			return  getIngredient()
					+ " amount: " + getAmount() ;
		}
	}                                                                                                

	 public static class Char {
		private String numberOfTurns;
		private String transparency;
		private String filtered;
		private String nutritional;
		private Filling fill = new Filling();

		public Char() {
		}

		public Char(String numberOfTurns, String transparency, String filtered,
				String nutritional, Filling fill) {
			setNumberOfTurns(numberOfTurns);
			setTransparency(transparency);
			setFiltered(filtered);
			setNutritional(nutritional);
			setFill(fill);
		}

		public String getNumberOfTurns() {
			return numberOfTurns;
		}

		public void setNumberOfTurns(String numberOfTurns) {
			this.numberOfTurns = numberOfTurns;
		}

		public String getTransparency() {
			return transparency;
		}

		public void setTransparency(String transparency) {
			this.transparency = transparency;
		}

		public String getFiltered() {
			return filtered;
		}

		public void setFiltered(String filtered) {
			this.filtered = filtered;
		}

		public String getNutritional() {
			return nutritional;
		}

		public void setNutritional(String nutritional) {
			this.nutritional = nutritional;
		}

		public Filling getFill() {
			return fill;
		}

		public void setFill(Filling fill) {
			this.fill = fill;
		}
		public String toString() {
			return "[ NumberOfTurns : " + getNumberOfTurns() + "  \tTransparency: "
					+ getTransparency()+" \tFiltered: " +getFiltered()+ "  \tNutritional: " +getNutritional()+" \tFill: " +getFill()+"] ";
		}
		
		
		public static class Filling {

			private String material;
			private String volume;

			public Filling() {
			}

			public Filling(String material, String volume) {
				setMaterial(material);
				setVolume(volume);
			}

			public String getMaterial() {
				return material;
			}

			public void setMaterial(String material) {
				this.material = material;
			}

			public String getVolume() {
				return volume;
			}

			public void setVolume(String volume) {
				this.volume = volume;
			}

			public String toString() {
				return "[ material : " + getMaterial() + "\n\tvolume: "
						+ getVolume()+"]\n" ;
			}
		}
	}
	 

}

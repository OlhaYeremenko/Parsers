package beer;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "beer")
public class Beer {

	private String name;
	private String type;
	private String al;
	private String manufacturer;
	private List<Ingredient> ingredients;
	private Char chars;

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
	
    @XmlElement(name="chars")
	public void setChars(Char chars) {
		this.chars = chars;
	}

	public String getName() {
		return name;
	}
	
    @XmlElement(name="name")
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
    @XmlElement(name="type")
	public void setType(String type) {
		this.type = type;
	}

	public String getAl() {
		return al;
	}
	
    @XmlElement(name="al")
	public void setAl(String al) {
		this.al = al;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	
    @XmlElement(name="manufacturer")
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	/*public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}*/

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	@XmlElement
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
		@XmlElement (name="ingredient")
		public void setIngredient(String ingredient) {
			this.ingredient = ingredient;
		}

		public String getAmount() {
			return amount;
		}
		@XmlAttribute(name ="amount")
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
		
		@XmlElement(name="numberOfTurns") 
		public void setNumberOfTurns(String numberOfTurns) {
			this.numberOfTurns = numberOfTurns;
		}

		public String getTransparency() {
			return transparency;
		}
		
		@XmlElement(name="transparency")  
		public void setTransparency(String transparency) {
			this.transparency = transparency;
		}

		public String getFiltered() {
			return filtered;
		}
		
		@XmlElement (name="filtered")  
		public void setFiltered(String filtered) {
			this.filtered = filtered;
		}

		public String getNutritional() {
			return nutritional;
		}
		
		@XmlElement (name="nutritional")  
		public void setNutritional(String nutritional) {
			this.nutritional = nutritional;
		}

		public Filling getFill() {
			return fill;
		}
		@XmlElement (name="filling")  
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
			
			@XmlAttribute(name="material")
			public void setMaterial(String material) {
				this.material = material;
			}

			public String getVolume() {
				return volume;
			}
			
			@XmlElement(name="filling")
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

public class Book {

	/**
	 * @uml.property  name="Name"
	 */
	private String name;

	/**
	 * Getter of the property <tt>Name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="Name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>Name</tt>
	 * @param Name  The name to set.
	 * @uml.property  name="Name"
	 */
	public void setName(String name) {
		this.name = name;
	}


		
	/**
	*/
	public Book(int id,String name){
		this.name = name;
		this.id = id;
		exist = true;
	}



	/**
	 * @uml.property  name="exist"
	 */
	private boolean exist;

	/**
	 * Getter of the property <tt>exist</tt>
	 * @return  Returns the exist.
	 * @uml.property  name="exist"
	 */
	public boolean isExist() {
		return exist;
	}

	/**
	 * Setter of the property <tt>exist</tt>
	 * @param exist  The exist to set.
	 * @uml.property  name="exist"
	 */
	public void setExist(boolean exist) {
		this.exist = exist;
	}



	/**
	 * @uml.property  name="ID"
	 */
	private int id;

	/**
	 * Getter of the property <tt>ID</tt>
	 * @return  Returns the id.
	 * @uml.property  name="ID"
	 */
	public int getID() {
		return id;
	}

	/**
	 * Setter of the property <tt>ID</tt>
	 * @param ID  The id to set.
	 * @uml.property  name="ID"
	 */
	public void setID(int id) {
		this.id = id;
	}
}

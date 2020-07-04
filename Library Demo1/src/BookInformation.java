import java.util.Calendar;



public class BookInformation {

	
	private int id;

	/**
	 * Getter of the property <tt>Book</tt>
	 * @return  Returns the book.
	 * @uml.property  name="Book"
	 */
	public int getID() {
		return id;
	}

	/**
	 * Setter of the property <tt>Book</tt>
	 * @param Book  The book to set.
	 * @uml.property  name="Book"
	 */
	public void setID(int id) {
		this.id = id;
	}



	public BookInformation(int id,Calendar calendar){
		this.id = id;
		this.borrowday = calendar;
	}


	/**
	 * @uml.property  name="borrowday"
	 */
	private Calendar borrowday;

	/**
	 * Getter of the property <tt>returnday</tt>
	 * @return  Returns the returnday.
	 * @uml.property  name="borrowday"
	 */
	public Calendar getBorrowday() {
		return borrowday;
	}

	/**
	 * Setter of the property <tt>returnday</tt>
	 * @param returnday  The returnday to set.
	 * @uml.property  name="borrowday"
	 */
	public void setBorrowday(Calendar borrowday) {
		this.borrowday = borrowday;
	}

}

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;



public class Member {
	private Collection<BookInformation> bookhold;
	public Member(int id,String name,String address){
		bookControl = new BookControl();
		bookhold = new ArrayList<BookInformation>();
		this.id = id;
		this.name = name;
		this.address = address;
		stateFactory = new StateFactory();
		state = stateFactory.getState(address);
		System.out.println(" ->ID:" + id + " 名前:" + name + " 住所:" + address +" で会員登録しました");
	}


	/**
	 */
	public void System(){
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
	 * @uml.property  name="Address"
	 */
	private String address;


	/**
	 * Getter of the property <tt>Address</tt>
	 * @return  Returns the address.
	 * @uml.property  name="Address"
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * Setter of the property <tt>Address</tt>
	 * @param Address  The address to set.
	 * @uml.property  name="Address"
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @uml.property name="memberList"
	 * @uml.associationEnd inverse="membergroup:MemberList"
	 */
	private MemberList memberList;


	/**
	 * Getter of the property <tt>memberList</tt>
	 * @return  Returns the memberList.
	 * @uml.property  name="memberList"
	 */
	public MemberList getMemberList() {
		return memberList;
	}


	/**
	 * @uml.property  name="stateFactory"
	 * @uml.associationEnd  aggregation="shared" inverse="member:StateFactory"
	 */
	private StateFactory stateFactory;


	/**
	 * Getter of the property <tt>stateFactory</tt>
	 * @return  Returns the stateFactory.
	 * @uml.property  name="stateFactory"
	 */
	public StateFactory getStateFactory() {
		return stateFactory;
	}


	/**
	 * Setter of the property <tt>stateFactory</tt>
	 * @param stateFactory  The stateFactory to set.
	 * @uml.property  name="stateFactory"
	 */
	public void setStateFactory(StateFactory stateFactory) {
		this.stateFactory = stateFactory;
	}


	/**
	 * @uml.property  name="state"
	 * @uml.associationEnd  aggregation="shared" inverse="member:State"
	 */
	private State state;


	/**
	 * Getter of the property <tt>state</tt>
	 * @return  Returns the state.
	 * @uml.property  name="state"
	 */
	public State getState() {
		return state;
	}


	/**
	 * Setter of the property <tt>state</tt>
	 * @param state  The state to set.
	 * @uml.property  name="state"
	 */
	public void setState(State state) {
		this.state = state;
	}


	/**
	 * Setter of the property <tt>memberList</tt>
	 * @param memberList  The memberList to set.
	 * @uml.property  name="memberList"
	 */
	public void setMemberList(MemberList memberList) {
		this.memberList = memberList;
	}



	/**
	 */
	public void borrowbook(int id,Calendar returnday){
		if(bookControl.searchBook(id)){
			if(bookhold.size() <= getState().getBooklimit()){
				bookhold.add(new BookInformation(id,returnday));
				bookControl.borrowBook(id);
				System.out.println(" ->ID:" + this.name +"さんがID:" + id + "の本を借りました");
			}else{
				System.err.println("貸し出し数オーバー");
			}
		}else{
			System.err.println("貸し出しエラー");
		}
	}




	/**
	 * @uml.property  name="bookList"
	 * @uml.associationEnd  aggregation="shared" inverse="member:BookList"
	 */
	private BookList bookList;


	/**
	 * Getter of the property <tt>bookList</tt>
	 * @return  Returns the bookList.
	 * @uml.property  name="bookList"
	 */
	public BookList getBookList() {
		return bookList;
	}


	/**
	 * Setter of the property <tt>bookList</tt>
	 * @param bookList  The bookList to set.
	 * @uml.property  name="bookList"
	 */
	public void setBookList(BookList bookList) {
		this.bookList = bookList;
	}

	/**
	 */
	public boolean search(String bookname){
		return bookControl.searchBook(bookname);
	}



	/**
	 */
	public void returnbook(int id,Calendar returnday){
		returnday.add(Calendar.DAY_OF_MONTH,getState().getLimitweek() * (-7));
		if(bookControl.searchnonBook(id)&& isbookhold(id)) {
			Iterator<BookInformation> iterator = bookhold.iterator();
			while(iterator.hasNext()) {
				BookInformation booksign = iterator.next();
				if(booksign.getID()== id &&
						returnday.compareTo(booksign.getBorrowday()) <= 0){
					iterator.remove();
					bookControl.returnBook(id);
					System.out.println(" ->ID" + id + "の本を返却しました");
					return;
				}
			}
			System.err.println("返却できませんでした");
		}else{
			System.err.println("その本は存在しません");
		}
	}



	/**
	 */
	public boolean isbookhold(int id){
		Iterator<BookInformation> iterator = bookhold.iterator();
		while(iterator.hasNext()) {
			BookInformation booksign = iterator.next();
			if(booksign.getID() == id){
				return true;
			}
		}
		return false;
	}



	/**
	 */
	public void changeState(String newaddress){
		this.address = newaddress;
		stateFactory = new StateFactory();
		state = stateFactory.getState(address);
	}



	/**
	 */
	public void showAllHoldBook(){
		Iterator<BookInformation> iterator = bookhold.iterator();
		System.out.println("-----"  + this.getName() +"さんの借りている本一覧-----");
		while(iterator.hasNext()) {
			BookInformation booksign = iterator.next();
			int year = booksign.getBorrowday().get(Calendar.YEAR);
			int month = booksign.getBorrowday().get(Calendar.MONTH) + 1;
			int day = booksign.getBorrowday().get(Calendar.DATE);
			System.out.println("本のID:" + booksign.getID() + " 貸し出し日:" + year + "年"+ month + "月" + day + "日");
		}
		System.out.println("----------------------");
	}


	/**
	 * @uml.property  name="bookControl"
	 * @uml.associationEnd  aggregation="shared" inverse="member:BookControl"
	 */
	private BookControl bookControl;
	/**
	 * Getter of the property <tt>bookControl</tt>
	 * @return  Returns the bookControl.
	 * @uml.property  name="bookControl"
	 */
	public BookControl getBookControl() {
		return bookControl;
	}


	/**
	 * Setter of the property <tt>bookControl</tt>
	 * @param bookControl  The bookControl to set.
	 * @uml.property  name="bookControl"
	 */
	public void setBookControl(
			BookControl bookControl) {
		this.bookControl = bookControl;
	}



	/**
	 */
	public boolean isbookhold(){
		Iterator<BookInformation> iterator = bookhold.iterator();
		if(iterator.hasNext()) {

			return true;

		}
		return false;
	}
}

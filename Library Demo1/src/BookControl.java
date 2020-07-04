import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BookControl {
	private static Collection<Book> booklist = new ArrayList<Book>();
	/**
	 */
	public void addBook(int id,String bookname){
		Book book = new Book(id,bookname);
		booklist.add(book);
		System.out.println(" ->ID:" + id + " 名前:" + bookname + "が図書館に追加されました");
	}


	/**
	 */
	public void deleteBook(int id){
		Iterator<Book> iterator = booklist.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getID() == id){
				iterator.remove();
				System.out.println(" ->ID:" + id + "の本が図書館から削除されました");
				return;
			}
		}
		System.err.println(" ->そのIDの本は存在しません");
		return;
	}


	/**
	 */
	public boolean searchBook(int id){
		Iterator<Book> iterator = booklist.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getID() == id && book.isExist()== true){
				return true;
			}
		}
		return false;
	}

	public boolean searchBook(String bookname){
		Iterator<Book> iterator = booklist.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getName() == bookname && book.isExist()== true){
				return true;
			}
		}
		return false;
	}

	public void borrowBook(int id){
		informexistBook(id).setExist(false);
	}

	public void returnBook(int id){
		informnonexistbook(id).setExist(true);
	}

	/**
	 */
	public Book informexistBook(int id){
		Iterator<Book> iterator = booklist.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getID()==id && book.isExist()== true){
				return book;
			}
		}
		return null;
	}



	/**
	 */
	public Book informnonexistbook(int id){
		Iterator<Book> iterator = booklist.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getID() == id && book.isExist()== false){
				return book;
			}
		}
		return null;
	}



	/**
	 */
	public boolean searchnonBook(int id){
		Iterator<Book> iterator = booklist.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getID()==id && book.isExist()== false){
				return true;
			}
		}
		return false;
	}



	/**
	 * @uml.property  name="memberList"
	 * @uml.associationEnd  inverse="bookControl:MemberList"
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
	 * Setter of the property <tt>memberList</tt>
	 * @param memberList  The memberList to set.
	 * @uml.property  name="memberList"
	 */
	public void setMemberList(
			MemberList memberList) {
		this.memberList = memberList;
	}



	/**
	 * @uml.property  name="member"
	 * @uml.associationEnd  inverse="bookControl:Member"
	 */
	private Member member;


	/**
	 * Getter of the property <tt>member</tt>
	 * @return  Returns the member.
	 * @uml.property  name="member"
	 */
	public Member getMember() {
		return member;
	}


	/**
	 * Setter of the property <tt>member</tt>
	 * @param member  The member to set.
	 * @uml.property  name="member"
	 */
	public void setMember(Member member) {
		this.member = member;
	}



	/**
	 */
	public void showAllBook(){
		System.out.println("-----図書館の本一覧-----");
		for(Book book:booklist) {
			System.out.println("本のID:" + book.getID() +" 本の名前:" + book.getName()+ " 貸し出し:" + book.isExist());
		}
		System.out.println("----------------------");
	}
}

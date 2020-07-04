import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;


public class MemberList {
	public static void main(String[] args) {
		MemberList mlist = new MemberList();
		bookControl = new BookControl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		bookControl.addBook(1001,"国語");
		bookControl.addBook(1002,"数学");
		bookControl.addBook(1003,"物理");
		bookControl.addBook(1004,"化学");
		bookControl.addBook(1005,"生物");
		bookControl.addBook(1006,"世界史");
		bookControl.addBook(1007,"日本史");
		bookControl.addBook(1008,"英語");
		bookControl.addBook(1009,"広辞苑");
		bookControl.addBook(1010,"少年ジャンプ");
		bookControl.addBook(1011,"はらぺこあおむし");
		bookControl.showAllBook();
		
		while(true){
			String input_text = scanner.nextLine();
			String[] str = input_text.split(" ", 0);
			int strlength = str.length;
			switch(str[0]){
			case "addbook":
				if(strlength < 3){System.err.println("入力誤りである");break;}
				bookControl.addBook(Integer.parseInt(str[1]),str[2]);
				break;
			case "deletebook":
				if(strlength < 2){System.err.println("入力誤りである");break;}
				bookControl.deleteBook(Integer.parseInt(str[1]));
				break;
			case "searchbook":
				if(strlength < 2){System.err.println("入力誤りである");break;}
				System.out.println(bookControl.searchBook(Integer.parseInt(str[1])));
				break;
			case "subscribe":
				if(strlength < 4){System.err.println("入力誤りである");break;}
				Member mem;
				mem = new Member(Integer.parseInt(str[1]),str[2],str[3]);
				mlist.addMember(mem);
				break;
			case "retire":
				if(strlength < 2){System.err.println("入力誤りである");break;}
				mlist.retire(Integer.parseInt(str[1]));
				break;
			case "change":
				if(strlength < 3){System.err.println("入力誤りである");break;}
				mlist.changeAddress(Integer.parseInt(str[1]),str[2]);
				
				break;
			case "borrowbook":
				if(strlength < 5){System.err.println("入力誤りである");break;}
				cal = Calendar.getInstance();
				try{
				cal.setTime(sdf.parse(str[3] + " " + str[4]));
				mlist.getMember(Integer.parseInt(str[1])).borrowbook(Integer.parseInt(str[2]),cal);
				}catch (ParseException e){
		            
		        }
				break;
			case "returnbook":
				if(strlength < 5){System.err.println("入力誤りである");break;}
				cal = Calendar.getInstance();
				try{
				cal.setTime(sdf.parse(str[3] + " " + str[4]));
				mlist.getMember(Integer.parseInt(str[1])).returnbook(Integer.parseInt(str[2]),cal);
				}catch (ParseException e){
		            
		        }
				break;
			case "showp":
				mlist.showMemberlist();
				break;
			case "showl":
				bookControl.showAllBook();
				break;
			case "showholding":
				if(strlength < 2){System.err.println("入力誤りである");break;}
				mlist.getMember(Integer.parseInt(str[1])).showAllHoldBook();
				break;
			case "quit":
				return;
			default :
				System.err.println("入力誤りである");
				break;
			}
		}
		
	}

	/** 
	 * @uml.property name="membergroup"
	 * @uml.associationEnd multiplicity="(0 -1)" aggregation="shared" inverse="memberList:Member"
	 */
	private Collection<Member> membergroup;

	/**
	 */
	public void addMember(Member member){
		Iterator<Member> iterator = this.membergroup.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getID() == member.getID()){
				System.err.println("そのIDは既に使用されています");
				return;
			}
		}
		this.membergroup.add(member);
	}



	/**
	 */
	public MemberList(){
		membergroup = new ArrayList<Member>();
	}


	/**
	 * Getter of the property <tt>membergroup</tt>
	 * @return  Returns the member.
	 * @uml.property  name="membergroup"
	 */
	public Collection<Member> getMembergroup() {
		return membergroup;
	}


	/**
	 * Setter of the property <tt>membergroup</tt>
	 * @param membergroup  The member to set.
	 * @uml.property  name="membergroup"
	 */
	public void setMembergroup(Collection<Member> membergroup) {
		this.membergroup = membergroup;
	}






	public void retire(int id){
		Iterator<Member> iterator = this.membergroup.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			if(m.getID() == id){
				if(m.isbookhold() != true){
					System.out.println(" ->ID:" + id + " が会員削除をしました");
					iterator.remove();
					return;
				}else{
					System.err.println("借りている本があります");
				}

			}
		}
		System.err.println("退会に失敗しました。");
	}




	/**
	 */
	public void changeAddress(int id,String newaddress){
		Iterator<Member> iterator = this.membergroup.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			if(m.getID() == id ){
				m.changeState(newaddress);
				System.out.println("住所が " + newaddress +" に変更されました");
				return;
			}
		}
		System.err.println("入力情報が異なります");
	}




	/**
	 */
	public Member getMember(int id){
		Iterator<Member> iterator = this.membergroup.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			if(m.getID() == id ){
				return m;
			}
		}
		System.err.println("そのIDは使用できません");
		return null;
	}




	/**
	 */
	public boolean isexistID(int id){
		Iterator<Member> iterator = this.membergroup.iterator();
		while(iterator.hasNext()) {
			Member m = iterator.next();
			if(m.getID() == id ){
				return true;
			}
		}
		System.err.println("そのIDは使用できません");
		return false;
	}




	/**
	 */
	public void showMemberlist(){
		Iterator<Member> iterator = this.membergroup.iterator();
		System.out.println("-------メンバー一覧---------");
		while(iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println("ID:" +m.getID() + " Name:" + m.getName() + " Address: " + m.getAddress());
		}
		System.out.println("-------------------------");
		System.out.println("");
	}

	/**
	 * @uml.property  name="bookControl"
	 * @uml.associationEnd  aggregation="shared" inverse="memberList:BookControl"
	 */
	private static BookControl bookControl;

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
	public void setBookControl(BookControl bookControl) {
		this.bookControl = bookControl;
	}
}

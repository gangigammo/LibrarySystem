

public class StateFactory {

	/**
	 * @uml.property  name="member"
	 * @uml.associationEnd  inverse="stateFactory:Member"
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
	public State getState(String address){
		if(address.indexOf("大岡山") == -1){
			return new OtherState();
		}else{
			return new OokayamaState();
		}
	}

}

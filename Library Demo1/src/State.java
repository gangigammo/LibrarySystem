

public abstract class State {

	/**
	 * @uml.property  name="member"
	 * @uml.associationEnd  inverse="state:Member"
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
	 * @return  Returns the limitweek.
	 * @uml.property  name="limitweek"
	 */
	public abstract int getLimitweek();

	/**
	 * Setter of the property <tt>limitweek</tt>
	 * @param limitweek  The limitweek to set.
	 * @uml.property  name="limitweek"
	 */
	public abstract void setLimitweek(int limitweek);

	/**
	 * @return  Returns the booklimit.
	 * @uml.property  name="booklimit"
	 */
	public abstract int getBooklimit();

	/**
	 * Setter of the property <tt>booklimit</tt>
	 * @param booklimit  The booklimit to set.
	 * @uml.property  name="booklimit"
	 */
	public abstract void setBooklimit(int booklimit);

	
}

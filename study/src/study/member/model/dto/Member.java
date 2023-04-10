package study.member.model.dto;

public class Member {

	private int memberNo; 
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String enrollDate;
	private String unresgisterFlag; //탈퇴여부
	private String location;
	
	
	public Member() {}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberGender() {
		return memberGender;
	}


	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getUnresgisterFlag() {
		return unresgisterFlag;
	}


	public void setUnresgisterFlag(String unresgisterFlag) {
		this.unresgisterFlag = unresgisterFlag;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


}

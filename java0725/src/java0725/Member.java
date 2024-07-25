package java0725;

public class Member {
	String id;
	
	Member(String id){
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		
//		if(obj instanceof Member) {
//			Member member = (Member)obj;
//			if(this.id.equals(member.id)) {
//				return true;
//			}			
//		}
//		return false;
		return obj instanceof Member?this.id.equals(((Member)obj).id)?true:false:false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	
	
}

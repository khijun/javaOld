package model;

public class Ex1 {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		dao.selectAllMember().stream().map(MemberDTO::getName).forEach(System.out::println);
		MemberDTO adminDto = new MemberDTO("admin", "12345","");
		System.out.println(dao.getMemberInfo(adminDto).getName());
		MemberDTO dto =	 new MemberDTO("testsql", "testsql","sql테스트");
		System.out.println(dao.getMemberInfo(dto).getName());
//		dao.joinMember(dto);
		MemberDTO newDto = new MemberDTO("testupdate", "testupdate", "update테스트");
		dao.updateMember(dto, newDto);
	}
}

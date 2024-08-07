package drive;

import dept.DeptDAO;
import dept.DeptDTO;

public class TestMain {
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		int deptno = dao.searchDeptno("영업");
		System.out.println(deptno);
		
		DeptDTO dto = dao.searchLoc("BOSTON");
		System.out.println(dto);
	}
}
